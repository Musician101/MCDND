package io.musician101.sponge.mcdnd.clazz.feature.subclass.domain;

import io.musician101.sponge.mcdnd.clazz.feature.subclass.SubClassFeatureBuilder;
import io.musician101.sponge.mcdnd.util.list.FeatureList;
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

public class DivineDomainBuilder extends SubClassFeatureBuilder<DivineDomain, DivineDomainBuilder>
{
    @Override
    public DivineDomainBuilder addLineToDescription(String line)
    {
        description.add(line);
        return this;
    }

    @Override
    public <E> DivineDomainBuilder addProperty(Key<? extends BaseValue<E>> key, E value)
    {
        properties.set(key, value);
        return this;
    }

    @Override
    public DivineDomainBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    @Override
    public DivineDomainBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    @Override
    public DivineDomainBuilder levelRequirement(int level)
    {
        this.level = level;
        return this;
    }

    @Override
    public DivineDomainBuilder map(Map<Integer, FeatureList> map)
    {
        this.map = map;
        return this;
    }

    @Override
    public DivineDomainBuilder addToMap(int key, FeatureList value)
    {
        map.put(key, value);
        return this;
    }

    @Override
    public DivineDomainBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public DivineDomainBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    @Override
    public DivineDomain build()
    {
        return new DivineDomain(name, map, properties, description);
    }

    @Nonnull
    @Override
    public DivineDomainBuilder from(@Nonnull DivineDomain value)
    {
        return super.from(value).map(value.getMap()).levelRequirement(value.getLevelRequirement());
    }

    @Nonnull
    @Override
    public DivineDomainBuilder reset()
    {
        description = new ArrayList<>();
        level = 1;
        map = new HashMap<>();
        name = null;
        properties = new MemoryDataContainer();
        return this;
    }
}
