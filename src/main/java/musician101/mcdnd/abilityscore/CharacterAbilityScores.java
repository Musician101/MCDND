package musician101.mcdnd.abilityscore;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScoreType;
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
        updateScores(new AbilityScore(AbilityScoreType.STR), new AbilityScore(AbilityScoreType.DEX), new AbilityScore
                (AbilityScoreType.CON), new AbilityScore(AbilityScoreType.INT), new AbilityScore(AbilityScoreType.WIS), new
                AbilityScore(AbilityScoreType.CHA));
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
        return proficientSavingThrows.contains(AbilityScoreType.STR) ? getAbilityMod(score) + proficiencyBonus.getBonus
                () : getAbilityMod(score);
    }

    public int rollSavingThrow(AbilityScoreType score)
    {
        return new Random().nextInt(19) + 1 + getSavingThrowMod(score);
    }
}
