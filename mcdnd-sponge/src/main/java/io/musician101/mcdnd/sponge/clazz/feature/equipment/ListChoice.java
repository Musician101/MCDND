package io.musician101.mcdnd.sponge.clazz.feature.equipment;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import io.musician101.mcdnd.sponge.util.Interfaces.Listed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;

public class ListChoice implements EquipmentChoice, Listed<Equipment> {

    private final List<Equipment> equipment;

    public ListChoice(Collection<? extends Equipment> equipment) {
        this(new ArrayList<>(equipment));
    }

    public ListChoice(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    @Override
    public Equipment get(int index) {
        return equipment.get(index);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public List<Equipment> getList() {
        return equipment;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.EQUIPMENT_LIST, equipment);
    }
}
