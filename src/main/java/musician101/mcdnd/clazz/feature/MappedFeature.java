package musician101.mcdnd.clazz.feature;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import musician101.mcdnd.util.Interfaces.Mapped;

public class MappedFeature<K, V> extends Feature implements Mapped<K, V>
{
	Map<K, V> map;
	
	public MappedFeature(String name, int level, Map<K, V> map, String description)
	{
		super(name, level, description);
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
	public V get(K key)
	{
		return map.get(key);
	}

	@Override
	public V remove(K key)
	{
		return map.remove(key);
	}

	@Override
	public Set<K> keySet()
	{
		
		return map.keySet();
	}

	@Override
	public Set<Entry<K, V>> entrySet()
	{
		
		return map.entrySet();
	}
}
