package io.musician101.sponge.mcdnd.data.manipulator.mutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableSkillProficiencyData;
import io.musician101.sponge.mcdnd.data.type.skill.SkillModType;
import io.musician101.sponge.mcdnd.data.type.skill.SkillType;
import io.musician101.sponge.mcdnd.util.Utils;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractMappedData;
import org.spongepowered.api.data.merge.MergeFunction;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class SkillProficiencyData extends AbstractMappedData<SkillType, SkillModType, SkillProficiencyData, ImmutableSkillProficiencyData>
{
    public SkillProficiencyData(Map<SkillType, SkillModType> value)
    {
        super(value, MCDNDKeys.SKILL_PROFICIENCIES);
    }

    @Nonnull
    @Override
    public Optional<SkillModType> get(@Nonnull SkillType key)
    {
        if (getValue().containsKey(key))
            return Optional.of(getValue().get(key));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Set<SkillType> getMapKeys()
    {
        return getValue().keySet();
    }

    @Nonnull
    @Override
    public SkillProficiencyData put(@Nonnull SkillType key, @Nonnull SkillModType value)
    {
        Map<SkillType, SkillModType> map = getValue();
        map.put(key, value);
        return new SkillProficiencyData(map);
    }

    @Nonnull
    @Override
    public SkillProficiencyData putAll(@Nonnull Map<? extends SkillType, ? extends SkillModType> map)
    {
        Map<SkillType, SkillModType> newMap = getValue();
        newMap.putAll(map);
        return new SkillProficiencyData(newMap);
    }

    @Nonnull
    @Override
    public SkillProficiencyData remove(@Nonnull SkillType key)
    {
        Map<SkillType, SkillModType> map = getValue();
        map.remove(key);
        return new SkillProficiencyData(map);
    }

    @Nonnull
    @Override
    public Optional<SkillProficiencyData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap)
    {
        Optional<Map<SkillType, SkillModType>> optional = overlap.merge(this, dataHolder).get(usedKey);
        if (optional.isPresent())
            return Optional.of(new SkillProficiencyData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<SkillProficiencyData> from(@Nonnull DataContainer container)
    {
        Optional<Map<SkillType, SkillModType>> optional = Utils.getObjectMap(container, usedKey.getQuery(), SkillType.class, SkillModType.class);
        if (optional.isPresent())
            return Optional.of(new SkillProficiencyData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public SkillProficiencyData copy()
    {
        return new SkillProficiencyData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableSkillProficiencyData asImmutable()
    {
        return new ImmutableSkillProficiencyData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
