package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.SavingThrowProficiencyData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableListData;

import javax.annotation.Nonnull;
import java.util.List;

public class ImmutableSavingThrowProficiencyData extends AbstractImmutableListData<AbilityScoreType, ImmutableSavingThrowProficiencyData, SavingThrowProficiencyData>
{
    public ImmutableSavingThrowProficiencyData(List<AbilityScoreType> value)
    {
        super(value, MCDNDKeys.SAVING_THROW_PROFICIENCIES);
    }

    @Nonnull
    @Override
    public SavingThrowProficiencyData asMutable()
    {
        return new SavingThrowProficiencyData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
