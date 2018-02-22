package io.musician101.mcdnd.sponge.data.type;

import io.musician101.mcdnd.sponge.reference.Reference;
import javax.annotation.Nonnull;
import org.spongepowered.api.CatalogType;

public class MCDNDCatalogType implements CatalogType {

    protected final String name;
    private final String id;

    protected MCDNDCatalogType(String name) {
        this.name = name;
        this.id = Reference.ID + ":" + name.toLowerCase().replace(" ", "_");
    }

    @Nonnull
    @Override
    public String getId() {
        return id;
    }

    @Nonnull
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getId();
    }
}
