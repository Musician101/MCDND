package musician101.mcdnd.combat;

import musician101.mcdnd.util.Interfaces.Named;

public class DamageType implements Named
{
    final String name;

    public DamageType(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
