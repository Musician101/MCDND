package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.ListDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableSavingThrowProficiencyData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.SavingThrowProficiencyData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

public class SavingThrowProficiencyDataBuilder extends ListDataManipulatorBuilder<AbilityScoreType, SavingThrowProficiencyData, ImmutableSavingThrowProficiencyData> {

    @Nonnull
    @Override
    public Optional<SavingThrowProficiencyData> build(@Nonnull DataView container) {
        Optional<List<AbilityScoreType>> optional = container.getObjectList(MCDNDKeys.SAVING_THROW_PROFICIENCIES.getQuery(), AbilityScoreType.class);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public SavingThrowProficiencyData create() {
        return new SavingThrowProficiencyData(value);
    }

    @Nonnull
    @Override
    public Optional<SavingThrowProficiencyData> createFrom(@Nonnull DataHolder dataHolder) {
        Optional<List<AbilityScoreType>> optional = dataHolder.get(MCDNDKeys.SAVING_THROW_PROFICIENCIES);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        this.value = optional.get();
        return Optional.of(create());
    }
}
