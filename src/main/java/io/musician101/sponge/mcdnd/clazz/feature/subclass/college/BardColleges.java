package io.musician101.sponge.mcdnd.clazz.feature.subclass.college;

import java.util.Arrays;
import java.util.Collections;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;
import static io.musician101.sponge.mcdnd.util.list.FeatureList.of;

public class BardColleges
{
    public static final BardCollege LORE = ((BardCollegeBuilder) builder()).name("College of Lore").levelRequirement(3)
            .description("Bards of the College of Lore know something about most things, collecting bits of knowledge from sources as diverse as scholarly tomes and peasant tales. Whether singing folk ballads in taverns or elaborate compositions in royal courts, these bards use their gifts to hold audiences spellbound. When the applause dies down, the audience members might find themselves questioning everything they held to be true, from their faith in the priesthood of the local temple to their loyalty to the king.")
            .addToMap(3, of(Arrays.asList(LoreCollege.BONUS_PROFICIENCIES, LoreCollege.CUTTING_WORDS))).addToMap(6, of(Collections.singletonList(LoreCollege.ADDITIONAL_MAGICAL_SECRETS))).addToMap(14, of(Collections.singletonList(LoreCollege.PEERLESS_SKILL))).build();
    public static final BardCollege VALOR = ((BardCollegeBuilder) builder()).name("College of Valor").levelRequirement(3)
            .description("Bards of the College of Valor are daring skalds whose tales keep alive the memory of the great heroes of the past, and thereby inspire a new generations of heroes. These bards gather in mead halls or around great bonfires to sing the deeds of the mighty, both past and present. They travel the land to witness great bonfires to sing the deeds of the mighty, both past and present. They travel the land to witness great events firsthand and to ensure that the memory of those events doesn't pass from the world. With their songs, they inspire others to reach the same heights of the accomplishment as the heroes of old.")
            .addToMap(3, of(Arrays.asList(ValorCollege.BONUS_PROFICIENCIES, ValorCollege.COMBAT_INSPIRATION))).addToMap(6, of(Collections.singletonList(ValorCollege.BARD_EXTRA_ATTACK))).addToMap(14, of(Collections.singletonList(ValorCollege.BATTLE_MAGIC))).build();

    private BardColleges()
    {

    }
}