package io.musician101.sponge.mcdnd.data.manipulator.immutable;

import io.musician101.sponge.mcdnd.armor.ArmorClass;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.ArmorClassData;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

import javax.annotation.Nonnull;
import java.util.Optional;

public class ImmutableArmorClassData extends AbstractImmutableSingleData<ArmorClass, ImmutableArmorClassData, ArmorClassData>//NOSONAR
{
    private final ImmutableValue<ArmorClass> armorClassValue;

    public ImmutableArmorClassData(ArmorClass armorClass)
    {
        super(armorClass, MCDNDKeys.ARMOR_CLASS);
        this.armorClassValue = Sponge.getRegistry().getValueFactory().createValue(MCDNDKeys.ARMOR_CLASS, value).asImmutable();
    }

    @Nonnull
    @Override
    protected ImmutableValue<ArmorClass> getValueGetter()
    {
        return armorClassValue;
    }

    @Nonnull
    @Override
    public ArmorClassData asMutable()
    {
        return new ArmorClassData(getValue());
    }

    @Override
    public int compareTo(@Nonnull ImmutableArmorClassData o)
    {
        Optional<ArmorClass> armorClassOptional = o.get(usedKey);
        //noinspection OptionalGetWithoutIsPresent
        return Boolean.compare(armorClassOptional.isPresent(), getValue().equals(armorClassOptional.get()));
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }
}
