package io.musician101.sponge.mcdnd.property;

import io.musician101.sponge.mcdnd.util.MapUtils;

import java.util.Arrays;
import java.util.Map;

public class RageProperty
{
    private final Map<Integer, Integer> rageDamageMap = new MapUtils<Integer, Integer>().add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 2)
            .add(Arrays.asList(9, 10, 11, 12, 13, 14, 15), 3).add(Arrays.asList(16, 17, 18, 19, 20), 4);
    private final Map<Integer, Integer> ragesMap = new MapUtils<Integer, Integer>().add(Arrays.asList(1,2) , 2)
            .add(Arrays.asList(3, 4, 5), 3).add(Arrays.asList(6, 7, 8, 9, 10, 11), 4).add(Arrays.asList(12, 13, 14, 15, 16), 5)
            .add(Arrays.asList(17, 18, 19), 6).add(20, -1);

    public int getRageDamage(int level)
    {
        return rageDamageMap.get(level);
    }

    public int getRages(int level)
    {
        return ragesMap.get(level);
    }
}
