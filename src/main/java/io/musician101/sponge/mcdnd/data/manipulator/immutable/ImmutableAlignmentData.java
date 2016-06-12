package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AlignmentData;
import io.musician101.sponge.mcdnd.data.type.Alignment;
import io.musician101.sponge.mcdnd.data.type.Alignments;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleCatalogData;

import javax.annotation.Nonnull;

public class ImmutableAlignmentData extends AbstractImmutableSingleCatalogData<Alignment, ImmutableAlignmentData, AlignmentData>
{
    public ImmutableAlignmentData(Alignment value)
    {
        super(value, Alignments.NEUTRAL, MCDNDKeys.ALIGNMENT);
    }

    @Nonnull
    @Override
    public AlignmentData asMutable()
    {
        return new AlignmentData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
