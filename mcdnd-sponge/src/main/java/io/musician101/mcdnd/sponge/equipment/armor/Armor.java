package io.musician101.mcdnd.sponge.equipment.armor;

import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorType;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import org.spongepowered.api.data.DataContainer;

import javax.annotation.Nonnull;

public class Armor extends Equipment
{
    private final MCDNDArmorType type;
    private final boolean stealthDisadvantage;
    private final int armorClass;
    private final int strength;

    public Armor(String name, MCDNDArmorType type, Cost cost, int armorClass, int strength, boolean stealthDisadvantage, int weight)
    {
        super(name, cost, weight);
        this.type = type;
        this.armorClass = armorClass;
        this.strength = strength;
        this.stealthDisadvantage = stealthDisadvantage;
    }

    public MCDNDArmorType getType()
    {
        return type;
    }

    public boolean hasStealthDisadvantage()
    {
        return stealthDisadvantage;
    }

    public int getArmorClass()
    {
        return armorClass;
    }

    public int getStrengthRequirement()
    {
        return strength;
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
        return super.toContainer()
                .set(MCDNDKeys.ARMOR_TYPE, type)
                .set(MCDNDKeys.STEALTH_DISADVANTAGE, stealthDisadvantage)
                .set(MCDNDKeys.ARMOR_CLASS, armorClass)
                .set(MCDNDKeys.REQUIRED_STRENGTH, strength);
    }
}
