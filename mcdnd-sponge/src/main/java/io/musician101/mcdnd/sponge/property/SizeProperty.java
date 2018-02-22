package io.musician101.mcdnd.sponge.property;

import io.musician101.mcdnd.sponge.data.type.CharacterSize;
import io.musician101.mcdnd.sponge.dice.Dice;
import java.util.Map.Entry;

public class SizeProperty implements MCDNDProperty {

    private final int baseHeight;
    private final int baseWeight;
    private final Dice heightDice;
    private final CharacterSize size;
    private final Dice weightDice;

    public SizeProperty(int baseHeight, Dice heightDice, int baseWeight, Dice weightDice, CharacterSize size) {
        this.baseHeight = baseHeight;
        this.heightDice = heightDice;
        this.baseWeight = baseWeight;
        this.weightDice = weightDice;
        this.size = size;
    }

    public int getAverageHeight() {
        return heightDice.getAverageRoll() + baseHeight;
    }

    public int getAverageWeight(int height) {
        return height * weightDice.getAverageRoll() + baseWeight;
    }

    public CharacterSize getSize() {
        return size;
    }

    public int rollHeight() {
        int roll = 0;
        for (Entry<Dice, Integer> entry : heightDice.roll()) {
            roll = +entry.getValue();
        }

        return roll + baseHeight;
    }

    public int rollWeight(int height) {
        int roll = 0;
        for (Entry<Dice, Integer> entry : weightDice.roll()) {
            roll = +entry.getValue();
        }

        return height * roll + baseWeight;
    }
}
