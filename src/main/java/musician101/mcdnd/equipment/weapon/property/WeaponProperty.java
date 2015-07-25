package musician101.mcdnd.equipment.weapon.property;

import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.util.Interfaces.Named;

public class WeaponProperty implements Named
{
	String name;
	
	public WeaponProperty(String name)
	{
		this.name = name;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	public static abstract class RangeWeaponProperty extends WeaponProperty
	{
		int max;
		int min;
		
		protected RangeWeaponProperty(String name, int min, int max)
		{
			super(name + " (range " + min + "/" + max + ")");
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
	
	public static class AmmunitionWeaponProperty extends RangeWeaponProperty
	{
		public AmmunitionWeaponProperty(int min, int max)
		{
			super("Ammunition", min, max);
		}
	}
	
	public static class ThrownWeaponProperty extends RangeWeaponProperty
	{
		public ThrownWeaponProperty(int min, int max)
		{
			super("Thrown", min, max);
		}
	}
	
	public static class VersatileWeaponProperty extends WeaponProperty
	{
		Dice dice;
		
		public VersatileWeaponProperty(Dice dice)
		{
			super("Versatile (" + dice.toString() + ")");
			this.dice = dice;
		}
		
		public Dice getDice()
		{
			return dice;
		}
	}
}
