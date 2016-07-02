package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.armor.CharacterArmorClass;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.CharacterArmorClassData;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

import javax.annotation.Nonnull;
import java.util.Optional;

public class ImmutableCharacterArmorClassData extends AbstractImmutableSingleData<CharacterArmorClass, ImmutableCharacterArmorClassData, CharacterArmorClassData>//NOSONAR
{
    private final ImmutableValue<CharacterArmorClass> armorClassValue;

    public ImmutableCharacterArmorClassData(CharacterArmorClass characterArmorClass)
    {
        super(characterArmorClass, MCDNDKeys.CHARACTER_ARMOR_CLASS);
        this.armorClassValue = Sponge.getRegistry().getValueFactory().createValue(MCDNDKeys.CHARACTER_ARMOR_CLASS, value).asImmutable();
    }

    @Nonnull
    @Override
    protected ImmutableValue<CharacterArmorClass> getValueGetter()
    {
        return armorClassValue;
    }

    @Nonnull
    @Override
    public CharacterArmorClassData asMutable()
    {
        return new CharacterArmorClassData(getValue());
    }

    @Override
    public int compareTo(@Nonnull ImmutableCharacterArmorClassData o)
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
