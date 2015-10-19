package musician101.mcdnd.race.trait;

import java.util.List;
import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.magic.Spell;
import musician101.mcdnd.util.Interfaces.Mapped;

public class MappedTrait<K, V> extends Trait implements Mapped<K, V>
{
	private final Map<K, V> map;
	
	public MappedTrait(String name, Map<K, V> map, String... description)
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
	
	public static class SubraceTrait extends MappedTrait<String, List<? extends Trait>>
	{
		public SubraceTrait(Map<String, List<? extends Trait>> map, String description)
		{
			super("Subrace", map, description);
		}
	}
	
	public static class SpellcastingTrait extends MappedTrait<Integer, Spell>
	{
		final AbilityScores type;
		
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
