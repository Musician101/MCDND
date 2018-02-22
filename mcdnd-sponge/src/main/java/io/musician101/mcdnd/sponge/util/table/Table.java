package io.musician101.mcdnd.sponge.util.table;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.util.Interfaces.Named;
import javax.annotation.Nonnull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

//TODO add class tables as features
public class Table implements DataSerializable, Named {

    private final DataContainer columns;
    private final String name;

    protected Table(String name, DataContainer columns) {
        this.name = name;
        this.columns = columns;
    }

    public static TableBuilder builder() {
        return Sponge.getRegistry().createBuilder(TableBuilder.class);
    }

    public DataContainer getColumns() {
        return columns;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.NAME, name).set(MCDNDKeys.COLUMNS, columns);
    }
}
