package musician101.mcdnd.clazz.feature;

import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.equipment.Armor.ArmorTypes;
import musician101.mcdnd.equipment.tool.Tool;
import musician101.mcdnd.equipment.weapon.Weapon.WeaponType;
import musician101.mcdnd.skill.Skills;
import musician101.mcdnd.util.Interfaces.Listed;

public class ListFeature<T> extends Feature implements Listed<T>
{
	List<T> list;
	
	public ListFeature(String name, List<T> list, String description)
	{
		this(name, 1, list, description);
	}
	
	public ListFeature(String name, int level, List<T> list, String description)
	{
		super(name, level, description);
		this.list = list;
	}
	
	@Override
	public List<T> getList()
	{
		return list;
	}
	
	@Override
	public T get(int index)
	{
		return list.get(index);
	}
	
	public static class AbilityScoreImprovementFeature extends ListFeature<Integer>
	{
		public AbilityScoreImprovementFeature(List<Integer> levels, String description)
		{
			super("Ability Score Improvement", levels.get(1), levels, description);
		}
	}
	
	public static class ArmorProficiencyFeature extends ListFeature<ArmorTypes>
	{
		public ArmorProficiencyFeature(List<ArmorTypes> armorTypes, String description)
		{
			super("Armor", armorTypes, description);
		}
	}
	
	public static class EquipmentFeature extends ListFeature<EquipmentChoicesFeature>
	{
		public EquipmentFeature(EquipmentChoicesFeature... equipmentChoices)
		{
			super("Equipment", Arrays.asList(equipmentChoices), "You start with the following equipment, in addition to the equipment granted by your background:");
		}
	}
	
	public static class SavingThrowProficiencyFeature extends ListFeature<AbilityScores>
	{
		public SavingThrowProficiencyFeature(List<AbilityScores> savingThrows, String description)
		{
			super("SavingThrows", savingThrows, description);
		}
	}
	
	public static class SkillProficiencyFeature extends ListFeature<Skills>
	{
		int amount;
		
		public SkillProficiencyFeature(List<Skills> skills, int amount, String description)
		{
			super("Skills", skills, description);
			this.amount = amount;
		}
		
		public int getAmount()
		{
			return amount;
		}
	}
	
	public static class ToolProficiencyFeature extends ListFeature<Tool>
	{
		public ToolProficiencyFeature(List<Tool> tools, String description)
		{
			super("Tools", tools, description);
		}
	}
	
	public static class WeaponProficiencyFeature extends ListFeature<WeaponType>
	{
		public WeaponProficiencyFeature(List<WeaponType> weaponTypes, String description)
		{
			super("Weapons", weaponTypes, description);
		}
	}
}
