package musician101.mcdnd.clazz.feature.totem;

import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Named;

public class Totem implements Described, Named
{
	String[] description;
	String name;
	
	public Totem(String name, String... description)
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
	
	public static class BearTotem extends Totem
	{
		public BearTotem(String description)
		{
			super("Bear", description);
		}
	}
	
	public static class EagleTotem extends Totem
	{
		public EagleTotem(String description)
		{
			super("Eagle", description);
		}
	}
	
	public static class WolfTotem extends Totem
	{
		public WolfTotem(String description)
		{
			super("Wolf", description);
		}
	}
}
