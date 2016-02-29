package musician101.mcdnd.magic;

public class SpellDuration
{
    double duration;
    boolean needsConcentration;

    public SpellDuration()
    {
        this(0);
    }

    public SpellDuration(double duration)
    {
        this(duration, false);
    }

    public SpellDuration(double duration, boolean needsConcentration)
    {
        this.duration = duration;
        this.needsConcentration = needsConcentration;
    }

    public boolean needsConcentration()
    {
        return needsConcentration;
    }

    /** In seconds */
    public double getDuration()
    {
        return duration;
    }
}
