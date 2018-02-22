package io.musician101.mcdnd.sponge.registry.skill;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.data.type.skill.SkillType;
import io.musician101.mcdnd.sponge.data.type.skill.SkillTypes;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import static com.google.common.base.Preconditions.checkNotNull;

public final class SkillTypeRegistryModule implements CatalogRegistryModule<SkillType> {

    @RegisterCatalog(SkillTypes.class)
    private final Map<String, SkillType> mappings = new ImmutableMap.Builder<String, SkillType>().put(SkillTypes.ACROBATICS.getId(), SkillTypes.ACROBATICS).put(SkillTypes.ANIMAL_HANDLING.getId(), SkillTypes.ANIMAL_HANDLING).put(SkillTypes.ARCANA.getId(), SkillTypes.ARCANA).put(SkillTypes.ATHLETICS.getId(), SkillTypes.ATHLETICS).put(SkillTypes.DECEPTION.getId(), SkillTypes.DECEPTION).put(SkillTypes.HISTORY.getId(), SkillTypes.HISTORY).put(SkillTypes.INSIGHT.getId(), SkillTypes.INSIGHT).put(SkillTypes.INTIMIDATION.getId(), SkillTypes.INTIMIDATION).put(SkillTypes.INVESTIGATION.getId(), SkillTypes.INVESTIGATION).put(SkillTypes.MEDICINE.getId(), SkillTypes.MEDICINE).put(SkillTypes.NATURE.getId(), SkillTypes.NATURE).put(SkillTypes.PERCEPTION.getId(), SkillTypes.PERCEPTION).put(SkillTypes.PERFORMANCE.getId(), SkillTypes.PERFORMANCE).put(SkillTypes.PERSUASION.getId(), SkillTypes.PERSUASION).put(SkillTypes.RELIGION.getId(), SkillTypes.RELIGION).put(SkillTypes.SLEIGHT_OF_HAND.getId(), SkillTypes.SLEIGHT_OF_HAND).put(SkillTypes.STEALTH.getId(), SkillTypes.STEALTH).put(SkillTypes.SURVIVAL.getId(), SkillTypes.SURVIVAL).build();

    @Nonnull
    @Override
    public Collection<SkillType> getAll() {
        return ImmutableList.copyOf(mappings.values());
    }

    @Nonnull
    @Override
    public Optional<SkillType> getById(@Nonnull String id) {
        return Optional.ofNullable(mappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }
}
