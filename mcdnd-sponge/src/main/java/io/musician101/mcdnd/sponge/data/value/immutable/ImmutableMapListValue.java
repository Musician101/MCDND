package io.musician101.mcdnd.sponge.data.value.immutable;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import io.musician101.mcdnd.sponge.data.value.mutable.MapListValue;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;
import org.spongepowered.api.data.value.mutable.MapValue;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.google.common.base.Preconditions.checkNotNull;

public class ImmutableMapListValue<K, E> implements ImmutableMapValue<K, List<E>>
{
    private final Key<? extends BaseValue<Map<K, List<E>>>> key;
    private final Map<K, List<E>> defaultValue;
    private Map<K, List<E>> actualValue;

    public ImmutableMapListValue(Key<? extends BaseValue<Map<K, List<E>>>> key)
    {
        this(key, new HashMap<>());
    }

    public ImmutableMapListValue(Key<? extends BaseValue<Map<K, List<E>>>> key, Map<K, List<E>> actualValue)
    {
        this(key, ImmutableMap.of(), actualValue);
    }

    public ImmutableMapListValue(Key<? extends BaseValue<Map<K, List<E>>>> key, Map<K, List<E>> defaultMap, Map<K, List<E>> actualValue)
    {
        this.key = key;
        this.defaultValue = defaultMap;
        this.actualValue = actualValue;
    }

    @Nonnull
    @Override
    public Map<K, List<E>> get()
    {
        return actualValue == null ? defaultValue : actualValue;
    }

    @Override
    public boolean exists()
    {
        return actualValue != null;
    }

    @Nonnull
    @Override
    public Map<K, List<E>> getDefault()
    {
        return defaultValue;
    }

    @Nonnull
    @Override
    public Optional<Map<K, List<E>>> getDirect()
    {
        return Optional.ofNullable(actualValue);
    }

    @Nonnull
    @Override
    public Key<? extends BaseValue<Map<K, List<E>>>> getKey()
    {
        return key;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(key, defaultValue, actualValue);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        ImmutableMapListValue other = (ImmutableMapListValue) obj;
        return Objects.equal(key, other.key)
                && Objects.equal(defaultValue, other.defaultValue)
                && Objects.equal(actualValue, other.actualValue);
    }

    @Override
    public int size()
    {
        return actualValue.size();
    }

    @Nonnull
    @Override
    public ImmutableMapListValue<K, E> with(@Nonnull K key, @Nonnull List<E> value)
    {
        return new ImmutableMapListValue<>(this.key, ImmutableMap.<K, List<E>>builder().putAll(actualValue).put(checkNotNull(key), checkNotNull(value)).build());
    }

    @Nonnull
    @Override
    public ImmutableMapListValue<K, E> with(@Nonnull Map<K, List<E>> map)
    {
        return new ImmutableMapListValue<>(key, defaultValue, map);
    }

    @Nonnull
    @Override
    public ImmutableMapListValue<K, E> withAll(@Nonnull Map<K, List<E>> map)
    {
        return new ImmutableMapListValue<>(key, ImmutableMap.<K, List<E>>builder().putAll(actualValue).putAll(map).build());
    }

    @Nonnull
    @Override
    public ImmutableMapListValue<K, E> without(@Nonnull K key)
    {
        final ImmutableMap.Builder<K, List<E>> builder = ImmutableMap.builder();
        actualValue.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(key))
                .forEach(entry -> builder.put(entry.getKey(), entry.getValue()));
        return new ImmutableMapListValue<>(getKey(), builder.build());
    }

    @Nonnull
    @Override
    public ImmutableMapValue<K, List<E>> withoutAll(@Nonnull Iterable<K> keys)
    {
        final ImmutableMap.Builder<K, List<E>> builder = ImmutableMap.builder();
        actualValue.entrySet().stream()
                .filter(entry -> !Iterables.contains(keys, entrySet()))
                .forEach(entry -> builder.put(entry.getKey(), entry.getValue()));
        return new ImmutableMapListValue<>(getKey(), builder.build());
    }

    @Nonnull
    @Override
    public ImmutableMapListValue<K, E> withoutAll(@Nonnull Predicate<Entry<K, List<E>>> predicate)
    {
        final ImmutableMap.Builder<K, List<E>> builder = ImmutableMap.builder();
        actualValue.entrySet().stream()
                .filter(entry -> checkNotNull(predicate.test(entry)))
                .forEach(entry -> builder.put(entry.getKey(), entry.getValue()));
        return new ImmutableMapListValue<>(getKey(), builder.build());
    }

    @Override
    public boolean containsKey(@Nonnull K key)
    {
        return actualValue.containsKey(checkNotNull(key));
    }

    @Override
    public boolean containsValue(@Nonnull List<E> value)
    {
        return actualValue.containsValue(checkNotNull(value));
    }

    @Nonnull
    @Override
    public ImmutableSet<K> keySet()
    {
        return ImmutableSet.copyOf(actualValue.keySet());
    }

    @Nonnull
    @Override
    public ImmutableSet<Entry<K, List<E>>> entrySet()
    {
        return ImmutableSet.copyOf(actualValue.entrySet());
    }

    @Nonnull
    @Override
    public ImmutableCollection<List<E>> values()
    {
        return ImmutableSet.copyOf(actualValue.values());
    }

    @Nonnull
    @Override
    public ImmutableMapValue<K, List<E>> transform(@Nonnull Function<Map<K, List<E>>, Map<K, List<E>>> function)
    {
        final Map<K, List<E>> value = checkNotNull(function).apply(get());
        return new ImmutableMapListValue<>(getKey(), getDefault(), value);
    }

    @Nonnull
    @Override
    public MapValue<K, List<E>> asMutable()
    {
        return new MapListValue<>(getKey(), getDefault(), get());
    }
}
