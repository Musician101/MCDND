package io.musician101.mcdnd.sponge.equipment;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.armor.Armor;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapon;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public class EquippedItems implements DataSerializable {

    private Armor armor;
    private Weapon mainHand;
    private Weapon offHand;
    private Armor shield;

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public Weapon getMainHand() {
        return mainHand;
    }

    public void setMainHand(Weapon mainHand) {
        this.mainHand = mainHand;
    }

    public Weapon getOffHand() {
        return offHand;
    }

    public void setOffHand(Weapon offHand) {
        this.offHand = offHand;
    }

    public Armor getShield() {
        return shield;
    }

    public void setShield(Armor shield) {
        this.shield = shield;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.ARMOR, armor).set(MCDNDKeys.SHIELD, shield).set(MCDNDKeys.MAIN_HAND, mainHand).set(MCDNDKeys.OFF_HAND, offHand);
    }
}
