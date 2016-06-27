package io.musician101.sponge.mcdnd.data.type.spell;

import io.musician101.sponge.mcdnd.data.type.MCDNDCatalogType;
import io.musician101.sponge.mcdnd.util.Interfaces.SingleValue;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(SpellLevels.class)
public class SpellLevel extends MCDNDCatalogType implements SingleValue<Integer>
{
    private final int numericalValue;

    public SpellLevel(String name, int numericalValue)
    {
        super(name);
        this.numericalValue = numericalValue;
    }

    @Override
    public Integer getValue()
    {
        return numericalValue;
    }
}
