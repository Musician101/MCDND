package io.musician101.sponge.mcdnd.property.single;

import io.musician101.sponge.mcdnd.combat.MCDNDDamageType;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class DamageTypeProperty extends SingleValueProperty<MCDNDDamageType>
{
    public DamageTypeProperty(MCDNDDamageType damageType)
    {
        super(damageType);
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
        return new MemoryDataContainer()
                .set(MCDNDKeys.DAMAGE_TYPE, value);
    }
}
