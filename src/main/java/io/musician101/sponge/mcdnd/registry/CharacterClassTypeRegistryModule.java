package io.musician101.sponge.mcdnd.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import io.musician101.sponge.mcdnd.data.type.CharacterClassTypes;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public final class CharacterClassTypeRegistryModule implements CatalogRegistryModule<CharacterClassType>
{
    @RegisterCatalog(CharacterClassTypes.class)
    private final Map<String, CharacterClassType> mappings = new ImmutableMap.Builder<String, CharacterClassType>()
            .put(CharacterClassTypes.BARBARIAN.getId(), CharacterClassTypes.BARBARIAN)
            .put(CharacterClassTypes.BARD.getId(), CharacterClassTypes.BARD)
            .put(CharacterClassTypes.CLERIC.getId(), CharacterClassTypes.CLERIC)
            .put(CharacterClassTypes.DRUID.getId(), CharacterClassTypes.DRUID)
            .put(CharacterClassTypes.FIGHTER.getId(), CharacterClassTypes.FIGHTER)
            .put(CharacterClassTypes.MONK.getId(), CharacterClassTypes.MONK)
            .put(CharacterClassTypes.PALADIN.getId(), CharacterClassTypes.PALADIN)
            .put(CharacterClassTypes.RANGER.getId(), CharacterClassTypes.RANGER)
            .put(CharacterClassTypes.ROGUE.getId(), CharacterClassTypes.ROGUE)
            .put(CharacterClassTypes.SORCERER.getId(), CharacterClassTypes.SORCERER)
            .put(CharacterClassTypes.WARLOCK.getId(), CharacterClassTypes.WARLOCK)
            .put(CharacterClassTypes.WIZARD.getId(), CharacterClassTypes.WIZARD)
            .build();

    @Nonnull
    @Override
    public Optional<CharacterClassType> getById(@Nonnull String id)
    {
        return Optional.ofNullable(mappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }

    @Nonnull
    @Override
    public Collection<CharacterClassType> getAll()
    {
        return ImmutableList.copyOf(mappings.values());
    }
}
