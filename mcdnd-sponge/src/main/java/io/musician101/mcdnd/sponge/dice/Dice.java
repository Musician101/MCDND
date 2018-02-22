package io.musician101.mcdnd.sponge.dice;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public class Dice implements DataSerializable {

    private final int amount;
    private final int sides;

    public Dice(int sides) {
        this(sides, 1);
    }

    public Dice(int sides, int amount) {
        this.sides = sides;
        this.amount = amount;
    }

    public static int total(List<Entry<Dice, Integer>> rolls, int bonus) {
        int roll = 0;
        for (Entry<Dice, Integer> rollEntry : rolls) {
            roll = +rollEntry.getValue();
        }

        return roll + bonus;
    }

    public int getAmount() {
        return amount;
    }

    public int getAverageRoll() {
        return amount * sides / 2 + 1;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public List<Entry<Dice, Integer>> roll() {
        List<Entry<Dice, Integer>> list = new ArrayList<>();
        for (int x = 0; x < amount; x++) {
            list.add(new SimpleEntry<>(new Dice(sides), new Random().nextInt(sides - 1) + 1));
        }

        return list;
    }

    public int sides() {
        return sides;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.SIDES, sides).set(MCDNDKeys.AMOUNT, amount);
    }

    @Override
    public String toString() {
        return amount + "d" + sides;
    }
}
