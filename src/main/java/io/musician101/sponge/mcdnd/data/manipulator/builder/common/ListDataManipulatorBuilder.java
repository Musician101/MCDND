package io.musician101.sponge.mcdnd.data.manipulator.builder.common;

import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.manipulator.mutable.ListData;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class ListDataManipulatorBuilder<V, M extends ListData<V, M, I>, I extends ImmutableListData<V, I, M>> extends SingleValueDataManipulatorBuilder<List<V>, M, I>
{
    @Nonnull
    @Override
    public ListDataManipulatorBuilder<V, M, I> reset()
    {
        value = null;
        return this;
    }

    @Nonnull
    @Override
    public ListDataManipulatorBuilder<V, M, I> from(@Nonnull M value)
    {
        this.value = value.asList();
        return this;
    }
}
