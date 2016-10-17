package io.musician101.mcdnd.sponge.data.type;

import io.musician101.mcdnd.sponge.clazz.ProficiencyBonus;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(AbilityScoreTypes.class)
public class AbilityScoreType extends MCDNDCatalogType
{
    private final String abbreviation;

    public AbilityScoreType(String name, String abbreviation)
    {
        super(name);
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public int getMod(int score)
    {
        return (score - 10) / 2;
    }

    public int getSavingThrowMod(int score, ProficiencyBonus bonus, boolean isProficient)
    {
        if (isProficient)
            return score + bonus.getBonus();

        return score;
    }
}
