package io.musician101.sponge.mcdnd.race.trait.halfling;

import io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.race.trait.Trait;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class StoutHalflingTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.CONSTITUTION, 1))
            .description("Your Constitution score increases by 1.")
            .build();
    public static final Trait STOUT_RESILIENCE = builder().name("Stout Resilience")
            .addProperty(MCDNDKeys.DAMAGE_TYPE, MCDNDDamageTypes.POISON)
            .description("You have advantage on saving throws against poison, and you have resistance against poison damage.")
            .build();
    protected static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, STOUT_RESILIENCE);
}
