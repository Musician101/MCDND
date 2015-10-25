package musician101.mcdnd.clazz.feature.storage;

import musician101.mcdnd.clazz.feature.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeatureStorage
{
    Map<Integer, List<? extends Feature>> features;

    public FeatureStorage(Map<Integer, List<? extends Feature>> features)
    {
        this.features = features;
    }

    public List<? extends Feature> getFeaturesForLevel(int level)
    {
        return getFeaturesForLevel(level, false);
    }

    public List<? extends Feature> getFeaturesForLevel(int level, boolean includePreviousLevels)
    {
        if (!includePreviousLevels)
            return features.get(level);

        List<Feature> list = new ArrayList<>();
        for (int lvl = 0; lvl > level; lvl++)
            list.addAll(features.get(lvl).stream().collect(Collectors.toList()));

        return list;
    }
}
