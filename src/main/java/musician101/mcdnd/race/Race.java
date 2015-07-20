package musician101.mcdnd.race;

import java.util.List;

import musician101.mcdnd.race.trait.Trait;

public interface Race
{
	public List<Trait> getTraits();
	
	public String getName();
	
	public static enum CharacterSize
	{
		TINY("Tiny"),
		SMALL("Small"),
		MEDIUM("Medium"),
		LARGE("Large"),
		HUGE("Huge"),
		GARGANTUAN("Gargantuan");
		
		String name;
		
		private CharacterSize(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
}
