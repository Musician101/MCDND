package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableHitDiceData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.HitDiceData;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.MappedDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.type.CharacterClassType;
import io.musician101.mcdnd.sponge.dice.HitDice;
import io.musician101.mcdnd.sponge.util.Utils;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;

public class HitDiceDataBuilder extends MappedDataManipulatorBuilder<CharacterClassType, HitDice, HitDiceData, ImmutableHitDiceData>
{
    @Nonnull
    @Override
    public HitDiceData create()
    {
        return new HitDiceData(value);
    }

    @Nonnull
    @Override
    public Optional<HitDiceData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<Map<CharacterClassType, HitDice>> optional = dataHolder.get(MCDNDKeys.CHARACTER_HIT_DICE);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<HitDiceData> build(@Nonnull DataView container)
    {
        Optional<Map<CharacterClassType, HitDice>> optional = Utils.getObjectMap((DataContainer) container, MCDNDKeys.CHARACTER_HIT_DICE.getQuery(), CharacterClassType.class, HitDice.class);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }
}
