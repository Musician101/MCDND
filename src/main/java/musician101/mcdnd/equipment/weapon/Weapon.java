package musician101.mcdnd.equipment.weapon;

import java.util.ArrayList;
import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.equipment.Equipment;
import musician101.mcdnd.equipment.weapon.property.WeaponProperty;
import musician101.mcdnd.util.Interfaces.DamageDealer;

public class Weapon extends Equipment implements DamageDealer
{
	Damage damage;
	List<WeaponProperty> properties;
	WeaponType type;
	
	protected Weapon(String name, Cost cost, Damage damage, double weight, WeaponType type)
	{
		this(name, cost, damage, weight, new ArrayList<WeaponProperty>(), type);
	}
	
	protected Weapon(String name, Cost cost, Damage damage, double weight, List<WeaponProperty> properties, WeaponType type)
	{
		super(name, cost, weight);
		this.damage = damage;
		this.properties = properties;
		this.type = type;
	}
	
	@Override
	public Damage getDamage()
	{
		return damage;
	}
	
	public int rollDamage(AbilityScore score)
	{
		return rollDamage(score, true);
	}
	
	public int rollDamage(AbilityScore score, boolean hasProficiency)
	{
		int mod = 0;
		if (hasProficiency)
			mod += 2;
		
		mod += score.getAmount();
		return damage.rollDamage() + mod;
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
}