package musician101.mcdnd.abilityscore;

import musician101.mcdnd.util.Interfaces.Mapped;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAbilityScores implements Mapped<AbilityScoreType, AbilityScore>
{
    private final Map<AbilityScoreType, AbilityScore> scores = new HashMap<>();

    //TODO add point buy system and standard system array (15, 14, 13, 12, 10, 8)
    protected AbstractAbilityScores()
    {

    }

    protected int getAbilityScore(AbilityScoreType score)
    {
        return scores.get(score).getAmount();
    }

    public void updateScores(AbilityScore... abilityScores)
    {
        for (AbilityScore abilityScore : abilityScores)
            add(abilityScore.getType(), abilityScore);
    }

    @Override
    public boolean containsKey(AbilityScoreType key)
    {
        return scores.containsKey(key);
    }

    @Override
    public Map<AbilityScoreType, AbilityScore> getMap()
    {
        return scores;
    }

    @Override
    public AbilityScore get(AbilityScoreType key)
    {
        return scores.get(key);
    }

    @Override
    public AbstractAbilityScores add(AbilityScoreType key, AbilityScore value)
    {
        scores.put(key, value);
        return this;
    }
}
