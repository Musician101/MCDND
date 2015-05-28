package musician101.mcdnd.race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.abilityscore.RaceAbilityScoreIncrease;
import musician101.mcdnd.combat.Dice;
import musician101.mcdnd.language.Language;
import musician101.mcdnd.trait.Trait;
import musician101.mcdnd.trait.Traits;

public class Race
{
	Age age;
	CharacterSize size = CharacterSize.MEDIUM;
	int movementSpeed = 30;
	Height height;
	List<Language> languages = new ArrayList<Language>();
	List<Trait> traits;
	Races race;
	RaceAbilityScoreIncrease scores = new RaceAbilityScoreIncrease();
	Vision vision = Vision.NORMAL;
	Weight weight;
	
	public Race(Races race)
	{
		this.race = race;
		traits = Traits.getTraits(race);
		List<Races> dragonborn = Arrays.asList(Races.BLACK_DRAGONBORN, Races.BLUE_DRAGONBORN, Races.BRASS_DRAGONBORN,
				Races.BRONZE_DRAGONBORN, Races.COPPER_DRAGONBORN, Races.GOLD_DRAGONBORN, Races.GREEN_DRAGONBORN,
				Races.RED_DRAGONBORN, Races.SILVER_DRAGONBORN, Races.WHITE_DRAGONBORN);
		
		if (race == Races.HILL_DWARF)
		{
			age = Age.DWARF;
			height = Height.HILL_DWARF;
			movementSpeed = 25;
			scores.updateScore(new AbilityScore(AbilityScores.CON, 2), new AbilityScore(AbilityScores.WIS, 1));
			vision = Vision.DARKVISION_60;
			weight = Weight.HILL_DWARF;
		}
		else if (race == Races.MOUNTAIN_DWARF)
		{
			age = Age.DWARF;
			height = Height.MOUNTAIN_DWARF;
			movementSpeed = 25;
			scores.updateScore(new AbilityScore(AbilityScores.CON, 2), new AbilityScore(AbilityScores.STR, 2));
			vision = Vision.DARKVISION_60;
			weight = Weight.MOUNTAIN_DWARF;
		}
		else if (race == Races.DROW_ELF)
		{
			age = Age.ELF;
			scores.updateScore(new AbilityScore(AbilityScores.DEX, 2), new AbilityScore(AbilityScores.CHA, 1));
			height = Height.DROW_ELF;
			vision = Vision.DARKVISION_120;
			weight = Weight.DROW_ELF;
		}
		else if (race == Races.HIGH_ELF)
		{
			age = Age.ELF;
			height = Height.HIGH_ELF;
			scores.updateScore(new AbilityScore(AbilityScores.DEX, 2), new AbilityScore(AbilityScores.INT, 1));
			vision = Vision.DARKVISION_60;
			weight = Weight.HIGH_ELF;
		}
		else if (race == Races.WOOD_ELF)
		{
			age = Age.ELF;
			height = Height.WOOD_ELF;
			movementSpeed = 35;
			scores.updateScore(new AbilityScore(AbilityScores.DEX, 2), new AbilityScore(AbilityScores.WIS, 1));
			vision = Vision.DARKVISION_60;
			weight = Weight.WOOD_ELF;
		}
		else if (race == Races.LIGHTFOOT_HALFLING)
		{
			age = Age.HALFLING;
			height = Height.HALFLING;
			movementSpeed = 25;
			scores.updateScore(new AbilityScore(AbilityScores.DEX, 2), new AbilityScore(AbilityScores.CHA, 1));
			size = CharacterSize.SMALL;
			weight = Weight.HALFLING;
		}
		else if (race == Races.STOUT_HALFLING)
		{
			age = Age.HALFLING;
			height = Height.HALFLING;
			movementSpeed = 25;
			scores.updateScore(new AbilityScore(AbilityScores.DEX, 2), new AbilityScore(AbilityScores.CON, 1));
			size = CharacterSize.SMALL;
			weight = Weight.HALFLING;
		}
		else if (race == Races.HUMAN)
		{
			age = Age.HUMAN;
			height = Height.HUMAN;
			scores.updateScore(new AbilityScore(AbilityScores.STR, 1),new AbilityScore(AbilityScores.DEX, 1),
					new AbilityScore(AbilityScores.CON, 1), new AbilityScore(AbilityScores.INT, 1),
					new AbilityScore(AbilityScores.WIS, 1), new AbilityScore(AbilityScores.CHA, 1));
			weight = Weight.HUMAN;
		}
		else if (dragonborn.contains(race))
		{
			age = Age.DRAGONBORN;
			height = Height.DRAGONBORN;
			scores.updateScore(new AbilityScore(AbilityScores.STR, 2), new AbilityScore(AbilityScores.CHA, 1));
			weight = Weight.DRAGONBORN;
		}
		else if (race == Races.FOREST_GNOME)
		{
			age = Age.GNOME;
			height = Height.GNOME;
			movementSpeed = 25;
			scores.updateScore(new AbilityScore(AbilityScores.INT, 2), new AbilityScore(AbilityScores.DEX, 1));
			size = CharacterSize.SMALL;
			vision = Vision.DARKVISION_60;
		}
		else if (race == Races.ROCK_GNOME)
		{
			age = Age.GNOME;
			height = Height.GNOME;
			movementSpeed = 25;
			scores.updateScore(new AbilityScore(AbilityScores.INT, 2), new AbilityScore(AbilityScores.CON, 1));
			size = CharacterSize.SMALL;
			vision = Vision.DARKVISION_60;
		}
		else if (race == Races.HALF_ELF)
		{
			age = Age.HALF_ELF;//TODO need a method to allow choice of input for ability scores
			height = Height.HALF_ELF;
			scores.updateScore(new AbilityScore(AbilityScores.CHA, 2));
			size = CharacterSize.MEDIUM;
			vision = Vision.DARKVISION_60;
		}
		else if (race == Races.HALF_ORC)
		{
			age = Age.HALF_ORC;
			height = Height.HALF_ORC;
			scores.updateScore(new AbilityScore(AbilityScores.STR, 2), new AbilityScore(AbilityScores.CON, 1));
			size = CharacterSize.MEDIUM;
			vision = Vision.DARKVISION_60;
		}
		else if (race == Races.TIEFLING)
		{
			age = Age.TIEFLING;
			height = Height.TIEFLING;
			scores.updateScore(new AbilityScore(AbilityScores.INT, 1), new AbilityScore(AbilityScores.CHA, 2));
			size = CharacterSize.MEDIUM;
			vision = Vision.DARKVISION_60;
		}
	}
	
