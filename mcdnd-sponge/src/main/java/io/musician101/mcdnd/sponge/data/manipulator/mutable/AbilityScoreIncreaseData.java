package io.musician101.mcdnd.sponge.data.manipulator.mutable;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableAbilityScoreIncreaseData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.util.Utils;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractMappedData;
import org.spongepowered.api.data.merge.MergeFunction;

public class AbilityScoreIncreaseData extends AbstractMappedData<AbilityScoreType, Integer, AbilityScoreIncreaseData, ImmutableAbilityScoreIncreaseData> {

    //TODO add point buy system and standard system array (15, 14, 13, 12, 10, 8)
    public AbilityScoreIncreaseData(Map<AbilityScoreType, Integer> value) {
        super(value, MCDNDKeys.ABILITY_SCORES);
    }

    @Nonnull
    @Override
    public ImmutableAbilityScoreIncreaseData asImmutable() {
        return new ImmutableAbilityScoreIncreaseData(getValue());
    }

    @Nonnull
    @Override
    public AbilityScoreIncreaseData copy() {
        return new AbilityScoreIncreaseData(getValue());
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreIncreaseData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap) {
        Optional<Map<AbilityScoreType, Integer>> optional = overlap.merge(copy(), dataHolder).get(usedKey);
        if (optional.isPresent()) {
            setValue(optional.get());
        }

        return Optional.of(this);
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreIncreaseData> from(@Nonnull DataContainer container) {
        Optional<Map<AbilityScoreType, Integer>> optional = Utils.getObjectMap(container, usedKey.getQuery(), AbilityScoreType.class, Integer.class);
        if (optional.isPresent()) {
            setValue(optional.get());
        }

        return Optional.of(this);
    }

    @Nonnull
    @Override
    public Optional<Integer> get(@Nonnull AbilityScoreType key) {
        if (getValue().containsKey(key)) {
            return Optional.of(getValue().get(key));
        }

        return Optional.empty();
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Nonnull
    @Override
    public Set<AbilityScoreType> getMapKeys() {
        return getValue().keySet();
    }

    @Nonnull
    @Override
    public AbilityScoreIncreaseData put(@Nonnull AbilityScoreType key, @Nonnull Integer value) {
        getValue().put(key, value);
        return this;
    }

    @Nonnull
    @Override
    public AbilityScoreIncreaseData putAll(@Nonnull Map<? extends AbilityScoreType, ? extends Integer> map) {
        getValue().putAll(map);
        return this;
    }

    @Nonnull
    @Override
    public AbilityScoreIncreaseData remove(@Nonnull AbilityScoreType key) {
        getValue().remove(key);
        return this;
    }
}
