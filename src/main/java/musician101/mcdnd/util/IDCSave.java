package musician101.mcdnd.util;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;

public interface IDCSave
{
	AbilityScores getAbilitySaveType();
	
	int getDCSave(AbilityScore score, int... bonuses);
}
