package io.musician101.sponge.mcdnd.clazz.feature.equipment;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import io.musician101.sponge.mcdnd.util.Interfaces.Listed;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListChoice extends EquipmentChoice implements Listed<Equipment>
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
