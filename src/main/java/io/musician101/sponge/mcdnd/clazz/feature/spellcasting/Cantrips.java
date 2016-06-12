package io.musician101.sponge.mcdnd.clazz.feature.spellcasting;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import org.spongepowered.api.data.MemoryDataContainer;

import java.util.Arrays;
import java.util.Map;

public class Cantrips extends Feature
{
    protected Cantrips(Map<Integer, Integer> map, String... description)
    {
        super("Cantrips", 1, new MemoryDataContainer(), Arrays.asList(description));
        properties.set(MCDNDKeys.CANTRIP_SLOT_AMOUNT, map);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
