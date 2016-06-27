package io.musician101.sponge.mcdnd.race.trait.halfling;

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

public class HalflingTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.DEXTERITY, 1))
            .description("Your Dexterity score increases by 2.")
            .build();
    public static final Trait AGE = builder().name("Age")
            .description("A halfling reaches adulthood at the age of 20 and generally lives into the middle of his or her second century.")
            .build();
    public static final Trait ALIGNMENT = builder().name("Alignment")
            .description("Most halflings are lawful good. As a rule, they are good-hearted and kind, hate to see others in pain, and have no tolerance for oppression. They are also very orderly and traditional, leaning heavily on the support of their community and the comfort of the their old ways.")
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 25 feet.")
            .addProperty(MCDNDKeys.INTEGER, 25)
            .build();
    public static final Trait SIZE = builder().name("Size")
            .addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(2 * 12 + 7, new Dice(4, 2), 35, new Dice(1), CharacterSize.SMALL))
            .description("Halflings average about 3 feet tall and weight about 40 pounds. Your size is Small.")
            .build();
    public static final Trait LUCKY = builder().name("Lucky")
            .description("When you roll a 1 on an attack roll, ability check, or saving throw, you can reroll the die and must use the new roll.")
            .build();
    public static final Trait BRAVE = builder().name("Brave")
            .description("You have advantage on saving throws against being frightened.")
            .build();
    public static final Trait HALFLING_NIMBLENESS = builder().name("Halfling Nimbleness")
            .description("You can move through the space of any creature that is of a size larger than yours.")
            .build();
    public static final Trait LANGUAGES = builder().name("Languages")
            .addProperty(MCDNDKeys.LANGUAGES, Arrays.asList(Languages.COMMON, Languages.HALFLING))
            .description("You can speak, read, and write Common and Halfling. The Halfling language isn't secret, but halflings are loath to share it with others. They write very little, so they don't have a rich body of literature. Their oral tradition, however, is very strong. Almost all halflings speak Common to converse with the people in whose lands they dwell or through which they are traveling.")
            .build();
    public static final Trait SUBRACES = builder().name("Subraces")
            .addProperty(MCDNDKeys.SUBRACES, ImmutableMap.<String, TraitList>builder().put("Lightfoot", TraitList.of(LightfootHalflingTraits.ALL)).put("Stout", TraitList.of(StoutHalflingTraits.ALL)).build())
            .description("The two main kinds of halfling, lightfoot and stout, are more like closely related families than true subraces. Choose one of these subraces.")
            .build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, SPEED, SIZE, LUCKY, BRAVE, HALFLING_NIMBLENESS, LANGUAGES, SUBRACES);
}
