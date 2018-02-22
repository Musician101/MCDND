package io.musician101.mcdnd.sponge.data.type;

import io.musician101.mcdnd.sponge.util.Interfaces.Described;
import java.util.Arrays;
import java.util.List;

public class ActionType extends MCDNDCatalogType implements Described {

    private final List<String> description;

    public ActionType(String name, String... description) {
        super(name);
        this.description = Arrays.asList(description);
    }

    @Override
    public List<String> getDescription() {
        return description;
    }
}
