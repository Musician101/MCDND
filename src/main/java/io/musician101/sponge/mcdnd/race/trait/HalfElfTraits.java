package io.musician101.sponge.mcdnd.race.trait;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.CharacterSizes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.language.Languages;
import io.musician101.sponge.mcdnd.property.SizeProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class HalfElfTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.CHARISMA, 2))
            .description("Your Charisma score increases by 2, and two other ability scores of your choice increases by 1.")
            .build();
    public static final Trait AGE = builder().name("Age")
            .description("Half-elves mature at the same rate humans do and reach adulthood around the age of 20. They live much longer than humans, however, often exceeding 180 years.")
            .build();
    public static final Trait ALIGNMENT = builder().name("Alignment")
            .description("Half-elves share the chaotic bent of their elven heritage. They value both personal freedom and creative expression, demonstrating neither love of leaders nor desire for followers. They chafe at rules, resent others' demands, and sometimes prove unreliable or at least unpredictable.")
            .build();
    public static final Trait DARKVISION = builder().name("Darkvision")
            .description("Thanks to your elf blood, you have superior vision in dark and dim conditions.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 30 feet.")
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(4 * 12 + 9, new Dice(8, 2), 110, new Dice(4, 2), CharacterSizes.MEDIUM))
            .description("Half-elves are about the same size as humans, ranging from 5 to 6 feet tall. Your size is Medium.")
            .build();
    public static final Trait SKILL_VERSATILITY = builder().name("Skill Versatility")
            .description("You gain proficiency in two skills of your choice.")
            .build();
    public static final Trait LANGUAGES = builder().name("Languages")
            .addProperty(MCDNDKeys.LANGUAGES, Arrays.asList(Languages.COMMON, Languages.ELVISH))
            .description("You can speak, read, and write Common, Elvish, and one extra language of your choice.")
            .build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, DARKVISION, SPEED, SIZE, SKILL_VERSATILITY, LANGUAGES);
}
