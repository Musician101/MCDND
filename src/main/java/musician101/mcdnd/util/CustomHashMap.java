package musician101.mcdnd.util;

import java.util.HashMap;

@SuppressWarnings("serial")
public class CustomHashMap<K, V> extends HashMap<K, V>
{
	public CustomHashMap()
	{
		super();
	}
	
	public CustomHashMap<K, V> add(K key, V value)
	{
		put(key, value);
		return this;
	}
}
