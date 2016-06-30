package io.musician101.sponge.mcdnd.clazz.feature.equipment;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import io.musician101.sponge.mcdnd.util.Interfaces.Mapped;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.Map;

public class MultipleChoice extends EquipmentChoice implements Mapped<Equipment, Integer>
{
    private final Map<Equipment, Integer> equipment;

    public MultipleChoice(Map<Equipment, Integer> equipment)
    {
        this.equipment = equipment;
    }

    @Override
    public boolean containsKey(Equipment key)
    {
        return equipment.containsKey(key);
    }

    @Override
    public Map<Equipment, Integer> getMap()
    {
        return equipment;
    }

    @Override
    public Integer get(Equipment key)
    {
        return equipment.get(key);
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
                .set(MCDNDKeys.EQUIPMENT_MAP, equipment);
    }
}