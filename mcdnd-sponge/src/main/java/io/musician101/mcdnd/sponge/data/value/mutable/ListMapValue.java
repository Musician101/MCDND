package io.musician101.mcdnd.sponge.data.value.mutable;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.musician101.mcdnd.sponge.data.value.immutable.ImmutableListMapValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListMapValue<E, V> implements MapValue<List<E>, V> {

    private final Map<List<E>, V> defaultValue;
    private final Key<? extends BaseValue<Map<List<E>, V>>> key;
    private Map<List<E>, V> actualValue;

    public ListMapValue(Key<? extends BaseValue<Map<List<E>, V>>> key) {
        this(key, new HashMap<>());
    }

    public ListMapValue(Key<? extends BaseValue<Map<List<E>, V>>> key, Map<List<E>, V> actualValue) {
        this(key, ImmutableMap.of(), actualValue);
    }

    public ListMapValue(Key<? extends BaseValue<Map<List<E>, V>>> key, Map<List<E>, V> defaultMap, Map<List<E>, V> actualValue) {
        this.key = key;
        this.defaultValue = defaultMap;
        this.actualValue = actualValue;
    }

    @Nonnull
    @Override
    public ImmutableListMapValue<E, V> asImmutable() {
        return new ImmutableListMapValue<>(key, defaultValue, actualValue);
    }

    @Override
    public boolean containsKey(@Nonnull List<E> key) {
        return actualValue.containsKey(checkNotNull(key));
    }

    @Override
    public boolean containsValue(@Nonnull V value) {
        return actualValue.containsValue(checkNotNull(value));
    }

    @Nonnull
    @Override
    public ImmutableSet<Entry<List<E>, V>> entrySet() {
        return ImmutableSet.copyOf(actualValue.entrySet());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ListMapValue other = (ListMapValue) obj;
        return Objects.equal(key, other.key) && Objects.equal(defaultValue, other.defaultValue) && Objects.equal(actualValue, other.actualValue);
    }

    @Override
    public boolean exists() {
        return actualValue != null;
    }

    @Nonnull
    @Override
    public Map<List<E>, V> get() {
        return actualValue == null ? defaultValue : actualValue;
    }

    @Nonnull
    @Override
    public Map<List<E>, V> getDefault() {
        return defaultValue;
    }

    @Nonnull
    @Override
    public Optional<Map<List<E>, V>> getDirect() {
        return Optional.ofNullable(actualValue);
    }

    @Nonnull
    @Override
    public Key<? extends BaseValue<Map<List<E>, V>>> getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key, defaultValue, actualValue);
    }

    @Nonnull
    @Override
    public ImmutableSet<List<E>> keySet() {
        return ImmutableSet.copyOf(actualValue.keySet());
    }

    @Nonnull
    @Override
    public MapValue<List<E>, V> put(@Nonnull List<E> key, @Nonnull V value) {
        actualValue.put(checkNotNull(key), checkNotNull(value));
        return this;
    }

    @Nonnull
    @Override
    public MapValue<List<E>, V> putAll(@Nonnull Map<List<E>, V> map) {
        actualValue.putAll(checkNotNull(map));
        return this;
    }

    @Nonnull
    @Override
    public MapValue<List<E>, V> remove(@Nonnull List<E> key) {
        actualValue.remove(checkNotNull(key));
        return this;
    }

    @Nonnull
    @Override
    public MapValue<List<E>, V> removeAll(@Nonnull Iterable<List<E>> keys) {
        for (List<E> key : keys) {
            actualValue.remove(checkNotNull(key));
        }

        return this;
    }

    @Nonnull
    @Override
    public MapValue<List<E>, V> removeAll(@Nonnull Predicate<Entry<List<E>, V>> predicate) {
        for (Iterator<Entry<List<E>, V>> iterator = actualValue.entrySet().iterator(); iterator.hasNext(); ) {
            final Entry<List<E>, V> entry = iterator.next();
            if (!checkNotNull(predicate).test(entry)) {
                iterator.remove();
            }
        }

        return this;
    }

    @Nonnull
    @Override
    public Value<Map<List<E>, V>> set(@Nonnull Map<List<E>, V> value) {
        this.actualValue = value;
        return this;
    }

    @Override
    public int size() {
        return actualValue.size();
    }

    @Nonnull
    @Override
    public ListMapValue<E, V> transform(@Nonnull Function<Map<List<E>, V>, Map<List<E>, V>> function) {
        this.actualValue = function.apply(actualValue);
        return this;
    }

    @Nonnull
    @Override
    public ImmutableCollection<V> values() {
        return ImmutableSet.copyOf(actualValue.values());
    }
}
