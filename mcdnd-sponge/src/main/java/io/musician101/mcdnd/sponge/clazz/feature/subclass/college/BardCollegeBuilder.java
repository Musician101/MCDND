package io.musician101.mcdnd.sponge.clazz.feature.subclass.college;

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

public class BardCollegeBuilder extends SubClassFeatureBuilder<BardCollege, BardCollegeBuilder> {

    @Override
    public BardCollegeBuilder addLineToDescription(String line) {
        description.add(line);
        return this;
    }

    @Override
    public <E> BardCollegeBuilder addProperty(Key<? extends BaseValue<E>> key, E value) {
        this.properties.set(key, value);
        return this;
    }

    @Override
    public BardCollegeBuilder addToMap(int key, List<Feature> value) {
        map.put(key, value);
        return this;
    }

    @Override
    public BardCollege build() {
        return new BardCollege(name, map, properties, description);
    }

    @Override
    public BardCollegeBuilder description(List<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public BardCollegeBuilder description(String... description) {
        return description(Arrays.asList(description));
    }

    @Nonnull
    @Override
    public BardCollegeBuilder from(@Nonnull BardCollege value) {
        return super.from(value).map(value.getMap()).levelRequirement(value.getLevelRequirement());
    }

    @Override
    public BardCollegeBuilder levelRequirement(int level) {
        this.level = level;
        return this;
    }

    @Override
    public BardCollegeBuilder map(Map<Integer, List<Feature>> map) {
        this.map = map;
        return this;
    }

    @Override
    public BardCollegeBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BardCollegeBuilder properties(DataContainer properties) {
        this.properties = properties;
        return this;
    }

    @Nonnull
    @Override
    public BardCollegeBuilder reset() {
        description = new ArrayList<>();
        level = 1;
        map = new HashMap<>();
        name = null;
        properties = DataContainer.createNew();
        return this;
    }
}
