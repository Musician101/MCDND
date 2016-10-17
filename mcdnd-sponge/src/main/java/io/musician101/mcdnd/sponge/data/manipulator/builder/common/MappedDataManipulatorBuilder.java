package io.musician101.mcdnd.sponge.data.manipulator.builder.common;

import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;

import javax.annotation.Nonnull;
import java.util.Map;

public abstract class MappedDataManipulatorBuilder<K, V, M extends MappedData<K, V, M, I>, I extends ImmutableMappedData<K, V, I, M>> extends SingleValueDataManipulatorBuilder<Map<K, V>, M, I>
{
    @Nonnull
    @Override
    public MappedDataManipulatorBuilder<K, V, M, I> reset()
    {
        value = null;
        return this;
    }

    @Nonnull
    @Override
    public MappedDataManipulatorBuilder<K, V, M, I> from(@Nonnull M value)
    {
        this.value = value.asMap();
        return this;
    }
}
