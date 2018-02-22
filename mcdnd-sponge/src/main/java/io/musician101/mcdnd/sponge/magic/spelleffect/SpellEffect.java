package io.musician101.mcdnd.sponge.magic.spelleffect;

import io.musician101.mcdnd.sponge.util.MCDNDBuildable;
import java.util.List;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

public class SpellEffect extends MCDNDBuildable {

    protected SpellEffect(String name, DataContainer properties, List<String> description) {
        super(name, properties, description);
    }

    public static SpellEffectBuilder builder() {
        return Sponge.getRegistry().createBuilder(SpellEffectBuilder.class);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
