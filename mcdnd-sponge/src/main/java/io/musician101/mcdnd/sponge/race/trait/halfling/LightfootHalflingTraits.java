package io.musician101.mcdnd.sponge.race.trait.halfling;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.race.trait.Trait;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.mcdnd.sponge.race.trait.Trait.builder;

public class LightfootHalflingTraits {

    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase").addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.CHARISMA, 1)).description("Your Charisma score increases by 1.").build();
    public static final Trait NATURALLY_STEALTHY = builder().name("Naturally Stealthy").description("You can attempt to hide even when you are obscured only by a creature that is at least one size larger than you.").build();
    protected static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, NATURALLY_STEALTHY);
}
