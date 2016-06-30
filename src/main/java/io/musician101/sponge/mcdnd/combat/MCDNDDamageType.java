package io.musician101.sponge.mcdnd.combat;

import io.musician101.sponge.mcdnd.util.Interfaces.Named;

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
