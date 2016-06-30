package io.musician101.sponge.mcdnd.clazz.feature.equipment;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class SingleChoice extends EquipmentChoice
{
    private final int amount;
    private final Equipment equipment;

    public SingleChoice(Equipment equipment)
    {
        this(equipment, 1);
    }

    public SingleChoice(Equipment equipment, int amount)
    {
        this.equipment = equipment;
        this.amount = amount;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public int getAmount()
    {
        return amount;
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
                .set(MCDNDKeys.AMOUNT, amount)
                .set(MCDNDKeys.EQUIPMENT, equipment);
    }
}