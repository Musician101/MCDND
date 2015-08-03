package musician101.mcdnd.clazz.feature;

import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.magic.Spell.SpellLevel;

public class SpellcastingFeature extends Feature
{
	Cantrips cantrips;
	RitualCasting ritualCasting;
	SpellcastingAbility spellcastingAbility;
	SpellcastingFocus spellcastingFocus;
	SpellsKnown spellsKnown;
	SpellSlots spellSlots;
	
	public SpellcastingFeature(Cantrips cantrips, SpellSlots spellSlots, SpellsKnown spellsKnown, RitualCasting ritualCasting, SpellcastingFocus spellcastingFocus, String... description)
	{
		super("Spellcasting", description);
		this.cantrips = cantrips;
		this.spellSlots = spellSlots;
		this.spellsKnown = spellsKnown;
		this.ritualCasting = ritualCasting;
		this.spellcastingFocus = spellcastingFocus;
	}
	
	public Cantrips getCantrips()
	{
		return cantrips;
	}
	
	public static class Cantrips extends MappedFeature<Integer, Integer>
	{
		public Cantrips(Map<Integer, Integer> map, String... description)
		{
			super("Cantrips", map, description);
		}
	}
	
	public static class RitualCasting extends Feature
	{
		public RitualCasting(String... description)
		{
			super("Ritual Casting", description);
		}
	}
	
	public static class SpellcastingAbility extends DCSaveFeature
	{
		public SpellcastingAbility(AbilityScores scoreType, String... description)
		{
			super("Spellcasting Ability", scoreType, description);
		}

		public int getDamageMod(AbilityScore score, int bonus)
		{
			return score.getMod() + bonus;
		}
	}
	
	public static class SpellcastingFocus extends Feature
	{
		public SpellcastingFocus(String... description)
		{
			super("Spellcasting Focus", description);
		}
	}
	
	public static class SpellsKnown extends MappedFeature<Integer, Integer>
	{
		public SpellsKnown(Map<Integer, Integer> map, String... description)
		{
			super("Spells Known of 1st Level and Higher", map, description);
		}
	}
	
	public static class SpellSlots extends MappedFeature<SpellLevel, Map<Integer, Integer>>
	{
		public SpellSlots(Map<SpellLevel, Map<Integer, Integer>> map, String... description)
		{
			super("Spell Slots", map, description);
		}
	}
}
