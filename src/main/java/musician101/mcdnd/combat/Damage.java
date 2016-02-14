package musician101.mcdnd.combat;

import musician101.mcdnd.dice.Dice;

public class Damage
{
    private final DamageTypes type;
    private final Dice dice;

    public Damage(DamageTypes type, Dice dice)
    {
        this.type = type;
        this.dice = dice;
    }

    public DamageTypes getDamageType()
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
