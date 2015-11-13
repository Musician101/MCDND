package musician101.mcdnd.condition;

import musician101.mcdnd.property.Property;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.HasProperties;
import musician101.mcdnd.util.Interfaces.Identified;
import musician101.mcdnd.util.Interfaces.Named;

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
