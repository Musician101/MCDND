package io.musician101.mcdnd.sponge.clazz.feature.subclass;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.util.Interfaces.Mapped;
import io.musician101.mcdnd.sponge.util.MCDNDBuildable;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;

public class SubClassFeature extends MCDNDBuildable implements Mapped<Integer, List<Feature>> {

    private final int levelRequirement;
    private final Map<Integer, List<Feature>> map;

    protected SubClassFeature(String name, int levelRequirement, Map<Integer, List<Feature>> map, DataContainer properties, List<String> description) {
        super(name, properties, description);
        this.levelRequirement = levelRequirement;
        this.map = map;
    }

    @Override
    public boolean containsKey(Integer key) {
        return map.containsKey(key);
    }

    @Override
    public List<Feature> get(Integer key) {
        return map.get(key);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    @Override
    public Map<Integer, List<Feature>> getMap() {
        return map;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(MCDNDKeys.FEATURES_MAP, map);
    }
}
