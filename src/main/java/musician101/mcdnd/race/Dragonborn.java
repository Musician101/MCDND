package musician101.mcdnd.race;

import musician101.mcdnd.race.trait.Trait;

import java.util.List;

public abstract class Dragonborn implements Race
{
    List<Trait> traits;

    protected Dragonborn()
    {
        //traits.add();
    }

    public static class BlackDragonborn extends Dragonborn
    {
        public BlackDragonborn()
        {
            super();
        }

        @Override
        public List<Trait> getTraits()
        {
            return null;
        }

        @Override
        public String getName()
        {
            return "Black Dragonborn";
        }
    }

    public static class BlueDragonborn extends Dragonborn
    {
        public BlueDragonborn()
        {
        }

        @Override
        public List<Trait> getTraits()
        {
            return null;
        }

        @Override
        public String getName()
        {
            return "Blue Dragonborn";
        }
    }

    public static class BrassDragonborn extends Dragonborn
    {
        public BrassDragonborn()
        {
        }

        @Override
        public List<Trait> getTraits()
        {
            return null;
        }

        @Override
        public String getName()
        {
            return "Brass Dragonborn";
        }
    }
}
