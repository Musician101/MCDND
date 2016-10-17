package io.musician101.mcdnd.sponge.data.value.immutable;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import io.musician101.mcdnd.sponge.data.value.mutable.ListMapValue;
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

public class ImmutableListMapValue<E, V> implements ImmutableMapValue<List<E>, V>
{
    private final Key<? extends BaseValue<Map<List<E>, V>>> key;
    private final Map<List<E>, V> defaultValue;
    private Map<List<E>, V> actualValue;

    public ImmutableListMapValue(Key<? extends BaseValue<Map<List<E>, V>>> key)
    {
        this(key, new HashMap<>());
    }

    public ImmutableListMapValue(Key<? extends BaseValue<Map<List<E>, V>>> key, Map<List<E>, V> actualValue)
    {
        this(key, ImmutableMap.of(), actualValue);
    }

    public ImmutableListMapValue(Key<? extends BaseValue<Map<List<E>, V>>> key, Map<List<E>, V> defaultMap, Map<List<E>, V> actualValue)
    {
        this.key = key;
        this.defaultValue = defaultMap;
        this.actualValue = actualValue;
    }

    @Nonnull
    @Override
    public Map<List<E>, V> get()
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
    public Map<List<E>, V> getDefault()
    {
        return defaultValue;
    }

    @Nonnull
    @Override
    public Optional<Map<List<E>, V>> getDirect()
    {
        return Optional.ofNullable(actualValue);
    }

    @Nonnull
    @Override
    public Key<? extends BaseValue<Map<List<E>, V>>> getKey()
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

        ImmutableListMapValue other = (ImmutableListMapValue) obj;
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
    public ImmutableListMapValue<E, V> with(@Nonnull List<E> key, @Nonnull V value)
    {
        return new ImmutableListMapValue<>(this.key, ImmutableMap.<List<E>, V>builder().putAll(actualValue).put(checkNotNull(key), checkNotNull(value)).build());
    }

    @Nonnull
    @Override
    public ImmutableListMapValue<E, V> with(@Nonnull Map<List<E>, V> map)
    {
        return new ImmutableListMapValue<>(key, defaultValue, map);
    }

    @Nonnull
    @Override
    public ImmutableListMapValue<E, V> withAll(@Nonnull Map<List<E>, V> map)
    {
        return new ImmutableListMapValue<>(key, ImmutableMap.<List<E>, V>builder().putAll(actualValue).putAll(map).build());
    }

    @Nonnull
    @Override
    public ImmutableListMapValue<E, V> without(@Nonnull List<E> key)
    {
        final ImmutableMap.Builder<List<E>, V> builder = ImmutableMap.builder();
        actualValue.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(key))
                .forEach(entry -> builder.put(entry.getKey(), entry.getValue()));
        return new ImmutableListMapValue<>(getKey(), builder.build());
    }

    @Nonnull
    @Override
    public ImmutableMapValue<List<E>, V> withoutAll(@Nonnull Iterable<List<E>> keys)
    {
        final ImmutableMap.Builder<List<E>, V> builder = ImmutableMap.builder();
        actualValue.entrySet().stream()
                .filter(entry -> !Iterables.contains(keys, entrySet()))
                .forEach(entry -> builder.put(entry.getKey(), entry.getValue()));
        return new ImmutableListMapValue<>(getKey(), builder.build());
    }

    @Nonnull
    @Override
    public ImmutableListMapValue<E, V> withoutAll(@Nonnull Predicate<Entry<List<E>, V>> predicate)
    {
        final ImmutableMap.Builder<List<E>, V> builder = ImmutableMap.builder();
        actualValue.entrySet().stream()
                .filter(entry -> checkNotNull(predicate.test(entry)))
                .forEach(entry -> builder.put(entry.getKey(), entry.getValue()));
        return new ImmutableListMapValue<>(getKey(), builder.build());
    }

    @Override
    public boolean containsKey(@Nonnull List<E> key)
    {
        return actualValue.containsKey(checkNotNull(key));
    }

    @Override
    public boolean containsValue(@Nonnull V value)
    {
        return actualValue.containsValue(checkNotNull(value));
    }

    @Nonnull
    @Override
    public ImmutableSet<List<E>> keySet()
    {
        return ImmutableSet.copyOf(actualValue.keySet());
    }

    @Nonnull
    @Override
    public ImmutableSet<Entry<List<E>, V>> entrySet()
    {
        return ImmutableSet.copyOf(actualValue.entrySet());
    }

    @Nonnull
    @Override
    public ImmutableCollection<V> values()
    {
        return ImmutableSet.copyOf(actualValue.values());
    }

    @Nonnull
    @Override
    public ImmutableMapValue<List<E>, V> transform(@Nonnull Function<Map<List<E>, V>, Map<List<E>, V>> function)
    {
        final Map<List<E>, V> value = checkNotNull(function).apply(get());
        return new ImmutableListMapValue<>(getKey(), getDefault(), value);
    }

    @Nonnull
    @Override
    public MapValue<List<E>, V> asMutable()
    {
        return new ListMapValue<>(getKey(), getDefault(), get());
    }
}
