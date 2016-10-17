package io.musician101.mcdnd.sponge.magic.spelleffect;

import io.musician101.mcdnd.sponge.util.MCDNDBuilder;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpellEffectBuilder extends MCDNDBuilder<SpellEffect, SpellEffectBuilder>
{
    @Override
    public SpellEffectBuilder addLineToDescription(String line)
    {
        description.add(line);
        return this;
    }

    @Override
    public SpellEffectBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    @Override
    public SpellEffectBuilder description(String... description)
    {
        description(Arrays.asList(description));
        return this;
    }

    @Override
    public SpellEffectBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public <V> SpellEffectBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

    @Override
    public SpellEffectBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    @Override
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
        description = new ArrayList<>();
        name = null;
        return this;
    }
}
