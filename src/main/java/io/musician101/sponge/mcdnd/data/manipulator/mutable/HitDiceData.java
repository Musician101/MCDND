package io.musician101.sponge.mcdnd.data.manipulator.mutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableHitDiceData;
import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import io.musician101.sponge.mcdnd.dice.HitDice;
import io.musician101.sponge.mcdnd.util.Utils;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractMappedData;
import org.spongepowered.api.data.merge.MergeFunction;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class HitDiceData extends AbstractMappedData<CharacterClassType, HitDice, HitDiceData, ImmutableHitDiceData>
{
    public HitDiceData(Map<CharacterClassType, HitDice> value)
    {
        super(value, MCDNDKeys.CHARACTER_HIT_DICE);
    }

    public Optional<String> getHitPointsAtFirstLevel(CharacterClassType clazz)
    {
        Optional<HitDice> optional = get(clazz);
        if (optional.isPresent())
            return Optional.of(optional.get().sides() + " + your Constitution modifier");

        return Optional.empty();
    }

    public Optional<String> getHitPointsAtHigherLevels(CharacterClassType clazz)
    {
        Optional<HitDice> optional = get(clazz);
        if (!optional.isPresent())
            return Optional.empty();

        HitDice hd = optional.get();
        return Optional.of(hd.toString() + " (or " + (optional.get().sides() / 2) + " + your Constitution modifier per " + clazz.getName() + " level");
    }

    @Nonnull
    @Override
    public Optional<HitDice> get(@Nonnull CharacterClassType key)
    {
        if (getValue().containsKey(key))
            return Optional.of(getValue().get(key));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Set<CharacterClassType> getMapKeys()
    {
        return getValue().keySet();
    }

    @Nonnull
    @Override
    public HitDiceData put(@Nonnull CharacterClassType key, @Nonnull HitDice value)
    {
        Map<CharacterClassType, HitDice> map = getValue();
        map.put(key, value);
        return new HitDiceData(map);
    }

    @Nonnull
    @Override
    public HitDiceData putAll(@Nonnull Map<? extends CharacterClassType, ? extends HitDice> map)
    {
        Map<CharacterClassType, HitDice> newMap = getValue();
        newMap.putAll(map);
        return new HitDiceData(newMap);
    }

    @Nonnull
    @Override
    public HitDiceData remove(@Nonnull CharacterClassType key)
    {
        Map<CharacterClassType, HitDice> map = getValue();
        map.remove(key);
        return new HitDiceData(map);
    }

    @Nonnull
    @Override
    public Optional<HitDiceData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap)
    {
        Optional<Map<CharacterClassType, HitDice>> optional = overlap.merge(this, dataHolder).get(usedKey);
        if (optional.isPresent())
            return Optional.of(new HitDiceData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<HitDiceData> from(@Nonnull DataContainer container)
    {
        Optional<Map<CharacterClassType, HitDice>> optional = Utils.getObjectMap(container, usedKey.getQuery(), CharacterClassType.class, HitDice.class);
        if (optional.isPresent())
            return Optional.of(new HitDiceData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public HitDiceData copy()
    {
        return new HitDiceData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableHitDiceData asImmutable()
    {
        return new ImmutableHitDiceData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
