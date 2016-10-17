package io.musician101.mcdnd.sponge.combat;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.dice.Dice;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.Map.Entry;

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
        int roll = 0;
        for (Entry<Dice, Integer> entry : dice.roll())
            roll =+ entry.getValue();

        return roll;
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
