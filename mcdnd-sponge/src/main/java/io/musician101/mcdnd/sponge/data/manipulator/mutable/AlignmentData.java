package io.musician101.mcdnd.sponge.data.manipulator.mutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableAlignmentData;
import io.musician101.mcdnd.sponge.data.type.Alignment;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleCatalogData;
import org.spongepowered.api.data.merge.MergeFunction;

public class AlignmentData extends AbstractSingleCatalogData<Alignment, AlignmentData, ImmutableAlignmentData> {

    public AlignmentData(Alignment value) {
        super(value, MCDNDKeys.ALIGNMENT);
    }

    @Nonnull
    @Override
    public ImmutableAlignmentData asImmutable() {
        return new ImmutableAlignmentData(getValue());
    }

    @Nonnull
    @Override
    public AlignmentData copy() {
        return new AlignmentData(getValue());
    }

    @Nonnull
    @Override
    public Optional<AlignmentData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap) {
        Optional<Alignment> alignmentOptional = overlap.merge(copy(), dataHolder).get(usedKey);
        if (alignmentOptional.isPresent()) {
            return Optional.of(new AlignmentData(alignmentOptional.get()));
        }

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<AlignmentData> from(@Nonnull DataContainer container) {
        Optional<Alignment> alignmentOptional = container.getObject(usedKey.getQuery(), Alignment.class);
        if (alignmentOptional.isPresent()) {
            return Optional.of(new AlignmentData(alignmentOptional.get()));
        }

        return Optional.empty();
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
