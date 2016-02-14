package musician101.mcdnd.magic;

import musician101.mcdnd.util.Interfaces.Named;
import musician101.mcdnd.util.Interfaces.SingleValue;

public class SpellLevel implements Named, SingleValue<Integer>
{
    final int numericalValue;
    final String name;

    public SpellLevel(String name, int numericalValue)
    {
        this.name = name;
        this.numericalValue = numericalValue;
    }

    @Override
    public Integer getValue()
    {
        return numericalValue;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
