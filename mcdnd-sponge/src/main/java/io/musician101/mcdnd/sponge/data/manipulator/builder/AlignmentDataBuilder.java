package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.manipulator.builder.common.SingleValueDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableAlignmentData;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AlignmentData;
import io.musician101.mcdnd.sponge.data.type.Alignment;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Optional;

public class AlignmentDataBuilder extends SingleValueDataManipulatorBuilder<Alignment, AlignmentData, ImmutableAlignmentData>
{
    @Nonnull
    @Override
    public AlignmentData create()
    {
        return new AlignmentData(value);
    }

    @Nonnull
    @Override
    public Optional<AlignmentData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<Alignment> alignment = dataHolder.get(MCDNDKeys.ALIGNMENT);//NOSONAR
        if (!alignment.isPresent())
            return Optional.empty();

        this.value = alignment.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<AlignmentData> build(@Nonnull DataView container)
    {
        Optional<Alignment> alignment = container.getObject(MCDNDKeys.SAVING_THROW_PROFICIENCIES.getQuery(), Alignment.class);//NOSONAR
        if (!alignment.isPresent())
            return Optional.empty();

        this.value = alignment.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public AlignmentDataBuilder reset()
    {
        value = null;
        return this;
    }

    @Nonnull
    @Override
    public AlignmentDataBuilder from(@Nonnull AlignmentData value)
    {
        this.value = value.type().get();
        return this;
    }
}
