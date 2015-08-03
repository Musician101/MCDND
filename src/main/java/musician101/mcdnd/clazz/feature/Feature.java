package musician101.mcdnd.clazz.feature;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.clazz.HitDice;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Named;

public class Feature implements Described, Named
{
	int level;
	String[] description;
	String name;
	
	public Feature(String name, String... description)
	{
		this(name, 1, description);
	}
	
	public Feature(String name, int level, String... description)
	{
		this.name = name;
		this.level = level;
		this.description = description;
	}
	
	public int getLevelRequirement()
	{
		return level;
	}
	
	@Override
	public String[] getDescription()
	{
		return description;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	public static class EquipmentChoicesFeature extends Feature
	{
		EquipmentChoice option1;
		EquipmentChoice option2;
		
		public EquipmentChoicesFeature(EquipmentChoice option1, String... description)
		{
			this(option1, null, description);
		}
		
		public EquipmentChoicesFeature(EquipmentChoice option1, EquipmentChoice option2, String... description)
		{
			super("EquipmentChoices", description);
			this.option1 = option1;
			this.option2 = option2;
		}
		
		public EquipmentChoice get1stOption()
		{
			return option1;
		}
		
		public EquipmentChoice get2ndOption()
		{
			return option2;
		}
	}
	
	public static class HitPointsFeature extends Feature
	{
		HitDice dice;
		String className;
		
		public HitPointsFeature(HitDice dice, String className)
		{
			super("Hit Points", "");
			this.dice = dice;
			this.className = className;
		}
		
		public HitDice getHitDice()
		{
			return dice;
		}
		
		public String getHitPointsAtFirstLevel()
		{
			return "8 + your Constitution modifier";
		}
		
		public String getHitPointsAtHigherLevels()
		{
			return dice.toString() + " (or " + (dice.sides() / 2) + " + your Constitution modifier per " + className + " level";
		}
	}
	
	public static class UnarmoredDefenseFeature extends Feature
	{
		public UnarmoredDefenseFeature(String description)
		{
			super("Unarmored Defense", description);
		}
		
		public int getArmorClass(AbilityScore dexScore, AbilityScore conScore)
		{
			return 10 + dexScore.getMod() + conScore.getMod();
		}
	}
}
