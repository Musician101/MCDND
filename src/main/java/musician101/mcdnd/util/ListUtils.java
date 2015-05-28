package musician101.mcdnd.util;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ListUtils
{
	public static <T> List<T> newList()
	{
		return new ArrayList<T>();
	}
	
	public static <T> List<T> addToList(List<T> list, T... items)
	{
		for (T item : items)
			list.add(item);
		
		return list;
	}
	
	public static <T> List<T> removeFromList(List<T> list, T... items)
	{
		for (T item : items)
			list.remove(item);
		
		return list;
	}
}
