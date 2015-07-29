package musician101.mcdnd.clazz.feature;

public class SingleValueFeature<V> extends Feature
{
	V value;
	
	public SingleValueFeature(String name, V value, String description)
	{
		super(name, description);
	}
	
	public V getValue()
	{
		return value;
	}
}
