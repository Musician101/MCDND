package musician101.mcdnd.equipment.weapon.property;

import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.equipment.weapon.property.WeaponProperty.AmmunitionWeaponProperty;
import musician101.mcdnd.equipment.weapon.property.WeaponProperty.ThrownWeaponProperty;
import musician101.mcdnd.equipment.weapon.property.WeaponProperty.VersatileWeaponProperty;

public class WeaponProperties
{
	public static final WeaponProperty AMMUNITION_25_100 = new AmmunitionWeaponProperty(25, 100);
	public static final WeaponProperty AMMUNITION_30_120 = new AmmunitionWeaponProperty(30, 120);
	public static final WeaponProperty AMMUNITION_80_320 = new AmmunitionWeaponProperty(80, 320);
	public static final WeaponProperty AMMUNITION_100_400 = new AmmunitionWeaponProperty(100, 400);
	public static final WeaponProperty AMMUNITION_150_600 = new AmmunitionWeaponProperty(150, 600);
	public static final WeaponProperty FINESSE = new WeaponProperty("Finesse");
	public static final WeaponProperty HEAVY = new WeaponProperty("Heavy");
	public static final WeaponProperty LIGHT = new WeaponProperty("Light");
	public static final WeaponProperty LOADING = new WeaponProperty("Loading");
	public static final WeaponProperty REACH = new WeaponProperty("Reach");
	public static final WeaponProperty THROWN_5_15 = new ThrownWeaponProperty(5, 15);
	public static final WeaponProperty THROWN_20_60 = new ThrownWeaponProperty(20, 60);
	public static final WeaponProperty THROWN_30_120 = new ThrownWeaponProperty(30, 120);
	public static final WeaponProperty TWO_HANDED = new WeaponProperty("Two-handed");
	public static final WeaponProperty SPECIAL = new WeaponProperty("Special");
	public static final WeaponProperty VERSATILE_D8 = new VersatileWeaponProperty(new Dice(8));
	public static final WeaponProperty VERSATILE_D10 = new VersatileWeaponProperty(new Dice(10));
}
