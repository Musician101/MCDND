package io.musician101.mcdnd.sponge.registry.weapon;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.data.type.WeaponType;
import io.musician101.mcdnd.sponge.data.type.WeaponTypes;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import static com.google.common.base.Preconditions.checkNotNull;

public final class WeaponTypeRegistryModule implements CatalogRegistryModule<WeaponType> {

    @RegisterCatalog(WeaponTypes.class)
    private final Map<String, WeaponType> mappings = new ImmutableMap.Builder<String, WeaponType>().put(WeaponTypes.MARTIAL_MELEE.getId(), WeaponTypes.MARTIAL_MELEE).put(WeaponTypes.MARTIAL_RANGED.getId(), WeaponTypes.MARTIAL_RANGED).put(WeaponTypes.SIMPLE_MELEE.getId(), WeaponTypes.SIMPLE_MELEE).put(WeaponTypes.SIMPLE_RANGED.getId(), WeaponTypes.SIMPLE_RANGED).build();

    @Nonnull
    @Override
    public Collection<WeaponType> getAll() {
        return ImmutableList.copyOf(mappings.values());
    }

    @Nonnull
    @Override
    public Optional<WeaponType> getById(@Nonnull String id) {
        return Optional.ofNullable(mappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }
}
