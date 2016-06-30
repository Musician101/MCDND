package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.CharacterClassData;
import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableMappedData;

import javax.annotation.Nonnull;
import java.util.Map;

public class ImmutableCharacterClassData extends AbstractImmutableMappedData<CharacterClassType, Integer, ImmutableCharacterClassData, CharacterClassData>
{
    public ImmutableCharacterClassData(Map<CharacterClassType, Integer> value)
    {
        super(value, MCDNDKeys.CHARACTER_CLASSES);
    }

    @Nonnull
    @Override
    public CharacterClassData asMutable()
    {
        return new CharacterClassData(getValue());
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}