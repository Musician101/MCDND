package io.musician101.sponge.mcdnd.property.single;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.dice.HitDice;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class HitPointsProperty extends SingleValueProperty<HitDice>
{
    private final String className;

    public HitPointsProperty(HitDice dice, String className)
    {
        super(dice);
        this.className = className;
    }

    public String getHitPointsAtFirstLevel()
    {
        return value.sides() + " + your Constitution modifier";
    }

    public String getHitPointsAtHigherLevels()
    {
        return value.toString() + " (or " + (value.sides() / 2) + " + your Constitution modifier per " + className + " level";
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
                .set(MCDNDKeys.HIT_DICE_PROPERTY, value)
                .set(MCDNDKeys.CLASS_NAME, className);
    }
}
