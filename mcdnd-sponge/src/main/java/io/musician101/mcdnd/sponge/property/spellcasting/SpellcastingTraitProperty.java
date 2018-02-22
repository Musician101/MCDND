package io.musician101.mcdnd.sponge.property.spellcasting;

import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.magic.Spell;
import io.musician101.mcdnd.sponge.property.MCDNDProperty;
import java.util.Map;

public class SpellcastingTraitProperty implements MCDNDProperty {

    public AbilityScoreType scoreType;
    public Map<Integer, Spell> spellMap;

    public SpellcastingTraitProperty(Map<Integer, Spell> spellMap, AbilityScoreType scoreType) {
        this.spellMap = spellMap;
        this.scoreType = scoreType;
    }
}
