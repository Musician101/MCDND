package musician101.mcdnd.magic;

import java.util.Map;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;

public class MappedSpell<K, V> extends Spell
{
	Map<K, V> map;
	
	public MappedSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, boolean needsConcentration, Map<K, V> map, String description)
	{
		this(name, type, level, castingTime, range, isVerbal, isSomatic, "", 0, false, map, description);
	}
	
	public MappedSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, V> map, String description)
	{
		super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
		this.map = map;
	}
	
	public Map<K, V> getMap()
	{
		return map;
	}
	
	public V get(V key)
	{
		return map.get(key);
	}
	
	public static class ScaleableDamageSpell<K> extends MappedSpell<K, Dice>
	{
		Damage damage;
		
		public ScaleableDamageSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, boolean needsConcentration, Map<K, Dice> map, DamageType damageType, String description)
		{
			this(name, type, level, castingTime, range, isVerbal, isSomatic, "", 0, false, map, damageType, description);
		}
		
		public ScaleableDamageSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, Dice> map, DamageType damageType, String description)
		{
			super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
			this.damage = new Damage(damageType, map.get(1));
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
	
	public static class MultipleSpellSlotSpell extends MappedSpell<SpellLevel, Integer>
	{
		SpellLevel startingLevel;
		
		public MultipleSpellSlotSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, boolean needsConcentration, Map<SpellLevel, Integer> map, SpellLevel startingLevel, String description)
		{
			this(name, type, level, castingTime, range, isVerbal, isSomatic, "", 0, false, map, startingLevel, description);
		}
		
		public MultipleSpellSlotSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<SpellLevel, Integer> map, SpellLevel startingLevel, String description)
		{
			super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
		}
		
		public SpellLevel getStartingLevel()
		{
			return startingLevel;
		}
	}
}
