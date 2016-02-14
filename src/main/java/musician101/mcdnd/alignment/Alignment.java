package musician101.mcdnd.alignment;

import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Named;

public class Alignment implements Described, Named
{
    final String abbreviation;
    final String[] description;
    final String name;

    public Alignment(String name, String abbreviation, String... description)
    {
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public String getName()
    {
        return name;
    }

    public String[] getDescription()
    {
        return description;
    }
}
