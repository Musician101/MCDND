package io.musician101.sponge.mcdnd.equipment.tool;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.equipment.Equipment;

public class Tool extends Equipment
{
    public Tool(String name, Cost cost, double weight)
    {
        super(name, cost, weight);
    }

    public static class ArtisanTool extends Tool
    {
        public ArtisanTool(String name, Cost cost, double weight)
        {
            super(name, cost, weight);
        }
    }

    public static class GamingSet extends Tool
    {
        public GamingSet(String name, Cost cost, double weight)
        {
            super(name, cost, weight);
        }
    }

    public static class MusicalInstrument extends Tool
    {
        public MusicalInstrument(String name, Cost cost, double weight)
        {
            super(name, cost, weight);
        }
    }
}
