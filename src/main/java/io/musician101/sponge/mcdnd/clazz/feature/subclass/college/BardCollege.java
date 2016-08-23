package io.musician101.sponge.mcdnd.clazz.feature.subclass.college;

import io.musician101.sponge.mcdnd.clazz.feature.subclass.SubClassFeature;
import io.musician101.sponge.mcdnd.util.list.FeatureList;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

import java.util.List;
import java.util.Map;

public class BardCollege extends SubClassFeature
{
    BardCollege(String name, Map<Integer, FeatureList> map, DataContainer properties, List<String> description)
    {
        super(name, 3, map, properties, description);
    }

    public static BardCollegeBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(BardCollegeBuilder.class);
    }
}
