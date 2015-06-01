package musician101.mcdnd.currency;

public enum CurrencyType
{
	COPPER("Copper"),
	SILVER("Silver"),
	ELECTRUM("Electrum"),
	GOLD("Gold"),
	PLATINUM("Platinum");
	
	String name;
	
	private CurrencyType(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
