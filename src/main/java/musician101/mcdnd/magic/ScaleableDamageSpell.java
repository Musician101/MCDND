package musician101.mcdnd.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import musician101.mcdnd.dice.Dice;

public class ScaleableDamageSpell extends DamageSpell
{
	Map<Integer, Dice> damageMap;
	
	public ScaleableDamageSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, boolean needsConcentration, Map<Integer, Dice> damageMap, String description)
	{
		this(name, type, level, castingTime, range, isVerbal, isSomatic, new ArrayList<String>(), 0, false, damageMap, description);
	}
	
	public ScaleableDamageSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, List<String> materials, int duration, boolean needsConcentration, Map<Integer, Dice> damageMap, String description)
	{
		super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, damageMap.get(1), description);
		this.damageMap = damageMap;
	}

	public Dice getDice(int level)
	{
		return damageMap.get(level);
	}
	
	public Map<Integer, Dice> getDamageMap()
	{
		return damageMap;
	}
	
	public void updateDamage(int level)
	{
		damage = damageMap.get(level);
	}
}
