package io.musician101.sponge.mcdnd.clazz.feature;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.dice.HitDice;

import java.util.Arrays;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;

//TODO implement Properties
public class CommonFeatures
{
    public static final Feature ABILITY_SCORE_IMPROVEMENT = builder().name("Ability Score Improvement").levelRequirement(4)
            .description("When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't increase an ability score above 20 using this feature.")
            .addProperty(MCDNDKeys.ABILITY_SCORE_IMPROVEMENT_PROPERTY, Arrays.asList(4, 8, 12, 16, 19)).build();
    public static final HitDice D8 = new HitDice(8);

    private CommonFeatures()
    {

    }
}
