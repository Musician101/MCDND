package io.musician101.sponge.mcdnd.clazz.feature.storage;

import io.musician101.sponge.mcdnd.clazz.feature.CommonFeatures;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.clazz.BarbarianFeatures;
import io.musician101.sponge.mcdnd.clazz.feature.clazz.BardFeatures;
import io.musician101.sponge.mcdnd.clazz.feature.clazz.ClericFeatures;
import io.musician101.sponge.mcdnd.util.MapUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FeatureStorages
{
    //TODO separate the sub classes (primal path, college, etc.)
    public static final FeatureStorage BARBARIAN_FEATURES = new FeatureStorage(new MapUtils<Integer, List<Feature>>()
            .add(1, Arrays.asList(BarbarianFeatures.HP, BarbarianFeatures.PROFICIENCIES, BarbarianFeatures.EQUIPMENT, BarbarianFeatures.RAGE, BarbarianFeatures.UNARMORED_DEFENSE))
            .add(2, Arrays.asList(BarbarianFeatures.RECKLESS_ATTACK, BarbarianFeatures.DANGER_SENSE))
            .add(3, Collections.singletonList(BarbarianFeatures.PRIMAL_PATH))
            .add(4, Collections.singletonList(CommonFeatures.ABILITY_SCORE_IMPROVEMENT))
            .add(5, Arrays.asList(BarbarianFeatures.EXTRA_ATTACK, BarbarianFeatures.FAST_MOVEMENT))
            .add(7, Collections.singletonList(BarbarianFeatures.FERAL_INSTINCT))
            .add(9, Collections.singletonList(BarbarianFeatures.BRUTAL_CRITICAL))
            .add(11, Collections.singletonList(BarbarianFeatures.RELENTLESS_RAGE))
            .add(15, Collections.singletonList(BarbarianFeatures.PERSISTENT_RAGE))
            .add(18, Collections.singletonList(BarbarianFeatures.INDOMITABLE_MIGHT))
            .add(20, Collections.singletonList(BarbarianFeatures.PRIMAL_CHAMPION)));
    public static final FeatureStorage BARD_FEATURES = new FeatureStorage(new MapUtils<Integer, List<Feature>>()
            .add(1, Arrays.asList(BardFeatures.HP, BardFeatures.PROFICIENCIES, BardFeatures.EQUIPMENT, BardFeatures.SPELLCASTING, BardFeatures.BARDIC_INSPIRATION))
            .add(2, Arrays.asList(BardFeatures.JACK_OF_ALL_TRADES, BardFeatures.SONG_OF_REST))
            .add(3, Collections.singletonList(BardFeatures.BARD_COLLEGE))
            .add(4, Collections.singletonList(CommonFeatures.ABILITY_SCORE_IMPROVEMENT))
            .add(5, Collections.singletonList(BardFeatures.FONT_OF_INSPIRATION))
            .add(6, Collections.singletonList(BardFeatures.COUNTERCHARM))
            .add(10, Collections.singletonList(BardFeatures.MAGICAL_SECRETS))
            .add(20, Collections.singletonList(BardFeatures.SUPERIOR_INSPIRATION)));
    public static final FeatureStorage CLERIC_FEATURES = new FeatureStorage(new MapUtils<Integer, List<Feature>>()
            .add(1, Arrays.asList(ClericFeatures.HP, ClericFeatures.PROFICIENCIES, ClericFeatures.EQUIPMENT, ClericFeatures.SPELLCASTING, ClericFeatures.DIVINE_DOMAIN)));
}
