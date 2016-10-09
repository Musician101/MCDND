package io.musician101.sponge.mcdnd.data.manipulator.builder;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.builder.common.SingleValueDataManipulatorBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableEquippedItemsData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.EquippedItemsData;
import io.musician101.sponge.mcdnd.equipment.EquippedItems;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Optional;

public class EquippedItemsDataBuilder extends SingleValueDataManipulatorBuilder<EquippedItems, EquippedItemsData, ImmutableEquippedItemsData>
{
    @Nonnull
    @Override
    public EquippedItemsData create()
    {
        return new EquippedItemsData(value);
    }

    @Nonnull
    @Override
    public Optional<EquippedItemsData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<EquippedItems> optional = dataHolder.get(MCDNDKeys.EQUIPPED_ITEMS);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<EquippedItemsData> build(@Nonnull DataView container)
    {
        Optional<EquippedItems> optional = container.getObject(MCDNDKeys.EQUIPPED_ITEMS.getQuery(), EquippedItems.class);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }
}
