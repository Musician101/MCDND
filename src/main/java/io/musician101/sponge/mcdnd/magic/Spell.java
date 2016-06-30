package io.musician101.sponge.mcdnd.magic;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellType;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import io.musician101.sponge.mcdnd.util.Interfaces.HasProperties;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.List;

public class Spell implements Described, HasProperties, Named, DataSerializable
{
    private final boolean isRitual;
    private final DataContainer properties;
    private final double castingTime;
    private final int range;
    private final List<String> description;
    private final SpellComponents spellComponents;
    private final SpellDuration spellDuration;
    private final SpellLevel spellLevel;
    private final SpellType spellType;
    private final String name;

    protected Spell(String name, List<String> description, boolean isRitual, DataContainer properties, double castingTime, int range, SpellComponents spellComponents, SpellDuration spellDuration, SpellLevel spellLevel, SpellType spellType)//NOSONAR
    {
        this.name = name;
        this.description = description;
        this.isRitual = isRitual;
        this.properties = properties;
        this.castingTime = castingTime;
        this.range = range;
        this.spellComponents = spellComponents;
        this.spellDuration = spellDuration;
        this.spellLevel = spellLevel;
        this.spellType = spellType;
    }

    public boolean isRitual()
    {
        return isRitual;
    }

    @Override
    public DataContainer getProperties()
    {
        return properties;
    }

    public double getCastingTime()
    {
        return castingTime;
    }

    public int getRange()
    {
        return range;
    }

    @Override
    public List<String> getDescription()
    {
        return description;
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
    public String getName()
    {
        return name;
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.NAME, name)
                .set(MCDNDKeys.DESCRIPTION, description)
                .set(MCDNDKeys.PROPERTIES, properties)
                .set(MCDNDKeys.IS_RITUAL, isRitual)
                .set(MCDNDKeys.CASTING_TIME, castingTime)
                .set(MCDNDKeys.RANGE, range)
                .set(MCDNDKeys.SPELL_COMPONENTS, spellComponents)
                .set(MCDNDKeys.SPELL_DURATION, spellDuration)
                .set(MCDNDKeys.SPELL_LEVEL, spellLevel)
                .set(MCDNDKeys.SPELL_TYPE, spellType);
    }

    public static SpellBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(SpellBuilder.class);
    }
}
