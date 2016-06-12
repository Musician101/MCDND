package io.musician101.sponge.mcdnd.equipment.weapon.property;

import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;

public class WeaponProperty implements Described, Named
{
    private final String[] description;
    private final String name;

    public WeaponProperty(String name, String... description)
    {
        this.name = name;
        this.description = description;
    }

    @Override
    public String[] getDescription()
    {
        return description;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public static class RangeWeaponProperty extends WeaponProperty
    {
        final int max;
        final int min;

        public RangeWeaponProperty(int min, int max)
        {
            super("Range (" + min + "/" + max + ")", "The range property lists two numbers in parentheses next to it. The first number is the weapon's normal range in feet, and the second indicates the weapon's maximum range. When attacking a target beyond normal range, you have disadvantage on the attack roll. You can't attack a target beyond the weapon's long range.");
            this.min = min;
            this.max = max;
        }

        public int getMaxRange()
        {
            return max;
        }

        public int getMinRange()
        {
            return min;
        }
    }

    public static class VersatileWeaponProperty extends WeaponProperty
    {
        final Dice dice;

        public VersatileWeaponProperty(Dice dice)
        {
            super("Versatile (" + dice.toString() + ")", "This weapon can be used with one or two hands. A damage value in parentheses appears with the property-the damage when the weapon is used with two hands to make a melee attack.");
            this.dice = dice;
        }

        public Dice getDice()
        {
            return dice;
        }
    }
}
