package io.musician101.sponge.mcdnd.race.trait.elf;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import io.musician101.sponge.mcdnd.magic.Spell;
import io.musician101.sponge.mcdnd.magic.Spells;
import io.musician101.sponge.mcdnd.property.SizeProperty;
import io.musician101.sponge.mcdnd.property.spellcasting.SpellcastingTraitProperty;
import io.musician101.sponge.mcdnd.data.type.CharacterSizes;
import io.musician101.sponge.mcdnd.race.trait.Trait;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class DarkElfTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.CHARISMA, 1))
            .description("Your Charisma score increases by 1.")
            .build();
    public static final Trait DARKVISION = builder().name("Superior Darkvision")
            .addProperty(MCDNDKeys.INTEGER, 120)
            .description("Your darkvision has a radius of 120 feet.")
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(4 * 12 + 5, new Dice(6, 2), 75, new Dice(4, 2), CharacterSizes.MEDIUM))
            .description("Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.")
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 30 feet.")
            .build();
    public static final Trait SUNLIGHT_SENSITIVITY = builder().name("Sunlight Sensitivity")
            .addProperty(MCDNDKeys.SKILL_TYPE, SkillTypes.PERCEPTION)
            .description("You have disadvantage on attack rolls and on Wisdom (Perception) checks that rely on sight when you, the target of your attack, or whatever you are trying to perceive is in direct sunlight.")
            .build();
    public static final Trait DROW_MAGIC = builder().name("Drow Magic")
            .addProperty(MCDNDKeys.SPELLCASTING_TRAIT_PROPERTY, new SpellcastingTraitProperty(ImmutableMap.<Integer, Spell>builder().put(1,Spells.DANCING_LIGHTS).put(3,Spells.FAERIE_FIRE).put(5,Spells.DARKNESS).build(), AbilityScoreTypes.CHARISMA))
            .description("You know the dancing lights cantrip. When you reach 3rd level, you can cast the faerie fire spell once per day. When you reach 5th level, you can also cast the darkness spell once per day. Charisma is your spellcasting ability for these spells.")
            .build();
    public static final Trait DROW_WEAPON_TRAINING = builder().name("Drow Weapon Training").addProperty(MCDNDKeys.WEAPONS, Arrays.asList(Weapons.RAPIER, Weapons.SHORTSWORD, Weapons.HAND_CROSSBOW))
            .description("You have proficiency with rapiers, shortswords, and hand crossbows.")
            .build();
    protected static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, DARKVISION, SIZE, SUNLIGHT_SENSITIVITY, DROW_MAGIC, DROW_WEAPON_TRAINING, SPEED);
}
