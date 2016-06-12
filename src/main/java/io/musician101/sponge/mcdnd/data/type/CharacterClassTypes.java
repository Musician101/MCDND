package io.musician101.sponge.mcdnd.data.type;

import io.musician101.sponge.mcdnd.dice.HitDice;

public class CharacterClassTypes
{
    public static final CharacterClassType BARBARIAN = new CharacterClassType("Barbarian", new HitDice(12));
    public static final CharacterClassType BARD = new CharacterClassType("Bard", new HitDice(8));
    public static final CharacterClassType CLERIC = new CharacterClassType("Cleric", new HitDice(8));
    public static final CharacterClassType DRUID = new CharacterClassType("Druid", new HitDice(8));
    public static final CharacterClassType FIGHTER = new CharacterClassType("Fighter", new HitDice(10));
    public static final CharacterClassType MONK = new CharacterClassType("Monk", new HitDice(8));
    public static final CharacterClassType PALADIN = new CharacterClassType("Paladin", new HitDice(10));
    public static final CharacterClassType RANGER = new CharacterClassType("Ranger", new HitDice(10));
    public static final CharacterClassType ROGUE = new CharacterClassType("Rogue", new HitDice(8));
    public static final CharacterClassType SORCERER = new CharacterClassType("Sorcerer", new HitDice(8));
    public static final CharacterClassType WARLOCK = new CharacterClassType("Warlock", new HitDice(8));
    public static final CharacterClassType WIZARD = new CharacterClassType("Wizard", new HitDice(6));

    private CharacterClassTypes()
    {

    }
}
