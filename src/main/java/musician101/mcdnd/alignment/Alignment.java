package musician101.mcdnd.alignment;

public class Alignment
{
    final String abbreviation;
    final String description;
    final String name;

    public Alignment(String name, String abbreviation, String description)
    {
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
}
