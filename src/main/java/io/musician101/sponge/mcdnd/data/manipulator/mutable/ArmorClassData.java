package io.musician101.sponge.mcdnd.data.manipulator.mutable;

import io.musician101.sponge.mcdnd.armor.ArmorClass;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableArmorClassData;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.mutable.Value;

import javax.annotation.Nonnull;
import java.util.Optional;

public class ArmorClassData extends AbstractSingleData<ArmorClass, ArmorClassData, ImmutableArmorClassData>//NOSONAR
{
    private final Value<ArmorClass> armorClassValue;

    public ArmorClassData(ArmorClass armorClass)
    {
        super(armorClass, MCDNDKeys.ARMOR_CLASS);
        this.armorClassValue = Sponge.getRegistry().getValueFactory().createValue(MCDNDKeys.ARMOR_CLASS, getValue());
    }

    @Nonnull
    @Override
    protected Value<ArmorClass> getValueGetter()
    {
        return armorClassValue;
    }

    @Nonnull
    @Override
    public Optional<ArmorClassData> fill(@Nonnull DataHolder dataHolder, @Nonnull MergeFunction overlap)
    {
        Optional<ArmorClass> optional = overlap.merge(copy(), dataHolder).get(usedKey);
        if (optional.isPresent())
            return Optional.of(new ArmorClassData(optional.get()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<ArmorClassData> from(@Nonnull DataContainer container)
    {
        Optional<ArmorClass> listOptional = container.getObject(usedKey.getQuery(), ArmorClass.class);
        if (listOptional.isPresent())
            return Optional.of(new ArmorClassData(getValue()));

        return Optional.empty();
    }

    @Nonnull
    @Override
    public ArmorClassData copy()
    {
        return new ArmorClassData(getValue());
    }

    @Nonnull
    @Override
    public ImmutableArmorClassData asImmutable()
    {
        return new ImmutableArmorClassData(getValue());
    }

    @Override
    public int compareTo(@Nonnull ArmorClassData o)
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
