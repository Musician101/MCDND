package musician101.mcdnd.abilityscore;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;

public class RaceAbilityScoreIncrease extends AbstractAbilityScores
{
	/** Use only for initial Human race creation */
	public RaceAbilityScoreIncrease()
	{
		this(new AbilityScore(AbilityScores.STR, 1), new AbilityScore(AbilityScores.DEX, 1), 
				new AbilityScore(AbilityScores.CON, 1), new AbilityScore(AbilityScores.INT, 1),
				new AbilityScore(AbilityScores.WIS, 1), new AbilityScore(AbilityScores.CHA, 1));
	}
	
	public RaceAbilityScoreIncrease(AbilityScore... scores)
	{
		super();
		updateScores(scores);
	}
	
	public int getAbilityScoreIncrease(AbilityScores score)
	{
		return getAbilityScore(score);
	}
}
