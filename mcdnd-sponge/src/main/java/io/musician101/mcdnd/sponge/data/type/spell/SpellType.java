package io.musician101.mcdnd.sponge.data.type.spell;

import io.musician101.mcdnd.sponge.data.type.MCDNDCatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(SpellTypes.class)
public class SpellType extends MCDNDCatalogType
{
    public SpellType(String name)
    {
        super(name);
    }
}
