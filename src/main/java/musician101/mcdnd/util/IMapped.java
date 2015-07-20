package musician101.mcdnd.util;

import java.util.Map;

public interface IMapped<K, V>
{
	Map<K, V> getMap();
	
	V get(K key);
}
