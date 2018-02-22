package io.musician101.mcdnd.sponge.data.manipulator.mutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableWeaponProficiencyData;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapon;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractListData;
import org.spongepowered.api.data.merge.MergeFunction;

public class WeaponProficiencyData extends AbstractListData<Weapon, WeaponProficiencyData, ImmutableWeaponProficiencyData> {

    public WeaponProficiencyData(List<Weapon> value) {
        super(value, MCDNDKeys.WEAPON_PROFICIENCIES);
    }

    @Nonnull
    @Override
    public ImmutableWeaponProficiencyData asImmutable() {
        return new ImmutableWeaponProficiencyData(getValue());
    }

    @Nonnull
    @Override
    public WeaponProficiencyData copy() {
        return new WeaponProficiencyData(getValue());
    }

    @Nonnull
    @Override
    public Optional<WeaponProficiencyData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap) {
        Optional<List<Weapon>> optional = overlap.merge(this, dataHolder).get(usedKey);
        if (optional.isPresent()) {
            setValue(optional.get());
        }

        return Optional.of(this);
    }

    @Nonnull
    @Override
    public Optional<WeaponProficiencyData> from(@Nonnull DataContainer container) {
        Optional<List<Weapon>> optional = container.getObjectList(usedKey.getQuery(), Weapon.class);
        if (optional.isPresent()) {
            setValue(optional.get());
        }

        return Optional.of(this);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
