package musician101.mcdnd.clazz.features;

public class Feature
{
	String description;
	String name;
	
	public Feature(String name, String description)
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
