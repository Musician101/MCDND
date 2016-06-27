package io.musician101.sponge.mcdnd.util.table;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;

public class TableBuilder implements ResettableBuilder<Table, TableBuilder>
{
    private DataContainer columns = new MemoryDataContainer();
    private String name;

    public <V> TableBuilder addColumn(Key<? extends BaseValue<V>> key, V value)
    {
        columns.set(key, value);
        return this;
    }

    public TableBuilder columns(DataContainer columns)
    {
        this.columns = columns;
        return this;
    }

    public TableBuilder name(String name)
    {
        this.name = name;
        return this;
    }

    public Table build()
    {
        return new Table(name, columns);
    }

    @Nonnull
    @Override
    public TableBuilder from(@Nonnull Table value)
    {
        return name(value.getName()).columns(value.getColumns());
    }

    @Nonnull
    @Override
    public TableBuilder reset()
    {
        columns = new MemoryDataContainer();
        name = null;
        return this;
    }
}
