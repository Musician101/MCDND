package io.musician101.mcdnd.sponge.clazz.feature.equipment;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;

public class SingleChoice implements EquipmentChoice {

    private final int amount;
    private final Equipment equipment;

    public SingleChoice(Equipment equipment) {
        this(equipment, 1);
    }

    public SingleChoice(Equipment equipment, int amount) {
        this.equipment = equipment;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.AMOUNT, amount).set(MCDNDKeys.EQUIPMENT, equipment);
    }
}
