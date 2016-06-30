package io.musician101.sponge.mcdnd.condition;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class ConditionBuilder implements ResettableBuilder<Condition, ConditionBuilder>
{
    DataContainer properties = new MemoryDataContainer();
    List<String> description;
    String name;

    public ConditionBuilder description(List<String> description)
    {
        this.description = description;
        return this;
    }

    public ConditionBuilder description(String... description)
    {
        return description(Arrays.asList(description));
    }

    public ConditionBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public <V> ConditionBuilder addProperty(Key<? extends BaseValue<V>> key, V value)
    {
        properties.set(key, value);
        return this;
    }

    public ConditionBuilder properties(DataContainer properties)
    {
        this.properties = properties;
        return this;
    }

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
        description = null;
        name = null;
        return this;
    }
}
