package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.FeatureListData;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableListData;

import javax.annotation.Nonnull;
import java.util.List;

public class ImmutableFeatureListData extends AbstractImmutableListData<Feature, ImmutableFeatureListData, FeatureListData>
{
    public ImmutableFeatureListData(List<Feature> value)
    {
        super(value, MCDNDKeys.FEATURES);
    }

    @Nonnull
    @Override
    public FeatureListData asMutable()
    {
        return new FeatureListData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
