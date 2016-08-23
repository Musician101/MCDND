package io.musician101.sponge.mcdnd.condition;

import io.musician101.sponge.mcdnd.util.MCDNDBuildable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;

import java.util.List;


public class Condition extends MCDNDBuildable
{
    protected Condition(String name, DataContainer properties, List<String> description)
    {
        super(name, properties, description);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    public static ConditionBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(ConditionBuilder.class);
    }
}
