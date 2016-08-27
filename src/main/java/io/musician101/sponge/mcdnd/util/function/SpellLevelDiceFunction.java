package io.musician101.sponge.mcdnd.util.function;

import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.dice.Dice;

import java.util.function.Function;

public interface SpellLevelDiceFunction extends Function<SpellLevel, Dice>
{

}
