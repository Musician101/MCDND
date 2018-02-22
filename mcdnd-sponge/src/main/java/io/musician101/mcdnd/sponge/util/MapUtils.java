package io.musician101.mcdnd.sponge.util;

import io.musician101.mcdnd.sponge.data.type.spell.SpellLevel;
import io.musician101.mcdnd.sponge.data.type.spell.SpellLevels;
import io.musician101.mcdnd.sponge.dice.Dice;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapUtils {

    public static Map<SpellLevel, Dice> populateSpellLevelDiceMap(SpellLevel startingSpellLevel, int sides, Function<SpellLevel, Integer> function) {
        Map<SpellLevel, Dice> map = new HashMap<>();
        SpellLevels.ALL.stream().filter(spellLevel -> spellLevel.getValue() >= startingSpellLevel.getValue()).forEach(spellLevel -> map.put(spellLevel, new Dice(sides, function.apply(spellLevel))));
        return map;
    }

    public static Map<SpellLevel, Double> populateSpellLevelDoubleMap(SpellLevel startingSpellLevel, Function<SpellLevel, Double> function) {
        Map<SpellLevel, Double> map = new HashMap<>();
        SpellLevels.ALL.stream().filter(spellLevel -> spellLevel.getValue() >= startingSpellLevel.getValue()).forEach(spellLevel -> map.put(spellLevel, function.apply(spellLevel)));
        return map;
    }

    public static Map<SpellLevel, Integer> populateSpellLevelIntegerMap(SpellLevel startingSpellLevel, Function<SpellLevel, Integer> function) {
        Map<SpellLevel, Integer> map = new HashMap<>();
        SpellLevels.ALL.stream().filter(spellLevel -> spellLevel.getValue() >= startingSpellLevel.getValue()).forEach(spellLevel -> map.put(spellLevel, function.apply(spellLevel)));
        return map;
    }
}
