package musician101.mcdnd.magic;

import musician101.mcdnd.util.Interfaces.Named;

public class SpellType implements Named
{
    final String name;

    public SpellType(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
