package io.musician101.sponge.mcdnd.clazz.feature.storage;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.CommonFeatures;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.clazz.BarbarianFeatures;
import io.musician101.sponge.mcdnd.clazz.feature.clazz.BardFeatures;
import io.musician101.sponge.mcdnd.clazz.feature.clazz.ClericFeatures;
import io.musician101.sponge.mcdnd.clazz.feature.clazz.DruidFeatures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FeatureStorages
{
    public static final FeatureStorage BARBARIAN_FEATURES = new FeatureStorage(ImmutableMap.<Integer, List<Feature>>builder()
            .put(1, Arrays.asList(BarbarianFeatures.HP, BarbarianFeatures.PROFICIENCIES, BarbarianFeatures.EQUIPMENT, BarbarianFeatures.RAGE, BarbarianFeatures.UNARMORED_DEFENSE))
            .put(2, Arrays.asList(BarbarianFeatures.RECKLESS_ATTACK, BarbarianFeatures.DANGER_SENSE))
            .put(3, Collections.singletonList(BarbarianFeatures.PRIMAL_PATH))
            .put(4, Collections.singletonList(CommonFeatures.ABILITY_SCORE_IMPROVEMENT))
            .put(5, Arrays.asList(BarbarianFeatures.EXTRA_ATTACK, BarbarianFeatures.FAST_MOVEMENT))
            .put(7, Collections.singletonList(BarbarianFeatures.FERAL_INSTINCT))
            .put(9, Collections.singletonList(BarbarianFeatures.BRUTAL_CRITICAL))
            .put(11, Collections.singletonList(BarbarianFeatures.RELENTLESS_RAGE))
            .put(15, Collections.singletonList(BarbarianFeatures.PERSISTENT_RAGE))
            .put(18, Collections.singletonList(BarbarianFeatures.INDOMITABLE_MIGHT))
            .put(20, Collections.singletonList(BarbarianFeatures.PRIMAL_CHAMPION))
            .build());
    public static final FeatureStorage BARD_FEATURES = new FeatureStorage(ImmutableMap.<Integer, List<Feature>>builder()
            .put(1, Arrays.asList(BardFeatures.HP, BardFeatures.PROFICIENCIES, BardFeatures.EQUIPMENT, BardFeatures.SPELLCASTING, BardFeatures.BARDIC_INSPIRATION))
            .put(2, Arrays.asList(BardFeatures.JACK_OF_ALL_TRADES, BardFeatures.SONG_OF_REST))
            .put(3, Collections.singletonList(BardFeatures.BARD_COLLEGE))
            .put(4, Collections.singletonList(CommonFeatures.ABILITY_SCORE_IMPROVEMENT))
            .put(5, Collections.singletonList(BardFeatures.FONT_OF_INSPIRATION))
            .put(6, Collections.singletonList(BardFeatures.COUNTERCHARM))
            .put(10, Collections.singletonList(BardFeatures.MAGICAL_SECRETS))
            .put(20, Collections.singletonList(BardFeatures.SUPERIOR_INSPIRATION))
            .build());
    public static final FeatureStorage CLERIC_FEATURES = new FeatureStorage(ImmutableMap.<Integer, List<Feature>>builder()
            .put(1, Arrays.asList(ClericFeatures.HP, ClericFeatures.PROFICIENCIES, ClericFeatures.EQUIPMENT, ClericFeatures.SPELLCASTING, ClericFeatures.DIVINE_DOMAIN))
            .put(2, Collections.singletonList(ClericFeatures.CHANNEL_DIVINITY))
            .put(4, Collections.singletonList(CommonFeatures.ABILITY_SCORE_IMPROVEMENT))
            .put(5, Collections.singletonList(ClericFeatures.DESTROY_UNDEAD))
            .put(10, Collections.singletonList(ClericFeatures.DIVINE_INTERVENTION))
            .build());
    public static final FeatureStorage DRUID_FEATURES = new FeatureStorage(ImmutableMap.<Integer, List<Feature>>builder()
            .put(1, Arrays.asList(DruidFeatures.HP, DruidFeatures.PROFICIENCIES, DruidFeatures.EQUIPMENT, DruidFeatures.DRUIDIC, DruidFeatures.SPELLCASTING))
            .put(2, Arrays.asList(DruidFeatures.WILD_SHAPE, DruidFeatures.DRUID_CIRCLE))
            .put(4, Collections.singletonList(CommonFeatures.ABILITY_SCORE_IMPROVEMENT))
            .put(18, Arrays.asList(DruidFeatures.TIMELESS_BODY, DruidFeatures.BEAST_SPELLS))
            .put(20, Collections.singletonList(DruidFeatures.ARCHDRUID))
            .build());
}
