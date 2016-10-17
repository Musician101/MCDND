package io.musician101.mcdnd.sponge.clazz.feature.storage;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeatureStorage
{
    private final Map<Integer, List<Feature>> features;

    public FeatureStorage(Map<Integer, List<Feature>> features)
    {
        this.features = features;
    }

    public List<Feature> getFeaturesForLevel(int level)
    {
        return getFeaturesForLevel(level, false);
    }

    public List<Feature> getFeaturesForLevel(int level, boolean includePreviousLevels)
    {
        if (!includePreviousLevels)
            return features.get(level);

        List<Feature> list = new ArrayList<>();
        for (int lvl = 0; lvl < level; lvl++)
            list.addAll(features.get(lvl).stream().collect(Collectors.toList()));

        return list;
    }
}
