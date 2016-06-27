package io.musician101.sponge.mcdnd.data.type.spell;

import io.musician101.sponge.mcdnd.data.type.MCDNDCatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(SpellTypes.class)
public class SpellType extends MCDNDCatalogType
{
    public SpellType(String name)
    {
        super(name);
    }
}
