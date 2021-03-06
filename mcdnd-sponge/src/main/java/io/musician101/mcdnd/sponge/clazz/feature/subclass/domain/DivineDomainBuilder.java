package io.musician101.mcdnd.sponge.clazz.feature.subclass.domain;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.SubClassFeatureBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

public class DivineDomainBuilder extends SubClassFeatureBuilder<DivineDomain, DivineDomainBuilder> {

    @Override
    public DivineDomainBuilder addLineToDescription(String line) {
        description.add(line);
        return this;
    }

    @Override
    public <E> DivineDomainBuilder addProperty(Key<? extends BaseValue<E>> key, E value) {
        properties.set(key, value);
        return this;
    }

    @Override
    public DivineDomainBuilder addToMap(int key, List<Feature> value) {
        map.put(key, value);
        return this;
    }

    @Override
    public DivineDomain build() {
        return new DivineDomain(name, map, properties, description);
    }

    @Override
    public DivineDomainBuilder description(List<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public DivineDomainBuilder description(String... description) {
        return description(Arrays.asList(description));
    }

    @Nonnull
    @Override
    public DivineDomainBuilder from(@Nonnull DivineDomain value) {
        return super.from(value).map(value.getMap()).levelRequirement(value.getLevelRequirement());
    }

    @Override
    public DivineDomainBuilder levelRequirement(int level) {
        this.level = level;
        return this;
    }

    @Override
    public DivineDomainBuilder map(Map<Integer, List<Feature>> map) {
        this.map = map;
        return this;
    }

    @Override
    public DivineDomainBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public DivineDomainBuilder properties(DataContainer properties) {
        this.properties = properties;
        return this;
    }

    @Nonnull
    @Override
    public DivineDomainBuilder reset() {
        description = new ArrayList<>();
        level = 1;
        map = new HashMap<>();
        name = null;
        properties = DataContainer.createNew();
        return this;
    }
}
