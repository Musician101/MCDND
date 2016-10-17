package io.musician101.mcdnd.sponge.language;

public class Languages
{
    public static final Language COMMON = new Language("Common");
    public static final Language DRUIDIC = new Language("Druidic");
    public static final Language DWARVISH = new Language("Dwarvish");//NOSONAR
    public static final Language ELVISH = new Language("Elvish");//NOSONAR
    public static final Language GIANT = new Language("Giant", "Dwarvish");
    public static final Language GNOMISH = new Language("Gnomish", "Dwarvish");
    public static final Language GOBLIN = new Language("Goblin", "Dwarvish");
    public static final Language HALFLING = new Language("Halfling", "Common");
    public static final Language ORC = new Language("Orc", "Dwarvish");
    public static final Language ABYSSAL = new Language("Abyssal", "Infernal", true);
    public static final Language CELESTIAL = new Language("Celestial", true);
    public static final Language DRACONIC = new Language("Draconic", true);
    public static final Language DEEP_SPEECH = new Language("Deep Speech", true);
    public static final Language INFERNAL = new Language("Infernal", true);
    public static final Language PRIMORDIAL = new Language("Primordial", "Dwarvish", true);
    public static final Language SYLVAN = new Language("Sylvan", "Elvish", true);
    public static final Language UNDERCOMMON = new Language("Undercommon", "Elvish", true);

    private Languages()
    {

    }
}
