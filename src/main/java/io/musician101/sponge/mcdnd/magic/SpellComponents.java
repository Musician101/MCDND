package io.musician101.sponge.mcdnd.magic;

public class SpellComponents
{
    boolean isVerbal;
    boolean isSomatic;
    String materials;

    private SpellComponents()
    {
        this(false, false, "");
    }

    private SpellComponents(boolean isVerbal, boolean isSomatic)
    {
        this(isVerbal, isSomatic, "");
    }

    private SpellComponents(boolean isVerbal, boolean isSomatic, String materials)
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

    public static SpellComponents of()
    {
        return new SpellComponents();
    }

    public static SpellComponents of(boolean isVerbal, boolean isSomatic)
    {
        return new SpellComponents(isVerbal, isSomatic);
    }

    public static SpellComponents of(boolean isVerbal, boolean isSomatic, String materials)
    {
        return new SpellComponents(isVerbal, isSomatic, materials);
    }
}
