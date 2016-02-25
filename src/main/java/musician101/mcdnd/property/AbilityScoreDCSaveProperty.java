package musician101.mcdnd.property;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;

//TODO move to SingleValueProperty class
@Deprecated
public class AbilityScoreDCSaveProperty extends SingleValueProperty<AbilityScoreType> implements AbilityScoreDCSave
{
    public AbilityScoreDCSaveProperty(String idPrefix, AbilityScoreType abilityScoreType)
    {
        super(idPrefix + ".property.ability_score_dc_save", abilityScoreType);
    }

    @Override
    public int getDCSave(AbilityScore score, int... bonuses)
    {
        if (getValue() != score.getType())
            throw new IllegalArgumentException("Invalid AbilityScore type for DC saving throw.");

        int save = 8 + score.getMod();
        for (int bonus : bonuses)
            save = +bonus;

        return save;
    }
}
