package musician101.mcdnd.util;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("serial")
public class CustomMap<K, V> extends HashMap<K, V>
{
    public CustomMap()
    {
        super();
    }

    public CustomMap<K, V> add(K key, V value)
    {
        put(key, value);
        return this;
    }

    public CustomMap<K, V> add(List<K> keys, V value)
    {
        for (K key : keys)
            put(key, value);

        return this;
    }
}
