package musician101.mcdnd.race.trait;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.magic.Spell;
import musician101.mcdnd.util.Interfaces.Mapped;

public class MappedTrait<K, V> extends Trait implements Mapped<K, V>
{
	Map<K, V> map;
	
	public MappedTrait(String name, Map<K, V> map, String description)
	{
		super(name, description);
		this.map = map;
	}
	
	@Override
	public Map<K, V> getMap()
	{
		return map;
	}
	
	@Override
	public boolean containsKey(K key)
	{
		return map.containsKey(key);
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
	
	public static class SubraceTrait extends MappedTrait<String, List<? extends Trait>>
	{
		public SubraceTrait(Map<String, List<? extends Trait>> map, String description)
		{
			super("Subrace", map, description);
		}
	}
	
	public static class SpellcastingTrait extends MappedTrait<Integer, Spell>
	{
		AbilityScores type;
		
		public SpellcastingTrait(String name, Map<Integer, Spell> map, AbilityScores type, String description)
		{
			super(name, map, description);
			this.type = type;
		}
		
		public AbilityScores getAbilityScoreType()
		{
			return type;
		}
	}
}
