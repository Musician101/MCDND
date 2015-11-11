package musician101.mcdnd.property;

import musician101.mcdnd.util.Interfaces.SingleValue;

public class SingleValueProperty<T> extends Property implements SingleValue<T>
{
    T value;

    public SingleValueProperty(String id, T value)
    {
        super(id);
        this.value = value;
    }

    @Override
    public T getValue()
    {
        return value;
    }
}
