package musician101.mcdnd.combat;

import musician101.mcdnd.dice.Dice;

public class Damage
{
	DamageType type;
	Dice dice;
	
	public Damage(DamageType type, Dice dice)
	{
		this.type = type;
		this.dice = dice;
	}
	
	public DamageType getDamageType()
	{
		return type;
	}
	
	public Dice getDice()
	{
		return dice;
	}
	
	public int rollDamage()
	{
		return dice.rollDice();
	}
}
