package io.musician101.sponge.mcdnd.condition;

import io.musician101.sponge.mcdnd.property.Property;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import io.musician101.sponge.mcdnd.util.Interfaces.HasProperties;
import io.musician101.sponge.mcdnd.util.Interfaces.Identified;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;

import java.util.ArrayList;
import java.util.List;

public class Condition implements Described, HasProperties, Identified, Named
{
    List<Property> properties = new ArrayList<>();
    String id;
    String name;
    String[] description;

    public Condition(String name, String... description)
    {
        this.id = "condition." + name.toLowerCase();
        this.name = name;
        this.description = description;
    }

    @Override
    public List<Property> getProperties()
    {
        return properties;
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
    public String[] getDescription()
    {
        return description;
    }
}
