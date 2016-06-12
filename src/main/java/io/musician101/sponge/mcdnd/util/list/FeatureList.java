package io.musician101.sponge.mcdnd.util.list;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;

import java.util.ArrayList;
import java.util.Collection;

public class FeatureList extends ArrayList<Feature>
{
    private FeatureList(Collection<? extends Feature> collection)
    {
        super(collection);
    }

    public static FeatureList of(Collection<? extends Feature> collection)
    {
        return new FeatureList(collection);
    }
}
