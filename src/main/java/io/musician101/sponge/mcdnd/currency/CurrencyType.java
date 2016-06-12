package io.musician101.sponge.mcdnd.currency;

import io.musician101.sponge.mcdnd.util.Interfaces.Named;

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
