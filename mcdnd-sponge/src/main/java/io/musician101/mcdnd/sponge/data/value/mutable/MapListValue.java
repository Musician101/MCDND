package io.musician101.mcdnd.sponge.data.value.mutable;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.musician101.mcdnd.sponge.data.value.immutable.ImmutableMapListValue;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.google.common.base.Preconditions.checkNotNull;

public class MapListValue<K, E> implements MapValue<K, List<E>>
{
    private final Key<? extends BaseValue<Map<K, List<E>>>> key;
    private final Map<K, List<E>> defaultValue;
    private Map<K, List<E>> actualValue;

    public MapListValue(Key<? extends BaseValue<Map<K, List<E>>>> key)
    {
        this(key, new HashMap<>());
    }

    public MapListValue(Key<? extends BaseValue<Map<K, List<E>>>> key, Map<K, List<E>> actualValue)
    {
        this(key, ImmutableMap.of(), actualValue);
    }

    public MapListValue(Key<? extends BaseValue<Map<K, List<E>>>> key, Map<K, List<E>> defaultMap, Map<K, List<E>> actualValue)
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

        MapListValue other = (MapListValue) obj;
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
    public MapValue<K, List<E>> put(@Nonnull K key, @Nonnull List<E> value)
    {
        actualValue.put(checkNotNull(key), checkNotNull(value));
        return this;
    }

    @Nonnull
    @Override
    public MapValue<K, List<E>> putAll(@Nonnull Map<K, List<E>> map)
    {
        actualValue.putAll(checkNotNull(map));
        return this;
    }

    @Nonnull
    @Override
    public MapValue<K, List<E>> remove(@Nonnull K key)
    {
        actualValue.remove(checkNotNull(key));
        return this;
    }

    @Nonnull
    @Override
    public MapValue<K, List<E>> removeAll(@Nonnull Iterable<K> keys)
    {
        for (K key : keys)//NOSONAR
            actualValue.remove(checkNotNull(key));

        return this;
    }

    @Nonnull
    @Override
    public MapValue<K, List<E>> removeAll(@Nonnull Predicate<Entry<K, List<E>>> predicate)
    {
        for (Iterator<Entry<K, List<E>>> iterator = actualValue.entrySet().iterator(); iterator.hasNext(); )
        {
            final Entry<K, List<E>> entry = iterator.next();
            if (!checkNotNull(predicate).test(entry))
                iterator.remove();
        }

        return this;
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
    public Value<Map<K, List<E>>> set(@Nonnull Map<K, List<E>> value)
    {
        this.actualValue = value;
        return this;
    }

    @Nonnull
    @Override
    public MapListValue<K, E> transform(@Nonnull Function<Map<K, List<E>>, Map<K, List<E>>> function)
    {
        this.actualValue = function.apply(actualValue);
        return this;
    }

    @Nonnull
    @Override
    public ImmutableMapListValue<K, E> asImmutable()
    {
        return new ImmutableMapListValue<>(key, defaultValue, actualValue);
    }
}
