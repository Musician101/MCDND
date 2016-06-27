package io.musician101.sponge.mcdnd.registry.spell;

import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevels;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SpellLevelRegistryModule implements CatalogRegistryModule<SpellLevel>
{
    @RegisterCatalog(SpellLevels.class)
    private final Map<String, SpellLevel> mappings = new HashMap<>();

    @Override
    public void registerDefaults()
    {
        SpellLevels.ALL.forEach(level -> mappings.put(level.getId(), level));
    }

    @Nonnull
    @Override
    public Optional<SpellLevel> getById(@Nonnull String id)
    {
        return Optional.ofNullable(mappings.get(id));
    }

    @Nonnull
    @Override
    public Collection<SpellLevel> getAll()
    {
        return mappings.values();
    }
}
