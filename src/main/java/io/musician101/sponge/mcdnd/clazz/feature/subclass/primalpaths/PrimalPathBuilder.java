package io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.SubClassFeatureBuilder;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimalPathBuilder extends SubClassFeatureBuilder<PrimalPath, PrimalPathBuilder>
{
    @Override
    public <V> PrimalPathBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

    @Override
    public PrimalPathBuilder addLineToDescription(String line)
    {
        description.add(line);
        return this;
    }

    @Override
    public PrimalPathBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    @Override
    public PrimalPathBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    @Override
    public PrimalPathBuilder levelRequirement(int level)
    {
        this.level = level;
        return this;
    }

    @Override
    public PrimalPathBuilder map(Map<Integer, List<Feature>> map)
    {
        this.map = map;
        return this;
    }

    @Override
    public PrimalPathBuilder addToMap(int key, List<Feature> value)
    {
        map.put(key, value);
        return this;
    }

    @Override
    public PrimalPathBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public PrimalPathBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    @Override
    public PrimalPath build()
    {
        return new PrimalPath(name, map, properties, description);
    }

    @Nonnull
    @Override
    public PrimalPathBuilder from(@Nonnull PrimalPath value)
    {
        return super.from(value).map(value.getMap()).levelRequirement(value.getLevelRequirement());
    }

    @Nonnull
    @Override
    public PrimalPathBuilder reset()
    {
        description = new ArrayList<>();
        level = 1;
        map = new HashMap<>();
        name = null;
        properties = new MemoryDataContainer();
        return this;
    }
}
