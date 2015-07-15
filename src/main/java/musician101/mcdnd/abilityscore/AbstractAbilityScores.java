package musician101.mcdnd.abilityscore;

import java.util.HashMap;
import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;

public abstract class AbstractAbilityScores
{
	Map<AbilityScores, AbilityScore> scores = new HashMap<AbilityScores, AbilityScore>();
	
	//TODO add point buy system and standard system array (15, 14, 13, 12, 10, 8)
	protected AbstractAbilityScores() {}
	
	protected int getAbilityScore(AbilityScores score)
	{
		return scores.get(score).getAmount();
	}
	
	public void updateScores(AbilityScore... abilityScores)
	{
		for (AbilityScore abilityScore : abilityScores)
			scores.put(abilityScore.getType(), abilityScore);
	}
}
