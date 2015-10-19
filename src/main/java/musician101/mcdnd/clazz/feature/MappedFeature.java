package musician101.mcdnd.clazz.feature;

import java.util.List;
import java.util.Map;

import musician101.mcdnd.magic.Spell;
import musician101.mcdnd.util.Interfaces.Mapped;

public class MappedFeature<K, V> extends Feature implements Mapped<K, V>
{
	private final Map<K, V> map;
	
	public MappedFeature(String name, Map<K, V> map, String... description)
	{
		this(name, 1, map, description);
	}
	
	public MappedFeature(String name, int level, Map<K, V> map, String... description)
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
	
	public static class DomainSpellsFeature extends MappedFeature<Integer, List<Spell>>
	{
		public DomainSpellsFeature(String name, Map<Integer, List<Spell>> map)
		{
			super(name + " Domain Spells", map, "");
		}
	}
}
