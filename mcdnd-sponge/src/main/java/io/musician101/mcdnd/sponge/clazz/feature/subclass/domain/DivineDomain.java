package io.musician101.mcdnd.sponge.clazz.feature.subclass.domain;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.SubClassFeature;
import java.util.List;
import java.util.Map;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class DivineDomain extends SubClassFeature {

    DivineDomain(String name, Map<Integer, List<Feature>> map, DataContainer properties, List<String> description) {
        super(name, 1, map, properties, description);
    }

    public static DivineDomainBuilder builder() {
        return Sponge.getRegistry().createBuilder(DivineDomainBuilder.class);
    }
}
