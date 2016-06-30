package io.musician101.sponge.mcdnd.property.spellcasting;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.magic.Spell;
import io.musician101.sponge.mcdnd.property.MCDNDProperty;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import java.util.Map;

public class SpellcastingTraitProperty extends MCDNDProperty
{
    public AbilityScoreType scoreType;
    public Map<Integer, Spell> spellMap;

    public SpellcastingTraitProperty(Map<Integer, Spell> spellMap, AbilityScoreType scoreType)
    {
        this.spellMap = spellMap;
        this.scoreType = scoreType;
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.ABILITY_SCORE_TYPE, scoreType)
                .set(MCDNDKeys.SPELL_MAP, spellMap);
    }
}
