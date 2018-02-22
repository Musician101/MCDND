package io.musician101.mcdnd.sponge.equipment.armor;

import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorType;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;

public class Armor extends Equipment {

    private final int armorClass;
    private final boolean stealthDisadvantage;
    private final int strength;
    private final MCDNDArmorType type;

    public Armor(String name, MCDNDArmorType type, Cost cost, int armorClass, int strength, boolean stealthDisadvantage, int weight) {
        super(name, cost, weight);
        this.type = type;
        this.armorClass = armorClass;
        this.strength = strength;
        this.stealthDisadvantage = stealthDisadvantage;
    }

    public int getArmorClass() {
        return armorClass;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public int getStrengthRequirement() {
        return strength;
    }

    public MCDNDArmorType getType() {
        return type;
    }

    public boolean hasStealthDisadvantage() {
        return stealthDisadvantage;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(MCDNDKeys.ARMOR_TYPE, type).set(MCDNDKeys.STEALTH_DISADVANTAGE, stealthDisadvantage).set(MCDNDKeys.ARMOR_CLASS, armorClass).set(MCDNDKeys.REQUIRED_STRENGTH, strength);
    }
}
