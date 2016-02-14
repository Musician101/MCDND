package musician101.mcdnd.property;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;

public class AbilityScoreDCSaveProperty extends SingleValueProperty<AbilityScoreType> implements AbilityScoreDCSave
{
    public AbilityScoreDCSaveProperty(String id, AbilityScoreType abilityScoreType)
    {
        super(id, abilityScoreType);
    }

    @Override
    public AbilityScoreType getAbilityScoreType()
    {
        return getValue();
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
