package musician101.mcdnd.clazz.feature;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.clazz.HitDice;

public class SingleValueFeature<V> extends Feature
{
	V value;
	
	public SingleValueFeature(String name, V value, String description)
	{
		super(name, description);
	}
	
	public V getValue()
	{
		return value;
	}
	
	public static class FirstLevelHPFeature extends SingleValueFeature<Integer>
	{
		public FirstLevelHPFeature(HitDice dice)
		{
			super("Hit Points at 1st Level", dice.sides(), dice.sides() + " + your Constitution modifier.");
		}
		
		public int getHP(AbilityScore score)
		{
			if (score.getType() != AbilityScores.CON)
				throw new IllegalArgumentException("Invalid ability modifier.");
			
			return getValue() + score.getMod();
		}
	}
	
	public static class HitDiceFeature extends SingleValueFeature<HitDice>
	{
		public HitDiceFeature(HitDice dice, String description)
		{
			super("Hit Dice", dice, description);
		}
	}
	
	public static class HigherLevelHPFeature extends SingleValueFeature<HitDice>
	{
		public HigherLevelHPFeature(HitDice dice)
		{
			super("Hit Points at Higher Levels", dice, dice.toString() + "(or " + dice.sides() / 2 + ") + your Constitution modifier per barbarian level after 1st.");
		}
	}
}
