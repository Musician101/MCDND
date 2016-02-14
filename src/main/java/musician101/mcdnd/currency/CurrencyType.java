package musician101.mcdnd.currency;

import musician101.mcdnd.util.Interfaces.Named;

public class CurrencyType implements Named
{
    final String name;

    public CurrencyType(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
