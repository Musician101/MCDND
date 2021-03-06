package io.musician101.mcdnd.sponge.clazz.feature.subclass.druidcircle;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.SubClassFeatureBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

public class DruidCircleBuilder extends SubClassFeatureBuilder<DruidCircle, DruidCircleBuilder> {

    @Override
    public DruidCircleBuilder addLineToDescription(String line) {
        description.add(line);
        return this;
    }

    @Override
    public <V> DruidCircleBuilder addProperty(Key<? extends BaseValue<V>> key, V value) {
        properties.set(key, value);
        return this;
    }

    @Override
    public DruidCircleBuilder addToMap(int key, List<Feature> value) {
        map.put(key, value);
        return this;
    }

    @Override
    public DruidCircle build() {
        return new DruidCircle(name, map, properties, description);
    }

    @Override
    public DruidCircleBuilder description(List<String> description) {
        this.description = description;
        return this;
    }

    @Nonnull
    @Override
    public DruidCircleBuilder from(@Nonnull DruidCircle value) {
        return super.from(value).map(value.getMap()).levelRequirement(value.getLevelRequirement());
    }

    @Override
    public DruidCircleBuilder levelRequirement(int level) {
        this.level = level;
        return this;
    }

    @Override
    public DruidCircleBuilder map(Map<Integer, List<Feature>> map) {
        this.map = map;
        return this;
    }

    @Override
    public DruidCircleBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public DruidCircleBuilder properties(DataContainer properties) {
        this.properties = properties;
        return this;
    }

    @Nonnull
    @Override
    public DruidCircleBuilder reset() {
        description = new ArrayList<>();
        level = 1;
        map = new HashMap<>();
        name = null;
        properties = DataContainer.createNew();
        return this;
    }
}
