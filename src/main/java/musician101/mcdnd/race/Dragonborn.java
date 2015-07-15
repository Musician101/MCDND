package musician101.mcdnd.race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.abilityscore.RaceAbilityScoreIncrease;
import musician101.mcdnd.language.Language;
import musician101.mcdnd.race.trait.Trait;

public abstract class Dragonborn implements Race
{
	List<Trait> traits;
	
	protected Dragonborn()
	{
		//traits.add();
	}
	
	@Override
	public Age getAge()
	{
		return Age.DRAGONBORN;
	}

	@Override
	public CharacterSize getSize()
	{
		return CharacterSize.MEDIUM;
	}

	@Override
	public int getMovmentSpeed()
	{
		return 30;
	}

	@Override
	public List<Language> getLanguages()
	{
		return Arrays.asList(Language.COMMON, Language.DRACONIC);
	}
	
	@Override
	public RaceAbilityScoreIncrease getAbilityScoreIncrease()
	{
		return new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.CHA, 1), new AbilityScore(AbilityScores.STR, 2));
	}
	
	@Override
	public Vision getVision()
	{
		return Vision.NORMAL;
	}
	
	public static class BlackDragonborn extends Dragonborn
	{
		public BlackDragonborn()
		{
			super();
		}

		@Override
		public List<Trait> getTraits()
		{
			List<Trait> list = new ArrayList<Trait>();
			return list;
		}

		@Override
		public String getName()
		{
			return "Black Dragonborn";
		}
	}
	
	public static class BlueDragonborn extends Dragonborn
	{
		public BlueDragonborn() {}

		@Override
		public List<Trait> getTraits()
		{
			return null;
		}

		@Override
		public String getName()
		{
			return "Blue Dragonborn";
		}
	}
	
	public static class BrassDragonborn extends Dragonborn
	{
		public BrassDragonborn() {}

		@Override
		public List<Trait> getTraits()
		{
			return null;
		}

		@Override
		public String getName()
		{
			return "Brass Dragonborn";
		}
	}
}
