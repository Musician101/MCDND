package musician101.mcdnd.property;

import musician101.mcdnd.util.Interfaces.Mapped;

import java.util.Map;

public class MappedProperty<K, V> extends Property implements Mapped<K, V>
{
    Map<K, V> map;

    public MappedProperty(String id, Map<K, V> map)
    {
        super(id);
        this.map = map;
    }

    @Override
    public boolean containsKey(K key)
    {
        return map.containsKey(key);
    }

    @Override
    public Map<K, V> getMap()
    {
        return map;
    }

    @Override
    public MappedProperty<K, V> add(K key, V value)
    {
        map.put(key, value);
        return this;
    }

    @Override
    public V get(K key)
    {
        return map.get(key);
    }
}
