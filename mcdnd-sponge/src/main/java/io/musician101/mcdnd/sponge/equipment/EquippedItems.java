package io.musician101.mcdnd.sponge.equipment;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.armor.Armor;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapon;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class EquippedItems implements DataSerializable
{
    private Armor armor;
    private Armor shield;
    private Weapon mainHand;
    private Weapon offHand;

    public Armor getArmor()
    {
        return armor;
    }

    public Weapon getMainHand()
    {
        return mainHand;
    }

    public Weapon getOffHand()
    {
        return offHand;
    }

    public Armor getShield()
    {
        return shield;
    }

    public void setArmor(Armor armor)
    {
        this.armor = armor;
    }

    public void setMainHand(Weapon mainHand)
    {
        this.mainHand = mainHand;
    }

    public void setOffHand(Weapon offHand)
    {
        this.offHand = offHand;
    }

    public void setShield(Armor shield)
    {
        this.shield = shield;
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.ARMOR, armor)
                .set(MCDNDKeys.SHIELD, shield)
                .set(MCDNDKeys.MAIN_HAND, mainHand)
                .set(MCDNDKeys.OFF_HAND, offHand);
    }
}
