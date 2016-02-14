package musician101.mcdnd.clazz.feature;

import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.Spell;
import musician101.mcdnd.util.Interfaces.Listed;
import musician101.mcdnd.util.Interfaces.Mapped;

import java.util.List;
import java.util.Map;

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

    @Override
    public MappedFeature<K, V> add(K key, V value)
    {
        map.put(key, value);
        return this;
    }

    public static class DomainSpellsFeature extends MappedFeature<Integer, List<Spell>>
    {
        public DomainSpellsFeature(String name, Map<Integer, List<Spell>> map)
        {
            super(name + " Domain Spells", map, "");
        }
    }

    public static class MultiDamageTypeScalableDamageFeature extends MappedFeature<Integer, Dice> implements Listed<DamageType>
    {
        List<DamageType> list;

        public MultiDamageTypeScalableDamageFeature(String name, int level, Map<Integer, Dice> map, List<DamageType> list, String... description)
        {
            super(name, level, map, description);
            this.list = list;
        }

        @Override
        public List<DamageType> getList()
        {
            return list;
        }

        @Override
        public DamageType get(int index)
        {
            return list.get(index);
        }
    }
}
