package io.musician101.sponge.mcdnd.property.list;

import io.musician101.sponge.mcdnd.magic.spelleffect.SpellEffect;
import io.musician101.sponge.mcdnd.property.Property;
import io.musician101.sponge.mcdnd.util.Interfaces.Listed;

import java.util.List;

public abstract class ListProperty<T> extends Property implements Listed<T>
{
    protected List<T> list;

    public ListProperty(List<T> list)
    {
        super();
        this.list = list;
    }

    @Override
    public List<T> getList()
    {
        return list;
    }

    @Override
    public T get(int index)
    {
        return list.get(index);
    }

    public static class MultipleEffectsProperty extends ListProperty<SpellEffect>
    {
        public MultipleEffectsProperty(List<SpellEffect> list)
        {
            super(list);
        }
    }
}
