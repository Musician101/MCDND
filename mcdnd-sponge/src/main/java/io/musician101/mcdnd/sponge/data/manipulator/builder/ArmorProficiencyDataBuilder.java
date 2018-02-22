package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.ListDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableArmorProficiencyData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.ArmorProficiencyData;
import io.musician101.mcdnd.sponge.equipment.armor.Armor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

public class ArmorProficiencyDataBuilder extends ListDataManipulatorBuilder<Armor, ArmorProficiencyData, ImmutableArmorProficiencyData> {

    @Nonnull
    @Override
    public Optional<ArmorProficiencyData> build(@Nonnull DataView container) {
        Optional<List<Armor>> optional = container.getObjectList(MCDNDKeys.ARMOR_PROFICIENCIES.getQuery(), Armor.class);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public ArmorProficiencyData create() {
        return new ArmorProficiencyData(value);
    }

    @Nonnull
    @Override
    public Optional<ArmorProficiencyData> createFrom(@Nonnull DataHolder dataHolder) {
        Optional<List<Armor>> optional = dataHolder.get(MCDNDKeys.ARMOR_PROFICIENCIES);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public ArmorProficiencyDataBuilder from(@Nonnull ArmorProficiencyData value) {
        this.value = value.asList();
        return this;
    }

    @Nonnull
    @Override
    public ArmorProficiencyDataBuilder reset() {
        value = null;
        return this;
    }
}
