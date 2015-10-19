package musician101.mcdnd.race;

import musician101.mcdnd.race.trait.Trait;

import java.util.List;

public interface Race
{
    List<Trait> getTraits();

    String getName();

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
