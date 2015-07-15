package musician101.mcdnd.race;

public enum Races
{
	BLACK_DRAGONBORN("Dragonborn", "Black"),
	BLUE_DRAGONBORN("Dragonborn", "Blue"),
	BRASS_DRAGONBORN("Dragonborn", "Brass"),
	BRONZE_DRAGONBORN("Dragonborn", "Bronze"),
	COPPER_DRAGONBORN("Dragonborn", "Copper"),
	GOLD_DRAGONBORN("Dragonborn", "Gold"),
	GREEN_DRAGONBORN("Dragonborn", "Green"),
	RED_DRAGONBORN("Dragonborn", "Red"),
	SILVER_DRAGONBORN("Dragonborn", "Silver"),
	WHITE_DRAGONBORN("Dragonborn", "White"),
	HILL_DWARF("Dwarf", "Hill"),
	MOUNTAIN_DWARF("Dwarf", "Mountain"),
	DROW_ELF("Elf", "Drow"),
	HIGH_ELF("Elf", "High"),
	WOOD_ELF("Elf", "Wood"),
	HUMAN("Human"),
	HALF_ELF("Half-Elf"),
	HALF_ORC("Half-Orc"),
	LIGHTFOOT_HALFLING("Halfling", "Lightfoot"),
	STOUT_HALFLING("Halfling", "Stout"),
	FOREST_GNOME("Gnome", "Forest"),
	ROCK_GNOME("Gnome", "Rock"),
	TIEFLING("Dragonborn", "Black");
	
	String race;
	String subRace;
	
	private Races(String race)
	{
		this(race, null);
	}
	
	private Races(String race, String subRace)
	{
		this.race = race;
		this.subRace = subRace;
	}
	
	public String getRace()
	{
		return race + (subRace != null ? "(" + subRace + ")" : "");
	}
}
