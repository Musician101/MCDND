package io.musician101.mcdnd.sponge.data.manipulator.mutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableMCDNDHealthData;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractIntData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.mutable.Value;

public class MCDNDHealthData extends AbstractIntData<MCDNDHealthData, ImmutableMCDNDHealthData> {

    public MCDNDHealthData(int value) {
        super(value, MCDNDKeys.HEALTH);
    }

    @Nonnull
    @Override
    public ImmutableMCDNDHealthData asImmutable() {
        return new ImmutableMCDNDHealthData(getValue());
    }

    public int asInt() {
        return getValue();
    }

    @Nonnull
    @Override
    public MCDNDHealthData copy() {
        return new MCDNDHealthData(getValue());
    }

    @Nonnull
    @Override
    public Optional<MCDNDHealthData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction mergeFunction) {
        Optional<Integer> optional = mergeFunction.merge(copy(), dataHolder).get(usedKey);
        if (optional.isPresent()) {
            return Optional.of(new MCDNDHealthData(optional.get()));
        }

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<MCDNDHealthData> from(@Nonnull DataContainer dataContainer) {
        Optional<Integer> listOptional = dataContainer.getObject(usedKey.getQuery(), Integer.class);
        if (listOptional.isPresent()) {
            return Optional.of(new MCDNDHealthData(getValue()));
        }

        return Optional.empty();
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

    @Nonnull
    @Override
    protected Value<Integer> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createValue(MCDNDKeys.HEALTH, getValue(), getValue());
    }
}
