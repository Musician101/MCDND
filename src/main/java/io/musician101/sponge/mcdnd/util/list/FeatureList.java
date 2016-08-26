package io.musician101.sponge.mcdnd.util.list;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FeatureList extends ArrayList<Feature>
{
    private FeatureList(Collection<? extends Feature> collection)
    {
        super(collection);
    }

    public static FeatureList of(Feature... features)
    {
        return new FeatureList(Arrays.asList(features));
    }
}
