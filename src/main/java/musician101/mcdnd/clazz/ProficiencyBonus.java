package musician101.mcdnd.clazz;

public class ProficiencyBonus
{
	private int bonus = 2;
	
	public ProficiencyBonus(CharacterClass... classes)
	{
		updateBonus(classes);
	}
	
	public int getBonus()
	{
		return bonus;
	}
	
	public void updateBonus(CharacterClass... classes)
	{
		double classLevels = 0;
		for (CharacterClass clazz : classes)
			classLevels =+ clazz.getLevel();
		
		this.bonus = (int) (Math.floor(classLevels / (10000000000D)) + Math.floor(classLevels / 4d));
	}
}
