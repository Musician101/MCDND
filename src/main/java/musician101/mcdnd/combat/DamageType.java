package musician101.mcdnd.combat;

public enum DamageType
{
	//TODO include weapon damage types
	ACID("Acid"),
	COLD("Cold"),
	FIRE("Fire"),
	LIGHTNING("Lightning"),
	POISON("Poison");
	
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
