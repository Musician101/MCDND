package io.musician101.sponge.mcdnd.data.manipulator.builder;

import io.musician101.sponge.mcdnd.armor.ArmorClass;
import io.musician101.sponge.mcdnd.data.manipulator.builder.common.SingleValueDataManipulatorBuilder;
import io.musician101.sponge.mcdnd.data.manipulator.immutable.ImmutableArmorClassData;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.ArmorClassData;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;

import javax.annotation.Nonnull;
import java.util.Optional;

public class ArmorClassDataBuilder extends SingleValueDataManipulatorBuilder<ArmorClass, ArmorClassData, ImmutableArmorClassData>
{
    @Nonnull
    @Override
    public ArmorClassData create()
    {
        return new ArmorClassData(value);
    }

    @Nonnull
    @Override
    public Optional<ArmorClassData> createFrom(@Nonnull DataHolder dataHolder)
    {
        Optional<ArmorClass> armorClass = dataHolder.get(MCDNDKeys.ARMOR_CLASS);//NOSONAR
        if (!armorClass.isPresent())
            return Optional.empty();

        this.value = armorClass.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public Optional<ArmorClassData> build(@Nonnull DataView container)
    {
        Optional<ArmorClass> armorClass = container.getObject(MCDNDKeys.SAVING_THROW_PROFICIENCIES.getQuery(), ArmorClass.class);//NOSONAR
        if (!armorClass.isPresent())
            return Optional.empty();

        this.value = armorClass.get();
        return Optional.of(create());
    }

    @Nonnull
    @Override
    public ArmorClassDataBuilder reset()
    {
        value = null;
        return this;
    }

    @Nonnull
    @Override
    public ArmorClassDataBuilder from(@Nonnull ArmorClassData value)
    {
        //noinspection OptionalGetWithoutIsPresent
        this.value = value.get(MCDNDKeys.ARMOR_CLASS).get();
        return this;
    }
}
