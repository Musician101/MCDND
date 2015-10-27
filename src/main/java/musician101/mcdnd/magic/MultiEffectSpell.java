package musician101.mcdnd.magic;

import musician101.mcdnd.magic.spelleffect.SpellEffect;
import musician101.mcdnd.util.Interfaces.Listed;

import java.util.List;

public class MultiEffectSpell extends Spell implements Listed<SpellEffect>
{
    List<SpellEffect> effects;

    public MultiEffectSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, List<SpellEffect> effects, String... description)
    {
        super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
        this.effects = effects;
    }

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
