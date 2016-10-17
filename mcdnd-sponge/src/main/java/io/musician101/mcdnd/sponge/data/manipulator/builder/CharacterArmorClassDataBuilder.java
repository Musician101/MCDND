package io.musician101.mcdnd.sponge.data.manipulator.builder;

import io.musician101.mcdnd.sponge.armor.CharacterArmorClass;
import io.musician101.mcdnd.sponge.data.manipulator.builder.common.SingleValueDataManipulatorBuilder;
import io.musician101.mcdnd.sponge.data.manipulator.immutable.ImmutableCharacterArmorClassData;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.CharacterArmorClassData;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Optional;

public class CharacterArmorClassDataBuilder extends SingleValueDataManipulatorBuilder<CharacterArmorClass, CharacterArmorClassData, ImmutableCharacterArmorClassData>
{
    @Nonnull
    @Override
    public CharacterArmorClassData create()
    {
        return new CharacterArmorClassData(value);
    }

    @Nonnull
    @Override
    public Optional<CharacterArmorClassData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<CharacterArmorClass> armorClass = dataHolder.get(MCDNDKeys.CHARACTER_ARMOR_CLASS);//NOSONAR
        if (!armorClass.isPresent())
            return Optional.empty();

        this.value = armorClass.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<CharacterArmorClassData> build(@Nonnull DataView container)
    {
        Optional<CharacterArmorClass> armorClass = container.getObject(MCDNDKeys.SAVING_THROW_PROFICIENCIES.getQuery(), CharacterArmorClass.class);//NOSONAR
        if (!armorClass.isPresent())
            return Optional.empty();

        this.value = armorClass.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public CharacterArmorClassDataBuilder reset()
    {
        value = null;
        return this;
    }

    @Nonnull
    @Override
    public CharacterArmorClassDataBuilder from(@Nonnull CharacterArmorClassData value)
    {
        //noinspection OptionalGetWithoutIsPresent
        this.value = value.get(MCDNDKeys.CHARACTER_ARMOR_CLASS).get();
        return this;
    }
}
