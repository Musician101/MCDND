package io.musician101.mcdnd.sponge.clazz.feature.subclass.college;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.SubClassFeature;
import java.util.List;
import java.util.Map;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class BardCollege extends SubClassFeature {

    BardCollege(String name, Map<Integer, List<Feature>> map, DataContainer properties, List<String> description) {
        super(name, 3, map, properties, description);
    }

    public static BardCollegeBuilder builder() {
        return Sponge.getRegistry().createBuilder(BardCollegeBuilder.class);
    }
}
