package musician101.mcdnd.race.trait;

public class SingleValueTrait<T> extends Trait
{
	T trait;
	
	public SingleValueTrait(String name, T trait, String description)
	{
		super(name, description);
		this.trait = trait;
	}
	
	public T getTrait()
	{
		return trait;
	}
}
