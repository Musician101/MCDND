package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.MappedDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableSkillProficiencyData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.SkillProficiencyData;
import io.musician101.mcdnd.sponge.data.type.skill.SkillModType;
import io.musician101.mcdnd.sponge.data.type.skill.SkillType;
import io.musician101.mcdnd.sponge.util.Utils;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;

public class SkillProficiencyDataBuilder extends MappedDataManipulatorBuilder<SkillType, SkillModType, SkillProficiencyData, ImmutableSkillProficiencyData>
{
    @Nonnull
    @Override
    public SkillProficiencyData create()
    {
        return new SkillProficiencyData(value);
    }

    @Nonnull
    @Override
    public Optional<SkillProficiencyData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<Map<SkillType, SkillModType>> optional = dataHolder.get(MCDNDKeys.SKILL_PROFICIENCIES);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<SkillProficiencyData> build(@Nonnull DataView container)
    {
        Optional<Map<SkillType, SkillModType>> optional = Utils.getObjectMap((DataContainer) container, MCDNDKeys.SKILL_PROFICIENCIES.getQuery(), SkillType.class, SkillModType.class);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }
}
