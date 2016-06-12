package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.ArmorProficiencyData;
import io.musician101.sponge.mcdnd.equipment.armor.Armor;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableListData;

import javax.annotation.Nonnull;
import java.util.List;

public class ImmutableArmorProficiencyData extends AbstractImmutableListData<Armor, ImmutableArmorProficiencyData, ArmorProficiencyData>
{
    public ImmutableArmorProficiencyData(List<Armor> value)
    {
        super(value, MCDNDKeys.ARMOR_PROFICIENCIES);
    }

    @Nonnull
    @Override
    public ArmorProficiencyData asMutable()
    {
        return new ArmorProficiencyData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
