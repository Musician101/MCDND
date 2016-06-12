package io.musician101.sponge.mcdnd.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.data.type.Alignment;
import io.musician101.sponge.mcdnd.data.type.Alignments;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public final class AlignmentRegistryModule implements CatalogRegistryModule<Alignment>
{
    @RegisterCatalog(Alignments.class)
    private final Map<String, Alignment> mappings = new ImmutableMap.Builder<String, Alignment>()
            .put(Alignments.LAWFUL_EVIL.getId(), Alignments.LAWFUL_EVIL)
            .put(Alignments.LAWFUL_NEUTRAL.getId(), Alignments.LAWFUL_NEUTRAL)
            .put(Alignments.LAWFUL_GOOD.getId(), Alignments.LAWFUL_GOOD)
            .put(Alignments.NEUTRAL_EVIL.getId(), Alignments.NEUTRAL_EVIL)
            .put(Alignments.NEUTRAL.getId(), Alignments.NEUTRAL)
            .put(Alignments.NEUTRAL_GOOD.getId(), Alignments.NEUTRAL_GOOD)
            .put(Alignments.CHAOTIC_EVIL.getId(), Alignments.CHAOTIC_EVIL)
            .put(Alignments.CHAOTIC_NEUTRAL.getId(), Alignments.CHAOTIC_NEUTRAL)
            .put(Alignments.CHAOTIC_GOOD.getId(), Alignments.CHAOTIC_GOOD)
            .build();

    @Nonnull
    @Override
    public Optional<Alignment> getById(@Nonnull String id)
    {
        return Optional.ofNullable(mappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }

    @Nonnull
    @Override
    public Collection<Alignment> getAll()
    {
        return ImmutableList.copyOf(mappings.values());
    }
}
