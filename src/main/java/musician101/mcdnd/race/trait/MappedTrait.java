package musician101.mcdnd.race.trait;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MappedTrait<K, V> extends Trait
{
	Map<K, V> map;
	
	public MappedTrait(String name, Map<K, V> map, String description)
	{
		super(name, description);
		this.map = map;
	}
	
	public Map<K, V> getMap()
	{
		return map;
	}
	
	public boolean containsKey(K key)
	{
		return map.containsKey(key);
	}
	
	public V get(K key)
	{
		return map.get(key);
	}
	
	public V remove(K key)
	{
		return map.remove(key);
	}
	
	public Set<K> keySet()
	{
		return map.keySet();
	}
	
	public Set<Entry<K, V>> entrySet()
	{
		return map.entrySet();
	}
}
