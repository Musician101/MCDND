package musician101.mcdnd.abilityscore;

public class RaceAbilityScoreIncrease extends AbstractAbilityScores
{
    /** Use only for initial Human race creation */
    public RaceAbilityScoreIncrease()
    {
        this(new AbilityScore(AbilityScoreTypes.STR, 1), new AbilityScore(AbilityScoreTypes.DEX, 1), new AbilityScore
                (AbilityScoreTypes.CON, 1), new AbilityScore(AbilityScoreTypes.INT, 1), new AbilityScore(AbilityScoreTypes.WIS, 1),
                new AbilityScore(AbilityScoreTypes.CHA, 1));
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
