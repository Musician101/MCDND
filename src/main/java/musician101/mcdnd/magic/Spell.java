package musician101.mcdnd.magic;

import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Named;

public class Spell implements Described, Named
{
	private final boolean needsConcentration;
	private final boolean isSomatic;
	private final boolean isVerbal;
	private final SpellLevel level;
	private final SpellType type;
	private final double castingTime;
	private final int duration;
	private final int range;
	private final String[] description;
	private final String materials;
	private final String name;
	
	public Spell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, String... description)
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
	
	// In seconds
	public double getCastingTime()
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
	
	public String getMaterials()
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
	
	@Override
	public String[] getDescription()
	{
		return description;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	public static class RitualSpell extends Spell
	{
		public RitualSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, String... description)
		{
			super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
		}
	}
	
	public enum SpellLevel
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
		
		final String name;
		
		SpellLevel(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
	
	public enum SpellType
	{
		ABJURATION("Abjuration"),
		CONJURATION("Conjuration"),
		DIVINATION("Divination"),
		ENCHANTMENT("Enchantment"),
		EVOCATION("Evocation"),
		ILLUSION("Illusion"),
		NECROMANCY("Necromancy"),
		TRANSMUTATION("Transmutation");
		
		final String name;
		
		SpellType(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
}
