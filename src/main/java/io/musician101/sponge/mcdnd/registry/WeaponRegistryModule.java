package io.musician101.sponge.mcdnd.registry;

import com.google.common.collect.ImmutableList;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapon;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public final class WeaponRegistryModule implements CatalogRegistryModule<Weapon>
{
    @RegisterCatalog(Weapons.class)
    private static final Map<String, Weapon> mappings = new HashMap<>();

    @Override
    public void registerDefaults()
    {
        Weapons.getAll().forEach(weapon -> mappings.put(weapon.getId(), weapon));
    }

    @Nonnull
    @Override
    public Optional<Weapon> getById(@Nonnull String id)
    {
        return Optional.ofNullable(mappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }

    @Nonnull
    @Override
    public Collection<Weapon> getAll()
    {
        return ImmutableList.copyOf(mappings.values());
    }
}
