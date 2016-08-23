package io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths;

import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.berserker.BerserkerFeatures;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.totem.TotemWarriorFeatures;

import java.util.Arrays;
import java.util.Collections;

import static io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.PrimalPath.builder;
import static io.musician101.sponge.mcdnd.util.list.FeatureList.of;

public class PrimalPaths
{
    public static final PrimalPath BERSERKER = builder().name("Path of the Berserker")
            .description("For some barbarians, rage is a means to an end-that end being violence. The Path of the Berserker is a path of untrammeled fury, slick with blood. As you enter the berserker's rage, you thrill in the chaos of battle, heedless of your own health or well-being.")
            .addToMap(3, of(Collections.singletonList(BerserkerFeatures.FRENZY))).addToMap(6, of(Collections.singletonList(BerserkerFeatures.MINDLESS_RAGE))).addToMap(10, of(Collections.singletonList(BerserkerFeatures.INTIMIDATING_PRESENCE))).addToMap(14, of(Collections.singletonList(BerserkerFeatures.RETALIATION)))
            .build();
    public static final PrimalPath TOTEM_WARRIOR = builder().name("Path of the Totem Warrior")
            .addLineToDescription("The Path of the Totem Warrior is a spiritual journey, as the barbarian accepts a spirit animal as guide, protector, and inspiration. In battle, your totem spirit fills you with supernatural might, adding magical fuel to your barbarian rage.")
            .addLineToDescription("Most barbarian tribes consider a totem animal to be kin to a particular clan. In such cases, it is unusual for an individual to have more than one totem animal spirit, though exceptions exist.")
            .addToMap(3,of(Arrays.asList(TotemWarriorFeatures.SPIRIT_SEEKER, TotemWarriorFeatures.TOTEM_SPIRIT))).addToMap(6,of(Collections.singletonList(TotemWarriorFeatures.ASPECT_OF_THE_BEAST))).addToMap(10,of(Collections.singletonList(TotemWarriorFeatures.SPIRIT_WALKER))).addToMap(14,of(Collections.singletonList(TotemWarriorFeatures.TOTEMIC_ATTUNEMENT)))
            .build();

    private PrimalPaths()
    {

    }
}
