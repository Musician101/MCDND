package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.SavingThrowProficiencyData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableListData;

public class ImmutableSavingThrowProficiencyData extends AbstractImmutableListData<AbilityScoreType, ImmutableSavingThrowProficiencyData, SavingThrowProficiencyData> {

    public ImmutableSavingThrowProficiencyData(List<AbilityScoreType> value) {
        super(value, MCDNDKeys.SAVING_THROW_PROFICIENCIES);
    }

    @Nonnull
    @Override
    public SavingThrowProficiencyData asMutable() {
        return new SavingThrowProficiencyData(getValue());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
