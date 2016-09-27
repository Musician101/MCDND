package io.musician101.sponge.mcdnd.data.manipulator.mutable;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableFeatureListData;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractListData;
import org.spongepowered.api.data.merge.MergeFunction;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class FeatureListData extends AbstractListData<Feature, FeatureListData, ImmutableFeatureListData>
{
    public FeatureListData(List<Feature> value)
    {
        super(value, MCDNDKeys.FEATURES);
    }

    @Nonnull
    @Override
    public Optional<FeatureListData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction mergeFunction)
    {
        Optional<List<Feature>> optional = mergeFunction.merge(this, dataHolder).get(usedKey);
        if (optional.isPresent())
            return Optional.of(new FeatureListData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<FeatureListData> from(@Nonnull DataContainer dataContainer)
    {
        Optional<List<Feature>> optional = dataContainer.getObjectList(usedKey.getQuery(), Feature.class);
        if (optional.isPresent())
            return Optional.of(new FeatureListData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public FeatureListData copy()
    {
        return new FeatureListData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableFeatureListData asImmutable()
    {
        return new ImmutableFeatureListData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
