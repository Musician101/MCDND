package io.musician101.sponge.mcdnd.race.trait;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.language.Languages;
import io.musician101.sponge.mcdnd.property.SizeProperty;
import io.musician101.sponge.mcdnd.data.type.CharacterSizes;

import java.util.Arrays;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class HalfOrcTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, ImmutableMap.<AbilityScoreType, Integer>builder().put(AbilityScoreTypes.STRENGTH, 2).put(AbilityScoreTypes.CONSTITUTION, 1).build())
            .description("Your Strength score increases by 2, and your Constitution score increases by 1.")
            .build();
    public static final Trait AGE = builder().name("Age")
            .description("Half-orcs mature a little faster than humans, reaching adulthood around age 14. They age noticeably faster and rarely live longer than 75 years.")
            .build();
    public static final Trait ALIGNMENT = builder().name("Alignment")
            .description("Half-orcs inherit a tendency toward chaos from their orc parents and are not strongly inclined toward good. Half-orcs raised among orcs and willing to live out their lives among them are usually evil.")
            .build();
    public static final Trait DARKVISION = builder().name("Darkvision")
            .description("Thanks to your orc blood, you have superior vision in dark and dim conditions.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .description("Your movement speed is 30 feet.")
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(4 * 12 + 10, new Dice(10, 2), 140, new Dice(6, 2), CharacterSizes.MEDIUM))
            .description("Half-orcs are somewhat larger and bulkier than humans, and they range from 5 to well over 6 feet tall. Your size is Medium.")
            .build();
    public static final Trait MENACING = builder().name("Menacing")
            .addProperty(MCDNDKeys.SKILL_TYPE, SkillTypes.INTIMIDATION)
            .description("You gain proficiency in the Intimidation skill.")
            .build();
    public static final Trait RELENTLESS_ENDURANCE = builder().name("Relentless Endurance")
            .description("When you are reduced to 0 hit points but not killed outright, you can drop to 1 hit point instead. You can't use this feature again until you finish a long rest.")
            .build();
    public static final Trait LANGUAGES = builder().name("Languages")
            .addProperty(MCDNDKeys.LANGUAGES, Arrays.asList(Languages.COMMON, Languages.ORC))
            .description("You can speak, read, and write Common and Orc. Orc is a harsh, grating language with hard consonants. It has no script of its own but is written in the Dwarvish script.")
            .build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, DARKVISION, SPEED, SIZE, MENACING, RELENTLESS_ENDURANCE, LANGUAGES);
}
