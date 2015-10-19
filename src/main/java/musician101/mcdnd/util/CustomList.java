package musician101.mcdnd.util;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "serial"})
public class CustomList<T> extends ArrayList<T>
{
    @SafeVarargs
    public CustomList(List<? extends T>... lists)
    {
        super();
        for (List<? extends T> list : lists)
            addAll(list);
    }

    public CustomList(T... items)
    {
        add(items);
    }

    public List<T> add(T... items)
    {
        for (T item : items)
            add(item);

        return this;
    }

    public List<T> add(List<T> items)
    {
        addAll(items);
        return this;
    }
}
