package musician101.mcdnd.race.trait;

import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Named;

public class Trait implements Described, Named
{
	private final String[] description;
	private final String name;
	
	public Trait(String name, String... description)
	{
		this.name = name;
		this.description = description;
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
	
	public static class AlignmentTrait extends Trait
	{
		protected AlignmentTrait(String description)
		{
			super("Alignment", description);
		}
	}
}
