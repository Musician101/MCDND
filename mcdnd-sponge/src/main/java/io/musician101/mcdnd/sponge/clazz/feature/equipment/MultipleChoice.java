package io.musician101.mcdnd.sponge.clazz.feature.equipment;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import io.musician101.mcdnd.sponge.util.Interfaces.Mapped;
import java.util.Map;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;

public class MultipleChoice implements EquipmentChoice, Mapped<Equipment, Integer> {

    private final Map<Equipment, Integer> equipment;

    public MultipleChoice(Map<Equipment, Integer> equipment) {
        this.equipment = equipment;
    }

    @Override
    public boolean containsKey(Equipment key) {
        return equipment.containsKey(key);
    }

    @Override
    public Integer get(Equipment key) {
        return equipment.get(key);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public Map<Equipment, Integer> getMap() {
        return equipment;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.EQUIPMENT_MAP, equipment);
    }
}
