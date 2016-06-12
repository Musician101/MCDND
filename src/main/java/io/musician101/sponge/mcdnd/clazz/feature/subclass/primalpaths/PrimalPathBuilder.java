package io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.SubClassFeatureBuilder;
import io.musician101.sponge.mcdnd.util.list.FeatureList;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

public class PrimalPathBuilder extends SubClassFeatureBuilder
{
    @Override
    public <E> PrimalPathBuilder addProperty(Key<? extends BaseValue<E>> key, E value)
    {
        return (PrimalPathBuilder) super.addProperty(key, value);
    }

    @Override
    public PrimalPathBuilder description(List<String> description)
    {
        return (PrimalPathBuilder) super.description(description);
    }

    @Override
    public PrimalPathBuilder description(String... description)
    {
        return (PrimalPathBuilder) super.description(description);
    }

    @Override
    public PrimalPathBuilder levelRequirement(int level)
    {
        return (PrimalPathBuilder) super.levelRequirement(level);
    }

    @Override
    public PrimalPathBuilder map(Map<Integer, FeatureList> map)
    {
        return (PrimalPathBuilder) super.map(map);
    }

    @Override
    public PrimalPathBuilder addToMap(int key, FeatureList value)
    {
        return (PrimalPathBuilder) super.addToMap(key, value);
    }

    @Override
    public PrimalPathBuilder name(String name)
    {
        return (PrimalPathBuilder) super.name(name);
    }

    @Override
    public PrimalPathBuilder properties(DataContainer properties)
    {
        return (PrimalPathBuilder) super.properties(properties);
    }

    @Override
    public PrimalPath build()
    {
        return new PrimalPath(name, map, properties, description);
    }

    @Nonnull
    @Override
    public PrimalPathBuilder from(@Nonnull Feature value)
    {
        PrimalPath pp = (PrimalPath) value;
        return (PrimalPathBuilder) super.from(pp).map(pp.getMap());
    }

    @Nonnull
    @Override
    public PrimalPathBuilder reset()
    {
        return (PrimalPathBuilder) super.reset();
    }
}
