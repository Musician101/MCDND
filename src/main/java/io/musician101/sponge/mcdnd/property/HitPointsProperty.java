package io.musician101.sponge.mcdnd.property;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.dice.HitDice;
import io.musician101.sponge.mcdnd.property.MCDNDProperty;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class HitPointsProperty extends MCDNDProperty
{
    private final HitDice hitDice;
    private final String className;

    public HitPointsProperty(HitDice hitDice, String className)
    {
        this.hitDice = hitDice;
        this.className = className;
    }

    public HitDice getHitDice()
    {
        return hitDice;
    }

    public String getHitPointsAtFirstLevel()
    {
        return hitDice.sides() + " + your Constitution modifier";
    }

    public String getHitPointsAtHigherLevels()
    {
        return hitDice.toString() + " (or " + (hitDice.sides() / 2) + " + your Constitution modifier per " + className + " level";
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
                .set(MCDNDKeys.HIT_DICE, hitDice)
                .set(MCDNDKeys.CLASS_NAME, className);
    }
}
