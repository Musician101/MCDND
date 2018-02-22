package io.musician101.mcdnd.sponge.equipment;

import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.MCDNDCatalogType;
import io.musician101.mcdnd.sponge.util.Interfaces.Buyable;
import io.musician101.mcdnd.sponge.util.Interfaces.Weighable;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public abstract class Equipment extends MCDNDCatalogType implements Buyable, DataSerializable, Weighable {

    private final Cost cost;
    private final double weight;

    protected Equipment(String name, Cost cost, double weight) {
        super(name);
        this.cost = cost;
        this.weight = weight;
    }

    @Override
    public Cost getCost() {
        return cost;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.NAME, name).set(MCDNDKeys.WEIGHT, weight).set(MCDNDKeys.COST, cost);
    }
}
