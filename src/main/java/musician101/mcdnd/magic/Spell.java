package musician101.mcdnd.magic;

import java.util.List;

public class Spell
{
	boolean needsConcentration;
	boolean isSomatic;
	boolean isVerbal;
	SpellLevel level;
	SpellType type;
	int castingTime;
	int duration;
	int range;
	List<String> materials;
	String description;
	String name;
	
	protected Spell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, List<String> materials, int duration, boolean needsConcentration, String description)
	{
		this.name = name;
		this.type = type;
		this.level = level;
		this.castingTime = castingTime;
		this.range = range;
		this.isVerbal = isVerbal;
		this.isSomatic = isSomatic;
		this.materials = materials;
		this.duration = duration;
		this.needsConcentration = needsConcentration;
		this.description = description;
	}
	
	public boolean needsConcentration()
	{
		return needsConcentration;
	}
	
	public boolean isSomatic()
	{
		return isSomatic;
	}
	
	public boolean isVerbal()
	{
		return isVerbal;
	}
	
	// Number of actions
	public int getCastingTime()
	{
		return castingTime;
	}
	
	// In seconds
	public int getDuration()
	{
		return duration;
	}
	
	public int getRange()
	{
		return range;
	}
	
	public List<String> getMaterials()
	{
		return materials;
	}
	
	public SpellLevel getLevel()
	{
		return level;
	}
	
	public SpellType getType()
	{
		return type;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getName()
	{
		return name;
	}
	
	public static enum SpellLevel
	{
		CANTRIP("Cantrip"),
		LEVEL_1("1st Level"),
		LEVEL_2("2nd Level"),
		LEVEL_3("3rd Level"),
		LEVEL_4("4th Level"),
		LEVEL_5("5th Level"),
		LEVEL_6("6th Level"),
		LEVEL_7("7th Level"),
		LEVEL_8("8th Level"),
		LEVEL_9("9th Level"),;
		
		String name;
		
		private SpellLevel(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
	
	public static enum SpellType
	{
		CONJURATION("Conjuration"),
		EVOCATION("Evocation");
		
		String name;
		
		private SpellType(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
}
