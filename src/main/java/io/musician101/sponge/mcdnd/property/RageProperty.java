package io.musician101.sponge.mcdnd.property;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class RageProperty
{
    private final Map<Integer, Integer> rageDamageMap = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(9, 3).put(16, 4).build();
    private final Map<Integer, Integer> ragesMap = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 3).put(6, 4).put(12, 5).put(17, 6).put(20, -1).build();

    public int getRageDamage(int level)
    {
        return rageDamageMap.get(level);
    }

    public int getRages(int level)
    {
        return ragesMap.get(level);
    }
}
