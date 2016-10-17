package io.musician101.mcdnd.sponge.util;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Utils
{
    private Utils()
    {

    }

    @SuppressWarnings("UnusedParameters")
    public static <K, V> Optional<Map<K, V>> getObjectMap(DataContainer container, DataQuery query, Class<K> kClass, Class<V> vClass)//NOSONAR
    {
        Optional<? extends Map<?, ?>> optional = container.getMap(query);
        if (!optional.isPresent())
            return Optional.empty();

        Map<K, V> map = new HashMap<>();
        for (Entry<?, ?> entry : optional.get().entrySet())
            map.put((K) entry.getKey(), (V) entry.getValue());

        return Optional.of(map);
    }
}
