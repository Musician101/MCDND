package musician101.mcdnd.property;

import musician101.mcdnd.util.Interfaces.Listed;

import java.util.List;

public class ListProperty<T> extends Property implements Listed<T>
{
    protected List<T> list;

    public ListProperty(String id, List<T> list)
    {
        super(id);
        this.list = list;
    }

    @Override
    public List<T> getList()
    {
        return list;
    }

    @Override
    public T get(int index)
    {
        return list.get(index);
    }
}
