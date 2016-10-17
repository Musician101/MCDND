package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.ListDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableWeaponProficiencyData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.WeaponProficiencyData;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapon;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class WeaponProficiencyDataBuilder extends ListDataManipulatorBuilder<Weapon, WeaponProficiencyData, ImmutableWeaponProficiencyData>
{
    @Nonnull
    @Override
    public WeaponProficiencyData create()
    {
        return new WeaponProficiencyData(value);
    }

    @Nonnull
    @Override
    public Optional<WeaponProficiencyData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<List<Weapon>> optional = dataHolder.get(MCDNDKeys.WEAPON_PROFICIENCIES);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<WeaponProficiencyData> build(@Nonnull DataView container)
    {
        Optional<List<Weapon>> optional = container.getObjectList(MCDNDKeys.WEAPON_PROFICIENCIES.getQuery(), Weapon.class);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }
}
