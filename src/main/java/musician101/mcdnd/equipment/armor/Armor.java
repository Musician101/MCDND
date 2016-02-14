package musician101.mcdnd.equipment.armor;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.equipment.Equipment;

public class Armor extends Equipment
{
    private final ArmorTypes type;
    private final boolean stealthDisadvantage;
    private final int armorClass;
    private final int strength;
    Cost cost;
    int weight;
    String name;

    public Armor(String name, ArmorTypes type, Cost cost, int armorClass, int strength, boolean stealthDisadvantage,
                 int weight)
    {
        super(name, cost, weight);
        this.type = type;
        this.armorClass = armorClass;
        this.strength = strength;
        this.stealthDisadvantage = stealthDisadvantage;
    }

    public ArmorTypes getType()
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

    public enum ArmorTypes
    {
        LIGHT,
        MEDIUM,
        HEAVY,
        SHIELD,
        UNARMORED
    }
}
