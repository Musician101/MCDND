package io.musician101.mcdnd.sponge.clazz.feature;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.util.MCDNDBuildable;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class Feature extends MCDNDBuildable {

    private final int level;

    protected Feature(String name, int level, DataContainer properties, List<String> description) {
        super(name, properties, description);
        this.level = level;
    }

    public static FeatureBuilder builder() {
        return Sponge.getRegistry().createBuilder(FeatureBuilder.class);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public int getLevelRequirement() {
        return level;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(MCDNDKeys.STARTING_LEVEL, level);
    }
}
