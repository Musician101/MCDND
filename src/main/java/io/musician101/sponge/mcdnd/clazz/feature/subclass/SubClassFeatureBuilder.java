package io.musician101.sponge.mcdnd.clazz.feature.subclass;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.FeatureBuilder;
import io.musician101.sponge.mcdnd.util.list.FeatureList;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class SubClassFeatureBuilder extends FeatureBuilder
{
    protected Map<Integer, FeatureList> map = new HashMap<>();

    public SubClassFeatureBuilder map(Map<Integer, FeatureList> map)
    {
        this.map = map;
        return this;
    }

    public SubClassFeatureBuilder addToMap(int key, FeatureList value)
    {
        map.put(key, value);
        return this;
    }

    @Nonnull
    @Override
    public SubClassFeatureBuilder from(@Nonnull Feature value)
    {
        SubClassFeature scf = (SubClassFeature) value;
        return ((SubClassFeatureBuilder) super.from(scf)).map(scf.getMap());
    }

    @Nonnull
    @Override
    public SubClassFeatureBuilder reset()
    {
        super.reset();
        this.map = new HashMap<>();
        return this;
    }
}
