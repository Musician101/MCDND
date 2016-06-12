package io.musician101.sponge.mcdnd.magic.spelleffect;

import io.musician101.sponge.mcdnd.property.Property;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import io.musician101.sponge.mcdnd.util.Interfaces.HasProperties;
import io.musician101.sponge.mcdnd.util.Interfaces.Identified;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;

import java.util.ArrayList;
import java.util.List;

public class SpellEffect implements Described, HasProperties, Identified, Named
{
    List<Property> properties = new ArrayList<>();
    String id;
    String name;
    String[] description;

    protected SpellEffect(String id, String name, String... description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String[] getDescription()
    {
        return description;
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public List<Property> getProperties()
    {
        return properties;
    }
}
