package musician101.mcdnd.abilityscore;

import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.util.CustomHashMap;

public abstract class AbstractAbilityScores
{
	Map<AbilityScores, AbilityScore> scores = new CustomHashMap<AbilityScores, AbilityScore>().add(AbilityScores.STR, new AbilityScore(AbilityScores.STR))
			.add(AbilityScores.DEX, new AbilityScore(AbilityScores.DEX)).add(AbilityScores.CON, new AbilityScore(AbilityScores.CON))
			.add(AbilityScores.INT, new AbilityScore(AbilityScores.INT)).add(AbilityScores.WIS, new AbilityScore(AbilityScores.WIS))
			.add(AbilityScores.CHA, new AbilityScore(AbilityScores.CHA));
	
	//TODO add point buy system and standard system array (15, 14, 13, 12, 10, 8)
	protected AbstractAbilityScores() {}
	
	protected int getAbilityScore(AbilityScores score)
	{
		return scores.get(score).getAmount();
	}
	
	public void updateScore(AbilityScore... abilityScores)
	{
		for (AbilityScore abilityScore : abilityScores)
			scores.put(abilityScore.getType(), abilityScore);
	}
}
