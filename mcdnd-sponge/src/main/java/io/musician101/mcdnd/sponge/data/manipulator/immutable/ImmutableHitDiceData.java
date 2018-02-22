package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.HitDiceData;
import io.musician101.mcdnd.sponge.data.type.CharacterClassType;
import io.musician101.mcdnd.sponge.dice.HitDice;
import java.util.Map;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData;

public class ImmutableHitDiceData extends AbstractImmutableMappedData<CharacterClassType, HitDice, ImmutableHitDiceData, HitDiceData> {

    public ImmutableHitDiceData(Map<CharacterClassType, HitDice> value) {
        super(value, MCDNDKeys.CHARACTER_HIT_DICE);
    }

    @Nonnull
    @Override
    public HitDiceData asMutable() {
        return new HitDiceData(getValue());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
