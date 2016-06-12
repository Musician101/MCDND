package io.musician101.sponge.mcdnd.data.manipulator.builder.common;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;

public abstract class SingleValueDataManipulatorBuilder<V, M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>> implements DataManipulatorBuilder<M, I>
{
    protected V value;

    public SingleValueDataManipulatorBuilder<V, M, I> setValue(V value)
    {
        this.value = value;
        return this;
    }
}
