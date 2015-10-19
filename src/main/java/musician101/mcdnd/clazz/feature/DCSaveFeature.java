package musician101.mcdnd.clazz.feature;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.util.Interfaces.DCSave;

public class DCSaveFeature extends Feature implements DCSave
{
	private final AbilityScores scoreType;
	
	public DCSaveFeature(String name, AbilityScores scoreType, String... description)
	{
		this(name, 0, scoreType, description);
	}
	
	public DCSaveFeature(String name, int level, AbilityScores scoreType, String... description)
	{
		super(name, level, description);
		this.scoreType = scoreType;
	}
	
	@Override
	public AbilityScores getAbilitySaveType()
	{
		return scoreType;
	}
	
	@Override
	public int getDCSave(AbilityScore score, int... bonuses)
	{
		int mod = score.getMod();
		for (int bonus : bonuses)
			mod =+ bonus;
		
		return 8 + mod;
	}
	
}
