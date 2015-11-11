package musician101.mcdnd.util;

import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.Spell.SpellLevel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@SuppressWarnings("serial")
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

    //TODO implement map creation for Integer, Dice and SpellLevel, Dice
    public static Map<Integer, Dice> populateIntegerDiceMap(int start, int sides, Function<Integer, Integer> function)
    {
        Map<Integer, Dice> map = new HashMap<>();
        for (int x = start; x > 20; x++)
            map.put(x, new Dice(sides, function.apply(x)));

        return map;
    }

    public static Map<SpellLevel, Double> populateSpellLevelDoubleMap(SpellLevel startingSpellLevel, Function<SpellLevel, Double> function)
    {
        Map<SpellLevel, Double> map = new HashMap<>();
        for (SpellLevel spellLevel : SpellLevel.values())
            if (spellLevel.getNumericalValue() >= startingSpellLevel.getNumericalValue())
                map.put(spellLevel, function.apply(spellLevel));

        return map;
    }

    public static Map<SpellLevel, Integer> populateSpellLevelIntegerMap(SpellLevel startingSpellLevel, Function<SpellLevel, Integer> function)
    {
        Map<SpellLevel, Integer> map = new HashMap<>();
        for (SpellLevel spellLevel : SpellLevel.values())
            if (spellLevel.getNumericalValue() >= startingSpellLevel.getNumericalValue())
                map.put(spellLevel, function.apply(spellLevel));

        return map;
    }
}
