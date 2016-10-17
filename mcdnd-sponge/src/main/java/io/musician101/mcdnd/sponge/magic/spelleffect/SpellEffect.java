package io.musician101.mcdnd.sponge.magic.spelleffect;

import io.musician101.mcdnd.sponge.util.MCDNDBuildable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

import java.util.List;

public class SpellEffect extends MCDNDBuildable
{
    protected SpellEffect(String name, DataContainer properties, List<String> description)
    {
        super(name, properties, description);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    public static SpellEffectBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(SpellEffectBuilder.class);
    }
}
