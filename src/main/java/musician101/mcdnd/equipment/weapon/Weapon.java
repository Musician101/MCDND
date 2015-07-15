package musician101.mcdnd.equipment.weapon;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;

public abstract class Weapon
{
	AbilityScores scoreType;
	DamageType damageType;
	Dice damage;
	String name;
	
	protected Weapon(String name, DamageType damageType, Dice damage, AbilityScores scoreType)
	{
		this.name = name;
		this.damageType = damageType;
		this.damage = damage;
		this.scoreType = scoreType;
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
		return damage.roll() + mod;
	}
}
