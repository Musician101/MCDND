package io.musician101.sponge.mcdnd.clazz.feature;

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

public class Feature implements DataSerializable, Described, HasProperties, Named
{
    protected final DataContainer properties;
    private final int level;
    private final List<String> description;
    private final String name;

    protected Feature(String name, int level, DataContainer properties, List<String> description)
    {
        this.name = name;
        this.level = level;
        this.properties = properties;
        this.description = description;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.NAME, name)
                .set(MCDNDKeys.STARTING_LEVEL, level)
                .set(MCDNDKeys.DESCRIPTION, description)
                .set(MCDNDKeys.PROPERTIES, properties);
    }

    @Override
    public DataContainer getProperties()
    {
        return properties;
    }

    public int getLevelRequirement()
    {
        return level;
    }

    @Override
    public int getContentVersion()
    {
        return 1;
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

    public static FeatureBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(FeatureBuilder.class);
    }
}
