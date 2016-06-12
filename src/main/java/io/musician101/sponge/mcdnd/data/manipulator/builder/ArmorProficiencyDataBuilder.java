package io.musician101.sponge.mcdnd.data.manipulator.builder;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableArmorProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.ArmorProficiencyData;
import io.musician101.sponge.mcdnd.data.manipulator.builder.common.ListDataManipulatorBuilder;
import io.musician101.sponge.mcdnd.equipment.armor.Armor;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class ArmorProficiencyDataBuilder extends ListDataManipulatorBuilder<Armor, ArmorProficiencyData, ImmutableArmorProficiencyData>
{
    @Nonnull
    @Override
    public ArmorProficiencyData create()
    {
        return new ArmorProficiencyData(value);
    }

    @Nonnull
    @Override
    public Optional<ArmorProficiencyData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<List<Armor>> optional = dataHolder.get(MCDNDKeys.ARMOR_PROFICIENCIES);//NOSONAR
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<ArmorProficiencyData> build(@Nonnull DataView container)
    {
        Optional<List<Armor>> optional = container.getObjectList(MCDNDKeys.ARMOR_PROFICIENCIES.getQuery(), Armor.class);//NOSONAR
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public ArmorProficiencyDataBuilder reset()
    {
        value = null;
        return this;
    }

    @Nonnull
    @Override
    public ArmorProficiencyDataBuilder from(@Nonnull ArmorProficiencyData value)
    {
        this.value = value.asList();
        return this;
    }
}
