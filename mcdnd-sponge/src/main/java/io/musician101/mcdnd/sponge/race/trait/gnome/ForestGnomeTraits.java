package io.musician101.mcdnd.sponge.race.trait.gnome;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.magic.Spells;
import io.musician101.mcdnd.sponge.race.trait.Trait;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.mcdnd.sponge.race.trait.Trait.builder;

public class ForestGnomeTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.DEXTERITY, 1))
            .description("Your Dexterity score increases by 1.")
            .build();
    public static final Trait NATURAL_ILLUSIONIST = builder().name("Natural Illusionist")
            .addProperty(MCDNDKeys.SPELL, Spells.MINOR_ILLUSION)
            .description("You know the Minor Illusion cantrip. Intelligence is your spellcasting ability for it.")
            .build();
    public static final Trait SPEAK_WITH_SMALL_BEASTS = builder().name("Speak with Small Beasts")
            .description("Through sounds and gestures, you can communicate simple ideas with Small or smaller beasts. Forest gnomes love animals and often keep squirrels, badgers, rabbits, moles, woodpeckers, and other creatures as beloved pets.")
            .build();
    protected static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, NATURAL_ILLUSIONIST, SPEAK_WITH_SMALL_BEASTS);
}
