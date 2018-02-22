package io.musician101.mcdnd.sponge.clazz.feature.subclass.fightingstyle;

import io.musician101.mcdnd.sponge.util.MCDNDBuildable;
import java.util.List;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class FightingStyle extends MCDNDBuildable {

    FightingStyle(String name, DataContainer properties, List<String> description) {
        super(name, properties, description);
    }

    public static FightingStyleBuilder builder() {
        return Sponge.getRegistry().createBuilder(FightingStyleBuilder.class);
    }
}
