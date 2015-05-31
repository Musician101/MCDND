package musician101.mcdnd.clazz;

import java.util.List;

import musician101.mcdnd.armor.Armor;

public class CharacterClass
{
	List<Armor> armorProficiencies;
	HitDice hitDice;
	int level;
	String name;
	
	public CharacterClass()
	{
		
	}
	
	public List<Armor> getArmorProficiencies()
	{
		return armorProficiencies;
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
