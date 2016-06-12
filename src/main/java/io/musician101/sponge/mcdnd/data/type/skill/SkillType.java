package io.musician101.sponge.mcdnd.data.type.skill;

import io.musician101.sponge.mcdnd.clazz.ProficiencyBonus;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.MCDNDCatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

@CatalogedBy(SkillTypes.class)
public class SkillType extends MCDNDCatalogType
{
    private final AbilityScoreType type;

    public SkillType(String name, AbilityScoreType type)
    {
        super(name);
        this.type = type;
    }

    public AbilityScoreType getScoreType()
    {
        return type;
    }

    public Optional<Integer> getMod(AbilityScoreData score, ProficiencyBonus bonus, SkillModType skillModType)
    {
        Optional<Integer> optional = score.get(type);
        if (!optional.isPresent())
            return Optional.empty();

        return Optional.of(skillModType.calculateMod(type.getMod(optional.get()), bonus));
    }
}
