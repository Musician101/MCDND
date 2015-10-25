package musician101.mcdnd.magic;

import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.util.Interfaces.Listed;

import java.util.List;
import java.util.Map;

public class ListSpell<T> extends Spell implements Listed<T>
{
    List<T> list;

    public ListSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, List<T> list, String... description)
    {
        super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
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
}
