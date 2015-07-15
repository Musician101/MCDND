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
	
	boolean isExotic;
	String name;
	String script;
	
	private Language(String name, boolean isExotic)
	{
		this(name, name, isExotic);
	}
	
	private Language(String name)
	{
		this(name, name);
	}
	
	private Language(String name, String script)
	{
		this(name, script, false);
	}
	
	private Language(String name, String script, boolean isExotic)
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
