package io.musician101.mcdnd.sponge.clazz.feature.subclass;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.util.MCDNDBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SubClassFeatureBuilder<T extends SubClassFeature, B extends SubClassFeatureBuilder<T, B>> extends MCDNDBuilder<T, B> {

    protected int level = 1;
    protected Map<Integer, List<Feature>> map = new HashMap<>();

    public abstract B addToMap(int key, List<Feature> value);

    public abstract B levelRequirement(int level);

    public abstract B map(Map<Integer, List<Feature>> map);
}
