package io.musician101.sponge.mcdnd.race.trait;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.language.Languages;
import io.musician101.sponge.mcdnd.property.SizeProperty;
import io.musician101.sponge.mcdnd.data.type.CharacterSizes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class HumanTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, ImmutableMap.<AbilityScoreType, Integer>builder().put(AbilityScoreTypes.CHARISMA, 1).put(AbilityScoreTypes.CONSTITUTION, 1).put(AbilityScoreTypes.DEXTERITY, 1).put(AbilityScoreTypes.INTELLIGENCE, 1).put(AbilityScoreTypes.STRENGTH, 1).put(AbilityScoreTypes.WISDOM, 1).build())
            .description("Your ability scores each increases by 1.")
            .build();
    public static final Trait AGE = builder().name("Age")
            .description("Humans reach adulthood in their late teens and live less than a century.")
            .build();
    public static final Trait ALIGNMENT = builder().name("Alignment")
            .description("Humans tend toward no particular alignment. The best and the worst are found among them.")
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 30 feet.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(4 * 12 + 8, new Dice(10, 2), 110, new Dice(4, 2), CharacterSizes.MEDIUM))
            .description("Humans vary widely in height and build, from barely 5 feet to well over 6 feet tall. Regardless of your position in that range, your size is Medium.")
            .build();
    public static final Trait LANGUAGES = builder().name("Languages")
            .addProperty(MCDNDKeys.LANGUAGES, Collections.singletonList(Languages.COMMON))
            .description("You can speak, read and write Common and one extra language of your choice. Humans typically learn the language of other peoples they deal with including obscure dialects. They are fond of sprinkling their speech with words borrowed from other tongues: Orc curses, Elvish musical expressions, Dwarvish military phrases, and so on.")
            .build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, SPEED, SIZE, LANGUAGES);
}
