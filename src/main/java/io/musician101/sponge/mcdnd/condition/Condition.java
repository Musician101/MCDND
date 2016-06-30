package io.musician101.sponge.mcdnd.condition;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import io.musician101.sponge.mcdnd.util.Interfaces.HasProperties;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.List;


public class Condition implements DataSerializable, Described, HasProperties, Named
{
    private final DataContainer properties;
    private final String name;
    private final List<String> description;

    protected Condition(String name, DataContainer properties, List<String> description)
    {
        this.name = name;
        this.properties = properties;
        this.description = description;
    }

    @Override
    public DataContainer getProperties()
    {
        return properties;
    }

    @Override
    public List<String> getDescription()
    {
        return description;
    }

    @Override
    public String getName()
    {
        return name;
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
                .set(MCDNDKeys.NAME, name)
                .set(MCDNDKeys.DESCRIPTION, description)
                .set(MCDNDKeys.PROPERTIES, properties);
    }

    public static ConditionBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(ConditionBuilder.class);
    }
}
