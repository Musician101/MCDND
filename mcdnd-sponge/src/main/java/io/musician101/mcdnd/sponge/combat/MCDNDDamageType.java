package io.musician101.mcdnd.sponge.combat;

import io.musician101.mcdnd.sponge.util.Interfaces.Named;

public class MCDNDDamageType implements Named
{
    final String name;

    public MCDNDDamageType(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
