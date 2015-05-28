package musician101.mcdnd.abilityscore;

public class AbilityScore
{
	private AbilityScores type;
	private int amount;
	
	public AbilityScore(AbilityScores type)
	{
		this(type, 8);
	}
	
	public AbilityScore(AbilityScores type, int amount)
	{
		this.type = type;
		this.amount = amount;
	}
	
	public AbilityScores getType()
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
	
	public static enum AbilityScores
	{
		STR("Strength"),
		DEX("Dexterity"),
		CON("Constitution"),
		INT("Intelligence"),
		WIS("Wisdom"),
		CHA("Charisma");
		
		String name;
		
		private AbilityScores(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
}
