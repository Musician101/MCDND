package io.musician101.sponge.mcdnd.data.manipulator.mutable;

import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableCharacterClassData;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractMappedData;
import org.spongepowered.api.data.merge.MergeFunction;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

public class CharacterClassData extends AbstractMappedData<CharacterClassType, Integer, CharacterClassData, ImmutableCharacterClassData>
{
    public CharacterClassData(Map<CharacterClassType, Integer> value)
    {
        super(value, MCDNDKeys.CHARACTER_CLASSES);
    }

    @Nonnull
    @Override
    public Optional<CharacterClassData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap)
    {
        Optional<Map<CharacterClassType, Integer>> alignmentOptional = overlap.merge(copy(), dataHolder).get(usedKey);
        if (alignmentOptional.isPresent())
            return Optional.of(new CharacterClassData(alignmentOptional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<CharacterClassData> from(@Nonnull DataContainer container)
    {
        Optional<? extends Map<?, ?>> optional = container.getMap(usedKey.getQuery());
        if (!optional.isPresent())
            return Optional.empty();

        Map<CharacterClassType, Integer> map = new HashMap<>();
        for (Entry entry : optional.get().entrySet())
            map.put((CharacterClassType) entry.getKey(), (Integer) entry.getValue());

        return Optional.of(new CharacterClassData(map));
    }

    @Nonnull
    @Override
    public CharacterClassData copy()
    {
        return new CharacterClassData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableCharacterClassData asImmutable()
    {
        return new ImmutableCharacterClassData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public Optional<Integer> get(@Nonnull CharacterClassType key)
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
    public CharacterClassData put(@Nonnull CharacterClassType key, @Nonnull Integer value)
    {
        Map<CharacterClassType, Integer> map = getValue();
        map.put(key, value);
        return new CharacterClassData(map);
    }

    @Nonnull
    @Override
    public CharacterClassData putAll(@Nonnull Map<? extends CharacterClassType, ? extends Integer> map)
    {
        Map<CharacterClassType, Integer> newMap = getValue();
        newMap.putAll(map);
        return new CharacterClassData(newMap);
    }

    @Nonnull
    @Override
    public CharacterClassData remove(@Nonnull CharacterClassType key)
    {
        Map<CharacterClassType, Integer> map = getValue();
        map.remove(key);
        return new CharacterClassData(map);
    }
}
