package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AlignmentData;
import io.musician101.mcdnd.sponge.data.type.Alignment;
import io.musician101.mcdnd.sponge.data.type.Alignments;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleCatalogData;

public class ImmutableAlignmentData extends AbstractImmutableSingleCatalogData<Alignment, ImmutableAlignmentData, AlignmentData> {

    public ImmutableAlignmentData(Alignment value) {
        super(value, Alignments.NEUTRAL, MCDNDKeys.ALIGNMENT);
    }

    @Nonnull
    @Override
    public AlignmentData asMutable() {
        return new AlignmentData(getValue());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
