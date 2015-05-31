package musician101.mcdnd.currency;

import musician101.mcdnd.currency.Currency.CurrencyType;

public abstract class CurrencyHolder
{
	Currency copper = new Currency(CurrencyType.COPPER, 0);
	Currency silver = new Currency(CurrencyType.SILVER, 0);
	Currency electrum = new Currency(CurrencyType.ELECTRUM, 0);
	Currency gold = new Currency(CurrencyType.GOLD, 0);
	Currency platinum = new Currency(CurrencyType.PLATINUM, 0);
	
	protected CurrencyHolder()
	{
		this.copper = new Currency(CurrencyType.COPPER, 0);
		this.silver = new Currency(CurrencyType.SILVER, 0);
		this.electrum = new Currency(CurrencyType.ELECTRUM, 0);
		this.gold = new Currency(CurrencyType.GOLD, 0);
		this.platinum = new Currency(CurrencyType.PLATINUM, 0);
	}
	
	protected CurrencyHolder(Currency... currencies)
	{
		this();
		for (Currency currency : currencies)
		{
			if (currency.getType() == CurrencyType.COPPER)
				this.copper = currency;
			else if (currency.getType() == CurrencyType.SILVER)
				this.silver = currency;
			else if (currency.getType() == CurrencyType.ELECTRUM)
				this.electrum = currency;
			else if (currency.getType() == CurrencyType.GOLD)
				this.gold = currency;
			else if (currency.getType() == CurrencyType.PLATINUM)
				this.platinum = currency;
		}
	}
	
	public int getCopper()
	{
		return copper.getAmount();
	}
	
	public void setCopperCurrency(Currency copper)
	{
		this.copper = copper;
	}
	
	public int getSilver()
	{
		return silver.getAmount();
	}
	
	public void setSilverCurrency(Currency silver)
	{
		this.silver = silver;
	}
	
	public int getGold()
	{
		return gold.getAmount();
	}
	
	public void setGoldCurrency(Currency gold)
	{
		this.gold = gold;
	}
	
	public int getPlatinum()
	{
		return platinum.getAmount();
	}
	
	public void setPlatinumCurrency(Currency platinum)
	{
		this.platinum = platinum;
	}
	
	public static class CurrencyCarrier extends CurrencyHolder
	{
		public CurrencyCarrier()
		{
			super();
		}
		
		public CurrencyCarrier(Currency... currencies)
		{
			super(currencies);
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
			super(new Currency(type, amount));
		}
		
		public Cost(Currency... currencies)
		{
			super(currencies);
		}
	}
}
