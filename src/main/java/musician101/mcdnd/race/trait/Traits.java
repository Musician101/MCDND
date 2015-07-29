package musician101.mcdnd.race.trait;

import java.util.Arrays;
import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.equipment.Armor.ArmorTypes;
import musician101.mcdnd.equipment.tool.Tool;
import musician101.mcdnd.equipment.tool.Tools;
import musician101.mcdnd.equipment.weapon.Weapon;
import musician101.mcdnd.equipment.weapon.Weapons;
import musician101.mcdnd.language.Language;
import musician101.mcdnd.magic.Spell;
import musician101.mcdnd.magic.Spells;
import musician101.mcdnd.race.Race.CharacterSize;
import musician101.mcdnd.race.trait.ListTrait.AbilityScoreIncreaseTrait;
import musician101.mcdnd.race.trait.ListTrait.LanguagesTrait;
import musician101.mcdnd.race.trait.MappedTrait.SpellcastingTrait;
import musician101.mcdnd.race.trait.MappedTrait.SubraceTrait;
import musician101.mcdnd.race.trait.SingleValueTrait.DarkvisionTrait;
import musician101.mcdnd.race.trait.SingleValueTrait.MovementSpeedTrait;
import musician101.mcdnd.race.trait.Trait.AlignmentTrait;
import musician101.mcdnd.skill.Skills;
import musician101.mcdnd.util.CustomHashMap;

