package io.musician101.mcdnd.sponge.data.manipulator.immutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.MCDNDHealthData;

public class ImmutableMCDNDHealthData extends AbstractImmutableIntData<ImmutableMCDNDHealthData, MCDNDHealthData>
{
    public ImmutableMCDNDHealthData(Integer value)
    {
        super(value, MCDNDKeys.HEALTH);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Override
    public MCDNDHealthData asMutable()
    {
        return new MCDNDHealthData(value);
    }

    public int asInt()
    {
        return getValue();
    }
}
