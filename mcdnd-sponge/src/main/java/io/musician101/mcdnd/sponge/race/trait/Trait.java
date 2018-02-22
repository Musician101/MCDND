package io.musician101.mcdnd.sponge.race.trait;

import io.musician101.mcdnd.sponge.util.MCDNDBuildable;
import java.util.List;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class Trait extends MCDNDBuildable {

    protected Trait(String name, DataContainer properties, List<String> description) {
        super(name, properties, description);
    }

    public static TraitBuilder builder() {
        return Sponge.getRegistry().createBuilder(TraitBuilder.class);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
