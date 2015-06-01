package musician101.mcdnd.race.trait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.DamagePath;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.race.Races;
import musician101.mcdnd.util.CustomHashMap;

public class Traits
{
	private static Map<Races, List<Trait>> traitMap = new CustomHashMap<Races, List<Trait>>()
			.add(Races.BLACK_DRAGONBORN, getDragonbornTraits(Dragonborn.BLACK)).add(Races.BLUE_DRAGONBORN, getDragonbornTraits(Dragonborn.BLUE))
			.add(Races.BRASS_DRAGONBORN, getDragonbornTraits(Dragonborn.BRASS)).add(Races.BRONZE_DRAGONBORN, getDragonbornTraits(Dragonborn.BRONZE))
			.add(Races.COPPER_DRAGONBORN, getDragonbornTraits(Dragonborn.COPPER)).add(Races.GOLD_DRAGONBORN, getDragonbornTraits(Dragonborn.GOLD))
			.add(Races.GREEN_DRAGONBORN, getDragonbornTraits(Dragonborn.GREEN)).add(Races.RED_DRAGONBORN, getDragonbornTraits(Dragonborn.RED))
			.add(Races.SILVER_DRAGONBORN, getDragonbornTraits(Dragonborn.SILVER)).add(Races.WHITE_DRAGONBORN, getDragonbornTraits(Dragonborn.WHITE))
			.add(Races.HILL_DWARF, getDwarfTraits(Dwarf.HILL)).add(Races.MOUNTAIN_DWARF, getDwarfTraits(Dwarf.MOUNTAIN))
			.add(Races.DROW_ELF, getElfTraits(Elf.DROW)).add(Races.HIGH_ELF, getElfTraits(Elf.HIGH)).add(Races.WOOD_ELF, getElfTraits(Elf.WOOD))
			.add(Races.LIGHTFOOT_HALFLING, getHalflingTraits(Halfling.LIGHTFOOT)).add(Races.STOUT_HALFLING, getHalflingTraits(Halfling.STOUT))
			.add(Races.HUMAN, new ArrayList<Trait>()).add(Races.HALF_ELF, getHalfElfTraits()).add(Races.HALF_ORC, getHalfOrcTraits())
			.add(Races.FOREST_GNOME, getGnomeTraits(Gnome.FOREST)).add(Races.ROCK_GNOME, getGnomeTraits(Gnome.ROCK))
			.add(Races.TIEFLING, getTieflingTraits());
	
	public static List<Trait> getTraits(Races race)
	{
		return traitMap.get(race);
	}
	
	private static List<Trait> getDragonbornTraits(Dragonborn ancestry)
	{
		List<Trait> traits = Arrays.asList(new Trait("Breath Weapon", "Use your action to exhale destructive energy. Regain ability after a short or long rest"));
		traits.add(new Trait("Draconic Ancestry", ancestry.getName()));
		String name = ancestry.getDamageType().getName();
		traits.add(new Trait("Damage Resistance", name));
		traits.add(new Trait("Damage Type", name));
		String shape = "5 by 30 ft. line";
		if (ancestry.getDamagePath() == DamagePath.CONE)
			shape = "15 ft. cone";
		
		traits.add(new Trait("Breath Weapon", shape + ". DC 11 " + ancestry.getAbilitySaveType().getName() + " save for 2d6 " + name.toLowerCase() + " on failed, half on success"));
		return traits;
	}
	
	private static List<Trait> getDwarfTraits(Dwarf ancestry)
	{
		List<Trait> traits = Arrays.asList(new Trait("Dwarven Resilience", "Advantage on saving throws against poison, and resistance against poison damage."),
				new Trait("Dwarven Combat Training", "Proficient with battleaxe, handaxe, throwing hammer, and warhammer"),
				new Trait("Tool Proficiency", "Gain proficiency with either Smith's Tools, Brewer's Supplies, or Mason's Tools"),
				new Trait("Stonecunning", "Add double proficiency bonus to Intelligence (History) check on any stonework"));
		
		if (ancestry == Dwarf.HILL)
			traits.add(new Trait("Dwarven Toughness", "Hit point maximum increased by one every level"));
		else if (ancestry == Dwarf.MOUNTAIN)
			traits.add(new Trait("Dwarven Armor Training", "Proficient with light and medium armor"));
		
		return traits;
	}
	
	private static List<Trait> getElfTraits(Elf ancestry)
	{
		List<Trait> traits = Arrays.asList(new Trait("Fey Ancestry", "Advantage on saving throws against being charmed, magic cannot put you to sleep"),
				new Trait("Keen Senses", "Proficiency in the Perception skill"),
				new Trait("Trance", "Do not sleep but meditate deeply, remaining semiconscious, for 4 hours a day"));
		
		if (ancestry != Elf.DROW)
			traits.add(new Trait("Elf Weapon Training", "Proficiency with longsword, shortsword, shortbow, and longbow"));
		
		if (ancestry == Elf.DROW)
		{
			traits.add(new Trait("Drow Magic", "Dancing Lights cantrip. Spell Ability (CHA) Save DC = 13"));
			traits.add(new Trait("Mask of the Wild", "Attempt to hide when lightly obscured by foilage, heavy rain, falling snow, mist, etc"));
			traits.add(new Trait("Sunlight Sensitivity", "Disadvantage on attack rolls and Wisdom (Perception) checks in sunlight"));
		}
		else if (ancestry == Elf.HIGH)
			traits.add(new Trait("Cantrip", "Choose one wizard cantrip"));
		else if (ancestry == Elf.WOOD)
		{
			traits.add(new Trait("Fleet of Foot", "Base movement increased to 35 feet"));
			traits.add(new Trait("Mask of the Wild", "Attempt to hide when lightly obscured by foilage, heavy rain, falling snow, mist, etc"));
		}
		
		return traits;
	}
	
