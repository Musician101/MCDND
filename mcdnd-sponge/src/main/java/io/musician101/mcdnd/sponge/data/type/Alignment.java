package io.musician101.mcdnd.sponge.data.type;

import io.musician101.mcdnd.sponge.util.Interfaces.Described;
import java.util.Arrays;
import java.util.List;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(Alignments.class)
public class Alignment extends MCDNDCatalogType implements Described {

    private final String abbreviation;
    private final List<String> description;

    public Alignment(String name, String abbreviation, String... description) {
        super(name);
        this.abbreviation = abbreviation;
        this.description = Arrays.asList(description);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public List<String> getDescription() {
        return description;
    }
}
