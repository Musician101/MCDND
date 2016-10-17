package io.musician101.mcdnd.sponge.equipment.gear;

import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import org.spongepowered.api.data.DataContainer;

import javax.annotation.Nonnull;

public class Gear extends Equipment
{
    public Gear(String name, Cost cost, double weight)
    {
        super(name, cost, weight);
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    public static class AmmunitionGear extends BundledGear
    {
        public AmmunitionGear(String name, int amount, Cost cost, double weight)
        {
            super(name + " (" + amount + ")", amount, cost, weight);
        }
    }

    public static class ArcaneFocusGear extends Gear
    {
        public ArcaneFocusGear(String name, Cost cost, double weight)
        {
            super("Arcane Focus (" + name + ")", cost, weight);
        }
    }

    public static class BundledGear extends Gear
    {
        int amount;

        public BundledGear(String name, int amount, Cost cost, double weight)
        {
            super(name, cost, weight);
            this.amount = amount;
        }

        public double getAmount()
        {
            return amount;
        }

        @Override
        public int getContentVersion()
        {
            return 1;
        }

        @Nonnull
        @Override
        public DataContainer toContainer()
        {
            return super.toContainer()
                    .set(MCDNDKeys.AMOUNT, amount);
        }
    }

    public static class DruidicFocusGear extends Gear
    {
        public DruidicFocusGear(String name, Cost cost, double weight)
        {
            super("Druidic Focus (" + name + ")", cost, weight);
        }
    }
}
