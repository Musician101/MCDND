package io.musician101.mcdnd.sponge.registry;

import io.musician101.mcdnd.sponge.data.type.CurrencyType;
import io.musician101.mcdnd.sponge.data.type.CurrencyTypes;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CurrencyTypeRegistryModule implements CatalogRegistryModule<CurrencyType>
{
    @RegisterCatalog(CurrencyTypes.class)
    private final Map<String, CurrencyType> mappings = new HashMap<>();

    @Override
    public void registerDefaults()
    {
        CurrencyTypes.ALL.forEach(type -> mappings.put(type.getId(), type));
    }

    @Nonnull
    @Override
    public Optional<CurrencyType> getById(@Nonnull String id)
    {
        return Optional.ofNullable(mappings.get(id));
    }

    @Nonnull
    @Override
    public Collection<CurrencyType> getAll()
    {
        return mappings.values();
    }
}
