package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.WeaponProficiencyData;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapon;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableListData;

import java.util.List;

public class ImmutableWeaponProficiencyData extends AbstractImmutableListData<Weapon, ImmutableWeaponProficiencyData, WeaponProficiencyData>
{
    public ImmutableWeaponProficiencyData(List<Weapon> value)
    {
        super(value, MCDNDKeys.WEAPON_PROFICIENCIES);
    }

    @Override
    public WeaponProficiencyData asMutable()
    {
        return new WeaponProficiencyData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
