package io.musician101.sponge.mcdnd.magic;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class SpellDuration implements DataSerializable
{
    private final double duration;
    private final boolean needsConcentration;

    private SpellDuration()
    {
        this(0);
    }

    private SpellDuration(double duration)
    {
        this(duration, false);
    }

    private SpellDuration(double duration, boolean needsConcentration)
    {
        this.duration = duration;
        this.needsConcentration = needsConcentration;
    }

    public boolean needsConcentration()
    {
        return needsConcentration;
    }

    public double getDuration()
    {
        return duration;
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
                .set(MCDNDKeys.DURATION, duration)
                .set(MCDNDKeys.NEEDS_CONCENTRATION, needsConcentration);
    }

    public static SpellDuration of()
    {
        return new SpellDuration();
    }

    public static SpellDuration of(double duration)
    {
        return new SpellDuration(duration);
    }

    public static SpellDuration of(double duration, boolean needsConcentration)
    {
        return new SpellDuration(duration, needsConcentration);
    }
}
