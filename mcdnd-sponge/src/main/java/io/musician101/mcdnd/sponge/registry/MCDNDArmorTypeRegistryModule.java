package io.musician101.mcdnd.sponge.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorType;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorTypes;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import static com.google.common.base.Preconditions.checkNotNull;

public final class MCDNDArmorTypeRegistryModule implements CatalogRegistryModule<MCDNDArmorType> {

    @RegisterCatalog(MCDNDArmorType.class)
    private final Map<String, MCDNDArmorType> mappings = new ImmutableMap.Builder<String, MCDNDArmorType>().put(MCDNDArmorTypes.LIGHT.getId(), MCDNDArmorTypes.LIGHT).put(MCDNDArmorTypes.MEDIUM.getId(), MCDNDArmorTypes.MEDIUM).put(MCDNDArmorTypes.HEAVY.getId(), MCDNDArmorTypes.HEAVY).put(MCDNDArmorTypes.SHIELD.getId(), MCDNDArmorTypes.SHIELD).put(MCDNDArmorTypes.UNARMORED.getId(), MCDNDArmorTypes.UNARMORED).build();

    @Nonnull
    @Override
    public Collection<MCDNDArmorType> getAll() {
        return ImmutableList.copyOf(mappings.values());
    }

    @Nonnull
    @Override
    public Optional<MCDNDArmorType> getById(@Nonnull String id) {
        return Optional.ofNullable(mappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }
}
