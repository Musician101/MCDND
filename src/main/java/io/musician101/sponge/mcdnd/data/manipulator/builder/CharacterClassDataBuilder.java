package io.musician101.sponge.mcdnd.data.manipulator.builder;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.builder.common.MappedDataManipulatorBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableCharacterClassData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.CharacterClassData;
import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import io.musician101.sponge.mcdnd.util.Utils;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;

public class CharacterClassDataBuilder extends MappedDataManipulatorBuilder<CharacterClassType, Integer, CharacterClassData, ImmutableCharacterClassData>
{
    @Nonnull
    @Override
    public CharacterClassData create()
    {
        return new CharacterClassData(value);
    }

    @Nonnull
    @Override
    public Optional<CharacterClassData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<Map<CharacterClassType, Integer>> optional = dataHolder.get(MCDNDKeys.CHARACTER_CLASSES);//NOSONAR
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<CharacterClassData> build(@Nonnull DataView container)
    {
        Optional<Map<CharacterClassType, Integer>> optional = Utils.getObjectMap((DataContainer) container, MCDNDKeys.SAVING_THROW_PROFICIENCIES.getQuery(), CharacterClassType.class, Integer.class);
        if (!optional.isPresent())
            return Optional.empty();

        this.value = optional.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public CharacterClassDataBuilder reset()
    {
        value = null;
        return this;
    }

    @Nonnull
    @Override
    public CharacterClassDataBuilder from(@Nonnull CharacterClassData value)
    {
        //noinspection OptionalGetWithoutIsPresent
        this.value = value.get(MCDNDKeys.CHARACTER_CLASSES).get();
        return this;
    }
}
