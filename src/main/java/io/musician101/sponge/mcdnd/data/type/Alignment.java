package io.musician101.sponge.mcdnd.data.type;

import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(Alignments.class)
public class Alignment extends MCDNDCatalogType implements Described
{
    private final String abbreviation;
    private final String[] description;

    public Alignment(String name, String abbreviation, String... description)
    {
        super(name);
        this.abbreviation = abbreviation;
        this.description = description;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public String[] getDescription()
    {
        return description;
    }
}
