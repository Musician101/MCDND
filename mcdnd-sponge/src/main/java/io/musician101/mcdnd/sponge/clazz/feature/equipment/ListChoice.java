package io.musician101.mcdnd.sponge.clazz.feature.equipment;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import io.musician101.mcdnd.sponge.util.Interfaces.Listed;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListChoice implements EquipmentChoice, Listed<Equipment>
{
    private final List<Equipment> equipment;

    public ListChoice(Collection<? extends Equipment> equipment)
    {
        this(new ArrayList<>(equipment));
    }

    public ListChoice(List<Equipment> equipment)
    {
        this.equipment = equipment;
    }

    @Override
    public List<Equipment> getList()
    {
        return equipment;
    }

    @Override
    public Equipment get(int index)
    {
        return equipment.get(index);
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
                .set(MCDNDKeys.EQUIPMENT_LIST, equipment);
    }
}
