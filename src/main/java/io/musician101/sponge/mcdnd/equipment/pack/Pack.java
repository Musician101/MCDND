package io.musician101.sponge.mcdnd.equipment.pack;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import org.spongepowered.api.data.DataContainer;

import javax.annotation.Nonnull;
import java.util.Map;

public class Pack extends Equipment
{
    private final Map<Equipment, Integer> contents;

    public Pack(String name, Cost cost, Map<Equipment, Integer> contents)
    {
        super(name, cost, 0);
        this.contents = contents;
    }

    public Map<Equipment, Integer> getContents()
    {
        return contents;
    }

    @Override
    public double getWeight()
    {
        double weight = 0;
        for (Equipment equipment : contents.keySet())
            weight =+ (weight * contents.get(equipment));

        return weight;
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
                .set(MCDNDKeys.PACK_CONTENTS, contents);
    }
}
