package io.musician101.sponge.mcdnd.property;

import io.musician101.sponge.mcdnd.dice.HitDice;

@Deprecated
public class HitPointsProperty
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
}
