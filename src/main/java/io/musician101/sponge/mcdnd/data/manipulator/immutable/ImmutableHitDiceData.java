package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.HitDiceData;
import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import io.musician101.sponge.mcdnd.dice.HitDice;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData;

import javax.annotation.Nonnull;
import java.util.Map;

public class ImmutableHitDiceData extends AbstractImmutableMappedData<CharacterClassType, HitDice, ImmutableHitDiceData, HitDiceData>
{
    public ImmutableHitDiceData(Map<CharacterClassType, HitDice> value)
    {
        super(value, MCDNDKeys.CHARACTER_HIT_DICE);
    }

    @Nonnull
    @Override
    public HitDiceData asMutable()
    {
        return new HitDiceData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
