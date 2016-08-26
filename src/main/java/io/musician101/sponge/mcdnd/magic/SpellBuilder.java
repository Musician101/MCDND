package io.musician101.sponge.mcdnd.magic;

import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellType;
import io.musician101.sponge.mcdnd.util.MCDNDBuilder;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class SpellBuilder extends MCDNDBuilder<Spell, SpellBuilder>
{
    private boolean isRitual = false;
    private double castingTime = 0;
    private int range = 0;
    private SpellComponents spellComponents = SpellComponents.of();
    private SpellDuration spellDuration = SpellDuration.of();
    private SpellLevel spellLevel;
    private SpellType spellType;

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

    public SpellBuilder components(boolean verbal, boolean somatic)
    {
        return components(SpellComponents.of(verbal, somatic));
    }

    public SpellBuilder components(boolean verbal, boolean somatic, String materials)
    {
        return components(SpellComponents.of(verbal, somatic, materials));
    }

    @Override
    public SpellBuilder addLineToDescription(String line)
    {
        description.add(line);
        return this;
    }

    @Override
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

    public SpellBuilder duration(double duration)
    {
        return duration(SpellDuration.of(duration));
    }

    public SpellBuilder duration(double duration, boolean concentration)
    {
        return duration(SpellDuration.of(duration, concentration));
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

    @Override
    public SpellBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public <V> SpellBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

    @Override
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

    @Override
    public Spell build()
    {
        return new Spell(name, description, isRitual, properties, castingTime, range, spellComponents, spellDuration, spellLevel, spellType);
    }

    @Nonnull
    @Override
    public SpellBuilder from(@Nonnull Spell value)
    {
        return super.from(value).isRitual(value.isRitual()).duration(value.getSpellDuration()).level(value.getSpellLevel())
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
