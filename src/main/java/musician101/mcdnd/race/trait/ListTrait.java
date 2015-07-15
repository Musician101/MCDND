package musician101.mcdnd.race.trait;

import java.util.Arrays;
import java.util.List;

public class ListTrait<V> extends Trait
{
	List<V> values;
	
	public ListTrait(String name, List<V> values, String description)
	{
		super(name, description);
		this.values = values;
	}
	
	public List<V> getAll()
	{
		return values;
	}
	
	public V get(int index)
	{
		return values.get(index);
	}
	
	public boolean contains(V object)
	{
		return values.contains(object);
	}
	
	@SuppressWarnings("unchecked")
	public void set(V... values)
	{
		set(Arrays.asList(values));
	}
	
	public void set(List<V> values)
	{
		this.values = values;
	}
	
	public void set(int index, V value)
	{
		values.set(index, value);
	}
	
	public void add(V value)
	{
		values.add(value);
	}
}
