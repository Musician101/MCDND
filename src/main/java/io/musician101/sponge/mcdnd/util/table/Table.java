package io.musician101.sponge.mcdnd.util.table;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;

public class Table implements DataSerializable, Named
{
    private final String name;
    private final DataContainer columns;

    protected Table(String name, DataContainer columns)
    {
        this.name = name;
        this.columns = columns;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public DataContainer getColumns()
    {
        return columns;
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
                .set(MCDNDKeys.NAME, name)
                .set(MCDNDKeys.COLUMNS, columns);
    }

    public static TableBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(TableBuilder.class);
    }
}
