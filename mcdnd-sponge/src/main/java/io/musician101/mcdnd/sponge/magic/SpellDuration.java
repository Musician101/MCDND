package io.musician101.mcdnd.sponge.magic;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public class SpellDuration implements DataSerializable {

    private final double duration;
    private final boolean needsConcentration;

    private SpellDuration() {
        this(0);
    }

    private SpellDuration(double duration) {
        this(duration, false);
    }

    private SpellDuration(double duration, boolean needsConcentration) {
        this.duration = duration;
        this.needsConcentration = needsConcentration;
    }

    public static SpellDuration of() {
        return new SpellDuration();
    }

    public static SpellDuration of(double duration) {
        return new SpellDuration(duration);
    }

    public static SpellDuration of(double duration, boolean needsConcentration) {
        return new SpellDuration(duration, needsConcentration);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public double getDuration() {
        return duration;
    }

    public boolean needsConcentration() {
        return needsConcentration;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.DURATION, duration).set(MCDNDKeys.NEEDS_CONCENTRATION, needsConcentration);
    }
}
