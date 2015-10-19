package musician101.mcdnd.magic;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;

import java.util.Map;

public abstract class MappedDCSaveSpell<K, V> extends DCSaveSpell
{
    private Map<K, V> map;

    protected MappedDCSaveSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, int duration, boolean needsConcentration, AbilityScores scoreType, String
			description)
    {
        super(name, type, level, castingTime, range, isVerbal, isSomatic, "", duration, needsConcentration,
				scoreType, description);
    }

    public Map<K, V> getMap()
    {
        return map;
    }

    public V get(K key)
    {
        return map.get(key);
    }
}
