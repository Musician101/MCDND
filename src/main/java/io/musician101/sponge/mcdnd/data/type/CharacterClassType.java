package io.musician101.sponge.mcdnd.data.type;

import io.musician101.sponge.mcdnd.dice.HitDice;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(CharacterClassTypes.class)
public class CharacterClassType extends MCDNDCatalogType
{
    private final HitDice hitDice;

    public CharacterClassType(String name, HitDice hitDice)
    {
        super(name);
        this.hitDice = hitDice;
    }

    public HitDice getHitDice()
    {
        return hitDice;
    }
}
