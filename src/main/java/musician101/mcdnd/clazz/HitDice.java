package musician101.mcdnd.clazz;

import musician101.mcdnd.dice.Dice;

public class HitDice extends Dice
{
	public HitDice(int sides)
	{
		super(sides);
	}
	
	public HitDice(int sides, int amount)
	{
		super(sides, amount);
	}
	
	/** Gain average HP */
	public int gainHitPoints(int conMod)
	{
		return gainHitPoints(conMod, false);
	}
	
	/** Used for when leveling up, when a player uses a hit die to regain HP, or when a player goes for a long rest */
	public int gainHitPoints(int conMod, boolean isRolling)
	{
		if (isRolling)
			return super.roll() + conMod;
		
		return (sides() / 2) + 1 + conMod;
	}
}
