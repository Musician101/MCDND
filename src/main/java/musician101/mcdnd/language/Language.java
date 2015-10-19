package musician101.mcdnd.language;

public enum Language
{
	COMMON("Common"),
	DWARVISH("Dwarvish"),
	ELVISH("Elvish"),
	GIANT("Giant", "Dwarvish"),
	GNOMISH("Gnomish", "Dwarvish"),
	GOBLIN("Goblin", "Dwarvish"),
	HALFLING("Halfling", "Common"),
	ORC("Orc", "Dwarvish"),
	ABYSSAL("Abyssal", "Infernal", true),
	CELESTIAL("Celestial", true),
	DRACONIC("Draconic", true),
	DEEP_SPEECH("Deep Speech", true),
	INFERNAL("Infernal", true),
	PRIMORDIAL("Primordial", "Dwarvish", true),
	SYLVAN("Sylvan", "Elvish", true),
	UNDERCOMMON("Undercommon", "Elvish", true);
	
	final boolean isExotic;
	final String name;
	final String script;
	
	Language(String name, boolean isExotic)
	{
		this(name, name, isExotic);
	}
	
	Language(String name)
	{
		this(name, name);
	}
	
	Language(String name, String script)
	{
		this(name, script, false);
	}
	
	Language(String name, String script, boolean isExotic)
	{
		this.name = name;
		this.script = script;
		this.isExotic = isExotic;
	}
	
	public boolean isExotic()
	{
		return isExotic;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getScript()
	{
		return script;
	}
}
