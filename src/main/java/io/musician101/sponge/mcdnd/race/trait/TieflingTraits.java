package io.musician101.sponge.mcdnd.race.trait;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.CharacterSizes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.language.Languages;
import io.musician101.sponge.mcdnd.magic.Spell;
import io.musician101.sponge.mcdnd.magic.Spells;
import io.musician101.sponge.mcdnd.property.SizeProperty;
import io.musician101.sponge.mcdnd.property.spellcasting.SpellcastingTraitProperty;

import java.util.Arrays;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class TieflingTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, ImmutableMap.<AbilityScoreType, Integer>builder().put(AbilityScoreTypes.INTELLIGENCE, 1).put(AbilityScoreTypes.CHARISMA, 2).build())
            .description("Your Intelligence score increases by 1, and your Charisma score increases by 2.")
            .build();
    public static final Trait AGE = builder().name("Age")
            .description("Tieflings mature at the same rate as humans but live a few years longer.")
            .build();
    public static final Trait ALIGNMENT = builder().name("Alignment")
            .description("Tieflings might not have an innate tendency toward evil, but many of them end up there. Evil or not an independent nature inclines many tieflings toward a chaotic alignment.")
            .build();
    public static final Trait DARKVISION = builder().name("Darkvision")
            .description("Thanks to your infernal heritage, you have superior vision in dark and dim conditions.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 30 feet.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(4 * 12 + 9, new Dice(8, 2), 110, new Dice(4, 2), CharacterSizes.MEDIUM))
            .description("Tieflings are about the same size and build as humans. Your size is Medium.")
            .build();
    public static final Trait HELLISH_RESISTANCE = builder().name("Hellish Resistance")
            .addProperty(MCDNDKeys.DAMAGE_TYPE, MCDNDDamageTypes.FIRE)
            .description("You have resistance to fire damage.")
            .build();
    public static final Trait INFERNAL_LEGACY = builder().name("Infernal Legacy")
            .addProperty(MCDNDKeys.SPELLCASTING_TRAIT_PROPERTY, new SpellcastingTraitProperty(ImmutableMap.<Integer, Spell>builder().put(1,Spells.THAUMATURGY).put(3,Spells.HELLISH_REBUKE).put(5,Spells.DARKNESS).build(), AbilityScoreTypes.CHARISMA))
            .description("You know the Thaumaturgy cantrip. Once you reach 3rd level, you can cast the Hellish Rebuke spell once per day as a 2nd-level spell. Once you reach 5th level, you can also cast the Darkness spell once per day. Charisma is your spellcasting ability for these spells.")
            .build();
    public static final Trait LANGUAGES = builder().name("Languages")
            .addProperty(MCDNDKeys.LANGUAGES, Arrays.asList(Languages.COMMON, Languages.INFERNAL))
            .description("You can speak, read, and write Common and Infernal.")
            .build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, DARKVISION, SPEED, SIZE, HELLISH_RESISTANCE, INFERNAL_LEGACY, LANGUAGES);
}
