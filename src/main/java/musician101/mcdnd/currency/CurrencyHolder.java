package musician101.mcdnd.currency;

import java.util.Map;

import musician101.mcdnd.util.CustomMap;

public abstract class CurrencyHolder
{
	Map<CurrencyType, Integer> currency;
	
	protected CurrencyHolder()
	{
		currency = new CustomMap<CurrencyType, Integer>().add(CurrencyType.COPPER, 0)
				.add(CurrencyType.SILVER, 0).add(CurrencyType.ELECTRUM, 0)
				.add(CurrencyType.GOLD, 0).add(CurrencyType.PLATINUM, 0);
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
