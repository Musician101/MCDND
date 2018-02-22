package io.musician101.mcdnd.sponge.clazz.feature.subclass.fightingstyle;

import io.musician101.mcdnd.sponge.util.MCDNDBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

public class FightingStyleBuilder extends MCDNDBuilder<FightingStyle, FightingStyleBuilder> {

    @Override
    public FightingStyleBuilder addLineToDescription(String line) {
        description.add(line);
        return this;
    }

    @Override
    public <V> FightingStyleBuilder addProperty(Key<? extends BaseValue<V>> key, V value) {
        properties.set(key, value);
        return this;
    }

    @Override
    public FightingStyle build() {
        return new FightingStyle(name, properties, description);
    }

    @Override
    public FightingStyleBuilder description(List<String> description) {
        this.description = description;
        return this;
    }

    @Override
    public FightingStyleBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public FightingStyleBuilder properties(DataContainer properties) {
        this.properties = properties;
        return this;
    }

    @Nonnull
    @Override
    public FightingStyleBuilder reset() {
        description = new ArrayList<>();
        name = null;
        properties = DataContainer.createNew();
        return this;
    }
}
