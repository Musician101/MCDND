package io.musician101.sponge.mcdnd.clazz.feature.subclass;

import io.musician101.sponge.mcdnd.util.MCDNDBuilder;
import io.musician101.sponge.mcdnd.util.list.FeatureList;

import java.util.HashMap;
import java.util.Map;

public abstract class SubClassFeatureBuilder<T extends SubClassFeature, B extends SubClassFeatureBuilder<T, B>> extends MCDNDBuilder<T, B>
{
    protected int level = 1;
    protected Map<Integer, FeatureList> map = new HashMap<>();

    public abstract B levelRequirement(int level);

    public abstract B map(Map<Integer, FeatureList> map);

    public abstract B addToMap(int key, FeatureList value);
}
