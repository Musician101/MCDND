package io.musician101.sponge.mcdnd.property.map;

import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.property.Property;
import io.musician101.sponge.mcdnd.util.Interfaces.Mapped;

import java.util.Map;

public abstract class MappedProperty<K, V> extends Property implements Mapped<K, V>
{
    Map<K, V> map;

    protected MappedProperty(Map<K, V> map)
    {
        super();
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
    public MappedProperty<K, V> add(K key, V value)
    {
        map.put(key, value);
        return this;
    }

    @Override
    public V get(K key)
    {
        return map.get(key);
    }

    public static class SpellLevelProperty<V> extends MappedProperty<SpellLevel, V>
    {
        protected SpellLevelProperty(String idPrefix, String numberName, Map<SpellLevel, V> map)
        {
            super(idPrefix + "property.map.spell-level_" + numberName, map);
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
