package musician101.mcdnd.race.trait;

public class DarkvisionTrait extends SingleValueTrait<Integer>
{
	public DarkvisionTrait(String description)
	{
		this("Darkvision", 60, description + " You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.");
	}
	
	public DarkvisionTrait(String name, int distance, String description)
	{
		super(name, distance, description);
	}
}
