package io.musician101.sponge.mcdnd.currency;

import io.musician101.sponge.mcdnd.util.MapUtils;

import java.util.Map;

public abstract class CurrencyHolder
{
    final Map<CurrencyType, Integer> currency;

    protected CurrencyHolder()
    {
        currency = new MapUtils<CurrencyType, Integer>().add(CurrencyTypes.COPPER, 0).add(CurrencyTypes.SILVER, 0)
                .add(CurrencyTypes.ELECTRUM, 0).add(CurrencyTypes.GOLD, 0).add(CurrencyTypes.PLATINUM, 0);
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
