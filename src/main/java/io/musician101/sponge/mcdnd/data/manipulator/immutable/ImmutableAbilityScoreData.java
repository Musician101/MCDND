package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData;

import javax.annotation.Nonnull;
import java.util.Map;

public class ImmutableAbilityScoreData extends AbstractImmutableMappedData<AbilityScoreType, Integer, ImmutableAbilityScoreData, AbilityScoreData>
{
    public ImmutableAbilityScoreData(Map<AbilityScoreType, Integer> value)
    {
        super(value, MCDNDKeys.ABILITY_SCORES);
    }

    @Nonnull
    @Override
    public AbilityScoreData asMutable()
    {
        return new AbilityScoreData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
