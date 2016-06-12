package io.musician101.sponge.mcdnd.clazz.feature.spellcasting;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;

import java.util.Optional;

//TODO see deprecation reason
/**
 * @deprecated keeping just in case I need the getDamageMod() method
 */
@Deprecated
public class SpellcastingAbility
{
    public SpellcastingAbility()
    {

    }

    public Optional<Integer> getDamageMod(AbilityScoreData score)
    {
        Optional<AbilityScoreType> scoreTypeOptional = properties.getObject(MCDNDKeys.ABILITY_SCORE_TYPE.getQuery(), AbilityScoreType.class);
        if (!scoreTypeOptional.isPresent())
            return Optional.empty();

        AbilityScoreType scoreType = scoreTypeOptional.get();
        Optional<Integer> optional = score.get(scoreType);
        if (!optional.isPresent())
            return Optional.empty();

        return Optional.of(scoreType.getMod(optional.get()));
    }
}
