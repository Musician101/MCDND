package io.musician101.sponge.mcdnd.race.trait;

import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.race.Race.CharacterSize;
import io.musician101.sponge.mcdnd.util.CustomMap;

import java.util.Map;

public class SizeTrait extends Trait
{
    private final CharacterSize size;
    private final Dice heightDice;
    private final Dice weightDice;
    private final int baseHeight;
    private final int baseWeight;

    protected SizeTrait(int baseHeight, Dice heightDice, int baseWeight, Dice weightDice, CharacterSize size,
                        String... description)
    {
        super("Size", description);
        this.size = size;
        this.baseHeight = baseHeight;
        this.heightDice = heightDice;
        this.baseWeight = baseWeight;
        this.weightDice = weightDice;
    }

    public CharacterSize getSize()
    {
        return size;
    }

    public Dice getHeightDice()
    {
        return heightDice;
    }

    public Dice getWeightDice()
    {
        return weightDice;
    }

    public Map<String, Integer> rollHeightAndWeight()
    {
        int heightMod = heightDice.roll();
        return new CustomMap<String, Integer>().add("height", baseHeight + heightMod).add("weight", heightMod *
                weightDice.roll() + baseWeight);
    }
}
