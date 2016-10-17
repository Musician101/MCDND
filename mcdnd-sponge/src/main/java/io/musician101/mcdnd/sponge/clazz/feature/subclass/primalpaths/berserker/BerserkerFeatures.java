package io.musician101.mcdnd.sponge.clazz.feature.subclass.primalpaths.berserker;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;

import static io.musician101.mcdnd.sponge.clazz.feature.Feature.builder;

public class BerserkerFeatures
{
    public static final Feature FRENZY = builder().name("Frenzy").levelRequirement(3)
            .description("Starting when you choose this path at 3rd level, you can go into a frenzy whn you rage. If you do so, for the duration of your rage you can make a single melee weapon attack as a bonus action on each of your turns after this one. When your rage ends, you suffer one level of exhaustion.")
            .build();
    public static final Feature MINDLESS_RAGE = builder().name("Mindless Rage").levelRequirement(6)
            .description("Beginning at 6th level, you can't be charmed or frightened while raging. If you are charmed or frightened when you enter your rage, the effect is suspended for the duration of the rage.")
            .build();
    public static final Feature INTIMIDATING_PRESENCE = builder().name("Intimidating Presence").levelRequirement(10)
            .addLineToDescription("Beginning at 10th level, you can use your action to frighten someone with your menacing presence. When you do so, choose one creature that you can see within 30 feet of you. If the creature can see or hear you, it must succeed on a Wisdom saving throw (DC equal to 8 your proficiency bonus your Charisma modifier) or be frightened of you until the end of your next turn. On subsequent turns, you can use your action to extend the duration of this effect on the frightened creature until the end of your next turn. This effect ends if the creature ends its turn out of line of sight or more than 60 feet away from you.")
            .addLineToDescription("If the creature succeeds on its saving throw, you can't use this feature on that creature again for 24 hours.")
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.CHARISMA).build();
    public static final Feature RETALIATION = builder().name("Retaliation").levelRequirement(14)
            .description("Starting at 14th level, when you take damage from a creature that is within 5 feet of you, you can use your reaction to make a melee weapon attack against that creature.")
            .build();

    private BerserkerFeatures()
    {

    }
}
