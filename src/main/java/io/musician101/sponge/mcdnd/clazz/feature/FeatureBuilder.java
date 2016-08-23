package io.musician101.sponge.mcdnd.clazz.feature;

import io.musician101.sponge.mcdnd.util.MCDNDBuilder;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class FeatureBuilder extends MCDNDBuilder<Feature, FeatureBuilder>
{
    protected int level = 1;

    @Override
    public <E> FeatureBuilder addProperty(Key<? extends BaseValue<E>> key, E value)
    {
        properties.set(key, value);
        return this;
    }

    @Override
    public FeatureBuilder addLineToDescription(String line)
    {
        description.add(line);
        return this;
    }

    @Override
    public FeatureBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    //TODO add a way to add individual lines to description
    //TODO create builder interfaces for description, build, levelRequirement, name, properties
    public FeatureBuilder levelRequirement(int level)
    {
        this.level = level;
        return this;
    }

    @Override
    public FeatureBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public FeatureBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    @Override
    public Feature build()
    {
        return new Feature(name, level, properties, description);
    }

    @Nonnull
    @Override
    public FeatureBuilder from(@Nonnull Feature value)
    {
        return super.from(value)
                .levelRequirement(value.getLevelRequirement());
    }

    @Nonnull
    @Override
    public FeatureBuilder reset()
    {
        name = null;
        description = new ArrayList<>();
        level = 1;
        properties = new MemoryDataContainer();
        return this;
    }
}
