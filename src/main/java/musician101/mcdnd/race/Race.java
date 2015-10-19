package musician101.mcdnd.race;

import java.util.List;

import musician101.mcdnd.race.trait.Trait;

public interface Race
{
	List<Trait> getTraits();
	
	String getName();
	
	enum CharacterSize
	{
		TINY("Tiny"),
		SMALL("Small"),
		MEDIUM("Medium"),
		LARGE("Large"),
		HUGE("Huge"),
		GARGANTUAN("Gargantuan");
		
		final String name;
		
		CharacterSize(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
}
