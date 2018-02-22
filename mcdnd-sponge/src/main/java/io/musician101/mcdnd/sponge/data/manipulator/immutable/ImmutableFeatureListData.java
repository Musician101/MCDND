package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.FeatureListData;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableListData;

public class ImmutableFeatureListData extends AbstractImmutableListData<Feature, ImmutableFeatureListData, FeatureListData> {

    public ImmutableFeatureListData(List<Feature> value) {
        super(value, MCDNDKeys.FEATURES);
    }

    @Nonnull
    @Override
    public FeatureListData asMutable() {
        return new FeatureListData(getValue());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
