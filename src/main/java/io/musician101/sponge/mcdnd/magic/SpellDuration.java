package io.musician101.sponge.mcdnd.magic;

public class SpellDuration
{
    double duration;
    boolean needsConcentration;

    private SpellDuration()
    {
        this(0);
    }

    private SpellDuration(double duration)
    {
        this(duration, false);
    }

    private SpellDuration(double duration, boolean needsConcentration)
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

    public static SpellDuration of()
    {
        return new SpellDuration();
    }

    public static SpellDuration of(double duration)
    {
        return new SpellDuration(duration);
    }

    public static SpellDuration of(double duration, boolean needsConcentration)
    {
        return new SpellDuration(duration, needsConcentration);
    }
}
