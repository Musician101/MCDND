package musician101.mcdnd.abilityscore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.clazz.ProficiencyBonus;

public class CharacterAbilityScores extends AbstractAbilityScores
{
	private ProficiencyBonus proficiencyBonus;
	private final List<AbilityScores> proficientSavingThrows;
	
	public CharacterAbilityScores()
	{
		this(new ArrayList<>(), new ProficiencyBonus());
	}
	
	public CharacterAbilityScores(List<AbilityScores> proficientSavingThrows, ProficiencyBonus proficiencyBonus)
	{
		super();
		this.proficientSavingThrows = proficientSavingThrows;
		this.proficiencyBonus = proficiencyBonus;
		updateScores(new AbilityScore(AbilityScores.STR), new AbilityScore(AbilityScores.DEX), 
				new AbilityScore(AbilityScores.CON), new AbilityScore(AbilityScores.INT),
				new AbilityScore(AbilityScores.WIS), new AbilityScore(AbilityScores.CHA));
	}
	
	public int getProficiencyBonus()
	{
		return proficiencyBonus.getBonus();
	}
	
	public void setProficiencyBonus(ProficiencyBonus proficiencyBonus)
	{
		this.proficiencyBonus = proficiencyBonus;
	}
	
	public int getAbilityMod(AbilityScores score)
	{
		return (getAbilityScore(score) - 10) / 2;
	}
	
	public int getSavingThrowMod(AbilityScores score)
	{
		return proficientSavingThrows.contains(AbilityScores.STR) ? getAbilityMod(score) + proficiencyBonus.getBonus() : getAbilityMod(score);
	}
	
	public int rollSavingThrow(AbilityScores score)
	{
		return new Random().nextInt(19) + 1 + getSavingThrowMod(score);
	}
}
