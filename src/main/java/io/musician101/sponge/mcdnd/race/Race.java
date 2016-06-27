package io.musician101.sponge.mcdnd.race;

import io.musician101.sponge.mcdnd.race.trait.Trait;

import java.util.List;

public interface Race
{
    List<Trait> getTraits();

    String getName();

    //TODO remove enum
    enum CharacterSize
    {
        TINY("Tiny"),
        SMALL("Small"),
        MEDIUM("Medium"),
        LARGE("Large"),
        HUGE("Huge"),
        GARGANTUAN("Gargantuan");

        final String name;

        CharacterSize(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }
    }
}
