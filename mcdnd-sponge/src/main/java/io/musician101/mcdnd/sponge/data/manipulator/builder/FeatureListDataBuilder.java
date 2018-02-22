package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.ListDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableFeatureListData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.FeatureListData;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

public class FeatureListDataBuilder extends ListDataManipulatorBuilder<Feature, FeatureListData, ImmutableFeatureListData> {

    @Nonnull
    @Override
    public Optional<FeatureListData> build(@Nonnull DataView container) {
        Optional<List<Feature>> optional = container.getObjectList(MCDNDKeys.ARMOR_PROFICIENCIES.getQuery(), Feature.class);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public FeatureListData create() {
        return new FeatureListData(value);
    }

    @Nonnull
    @Override
    public Optional<FeatureListData> createFrom(@Nonnull DataHolder dataHolder) {
        Optional<List<Feature>> optional = dataHolder.get(MCDNDKeys.FEATURES);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public FeatureListDataBuilder from(@Nonnull FeatureListData value) {
        this.value = value.asList();
        return this;
    }

    @Nonnull
    @Override
    public FeatureListDataBuilder reset() {
        value = null;
        return this;
    }
}
