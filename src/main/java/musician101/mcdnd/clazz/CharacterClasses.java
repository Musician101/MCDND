package musician101.mcdnd.clazz;

public enum CharacterClasses
{
	BARBARIAN("Barbarian"),
	BARD("Bard"),
	CLERIC("Cleric"),
	DRUID("Druid"),
	FIGHTER("Fighter"),
	MONK("Monk"),
	PALADIN("Paladin"),
	RANGER("Ranger"),
	ROGUE("Rogue"),
	SORCERER("Sorcerer"),
	WARLOCK("Warlock"),
	WIZARD("Wizard");
	
	final String name;
	
	CharacterClasses(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
