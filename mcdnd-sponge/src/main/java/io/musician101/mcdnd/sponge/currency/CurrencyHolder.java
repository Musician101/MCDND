package io.musician101.mcdnd.sponge.currency;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.CurrencyType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class CurrencyHolder implements DataSerializable
{
    protected Map<CurrencyType, Integer> currency = new HashMap<>();

    protected CurrencyHolder()
    {

    }

    protected CurrencyHolder(Map<CurrencyType, Integer> currency)
    {
        this.currency = currency;
    }

    public int getAmount(CurrencyType type)
    {
        return currency.get(type);
    }

    public void setAmount(CurrencyType type, int amount)
    {
        currency.put(type, amount);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.CURRENCY_AMOUNTS, currency);
    }

    public static class CurrencyCarrier extends CurrencyHolder
    {
        public CurrencyCarrier()
        {
            super();
        }

        public CurrencyCarrier(Map<CurrencyType, Integer> currency)
        {
            super(currency);
        }
    }

    public static class Cost extends CurrencyHolder
    {
        public Cost()
        {
            super();
        }

        public Cost(CurrencyType type, int amount)
        {
            this();
            currency.put(type, amount);
        }

        public Cost(Map<CurrencyType, Integer> currency)
        {
            super(currency);
        }
    }
}
