package io.musician101.mcdnd.sponge.data.type;

import io.musician101.mcdnd.sponge.Reference;
import org.spongepowered.api.CatalogType;

import javax.annotation.Nonnull;

public class MCDNDCatalogType implements CatalogType
{
    private final String id;
    protected final String name;

    protected MCDNDCatalogType(String name)
    {
        this.name = name;
        this.id = Reference.ID + ":" + name.toLowerCase().replace(" ", "_");
    }

    @Nonnull
    @Override
    public String getId()
    {
        return id;
    }

    @Nonnull
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return getId();
    }
}
