package musician101.mcdnd.magic;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;

public class DCSaveSpell extends Spell
{
	AbilityScores type;
	
	public DCSaveSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, int duration, boolean needsConcentration, AbilityScores scoreType, String... description)
	{
		this(name, type, level, castingTime, range, isVerbal, isSomatic, "", duration, needsConcentration, scoreType, description);
	}
	
	public DCSaveSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, AbilityScores scoreType, String... description)
	{
		super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
		this.type = scoreType;
	}

	public AbilityScores getAbilityScoreType()
	{
		return type;
	}
	
	public int getDCSave(AbilityScore score, int... bonuses)
	{
		if (type != score.getType())
			throw new IllegalArgumentException("Invalid AbilityScore type for DC saving throw.");
		
		int save = 8 + score.getMod();
		for (int bonus : bonuses)
			save =+ bonus;
		
		return save;
	}
}
