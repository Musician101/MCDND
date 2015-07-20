package musician101.mcdnd.race.trait;

import java.util.List;
import java.util.Map;

public class SubraceTrait extends MappedTrait<String, List<? extends Trait>>
{
	public SubraceTrait(Map<String, List<? extends Trait>> map, String description)
	{
		super("Subrace", map, description);
	}
}
