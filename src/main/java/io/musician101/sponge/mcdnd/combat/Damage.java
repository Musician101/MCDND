package io.musician101.sponge.mcdnd.combat;

import io.musician101.sponge.mcdnd.dice.Dice;

public class Damage
{
    private final MCDNDDamageType type;
    private final Dice dice;

    public Damage(MCDNDDamageType type, Dice dice)
    {
        this.type = type;
        this.dice = dice;
    }

    public MCDNDDamageType getDamageType()
    {
        return type;
    }

    public Dice getDice()
    {
        return dice;
    }

    public int rollDamage()
    {
        return dice.roll();
    }
}
