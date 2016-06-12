package io.musician101.sponge.mcdnd.clazz.feature.subclass.domain;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.SubClassFeatureBuilder;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.PrimalPath;
import io.musician101.sponge.mcdnd.util.list.FeatureList;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

public class DivineDomainBuilder extends SubClassFeatureBuilder
{
    @Override
    public <E> DivineDomainBuilder addProperty(Key<? extends BaseValue<E>> key, E value)
    {
        return (DivineDomainBuilder) super.addProperty(key, value);
    }

    @Override
    public DivineDomainBuilder description(List<String> description)
    {
        return (DivineDomainBuilder) super.description(description);
    }

    @Override
    public DivineDomainBuilder description(String... description)
    {
        return (DivineDomainBuilder) super.description(description);
    }

    @Override
    public DivineDomainBuilder levelRequirement(int level)
    {
        return (DivineDomainBuilder) super.levelRequirement(level);
    }

    @Override
    public DivineDomainBuilder map(Map<Integer, FeatureList> map)
    {
        return (DivineDomainBuilder) super.map(map);
    }

    @Override
    public DivineDomainBuilder addToMap(int key, FeatureList value)
    {
        return (DivineDomainBuilder) super.addToMap(key, value);
    }

    @Override
    public DivineDomainBuilder name(String name)
    {
        return (DivineDomainBuilder) super.name(name);
    }

    @Override
    public DivineDomainBuilder properties(DataContainer properties)
    {
        return (DivineDomainBuilder) super.properties(properties);
    }

    @Override
    public DivineDomain build()
    {
        return new DivineDomain(name, map, properties, description);
    }

    @Nonnull
    @Override
    public DivineDomainBuilder from(@Nonnull Feature value)
    {
        PrimalPath pp = (PrimalPath) value;
        return (DivineDomainBuilder) super.from(pp).map(pp.getMap());
    }

    @Nonnull
    @Override
    public DivineDomainBuilder reset()
    {
        return (DivineDomainBuilder) super.reset();
    }
}
