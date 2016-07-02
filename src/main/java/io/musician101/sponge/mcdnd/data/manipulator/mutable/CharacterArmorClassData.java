package io.musician101.sponge.mcdnd.data.manipulator.mutable;

import io.musician101.sponge.mcdnd.armor.CharacterArmorClass;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableCharacterArmorClassData;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.mutable.Value;

import javax.annotation.Nonnull;
import java.util.Optional;

public class CharacterArmorClassData extends AbstractSingleData<CharacterArmorClass, CharacterArmorClassData, ImmutableCharacterArmorClassData>//NOSONAR
{
    private final Value<CharacterArmorClass> armorClassValue;

    public CharacterArmorClassData(CharacterArmorClass characterArmorClass)
    {
        super(characterArmorClass, MCDNDKeys.CHARACTER_ARMOR_CLASS);
        this.armorClassValue = Sponge.getRegistry().getValueFactory().createValue(MCDNDKeys.CHARACTER_ARMOR_CLASS, getValue());
    }

    @Nonnull
    @Override
    protected Value<CharacterArmorClass> getValueGetter()
    {
        return armorClassValue;
    }

    @Nonnull
    @Override
    public Optional<CharacterArmorClassData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap)
    {
        Optional<CharacterArmorClass> optional = overlap.merge(copy(), dataHolder).get(usedKey);
        if (optional.isPresent())
            return Optional.of(new CharacterArmorClassData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<CharacterArmorClassData> from(@Nonnull DataContainer container)
    {
        Optional<CharacterArmorClass> listOptional = container.getObject(usedKey.getQuery(), CharacterArmorClass.class);
        if (listOptional.isPresent())
            return Optional.of(new CharacterArmorClassData(getValue()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public CharacterArmorClassData copy()
    {
        return new CharacterArmorClassData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableCharacterArmorClassData asImmutable()
    {
        return new ImmutableCharacterArmorClassData(getValue());
    }

    @Override
    public int compareTo(@Nonnull CharacterArmorClassData o)
    {
        Optional<CharacterArmorClass> armorClassOptional = o.get(usedKey);
        //noinspection OptionalGetWithoutIsPresent
        return Boolean.compare(armorClassOptional.isPresent(), getValue().equals(armorClassOptional.get()));
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
