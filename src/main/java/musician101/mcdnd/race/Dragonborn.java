package musician101.mcdnd.race;

import java.util.ArrayList;
import java.util.List;

import musician101.mcdnd.race.trait.Trait;

public abstract class Dragonborn implements Race
{
	List<Trait> traits;
	
	protected Dragonborn()
	{
		//traits.add();
	}
	
	public static class BlackDragonborn extends Dragonborn
	{
		public BlackDragonborn()
		{
			super();
		}

		@Override
		public List<Trait> getTraits()
		{
			List<Trait> list = new ArrayList<Trait>();
			return list;
		}

		@Override
		public String getName()
		{
			return "Black Dragonborn";
		}
	}
	
	public static class BlueDragonborn extends Dragonborn
	{
		public BlueDragonborn() {}

		@Override
		public List<Trait> getTraits()
		{
			return null;
		}

		@Override
		public String getName()
		{
			return "Blue Dragonborn";
		}
	}
	
	public static class BrassDragonborn extends Dragonborn
	{
		public BrassDragonborn() {}

		@Override
		public List<Trait> getTraits()
		{
			return null;
		}

		@Override
		public String getName()
		{
			return "Brass Dragonborn";
		}
	}
}
