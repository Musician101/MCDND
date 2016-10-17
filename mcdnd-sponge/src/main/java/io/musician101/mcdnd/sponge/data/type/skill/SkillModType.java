package io.musician101.mcdnd.sponge.data.type.skill;

import io.musician101.mcdnd.sponge.clazz.ProficiencyBonus;
import io.musician101.mcdnd.sponge.data.type.MCDNDCatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.function.Function;

@CatalogedBy(SkillModTypes.class)
public class SkillModType extends MCDNDCatalogType
{
    private final Function<Integer, Integer> function;

    public SkillModType(String name, Function<Integer, Integer> function)
    {
        super(name);
        this.function = function;
    }

    public int calculateMod(int scoreMod, ProficiencyBonus bonus)
    {
        return scoreMod / 2  + function.apply(bonus.getBonus());
    }
}
