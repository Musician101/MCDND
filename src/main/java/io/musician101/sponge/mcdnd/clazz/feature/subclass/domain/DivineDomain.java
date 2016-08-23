package io.musician101.sponge.mcdnd.clazz.feature.subclass.domain;

import io.musician101.sponge.mcdnd.clazz.feature.subclass.SubClassFeature;
import io.musician101.sponge.mcdnd.util.list.FeatureList;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

import java.util.List;
import java.util.Map;

public class DivineDomain extends SubClassFeature
{
    DivineDomain(String name, Map<Integer, FeatureList> map, DataContainer properties, List<String> description)
    {
        super(name, 1, map, properties, description);
    }

    public static DivineDomainBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(DivineDomainBuilder.class);
    }
}
