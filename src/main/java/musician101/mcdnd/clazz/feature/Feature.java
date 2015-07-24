package musician101.mcdnd.clazz.feature;

import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.clazz.feature.ListFeature.ArmorProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.SavingThrowProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.SkillProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.ToolProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.WeaponProficiencyFeature;
import musician101.mcdnd.clazz.feature.SingleValueFeature.FirstLevelHPFeature;
import musician101.mcdnd.clazz.feature.SingleValueFeature.HigherLevelHPFeature;
import musician101.mcdnd.clazz.feature.SingleValueFeature.HitDiceFeature;
import musician101.mcdnd.equipment.Equipment;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Named;

public class Feature implements Described, Named
{
	String description;
	String name;
	
	public Feature(String name, String description)
	{
		this.name = name;
		this.description = description;
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
		EquipmentChoiceFeature option1;
		EquipmentChoiceFeature option2;
		
		public EquipmentChoicesFeature(EquipmentChoiceFeature option1, String description)
		{
			this(option1, null, description);
		}
		
		public EquipmentChoicesFeature(EquipmentChoiceFeature option1, EquipmentChoiceFeature option2, String description)
		{
			super("EquipmentChoices", description);
			this.option1 = option1;
			this.option2 = option2;
		}
		
		public EquipmentChoiceFeature get1stOption()
		{
			return option1;
		}
		
		public EquipmentChoiceFeature get2ndOption()
		{
			return option2;
		}
		
		public static class EquipmentChoiceFeature
		{
			int amount;
			List<? extends Equipment> list;
			
			public EquipmentChoiceFeature(Equipment equipment)
			{
				this(equipment, 1);
			}
			
			public EquipmentChoiceFeature(Equipment equipment, int amount)
			{
				this(Arrays.asList(equipment), amount);
			}
			
			public EquipmentChoiceFeature(List<? extends Equipment> equipmentList)
			{
				this(equipmentList, 1);
			}
			
			public EquipmentChoiceFeature(List<? extends Equipment> equipment, int amount)
			{
				this.list = equipment;
				this.amount = amount;
			}
			
			public List<? extends Equipment> getEquipment()
			{
				return list;
			}
			
			public int getAmount()
			{
				return amount;
			}
		}
	}
	
	public static class EquipmentFeature extends Feature
	{
		List<EquipmentChoicesFeature> equipmentChoices;
		public EquipmentFeature(EquipmentChoicesFeature... equipmentChoices)
		{
			super("Equipment", "You start with the following equipment, in addition to the equipment granted by your background:");
			this.equipmentChoices = Arrays.asList(equipmentChoices);
		}
		
		public List<EquipmentChoicesFeature> getEquipmentChoicesFeature()
		{
			return equipmentChoices;
		}
	}
	
	public static class HitPointsFeature extends Feature
	{
		FirstLevelHPFeature firstLevelHPFeature;
		HigherLevelHPFeature higherLevelHPFeature;
		HitDiceFeature hitDiceFeature;
		
		public HitPointsFeature(HitDiceFeature hitDiceFeature, FirstLevelHPFeature firstLevelHPFeature, HigherLevelHPFeature higherLevelHPFeature)
		{
			super("Hit Points", "");
			this.hitDiceFeature = hitDiceFeature;
			this.firstLevelHPFeature = firstLevelHPFeature;
			this.higherLevelHPFeature = higherLevelHPFeature;
		}
		
		public FirstLevelHPFeature getFirstLevelHPFeature()
		{
			return firstLevelHPFeature;
		}
		
		public HigherLevelHPFeature getHigherLevelHPFeature()
		{
			return higherLevelHPFeature;
		}
		
		public HitDiceFeature getHitDiceFeature()
		{
			return hitDiceFeature;
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
}
