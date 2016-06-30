package io.musician101.sponge.mcdnd.property;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.race.Race.CharacterSize;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class SizeProperty extends MCDNDProperty
{
    private final CharacterSize size;
    private final Dice heightDice;
    private final Dice weightDice;
    private final int baseHeight;
    private final int baseWeight;

    public SizeProperty(int baseHeight, Dice heightDice, int baseWeight, Dice weightDice, CharacterSize size)
    {
        this.baseHeight = baseHeight;
        this.heightDice = heightDice;
        this.baseWeight = baseWeight;
        this.weightDice = weightDice;
        this.size = size;
    }

    public CharacterSize getSize()
    {
        return size;
    }

    public int getAverageHeight()
    {
        return heightDice.getAverageRoll() + baseHeight;
    }

    public int rollHeight()
    {
        return heightDice.roll() + baseHeight;
    }

    public int getAverageWeight(int height)
    {
        return height * weightDice.getAverageRoll() + baseWeight;
    }

    public int rollWeight(int height)
    {
        return height * weightDice.roll() + baseWeight;
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
                .set(MCDNDKeys.CHARACTER_SIZE, size)
                .set(MCDNDKeys.BASE_HEIGHT, baseHeight)
                .set(MCDNDKeys.HEIGHT_DICE, heightDice)
                .set(MCDNDKeys.BASE_WEIGHT, baseWeight)
                .set(MCDNDKeys.WEIGHT_DICE, weightDice);
    }
}
