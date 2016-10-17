package io.musician101.mcdnd.sponge.condition;

import io.musician101.mcdnd.sponge.util.MCDNDBuilder;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConditionBuilder extends MCDNDBuilder<Condition, ConditionBuilder>
{
    @Override
    public ConditionBuilder addLineToDescription(String line)
    {
        description.add(line);
        return this;
    }

    @Override
    public ConditionBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    @Override
    public ConditionBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    @Override
    public ConditionBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public <V> ConditionBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

    @Override
    public ConditionBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

    @Override
    public Condition build()
    {
        return new Condition(name, properties, description);
    }

    @Nonnull
    @Override
    public ConditionBuilder from(@Nonnull Condition value)
    {
        return name(value.getName()).description(value.getDescription()).properties(value.getProperties());
    }

    @Nonnull
    @Override
    public ConditionBuilder reset()
    {
        properties = new MemoryDataContainer();
        description = new ArrayList<>();
        name = null;
        return this;
    }
}
