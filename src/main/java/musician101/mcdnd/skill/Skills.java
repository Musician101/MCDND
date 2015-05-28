package musician101.mcdnd.skill;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;

public enum Skills
{
	ACROBATICS("Acrobatics", AbilityScores.DEX),
	ANIMAL_HANDLING("Animal Handling", AbilityScores.WIS),
	ARCANA("Arcana", AbilityScores.INT),
	ATHLETICS("Athletics", AbilityScores.STR),
	DECEPTION("Decpetion", AbilityScores.CHA),
	HISTORY("History", AbilityScores.INT),
	INSIGHT("Insight", AbilityScores.WIS),
	INTIMIDATION("Intimidation", AbilityScores.STR),
	INVESTIGATION("Investigation", AbilityScores.INT),
	MEDICINE("Medicine", AbilityScores.WIS),
	NATURE("Nature", AbilityScores.STR),
	PERCEPTION("Perception", AbilityScores.WIS),
	PERFORMANCE("Performance", AbilityScores.CHA),
	PERSUASION("Persuasion", AbilityScores.CHA),
	RELIGION("Religion", AbilityScores.INT),
	SLEIGHT_OF_HAND("Sleight of Hand", AbilityScores.DEX),
	STEALTH("Stealth", AbilityScores.DEX),
	SURVIVAL("Survival", AbilityScores.WIS);
	
	AbilityScores type;
	String name;
	
	private Skills(String name, AbilityScores type)
	{
		this.name = name;
		this.type = type;
	}
	
	public AbilityScores getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
}
