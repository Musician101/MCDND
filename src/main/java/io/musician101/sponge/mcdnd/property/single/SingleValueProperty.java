package io.musician101.sponge.mcdnd.property.single;

import io.musician101.sponge.mcdnd.property.Property;
import io.musician101.sponge.mcdnd.util.Interfaces.SingleValue;

public abstract class SingleValueProperty<T> extends Property implements SingleValue<T>
{
    protected final T value;

    protected SingleValueProperty(T value)
    {
        super();
        this.value = value;
    }

    @Override
    public T getValue()
    {
        return value;
    }
}
