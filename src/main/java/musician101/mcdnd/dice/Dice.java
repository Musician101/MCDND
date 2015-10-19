package musician101.mcdnd.dice;

import java.util.Random;

public class Dice
{
    private final int amount;
    private final int sides;

    public Dice(int sides)
    {
        this(sides, 1);
    }

    public Dice(int sides, int amount)
    {
        this.sides = sides;
        this.amount = amount;
    }

    public int getAmount()
    {
        return amount;
    }

    public int sides()
    {
        return sides;
    }

    public int roll()
    {
        int roll = 0;
        for (int x = 0; x < amount; x++)
            x = +new Random().nextInt(sides - 1) + 1;

        return roll;
    }

    @Override
    public String toString()
    {
        return amount + "d" + sides;
    }
}
