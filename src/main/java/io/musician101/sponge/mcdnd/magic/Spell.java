package io.musician101.sponge.mcdnd.magic;

import io.musician101.sponge.mcdnd.property.Property;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import io.musician101.sponge.mcdnd.util.Interfaces.HasProperties;
import io.musician101.sponge.mcdnd.util.Interfaces.Identified;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;

import java.util.ArrayList;
import java.util.List;

public class Spell implements Described, HasProperties, Identified, Named
{
    protected boolean isRitual = false;
    protected double castingTime = 0;
    protected int range = 0;
    protected List<Property> properties = new ArrayList<>();
    protected SpellComponents spellComponents = SpellComponents.of();
    protected SpellDuration spellDuration = SpellDuration.of();
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

    @Override
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
}
