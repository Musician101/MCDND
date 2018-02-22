package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AbilityScoreIncreaseData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import java.util.Map;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData;

public class ImmutableAbilityScoreIncreaseData extends AbstractImmutableMappedData<AbilityScoreType, Integer, ImmutableAbilityScoreIncreaseData, AbilityScoreIncreaseData> {

    public ImmutableAbilityScoreIncreaseData(Map<AbilityScoreType, Integer> value) {
        super(value, MCDNDKeys.ABILITY_SCORES);
    }

    @Nonnull
    @Override
    public AbilityScoreIncreaseData asMutable() {
        return new AbilityScoreIncreaseData(getValue());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
