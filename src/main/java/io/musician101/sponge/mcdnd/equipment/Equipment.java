package io.musician101.sponge.mcdnd.equipment;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.MCDNDCatalogType;
import io.musician101.sponge.mcdnd.util.Interfaces.Buyable;
import io.musician101.sponge.mcdnd.util.Interfaces.Weighable;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public abstract class Equipment extends MCDNDCatalogType implements Buyable, DataSerializable, Weighable
{
    private final Cost cost;
    private final double weight;

    protected Equipment(String name, Cost cost, double weight)
    {
        super(name);
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

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.NAME, name)
                .set(MCDNDKeys.WEIGHT, weight)
                .set(MCDNDKeys.COST, cost);
    }
}
