package io.musician101.sponge.mcdnd.property.single;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.util.Interfaces.AbilityScoreDCSave;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.Optional;

public class AbilityScoreDCSaveProperty extends SingleValueProperty<AbilityScoreType> implements AbilityScoreDCSave
{
    public AbilityScoreDCSaveProperty(AbilityScoreType abilityScoreType)
    {
        super(abilityScoreType);
    }

    @Override
    public Optional<Integer> getDCSave(AbilityScoreData score, int... bonuses)
    {
        Optional<Integer> optional = score.get(value);
        if (!optional.isPresent())
            return Optional.empty();

        return Optional.of(8 + value.getMod(optional.get()));
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
                .set(MCDNDKeys.ABILITY_SCORE_TYPE, value);
    }

}
