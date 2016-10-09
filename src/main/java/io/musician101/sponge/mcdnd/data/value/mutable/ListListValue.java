package io.musician101.sponge.mcdnd.data.value.mutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import io.musician101.sponge.mcdnd.data.value.immutable.ImmutableListListValue;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.ListValue;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListListValue<E> implements ListValue<List<E>>
{
    private final Key<? extends BaseValue<List<List<E>>>> key;
    private final List<List<E>> defaultValue;
    private List<List<E>> actualValue;

    public ListListValue(Key<? extends BaseValue<List<List<E>>>> key)
    {
        this(key, Collections.emptyList());
    }

    public ListListValue(Key<? extends BaseValue<List<List<E>>>> key, List<List<E>> actualValue)
    {
        this(key, ImmutableList.of(), actualValue);
    }

    public ListListValue(Key<? extends BaseValue<List<List<E>>>> key, List<List<E>> defaultMap, List<List<E>> actualValue)
    {
        this.key = key;
        this.defaultValue = defaultMap;
        this.actualValue = actualValue;
    }

    @Nonnull
    @Override
    public List<E> get(int index)
    {
        return actualValue.get(index);
    }

    @Nonnull
    @Override
    public ListListValue<E> add(int index, @Nonnull List<E> value)
    {
        actualValue.add(index, value);
        return this;
    }

    @Nonnull
    @Override
    public ListListValue<E> add(int index, @Nonnull Iterable<List<E>> values)
    {
        int count = 0;
        for (Iterator<List<E>> iterator = values.iterator(); iterator.hasNext(); count++)//NOSONAR
            actualValue.add(index + count, checkNotNull(iterator.next()));

        return this;
    }

    @Nonnull
    @Override
    public List<List<E>> get()
    {
        return actualValue;
    }

    @Override
    public boolean exists()
    {
        return actualValue != null;
    }

    @Nonnull
    @Override
    public List<List<E>> getDefault()
    {
        return defaultValue;
    }

    @Nonnull
    @Override
    public Optional<List<List<E>>> getDirect()
    {
        return Optional.of(actualValue);
    }

    @Nonnull
    @Override
    public Key<? extends BaseValue<List<List<E>>>> getKey()
    {
        return key;
    }

    @Nonnull
    @Override
    public Iterator<List<E>> iterator()
    {
        return actualValue.iterator();
    }

    @Nonnull
    @Override
    public ListListValue<E> remove(int index)
    {
        actualValue.remove(index);
        return this;
    }

    @Nonnull
    @Override
    public ListListValue<E> set(int index, @Nonnull List<E> value)
    {
        actualValue.set(index, value);
        return this;
    }

    @Override
    public int indexOf(@Nonnull List<E> value)
    {
        return actualValue.indexOf(value);
    }

    @Nonnull
    @Override
    public ListListValue<E> set(@Nonnull List<List<E>> value)
    {
        actualValue = value;
        return this;
    }

    @Nonnull
    @Override
    public ListListValue<E> transform(@Nonnull Function<List<List<E>>, List<List<E>>> function)
    {
        actualValue = checkNotNull(function).apply(actualValue);
        return this;
    }

    @Override
    public int size()
    {
        return actualValue.size();
    }

    @Override
    public boolean isEmpty()
    {
        return actualValue.isEmpty();
    }

    @Nonnull
    @Override
    public ListListValue<E> add(@Nonnull List<E> value)
    {
        actualValue.add(value);
        return this;
    }

    @Nonnull
    @Override
    public ListListValue<E> addAll(@Nonnull Iterable<List<E>> iterable)
    {
        for (List<E> list : checkNotNull(iterable))
            actualValue.add(checkNotNull(list));

        return this;
    }

    @Nonnull
    @Override
    public ListListValue<E> remove(@Nonnull List<E> value)
    {
        actualValue.remove(value);
        return this;
    }

    @Nonnull
    @Override
    public ListListValue<E> removeAll(@Nonnull Iterable<List<E>> iterable)
    {
        for (List<E> list : iterable)
            //noinspection SuspiciousMethodCalls
            list.remove(checkNotNull(list));

        return this;
    }

    @Nonnull
    @Override
    public ListListValue<E> removeAll(@Nonnull Predicate<List<E>> predicate)
    {
        for (Iterator<List<E>> iterator = actualValue.iterator(); iterator.hasNext(); )
            if (checkNotNull(predicate).test(iterator.next()))
                iterator.remove();

        return this;
    }

    @Override
    public boolean contains(@Nonnull List<E> value)
    {
        return actualValue.contains(checkNotNull(value));
    }

    @Override
    public boolean containsAll(@Nonnull Collection<List<E>> collection)
    {
        return actualValue.containsAll(collection);
    }

    @Nonnull
    @Override
    public ListListValue<E> filter(@Nonnull Predicate<? super List<E>> predicate)
    {
        final List<List<E>> list = new ArrayList<>();
        list.addAll(actualValue.stream().filter(subList -> checkNotNull(predicate).test(subList)).collect(Collectors.toList()));//NOSONAR
        return new ListListValue<>(getKey(), list);
    }

    @Nonnull
    @Override
    public List<List<E>> getAll()
    {
        return Lists.newArrayList(actualValue);
    }

    @Nonnull
    @Override
    public ImmutableListListValue<E> asImmutable()
    {
        return new ImmutableListListValue<>(getKey(), ImmutableList.copyOf(actualValue));
    }
}
