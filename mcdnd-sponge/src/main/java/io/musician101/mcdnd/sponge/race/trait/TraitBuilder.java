package io.musician101.mcdnd.sponge.race.trait;

import io.musician101.mcdnd.sponge.util.MCDNDBuilder;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraitBuilder extends MCDNDBuilder<Trait, TraitBuilder>
{
    @Override
    public TraitBuilder addLineToDescription(String line)
    {
        description.add(line);
        return this;
    }

    @Override
    public TraitBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    @Override
    public TraitBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    @Override
    public TraitBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public TraitBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    @Override
    public <V> TraitBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

    @Override
    public Trait build()
    {
        return new Trait(name, properties, description);
    }

    @Nonnull
    @Override
    public TraitBuilder from(@Nonnull Trait value)
    {
        return name(value.getName()).properties(value.getProperties()).description(value.getDescription());
    }

    @Nonnull
    @Override
    public TraitBuilder reset()
    {
        this.name = null;
        this.description = new ArrayList<>();
        this.properties = new MemoryDataContainer();
        return this;
    }
}
