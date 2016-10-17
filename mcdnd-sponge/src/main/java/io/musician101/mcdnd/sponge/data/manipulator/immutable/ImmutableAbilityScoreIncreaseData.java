package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AbilityScoreIncreaseData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData;

import javax.annotation.Nonnull;
import java.util.Map;

public class ImmutableAbilityScoreIncreaseData extends AbstractImmutableMappedData<AbilityScoreType, Integer, ImmutableAbilityScoreIncreaseData, AbilityScoreIncreaseData>
{
    public ImmutableAbilityScoreIncreaseData(Map<AbilityScoreType, Integer> value)
    {
        super(value, MCDNDKeys.ABILITY_SCORES);
    }

    @Nonnull
    @Override
    public AbilityScoreIncreaseData asMutable()
    {
        return new AbilityScoreIncreaseData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
