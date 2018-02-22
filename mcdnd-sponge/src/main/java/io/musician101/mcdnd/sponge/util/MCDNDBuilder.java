package io.musician101.mcdnd.sponge.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

public abstract class MCDNDBuilder<T extends MCDNDBuildable, B extends MCDNDBuilder<T, B>> implements ResettableBuilder<T, B> {

    protected List<String> description = new ArrayList<>();
    protected String name;
    protected DataContainer properties = DataContainer.createNew();

    public abstract B addLineToDescription(String line);

    public abstract <V> B addProperty(Key<? extends BaseValue<V>> key, V value);

    public abstract T build();

    public abstract B description(List<String> description);

    public B description(String... description) {
        return description(Arrays.asList(description));
    }

    @Nonnull
    @Override
    public B from(@Nonnull T value) {
        return name(value.getName()).description(value.getDescription()).properties(properties);
    }

    public abstract B name(String name);

    public abstract B properties(DataContainer properties);
}
