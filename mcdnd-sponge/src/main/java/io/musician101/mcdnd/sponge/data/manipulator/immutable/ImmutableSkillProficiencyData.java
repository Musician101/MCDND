package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.SkillProficiencyData;
import io.musician101.mcdnd.sponge.data.type.skill.SkillModType;
import io.musician101.mcdnd.sponge.data.type.skill.SkillType;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData;

import java.util.Map;

public class ImmutableSkillProficiencyData extends AbstractImmutableMappedData<SkillType, SkillModType, ImmutableSkillProficiencyData, SkillProficiencyData>
{
    public ImmutableSkillProficiencyData(Map<SkillType, SkillModType> value)
    {
        super(value, MCDNDKeys.SKILL_PROFICIENCIES);
    }

    @Override
    public SkillProficiencyData asMutable()
    {
        return new SkillProficiencyData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
