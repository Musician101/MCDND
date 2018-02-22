package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.EquippedItemsData;
import io.musician101.mcdnd.sponge.equipment.EquippedItems;
import javax.annotation.Nonnull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

public class ImmutableEquippedItemsData extends AbstractImmutableSingleData<EquippedItems, ImmutableEquippedItemsData, EquippedItemsData> {

    private final ImmutableValue<EquippedItems> immutableValue;

    public ImmutableEquippedItemsData(EquippedItems value) {
        super(value, MCDNDKeys.EQUIPPED_ITEMS);
        this.immutableValue = Sponge.getRegistry().getValueFactory().createValue(MCDNDKeys.EQUIPPED_ITEMS, value).asImmutable();
    }

    @Nonnull
    @Override
    public EquippedItemsData asMutable() {
        return new EquippedItemsData(getValue());
    }

    @Override
    public int compareTo(@Nonnull ImmutableEquippedItemsData immutableEquippedItemsData) {
        //noinspection OptionalGetWithoutIsPresent
        return immutableEquippedItemsData.get(this.usedKey).get().equals(this.getValue()) ? 0 : -1;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Nonnull
    @Override
    protected ImmutableValue<EquippedItems> getValueGetter() {
        return immutableValue;
    }
}
