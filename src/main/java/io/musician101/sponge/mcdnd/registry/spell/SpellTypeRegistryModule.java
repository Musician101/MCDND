package io.musician101.sponge.mcdnd.registry.spell;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.data.type.spell.SpellType;
import io.musician101.sponge.mcdnd.data.type.spell.SpellTypes;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class SpellTypeRegistryModule implements CatalogRegistryModule<SpellType>
{
    @RegisterCatalog(SpellTypes.class)
    private final Map<String, SpellType> mappings = ImmutableMap.<String, SpellType>builder()
            .put(SpellTypes.ABJURATION.getId(), SpellTypes.ABJURATION)
            .put(SpellTypes.CONJURATION.getId(), SpellTypes.CONJURATION)
            .put(SpellTypes.DIVINATION.getId(), SpellTypes.DIVINATION)
            .put(SpellTypes.ENCHANTMENT.getId(), SpellTypes.ENCHANTMENT)
            .put(SpellTypes.EVOCATION.getId(), SpellTypes.EVOCATION)
            .put(SpellTypes.ILLUSION.getId(), SpellTypes.ILLUSION)
            .put(SpellTypes.NECROMANCY.getId(), SpellTypes.NECROMANCY)
            .put(SpellTypes.TRANSMUTATION.getId(), SpellTypes.TRANSMUTATION)
            .build();

    @Nonnull
    @Override
    public Optional<SpellType> getById(@Nonnull String id)
    {
        return Optional.ofNullable(mappings.get(id));
    }

    @Nonnull
    @Override
    public Collection<SpellType> getAll()
    {
        return mappings.values();
    }
}
