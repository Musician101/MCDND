package io.musician101.mcdnd.sponge.race.trait.elf;

import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.data.type.skill.SkillTypes;
import io.musician101.mcdnd.sponge.language.Languages;
import io.musician101.mcdnd.sponge.race.trait.Trait;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.mcdnd.sponge.race.trait.Trait.builder;

public class ElfTraits {

    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase").description("Your Strength score increases by 2.").addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.DEXTERITY, 2)).build();
    public static final Trait AGE = builder().name("Age").description("Although elves reach physical maturity at about the same age as humans, the elven understanding of adulthood goes beyond physical growth to encompass worldly experience. An elf typically claims adulthood and an adult name around the age of 100 and can live to be 750 years old.").build();
    public static final Trait ALIGNMENT = builder().name("Alignment").description("Elves love freedom, variety, and self-expression, so they lean strongly toward the gentler aspects of chaos. They value and protect others' freedom as well as their own, and they are more often good than not. The drow are an exception; their exile into the Underdark has made them vicious and dangerous. Drow are more often evil than not.").build();
    public static final Trait FEY_ANCESTRY = builder().name("Fey Ancestry").description("You have advantage on saving throws against being charmed, and magic can't put you to sleep.").build();
    public static final Trait KEEN_SENSES = builder().name("Keen Senses").description("You have proficiency in the Perception skill.").addProperty(MCDNDKeys.SKILL_TYPE, SkillTypes.PERCEPTION).build();
    public static final Trait LANGUAGES = builder().name("Languages").addProperty(MCDNDKeys.LANGUAGES, Arrays.asList(Languages.COMMON, Languages.ELVISH)).description("You can speak, read, and write Common and Elvish. Elvish is fluid, with subtle intonations and intricate grammar. Elven literature is rich and varied, and their songs and poems are famous among other races. Many bards learn their language so they can add Elvish ballads to their repertoires.").build();
    public static final Trait SUBRACES = builder().name("Subraces").addProperty(MCDNDKeys.SUBRACES, ImmutableMap.<String, List<Trait>>builder().put("Dark", DarkElfTraits.ALL).put("High", HighElfTraits.ALL).put("Wood", WoodElfTraits.ALL).build()).description("Ancient divides among the elven people resulted in three main subraces: high elves, wood elves, and dark elves, who are commonly called drow. Choose one of these subraces. In some worlds, these subraces are divided still further (such as the sun elves and moon elves of the Forgotten Realms), so if you wish you can choose a narrower subrace.").build();
    public static final Trait TRANCE = builder().name("Trance").description("Elves don't need to sleep. Instead, they meditate deeply, remaining semiconscious, for 4 hours a day. (The Common word for meditation is \"trance.\") While meditating, you can dream after a fashion; such dreams are actually mental exercises that have become reflexive through years of practice. After resting in this way, you gain the same benefit that a human does from 8 hours of sleep.").build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, KEEN_SENSES, FEY_ANCESTRY, TRANCE, LANGUAGES, SUBRACES);
}
