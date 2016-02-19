package musician101.mcdnd.property;

import musician101.mcdnd.magic.spelleffect.SpellEffect;
import musician101.mcdnd.util.Interfaces.Listed;

import java.util.List;

public class ListProperty<T> extends Property implements Listed<T>
{
    protected List<T> list;

    public ListProperty(String idPrefix, List<T> list)
    {
        super(idPrefix + ".property.list");
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
        public MultipleEffectsProperty(String idPrefix, List<SpellEffect> list)
        {
            super(idPrefix + ".property.list.effects", list);
        }
    }
}
