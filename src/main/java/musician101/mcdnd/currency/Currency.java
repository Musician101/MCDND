package musician101.mcdnd.currency;

public class Currency
{
	CurrencyType type;
	int amount;
	
	public Currency(CurrencyType type, int amount)
	{
		this.type = type;
		this.amount = amount;
	}
	
	public CurrencyType getType()
	{
		return type;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
	public static Currency convertCurrency(Currency currency, CurrencyType type)
	{
		if (currency.getType() == type)
			throw new IllegalArgumentException("Currency.getType() and CurrencyType cannot be the same.");
		
		if (currency.getType() == CurrencyType.COPPER)
			throw new IllegalArgumentException("You cannot convert currency down.");
		else if (currency.getType() == CurrencyType.SILVER)
		{
			if (type == CurrencyType.COPPER)
				return new Currency(type, currency.getAmount() * 10);
		}
		else if (currency.getType() == CurrencyType.ELECTRUM)
		{
			if (type == CurrencyType.COPPER)
				return new Currency(type, currency.getAmount() * 50);
			else if (type == CurrencyType.SILVER)
				return new Currency(type, currency.getAmount() * 5); 
		}
		else if (currency.getType() == CurrencyType.GOLD)
		{
			if (type == CurrencyType.COPPER)
				return new Currency(type, currency.getAmount() * 100);
			else if (type == CurrencyType.SILVER)
				return new Currency(type, currency.getAmount() * 10);
			else if (type == CurrencyType.ELECTRUM)
				return new Currency(type, currency.getAmount() * 2); 
		}
		else if (currency.getType() == CurrencyType.PLATINUM)
		{
			if (type == CurrencyType.COPPER)
				return new Currency(type, currency.getAmount() * 1000);
			else if (type == CurrencyType.SILVER)
				return new Currency(type, currency.getAmount() * 100);
			else if (type == CurrencyType.ELECTRUM)
				return new Currency(type, currency.getAmount() * 20);
			else if (type == CurrencyType.GOLD)
				return new Currency(type, currency.getAmount() * 10);
		}
		
		throw new IllegalArgumentException("You cannot convert currency down.");
	}
	
	public static enum CurrencyType
	{
		COPPER,
		SILVER,
		ELECTRUM,
		GOLD,
		PLATINUM;
	}
}
