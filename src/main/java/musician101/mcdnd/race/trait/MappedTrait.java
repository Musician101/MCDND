package musician101.mcdnd.race.trait;

import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.magic.Spell;
import musician101.mcdnd.util.Interfaces.Mapped;

import java.util.List;
import java.util.Map;

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

    @Override
    public MappedTrait<K, V> add(K key, V value)
    {
        map.put(key, value);
        return this;
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
        final AbilityScoreType type;

        public SpellcastingTrait(String name, Map<Integer, Spell> map, AbilityScoreType type, String description)
        {
            super(name, map, description);
            this.type = type;
        }

        public AbilityScoreType getAbilityScoreType()
        {
            return type;
        }
    }
}
