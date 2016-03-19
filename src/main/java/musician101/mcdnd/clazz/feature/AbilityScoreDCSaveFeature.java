package musician101.mcdnd.clazz.feature;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;

public class AbilityScoreDCSaveFeature extends Feature implements AbilityScoreDCSave
{
    private final AbilityScoreType scoreType;

    public AbilityScoreDCSaveFeature(String name, AbilityScoreType scoreType, String... description)
    {
        this(name, 0, scoreType, description);
    }

    public AbilityScoreDCSaveFeature(String name, int level, AbilityScoreType scoreType, String... description)
    {
        super(name, level, description);
        this.scoreType = scoreType;
    }

    @Override
    public AbilityScoreType getValue()
    {
        return scoreType;
    }

    @Override
    public int getDCSave(AbilityScore score, int... bonuses)
    {
        int mod = score.getMod();
        for (int bonus : bonuses)
            mod =+ bonus;

        return 8 + mod;
    }
}
