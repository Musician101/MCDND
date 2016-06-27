package io.musician101.sponge.mcdnd.race.trait;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraitBuilder implements ResettableBuilder<Trait, TraitBuilder>
{
    private DataContainer properties = new MemoryDataContainer();
    private List<String> description = new ArrayList<>();
    private String name;

    public TraitBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    public TraitBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    public TraitBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public TraitBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    public <V> TraitBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

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
