package io.musician101.sponge.mcdnd.dice;

import java.util.Map.Entry;

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
        int roll = 0;
        for (Entry<Dice, Integer> entry : roll())
            roll =+ entry.getValue();

        if (isRolling)
            return roll + conMod;

        return getAverageRoll() + conMod;
    }
}
