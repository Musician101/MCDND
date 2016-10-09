package io.musician101.sponge.mcdnd.clazz.feature.subclass.fightingstyle;

import io.musician101.sponge.mcdnd.util.MCDNDBuildable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

import java.util.List;

public class FightingStyle extends MCDNDBuildable
{
    FightingStyle(String name, DataContainer properties, List<String> description)
    {
        super(name, properties, description);
    }

    public static FightingStyleBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(FightingStyleBuilder.class);
    }
}
