package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.ListDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableSavingThrowProficiencyData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.SavingThrowProficiencyData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class SavingThrowProficiencyDataBuilder extends ListDataManipulatorBuilder<AbilityScoreType, SavingThrowProficiencyData, ImmutableSavingThrowProficiencyData>
{
    @Nonnull
    @Override
    public SavingThrowProficiencyData create()
    {
        return new SavingThrowProficiencyData(value);
    }

    @Nonnull
    @Override
    public Optional<SavingThrowProficiencyData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<List<AbilityScoreType>> optional = dataHolder.get(MCDNDKeys.SAVING_THROW_PROFICIENCIES);//NOSONAR
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<SavingThrowProficiencyData> build(@Nonnull DataView container)
    {
        Optional<List<AbilityScoreType>> optional = container.getObjectList(MCDNDKeys.SAVING_THROW_PROFICIENCIES.getQuery(), AbilityScoreType.class);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }
}
