package io.musician101.sponge.mcdnd.util;

import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.magic.SpellLevel;
import io.musician101.sponge.mcdnd.magic.SpellLevels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @deprecated Will be removed
 * @param <K>
 * @param <V>
 */
public class CustomMap<K, V> extends HashMap<K, V>
{
    public CustomMap()
    {
        super();
    }

    public CustomMap<K, V> add(K key, V value)
    {
        put(key, value);
        return this;
    }

    public CustomMap<K, V> add(List<K> keys, V value)
    {
        for (K key : keys)
            put(key, value);

        return this;
    }

    public static Map<SpellLevel, Dice> populateSpellLevelDiceMap(SpellLevel startingSpellLevel, int sides, Function<SpellLevel, Integer> function)
    {
        Map<SpellLevel, Dice> map = new HashMap<>();
        SpellLevels.ALL.stream().filter(spellLevel -> spellLevel.getValue() >= startingSpellLevel.getValue()).forEach(spellLevel -> map.put(spellLevel, new Dice(sides, function.apply(spellLevel))));
        return map;
    }

    public static Map<SpellLevel, Double> populateSpellLevelDoubleMap(SpellLevel startingSpellLevel, Function<SpellLevel, Double> function)
    {
        Map<SpellLevel, Double> map = new HashMap<>();
        SpellLevels.ALL.stream().filter(spellLevel -> spellLevel.getValue() >= startingSpellLevel.getValue()).forEach(spellLevel -> map.put(spellLevel, function.apply(spellLevel)));
        return map;
    }

    public static Map<SpellLevel, Integer> populateSpellLevelIntegerMap(SpellLevel startingSpellLevel, Function<SpellLevel, Integer> function)
    {
        Map<SpellLevel, Integer> map = new HashMap<>();
        SpellLevels.ALL.stream().filter(spellLevel -> spellLevel.getValue() >= startingSpellLevel.getValue()).forEach(spellLevel -> map.put(spellLevel, function.apply(spellLevel)));
        return map;
    }
}
