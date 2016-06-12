package io.musician101.sponge.mcdnd.magic;

import io.musician101.sponge.mcdnd.util.Interfaces.Named;
import io.musician101.sponge.mcdnd.util.Interfaces.SingleValue;

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
