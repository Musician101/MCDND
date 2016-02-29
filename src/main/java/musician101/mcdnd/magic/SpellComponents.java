package musician101.mcdnd.magic;

public class SpellComponents
{
    boolean isVerbal;
    boolean isSomatic;
    String materials;

    public SpellComponents()
    {
        this(false, false, "");
    }

    public SpellComponents(boolean isVerbal, boolean isSomatic)
    {
        this(isVerbal, isSomatic, "");
    }

    public SpellComponents(boolean isVerbal, boolean isSomatic, String materials)
    {
        this.isVerbal = isVerbal;
        this.isSomatic = isSomatic;
        this.materials = materials;
    }

    public boolean isSomatic()
    {
        return isSomatic;
    }

    public boolean isVerbal()
    {
        return isVerbal;
    }

    public String getMaterials()
    {
        return materials;
    }
}
