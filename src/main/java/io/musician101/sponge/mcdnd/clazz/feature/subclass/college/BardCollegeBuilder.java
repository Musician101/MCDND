package io.musician101.sponge.mcdnd.clazz.feature.subclass.college;

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

public class BardCollegeBuilder extends SubClassFeatureBuilder
{
    @Override
    public <E> BardCollegeBuilder addProperty(Key<? extends BaseValue<E>> key, E value)
    {
        return (BardCollegeBuilder) super.addProperty(key, value);
    }

    @Override
    public BardCollegeBuilder description(List<String> description)
    {
        return (BardCollegeBuilder) super.description(description);
    }

    @Override
    public BardCollegeBuilder description(String... description)
    {
        return (BardCollegeBuilder) super.description(description);
    }

    @Override
    public BardCollegeBuilder levelRequirement(int level)
    {
        return (BardCollegeBuilder) super.levelRequirement(level);
    }

    @Override
    public BardCollegeBuilder map(Map<Integer, FeatureList> map)
    {
        return (BardCollegeBuilder) super.map(map);
    }

    @Override
    public BardCollegeBuilder addToMap(int key, FeatureList value)
    {
        return (BardCollegeBuilder) super.addToMap(key, value);
    }

    @Override
    public BardCollegeBuilder name(String name)
    {
        return (BardCollegeBuilder) super.name(name);
    }

    @Override
    public BardCollegeBuilder properties(DataContainer properties)
    {
        return (BardCollegeBuilder) super.properties(properties);
    }

    @Override
    public BardCollege build()
    {
        return new BardCollege(name, map, properties, description);
    }

    @Nonnull
    @Override
    public BardCollegeBuilder from(@Nonnull Feature value)
    {
        PrimalPath pp = (PrimalPath) value;
        return (BardCollegeBuilder) super.from(pp).map(pp.getMap());
    }

    @Nonnull
    @Override
    public BardCollegeBuilder reset()
    {
        return (BardCollegeBuilder) super.reset();
    }
}
