package io.musician101.sponge.mcdnd.util;

import io.musician101.sponge.mcdnd.util.Interfaces.Named;

public class Table implements Named
{
    String name;
    Column[] columns;

    public Table(String name, Column... columns)
    {
        this.name = name;
        this.columns = columns;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public Column getColumn(int index)
    {
        return columns[index];
    }

    public Column getColumn(String name)
    {
        for (Column column : columns)
            if (column.getName().equalsIgnoreCase(name))
                return column;

        return null;
    }

    public static class Column<E> implements Named
    {
        String name;
        E[] values;

        @SafeVarargs
        public Column(String name, E... values)
        {
            this.name = name;
            this.values = values;
        }

        @Override
        public String getName()
        {
            return name;
        }

        public E[] getValues()
        {
            return values;
        }

        public E getValue(int index)
        {
            return values[index];
        }
    }
}
