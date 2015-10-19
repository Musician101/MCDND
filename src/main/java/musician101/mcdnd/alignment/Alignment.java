package musician101.mcdnd.alignment;

public enum Alignment
{
    LAWFUL_GOOD("Lawful Good", "LG", "Lawful good creatures can be counted on to do the right thing as expected by " + "society."),
    NEUTRAL_GOOD("Neutral Good", "NG", "Neutral good folk do the best they can to help others according to their " +
			"needs."),
    CHAOTIC_GOOD("Chaotic Good", "CG", "Chaotic good creatures act as their conscience directs, with little regard "
			+ "for what others expect."),
    LAWFUL_NEUTRAL("Lawful Neutral", "LN", "Lawful neutral individuals act in accordance with law, tradition, or " +
			"personal codes."),
    NEUTRAL("Neutral", "N", "Neutral is the alignment of those who prefer to steer clear of moral questions and " +
			"don't" + " takes sides, doing what seems best at the time."),
    CHAOTIC_NEUTRAL("Chaotic Neutral", "CN", "Chaotic neutral creatures follow their whims, holding their personal "
			+ "freedom above all else."),
    LAWFUL_EVIL("Lawful Evil", "LE", "Lawful evil creatures methodically take what they want, within the limits of a " +
			"" + "code of tradition, loyalty, or order."),
    NEUTRAL_EVIL("Neutral Evil", "NE", "Neutral evil is the alignment of those who do whatever they can get away " +
			"with, without compassion or qualms."),
    CHAOTIC_EVIL("Chaotic Evil", "CE", "Chaotic creatures act with arbitrary violence, spurred by their greed, " +
			"hatred, or bloodlust.");

    final String abbreviation;
    final String description;
    final String name;

    Alignment(String name, String abbreviation, String description)
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
