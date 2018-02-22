package io.musician101.mcdnd.sponge.util.table;

import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.ResettableBuilder;

public class TableBuilder implements ResettableBuilder<Table, TableBuilder> {

    private DataContainer columns = DataContainer.createNew();
    private String name;

    public <V> TableBuilder addColumn(Key<? extends BaseValue<V>> key, V value) {
        columns.set(key, value);
        return this;
    }

    public Table build() {
        return new Table(name, columns);
    }

    public TableBuilder columns(DataContainer columns) {
        this.columns = columns;
        return this;
    }

    @Nonnull
    @Override
    public TableBuilder from(@Nonnull Table value) {
        return name(value.getName()).columns(value.getColumns());
    }

    public TableBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Nonnull
    @Override
    public TableBuilder reset() {
        columns = DataContainer.createNew();
        name = null;
        return this;
    }
}
