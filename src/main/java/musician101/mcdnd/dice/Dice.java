package musician101.mcdnd.dice;

import java.util.Random;

public class Dice
{
	DiceType type;
	int amount;
	//TODO get rid of DiceType?
	public Dice(DiceType type)
	{
		this(type, 1);
	}
	
	public Dice(DiceType type, int amount)
	{
		this.type = type;
		this.amount = amount;
	}
	
	public DiceType getType()
	{
		return type;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	public int rollDice()
	{
		int roll = 0;
		for (int x = 0; x < amount; x++)
			x =+ new Random().nextInt(type.getSides() - 1) + 1;
		
		return roll;
	}
	
	public static enum DiceType
	{
		D1(1),
		D4(4),
		D6(6),
		D8(8),
		D10(10),
		D12(12),
		D20(20);
		
		int sides;
		
		private DiceType(int sides)
		{
			this.sides = sides;
		}
		
		public int getSides()
		{
			return sides;
		}
	}
}
