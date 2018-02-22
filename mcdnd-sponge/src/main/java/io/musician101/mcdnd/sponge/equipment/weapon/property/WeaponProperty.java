package io.musician101.mcdnd.sponge.equipment.weapon.property;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.util.Interfaces.Described;
import io.musician101.mcdnd.sponge.util.Interfaces.Named;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public class WeaponProperty implements DataSerializable, Described, Named {

    private final List<String> description;
    private final String name;

    public WeaponProperty(String name, String... description) {
        this.name = name;
        this.description = Arrays.asList(description);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.NAME, name).set(MCDNDKeys.DESCRIPTION, description);
    }

    public static class RangeWeaponProperty extends WeaponProperty {

        final int max;
        final int min;

        public RangeWeaponProperty(int min, int max) {
            super("Range (" + min + "/" + max + ")", "The range property lists two numbers in parentheses next to it. The first number is the weapon's normal range in feet, and the second indicates the weapon's maximum range. When attacking a target beyond normal range, you have disadvantage on the attack roll. You can't attack a target beyond the weapon's long range.");
            this.min = min;
            this.max = max;
        }

        @Override
        public int getContentVersion() {
            return 1;
        }

        public int getMaxRange() {
            return max;
        }

        public int getMinRange() {
            return min;
        }

        @Nonnull
        @Override
        public DataContainer toContainer() {
            return super.toContainer().set(MCDNDKeys.MIN_RANGE, min).set(MCDNDKeys.MAX_RANGE, max);
        }
    }

    public static class VersatileWeaponProperty extends WeaponProperty {

        final Dice dice;

        public VersatileWeaponProperty(Dice dice) {
            super("Versatile (" + dice.toString() + ")", "This weapon can be used with one or two hands. A damage value in parentheses appears with the property-the damage when the weapon is used with two hands to make a melee attack.");
            this.dice = dice;
        }

        @Override
        public int getContentVersion() {
            return 1;
        }

        public Dice getDice() {
            return dice;
        }

        @Nonnull
        @Override
        public DataContainer toContainer() {
            return super.toContainer().set(MCDNDKeys.DICE, dice);
        }
    }
}
