package musician101.mcdnd.race.trait;

import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.abilityscore.RaceAbilityScoreIncrease;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.equipment.Weapons;
import musician101.mcdnd.equipment.Armor.ArmorTypes;
import musician101.mcdnd.equipment.tool.Tool;
import musician101.mcdnd.equipment.tool.Tool.ArtisanTool;
import musician101.mcdnd.language.Language;
import musician101.mcdnd.race.Race.CharacterSize;
import musician101.mcdnd.skill.Skills;
import musician101.mcdnd.util.CustomHashMap;

public class Traits
{
	// Dragonborn Traits
	public static final AbilityScoreIncreaseTrait DRAGONBORN_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.STR, 2), new AbilityScore(AbilityScores.CHA, 1)), "Your Strength score increases by 2, and your Charisma score increases by 1.");
	public static final AgeTrait DRAGONBORN_AGE = new AgeTrait(15, 80, "Young dragonborns grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.");
	public static final AlignmentTrait DRAGONBORN_ALIGNMENT = new AlignmentTrait("Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil (represented by Bahamut and Tiamat, respectively). Most dragonborn are good, but those who side with Tiamat can be terrible villains.");
	public static final MovementSpeedTrait DRAGONBORN_SPEED = new MovementSpeedTrait();
	public static final SizeTrait DRAGONBORN_SIZE = new SizeTrait(5 * 12 + 6, new Dice(8, 2), 110, new Dice(4, 2), CharacterSize.MEDIUM, "Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.");
	
	// Hill Dwarf Traits
	public static final AbilityScoreIncreaseTrait DWARF_HILL_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.WIS, 1)), "Your Wisdom score increases by 1.");
	public static final SizeTrait DWARF_HILL_SIZE = new SizeTrait(3 * 12 + 8, new Dice(4, 2), 115, new Dice(6, 2), CharacterSize.MEDIUM, "Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium.");
	public static final Trait DWARVEN_TOUGHNESS = new Trait("Dwarven Toughness", "Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.");
	
	// Mountain Dwarf Traits
	public static final AbilityScoreIncreaseTrait DWARF_MOUNTAIN_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.STR, 2)), "Your Strength score increases by 2.");
	public static final ListTrait<ArmorTypes> DWARVEN_ARMOR_TRAINING = new ListTrait<ArmorTypes>("Dwarven Armor Training", Arrays.asList(ArmorTypes.LIGHT, ArmorTypes.MEDIUM), "You have proficiency with light and medium armor.");
	public static final SizeTrait DWARF_MOUNTAIN_SIZE = new SizeTrait(4 * 12, new Dice(4, 2), 130, new Dice(6, 2), CharacterSize.MEDIUM, "Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium.");
	
	// Dwarf Traits
	public static final AbilityScoreIncreaseTrait DWARF_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.CON, 2)), "Your Constitution score increases by 2");
	public static final AgeTrait DWARF_AGE = new AgeTrait(50, 350, "Dwarves mature at the same rate as humans, but they're considered young until they reach the age of 50. On average, they live about 350 years.");
	public static final AlignmentTrait DWARF_ALIGNMENT = new AlignmentTrait("Most dwarves are lawful, believing firmly in the benefits of a well-ordered society. They tend toward good as well, with a strong sense of fair play and a belief that everyone deserves to share in the benefits of a just order.");
	public static final DarkvisionTrait DWARF_DARKVISION = new DarkvisionTrait("Accustomed to life underground, you have superior vision in dark and dim conditions.");
	public static final LanguagesTrait DWARF_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.DWARVISH), "You can speak, read and write Common and Dwarvish. Dwarvish is full of hard consonants and guttural sounds and those characteristics spill over into whatever other language a dwarf might speak.");
	public static final ListTrait<ArtisanTool> DWARF_TOOL_PROFICIENCY = new ListTrait<ArtisanTool>("Tool Proficiency", Arrays.asList(Tool.BREWERS_SUPPLIES, Tool.MASONS_TOOLS, Tool.SMITHS_TOOLS), "You gain proficiency with the artisan's tools of your choice: smith's tools, brewer's supplies, or mason's tools.");
	public static final ListTrait<Weapons> DWARVEN_COMBAT_TRAINING = new ListTrait<Weapons>("Dwarven Combat Training", Arrays.asList(Weapons.BATTLEAXE, Weapons.HANDAXE, Weapons.LIGHT_HAMMER, Weapons.WARHAMMER), "You have proficiency with the battleaxe, handaxe, throwing hammer, and warhammer.");
	public static final MovementSpeedTrait DWARF_SPEED = new MovementSpeedTrait(25);
	public static final SingleValueTrait<DamageType> DWARVEN_RESLILIENCE = new SingleValueTrait<DamageType>("DwarvenResilienceTrait", DamageType.POISON, "You have advantage on saving throws against poison, and you have resistance against poison damage.");
	public static final SingleValueTrait<Skills> STONECUNNING = new SingleValueTrait<Skills>("Stonecunning", Skills.HISTORY, "Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient int the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.");
	public static final SubraceTrait DWARF_SUBRACE = new SubraceTrait(new CustomHashMap<String, List<Trait>>().add("hill", Arrays.asList(DWARF_HILL_ASI, DWARF_HILL_SIZE, DWARVEN_TOUGHNESS))
			.add("mountain", Arrays.asList(DWARF_MOUNTAIN_ASI, DWARVEN_ARMOR_TRAINING, DWARF_MOUNTAIN_SIZE)), "Two main subraces of dwarves populate the worlds of D&D: hill dwarves and mountain dwarves. Choose one of these subraces.");
	
	// Dark/Drow Elf Traits
	public static final AbilityScoreIncreaseTrait ELF_DARK_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.CHA, 1)), "Your Charisma score increases by 1.");
	public static final DarkvisionTrait ELF_DARK_DARKVISION = new DarkvisionTrait("Superior Darkvision", 120, "Your darkvision has a radius of 120 feet.");
	public static final SizeTrait ELF_DARK_SIZE = new SizeTrait(4 * 12 + 5, new Dice(6, 2), 75, new Dice(4, 2), CharacterSize.MEDIUM, "Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.");
	public static final SingleValueTrait<Skills> SUNLIGHT_SENSITIVITY = new SingleValueTrait<Skills>("Sunlight Sensitivity", Skills.PERCEPTION, "You have disadvantage on attack rolls and on Wisdom (Perception) checks that rely on sight when you, the target of your attack, or whatever you are trying to perceive is in direct sunlight.");
	
	
	// High Elf Traits
	public static final AbilityScoreIncreaseTrait ELF_HIGH_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.INT, 1)), "Your Intelligence score increases by 1.");
	public static final SizeTrait ELF_HIGH_SIZE = new SizeTrait(4 * 12 + 6, new Dice(10, 2), 90, new Dice(4, 2), CharacterSize.MEDIUM, "Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.");
	public static final SingleValueTrait<AbilityScores> CANTRIP = new SingleValueTrait<AbilityScores>("Cantrip", AbilityScores.INT, "You know one cantrip of your choice from the wizard spell list. Intelligence is your spellcasting ability for it.");
	
	// Wood Elf Traits
	public static final AbilityScoreIncreaseTrait ELF_WOOD_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.WIS, 1)), "Your Wisdom score increases by 1.");
	public static final SizeTrait ELF_WOOD_SIZE = new SizeTrait(4 * 12 + 6, new Dice(10, 2), 100, new Dice(6, 2), CharacterSize.MEDIUM, "Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.");
	public static final SingleValueTrait<Integer> FLEET_OF_FOOT = new SingleValueTrait<Integer>("Fleet of Foot", 35, "Your base walking speed increases to 35 feet.");
	public static final Trait MASK_OF_THE_WILD = new Trait("Mask of the Wild", "You can attempt to hide even when you are only lightly obscured by foliage, heavy rain, falling snow, mist, and other natural phenomena.");
	
	// Shared traits between Dark and High Elves
	public static final MovementSpeedTrait ELF_SPEED = new MovementSpeedTrait();
	
	// Shared traits between High and Wood Elves
	public static final DarkvisionTrait ELF_WOOD_DARKVISION = new DarkvisionTrait("Accustomed to twilit forests and the night sky, you have superior vision in dark and dim conditions.");
	public static final ListTrait<Weapons> ELF_WEAPON_TRAINING = new ListTrait<Weapons>("Elf Weapon Training", Arrays.asList(Weapons.LONGSWORD, Weapons.SHORTSWORD, Weapons.SHORTBOW, Weapons.LONGBOW), "You have proficiency with the longsword, shortsword, shortbow, and longbow.");
	
	// Elf Traits
	public static final AbilityScoreIncreaseTrait ELF_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.DEX, 2)), "Your Strength score increases by 2.");
	public static final AgeTrait ELF_AGE = new AgeTrait(100, 750, "Although elves reach physical maturity at about the same age as humans, the elven understanding of adulthood goes beyond physical growth to encompass worldly experience. An elf typically claims adulthood and an adult name around the age of 100 and can live to be 750 years old.");
	public static final AlignmentTrait ELF_ALIGNMENT = new AlignmentTrait("Elves love freedom, variety, and self-expression, so they lean strongly toward the gentler aspects of chaos. They value and protect others' freedom as well as their own, and they are more often good than not. The drow are an exception; their exile into the Underdark has made them vicious and dangerous. Drow are more often evil than not.");
	public static final SingleValueTrait<Skills> KEEN_SENSES = new SingleValueTrait<Skills>("Keen Senses", Skills.PERCEPTION, "You have proficiency in the Perception skill.");
	public static final Trait FEY_ANCESTRY = new Trait("Fey Ancestry", "You have advantage on saving throws against being charmed, and magic can't put you to sleep.");
	public static final Trait TRANCE = new Trait("Trance", "Elves don't need to sleep. Instead, they meditate deeply, remaining semiconscious, for 4 hours a day. (The Common word for meditation is \"trance.\") While meditating, you can dream after a fashion; such dreams are actually mental exercieses taht have become reflexive through years of practice. After resting in this way, you gain the same benefit that a human does from 8 hours of sleep.");
	public static final LanguagesTrait ELF_LANGUAGE = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.ELVISH), "You can speak, read, and write Common and Elvish. Elvish is fluid, with subtle intonations and intricate grammar. Elven literature is rich and varied, and their songs and poems are famous among other races. Many bards learn their language so they can add Elvish ballads to their repertoires.");
	//TODO need to finish spells
	public static final SubraceTrait ELF_SUBRACE = new SubraceTrait(new CustomHashMap<String, List<Trait>>().add("", value), "Ancient divides among the elven people resulted in three main subraces: high elves, wood elves, and dark elves, who are commonly called drow. Choose one of these subraces. In some worlds, these subraces are divided still further (such as the sun elves and moon elves of the Forgotten Realms), so if you wish you can choose a narrower subrace.");
	
	// Forest Gnome Traits
	public static final AbilityScoreIncreaseTrait GNOME_FOREST_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.DEX, 1)), "Your Dexterity score increases by 1.");
	
	// Rock Gnome Traits
	public static final AbilityScoreIncreaseTrait GNOME_ROCK_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.CON, 1)), "Your Constitution score increases by 1.");
	
	// Gnome Traits
	public static final AbilityScoreIncreaseTrait GNOME_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.INT, 2)), "Your Intelligence score increases by 2.");
	public static final AgeTrait GNOME_AGE = new AgeTrait(40, 500, "Gnomes mature at the same rate humans do, and most are expected to settle down into an adult life by around age 40. They can live 350 to almost 500 years.");
	public static final AlignmentTrait GNOME_ALIGNMENT = new AlignmentTrait("Gnomes are most often good. Those who tend toward law are sages, engineers, researches, scholars, investigators, or inventors. Those who tend toward chaos are minstrels, tricksters, wanderers, or fanciful jewelers. Gnomes are good-hearted, and even the tricksters among them are more playful than vicious.");
	public static final DarkvisionTrait GNOME_DARKVISION = new DarkvisionTrait("Accustomed to life underground, you have superior vision in dark and dim conditions.");
	public static final MovementSpeedTrait GNOME_SPEED = new MovementSpeedTrait(25);
	public static final SizeTrait GNOME_SIZE = new SizeTrait(2 * 12 + 11, new Dice(4, 2), 35, new Dice(1), CharacterSize.SMALL, "Gnomes are between 3 and 4 feet tall and average about 40 pounds. Your size is Small.");
	
	// Half-Elf Traits
	public static final AbilityScoreIncreaseTrait HALF_ELF_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.CHA, 2)), "Your Charisma score increases by 2, and two other ability scores of your choice increases by 1.");
	public static final AgeTrait HALF_ELF_AGE = new AgeTrait(20, 180, "Half-elves mature at the same rate humans do and reach adulthood around the age of 20. They live much longer than humans, however, often exceeding 180 years.");
	public static final AlignmentTrait HALF_ELF_ALIGNMENT = new AlignmentTrait("Half-elves share the chaotic bent of their elven heritage. They value both personal freedom and creative expression, demonstrating neither love of leaders nor desire for followers. They chafe at rules, resent others' demands, and sometimes prove unreliable or at least unpredictable.");
	public static final MovementSpeedTrait HALF_ELF_SPEED = new MovementSpeedTrait();
	public static final SizeTrait HALF_ELF_SIZE = new SizeTrait(4 * 12 + 9, new Dice(8, 2), 110, new Dice(4, 2), CharacterSize.MEDIUM, "Half-evles are about the same size as humans, ranging from 5 to 6 feet tall. Your size is Medium.");
	
	// Half-Orc Traits
	public static final AbilityScoreIncreaseTrait HALF_ORC_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.STR, 2), new AbilityScore(AbilityScores.CON, 1)), "Your Strength score increases by 2, and your Constitution score increases by 1.");
	public static final AgeTrait HALF_ORC_AGE = new AgeTrait(14, 75, "Half-orcs mature a little faster than humans, reaching adulthood around age 14. They age noticeably faster and rarely live longer than 75 years.");
	public static final AlignmentTrait HALF_ORC_ALIGNMENT = new AlignmentTrait("Half-orcs inherit a tendency toward chaos from their orc parents and are not strongly inclined toward good. Half-orcs raised among orcs and willing to live out their lives among them are usually evil.");
	public static final DarkvisionTrait HALF_ORC_DARKVISION = new DarkvisionTrait("Thanks to your orc blood, you have superior vision in dark and dim conditions.");
	public static final MovementSpeedTrait HALF_ORC_SPEED = new MovementSpeedTrait();
	public static final SizeTrait HALF_ORC_SIZE = new SizeTrait(4 * 12 + 10, new Dice(10, 2), 140, new Dice(6, 2), CharacterSize.MEDIUM, "Half-orcs are somewhat larger and bulkier than humans, and they range from 5 to well over 6 feet tall. Your size is Medium.");
	
	// Halfing Traits
	public static final AbilityScoreIncreaseTrait HALFLING_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.DEX, 1)), "Your Dexterity score increases by 2.");
	public static final AgeTrait HALFLING_AGE = new AgeTrait(20, 250, "A halfling reaches adulthood at the age of 20 and generally lives into the middle of his or her second century.");
	public static final AlignmentTrait HALFLING_ALIGNMENT = new AlignmentTrait("Most halflings are lawful good. As a rule, they are good-hearted and kind, hate to see others in pain, and have no tolerance for oppression. They are also very orderly and traditional, leaning heavily on the support of their community and the comfort of the their old ways.");
	public static final DarkvisionTrait HALF_ELF_DARKVISION = new DarkvisionTrait("Thanks to your elf blood, you have superior vision in dark and dim conditions.");
	public static final MovementSpeedTrait HALFLING_SPEED = new MovementSpeedTrait(25);
	public static final SizeTrait HALFLING_SIZE = new SizeTrait(2 * 12 + 7, new Dice(4, 2), 35, new Dice(1), CharacterSize.SMALL, "Halflings average about 3 feet tall and weight about 40 pounds. Your size is Small.");
	
	// Lightfoot Halfling Traits
	public static final AbilityScoreIncreaseTrait HALFLING_LIGHTFOOT_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.CHA, 1)), "Your Charisma score increases by 1.");
	
	// Stout Halfling Traits
	public static final AbilityScoreIncreaseTrait HALFLING_STOUT_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.CON, 1)), "Your Constitution score increases by 1.");
	
	// Human Traits
	public static final AbilityScoreIncreaseTrait HUMAN_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(), "Your ability scores each increases by 1.");
	public static final AgeTrait HUMAN_AGE = new AgeTrait(18, 100, "Humans reach adulthood in their late teens and live less than a century.");
	public static final AlignmentTrait HUMAN_ALIGNMENT = new AlignmentTrait("Humans tend toward no particular alignment. The best and the worst are found among them.");
	public static final MovementSpeedTrait HUMAN_SPEED = new MovementSpeedTrait();
	public static final SizeTrait HUMAN_SIZE = new SizeTrait(4 * 12 + 8, new Dice(10, 2), 110, new Dice(4, 2), CharacterSize.MEDIUM, "Humans vary widely in height and build, from barely 5 feet to well over 6 feet tall. Regardless of your position in that range, your size is Medium.");
	
	// Tiefling Traits
	public static final AbilityScoreIncreaseTrait TIEFLING_ASI = new AbilityScoreIncreaseTrait(new RaceAbilityScoreIncrease(new AbilityScore(AbilityScores.INT, 1), new AbilityScore(AbilityScores.CHA, 2)), "Your Intelligence score increases by 1, and your Charisma score increases by 2.");
	public static final AgeTrait TIEFLING_AGE = new AgeTrait(18, 100, "Tieflings mature at the same rate as humans but live a few years longer.");
	public static final AlignmentTrait TIEFLING_ALIGNMENT = new AlignmentTrait("Tieflings might not have an innate tendency toward evil, but many of them end up there. Evil or not an independent nature inclines many tieflings toward a chaotic alignment.");
	public static final DarkvisionTrait TIEFLING_DARKVISION = new DarkvisionTrait("Thanks to your infernal heritage, you have superior vision in dark and dim conditions.");
	public static final MovementSpeedTrait TIEFLING_SPEED = new MovementSpeedTrait();
	public static final SizeTrait TIEFLING_SIZE = new SizeTrait(4 * 12 + 9, new Dice(8, 2), 110, new Dice(4, 2), CharacterSize.MEDIUM, "Tieflings are about the same size and build as humans. Your size is Medium.");
}
