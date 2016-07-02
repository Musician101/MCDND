package io.musician101.sponge.mcdnd.combat;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.dice.Dice;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class Damage implements DataSerializable
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
                .set(MCDNDKeys.DAMAGE_TYPE, type)
                .set(MCDNDKeys.DICE, dice);
    }
}
