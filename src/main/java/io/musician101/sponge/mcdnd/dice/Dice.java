package io.musician101.sponge.mcdnd.dice;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public class Dice implements DataSerializable
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

    public int getAverageRoll()
    {
        return amount * sides / 2 + 1;
    }

    public int getAmount()
    {
        return amount;
    }

    public int sides()
    {
        return sides;
    }

    public List<Entry<Dice, Integer>> roll()
    {
        List<Entry<Dice, Integer>> list = new ArrayList<>();
        for (int x = 0; x < amount; x++)
            list.add(new SimpleEntry<>(new Dice(sides), new Random().nextInt(sides - 1) + 1));

        return list;
    }

    @Override
    public String toString()
    {
        return amount + "d" + sides;
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.SIDES, sides)
                .set(MCDNDKeys.AMOUNT, amount);
    }

    public static int total(List<Entry<Dice, Integer>> rolls, int bonus)
    {
        int roll = 0;
        for (Entry<Dice, Integer> rollEntry : rolls)
            roll =+ rollEntry.getValue();

        return roll + bonus;
    }
}
