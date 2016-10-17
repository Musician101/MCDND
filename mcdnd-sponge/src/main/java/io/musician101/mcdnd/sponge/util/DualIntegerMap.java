package io.musician101.mcdnd.sponge.util;

import java.util.HashMap;

public class DualIntegerMap extends HashMap<Integer, Integer>
{
    public static Builder builder()
    {
        return new Builder();
    }

    public static class Builder
    {
        DualIntegerMap map = new DualIntegerMap();

        public Builder put(Integer key, Integer value)
        {
            map.put(key, value);
            return this;
        }

        public DualIntegerMap build()
        {
            return map;
        }
    }
}
