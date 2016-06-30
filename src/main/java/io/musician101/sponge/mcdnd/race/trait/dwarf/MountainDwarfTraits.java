package io.musician101.sponge.mcdnd.race.trait.dwarf;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.ArmorTypes;
import io.musician101.sponge.mcdnd.property.SizeProperty;
import io.musician101.sponge.mcdnd.race.Race.CharacterSize;
import io.musician101.sponge.mcdnd.race.trait.Trait;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class MountainDwarfTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .description("Your Strength score increases by 2.")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.STRENGTH, 2))
            .build();
    public static final Trait DWARVEN_ARMOR_TRAINING = builder().name("Dwarven Armor Training")
            .description("You have proficiency with light and medium armor.")
            .addProperty(MCDNDKeys.ARMOR_TYPES, Arrays.asList(ArmorTypes.LIGHT, ArmorTypes.MEDIUM))
            .build();
    public static final Trait SIZE = builder().name("Size")
            .description("Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium.")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(4 * 12, new Dice(4, 2), 130, new Dice(6, 2), CharacterSize.MEDIUM))
            .build();
    protected static final List<Trait> DWARF_MOUNTAIN_TRAITS = Arrays.asList(ABILITY_SCORE_INCREASE, DWARVEN_ARMOR_TRAINING, SIZE);
}