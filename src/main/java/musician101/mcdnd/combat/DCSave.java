package musician101.mcdnd.combat;

import musician101.mcdnd.abilityscore.AbilityScore;

public interface DCSave
{
	int getRequiredDCSave(AbilityScore score, int proficiencyBonus);
}
