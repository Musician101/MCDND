package io.musician101.sponge.mcdnd.magic;

import io.musician101.sponge.mcdnd.util.Interfaces.Named;

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
