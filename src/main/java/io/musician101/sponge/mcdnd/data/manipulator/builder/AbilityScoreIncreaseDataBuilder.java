package io.musician101.sponge.mcdnd.data.manipulator.builder;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.builder.common.MappedDataManipulatorBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableAbilityScoreIncreaseData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreIncreaseData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.util.Utils;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;

public class AbilityScoreIncreaseDataBuilder extends MappedDataManipulatorBuilder<AbilityScoreType, Integer, AbilityScoreIncreaseData, ImmutableAbilityScoreIncreaseData>
{
    @Nonnull
    @Override
    public AbilityScoreIncreaseData create()
    {
        return new AbilityScoreIncreaseData(value);
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreIncreaseData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<Map<AbilityScoreType, Integer>> scores = dataHolder.get(MCDNDKeys.ABILITY_SCORES);//NOSONAR
        if (!scores.isPresent())
            return Optional.empty();

        this.value = scores.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreIncreaseData> build(@Nonnull DataView container)
    {
        Optional<Map<AbilityScoreType, Integer>> scores = Utils.getObjectMap((DataContainer) container, MCDNDKeys.ABILITY_SCORE.getQuery(), AbilityScoreType.class, Integer.class);
        if (!scores.isPresent())
            return Optional.empty();

        this.value = scores.get();
        return Optional.of(create());
    }
}
