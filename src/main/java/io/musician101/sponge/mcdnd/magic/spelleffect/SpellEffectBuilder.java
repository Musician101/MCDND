package io.musician101.sponge.mcdnd.magic.spelleffect;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class SpellEffectBuilder implements ResettableBuilder<SpellEffect, SpellEffectBuilder>
{
    private DataContainer properties = new MemoryDataContainer();
    private List<String> description;
    private String name;

    public SpellEffectBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    public SpellEffectBuilder description(String... description)
    {
        description(Arrays.asList(description));
        return this;
    }

    public SpellEffectBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public <V> SpellEffectBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

    public SpellEffectBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    public SpellEffect build()
    {
        return new SpellEffect(name, properties, description);
    }

    @Nonnull
    @Override
    public SpellEffectBuilder from(@Nonnull SpellEffect value)
    {
        return name(value.getName()).description(value.getDescription()).properties(properties);
    }

    @Nonnull
    @Override
    public SpellEffectBuilder reset()
    {
        properties = new MemoryDataContainer();
        description = null;
        name = null;
        return this;
    }
}