	private static List<Trait> getHalflingTraits(Halfling ancestry)
	{
		List<Trait> traits = Arrays.asList(new Trait("Brave", "Advantage on saving throws against being frightened"),
				new Trait("Halfling Nimbleness", "Move through space of a creature that is a size larger than yours"));
		
		if (ancestry == Halfling.LIGHTFOOT)
			traits.add(new Trait("Naturally Stealthy", "Hide when obscured by a creature at least one size larger"));
		else if (ancestry == Halfling.STOUT)
			traits.add(new Trait("Stout Resistance", "Advantage on poison saving throws, resistance to poison damage"));
		
		return traits;
	}
	
	private static List<Trait> getGnomeTraits(Gnome ancestry)
	{
		List<Trait> traits = Arrays.asList(new Trait("Gnome Cunning", "Advantage on all Intelligence, Wisdom and Charisma saving throws against magic"));
		if (ancestry == Gnome.FOREST)
		{
			traits.add(new Trait("Natural Illusionist", "Know the minor illusion cantrip (INT)"));
			traits.add(new Trait("Speak with Small Beasts", "Communicate simple ideas to Small or smaller beasts"));
		}
		else if (ancestry == Gnome.ROCK)
		{
			traits.add(new Trait("Articifer's Lore", "Advantage on Intelligence checks on alchemy, magic items, and technological devices"));
			traits.add(new Trait("Tinker", "Proficiency with Tinker's Tools and can construct a Tiny clockwork device (AC 5, HP 1) in 1 hour and 10 gold pieces"));
		}
		
		return traits;
	}
	
	private static List<Trait> getHalfElfTraits()
	{
		return Arrays.asList(new Trait("Fey Ancestry", "Advantage on saving throws against being charmed, magic cannot put you to sleep"),
				new Trait("Skill Versatility", "Gain proficiency in two skills of your choice"));
	}
	
	private static List<Trait> getHalfOrcTraits()
	{
		return Arrays.asList(new Trait("Menacing", "Advantage on Charisma (Intimidation) checks."),
				new Trait("Relentless Endurance", "If reduced to 0 hit points but not killed outright, drop to 1 hit point. Long rest to reuse"),
				new Trait("Savage Attacks", "Critical hits with a melee weapon attack allows one additional roll of one of the weapon's damage dice and add to the damage of the critical hit"));
	}
	
	private static List<Trait> getTieflingTraits()
	{
		return Arrays.asList(new Trait("Hellish Resistance", "Resistance to fire damage"),
				new Trait("Infernal Legacy", "Know the thaumaturgy cantrip. Spell Ability (Cha) Save DC = Proficiency Bonus + Charisma Mod"));
	}
	
	private enum Dragonborn
	{
		BLACK("Black", DamageType.ACID),
		BLUE("Blue", DamageType.LIGHTNING),
		BRASS("Brass", DamageType.FIRE),
		BRONZE("Bronze", DamageType.LIGHTNING),
		COPPER("Copper", DamageType.ACID),
		GOLD("Gold", DamageType.FIRE),
		GREEN("Green", DamageType.POISON),
		RED("Red", DamageType.FIRE),
		SILVER("Silver", DamageType.COLD),
		WHITE("White", DamageType.COLD);
		
		AbilityScores ability;
		DamagePath path;
		DamageType type;
		String name;
		
		private Dragonborn(String name, DamageType type)
		{
			this(name, type, DamagePath.LINE);
		}
		
		private Dragonborn(String name, DamageType type, DamagePath path)
		{
			this(name, type, path, AbilityScores.DEX);
		}
		
		private Dragonborn(String name, DamageType type, DamagePath path, AbilityScores ability)
		{
			this.type = type;
			this.path = path;
			this.ability = ability;
		}
		
		public AbilityScores getAbilitySaveType()
		{
			return ability;
		}
		
		public DamagePath getDamagePath()
		{
			return path;
		}
		
		public DamageType getDamageType()
		{
			return type;
		}
		
		public String getName()
		{
			return name;
		}
	}
	
	private enum Dwarf
	{
		HILL,
		MOUNTAIN;
	}
	
	private enum Elf
	{
		DROW,
		HIGH,
		WOOD;
	}
	
	private enum Halfling
	{
		LIGHTFOOT,
		STOUT;
	}
	
	private enum Gnome
	{
		FOREST,
		ROCK;
	}
}
