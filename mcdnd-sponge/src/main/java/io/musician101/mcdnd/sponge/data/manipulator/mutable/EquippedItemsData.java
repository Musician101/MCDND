package io.musician101.mcdnd.sponge.data.manipulator.mutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableEquippedItemsData;
import io.musician101.mcdnd.sponge.equipment.EquippedItems;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.mutable.Value;

import javax.annotation.Nonnull;
import java.util.Optional;

public class EquippedItemsData extends AbstractSingleData<EquippedItems, EquippedItemsData, ImmutableEquippedItemsData>
{
    public EquippedItemsData(EquippedItems value)
    {
        super(value, MCDNDKeys.EQUIPPED_ITEMS);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    protected Value<EquippedItems> getValueGetter()
    {
        return Sponge.getRegistry().getValueFactory().createValue(MCDNDKeys.EQUIPPED_ITEMS, getValue());
    }

    @Nonnull
    @Override
    public Optional<EquippedItemsData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction mergeFunction)
    {
        Optional<EquippedItems> optional = mergeFunction.merge(copy(), dataHolder).get(usedKey);
        if (optional.isPresent())
            setValue(optional.get());

        return Optional.of(this);
    }

    @Nonnull
    @Override
    public Optional<EquippedItemsData> from(@Nonnull DataContainer dataContainer)
    {
        Optional<EquippedItems> optional = dataContainer.getObject(usedKey.getQuery(), EquippedItems.class);
        if (optional.isPresent())
            setValue(optional.get());

        return Optional.of(this);
    }

    @Nonnull
    @Override
    public EquippedItemsData copy()
    {
        return new EquippedItemsData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableEquippedItemsData asImmutable()
    {
        return new ImmutableEquippedItemsData(getValue());
    }

    @Override
    public int compareTo(@Nonnull EquippedItemsData equippedItemsData)
    {
        //noinspection OptionalGetWithoutIsPresent
        return equippedItemsData.get(this.usedKey).get().equals(this.getValue()) ? 0 : -1;
    }
}
