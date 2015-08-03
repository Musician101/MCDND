package musician101.mcdnd.clazz.feature;

public class SingleValueFeature<V> extends Feature
{
	V value;
	
	public SingleValueFeature(String name, V value, String description)
	{
		this(name, 1, value, description);
	}
	
	public SingleValueFeature(String name, int level, V value, String... description)
	{
		super(name, level, description);
	}
	
	public V getValue()
	{
		return value;
	}
}
