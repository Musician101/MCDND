package musician101.mcdnd.clazz.feature;

import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.equipment.armor.Armor.ArmorTypes;
import musician101.mcdnd.equipment.tool.Tool;
import musician101.mcdnd.equipment.weapon.Weapon;
import musician101.mcdnd.skill.Skills;

public class ProficienciesFeature extends Feature
{
	int skillAmount;
	List<ArmorTypes> armor;
	List<AbilityScores> savingThrows;
	List<Skills> skills;
	List<Tool> tools;
	List<Weapon> weapons;
	String armorString;
	String toolString;
	String savingThrowString;
	String skillString;
	String weaponString;
	
	public ProficienciesFeature(List<ArmorTypes> armor, String armorString, List<Weapon> weapons, String weaponString, List<Tool> tools, String toolString, List<AbilityScores> savingThrows, String savingThrowString, List<Skills> skills, int skillAmount, String skillString)
	{
		super("Proficiencies", "");
		this.armor = armor;
		this.armorString = armorString;
		this.weapons = weapons;
		this.weaponString = weaponString;
		this.tools = tools;
		this.toolString = toolString;
		this.savingThrows = savingThrows;
		this.savingThrowString = savingThrowString;
		this.skills = skills;
		this.skillAmount = skillAmount;
		this.skillString = skillString;
	}
	
	public int getSkillAmount()
	{
		return skillAmount;
	}
	
	public List<ArmorTypes> getArmorProficiency()
	{
		return armor;
	}
	
	public List<AbilityScores> getSavingThrowProficiency()
	{
		return savingThrows;
	}
	
	public List<Skills> getSkillProficiency()
	{
		return skills;
	}
	
	public List<Tool> getToolProficiency()
	{
		return tools;
	}
	
	public List<Weapon> getWeaponProficiency()
	{
		return weapons;
	}
	
	public String getArmorString()
	{
		return armorString;
	}
	
	public String getToolString()
	{
		return toolString;
	}
	
	public String getSavingThrowString()
	{
		return savingThrowString;
	}
	
	public String getSkillString()
	{
		return skillString;
	}
	
	public String getWeaponString()
	{
		return weaponString;
	}
}