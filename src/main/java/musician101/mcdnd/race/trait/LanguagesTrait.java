package musician101.mcdnd.race.trait;

import java.util.List;

import musician101.mcdnd.language.Language;

public class LanguagesTrait extends ListTrait<Language>
{
	public LanguagesTrait(List<Language> languages, String description)
	{
		super("Languanges", languages, description);
	}
}
