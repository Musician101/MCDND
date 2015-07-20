package musician101.mcdnd.race.trait;

import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.magic.Spell;

//TODO might need to rename this to MagicTrait
public class SpellcastingTrait extends MappedTrait<Integer, Spell>
{
	AbilityScores type;
	
	public SpellcastingTrait(String name, Map<Integer, Spell> map, AbilityScores type, String description)
	{
		super(name, map, description);
		this.type = type;
	}
	
	public AbilityScores getAbilityScoreType()
	{
		return type;
	}
}
