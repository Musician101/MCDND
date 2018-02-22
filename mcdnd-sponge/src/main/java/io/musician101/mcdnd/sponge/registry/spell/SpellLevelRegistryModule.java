package io.musician101.mcdnd.sponge.registry.spell;

import io.musician101.mcdnd.sponge.data.type.spell.SpellLevel;
import io.musician101.mcdnd.sponge.data.type.spell.SpellLevels;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

public class SpellLevelRegistryModule implements CatalogRegistryModule<SpellLevel> {

    @RegisterCatalog(SpellLevels.class)
    private final Map<String, SpellLevel> mappings = new HashMap<>();

    @Nonnull
    @Override
    public Collection<SpellLevel> getAll() {
        return mappings.values();
    }

    @Nonnull
    @Override
    public Optional<SpellLevel> getById(@Nonnull String id) {
        return Optional.ofNullable(mappings.get(id));
    }

    @Override
    public void registerDefaults() {
        SpellLevels.ALL.forEach(level -> mappings.put(level.getId(), level));
    }
}
