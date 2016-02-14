package musician101.mcdnd.language;

public class Languages
{
    public static Language COMMON = new Language("Common");
    public static Language DWARVISH = new Language("Dwarvish");
    public static Language ELVISH = new Language("Elvish");
    public static Language GIANT = new Language("Giant", "Dwarvish");
    public static Language GNOMISH = new Language("Gnomish", "Dwarvish");
    public static Language GOBLIN = new Language("Goblin", "Dwarvish");
    public static Language HALFLING = new Language("Halfling", "Common");
    public static Language ORC = new Language("Orc", "Dwarvish");
    public static Language ABYSSAL = new Language("Abyssal", "Infernal", true);
    public static Language CELESTIAL = new Language("Celestial", true);
    public static Language DRACONIC = new Language("Draconic", true);
    public static Language DEEP_SPEECH = new Language("Deep Speech", true);
    public static Language INFERNAL = new Language("Infernal", true);
    public static Language PRIMORDIAL = new Language("Primordial", "Dwarvish", true);
    public static Language SYLVAN = new Language("Sylvan", "Elvish", true);
    public static Language UNDERCOMMON = new Language("Undercommon", "Elvish", true);
}
