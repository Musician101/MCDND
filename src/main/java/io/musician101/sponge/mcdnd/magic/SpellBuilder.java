package io.musician101.sponge.mcdnd.magic;

import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpellBuilder implements ResettableBuilder<Spell, SpellBuilder>
{
    private boolean isRitual = false;
    private DataContainer properties = new MemoryDataContainer();
    private double castingTime = 0;
    private int range = 0;
    private List<String> description = new ArrayList<>();
    private SpellComponents spellComponents = SpellComponents.of();
    private SpellDuration spellDuration = SpellDuration.of();
    private SpellLevel spellLevel;
    private SpellType spellType;
    private String name;

    public SpellBuilder castingTime(double castingTime)
    {
        this.castingTime = castingTime;
        return this;
    }

    public SpellBuilder components(SpellComponents spellComponents)
    {
        this.spellComponents = spellComponents;
        return this;
    }

    public SpellBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    public SpellBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    public SpellBuilder duration(SpellDuration spellDuration)
    {
        this.spellDuration = spellDuration;
        return this;
    }

    public SpellBuilder isRitual(boolean isRitual)
    {
        this.isRitual = isRitual;
        return this;
    }

    public SpellBuilder level(SpellLevel spellLevel)
    {
        this.spellLevel = spellLevel;
        return this;
    }

    public SpellBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public <V> SpellBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

    public SpellBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    public SpellBuilder range(int range)
    {
        this.range = range;
        return this;
    }

    public SpellBuilder type(SpellType spellType)
    {
        this.spellType = spellType;
        return this;
    }

    public Spell build()
    {
        return new Spell(name, description, isRitual, properties, castingTime, range, spellComponents, spellDuration, spellLevel, spellType);
    }

    @Nonnull
    @Override
    public SpellBuilder from(@Nonnull Spell value)
    {
        return name(value.getName()).properties(value.getProperties()).description(value.getDescription())
                .isRitual(value.isRitual()).duration(value.getSpellDuration()).level(value.getSpellLevel())
                .range(value.getRange()).castingTime(value.getCastingTime()).components(value.getSpellComponents())
                .type(value.getSpellType());
    }

    @Nonnull
    @Override
    public SpellBuilder reset()
    {
        isRitual = false;
        properties = new MemoryDataContainer();
        castingTime = 0;
        range = 0;
        description = new ArrayList<>();
        spellComponents = SpellComponents.of();
        spellDuration = SpellDuration.of();
        spellLevel = null;
        spellType = null;
        name = null;
        return this;
    }
}
