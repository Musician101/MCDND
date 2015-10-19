package musician101.mcdnd.equipment.pack;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.equipment.Equipment;

import java.util.Map;

public class Pack extends Equipment
{
    private final Map<Equipment, Integer> contents;

    public Pack(String name, Cost cost, Map<Equipment, Integer> contents)
    {
        super(name, cost, 0);
        this.contents = contents;
    }

    public Map<Equipment, Integer> getContents()
    {
        return contents;
    }

    @Override
    public double getWeight()
    {
        double weight = 0;
        for (Equipment equipment : contents.keySet())
            weight = +(weight * contents.get(equipment));

        return weight;
    }
}
