package musician101.mcdnd.equipment.gear;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.equipment.Equipment;

public class Gear extends Equipment
{
	Cost cost;
	double amount;
	double weight;
	String name;
	
	public Gear(String name, Cost cost, double weight)
	{
		super(name, cost, weight);
	}
	
	public static class AmmunitionGear extends BundledGear
	{
		public AmmunitionGear(String name, double amount, Cost cost, double weight)
		{
			super(name + " (" + (int) amount + ")", amount, cost, weight);
		}
	}
	
	public static class ArcaneFocusGear extends Gear
	{
		public ArcaneFocusGear(String name, Cost cost, double weight)
		{
			super("Arcane Focus (" + name + ")", cost, weight);
		}
	}
	
	public static class BundledGear extends Gear
	{
		double amount;
		
		public BundledGear(String name, double amount, Cost cost, double weight)
		{
			super(name, cost, weight);
		}
		
		public double getAmount()
		{
			return amount;
		}
	}
	
	public static class DruidicFocusGear extends Gear
	{
		public DruidicFocusGear(String name, Cost cost, double weight)
		{
			super("Druidic Focus (" + name + ")", cost, weight);
		}
	}
}
