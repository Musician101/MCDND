package musician101.mcdnd.race.trait;

import musician101.mcdnd.abilityscore.RaceAbilityScoreIncrease;

public class AbilityScoreIncreaseTrait extends SingleValueTrait<RaceAbilityScoreIncrease>
{
	protected AbilityScoreIncreaseTrait(RaceAbilityScoreIncrease trait, String description)
	{
		super("Ability Score Increase", trait, description);
	}
}
