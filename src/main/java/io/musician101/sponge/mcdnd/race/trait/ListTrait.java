package io.musician101.sponge.mcdnd.race.trait;

import io.musician101.sponge.mcdnd.language.Language;
import io.musician101.sponge.mcdnd.util.Interfaces.Listed;

import java.util.List;

public class ListTrait<T> extends Trait implements Listed<T>
{
    private final List<T> values;

    public ListTrait(String name, List<T> values, String... description)
    {
        super(name, description);
        this.values = values;
    }

    @Override
    public List<T> getList()
    {
        return values;
    }

    @Override
    public T get(int index)
    {
        return values.get(index);
    }

    public static class AbilityScoreIncreaseTrait extends ListTrait<AbilityScoreData>
    {
        protected AbilityScoreIncreaseTrait(List<AbilityScoreData> values, String... description)
        {
            super("Ability Score Increase", values, description);
        }
    }

    public static class LanguagesTrait extends ListTrait<Language>
    {
        public LanguagesTrait(List<Language> languages, String... description)
        {
            super("Languages", languages, description);
        }
    }
}
