package musician101.mcdnd.equipment;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.util.Interfaces.Buyable;
import musician101.mcdnd.util.Interfaces.Named;
import musician101.mcdnd.util.Interfaces.Weighable;

public abstract class Equipment implements Buyable, Named, Weighable
{
    private final Cost cost;
    private final double weight;
    private final String name;

    protected Equipment(String name, Cost cost, double weight)
    {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    @Override
    public Cost getCost()
    {
        return cost;
    }

    @Override
    public double getWeight()
    {
        return weight;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
