package musician101.mcdnd.race.trait;

public class MinMaxTrait extends Trait
{
	int max;
	int min;
	
	public MinMaxTrait(String name, int min, int max, String description)
	{
		super(name, description);
		this.min = min;
		this.max = max;
	}
	
	public int getMaximumValue()
	{
		return max;
	}
	
	public int getMinimumValue()
	{
		return min;
	}
}
