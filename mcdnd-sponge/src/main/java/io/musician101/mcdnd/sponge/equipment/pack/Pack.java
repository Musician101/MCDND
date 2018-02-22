package io.musician101.mcdnd.sponge.equipment.pack;

import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;

public class Pack extends Equipment {

    private final Map<Equipment, Integer> contents;

    public Pack(String name, Cost cost, Map<Equipment, Integer> contents) {
        super(name, cost, 0);
        this.contents = contents;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public Map<Equipment, Integer> getContents() {
        return contents;
    }

    @Override
    public double getWeight() {
        double weight = 0;
        for (Entry<Equipment, Integer> entry : contents.entrySet()) {
            weight = +(entry.getKey().getWeight() * entry.getValue());
        }

        return weight;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(MCDNDKeys.PACK_CONTENTS, contents);
    }
}
