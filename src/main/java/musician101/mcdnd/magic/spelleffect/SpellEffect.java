package musician101.mcdnd.magic.spelleffect;

import musician101.mcdnd.property.Property;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.HasProperties;
import musician101.mcdnd.util.Interfaces.Identified;
import musician101.mcdnd.util.Interfaces.Named;

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
