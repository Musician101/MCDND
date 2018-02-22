package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AbilityScoreData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import java.util.Map;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData;

public class ImmutableAbilityScoreData extends AbstractImmutableMappedData<AbilityScoreType, Integer, ImmutableAbilityScoreData, AbilityScoreData> {

    public ImmutableAbilityScoreData(Map<AbilityScoreType, Integer> value) {
        super(value, MCDNDKeys.ABILITY_SCORES);
    }

    @Nonnull
    @Override
    public AbilityScoreData asMutable() {
        return new AbilityScoreData(getValue());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
