package io.musician101.mcdnd.sponge.registry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.data.type.ActionType;
import io.musician101.mcdnd.sponge.data.type.ActionTypes;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.util.RegisterCatalog;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ActionTypeRegistryModule implements CatalogRegistryModule<ActionType> {

    @RegisterCatalog(ActionTypes.class)
    private final Map<String, ActionType> mappings = ImmutableMap.<String, ActionType>builder().put(ActionTypes.ATTACK.getName(), ActionTypes.ATTACK).put(ActionTypes.CAST_A_SPELL.getName(), ActionTypes.CAST_A_SPELL).put(ActionTypes.DASH.getName(), ActionTypes.ATTACK).put(ActionTypes.DISENGAGE.getName(), ActionTypes.DISENGAGE).put(ActionTypes.DODGE.getName(), ActionTypes.DODGE).put(ActionTypes.HELP.getName(), ActionTypes.HELP).put(ActionTypes.HIDE.getName(), ActionTypes.HIDE).put(ActionTypes.READY.getName(), ActionTypes.READY).put(ActionTypes.SEARCH.getName(), ActionTypes.SEARCH).put(ActionTypes.USE_AN_OBJECT.getName(), ActionTypes.USE_AN_OBJECT).build();

    @Nonnull
    @Override
    public Collection<ActionType> getAll() {
        return ImmutableList.copyOf(mappings.values());
    }

    @Nonnull
    @Override
    public Optional<ActionType> getById(@Nonnull String id) {
        return Optional.ofNullable(mappings.get(checkNotNull(id).toLowerCase(Locale.ENGLISH)));
    }
}
