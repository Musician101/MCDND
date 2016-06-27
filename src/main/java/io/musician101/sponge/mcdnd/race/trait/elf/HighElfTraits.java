package io.musician101.sponge.mcdnd.race.trait.elf;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import io.musician101.sponge.mcdnd.property.SizeProperty;
import io.musician101.sponge.mcdnd.race.Race.CharacterSize;
import io.musician101.sponge.mcdnd.race.trait.Trait;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class HighElfTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.INTELLIGENCE, 1))
            .description("Your Intelligence score increases by 1.")
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(4 * 12 + 6, new Dice(10, 2), 90, new Dice(4, 2), CharacterSize.MEDIUM))
            .description("Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.")
            .build();
    public static final Trait CANTRIP = builder().name("Cantrip")
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.INTELLIGENCE)
            .description("You know one cantrip of your choice from the wizard spell list. Intelligence is your spellcasting ability for it.")
            .build();
    public static final Trait EXTRA_LANGUAGE = builder().name("Extra Language")
            .description("You can speak, read, and write one extra language of your choice.")
            .build();
    public static final Trait DARKVISION = builder().name("Darkvision")
            .description("Accustomed to twilit forests and the night sky, you have superior vision in dark and dim conditions.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final Trait ELF_WEAPON_TRAINING = builder().name("Elf Weapon Training")
            .addProperty(MCDNDKeys.WEAPONS, Arrays.asList(Weapons.LONGSWORD, Weapons.SHORTSWORD, Weapons.SHORTBOW, Weapons.LONGBOW))
            .description("You have proficiency with the longsword, shortsword, shortbow, and longbow.")
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 30 feet.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, SIZE, CANTRIP, EXTRA_LANGUAGE, SPEED, DARKVISION, ELF_WEAPON_TRAINING);
}
