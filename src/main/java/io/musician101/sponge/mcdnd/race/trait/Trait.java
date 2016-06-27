package io.musician101.sponge.mcdnd.race.trait;

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

public class Trait implements DataSerializable, Described, Named, HasProperties
{
    private final DataContainer properties;
    private final List<String> description;
    private final String name;

    protected Trait(String name, DataContainer properties, List<String> description)
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

    public static TraitBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(TraitBuilder.class);
    }
}
