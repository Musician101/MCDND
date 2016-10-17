package io.musician101.mcdnd.sponge.registry.skill;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.data.type.skill.SkillModType;
import io.musician101.mcdnd.sponge.data.type.skill.SkillModTypes;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public final class SkillModTypeRegistryModule implements CatalogRegistryModule<SkillModType>
{
    @RegisterCatalog(SkillModTypes.class)
    private final Map<String, SkillModType> weaponTypeMappings = new ImmutableMap.Builder<String, SkillModType>()
            .put(SkillModTypes.EXPERTISE.getId(), SkillModTypes.EXPERTISE)
            .put(SkillModTypes.JACK_OF_ALL_TRADES.getId(), SkillModTypes.JACK_OF_ALL_TRADES)
            .put(SkillModTypes.NONE.getId(), SkillModTypes.NONE)
            .put(SkillModTypes.PROFICIENT.getId(), SkillModTypes.PROFICIENT)
            .build();

    @Nonnull
    @Override
    public Optional<SkillModType> getById(@Nonnull String id)
    {
        return Optional.ofNullable(weaponTypeMappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }

    @Nonnull
    @Override
    public Collection<SkillModType> getAll()
    {
        return ImmutableList.copyOf(weaponTypeMappings.values());
    }
}
