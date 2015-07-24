package musician101.mcdnd.equipment.weapon;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.equipment.Equipment;
import musician101.mcdnd.util.Interfaces.DamageDealer;

public class Weapon extends Equipment implements DamageDealer
{
	AbilityScores scoreType;
	Damage damage;
	
	protected Weapon(String name, Cost cost, double weight, DamageType damageType, Dice dice, AbilityScores scoreType)
	{
		super(name, cost, weight);
		this.damage = new Damage(damageType, dice);
		this.scoreType = scoreType;
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
		
		if (scoreType != score.getType())
			throw new IllegalArgumentException("Incorrect score type.");
		
		mod += score.getAmount();
		return damage.rollDamage() + mod;
	}
}
