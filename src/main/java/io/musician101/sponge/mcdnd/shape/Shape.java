package io.musician101.sponge.mcdnd.shape;

import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import io.musician101.sponge.mcdnd.util.Interfaces.EffectsArea;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;
import org.spongepowered.api.data.DataSerializable;

import java.util.Arrays;
import java.util.List;

public abstract class Shape implements DataSerializable, Described, EffectsArea, Named
{
    private final List<String> description;
    private final String name;

    protected Shape(String name, String... description)
    {
        this.name = name;
        this.description = Arrays.asList(description);
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
}
