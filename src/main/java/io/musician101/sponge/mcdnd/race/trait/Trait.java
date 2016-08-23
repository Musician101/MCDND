package io.musician101.sponge.mcdnd.race.trait;

import io.musician101.sponge.mcdnd.util.MCDNDBuildable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

import java.util.List;

public class Trait extends MCDNDBuildable
{
    protected Trait(String name, DataContainer properties, List<String> description)
    {
        super(name, properties, description);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    public static TraitBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(TraitBuilder.class);
    }
}
