package io.musician101.mcdnd.sponge.clazz.feature.subclass.druidcircle;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.clazz.feature.subclass.SubClassFeature;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

import java.util.List;
import java.util.Map;

public class DruidCircle extends SubClassFeature
{
    DruidCircle(String name, Map<Integer, List<Feature>> map, DataContainer properties, List<String> description)
    {
        super(name, 2, map, properties, description);
    }

    public static DruidCircleBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(DruidCircleBuilder.class);
    }
}
