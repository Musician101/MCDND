package io.musician101.mcdnd.sponge.combat;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.dice.Dice;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public class Damage implements DataSerializable {

    private final Dice dice;
    private final MCDNDDamageType type;

    public Damage(MCDNDDamageType type, Dice dice) {
        this.type = type;
        this.dice = dice;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public MCDNDDamageType getDamageType() {
        return type;
    }

    public Dice getDice() {
        return dice;
    }

    public int rollDamage() {
        int roll = 0;
        for (Entry<Dice, Integer> entry : dice.roll()) {
            roll = +entry.getValue();
        }

        return roll;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.DAMAGE_TYPE, type).set(MCDNDKeys.DICE, dice);
    }
}
