package io.musician101.mcdnd.sponge.race.trait.elf;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapons;
import io.musician101.mcdnd.sponge.property.SizeProperty;
import io.musician101.mcdnd.sponge.data.type.CharacterSizes;
import io.musician101.mcdnd.sponge.race.trait.Trait;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.mcdnd.sponge.race.trait.Trait.builder;

public class WoodElfTraits
{
    public static final Trait DARKVISION = builder().name("Darkvision")
            .description("Accustomed to twilit forests and the night sky, you have superior vision in dark and dim conditions.")
            .addProperty(MCDNDKeys.INTEGER, 30)
            .build();
    public static final Trait ELF_WEAPON_TRAINING = builder().name("Elf Weapon Training")
            .addProperty(MCDNDKeys.WEAPONS, Arrays.asList(Weapons.LONGSWORD, Weapons.SHORTSWORD, Weapons.SHORTBOW, Weapons.LONGBOW))
            .description("You have proficiency with the longsword, shortsword, shortbow, and longbow.")
            .build();
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.WISDOM, 1))
            .description("Your Wisdom score increases by 1.")
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(4 * 12 + 6, new Dice(10, 2), 100, new Dice(6, 2), CharacterSizes.MEDIUM))
            .description("Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.")
            .build();
    public static final Trait FLEET_OF_FOOT = builder().name("Fleet of Foot")
            .addProperty(MCDNDKeys.INTEGER, 35)
            .description("Your base walking speed increases to 35 feet.")
            .build();
    public static final Trait MASK_OF_THE_WILD = builder().name("Mask of the Wild")
            .description("You can attempt to hide even when you are only lightly obscured by foliage, heavy rain, falling snow, mist, and other natural phenomena.")
            .build();
    protected static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, SIZE, FLEET_OF_FOOT, MASK_OF_THE_WILD, DARKVISION, ELF_WEAPON_TRAINING);
}
