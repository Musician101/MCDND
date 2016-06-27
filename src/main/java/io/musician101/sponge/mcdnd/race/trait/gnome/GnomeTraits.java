package io.musician101.sponge.mcdnd.race.trait.gnome;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.language.Languages;
import io.musician101.sponge.mcdnd.property.SizeProperty;
import io.musician101.sponge.mcdnd.race.Race.CharacterSize;
import io.musician101.sponge.mcdnd.race.trait.Trait;
import io.musician101.sponge.mcdnd.util.list.TraitList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class GnomeTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.INTELLIGENCE, 2))
            .description("Your Intelligence score increases by 2.")
            .build();
    public static final Trait AGE = builder().name("Age")
            .description("Gnomes mature at the same rate humans do, and most are expected to settle down into an adult life by around age 40. They can live 350 to almost 500 years.")
            .build();
    public static final Trait ALIGNMENT = builder().name("Alignment")
            .description("Gnomes are most often good. Those who tend toward law are sages, engineers, researches, scholars, investigators, or inventors. Those who tend toward chaos are minstrels, tricksters, wanderers, or fanciful jewelers. Gnomes are good-hearted, and even the tricksters among them are more playful than vicious.")
            .build();
    public static final Trait GNOME_CUNNING = builder().name("Gnome Cunning")
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPES, Arrays.asList(AbilityScoreTypes.INTELLIGENCE, AbilityScoreTypes.WISDOM, AbilityScoreTypes.CHARISMA))
            .description("You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.")
            .build();
    public static final Trait DARKVISION = builder().name("Darkvision")
            .description("Accustomed to life underground, you have superior vision in dark and dim conditions.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final Trait LANGUAGES = builder().name("Languages")
            .addProperty(MCDNDKeys.LANGUAGES, Arrays.asList(Languages.COMMON, Languages.GNOMISH))
            .description("You can speak, read, and write Common and Gnomish. The Gnomish language, which uses Dwarvish script, is renowned for its technical treatises and its catalogs of knowledge about the natural world.")
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 25 feet.")
            .addProperty(MCDNDKeys.INTEGER, 25)
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(2 * 12 + 11, new Dice(4, 2), 35, new Dice(1), CharacterSize.SMALL))
            .description("Gnomes are between 3 and 4 feet tall and average about 40 pounds. Your size is Small.")
            .build();
    public static final Trait SUBRACES = builder().name("Subraces")
            .addProperty(MCDNDKeys.SUBRACES, ImmutableMap.<String, TraitList>builder().put("Forest", TraitList.of(ForestGnomeTraits.ALL)).put("Rock", TraitList.of(RockGnomeTraits.ALL)).build())
            .description("Two subraces of gnomes are found among the worlds of D&D: forest gnomes and rock gnomes. Choose one of these subraces.")
            .build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, GNOME_CUNNING, DARKVISION, LANGUAGES, SPEED, SIZE, SUBRACES);
}
