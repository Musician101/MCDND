package io.musician101.mcdnd.sponge.shape;

import io.musician101.mcdnd.sponge.util.Interfaces.Described;
import io.musician101.mcdnd.sponge.util.Interfaces.EffectsArea;
import io.musician101.mcdnd.sponge.util.Interfaces.Named;
import java.util.Arrays;
import java.util.List;
import org.spongepowered.api.data.DataSerializable;

public abstract class Shape implements DataSerializable, Described, EffectsArea, Named {

    private final List<String> description;
    private final String name;

    protected Shape(String name, String... description) {
        this.name = name;
        this.description = Arrays.asList(description);
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }
}
