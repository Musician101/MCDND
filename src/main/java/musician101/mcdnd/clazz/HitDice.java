package musician101.mcdnd.clazz;

import java.util.Random;

import musician101.mcdnd.dice.Dice;

public class HitDice extends Dice
{
	public HitDice(DiceType type)
	{
		super(type);
	}
	
	public HitDice(DiceType type, int amount)
	{
		super(type, amount);
	}
	
	public int gainHitPoints(int conMod, boolean isRolling)
	{
		if (isRolling)
			return new Random().nextInt(getType().getSides() - 1) + 1 + conMod;
		
		return (getType().getSides() / 2) + 1 + conMod;
	}
}
