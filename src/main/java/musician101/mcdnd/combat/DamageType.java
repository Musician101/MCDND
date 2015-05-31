package musician101.mcdnd.combat;

public enum DamageType
{
	ACID("Acid"),
	BLUDGEONING("Bludgeoning"),
	COLD("Cold"),
	FIRE("Fire"),
	FORCE("Force"),
	LIGHTNING("Lightning"),
	NECROTIC("Necrotic"),
	NONE("None"),
	PIERCING("Piercing"),
	POISON("Poison"),
	PSYCHIC("Psychic"),
	RADIANT("Radiant"),
	SLASHING("Slashing"),
	THUNDER("Thunder");
	
	String name;
	
	private DamageType(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
