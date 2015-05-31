package musician101.mcdnd.gear.weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.currency.Currency.CurrencyType;
import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.dice.Dice.DiceType;

public enum Weapons
{
	CLUB("Club", new Cost(CurrencyType.SILVER, 1), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D4)), 2, Arrays.asList(Property.LIGHT), WeaponType.SIMPLE_MELEE),
	DAGGER("Dagger", new Cost(CurrencyType.GOLD, 2), new Damage(DamageType.PIERCING, new Dice(DiceType.D4)), 1, Arrays.asList(Property.FINESSE, Property.LIGHT, Property.THROWN_20_60), WeaponType.SIMPLE_MELEE),
	GREATCLUB("Greatclub", new Cost(CurrencyType.SILVER, 2), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D8)), 10, Arrays.asList(Property.TWO_HANDED), WeaponType.SIMPLE_MELEE),
	HANDAXE("Handaxe", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.SLASHING, new Dice(DiceType.D6)), 2, Arrays.asList(Property.LIGHT, Property.THROWN_20_60), WeaponType.SIMPLE_MELEE),
	JAVELIN("Javelin", new Cost(CurrencyType.SILVER, 5), new Damage(DamageType.PIERCING, new Dice(DiceType.D6)), 2, Arrays.asList(Property.THROWN_30_120), WeaponType.SIMPLE_MELEE),
	LIGHT_HAMMER("Light Hammer", new Cost(CurrencyType.GOLD, 2), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D4)), 2, Arrays.asList(Property.LIGHT, Property.THROWN_20_60), WeaponType.SIMPLE_MELEE),
	MACE("Mace", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D6)), 4, new ArrayList<Property>(), WeaponType.SIMPLE_MELEE),
	QUARTERSTAFF("Quarterstaff", new Cost(CurrencyType.SILVER, 2), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D6)), 4, Arrays.asList(Property.VERSATILE_D8), WeaponType.SIMPLE_MELEE),
	SICKLE("Sickle", new Cost(CurrencyType.GOLD, 1), new Damage(DamageType.SLASHING, new Dice(DiceType.D4)), 2, Arrays.asList(Property.LIGHT), WeaponType.SIMPLE_MELEE),
	SPEAR("Spear", new Cost(CurrencyType.GOLD, 1), new Damage(DamageType.PIERCING, new Dice(DiceType.D6)), 3, Arrays.asList(Property.THROWN_20_60, Property.VERSATILE_D8), WeaponType.SIMPLE_MELEE),
	UNARMED_STRIKE("Unarmed Strike", new Cost(), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D12)), 0, new ArrayList<Property>(), WeaponType.SIMPLE_MELEE),
	LIGHT_CROSSBOW("Light Crossbow", new Cost(CurrencyType.GOLD, 25), new Damage(DamageType.PIERCING, new Dice(DiceType.D8)), 5, Arrays.asList(Property.AMMUNITION_80_320, Property.LOADING, Property.TWO_HANDED), WeaponType.SIMPLE_RANGED),
	DART("Dart", new Cost(CurrencyType.COPPER, 5), new Damage(DamageType.PIERCING, new Dice(DiceType.D4)), 0.25, Arrays.asList(Property.FINESSE, Property.THROWN_20_60), WeaponType.SIMPLE_RANGED),
	SHORTBOW("Shortbow", new Cost(CurrencyType.GOLD, 25), new Damage(DamageType.PIERCING, new Dice(DiceType.D6)), 2, Arrays.asList(Property.AMMUNITION_80_320, Property.TWO_HANDED), WeaponType.SIMPLE_RANGED),
	SLING("Sling", new Cost(CurrencyType.SILVER, 1), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D4)), 0, Arrays.asList(Property.AMMUNITION_30_120), WeaponType.SIMPLE_RANGED),
	BATTLEAXE("Battleaxe", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.SLASHING, new Dice(DiceType.D8)), 4, Arrays.asList(Property.VERSATILE_D10), WeaponType.MARTIAL_MELEE),
	FLAIL("Flail", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D8)), 2, new ArrayList<Property>(), WeaponType.MARTIAL_MELEE),
	GLAIVE("Glaive", new Cost(CurrencyType.GOLD, 20), new Damage(DamageType.SLASHING, new Dice(DiceType.D10)), 6, Arrays.asList(Property.HEAVY, Property.REACH, Property.TWO_HANDED), WeaponType.MARTIAL_MELEE),
	GREATAXE("Greateaxe", new Cost(CurrencyType.GOLD, 30), new Damage(DamageType.SLASHING, new Dice(DiceType.D12)), 7, Arrays.asList(Property.HEAVY, Property.TWO_HANDED), WeaponType.MARTIAL_MELEE),
	GREATSWORD("Greatsword", new Cost(CurrencyType.GOLD, 50), new Damage(DamageType.SLASHING, new Dice(DiceType.D6, 2)), 6, Arrays.asList(Property.HEAVY, Property.TWO_HANDED), WeaponType.MARTIAL_MELEE),
	HALBERD("Halberd", new Cost(CurrencyType.GOLD, 20), new Damage(DamageType.SLASHING, new Dice(DiceType.D10)), 6, Arrays.asList(Property.HEAVY, Property.REACH, Property.TWO_HANDED), WeaponType.MARTIAL_MELEE),
	LANCE("Lance", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.PIERCING, new Dice(DiceType.D12)), 6, Arrays.asList(Property.REACH, Property.SPECIAL), WeaponType.MARTIAL_MELEE),
	LONGSWORD("Longsword", new Cost(CurrencyType.GOLD, 15), new Damage(DamageType.SLASHING, new Dice(DiceType.D8)), 3, Arrays.asList(Property.VERSATILE_D10), WeaponType.MARTIAL_MELEE),
	MAUL("Maul", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D6, 2)), 10, Arrays.asList(Property.HEAVY, Property.TWO_HANDED), WeaponType.MARTIAL_MELEE),
	MORNINGSTAR("Morningstar", new Cost(CurrencyType.GOLD, 15), new Damage(DamageType.PIERCING, new Dice(DiceType.D8)), 4, new ArrayList<Property>(), WeaponType.MARTIAL_MELEE),
	PIKE("Pike", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.PIERCING, new Dice(DiceType.D10)), 18, Arrays.asList(Property.HEAVY, Property.REACH, Property.TWO_HANDED), WeaponType.MARTIAL_MELEE),
	RAPIER("Rapier", new Cost(CurrencyType.GOLD, 25), new Damage(DamageType.PIERCING, new Dice(DiceType.D8)), 2, Arrays.asList(Property.FINESSE), WeaponType.MARTIAL_MELEE),
	SCIMITAR("Scimitar", new Cost(CurrencyType.GOLD, 25), new Damage(DamageType.SLASHING, new Dice(DiceType.D6)), 3, Arrays.asList(Property.FINESSE, Property.LIGHT), WeaponType.MARTIAL_MELEE),
	SHORTSWORD("Shortsword", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.PIERCING, new Dice(DiceType.D6)), 2, Arrays.asList(Property.FINESSE, Property.LIGHT), WeaponType.MARTIAL_MELEE),
	TRIDENT("Trident", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.PIERCING, new Dice(DiceType.D6)), 4, Arrays.asList(Property.THROWN_20_60, Property.VERSATILE_D8), WeaponType.MARTIAL_MELEE),
	WAR_PICK("War Pick", new Cost(CurrencyType.GOLD, 5), new Damage(DamageType.PIERCING, new Dice(DiceType.D8)), 2, new ArrayList<Property>(), WeaponType.MARTIAL_MELEE),
	WARHAMMER("Warhammer", new Cost(CurrencyType.GOLD, 15), new Damage(DamageType.BLUDGEONING, new Dice(DiceType.D8)), 2, Arrays.asList(Property.VERSATILE_D10), WeaponType.MARTIAL_MELEE),
	WHIP("Whip", new Cost(CurrencyType.GOLD, 2), new Damage(DamageType.SLASHING, new Dice(DiceType.D4)), 3, Arrays.asList(Property.FINESSE, Property.REACH), WeaponType.MARTIAL_MELEE),
	BLOWGUN("Blowgun", new Cost(CurrencyType.GOLD, 10), new Damage(DamageType.PIERCING, new Dice(DiceType.D12)), 1, Arrays.asList(Property.AMMUNITION_25_100, Property.LOADING), WeaponType.MARTIAL_RANGED),
	HAND_CROSSBOW("Hand Crossbow", new Cost(CurrencyType.GOLD, 75), new Damage(DamageType.PIERCING, new Dice(DiceType.D6)), 3, Arrays.asList(Property.AMMUNITION_30_120, Property.LIGHT, Property.LOADING), WeaponType.MARTIAL_RANGED),
	HEAVY_CROSSBOW("Heavy Crossbow", new Cost(CurrencyType.GOLD, 50), new Damage(DamageType.PIERCING, new Dice(DiceType.D10)), 18, Arrays.asList(Property.AMMUNITION_100_400, Property.HEAVY, Property.LOADING, Property.TWO_HANDED), WeaponType.MARTIAL_RANGED),
	LONGBOW("Longbow", new Cost(CurrencyType.GOLD, 50), new Damage(DamageType.PIERCING, new Dice(DiceType.D8)), 2, Arrays.asList(Property.AMMUNITION_150_600, Property.HEAVY, Property.TWO_HANDED), WeaponType.MARTIAL_RANGED),
	NET("Net", new Cost(CurrencyType.GOLD, 1), new Damage(DamageType.NONE, new Dice(DiceType.D1)), 3, Arrays.asList(Property.SPECIAL, Property.THROWN_5_15), WeaponType.MARTIAL_RANGED);
	
	Cost cost;
	Damage damage;
	double weight;
	List<Property> properties;
	String name;
	WeaponType type;
	
	private Weapons(String name, Cost cost, Damage damage, double weight, List<Property> properties, WeaponType type)
	{
		this.name = name;
		this.cost = cost;
		this.damage = damage;
		this.weight = weight;
		this.properties = properties;
	}
	
	public Cost getCost()
	{
		return cost;
	}
	
	public Damage getDamage()
	{
		return damage;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public List<Property> getProperties()
	{
		return properties;
	}
	
	public String getName()
	{
		return name;
	}
	
	public WeaponType getType()
	{
		return type;
	}
	
	public static enum WeaponType
	{
		SIMPLE_MELEE("Simple Melee Weapon"),
		SIMPLE_RANGED("Simple Ranged Weapon"),
		MARTIAL_MELEE("Martial Melee Weapon"),
		MARTIAL_RANGED("Martial Ranged Weapon");
		
		String name;
		
		private WeaponType(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
	
	public static enum Property
	{
		AMMUNITION_25_100("Ammunition (range 25/100)", new Range(25, 100)),
		AMMUNITION_30_120("Ammunition (range 30/120)", new Range(30, 120)),
		AMMUNITION_80_320("Ammunition (range 80/320)", new Range(80, 320)),
		AMMUNITION_100_400("Ammunition (range 100/400)", new Range(100, 400)),
		AMMUNITION_150_600("Ammunition (range 150/600)", new Range(150, 600)),
		FINESSE("Finesse"),
		HEAVY("Heavy"),
		LIGHT("Light"),
		LOADING("Loading"),
		REACH("Reach"),
		THROWN_5_15("Thrown (range 5/15)", new Range(5, 15)),
		THROWN_20_60("Thrown (range 20/60)", new Range(20, 60)),
		THROWN_30_120("Thrown (range 30/120)", new Range(30, 120)),
		TWO_HANDED("Two-handed"),
		SPECIAL("Special"),
		VERSATILE_D8("Versatile (1d8)", new Dice(DiceType.D8)),
		VERSATILE_D10("Versatile (1d10)", new Dice(DiceType.D10));
		
		Dice versatileDice;
		Range range;
		String name;
		
		private Property(String name)
		{
			this.name = name;
		}
		
		private Property(String name, Range range)
		{
			this(name);
			this.range = range;
		}
		
		private Property(String name, Dice versatileDice)
		{
			this(name);
			this.versatileDice = versatileDice;
		}
		
		public Dice getDice()
		{
			return versatileDice;
		}
		
		public String getName()
		{
			return name;
		}
	}
	
	public static class Range
	{
		int min;
		int max;
		
		public Range(int min, int max)
		{
			this.min = min;
			this.max = max;
		}
		
		public int getMin()
		{
			return min;
		}
		
		public int getMax()
		{
			return max;
		}
	}
}
