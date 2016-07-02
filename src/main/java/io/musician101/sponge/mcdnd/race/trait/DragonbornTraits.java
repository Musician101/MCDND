package io.musician101.sponge.mcdnd.race.trait;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.CharacterSizes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.language.Languages;
import io.musician101.sponge.mcdnd.property.SizeProperty;

import java.util.Arrays;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class DragonbornTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .description("Your Strength score increases by 2, and your Charisma score increases by 1.")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, ImmutableMap.<AbilityScoreType, Integer>builder().put(AbilityScoreTypes.STRENGTH, 2).put(AbilityScoreTypes.CHARISMA, 1).build())
            .build();
    public static final Trait AGE = builder().name("Age")
            .description("Young dragonborns grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.")
            .build();
    public static final Trait ALIGNMENT = builder().name("Alignment")
            .description("Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil (represented by Bahamut and Tiamat, respectively). Most dragonborn are good, but those who side with Tiamat can be terrible villains.")
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 30 feet.")
            .addProperty(MCDNDKeys.MOVEMENT_SPEED, 30)
            .build();
    public static final Trait SIZE = builder().name("Size")
            .description("Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(5 * 12 + 6, new Dice(8, 2), 110, new Dice(4, 2), CharacterSizes.MEDIUM))
            .build();
    public static final Trait DRACONIC_ANCESTRY = builder().name("Draconic Ancestry")
            .description("You hae draconic ancestry. Choose one type of dragon from the Draconic Ancestry table. Your breath weapon and the damage resistance are determined by the dragon type, as shown in the table.")
            .build();
    public static final Trait BREATH_WEAPON = builder().name("Breath Weapon")
            .description("You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation.", "When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8+ your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at 6th level, 4d6 at 11th level, and 5d6 at 16th level.", "After you use your breathe weapon, you can't use it again until you complete a short or long rest.")
            .build();
    public static final Trait LANGUAGES = builder().name("Languages")
            .description("You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.")
            .addProperty(MCDNDKeys.LANGUAGES, Arrays.asList(Languages.COMMON, Languages.DRACONIC))
            .build();
    public static final List<Trait> ALL =  Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, SPEED, SIZE, DRACONIC_ANCESTRY, BREATH_WEAPON, LANGUAGES);
}
