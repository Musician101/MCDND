package musician101.mcdnd.abilityscore;

public class AbilityScore
{
    private final AbilityScoreType type;
    private int amount;

    public AbilityScore(AbilityScoreType type)
    {
        this(type, 8);
    }

    public AbilityScore(AbilityScoreType type, int amount)
    {
        this.type = type;
        this.amount = amount;
    }

    public AbilityScoreType getType()
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

    public int getMod()
    {
        return (amount - 10) / 2;
    }
}
