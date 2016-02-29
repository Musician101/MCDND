package musician101.mcdnd.magic;

import musician101.mcdnd.property.Property;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.HasProperties;
import musician101.mcdnd.util.Interfaces.Identified;
import musician101.mcdnd.util.Interfaces.Named;

import java.util.ArrayList;
import java.util.List;

public class Spell implements Described, HasProperties, Identified, Named
{
    protected boolean isRitual = false;
    protected double castingTime = 0;
    protected int range = 0;
    protected List<Property> properties = new ArrayList<>();
    protected SpellComponents spellComponents = new SpellComponents();
    protected SpellDuration spellDuration = new SpellDuration();
    protected SpellLevel spellLevel;
    protected SpellType spellType;
    private String id;
    private String name;
    private String[] description;

    protected Spell(String id, String name, String... description)
    {
        this.id = "spell." + id;
        this.name = name;
        this.description = description;
    }

    public double getCastingTime()
    {
        return castingTime;
    }

    public boolean isRitual()
    {
        return isRitual;
    }

    public int getRange()
    {
        return range;
    }

    public List<Property> getProperties()
    {
        return properties;
    }

    public SpellComponents getSpellComponents()
    {
        return spellComponents;
    }

    public SpellDuration getSpellDuration()
    {
        return spellDuration;
    }

    public SpellLevel getSpellLevel()
    {
        return spellLevel;
    }

    public SpellType getSpellType()
    {
        return spellType;
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String[] getDescription()
    {
        return description;
    }

    public static class SpellComponents
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

    public static class SpellDuration
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
}
