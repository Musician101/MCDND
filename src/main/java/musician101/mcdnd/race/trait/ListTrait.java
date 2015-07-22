package musician101.mcdnd.race.trait;

import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.language.Language;

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
	
	public static class AbilityScoreIncreaseTrait extends ListTrait<AbilityScore>
	{
		protected AbilityScoreIncreaseTrait(List<AbilityScore> values, String description)
		{
			super("Ability Score Increase", values, description);
		}
	}
	
	public static class LanguagesTrait extends ListTrait<Language>
	{
		public LanguagesTrait(List<Language> languages, String description)
		{
			super("Languanges", languages, description);
		}
	}
}
