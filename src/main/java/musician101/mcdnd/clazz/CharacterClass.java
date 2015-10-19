package musician101.mcdnd.clazz;

import java.util.List;

import musician101.mcdnd.equipment.armor.Armor;
import musician101.mcdnd.skill.Skills;

public class CharacterClass
{
	//TODO figure out how to incorporate starting equipment
	//TODO Archetypes, Paths, Schools, etc. will be a different class from Features
	//TODO do something similar to SpongeAPI's DataManipulators
	private List<Armor> armorProficiencies;
	private List<Skills> skillProficiencies;
	private HitDice hitDice;
	private int level;
	private String name;
	
	public CharacterClass()
	{
		
	}
	
	public List<Armor> getArmorProficiencies()
	{
		return armorProficiencies;
	}
	
	public List<Skills> getSkillProficiencies()
	{
		return skillProficiencies;
	}
	
	public HitDice getHitDice()
	{
		return hitDice;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public String getName()
	{
		return name;
	}
}
