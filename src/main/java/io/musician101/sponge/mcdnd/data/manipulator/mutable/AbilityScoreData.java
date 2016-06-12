package io.musician101.sponge.mcdnd.data.manipulator.mutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableAbilityScoreData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.util.Utils;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractMappedData;
import org.spongepowered.api.data.merge.MergeFunction;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AbilityScoreData extends AbstractMappedData<AbilityScoreType, Integer, AbilityScoreData, ImmutableAbilityScoreData>
{
    //TODO add point buy system and standard system array (15, 14, 13, 12, 10, 8)
    public AbilityScoreData(Map<AbilityScoreType, Integer> value)
    {
        super(value, MCDNDKeys.ABILITY_SCORES);
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap)
    {
        Optional<Map<AbilityScoreType, Integer>> optional = overlap.merge(copy(), dataHolder).get(usedKey);
        if (optional.isPresent())
            setValue(optional.get());

        return Optional.of(this);
    }

    @Nonnull
    @Override
    public Optional<AbilityScoreData> from(@Nonnull DataContainer container)
    {
        Optional<Map<AbilityScoreType, Integer>> optional = Utils.getObjectMap(container, usedKey.getQuery(), AbilityScoreType.class, Integer.class);
        if (optional.isPresent())
            setValue(optional.get());

        return Optional.of(this);
    }

    @Nonnull
    @Override
    public AbilityScoreData copy()
    {
        return new AbilityScoreData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableAbilityScoreData asImmutable()
    {
        return new ImmutableAbilityScoreData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public Optional<Integer> get(@Nonnull AbilityScoreType key)
    {
        if (getValue().containsKey(key))
            return Optional.of(getValue().get(key));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Set<AbilityScoreType> getMapKeys()
    {
        return getValue().keySet();
    }

    @Nonnull
    @Override
    public AbilityScoreData put(@Nonnull AbilityScoreType key, @Nonnull Integer value)
    {
        getValue().put(key, value);
        return this;
    }

    @Nonnull
    @Override
    public AbilityScoreData putAll(@Nonnull Map<? extends AbilityScoreType, ? extends Integer> map)
    {
        getValue().putAll(map);
        return this;
    }

    @Nonnull
    @Override
    public AbilityScoreData remove(@Nonnull AbilityScoreType key)
    {
        getValue().remove(key);
        return this;
    }
}
