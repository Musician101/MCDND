package musician101.mcdnd.race.trait;

import java.util.List;
import java.util.Map;

public class SubraceTrait extends MappedTrait<String, List<Trait>>
{
	public SubraceTrait(Map<String, List<Trait>> map, String description)
	{
		super("Subrace", map, description);
	}
}
