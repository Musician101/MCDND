package io.musician101.mcdnd.sponge.data.manipulator.mutable;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableFeatureListData;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractListData;
import org.spongepowered.api.data.merge.MergeFunction;

public class FeatureListData extends AbstractListData<Feature, FeatureListData, ImmutableFeatureListData> {

    public FeatureListData(List<Feature> value) {
        super(value, MCDNDKeys.FEATURES);
    }

    @Nonnull
    @Override
    public ImmutableFeatureListData asImmutable() {
        return new ImmutableFeatureListData(getValue());
    }

    @Nonnull
    @Override
    public FeatureListData copy() {
        return new FeatureListData(getValue());
    }

    @Nonnull
    @Override
    public Optional<FeatureListData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction mergeFunction) {
        Optional<List<Feature>> optional = mergeFunction.merge(this, dataHolder).get(usedKey);
        if (optional.isPresent()) {
            return Optional.of(new FeatureListData(optional.get()));
        }

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<FeatureListData> from(@Nonnull DataContainer dataContainer) {
        Optional<List<Feature>> optional = dataContainer.getObjectList(usedKey.getQuery(), Feature.class);
        if (optional.isPresent()) {
            return Optional.of(new FeatureListData(optional.get()));
        }

        return Optional.empty();
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
