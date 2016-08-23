package io.musician101.sponge.mcdnd.clazz.feature.subclass.college;

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

public class BardCollegeBuilder extends SubClassFeatureBuilder<BardCollege, BardCollegeBuilder>
{
    @Override
    public BardCollegeBuilder addLineToDescription(String line)
    {
        description.add(line);
        return this;
    }

    @Override
    public <E> BardCollegeBuilder addProperty(Key<? extends BaseValue<E>> key, E value)
    {
        this.properties.set(key, value);
        return this;
    }

    @Override
    public BardCollegeBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    @Override
    public BardCollegeBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    @Override
    public BardCollegeBuilder levelRequirement(int level)
    {
        this.level = level;
        return this;
    }

    @Override
    public BardCollegeBuilder map(Map<Integer, FeatureList> map)
    {
        this.map = map;
        return this;
    }

    @Override
    public BardCollegeBuilder addToMap(int key, FeatureList value)
    {
        map.put(key, value);
        return this;
    }

    @Override
    public BardCollegeBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public BardCollegeBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    @Override
    public BardCollege build()
    {
        return new BardCollege(name, map, properties, description);
    }

    @Nonnull
    @Override
    public BardCollegeBuilder from(@Nonnull BardCollege value)
    {
        return super.from(value).map(value.getMap()).levelRequirement(value.getLevelRequirement());
    }

    @Nonnull
    @Override
    public BardCollegeBuilder reset()
    {
        description = new ArrayList<>();
        level = 1;
        map = new HashMap<>();
        name = null;
        properties = new MemoryDataContainer();
        return this;
    }
}
