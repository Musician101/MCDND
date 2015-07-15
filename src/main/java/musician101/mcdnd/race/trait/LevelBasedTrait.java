package musician101.mcdnd.race.trait;

import java.util.Map;

import musician101.mcdnd.magic.Spell;

public class LevelBasedTrait extends MappedTrait<Integer, Spell>
{
	public LevelBasedTrait(String name, Map<Integer, Spell> map, String description)
	{
		super(name, map, description);
	}
}
