package io.musician101.mcdnd.sponge.race.trait.dwarf;

import com.google.common.collect.ImmutableList;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.data.type.CharacterSizes;
import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.property.SizeProperty;
import io.musician101.mcdnd.sponge.race.trait.Trait;
import java.util.Collections;
import java.util.List;

import static io.musician101.mcdnd.sponge.race.trait.Trait.builder;

public class HillDwarfTraits {

    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase").description("Your Wisdom score increases by 1.").addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.<AbilityScoreType, Integer>singletonMap(AbilityScoreTypes.WISDOM, 1)).build();
    public static final Trait DWARVEN_TOUGHNESS = builder().name("Dwarven Toughness").description("Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.").build();
    public static final Trait SIZE = builder().name("Size").description("Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium.").addProperty(MCDNDKeys.SIZE_PROPERTY, new SizeProperty(3 * 12 + 8, new Dice(4, 2), 115, new Dice(6, 2), CharacterSizes.MEDIUM)).build();
    protected static final List<Trait> ALL = ImmutableList.<Trait>builder().add(ABILITY_SCORE_INCREASE, SIZE, DWARVEN_TOUGHNESS).build();
}