	public CharacterSize getSize()
	{
		return size;
	}
	
	public int getMovmentSpeed()
	{
		return movementSpeed;
	}
	
	public List<Language> getLanguages()
	{
		return languages;
	}
	
	public Races getRace()
	{
		return race;
	}
	
	public Vision getVision()
	{
		return vision;
	}
	
	public RaceAbilityScoreIncrease getAbilityScoreIncrease()
	{
		return scores;
	}
	
	public static enum Age
	{
		DRAGONBORN(15, 80, "Young dragonborns grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80."),
		DWARF(50, 350, "Dwarves mature at the same rate as humans, but they're considered young until they reach the age of 50. On average, they live about 350 years."),
		ELF(100, 750, "Although elves reach physical maturity at about the same age as humans, the elven understanding of adulthood goes beyond physical growth to encompass worldly experience. An elf typically claims adulthood and an adult name around the age of 100 and can live to be 750 years old."),
		GNOME(40, 500, "Gnomes mature at the same rate humans do, and most are expected to settle down into an adult life by around age 40. They can live 350 to almost 500 years."),
		HALF_ELF(20, 180, "Half-elves mature at the same rate humans do and reach adulthood around the age of 20. They live much longer than humans, however, often exceeding 180 years."),
		HALF_ORC(14, 75, "Half-orcs mature a little faster than humans, reaching adulthood around age 14. They age noticeably faster and rarely live longer than 75 years."),
		HALFLING(20, 250, "A halfling reaches adulthood at the age of 20 and generally lives into the middle of his or her second century."),
		HUMAN(18, 100, "Humans reach adulthood in their late teens and live less than a century."),
		TIEFLING(18, 100, "Tieflings mature at the same rate as humans but live a few years longer.");
		
