package io.musician101.mcdnd.sponge.clazz.feature.subclass.primalpaths;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.SubClassFeature;
import java.util.List;
import java.util.Map;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class PrimalPath extends SubClassFeature {

    PrimalPath(String name, Map<Integer, List<Feature>> map, DataContainer properties, List<String> description) {
        super(name, 3, map, properties, description);
    }

    public static PrimalPathBuilder builder() {
        return Sponge.getRegistry().createBuilder(PrimalPathBuilder.class);
    }
}
