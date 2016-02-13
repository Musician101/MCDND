package musician101.mcdnd.abilityscore;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScoreType;

public class RaceAbilityScoreIncrease extends AbstractAbilityScores
{
    /** Use only for initial Human race creation */
    public RaceAbilityScoreIncrease()
    {
        this(new AbilityScore(AbilityScoreType.STR, 1), new AbilityScore(AbilityScoreType.DEX, 1), new AbilityScore
                (AbilityScoreType.CON, 1), new AbilityScore(AbilityScoreType.INT, 1), new AbilityScore(AbilityScoreType.WIS, 1),
                new AbilityScore(AbilityScoreType.CHA, 1));
    }

    public RaceAbilityScoreIncrease(AbilityScore... scores)
    {
        super();
        updateScores(scores);
    }

    public int getAbilityScoreIncrease(AbilityScoreType score)
    {
        return getAbilityScore(score);
    }
}
