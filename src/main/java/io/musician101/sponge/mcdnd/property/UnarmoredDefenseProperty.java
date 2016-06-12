package io.musician101.sponge.mcdnd.property;

import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.Optional;

public class UnarmoredDefenseProperty extends Property
{
    public Optional<Integer> getArmorClass(AbilityScoreData score)
    {
        AbilityScoreType con = AbilityScoreTypes.CONSTITUTION;
        AbilityScoreType dex = AbilityScoreTypes.DEXTERITY;
        Optional<Integer> conScore = score.get(con);
        Optional<Integer> dexScore = score.get(dex);
        if (!conScore.isPresent())
            return Optional.empty();

        if (!dexScore.isPresent())
            return Optional.empty();

        return Optional.of(10 + dex.getMod(dexScore.get()) + con.getMod(conScore.get()));
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
        return new MemoryDataContainer();
    }
}
