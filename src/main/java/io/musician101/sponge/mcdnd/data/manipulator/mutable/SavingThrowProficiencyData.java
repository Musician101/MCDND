package io.musician101.sponge.mcdnd.data.manipulator.mutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableSavingThrowProficiencyData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractListData;
import org.spongepowered.api.data.merge.MergeFunction;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class SavingThrowProficiencyData extends AbstractListData<AbilityScoreType, SavingThrowProficiencyData, ImmutableSavingThrowProficiencyData>
{
    public SavingThrowProficiencyData(List<AbilityScoreType> value)
    {
        super(value, MCDNDKeys.SAVING_THROW_PROFICIENCIES);
    }

    @Nonnull
    @Override
    public Optional<SavingThrowProficiencyData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap)
    {
        Optional<List<AbilityScoreType>> optional = overlap.merge(copy(), dataHolder).get(usedKey);
        if (optional.isPresent())
            return Optional.of(new SavingThrowProficiencyData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<SavingThrowProficiencyData> from(@Nonnull DataContainer container)
    {
        Optional<List<AbilityScoreType>> optional = container.getObjectList(usedKey.getQuery(), AbilityScoreType.class);
        if (optional.isPresent())
            return Optional.of(new SavingThrowProficiencyData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public SavingThrowProficiencyData copy()
    {
        return new SavingThrowProficiencyData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableSavingThrowProficiencyData asImmutable()
    {
        return new ImmutableSavingThrowProficiencyData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
