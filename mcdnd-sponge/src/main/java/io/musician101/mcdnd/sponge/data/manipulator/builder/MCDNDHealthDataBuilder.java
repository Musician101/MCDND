package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.SingleValueDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableMCDNDHealthData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.MCDNDHealthData;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.persistence.DataBuilder;

import javax.annotation.Nonnull;
import java.util.Optional;

public class MCDNDHealthDataBuilder extends SingleValueDataManipulatorBuilder<Integer, MCDNDHealthData, ImmutableMCDNDHealthData>
{
    @Nonnull
    @Override
    public Optional<MCDNDHealthData> build(@Nonnull DataView dataView)
    {
        Optional<Integer> integer = dataView.getInt(MCDNDKeys.HEALTH.getQuery());
        if (!integer.isPresent())
            return Optional.empty();

        this.value = integer.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public MCDNDHealthData create()
    {
        return new MCDNDHealthData(value);
    }

    @Nonnull
    @Override
    public Optional<MCDNDHealthData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<Integer> integer = dataHolder.get(MCDNDKeys.HEALTH);
        if (!integer.isPresent())
            return Optional.empty();

        this.value = integer.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public DataBuilder<MCDNDHealthData> reset()
    {
        value = null;
        return this;
    }

    @Nonnull
    @Override
    public DataBuilder<MCDNDHealthData> from(MCDNDHealthData value)
    {
        this.value = value.asInt();
        return this;
    }
}
