package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.MappedDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableAbilityScoreData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AbilityScoreData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.util.Utils;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;

public class AbilityScoreDataBuilder extends MappedDataManipulatorBuilder<AbilityScoreType, Integer, AbilityScoreData, ImmutableAbilityScoreData>
{
    @Nonnull
    @Override
    public AbilityScoreData create()
    {
        return new AbilityScoreData(value);
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<Map<AbilityScoreType, Integer>> scores = dataHolder.get(MCDNDKeys.ABILITY_SCORES);//NOSONAR
        if (!scores.isPresent())
            return Optional.empty();

        this.value = scores.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreData> build(@Nonnull DataView container)
    {
        Optional<Map<AbilityScoreType, Integer>> scores = Utils.getObjectMap((DataContainer) container, MCDNDKeys.ABILITY_SCORE.getQuery(), AbilityScoreType.class, Integer.class);
        if (!scores.isPresent())
            return Optional.empty();

        this.value = scores.get();
        return Optional.of(create());
    }
}
