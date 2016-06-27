package io.musician101.sponge.mcdnd.clazz.feature.subclass;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.util.Interfaces.Mapped;
import io.musician101.sponge.mcdnd.util.list.FeatureList;
import org.spongepowered.api.data.DataContainer;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

public class SubClassFeature extends Feature implements Mapped<Integer, FeatureList>
{
    private final Map<Integer, FeatureList> map;

    protected SubClassFeature(String name, int level, Map<Integer, FeatureList> map, DataContainer properties, List<String> description)
    {
        super(name, level, properties, description);
        this.map = map;
    }

    @Override
    public boolean containsKey(Integer key)
    {
        return map.containsKey(key);
    }

    @Override
    public Map<Integer, FeatureList> getMap()
    {
        return map;
    }

    @Override
    public FeatureList get(Integer key)
    {
        return map.get(key);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return super.toContainer().set(MCDNDKeys.FEATURES_MAP, map);
    }
}
