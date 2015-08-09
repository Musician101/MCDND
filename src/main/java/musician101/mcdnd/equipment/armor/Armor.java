package musician101.mcdnd.equipment.armor;

import java.util.List;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.equipment.Equipment;

public class Armor extends Equipment
{
	ArmorTypes type;
	boolean stealthDisadvantage;
	Cost cost;
	int armorClass;
	int strength;
	int weight;
	String name;
	
	public Armor(String name, ArmorTypes type, Cost cost, int armorClass, int strength, boolean stealthDisadvantage, int weight)
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
	
	public static enum ArmorTypes
	{
		LIGHT(),
		MEDIUM(),
		HEAVY(),
		SHIELD(),
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
