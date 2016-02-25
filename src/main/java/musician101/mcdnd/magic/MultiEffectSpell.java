package musician101.mcdnd.magic;

import musician101.mcdnd.magic.spelleffect.SpellEffect;
import musician101.mcdnd.util.Interfaces.Listed;

import java.util.List;

@Deprecated
public class MultiEffectSpell extends Spell implements Listed<SpellEffect>
{
    protected List<SpellEffect> effects;

    @Override
    public List<SpellEffect> getList()
    {
        return effects;
    }

    @Override
    public SpellEffect get(int index)
    {
        return effects.get(index);
    }
}
