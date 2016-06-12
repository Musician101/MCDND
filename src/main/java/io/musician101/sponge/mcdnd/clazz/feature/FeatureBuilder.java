package io.musician101.sponge.mcdnd.clazz.feature;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FeatureBuilder implements ResettableBuilder<Feature, FeatureBuilder>
{
    protected DataContainer properties = new MemoryDataContainer();
    protected int level = 1;
    protected List<String> description = new ArrayList<>();
    protected String name;

    public <E> FeatureBuilder addProperty(Key<? extends BaseValue<E>> key, E value)
    {
        properties.set(key, value);
        return this;
    }

    public FeatureBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    public FeatureBuilder description(String... description)
    {
        this.description = Arrays.asList(description);
        return this;
    }

    public FeatureBuilder levelRequirement(int level)
    {
        this.level = level;
        return this;
    }

    public FeatureBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public FeatureBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    public Feature build()
    {
        return new Feature(name, level, properties, description);
    }

    @Nonnull
    @Override
    public FeatureBuilder from(@Nonnull Feature value)
    {
        return name(value.getName())
                .description(value.getDescription())
                .levelRequirement(value.getLevelRequirement())
                .properties(value.getProperties());
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
