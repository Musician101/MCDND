package musician101.mcdnd.equipment;

import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.currency.CurrencyType;

public enum Armor
{
	PADDED("Padded", ArmorTypes.LIGHT, new Cost(CurrencyType.GOLD, 5), 11, 0, true, 8),
	LEATHER("Leather", ArmorTypes.LIGHT, new Cost(CurrencyType.GOLD, 10), 11, 0, false, 10),
	STUDDED_LEATHER("Studded Leather", ArmorTypes.LIGHT, new Cost(CurrencyType.GOLD, 45), 12, 0, false, 13),
	HIDE("Hide", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD, 10), 12, 0, false, 12),
	CHAIN_SHIRT("Chain Shirt", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD, 50), 13, 0, false, 20),
	SCALE_MAIL("Scale Mail", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD, 50), 14, 0, false, 20),
	BREASTPLATE("Breastplate", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD, 400), 14, 0, false, 20),
	HALF_PLATE("Half Plate", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD, 750), 15, 0, false, 20),
	RING_MAIL("Ring Mail", ArmorTypes.HEAVY, new Cost(CurrencyType.GOLD, 30), 14, 0, false, 20),
	CHAIN_MAIL("Chain Mail", ArmorTypes.HEAVY, new Cost(CurrencyType.GOLD, 75), 16, 0, false, 20),
	SPLINT("Splint", ArmorTypes.HEAVY ,new Cost(CurrencyType.GOLD, 200), 17, 0, false, 20),
	PLATE("Plate", ArmorTypes.HEAVY, new Cost(CurrencyType.GOLD, 1500), 18, 0, false, 20),
	NO_ARMOR("No Armor", ArmorTypes.UNARMORED, new Cost(), 11, 0, false, 0),
	SHIELD("Shield", ArmorTypes.SHIELD, new Cost(CurrencyType.GOLD, 10), 2, 0, false, 20),
	NO_SHIELD("No Shield", ArmorTypes.UNARMORED, new Cost(), 0, 0, false, 0);
	
	ArmorTypes type;
	boolean stealthDisadvantage;
	Cost cost;
	int armorClass;
	int strength;
	int weight;
	String name;
	
	private Armor(String name, ArmorTypes type, Cost cost, int armorClass, int strength, boolean stealthDisadvantage, int weight)
	{
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.armorClass = armorClass;
		this.strength = strength;
		this.stealthDisadvantage = stealthDisadvantage;
		this.weight = weight;
	}
	
	public ArmorTypes getType()
	{
		return type;
	}
	
	public boolean hasStealthDisadvantage()
	{
		return stealthDisadvantage;
	}
	
	public Cost getCost()
	{
		return cost;
	}
	
	public int getArmorClass()
	{
		return armorClass;
	}
	
	public int getStrengthRequirement()
	{
		return strength;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public String getName()
	{
		return name;
	}
	
	public static enum ArmorTypes
	{
		LIGHT(Arrays.asList(PADDED, LEATHER, STUDDED_LEATHER)),
		MEDIUM(Arrays.asList(HIDE, CHAIN_SHIRT, SCALE_MAIL, BREASTPLATE, HALF_PLATE)),
		HEAVY(Arrays.asList(RING_MAIL, CHAIN_MAIL, SPLINT, PLATE)),
		SHIELD(Arrays.asList(Armor.SHIELD)),
		UNARMORED;
		
		List<Armor> armor;
		
		private ArmorTypes()
		{
			this(null);
		}
		
		private ArmorTypes(List<Armor> armor)
		{
			this.armor = armor;
		}
		
		public List<Armor> getArmor()
		{
			return armor;
		}
	}
}
