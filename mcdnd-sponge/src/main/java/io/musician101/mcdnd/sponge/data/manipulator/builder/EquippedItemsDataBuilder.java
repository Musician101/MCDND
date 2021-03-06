package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.SingleValueDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableEquippedItemsData;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.EquippedItemsData;
import io.musician101.mcdnd.sponge.equipment.EquippedItems;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

public class EquippedItemsDataBuilder extends SingleValueDataManipulatorBuilder<EquippedItems, EquippedItemsData, ImmutableEquippedItemsData> {

    @Nonnull
    @Override
    public Optional<EquippedItemsData> build(@Nonnull DataView container) {
        Optional<EquippedItems> optional = container.getObject(MCDNDKeys.EQUIPPED_ITEMS.getQuery(), EquippedItems.class);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public EquippedItemsData create() {
        return new EquippedItemsData(value);
    }

    @Nonnull
    @Override
    public Optional<EquippedItemsData> createFrom(@Nonnull DataHolder dataHolder) {
        Optional<EquippedItems> optional = dataHolder.get(MCDNDKeys.EQUIPPED_ITEMS);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        this.value = optional.get();
        return Optional.of(create());
    }
}
