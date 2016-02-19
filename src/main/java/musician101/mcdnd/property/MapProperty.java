package musician101.mcdnd.property;

import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.SpellLevel;
import musician101.mcdnd.util.Interfaces.Mapped;

import java.util.Map;

public class MapProperty<K, V> extends Property implements Mapped<K, V>
{
    Map<K, V> map;

    public MapProperty(String id, Map<K, V> map)
    {
        super(id);
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
    public MapProperty<K, V> add(K key, V value)
    {
        map.put(key, value);
        return this;
    }

    @Override
    public V get(K key)
    {
        return map.get(key);
    }

    public static class SpellLevelProperty<V> extends MapProperty<SpellLevel, V>
    {
        protected SpellLevelProperty(String idPrefix, String numberName, Map<SpellLevel, V> map)
        {
            super(idPrefix + "property.spell-level_" + numberName, map);
        }

        public static class SpellLevelIntegerProperty extends SpellLevelProperty<Integer>
        {
            public SpellLevelIntegerProperty(String idPrefix, Map<SpellLevel, Integer> map)
            {
                super(idPrefix, "integer", map);
            }
        }

        public static class SpellLevelDoubleProperty extends SpellLevelProperty<Double>
        {
            public SpellLevelDoubleProperty(String idPrefix, Map<SpellLevel, Double> map)
            {
                super(idPrefix, "double", map);
            }
        }

        public static class SpellLevelDiceProperty extends SpellLevelProperty<Dice>
        {
            public SpellLevelDiceProperty(String idPrefix, Map<SpellLevel, Dice> map)
            {
                super(idPrefix, "dice", map);
            }
        }
    }
}
