package musician101.mcdnd.abilityscore;

import musician101.mcdnd.util.Interfaces.Named;

public class AbilityScoreType implements Named
{
    String abbreviation;
    final String name;

    public AbilityScoreType(String name, String abbreviation)
    {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
