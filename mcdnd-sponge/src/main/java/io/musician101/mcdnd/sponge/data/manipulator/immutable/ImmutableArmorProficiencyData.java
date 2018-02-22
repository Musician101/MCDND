package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.ArmorProficiencyData;
import io.musician101.mcdnd.sponge.equipment.armor.Armor;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableListData;

public class ImmutableArmorProficiencyData extends AbstractImmutableListData<Armor, ImmutableArmorProficiencyData, ArmorProficiencyData> {

    public ImmutableArmorProficiencyData(List<Armor> value) {
        super(value, MCDNDKeys.ARMOR_PROFICIENCIES);
    }

    @Nonnull
    @Override
    public ArmorProficiencyData asMutable() {
        return new ArmorProficiencyData(getValue());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
