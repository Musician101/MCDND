package musician101.mcdnd.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;

public class MappedSpell<K, V> extends Spell
{
	final Map<K, V> map;
	
	public MappedSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, V> map, String... description)
	{
		super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
		this.map = map;
	}
	
	public Map<K, V> getMap()
	{
		return map;
	}
	
	public V get(K key)
	{
		return map.get(key);
	}
	
	public class BehaviorSpell extends MappedSpell<Integer, String>
	{
		public BehaviorSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<Integer, String> map, String... description)
		{
			super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
		}
	}
	
	public static class MultipleSpellSlotSpell extends MappedSpell<SpellLevel, Integer>
	{
		public final SpellLevel startingLevel;
		
		public MultipleSpellSlotSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<SpellLevel, Integer> map, SpellLevel startingLevel, String... description)
		{
			super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
			this.startingLevel = startingLevel;
		}
		
		public SpellLevel getStartingLevel()
		{
			return startingLevel;
		}
	}
	
	public static class ScaleableDamageSpell<K> extends MappedSpell<K, Dice>
	{
		Damage damage;
		
		public ScaleableDamageSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, Dice> map, DamageType damageType, String... description)
		{
			super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
            List<K> list = new ArrayList<>();
            map.keySet().forEach(object -> list.add((K) object));
			this.damage = new Damage(damageType, map.get(list.get(1)));
		}
		
		public Damage getDamage()
		{
			return damage;
		}
		
		public void updateDamage(K level)
		{
			if (map.containsKey(level))
				damage = new Damage(damage.getDamageType(), map.get(level));
		}
	}
}
