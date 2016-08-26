package io.musician101.sponge.mcdnd.util.list;

import io.musician101.sponge.mcdnd.race.trait.Trait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TraitList extends ArrayList<Trait>
{
    private TraitList(Collection<? extends Trait> collection)
    {
        super(collection);
    }

    public static TraitList of(Collection<? extends Trait> collection)
    {
        return new TraitList(collection);
    }

    public static TraitList of(Trait... traits)
    {
        return new TraitList(Arrays.asList(traits));
    }
}
