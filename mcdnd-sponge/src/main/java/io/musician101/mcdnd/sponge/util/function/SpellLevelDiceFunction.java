package io.musician101.mcdnd.sponge.util.function;

import io.musician101.mcdnd.sponge.data.type.spell.SpellLevel;
import io.musician101.mcdnd.sponge.dice.Dice;
import java.util.function.Function;

public interface SpellLevelDiceFunction extends Function<SpellLevel, Dice> {

}
