package io.musician101.sponge.mcdnd.property.spellcasting;

import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.magic.Spell;
import io.musician101.sponge.mcdnd.property.MCDNDProperty;

import java.util.Map;

public class SpellcastingTraitProperty implements MCDNDProperty
{
    public AbilityScoreType scoreType;
    public Map<Integer, Spell> spellMap;

    public SpellcastingTraitProperty(Map<Integer, Spell> spellMap, AbilityScoreType scoreType)
    {
        this.spellMap = spellMap;
        this.scoreType = scoreType;
    }
}
