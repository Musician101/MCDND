package io.musician101.mcdnd.sponge.util;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.util.Interfaces.Described;
import io.musician101.mcdnd.sponge.util.Interfaces.HasProperties;
import io.musician101.mcdnd.sponge.util.Interfaces.Named;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.List;

public class MCDNDBuildable implements DataSerializable, Described, Named, HasProperties
{
    private DataContainer properties;
    private List<String> description;
    private String name;

    protected MCDNDBuildable(String name, DataContainer properties, List<String> description)
    {
        this.name = name;
        this.properties = properties;
        this.description = description;
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
    public DataContainer getProperties()
    {
        return properties;
    }
}
