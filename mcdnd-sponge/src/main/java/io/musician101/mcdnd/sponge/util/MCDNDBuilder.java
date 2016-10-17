package io.musician101.mcdnd.sponge.util;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MCDNDBuilder<T extends MCDNDBuildable, B extends MCDNDBuilder<T, B>> implements ResettableBuilder<T, B>
{
    protected DataContainer properties = new MemoryDataContainer();
    protected List<String> description = new ArrayList<>();
    protected String name;

    public abstract B addLineToDescription(String line);

    public abstract B description(List<String> description);

    public B description(String... description)
    {
        return description(Arrays.asList(description));
    }

    public abstract B name(String name);

    public abstract <V> B addProperty(Key<? extends BaseValue<V>> key, V value);

    public abstract B properties(DataContainer properties);

    public abstract T build();

    @Nonnull
    @Override
    public B from(@Nonnull T value)
    {
        return name(value.getName())
                .description(value.getDescription())
                .properties(properties);
    }
}