		int min;
		int avgMax;
		String description;
		
		private Age(int min, int avgMax, String description)
		{
			this.min = min;
			this.avgMax = avgMax;
			this.description = description;
		}
		
		public int getMinimumAge()
		{
			return min;
		}
		
		public int getAverageMaximumAge()
		{
			return avgMax;
		}
		
		public String getDescription()
		{
			return description;
		}
	}
	
	public static enum CharacterSize
	{
		TINY("Tiny"),
		SMALL("Small"),
		MEDIUM("Medium"),
		LARGE("Large"),
		HUGE("Huge"),
		GARGANTUAN("Gargantuan");
		
		String name;
		
		private CharacterSize(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return name;
		}
	}
	
	public static enum Height
	{
		HILL_DWARF(3 * 12 + 8, Dice.D4),
		MOUNTAIN_DWARF(4 * 12, Dice.D4),
		DROW_ELF(4 * 12 + 5, Dice.D6),
		HIGH_ELF(4 * 12 + 6, Dice.D10),
		WOOD_ELF(4 * 12 + 6, Dice.D10),
		HUMAN(4 * 12 + 8, Dice.D10),
		DRAGONBORN(5 * 12 + 6, Dice.D8),
		HALFLING(2 * 12 + 7, Dice.D4),
		HALF_ELF(4 * 12 + 9, Dice.D8),
		HALF_ORC(4 * 12 + 10, Dice.D10),
		TIEFLING(4 * 12 + 9, Dice.D8),
		GNOME(2 * 12 + 11, Dice.D4);
		
		Dice dice;
		int base;
		
		private Height(int base, Dice dice)
		{
			this.base = base;
			this.dice = dice;
		}
		
		public int getMinHeight()
		{
			return base + 2;
		}
		
		public int getMaxInches()
		{
			return base;
		}
		
		public int roll()
		{
			return base + dice.rollDice(2);
		}
	}
	
	public static enum Vision
	{
		NORMAL("Normal"),
		DARKVISION_60("Darkvision 60ft", 60),
		DARKVISION_120("Darkvision 120ft", 120);
		
		int distance;
		String name;
		
		private Vision(String name)
		{
			this(name, 0);
		}
		
		private Vision(String name, int distance)
		{
			this.distance = distance;
		}
		
		public int getDistance()
		{
			return distance;
		}
	}
	
	public static enum Weight
	{
		HILL_DWARF(115, Dice.D4, 2, Dice.D6),
		MOUNTAIN_DWARF(130, Dice.D4, 2, Dice.D6),
		HUMAN(110, Dice.D10, 2, Dice.D4),
		HIGH_ELF(90, Dice.D10, 1, Dice.D4),
		WOOD_ELF(100, Dice.D10, 1, Dice.D4),
		DROW_ELF(75, Dice.D6, 1, Dice.D6),
		HALFLING(35, Dice.D4, 1, null),
		DRAGONBORN(175, Dice.D8, 2, Dice.D6),
		GNOME(110, Dice.D8, 1, null),
		HALF_ELF(110, Dice.D8, 2, Dice.D4),
		HALF_ORC(140, Dice.D10, 2, Dice.D6),
		TIEFLING(110, Dice.D8, 2, Dice.D4);
		
		Dice heightMod;
		Dice weightMod;
		int base;
		int diceAmount;
		
		private Weight(int base, Dice heightMod, int diceAmount, Dice weightMod)
		{
			this.base = base;
			this.heightMod = heightMod;
			this.diceAmount = diceAmount;
			this.weightMod = weightMod;
		}
		
		public int getMin()
		{
			return base + 2 * diceAmount;
		}
		
		public int getMax()
		{
			int weightMod = 1;
			if (this.weightMod != null)
				weightMod = (2 * this.weightMod.getSides());
			
			return base + (2 * heightMod.getSides()) * weightMod;
		}
		
		public int roll(int heightMod)
		{
			int weightMod = 1;
			if (this.weightMod != null)
				weightMod = this.weightMod.rollDice(diceAmount);
			
			return base + heightMod * weightMod;
		}
	}
}