public class Traits
{
	// Dragonborn Traits
	public static final Trait DRAGONBORN_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.STR, 2), new AbilityScore(AbilityScores.CHA, 1)), "Your Strength score increases by 2, and your Charisma score increases by 1.");
	public static final Trait DRAGONBORN_AGE = new Trait("Age", "Young dragonborns grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.");
	public static final Trait DRAGONBORN_ALIGNMENT = new AlignmentTrait("Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil (represented by Bahamut and Tiamat, respectively). Most dragonborn are good, but those who side with Tiamat can be terrible villains.");
	public static final Trait DRAGONBORN_SPEED = new MovementSpeedTrait();
	public static final Trait DRAGONBORN_SIZE = new SizeTrait(5 * 12 + 6, new Dice(8, 2), 110, new Dice(4, 2), CharacterSize.MEDIUM, "Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.");
	public static final Trait DRACONIC_ANCENSTRY = new Trait("Draconic Ancestry", "You hae draconic ancestry. Choose one type of dragon from the Draconic Ancestry table. Your breath weapon and the damage resistance are determined by the dragon type, as shown in the table.");
	public static final Trait BREATH_WEAPON = new Trait("Breath Weapon", "You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation.\n" + 
			"When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + your Constituion modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at 6th level, 4d6 at 11th level, and 5d6 at 16th level.\n" +
			"After you use your breathe weapon, you can't use it again until you complete a short or long rest.");
	public static final Trait DRAGONBORN_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.DRACONIC), "You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.");
	public static final List<Trait> DRAGONBORN_TRAITS = Arrays.asList(DRAGONBORN_ASI, DRAGONBORN_AGE, DRAGONBORN_ALIGNMENT, DRAGONBORN_SPEED, DRAGONBORN_SIZE, DRACONIC_ANCENSTRY, BREATH_WEAPON, DRAGONBORN_LANGUAGES);
	
	// Hill Dwarf Traits
	public static final Trait DWARF_HILL_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.WIS, 1)), "Your Wisdom score increases by 1.");
	public static final Trait DWARF_HILL_SIZE = new SizeTrait(3 * 12 + 8, new Dice(4, 2), 115, new Dice(6, 2), CharacterSize.MEDIUM, "Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium.");
	public static final Trait DWARVEN_TOUGHNESS = new Trait("Dwarven Toughness", "Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.");
	public static final List<Trait> DWARVEN_HILL_TRAITS = Arrays.asList(DWARF_HILL_ASI, DWARF_HILL_SIZE, DWARVEN_TOUGHNESS);
	
	// Mountain Dwarf Traits
	public static final Trait DWARF_MOUNTAIN_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.STR, 2)), "Your Strength score increases by 2.");
	public static final Trait DWARVEN_ARMOR_TRAINING = new ListTrait<ArmorTypes>("Dwarven Armor Training", Arrays.asList(ArmorTypes.LIGHT, ArmorTypes.MEDIUM), "You have proficiency with light and medium armor.");
	public static final Trait DWARF_MOUNTAIN_SIZE = new SizeTrait(4 * 12, new Dice(4, 2), 130, new Dice(6, 2), CharacterSize.MEDIUM, "Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium.");
	public static final List<Trait> DWARF_MOUNTAIN_TRAITS = Arrays.asList(DWARF_MOUNTAIN_ASI, DWARVEN_ARMOR_TRAINING, DWARF_MOUNTAIN_SIZE);
	
	// Dwarf Traits
	public static final Trait DWARF_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.CON, 2)), "Your Constitution score increases by 2");
	public static final Trait DWARF_AGE = new Trait("Age", "Dwarves mature at the same rate as humans, but they're considered young until they reach the age of 50. On average, they live about 350 years.");
	public static final Trait DWARF_ALIGNMENT = new AlignmentTrait("Most dwarves are lawful, believing firmly in the benefits of a well-ordered society. They tend toward good as well, with a strong sense of fair play and a belief that everyone deserves to share in the benefits of a just order.");
	public static final Trait DWARF_DARKVISION = new DarkvisionTrait("Accustomed to life underground, you have superior vision in dark and dim conditions.");
	public static final Trait DWARF_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.DWARVISH), "You can speak, read and write Common and Dwarvish. Dwarvish is full of hard consonants and guttural sounds and those characteristics spill over into whatever other language a dwarf might speak.");
	public static final Trait DWARF_TOOL_PROFICIENCY = new ListTrait<Tool>("Tool Proficiency", Arrays.asList(Tools.BREWERS_SUPPLIES, Tools.MASONS_TOOLS, Tools.SMITHS_TOOLS), "You gain proficiency with the artisan's tools of your choice: smith's tools, brewer's supplies, or mason's tools.");
	public static final Trait DWARVEN_COMBAT_TRAINING = new ListTrait<Weapon>("Dwarven Combat Training", Arrays.asList(Weapons.BATTLEAXE, Weapons.HANDAXE, Weapons.LIGHT_HAMMER, Weapons.WARHAMMER), "You have proficiency with the battleaxe, handaxe, throwing hammer, and warhammer.");
	public static final Trait DWARF_SPEED = new MovementSpeedTrait(25);
	public static final Trait DWARVEN_RESILIENCE = new SingleValueTrait<DamageType>("DwarvenResilienceTrait", DamageType.POISON, "You have advantage on saving throws against poison, and you have resistance against poison damage.");
	public static final Trait STONECUNNING = new SingleValueTrait<Skills>("Stonecunning", Skills.HISTORY, "Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient int the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.");
	public static final Trait DWARF_SUBRACE = new SubraceTrait(new CustomHashMap<String, List<? extends Trait>>().add("hill", DWARVEN_HILL_TRAITS).add("mountain", DWARF_MOUNTAIN_TRAITS), "Two main subraces of dwarves populate the worlds of D&D: hill dwarves and mountain dwarves. Choose one of these subraces.");
	public static final List<Trait> DWARF_TRAITS = Arrays.asList(DWARF_ASI, DWARF_AGE, DWARF_ALIGNMENT, DWARF_DARKVISION, DWARF_LANGUAGES, DWARF_TOOL_PROFICIENCY, DWARVEN_COMBAT_TRAINING, DWARF_SPEED, DWARVEN_RESILIENCE, STONECUNNING, DWARF_SUBRACE);
	
	// Shared traits between Dark and High Elves
	public static final Trait ELF_SPEED = new MovementSpeedTrait();
		
	// Shared traits between High and Wood Elves
	public static final Trait ELF_DARKVISION = new DarkvisionTrait("Accustomed to twilit forests and the night sky, you have superior vision in dark and dim conditions.");
	public static final Trait ELF_WEAPON_TRAINING = new ListTrait<Weapon>("Elf Weapon Training", Arrays.asList(Weapons.LONGSWORD, Weapons.SHORTSWORD, Weapons.SHORTBOW, Weapons.LONGBOW), "You have proficiency with the longsword, shortsword, shortbow, and longbow.");
	
	// Dark/Drow Elf Traits
	public static final Trait ELF_DARK_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.CHA, 1)), "Your Charisma score increases by 1.");
	public static final Trait ELF_DARK_DARKVISION = new DarkvisionTrait("Superior Darkvision", 120, "Your darkvision has a radius of 120 feet.");
	public static final Trait ELF_DARK_SIZE = new SizeTrait(4 * 12 + 5, new Dice(6, 2), 75, new Dice(4, 2), CharacterSize.MEDIUM, "Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.");
	public static final Trait SUNLIGHT_SENSITIVITY = new SingleValueTrait<Skills>("Sunlight Sensitivity", Skills.PERCEPTION, "You have disadvantage on attack rolls and on Wisdom (Perception) checks that rely on sight when you, the target of your attack, or whatever you are trying to perceive is in direct sunlight.");
	public static final Trait DROW_MAGIC = new SpellcastingTrait("Drow Magic", new CustomHashMap<Integer, Spell>().add(1, Spells.DANCING_LIGHTS).add(3, Spells.FAERIE_FIRE).add(5, Spells.DARKNESS), AbilityScores.CHA, 
			"You know the dancing lights cantrip. When you reach 3rd level, you can cast the faerie fire spell once per day. When you reach 5th level, you can also cast the darkness spell once per day. Charisma is your spellcasting ability for these spells.");
	public static final Trait DROW_WEAPON_TRAINING = new ListTrait<Weapon>("Drow Weapon Training", Arrays.asList(Weapons.RAPIER, Weapons.SHORTSWORD, Weapons.HAND_CROSSBOW), "You have proficiency with rapiers, shortswords, and hand crossbows.");
	public static final List<Trait> ELF_DARK_TRAITS = Arrays.asList(ELF_DARK_ASI, ELF_DARK_DARKVISION, ELF_DARK_SIZE, SUNLIGHT_SENSITIVITY, DROW_MAGIC, DROW_WEAPON_TRAINING, ELF_SPEED);
	
	// High Elf Traits
	public static final Trait ELF_HIGH_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.INT, 1)), "Your Intelligence score increases by 1.");
	public static final Trait ELF_HIGH_SIZE = new SizeTrait(4 * 12 + 6, new Dice(10, 2), 90, new Dice(4, 2), CharacterSize.MEDIUM, "Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.");
	public static final Trait CANTRIP = new SingleValueTrait<AbilityScores>("Cantrip", AbilityScores.INT, "You know one cantrip of your choice from the wizard spell list. Intelligence is your spellcasting ability for it.");
	public static final Trait EXTRA_LANGUAGE = new Trait("Extra Language", "You can speak, read, and write one extra language of your choice.");
	public static final List<Trait> ELF_HIGH_TRAITS = Arrays.asList(ELF_HIGH_ASI, ELF_HIGH_SIZE, CANTRIP, EXTRA_LANGUAGE, ELF_SPEED, ELF_DARKVISION, ELF_WEAPON_TRAINING);
	
	// Wood Elf Traits
	public static final Trait ELF_WOOD_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.WIS, 1)), "Your Wisdom score increases by 1.");
	public static final Trait ELF_WOOD_SIZE = new SizeTrait(4 * 12 + 6, new Dice(10, 2), 100, new Dice(6, 2), CharacterSize.MEDIUM, "Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.");
	public static final Trait FLEET_OF_FOOT = new SingleValueTrait<Integer>("Fleet of Foot", 35, "Your base walking speed increases to 35 feet.");
	public static final Trait MASK_OF_THE_WILD = new Trait("Mask of the Wild", "You can attempt to hide even when you are only lightly obscured by foliage, heavy rain, falling snow, mist, and other natural phenomena.");
	public static final List<Trait> ELF_WOOD_TRAITS = Arrays.asList(ELF_WOOD_ASI, ELF_WOOD_SIZE, FLEET_OF_FOOT, MASK_OF_THE_WILD, ELF_DARKVISION, ELF_WEAPON_TRAINING);
	
	// Elf Traits
	public static final Trait ELF_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.DEX, 2)), "Your Strength score increases by 2.");
	public static final Trait ELF_AGE = new Trait("Age", "Although elves reach physical maturity at about the same age as humans, the elven understanding of adulthood goes beyond physical growth to encompass worldly experience. An elf typically claims adulthood and an adult name around the age of 100 and can live to be 750 years old.");
	public static final Trait ELF_ALIGNMENT = new AlignmentTrait("Elves love freedom, variety, and self-expression, so they lean strongly toward the gentler aspects of chaos. They value and protect others' freedom as well as their own, and they are more often good than not. The drow are an exception; their exile into the Underdark has made them vicious and dangerous. Drow are more often evil than not.");
	public static final Trait KEEN_SENSES = new SingleValueTrait<Skills>("Keen Senses", Skills.PERCEPTION, "You have proficiency in the Perception skill.");
	public static final Trait FEY_ANCESTRY = new Trait("Fey Ancestry", "You have advantage on saving throws against being charmed, and magic can't put you to sleep.");
	public static final Trait TRANCE = new Trait("Trance", "Elves don't need to sleep. Instead, they meditate deeply, remaining semiconscious, for 4 hours a day. (The Common word for meditation is \"trance.\") While meditating, you can dream after a fashion; such dreams are actually mental exercieses taht have become reflexive through years of practice. After resting in this way, you gain the same benefit that a human does from 8 hours of sleep.");
	public static final Trait ELF_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.ELVISH), "You can speak, read, and write Common and Elvish. Elvish is fluid, with subtle intonations and intricate grammar. Elven literature is rich and varied, and their songs and poems are famous among other races. Many bards learn their language so they can add Elvish ballads to their repertoires.");
	public static final Trait ELF_SUBRACE = new SubraceTrait(new CustomHashMap<String, List<? extends Trait>>().add("dark", ELF_DARK_TRAITS).add("high", ELF_HIGH_TRAITS).add("wood", ELF_WOOD_TRAITS), "Ancient divides among the elven people resulted in three main subraces: high elves, wood elves, and dark elves, who are commonly called drow. Choose one of these subraces. In some worlds, these subraces are divided still further (such as the sun elves and moon elves of the Forgotten Realms), so if you wish you can choose a narrower subrace.");
	public static final List<Trait> ELF_TRAITS = Arrays.asList(ELF_ASI, ELF_AGE, ELF_ALIGNMENT, KEEN_SENSES, FEY_ANCESTRY, TRANCE, ELF_LANGUAGES, ELF_SUBRACE);
	
	// Forest Gnome Traits
	public static final Trait GNOME_FOREST_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.DEX, 1)), "Your Dexterity score increases by 1.");
	public static final Trait NATURAL_ILLUSIONIST = new SingleValueTrait<Spell>("Natural Illusionist", Spells.MINOR_ILLUSION, "You know the Minor Illusion cantrip. Intelligence is your spellcasting ability for it.");
	public static final Trait SPEAK_WITH_SMALL_BEASTS = new Trait("Speak with Small Beasts", "Through sounds and gestures, you can communicate simple ideas with Small or smaller beasts. Forest gnomes love animals and often keep squirrels, badgers, rabbits, moles, woodpeckers, and other creatures as beloved pets.");
	public static final List<Trait> GNOME_FOREST_TRAITS = Arrays.asList(GNOME_FOREST_ASI, NATURAL_ILLUSIONIST, SPEAK_WITH_SMALL_BEASTS);
	
	// Rock Gnome Traits
	public static final Trait GNOME_ROCK_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.CON, 1)), "Your Constitution score increases by 1.");
	public static final Trait ARTIFICERS_LORE = new SingleValueTrait<Skills>("Artificer's Lore", Skills.HISTORY, "Whenever you make an Intelligence (History) check related to magic items, alchemical objects, or technological devices, you can add twice your proficiency bonus, instead of any proficiency bonus you normally apply.");
	public static final Trait TINKER = new SingleValueTrait<Tool>("Tinker", Tools.TINKERS_TOOLS, "You have proficiency with artisan's tools (tinker's tools). Using those tools, you can spend 1 hour and 10 gp worth of materials to construct a Tiny clockwork device (AC5, 1 hp). The device ceases to function after 24 hours (unless you spend 1 hour repairing it to keep the device functioning), or when you use your action to dismantle it; at that time, you can reclaim the materials used to create it. You can have up to three such devices active at a time.\n" + 
			"When you create a device, choose one of the following options:\n" + 
			"Clockwork Toy: This toy is a clockwork animal, monster, or person, such as a frog, mouse, bird, dragon, or soldier. When placed on the ground, the toy moves 5 feet across the ground on each of your turns in a random direction. It makes noises as appropriate to the creature it represents.\n" + 
			"Fire Starter: The device produces a miniature flame, which you can use to light a candle, torch, or campfire. Using the device requires your action.\n" +
			"Music Box: When opened, this music box plays a single song at a moderate volume. The box stops playing when it reaches the song's end or when it is closed.");
	public static final List<? extends Trait> GNOME_ROCK_TRAITS = Arrays.asList(GNOME_ROCK_ASI, ARTIFICERS_LORE, TINKER);
	
	// Gnome Traits
	public static final Trait GNOME_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.INT, 2)), "Your Intelligence score increases by 2.");
	public static final Trait GNOME_AGE = new Trait("Age", "Gnomes mature at the same rate humans do, and most are expected to settle down into an adult life by around age 40. They can live 350 to almost 500 years.");
	public static final Trait GNOME_ALIGNMENT = new AlignmentTrait("Gnomes are most often good. Those who tend toward law are sages, engineers, researches, scholars, investigators, or inventors. Those who tend toward chaos are minstrels, tricksters, wanderers, or fanciful jewelers. Gnomes are good-hearted, and even the tricksters among them are more playful than vicious.");
	public static final ListTrait<AbilityScores> GNOME_CUNNING = new ListTrait<AbilityScores>("Gnome Cunning", Arrays.asList(AbilityScores.INT, AbilityScores.WIS, AbilityScores.CHA), "You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.");
	public static final Trait GNOME_DARKVISION = new DarkvisionTrait("Accustomed to life underground, you have superior vision in dark and dim conditions.");
	public static final Trait GNOME_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.GNOMISH), "You can speak, read, and write Common and Gnomish. The Gnomish language, which uses Dwarvish script, is renowned for its technical treatises and its catalogs of knowledge about the natural world.");
	public static final Trait GNOME_SPEED = new MovementSpeedTrait(25);
	public static final Trait GNOME_SIZE = new SizeTrait(2 * 12 + 11, new Dice(4, 2), 35, new Dice(1), CharacterSize.SMALL, "Gnomes are between 3 and 4 feet tall and average about 40 pounds. Your size is Small.");
	public static final Trait GNOME_SUBRACE = new SubraceTrait(new CustomHashMap<String, List<? extends Trait>>().add("forest", GNOME_FOREST_TRAITS).add("rock", GNOME_ROCK_TRAITS), "Two subraces of gnomes are found among the worlds of D&D: forest gnomes and rock gnomes. Choose one of these subraces.");
	public static final List<Trait> GNOME_TRAITS = Arrays.asList(GNOME_ASI, GNOME_AGE, GNOME_ALIGNMENT, GNOME_CUNNING, GNOME_DARKVISION, GNOME_LANGUAGES, GNOME_SPEED, GNOME_SIZE, GNOME_SUBRACE);
	
	// Half-Elf Traits
	public static final Trait HALF_ELF_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.CHA, 2)), "Your Charisma score increases by 2, and two other ability scores of your choice increases by 1.");
	public static final Trait HALF_ELF_AGE = new Trait("Age", "Half-elves mature at the same rate humans do and reach adulthood around the age of 20. They live much longer than humans, however, often exceeding 180 years.");
	public static final Trait HALF_ELF_ALIGNMENT = new AlignmentTrait("Half-elves share the chaotic bent of their elven heritage. They value both personal freedom and creative expression, demonstrating neither love of leaders nor desire for followers. They chafe at rules, resent others' demands, and sometimes prove unreliable or at least unpredictable.");
	public static final Trait HALF_ELF_DARKVISION = new DarkvisionTrait("Thanks to your elf blood, you have superior vision in dark and dim conditions.");
	public static final Trait HALF_ELF_SPEED = new MovementSpeedTrait();
	public static final Trait HALF_ELF_SIZE = new SizeTrait(4 * 12 + 9, new Dice(8, 2), 110, new Dice(4, 2), CharacterSize.MEDIUM, "Half-evles are about the same size as humans, ranging from 5 to 6 feet tall. Your size is Medium.");
	public static final Trait SKILL_VERSATILITY = new Trait("Skill Versatility", "You gain proficiency in two skills of your choice.");
	public static final Trait HALF_ELF_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.ELVISH), "You can speak, read, and write Common, Elvish, and one extra language of your choice.");
	public static final List<Trait> HALF_ELF_TRAITS = Arrays.asList(HALF_ELF_ASI, HALF_ELF_AGE, HALF_ELF_ALIGNMENT, HALF_ELF_DARKVISION, HALF_ELF_SPEED, HALF_ELF_SIZE, SKILL_VERSATILITY, HALF_ELF_LANGUAGES);
	
	// Half-Orc Traits
	public static final Trait HALF_ORC_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.STR, 2), new AbilityScore(AbilityScores.CON, 1)), "Your Strength score increases by 2, and your Constitution score increases by 1.");
	public static final Trait HALF_ORC_AGE = new Trait("Age", "Half-orcs mature a little faster than humans, reaching adulthood around age 14. They age noticeably faster and rarely live longer than 75 years.");
	public static final Trait HALF_ORC_ALIGNMENT = new AlignmentTrait("Half-orcs inherit a tendency toward chaos from their orc parents and are not strongly inclined toward good. Half-orcs raised among orcs and willing to live out their lives among them are usually evil.");
	public static final Trait HALF_ORC_DARKVISION = new DarkvisionTrait("Thanks to your orc blood, you have superior vision in dark and dim conditions.");
	public static final Trait HALF_ORC_SPEED = new MovementSpeedTrait();
	public static final Trait HALF_ORC_SIZE = new SizeTrait(4 * 12 + 10, new Dice(10, 2), 140, new Dice(6, 2), CharacterSize.MEDIUM, "Half-orcs are somewhat larger and bulkier than humans, and they range from 5 to well over 6 feet tall. Your size is Medium.");
	public static final Trait MENACING = new SingleValueTrait<Skills>("Menacing", Skills.INTIMIDATION, "You gain proficiency in the Intimidation skill.");
	public static final Trait RELENTLESS_ENDURANCE = new Trait("Relentless Endurance", "When you are reduced to 0 hit points but not killed outright, you can drop to 1 hit point instead. You can't use this feature again until you finish a long rest.");
	public static final Trait HALF_ORC_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.ORC), "You can speak, read, and write Common and Orc. Orc is a harsh, grating language with hard consonants. It has no script of its own but is written in the Dwarvish script.");
	public static final List<Trait> HALF_ORC_TRAITS = Arrays.asList(HALF_ORC_ASI, HALF_ORC_AGE, HALF_ORC_ALIGNMENT, HALF_ORC_DARKVISION, HALF_ORC_SPEED, HALF_ORC_SIZE, MENACING, RELENTLESS_ENDURANCE, HALF_ORC_LANGUAGES);
	
	// Lightfoot Halfling Traits
	public static final Trait HALFLING_LIGHTFOOT_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.CHA, 1)), "Your Charisma score increases by 1.");
	public static final Trait NATURALLY_STEALTHY = new Trait("Naturally Stealthy", "You can attempt to hide even when you are obscured only by a creature that is at least one size larger than you.");
	public static final List<Trait> HALFLING_LIGHTFOOT_TRAITS = Arrays.asList(HALFLING_LIGHTFOOT_ASI, NATURALLY_STEALTHY);
	
	// Stout Halfling Traits
	public static final Trait HALFLING_STOUT_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.CON, 1)), "Your Constitution score increases by 1.");
	public static final Trait STOUT_RESILIENCE = new SingleValueTrait<DamageType>("Stout Resilience", DamageType.POISON, "You have advantage on saving throws against poison, and you have resistance against poison damage."); 
	public static final List<Trait> HALFLING_STOUT_TRAITS = Arrays.asList(HALFLING_STOUT_ASI, STOUT_RESILIENCE);
	
	// Halfing Traits
	public static final Trait HALFLING_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.DEX, 1)), "Your Dexterity score increases by 2.");
	public static final Trait HALFLING_AGE = new Trait("Age", "A halfling reaches adulthood at the age of 20 and generally lives into the middle of his or her second century.");
	public static final Trait HALFLING_ALIGNMENT = new AlignmentTrait("Most halflings are lawful good. As a rule, they are good-hearted and kind, hate to see others in pain, and have no tolerance for oppression. They are also very orderly and traditional, leaning heavily on the support of their community and the comfort of the their old ways.");
	public static final Trait HALFLING_SPEED = new MovementSpeedTrait(25);
	public static final Trait HALFLING_SIZE = new SizeTrait(2 * 12 + 7, new Dice(4, 2), 35, new Dice(1), CharacterSize.SMALL, "Halflings average about 3 feet tall and weight about 40 pounds. Your size is Small.");
	public static final Trait LUCKY = new Trait("Lucky", "When you roll a 1 on an attack roll, ability check, or saving throw, you can reroll the die and must use the new roll.");
	public static final Trait BRAVE = new Trait("Brave", "You have advantage on saving throws against being frightened.");
	public static final Trait HALFLING_NIMBLENESS = new Trait("Halfling Nimbleness", "You can move through the space of any creature that is of a size larger than yours.");
	public static final Trait HALFLING_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.HALFLING), "You can speak, read, and write Common and Halfling. The Halfling language isn't secret, but halflings are loath to share it with others. They write very little, so they don't have a rich body of literature. Their oral tradition, however, is very strong. Almost all halflings speak Common to converse with the people in whose lands they dwell or through which they are traveling.");
	public static final Trait HALFLING_SUBRACE = new SubraceTrait(new CustomHashMap<String, List<? extends Trait>>().add("lightfoot", HALFLING_LIGHTFOOT_TRAITS).add("stout", HALFLING_STOUT_TRAITS), "The two main kinds of halfling, lightfoot and stout, are more like closely related families than true subraces. Choose one of these subraces.");
	public static final List<Trait> HALFLING_TRAITS = Arrays.asList(HALFLING_ASI, HALFLING_AGE, HALFLING_ALIGNMENT, HALFLING_SPEED, HALFLING_SIZE, LUCKY, BRAVE, HALFLING_NIMBLENESS, HALFLING_LANGUAGES, HALFLING_SUBRACE);
	
	// Human Traits
	public static final Trait HUMAN_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.CHA, 1), new AbilityScore(AbilityScores.CON, 1), new AbilityScore(AbilityScores.DEX, 1), new AbilityScore(AbilityScores.INT, 1), new AbilityScore(AbilityScores.STR, 1), new AbilityScore(AbilityScores.WIS, 1)), "Your ability scores each increases by 1.");
	public static final Trait HUMAN_AGE = new Trait("Age", "Humans reach adulthood in their late teens and live less than a century.");
	public static final Trait HUMAN_ALIGNMENT = new AlignmentTrait("Humans tend toward no particular alignment. The best and the worst are found among them.");
	public static final Trait HUMAN_SPEED = new MovementSpeedTrait();
	public static final Trait HUMAN_SIZE = new SizeTrait(4 * 12 + 8, new Dice(10, 2), 110, new Dice(4, 2), CharacterSize.MEDIUM, "Humans vary widely in height and build, from barely 5 feet to well over 6 feet tall. Regardless of your position in that range, your size is Medium.");
	public static final Trait HUMAN_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON), "You can speak, read and write Common and one extra language of your choice. Humans typically learn the language of other peoples they deal with including obscure dialects. They are fond of sprinkling their speech with words borrowed from other tongues: Orc curses, Elvish musical expressions, Dwarvish military phrases, and so on.");
	public static final List<Trait> HUMAN_TRAITS = Arrays.asList(HUMAN_ASI, HUMAN_AGE, HUMAN_ALIGNMENT, HUMAN_SPEED, HUMAN_SIZE, HUMAN_LANGUAGES);
	
	// Tiefling Traits
	public static final Trait TIEFLING_ASI = new AbilityScoreIncreaseTrait(Arrays.asList(new AbilityScore(AbilityScores.INT, 1), new AbilityScore(AbilityScores.CHA, 2)), "Your Intelligence score increases by 1, and your Charisma score increases by 2.");
	public static final Trait TIEFLING_AGE = new Trait("Age", "Tieflings mature at the same rate as humans but live a few years longer.");
	public static final Trait TIEFLING_ALIGNMENT = new AlignmentTrait("Tieflings might not have an innate tendency toward evil, but many of them end up there. Evil or not an independent nature inclines many tieflings toward a chaotic alignment.");
	public static final Trait TIEFLING_DARKVISION = new DarkvisionTrait("Thanks to your infernal heritage, you have superior vision in dark and dim conditions.");
	public static final Trait TIEFLING_SPEED = new MovementSpeedTrait();
	public static final Trait TIEFLING_SIZE = new SizeTrait(4 * 12 + 9, new Dice(8, 2), 110, new Dice(4, 2), CharacterSize.MEDIUM, "Tieflings are about the same size and build as humans. Your size is Medium.");
	public static final Trait HELLISH_RESISTANCE = new SingleValueTrait<DamageType>("Hellish Resistance", DamageType.FIRE, "You have resistance to fire damage.");
	public static final Trait INFERNAL_LEGACY = new SpellcastingTrait("Infernal Legacy", new CustomHashMap<Integer, Spell>().add(1, Spells.THAUMATURGY).add(3, Spells.HELLISH_REBUKE).add(5, Spells.DARKNESS), AbilityScores.CHA, "You know the Thaumaturgy cantrip. Once you reach 3rd level, you can cast the Hellish Rebuke spell once per day as a 2nd-level spell. Once you reach 5th level, you can also cast the Darkness spell once per day. Charisma is your spellcasting ability for these spells.");
	public static final Trait TIEFLING_LANGUAGES = new LanguagesTrait(Arrays.asList(Language.COMMON, Language.INFERNAL), "You can speak, read, and write Common and Infernal.");
	public static final List<Trait> TIEFLING_TRAITS = Arrays.asList(TIEFLING_ASI, TIEFLING_AGE, TIEFLING_ALIGNMENT, TIEFLING_DARKVISION, TIEFLING_SPEED, TIEFLING_SIZE, HELLISH_RESISTANCE, INFERNAL_LEGACY, TIEFLING_LANGUAGES);
}
