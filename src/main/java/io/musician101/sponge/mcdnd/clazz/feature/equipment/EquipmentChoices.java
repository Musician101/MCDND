package io.musician101.sponge.mcdnd.clazz.feature.equipment;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.property.list.ListProperty;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EquipmentChoices extends ListProperty<EquipmentChoice> implements Described
{
    List<String> description;

    public EquipmentChoices(String description, EquipmentChoice... choices)
    {
        super(Arrays.asList(choices));
        this.description = Collections.singletonList(description);
    }


    @Override
    public List<String> getDescription()
    {
        return description;
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
                .set(MCDNDKeys.DESCRIPTION, description)
                .set(MCDNDKeys.EQUIPMENT_CHOICE_LIST, list);
    }
}
