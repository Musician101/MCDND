package musician101.mcdnd.abilityscore;

import musician101.mcdnd.clazz.ProficiencyBonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharacterAbilityScores extends AbstractAbilityScores
{
    private final List<AbilityScoreType> proficientSavingThrows;
    private ProficiencyBonus proficiencyBonus;

    public CharacterAbilityScores()
    {
        this(new ArrayList<>(), new ProficiencyBonus());
    }

    public CharacterAbilityScores(List<AbilityScoreType> proficientSavingThrows, ProficiencyBonus proficiencyBonus)
    {
        super();
        this.proficientSavingThrows = proficientSavingThrows;
        this.proficiencyBonus = proficiencyBonus;
        updateScores(new AbilityScore(AbilityScoreTypes.STR), new AbilityScore(AbilityScoreTypes.DEX), new AbilityScore
                (AbilityScoreTypes.CON), new AbilityScore(AbilityScoreTypes.INT), new AbilityScore(AbilityScoreTypes.WIS), new
                AbilityScore(AbilityScoreTypes.CHA));
    }

    public int getProficiencyBonus()
    {
        return proficiencyBonus.getBonus();
    }

    public void setProficiencyBonus(ProficiencyBonus proficiencyBonus)
    {
        this.proficiencyBonus = proficiencyBonus;
    }

    public int getAbilityMod(AbilityScoreType score)
    {
        return (getAbilityScore(score) - 10) / 2;
    }

    public int getSavingThrowMod(AbilityScoreType score)
    {
        return proficientSavingThrows.contains(AbilityScoreTypes.STR) ? getAbilityMod(score) + proficiencyBonus.getBonus() : getAbilityMod(score);
    }

    public int rollSavingThrow(AbilityScoreType score)
    {
        return new Random().nextInt(19) + 1 + getSavingThrowMod(score);
    }
}
