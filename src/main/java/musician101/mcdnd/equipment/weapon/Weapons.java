package musician101.mcdnd.equipment.weapon;

import java.util.Arrays;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.currency.CurrencyType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.equipment.weapon.Weapon.WeaponType;
import musician101.mcdnd.equipment.weapon.property.WeaponProperties;
import musician101.mcdnd.util.CustomList;

public class Weapons
{
	public static final Weapon CLUB = new Weapon("Club", new Cost(CurrencyType.SILVER, 1), new Damage(DamageType.BLUDGEONING, new Dice(4)), 2, Arrays.asList(WeaponProperties.LIGHT), WeaponType.SIMPLE_MELEE);
	public static final Weapon DAGGER = new Weapon("Dagger", new Cost(CurrencyType.GOLD, 2), new Damage(DamageType.PIERCING, new Dice(4)), 1, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.LIGHT, WeaponProperties.THROWN, WeaponProperties.RANGE_20_60), WeaponType.SIMPLE_MELEE);
	public static final Weapon GREATCLUB = new Weapon("Greatclub", new Cost(CurrencyType.SILVER, 2), new Damage(DamageType.BLUDGEONING, new Dice(8)), 10, Arrays.asList(WeaponProperties.TWO_HANDED), WeaponType.SIMPLE_MELEE);
	public static final Weapon HANDAXE = new Weapon("Handaxe", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.SLASHING, new Dice(6)), 2, Arrays.asList(WeaponProperties.LIGHT, WeaponProperties.THROWN, WeaponProperties.RANGE_20_60), WeaponType.SIMPLE_MELEE);
	public static final Weapon JAVELIN = new Weapon("Javelin", new Cost(CurrencyType.SILVER, 5), new Damage(DamageType.PIERCING, new Dice(6)), 2, Arrays.asList(WeaponProperties.THROWN, WeaponProperties.RANGE_30_120), WeaponType.SIMPLE_MELEE);
	public static final Weapon LIGHT_HAMMER = new Weapon("Light Hammer", new Cost(CurrencyType.GOLD, 2), new Damage(DamageType.BLUDGEONING, new Dice(4)), 2, Arrays.asList(WeaponProperties.LIGHT, WeaponProperties.THROWN, WeaponProperties.RANGE_20_60), WeaponType.SIMPLE_MELEE);
	public static final Weapon MACE = new Weapon("Mace", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.BLUDGEONING, new Dice(6)), 4, WeaponType.SIMPLE_MELEE);
	public static final Weapon QUARTERSTAFF = new Weapon("Quarterstaff", new Cost(CurrencyType.SILVER, 2), new Damage(DamageType.BLUDGEONING, new Dice(6)), 4, Arrays.asList(WeaponProperties.VERSATILE_D8), WeaponType.SIMPLE_MELEE);
	public static final Weapon SICKLE = new Weapon("Sickle", new Cost(CurrencyType.GOLD, 1), new Damage(DamageType.SLASHING, new Dice(4)), 2, Arrays.asList(WeaponProperties.LIGHT), WeaponType.SIMPLE_MELEE);
	public static final Weapon SPEAR = new Weapon("Spear", new Cost(CurrencyType.GOLD, 1), new Damage(DamageType.PIERCING, new Dice(6)), 3, Arrays.asList(WeaponProperties.THROWN, WeaponProperties.RANGE_20_60, WeaponProperties.VERSATILE_D8), WeaponType.SIMPLE_MELEE);
	public static final Weapon UNARMED_STRIKE = new Weapon("Unarmed Strike", new Cost(), new Damage(DamageType.BLUDGEONING, new Dice(12)), 0, WeaponType.SIMPLE_MELEE);
	public static final Weapon LIGHT_CROSSBOW = new Weapon("Light Crossbow", new Cost(CurrencyType.GOLD, 25), new Damage(DamageType.PIERCING, new Dice(8)), 5, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_80_320, WeaponProperties.LOADING, WeaponProperties.TWO_HANDED), WeaponType.SIMPLE_RANGED);
	public static final Weapon DART = new Weapon("Dart", new Cost(CurrencyType.COPPER, 5), new Damage(DamageType.PIERCING, new Dice(4)), 0.25, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.THROWN, WeaponProperties.RANGE_20_60), WeaponType.SIMPLE_RANGED);
	public static final Weapon SHORTBOW = new Weapon("Shortbow", new Cost(CurrencyType.GOLD, 25), new Damage(DamageType.PIERCING, new Dice(6)), 2, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_80_320, WeaponProperties.TWO_HANDED), WeaponType.SIMPLE_RANGED);
	public static final Weapon SLING = new Weapon("Sling", new Cost(CurrencyType.SILVER, 1), new Damage(DamageType.BLUDGEONING, new Dice(4)), 0, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_30_120), WeaponType.SIMPLE_RANGED);
	public static final Weapon BATTLEAXE = new Weapon("Battleaxe", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.SLASHING, new Dice(8)), 4, Arrays.asList(WeaponProperties.VERSATILE_D10), WeaponType.MARTIAL_MELEE);
	public static final Weapon FLAIL = new Weapon("Flail", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.BLUDGEONING, new Dice(8)), 2, WeaponType.MARTIAL_MELEE);
	public static final Weapon GLAIVE = new Weapon("Glaive", new Cost(CurrencyType.GOLD, 20), new Damage(DamageType.SLASHING, new Dice(10)), 6, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.REACH, WeaponProperties.TWO_HANDED), WeaponType.MARTIAL_MELEE);
	public static final Weapon GREATAXE = new Weapon("Greateaxe", new Cost(CurrencyType.GOLD, 30), new Damage(DamageType.SLASHING, new Dice(12)), 7, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.TWO_HANDED), WeaponType.MARTIAL_MELEE);
	public static final Weapon GREATSWORD = new Weapon("Greatsword", new Cost(CurrencyType.GOLD, 50), new Damage(DamageType.SLASHING, new Dice(6, 2)), 6, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.TWO_HANDED), WeaponType.MARTIAL_MELEE);
	public static final Weapon HALBERD = new Weapon("Halberd", new Cost(CurrencyType.GOLD, 20), new Damage(DamageType.SLASHING, new Dice(10)), 6, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.REACH, WeaponProperties.TWO_HANDED), WeaponType.MARTIAL_MELEE);
	public static final Weapon LANCE = new Weapon("Lance", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.PIERCING, new Dice(12)), 6, Arrays.asList(WeaponProperties.REACH, WeaponProperties.SPECIAL_LANCE), WeaponType.MARTIAL_MELEE);
	public static final Weapon LONGSWORD = new Weapon("Longsword", new Cost(CurrencyType.GOLD, 15), new Damage(DamageType.SLASHING, new Dice(8)), 3, Arrays.asList(WeaponProperties.VERSATILE_D10), WeaponType.MARTIAL_MELEE);
	public static final Weapon MAUL = new Weapon("Maul", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.BLUDGEONING, new Dice(6, 2)), 10, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.TWO_HANDED), WeaponType.MARTIAL_MELEE);
	public static final Weapon MORNINGSTAR = new Weapon("Morningstar", new Cost(CurrencyType.GOLD, 15), new Damage(DamageType.PIERCING, new Dice(8)), 4, WeaponType.MARTIAL_MELEE);
	public static final Weapon PIKE = new Weapon("Pike", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.PIERCING, new Dice(10)), 18, Arrays.asList(WeaponProperties.HEAVY, WeaponProperties.REACH, WeaponProperties.TWO_HANDED), WeaponType.MARTIAL_MELEE);
	public static final Weapon RAPIER = new Weapon("Rapier", new Cost(CurrencyType.GOLD, 25), new Damage(DamageType.PIERCING, new Dice(8)), 2, Arrays.asList(WeaponProperties.FINESSE), WeaponType.MARTIAL_MELEE);
	public static final Weapon SCIMITAR = new Weapon("Scimitar", new Cost(CurrencyType.GOLD, 25), new Damage(DamageType.SLASHING, new Dice(6)), 3, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.LIGHT), WeaponType.MARTIAL_MELEE);
	public static final Weapon SHORTSWORD = new Weapon("Shortsword", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.PIERCING, new Dice(6)), 2, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.LIGHT), WeaponType.MARTIAL_MELEE);
	public static final Weapon TRIDENT = new Weapon("Trident", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.PIERCING, new Dice(6)), 4, Arrays.asList(WeaponProperties.THROWN, WeaponProperties.RANGE_20_60, WeaponProperties.VERSATILE_D8), WeaponType.MARTIAL_MELEE);
	public static final Weapon WAR_PICK = new Weapon("War Pick", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.PIERCING, new Dice(8)), 2, WeaponType.MARTIAL_MELEE);
	public static final Weapon WARHAMMER = new Weapon("Warhammer", new Cost(CurrencyType.GOLD, 15), new Damage(DamageType.BLUDGEONING, new Dice(8)), 2, Arrays.asList(WeaponProperties.VERSATILE_D10), WeaponType.MARTIAL_MELEE);
	public static final Weapon WHIP = new Weapon("Whip", new Cost(CurrencyType.GOLD, 2), new Damage(DamageType.SLASHING, new Dice(4)), 3, Arrays.asList(WeaponProperties.FINESSE, WeaponProperties.REACH), WeaponType.MARTIAL_MELEE);
	public static final Weapon BLOWGUN = new Weapon("Blowgun", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.PIERCING, new Dice(12)), 1, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_25_100, WeaponProperties.LOADING), WeaponType.MARTIAL_RANGED);
	public static final Weapon HAND_CROSSBOW = new Weapon("Hand Crossbow", new Cost(CurrencyType.GOLD, 75), new Damage(DamageType.PIERCING, new Dice(6)), 3, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_30_120, WeaponProperties.LIGHT, WeaponProperties.LOADING), WeaponType.MARTIAL_RANGED);
	public static final Weapon HEAVY_CROSSBOW = new Weapon("Heavy Crossbow", new Cost(CurrencyType.GOLD, 50), new Damage(DamageType.PIERCING, new Dice(10)), 18, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_100_400, WeaponProperties.HEAVY, WeaponProperties.LOADING, WeaponProperties.TWO_HANDED), WeaponType.MARTIAL_RANGED);
	public static final Weapon LONGBOW = new Weapon("Longbow", new Cost(CurrencyType.GOLD, 50), new Damage(DamageType.PIERCING, new Dice(8)), 2, Arrays.asList(WeaponProperties.AMMUNITION, WeaponProperties.RANGE_150_600, WeaponProperties.HEAVY, WeaponProperties.TWO_HANDED), WeaponType.MARTIAL_RANGED);
	public static final Weapon NET = new Weapon("Net", new Cost(CurrencyType.GOLD, 1), new Damage(DamageType.NONE, new Dice(1)), 3, Arrays.asList(WeaponProperties.SPECIAL_NET, WeaponProperties.THROWN, WeaponProperties.RANGE_5_15), WeaponType.MARTIAL_RANGED);
	
	public static CustomList<Weapon> getSimpleMeleeWeapons()
	{
		return new CustomList<Weapon>(CLUB, DAGGER, GREATCLUB, HANDAXE, JAVELIN, LIGHT_HAMMER, MACE, QUARTERSTAFF, SICKLE, SPEAR, UNARMED_STRIKE);
	}
	
	public static CustomList<Weapon> getSimpleRangedWeapons()
	{
		return new CustomList<Weapon>(LIGHT_CROSSBOW, DART, SHORTBOW, SLING);
	}
	
	public static CustomList<Weapon> getSimpleWeapons()
	{
		return new CustomList<Weapon>(getSimpleMeleeWeapons(), getSimpleRangedWeapons());
	}
	
	public static CustomList<Weapon> getMartialMeleeWeapons()
	{
		return new CustomList<Weapon>(BATTLEAXE, FLAIL, GLAIVE, GREATAXE, GREATSWORD, HALBERD, LANCE, LONGSWORD, MAUL, MORNINGSTAR, PIKE, RAPIER, SCIMITAR, SHORTSWORD, TRIDENT, WAR_PICK, WARHAMMER, WHIP);
	}
	
	public static CustomList<Weapon> getMartialRangedWeapons()
	{
		return new CustomList<Weapon>(BLOWGUN, HAND_CROSSBOW, HEAVY_CROSSBOW, LONGBOW, NET);
	}
	
	public static CustomList<Weapon> getMartialWeapons()
	{
		return new CustomList<Weapon>(getMartialMeleeWeapons(), getMartialRangedWeapons());
	}
	
	public static CustomList<Weapon> getAll()
	{
		return new CustomList<Weapon>(getSimpleWeapons(), getMartialWeapons());
	}
}
