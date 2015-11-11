package musician101.mcdnd.property;

import musician101.mcdnd.util.Interfaces.Identified;

//TODO look at spongeapi datamanipulator for property coding
public class Property implements Identified
{
    protected String id;

    protected Property(String id)
    {
        this.id = id;
    }

    @Override
    public String getId()
    {
        return id;
    }
}
