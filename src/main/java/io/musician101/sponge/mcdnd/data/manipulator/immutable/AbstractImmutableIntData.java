package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;

import javax.annotation.Nonnull;

public abstract class AbstractImmutableIntData<I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>>
    extends AbstractImmutableSingleData<Integer, I, M>
{
    private final int defaultValue;
    private final ImmutableValue<Integer> immutableValue;

    protected AbstractImmutableIntData(Integer value, Key<Value<Integer>> usedKey)
    {
        super(value, usedKey);
        this.defaultValue = value;
        this.immutableValue = Sponge.getRegistry().getValueFactory().createValue(usedKey, defaultValue, value).asImmutable();
    }

    @Nonnull
    @Override
    protected ImmutableValue<Integer> getValueGetter()
    {
        return this.immutableValue;
    }

    @Override
    public int compareTo(@SuppressWarnings("NullableProblems") @Nonnull I o)
    {
        //noinspection OptionalGetWithoutIsPresent
        return Integer.compare(o.get(this.usedKey).get(), this.getValue());//NOSONAR
    }
}
