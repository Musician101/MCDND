package musician101.mcdnd.combat;

import java.util.Random;

public enum Dice
{
	D4(4),
	D6(6),
	D8(8),
	D10(10),
	D20(20);
	
	int sides;
	
	private Dice(int sides)
	{
		this.sides = sides;
	}
	
	public int getSides()
	{
		return sides;
	}
	
	public int rollDice(int amount)
	{
		int roll = 0;
		for (int x = 0; x < amount; x++)
			x =+ new Random().nextInt(sides - 1) + 1;
		
		return roll;
	}
}
