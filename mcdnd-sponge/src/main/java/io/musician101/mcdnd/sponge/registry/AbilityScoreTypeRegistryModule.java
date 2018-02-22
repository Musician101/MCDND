package io.musician101.mcdnd.sponge.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import static com.google.common.base.Preconditions.checkNotNull;

public final class AbilityScoreTypeRegistryModule implements CatalogRegistryModule<AbilityScoreType> {

    @RegisterCatalog(AbilityScoreTypes.class)
    private final Map<String, AbilityScoreType> mappings = new ImmutableMap.Builder<String, AbilityScoreType>().put(AbilityScoreTypes.CHARISMA.getId(), AbilityScoreTypes.CHARISMA).put(AbilityScoreTypes.CONSTITUTION.getId(), AbilityScoreTypes.CONSTITUTION).put(AbilityScoreTypes.DEXTERITY.getId(), AbilityScoreTypes.DEXTERITY).put(AbilityScoreTypes.INTELLIGENCE.getId(), AbilityScoreTypes.INTELLIGENCE).put(AbilityScoreTypes.STRENGTH.getId(), AbilityScoreTypes.STRENGTH).put(AbilityScoreTypes.WISDOM.getId(), AbilityScoreTypes.WISDOM).build();

    @Nonnull
    @Override
    public Collection<AbilityScoreType> getAll() {
        return ImmutableList.copyOf(mappings.values());
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreType> getById(@Nonnull String id) {
        return Optional.ofNullable(mappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }
}
