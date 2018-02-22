package io.musician101.mcdnd.sponge.data.value.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import io.musician101.mcdnd.sponge.data.value.mutable.ListListValue;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;

import static com.google.common.base.Preconditions.checkNotNull;

public class ImmutableListListValue<E> implements ImmutableListValue<List<E>> {

    private final List<List<E>> defaultValue;
    private final Key<? extends BaseValue<List<List<E>>>> key;
    private List<List<E>> actualValue;

    public ImmutableListListValue(Key<? extends BaseValue<List<List<E>>>> key) {
        this(key, Collections.emptyList());
    }

    public ImmutableListListValue(Key<? extends BaseValue<List<List<E>>>> key, List<List<E>> actualValue) {
        this(key, ImmutableList.of(), actualValue);
    }

    public ImmutableListListValue(Key<? extends BaseValue<List<List<E>>>> key, List<List<E>> defaultMap, List<List<E>> actualValue) {
        this.key = key;
        this.defaultValue = defaultMap;
        this.actualValue = actualValue;
    }

    @Nonnull
    @Override
    public ListListValue<E> asMutable() {
        return new ListListValue<>(getKey(), actualValue, defaultValue);
    }

    @Override
    public boolean contains(@Nonnull List<E> value) {
        return actualValue.contains(value);
    }

    @Override
    public boolean containsAll(@Nonnull Iterable<List<E>> iterable) {
        for (List<E> list : iterable) {
            if (!Iterables.contains(actualValue, list)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean exists() {
        return actualValue != null;
    }

    @Nonnull
    @Override
    public List<E> get(int index) {
        return actualValue.get(index);
    }

    @Nonnull
    @Override
    public List<List<E>> get() {
        return actualValue;
    }

    @Nonnull
    @Override
    public List<List<E>> getAll() {
        return actualValue;
    }

    @Nonnull
    @Override
    public List<List<E>> getDefault() {
        return defaultValue;
    }

    @Nonnull
    @Override
    public Optional<List<List<E>>> getDirect() {
        return Optional.of(actualValue);
    }

    @Nonnull
    @Override
    public Key<? extends BaseValue<List<List<E>>>> getKey() {
        return key;
    }

    @Override
    public int indexOf(@Nonnull List<E> value) {
        return actualValue.indexOf(value);
    }

    @Override
    public boolean isEmpty() {
        return actualValue.isEmpty();
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> set(int index, @Nonnull List<E> value) {
        return with(index, value);
    }

    @Override
    public int size() {
        return actualValue.size();
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> transform(@Nonnull Function<List<List<E>>, List<List<E>>> function) {
        return new ImmutableListListValue<>(getKey(), ImmutableList.copyOf(checkNotNull(checkNotNull(function).apply(actualValue))));
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> with(@Nonnull List<List<E>> lists) {
        return new ImmutableListListValue<>(getKey(), ImmutableList.copyOf(lists));
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> with(int index, @Nonnull List<E> value) {
        final ImmutableList.Builder<List<E>> builder = ImmutableList.builder();
        for (final ListIterator<List<E>> iterator = actualValue.listIterator(); iterator.hasNext(); ) {
            if (iterator.nextIndex() - 1 == index) {
                builder.add(checkNotNull(value));
                iterator.next();
            }
            else {
                builder.add(iterator.next());
            }
        }

        return new ImmutableListListValue<>(getKey(), builder.build());
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> with(int index, @Nonnull Iterable<List<E>> iterable) {
        final ImmutableList.Builder<List<E>> builder = ImmutableList.builder();
        for (final ListIterator<List<E>> iterator = actualValue.listIterator(); iterator.hasNext(); ) {
            if (iterator.nextIndex() - 1 == index) {
                builder.addAll(iterable);
            }

            builder.add(iterator.next());
        }

        return new ImmutableListListValue<>(getKey(), builder.build());
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> withAll(@Nonnull Iterable<List<E>> iterable) {
        return new ImmutableListListValue<>(getKey(), ImmutableList.<List<E>>builder().addAll(actualValue).addAll(iterable).build());
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> withElement(@Nonnull List<E> value) {
        return new ImmutableListListValue<>(getKey(), ImmutableList.<List<E>>builder().addAll(actualValue).add(value).build());
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> without(@Nonnull List<E> value) {
        final ImmutableList.Builder<List<E>> builder = ImmutableList.builder();
        actualValue.stream().filter(list -> !list.equals(value)).forEach(builder::add);
        return new ImmutableListListValue<>(getKey(), ImmutableList.<List<E>>builder().addAll(actualValue).build());
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> without(int index) {
        final ImmutableList.Builder<List<E>> builder = ImmutableList.builder();
        for (final ListIterator<List<E>> iterator = actualValue.listIterator(); iterator.hasNext(); ) {
            if (iterator.nextIndex() - 1 != index) {
                builder.add(iterator.next());
            }
        }

        return new ImmutableListListValue<>(getKey(), builder.build());
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> withoutAll(@Nonnull Iterable<List<E>> iterable) {
        final ImmutableList.Builder<List<E>> builder = ImmutableList.builder();
        actualValue.stream().filter(list -> !Iterables.contains(iterable, list)).forEach(builder::add);
        return new ImmutableListListValue<>(getKey(), builder.build());
    }

    @Nonnull
    @Override
    public ImmutableListValue<List<E>> withoutAll(@Nonnull Predicate<List<E>> predicate) {
        final ImmutableList.Builder<List<E>> builder = ImmutableList.builder();
        actualValue.stream().filter(list -> checkNotNull(predicate).test(list)).forEach(builder::add);
        return new ImmutableListListValue<>(getKey(), builder.build());
    }
}
