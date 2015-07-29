package musician101.mcdnd.clazz.feature;

import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.clazz.HitDice;
import musician101.mcdnd.clazz.feature.ListFeature.ArmorProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.SavingThrowProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.SkillProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.ToolProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.WeaponProficiencyFeature;
import musician101.mcdnd.util.CustomHashMap;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Named;

public class Feature implements Described, Named
{
	int level;
	String description;
	String name;
	
	public Feature(String name, String description)
	{
		this(name, 1, description);
	}
	
	public Feature(String name, int level, String description)
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
	public String getDescription()
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
		
		public EquipmentChoicesFeature(EquipmentChoice option1, String description)
		{
			this(option1, null, description);
		}
		
		public EquipmentChoicesFeature(EquipmentChoice option1, EquipmentChoice option2, String description)
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
	
	public static class ProficienciesFeature extends Feature
	{
		ArmorProficiencyFeature armor;
		SavingThrowProficiencyFeature savingThrow;
		SkillProficiencyFeature skills;
		ToolProficiencyFeature tools;
		WeaponProficiencyFeature weapons;
		
		public ProficienciesFeature(ArmorProficiencyFeature armor, WeaponProficiencyFeature weapons, ToolProficiencyFeature tools, SavingThrowProficiencyFeature savingThrow, SkillProficiencyFeature skills)
		{
			super("Proficiencies", "");
			this.armor = armor;
			this.weapons = weapons;
			this.tools = tools;
			this.savingThrow = savingThrow;
			this.skills = skills;
		}
		
		public ArmorProficiencyFeature getArmorProficiency()
		{
			return armor;
		}
		
		public SavingThrowProficiencyFeature getSavingThrowProficiency()
		{
			return savingThrow;
		}
		
		public SkillProficiencyFeature getSkillProficiency()
		{
			return skills;
		}
		
		public ToolProficiencyFeature getToolProficiency()
		{
			return tools;
		}
		
		public WeaponProficiencyFeature getWeaponProficiency()
		{
			return weapons;
		}
	}
	
	public static class RageFeature extends Feature
	{
		int rageDamage = 2;
		int rages = 2;
		Map<Integer, Integer> rageDamageMap = new CustomHashMap<Integer, Integer>().add(1, 2).add(9, 3).add(16, 4);
		Map<Integer, Integer> ragesMap = new CustomHashMap<Integer, Integer>().add(1, 2).add(3, 3).add(6, 4).add(12, 5).add(17, 6).add(20, -1);
		
		public RageFeature()
		{
			super("Rage", "In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action.\n" +
					"While raging, you gain the following benefits if you aren't wearing heavy armor:\n" +
					"- You have advantage on Strength checks and Strength saving throws.\n" +
					"- When you make a melee weapon attack using Strength, you gain a bonus to the damage roll that increases as you gain levels as a barbarian.\n" +
					"- You have resistance to bludgeoning, piercing, and slashing damage.\n" +
					"If you are able to cast spells, you can't cast them or concentrate on them while raging.\n" +
					"Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you haven't attacked a hostile creature since your last turn or taken damage since then. You can also end your rage on your turn as a bonus action.\n" +
					"Once you have raged the number of times shown for your barbarian level, you must finish a long rest before you can rage again.");
		}
		
		public int getRageDamage()
		{
			return rageDamage;
		}
		
		public int getRages()
		{
			return rages;
		}
		
		public void update(int level)
		{
			if (rageDamageMap.containsKey(level))
				rageDamage = rageDamageMap.get(level);
			
			if (ragesMap.containsKey(level))
				rages = ragesMap.get(level);
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
