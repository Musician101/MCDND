package io.musician101.mcdnd.sponge.clazz.feature.equipment;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.util.Interfaces.Described;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public class EquipmentChoices implements DataSerializable, Described {

    private final DataContainer choices;
    private final List<String> description;

    public EquipmentChoices(String description, DataContainer choices) {
        this.choices = choices;
        this.description = Collections.singletonList(description);
    }

    public DataContainer getChoices() {
        return choices;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.DESCRIPTION, description).set(MCDNDKeys.EQUIPMENT_CHOICES, choices);
    }
}
