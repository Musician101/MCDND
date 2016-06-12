package io.musician101.sponge.mcdnd.util.list;

import io.musician101.sponge.mcdnd.magic.Spell;

import java.util.ArrayList;
import java.util.Collection;

public class SpellList extends ArrayList<Spell>
{
    private SpellList(Collection<? extends Spell> collection)
    {
        super(collection);
    }

    public static SpellList of(Collection<? extends Spell> collection)
    {
        return new SpellList(collection);
    }
}
