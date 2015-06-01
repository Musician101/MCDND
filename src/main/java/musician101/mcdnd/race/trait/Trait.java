package musician101.mcdnd.race.trait;

public class Trait
{
	String description;
	String name;
	
	public Trait(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getName()
	{
		return name;
	}
}
