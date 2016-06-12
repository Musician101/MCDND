package io.musician101.sponge.mcdnd.property.single;

import io.musician101.sponge.mcdnd.clazz.ProficiencyBonus;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.SkillProficiencyData;
import io.musician101.sponge.mcdnd.data.type.skill.SkillModType;
import io.musician101.sponge.mcdnd.data.type.skill.SkillType;
import io.musician101.sponge.mcdnd.util.Interfaces.SkillDCSave;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.Optional;

public class SkillDCSaveProperty extends SingleValueProperty<SkillType> implements SkillDCSave
{
    public SkillDCSaveProperty(SkillType skillType)
    {
        super(skillType);
    }

    @Override
    public Optional<Integer> getDCSave(AbilityScoreData scoreData, SkillProficiencyData skillData, ProficiencyBonus bonus)
    {
        Optional<SkillModType> skillModOptional = skillData.get(value);
        if (!skillModOptional.isPresent())
            return Optional.empty();

        Optional<Integer> modifierOptional = value.getMod(scoreData, bonus, skillModOptional.get());
        if (!modifierOptional.isPresent())
            return Optional.empty();

        return Optional.of(8 + modifierOptional.get());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.SKILL_TYPE, value);
    }
}
