package io.musician101.mcdnd.sponge.data.manipulator.mutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableArmorProficiencyData;
import io.musician101.mcdnd.sponge.equipment.armor.Armor;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractListData;
import org.spongepowered.api.data.merge.MergeFunction;

public class ArmorProficiencyData extends AbstractListData<Armor, ArmorProficiencyData, ImmutableArmorProficiencyData> {

    public ArmorProficiencyData(List<Armor> list) {
        super(list, MCDNDKeys.ARMOR_PROFICIENCIES);
    }

    @Nonnull
    @Override
    public ImmutableArmorProficiencyData asImmutable() {
        return new ImmutableArmorProficiencyData(getValue());
    }

    @Nonnull
    @Override
    public ArmorProficiencyData copy() {
        return new ArmorProficiencyData(getValue());
    }

    @Nonnull
    @Override
    public Optional<ArmorProficiencyData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap) {
        Optional<List<Armor>> optional = overlap.merge(this, dataHolder).get(usedKey);
        if (optional.isPresent()) {
            return Optional.of(new ArmorProficiencyData(optional.get()));
        }

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<ArmorProficiencyData> from(@Nonnull DataContainer container) {
        Optional<List<Armor>> optional = container.getObjectList(MCDNDKeys.ARMOR_PROFICIENCIES.getQuery(), Armor.class);
        if (optional.isPresent()) {
            return Optional.of(new ArmorProficiencyData(optional.get()));
        }

        return Optional.empty();
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
