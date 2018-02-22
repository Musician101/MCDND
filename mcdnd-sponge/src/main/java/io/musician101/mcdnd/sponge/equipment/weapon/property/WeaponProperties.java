package io.musician101.mcdnd.sponge.equipment.weapon.property;

import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.equipment.weapon.property.WeaponProperty.RangeWeaponProperty;
import io.musician101.mcdnd.sponge.equipment.weapon.property.WeaponProperty.VersatileWeaponProperty;

public class WeaponProperties {

    public static final WeaponProperty AMMUNITION = new WeaponProperty("Ammunition", "You can use a weapon that has the ammunition property to make a ranged attack only if you have ammunition to fire the weapon. Each time you attack with the weapon, you expend one piece of ammunition. Drawing the ammunition from a quiver case, or other container is part of the attack. At the end of the battle, you can recover half your expended ammunition by taking a minute to search the battle field.", "If you use a weapon that has the ammunition property to make a melee attack, you treat the weapon as an improvised weapon. A sling must be loaded to deal any damage when used in this way.");
    public static final WeaponProperty FINESSE = new WeaponProperty("Finesse", "When making an attack with a finesse weapon, you use your choice of your Strength or Dexterity modifier for the attack and damage rolls. You must use the same modifier for both rolls.");
    public static final WeaponProperty HEAVY = new WeaponProperty("Heavy", "Small creatures have disadvantage on attack rolls with heavy weapons. A heavy weapon's size and bulk make it too large for a Small creature to use effectively.");
    public static final WeaponProperty LIGHT = new WeaponProperty("Light", "A light weapon is small and easy to handle, making it ideal for use when fighting with two weapons.");
    public static final WeaponProperty LOADING = new WeaponProperty("Loading", "Because of the time required to load this weapon, you can fire only one piece of ammunition from it when you use an action, bonus action, or reaction to fire it, regardless of the number of attacks you can normally make.");
    public static final WeaponProperty RANGE_100_400 = new RangeWeaponProperty(100, 400);
    public static final WeaponProperty RANGE_150_600 = new RangeWeaponProperty(150, 600);
    public static final WeaponProperty RANGE_20_60 = new RangeWeaponProperty(20, 60);
    public static final WeaponProperty RANGE_25_100 = new RangeWeaponProperty(25, 100);
    public static final WeaponProperty RANGE_30_120 = new RangeWeaponProperty(30, 120);
    public static final WeaponProperty RANGE_5_15 = new RangeWeaponProperty(5, 15);
    public static final WeaponProperty RANGE_80_320 = new RangeWeaponProperty(80, 320);
    public static final WeaponProperty REACH = new WeaponProperty("Reach", "This weapon adds 5 feet to you reach when you attack with it.");
    public static final WeaponProperty SPECIAL_LANCE = new WeaponProperty("Special", "You have disadvantage when you use a lance to attack a target within 5 feet of you. Also, a lance requires two hands to wield when you aren't mounted.");
    public static final WeaponProperty SPECIAL_NET = new WeaponProperty("Special", "A Large or smaller creature hit by a net is restrained until it is freed. A net has no effect on creatures that are formless, or creatures that are Huge or larger. A creature can use its action to make a DC 10 Strength check, freeing itself or another creature within its reach on a success. Dealing 5 slashing damage to the net (AC 10) also frees the creature without harming it, ending the effect and destroying the net.", "When you use an action, bonus action, or reaction to attack with a net, you can make only one attack regardless of the number of attacks you can normally make.");
    public static final WeaponProperty THROWN = new WeaponProperty("Thrown", "If a weapon has the thrown property, you can throw the weapon to make a ranged attack. If the weapon is a melee weapon, you use the same ability modifier for that attack roll and damage roll that you would use for a melee attack with the weapon.");
    public static final WeaponProperty TWO_HANDED = new WeaponProperty("Two-handed", "This weapon requires two hands to use.");
    public static final WeaponProperty VERSATILE_D10 = new VersatileWeaponProperty(new Dice(10));
    public static final WeaponProperty VERSATILE_D8 = new VersatileWeaponProperty(new Dice(8));
}
