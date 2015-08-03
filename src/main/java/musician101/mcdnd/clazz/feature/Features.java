package musician101.mcdnd.clazz.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.clazz.HitDice;
import musician101.mcdnd.clazz.feature.EquipmentChoice.ListEquipmentChoice;
import musician101.mcdnd.clazz.feature.EquipmentChoice.MultipleEquipmentChoice;
import musician101.mcdnd.clazz.feature.EquipmentChoice.SingleEquipmentFeature;
import musician101.mcdnd.clazz.feature.Feature.EquipmentChoicesFeature;
import musician101.mcdnd.clazz.feature.Feature.HitPointsFeature;
import musician101.mcdnd.clazz.feature.Feature.UnarmoredDefenseFeature;
import musician101.mcdnd.clazz.feature.ListFeature.AbilityScoreImprovementFeature;
import musician101.mcdnd.clazz.feature.ListFeature.EquipmentFeature;
import musician101.mcdnd.clazz.feature.SpellcastingFeature.Cantrips;
import musician101.mcdnd.clazz.feature.SpellcastingFeature.RitualCasting;
import musician101.mcdnd.clazz.feature.SpellcastingFeature.SpellSlots;
import musician101.mcdnd.clazz.feature.SpellcastingFeature.SpellcastingFocus;
import musician101.mcdnd.clazz.feature.SpellcastingFeature.SpellsKnown;
import musician101.mcdnd.clazz.feature.totem.Totem;
import musician101.mcdnd.clazz.feature.totem.Totems;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.equipment.Armor.ArmorTypes;
import musician101.mcdnd.equipment.Equipment;
import musician101.mcdnd.equipment.pack.Packs;
import musician101.mcdnd.equipment.tool.Tool;
import musician101.mcdnd.equipment.tool.Tools;
import musician101.mcdnd.equipment.weapon.Weapons;
import musician101.mcdnd.magic.Spell;
import musician101.mcdnd.magic.Spell.SpellLevel;
import musician101.mcdnd.magic.Spells;
import musician101.mcdnd.skill.Skills;
import musician101.mcdnd.util.CustomList;
import musician101.mcdnd.util.CustomMap;

public class Features
{
	private static final HitDice D8 = new HitDice(8);
	private static final HitDice D12 = new HitDice(12);
	public static final Feature ABILITY_SCORE_IMPROVEMENT = new AbilityScoreImprovementFeature(Arrays.asList(4, 8, 12, 16, 19), "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't increase an ability score above 20 using this feature.");
	
	// Barbarian Features
	// Path of the Berserker
	public static final Feature FRENZY = new Feature("Frenzy", 3, "Starting when you choose this path at 3rd level, you can go into a frenzy whn you rage. If you do so, for the duration of your rage you can make a single melee weapon attack as a bonus action on each of your turns after this one. When your rage ends, you suffer one level of exhaustion.");
	public static final Feature MINDLESS_RAGE = new Feature("Mindless Rage", 6, "Beginning at 6th level, you can't be charmed or fightened while raging. If you are charmed or frightened when you enter your rage, the effect is suspended for the duration of the rage.");
	public static final Feature INTIMIDATING_PRESENCE = new DCSaveFeature("Intimidating Presence", 10, AbilityScores.CHA,
			"Beginning at 10th level, you can use your action to frighten someone with your menacing presence. When you do so, choose one creature that you can see within 30 feet of you. If the creature can see or hear you, it must succeed on a Wisdom saving throw (DC equal to 8 your proficiency bonus your Charisma modifier) or be frightened of you until the end of your next turn. On subsequent turns, you can use your action to extend the duration of this effect on the frightened creature until the end of your next turn. This effect ends if the creature ends its turn out of line of sight or more than 60 feet away from you.",
			"If the creature succeeds on its saving throw, you can't use this feature on that creature again for 24 hours.");
	public static final Feature RETALIATION = new Feature("Retaliation", 14, "Starting at 14th level, when you take damage from a creature that is within 5 feet of you, you can use your reaction to make a melee weapon attack against that creature.");
	public static final Feature BERSERKER = new MappedFeature<Integer, List<Feature>>("Path of the Berserker", new CustomMap<Integer, List<Feature>>().add(3, Arrays.asList(FRENZY)).add(6, Arrays.asList(MINDLESS_RAGE)).add(10, Arrays.asList(INTIMIDATING_PRESENCE)).add(14, Arrays.asList(RETALIATION)), "For some barbarians, rage is a means to an end-that end being violence. The Path of the Berserker is a path of untrammeled fury, slick with blood. As you enter the berserker's rage, you thrill in the chaos of battle, heedless of your own health or well-being.");
	
	// Path of the Totem Warrior
	public static final Feature SPIRIT_SEEKER = new ListFeature<Spell>("Spirit Seeker", 3, Arrays.asList(Spells.BEAST_SENSE, Spells.SPEAK_WITH_ANIMALS), "Yours is a path that seeks attunement with the natural world, giving you a kinship with beasts. At 3rd level when you adopt this path, you gain the ability to cast the Beast Sense and Speak with Animals spells, but only as rituals.");
	public static final Feature TOTEM_SPIRIT = new ListFeature<Totem>("Totem Spirit", 3, Totems.TOTEMS.get(3), "At 3rd level, when you adopt this path, you choose a totem spirit and gain its feature. You must make or acquire a physical totem object-an amulet or similar adornment-that incorporates fur or feathers, cloaws, teeth, or bones of the totem animal. At your option, you also gain minor physical attributes that are reminiscent of your totem spirit. For example, if you have a bear totem spirit, you might be unusually hairy and thick-skinned, or if your totem is the eagle, your eyes turn bright yellow.",
			"Your totem animal might be an animal related to those listed here but more appropriate to you homeland. For example, you could choose a hawk or vulture in place of an eagle.");
	public static final Feature ASPECT_OF_THE_BEAST = new ListFeature<Totem>("Aspect of the Beast", 6, Totems.TOTEMS.get(6), "At 6th level, you gain a magical benefit based on the totem animal of your choice. You can choose the same animal you selected at 3rd level or a different one.");
	public static final Feature SPIRIT_WALKER = new SingleValueFeature<Spell>("Spirit Walker", 10, Spells.COMMUNE_WITH_NATURE, "At 10th level, you can cast the Commune with Nature spell, but only as a ritual. When you do so, a spiritual version of one of the animals you chose for Totem Spirit or Aspect of the Beast appears to you to convey the information you seek.");
	public static final Feature TOTEMIC_ATTUNEMENT = new ListFeature<Totem>("Totemic Attunement", 14, Totems.TOTEMS.get(14), "At 14th level, you gain a magical benefit based on a totem animal of your choice. You can choose the same animal you selected previously or a different one.");
	public static final Feature TOTEM_WARRIOR = new MappedFeature<Integer, List<Feature>>("Path of the Totem Warrior", new CustomMap<Integer, List<Feature>>().add(3, Arrays.asList(SPIRIT_SEEKER, TOTEM_SPIRIT)).add(6, Arrays.asList(ASPECT_OF_THE_BEAST)).add(10, Arrays.asList(SPIRIT_WALKER)).add(14, Arrays.asList(TOTEMIC_ATTUNEMENT)), "The Path of the Totem Warrior is a spiritual journey, as the barbarian accepts a spirit animal as guide, protector, and inspiration. In battle, your totem spirit fills you with supernatural might, adding magical fuel to your barbarian rage.",
			"Most barbarian tribes consider a totem animal to be kin to a particular clan. In such cases, it is unusal for an individual to have more than one totem animal spirit, though exceptions exist.");
	
	// Core Features
	public static final Feature BARBARIAN_HP = new HitPointsFeature(D12, "barbarian");
	public static final Feature BARBARIAN_PROFICIENCIES = new ProficienciesFeature(Arrays.asList(ArmorTypes.LIGHT, ArmorTypes.MEDIUM, ArmorTypes.SHIELD), "Light armor, medium armor, shields", Weapons.getAll(), "Simple weapons, martial weapons",
			new ArrayList<Tool>(), "None", Arrays.asList(AbilityScores.STR, AbilityScores.CON), "Strength, Constitution", Arrays.asList(Skills.ANIMAL_HANDLING, Skills.ATHLETICS, Skills.INTIMIDATION, Skills.NATURE, Skills.PERCEPTION, Skills.SURVIVAL), 2, "Choose two from Animal Handling, Athletics, Intimidation, Nature, Perception, and Survival");
	public static final Feature BARBARIAN_EQUIPMENT = new EquipmentFeature(new EquipmentChoicesFeature(new SingleEquipmentFeature(Weapons.GREATAXE), new ListEquipmentChoice(new CustomList<Equipment>(Weapons.getMartialMeleeWeapons())), "(a) a greataxe or (b) any martial melee weapon"),
			new EquipmentChoicesFeature(new SingleEquipmentFeature(Weapons.HANDAXE, 2), new ListEquipmentChoice(new CustomList<Equipment>(Weapons.getSimpleWeapons())), "(a) two handaxes or (b) any simple weapon"),
			new EquipmentChoicesFeature(new MultipleEquipmentChoice(new CustomMap<Equipment, Integer>().add(Packs.EXPLORERS_PACK, 1).add(Weapons.JAVELIN, 4)), "An explorer's pack and four javelins."));
	public static final Feature RAGE = new RageFeature();
	public static final Feature UNARMORED_DEFENSE = new UnarmoredDefenseFeature("While you are not wearing any armor, your Armor Class equals 10 your Dexterity modifier your Constitution modifier. You can use a shield and still gain this benefit.");
	public static final Feature RECKLESS_ATTACK = new Feature("Reckless Attack", 2, "Starting at 2nd level, you can throw aside all concern for defense to attack with fierce desperation. When you make your first attack on your turn, you can decide to attack recklessly. Doing so gives you advantage on melee weapon attack rolls using Strength during this turn, but attack rolls against you have advatange until your next turn.");
	public static final Feature DANGER_SENSE = new Feature("Danger Sense", 2, "At 2nd level, you gain an uncanny sense of when things nearby aren't as they should be, giving you an edge when you dodge away from danger.",
			"You have advantage on Dexterity saving throws against effects that you can see, such as traps and spells. To gain this benefit, you can't be blinded, deafened, or incapacitated.");
	public static final Feature PRIMAL_PATH = new ListFeature<Feature>("Primal Path", 3, Arrays.asList(BERSERKER, TOTEM_WARRIOR), "At 3rd level, you choose a path that shapes the nature of your rage. Choose the path of the Berserker or the Path of the Totem Warrior, both detailed at the end of the class description. Your choice grants you features at 3rd level and again at 6th, 10th, and 14th levels.");
	public static final Feature BARBARIAN_EXTRA_ATTACK = new Feature("Extra Attack", 5, "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.");
	public static final Feature FAST_MOVEMENT = new Feature("Fast Movement", 5, "Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.");
	public static final Feature FERAL_INSTINCT = new Feature("Feral Instinct", 7, "By 7th level, your insticts are so honed that you have advantage on initiative rolls.", "Additionally, if you are surprised at the beginning of combat and aren't incapacitated, you can act normally on your first turn, but only if you enter your rage before doing anything else on that turn.");
	public static final Feature BRUTAL_CRITICAL = new MappedFeature<Integer, Integer>("Brutal Critical", 9, new CustomMap<Integer, Integer>().add(9, 1).add(13, 2).add(17, 3), "Beginning at 9th level, you can roll one additional weapon damage die when determining the extra damage for a critical hit with a melee attack.", "This increases to two additional dice at 13th level and three additional dice at 17th level.");
	public static final Feature RELENTLESS_RAGE = new Feature("Relentless Rage", 11, "Starting at 11th level, your rage can keep you fighting despite grievous wounds. If you drop to 0 hit points while you're raging and don't die outright, you can make a DC 10 Constitution saving throw. If you succeed, you drop to 1 hit point instead.", "Each time you use this feature after the first, the DC increases by 5. When you finish a short or long rest, the DC resets to 10.");
	public static final Feature PERSISTANT_RAGE = new Feature("Persistent Rage", 15, "Beginning at 15th level, your rage is so fierce that it ends early only if you fall unconscious or if you choose to end it.");
	public static final Feature INDOMITABLE_MIGHT = new Feature("Indomitable Might", 19, "Beginning at 18th level, if your total for a Strength check is less than your Strength score, you use that score in place of the total.");
	public static final Feature PRIMAL_CHAMPION = new Feature("Primal Champion", 20, "At 20th level, you embody the power of the wilds. Your Strength and Constitution scores increase by 4. Your maximum for those scores is now 24.");
	public static final Map<Integer, List<Feature>> BARBARIAN_FEATURES = new CustomMap<Integer, List<Feature>>()
			.add(1, Arrays.asList(BARBARIAN_HP, BARBARIAN_PROFICIENCIES, BARBARIAN_EQUIPMENT, RAGE, UNARMORED_DEFENSE))
			.add(2, Arrays.asList(RECKLESS_ATTACK, DANGER_SENSE)).add(3, Arrays.asList(PRIMAL_PATH))
			.add(4, Arrays.asList(ABILITY_SCORE_IMPROVEMENT)).add(5, Arrays.asList(BARBARIAN_EXTRA_ATTACK, FAST_MOVEMENT))
			.add(7, Arrays.asList(FERAL_INSTINCT)).add(9, Arrays.asList(BRUTAL_CRITICAL)).add(11, Arrays.asList(RELENTLESS_RAGE))
			.add(15, Arrays.asList(PERSISTANT_RAGE)).add(18, Arrays.asList(INDOMITABLE_MIGHT)).add(20, Arrays.asList(PRIMAL_CHAMPION));
	
	// Bard Features
	// Features shared between College of Lore and College of Valor
	public static final Feature BONUS_PROFICIENCES = new SingleValueFeature<Integer>("Bonus Proficiencies", 3, 3, "When you join the College of Lore at 3rd level, you gain proficiency with three skills of your choice.");
	
	// College of Lore
	public static final Feature CUTTING_WORDS = new Feature("Cutting Words", 3, "Also at 3rd level, you learn how to use your wit to distract, confuse, and otherwise sap the confidence and competence of others. When a creature that you can see within 60 feet of you makes an attack roll, an ability check, or a damage roll, you can use your reaction to expend one of your uses of Bardic Inspiration, rolling a Bardic Inspiration die and subtracting the number rolled from the creature's roll. You can choose to use this feature after the creature makes its roll, but before the DM determines whether the attack roll or ability roll check succeeds or fails, or before the creature deals its damage. The creature is immune if it can't hear you or if it's immune to being charmed.");
	public static final Feature ADDITIONAL_MAGICAL_SECRETS = new Feature("Additional Magical Secrets", 6, "At 6th level, you learn two spells of your choice from any class. A spell you choose must be of a level you can cast, as shown on the Bard table, or a cantrip. The chosen spells count as bard spells for you but don't count against the number of spells you know.");
	public static final Feature PEERLESS_SKILL = new Feature("Peerless Skill", 14, "Starting at 14th level, when you make an ability check, you can expend one use of Bardic Inspiration. Roll a Bardic Inspiration die and add the number rolled to your ability check. You can choose to do so after you roll the die for the ability check, but before the DM tells you whether you succeed or fail.");
	public static final Feature LORE = new MappedFeature<Integer, List<Feature>>("College of Lore", 3, new CustomMap<Integer, List<Feature>>().add(3, Arrays.asList(BONUS_PROFICIENCES, CUTTING_WORDS)).add(6, Arrays.asList(ADDITIONAL_MAGICAL_SECRETS)).add(14, Arrays.asList(PEERLESS_SKILL)),
			"Bards of the College of Lore know something about most things, collecting bits of knowledge from sources as diverse as scholary tomes and peasant tales. Whether singing folk ballads in taverns or elaborate compositions in royal courts, these bards use their gifts to hold audiences spellbound. When the applause dies down, the audience members might find themselves questioning everything they held to be true, from their faith in the priesthood of the local temple to their loyalty to the king.");
	
	// College of Valor
	public static final Feature COMBAT_INSPIRATION = new Feature("Combat Inspiration", 3, "Also at 3rd level, you learn to inspire others in battle. A creature that has a Bardic Inspiration die from you can roll that die and add the number rolled to a weapon damage roll it just made. Alternatively, when an attack roll is made against the creature, it can use its reaction to roll the Bardic Inspiration die and add the number rolled to its AC against that attack, after seeing the roll but before knowing whether it hits or misses.");
	public static final Feature BARD_EXTRA_ATTACK = new Feature("Extra Attack", 6, "Starting at 6th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.");
	public static final Feature BATTLE_MAGIC = new Feature("Battle Magic", 14, "At 14th level, you have mastered the art of weaving spellcasting and weapon use into a single harmonious act. When you use your action to cast a bard spell, you can make one weapon attack as a bonus action.");
	public static final Feature VALOR = new MappedFeature<Integer, List<Feature>>("College of Valor", 3, new CustomMap<Integer, List<Feature>>().add(3, Arrays.asList(BONUS_PROFICIENCES, COMBAT_INSPIRATION)).add(6, Arrays.asList(BARD_EXTRA_ATTACK)).add(14, Arrays.asList(BATTLE_MAGIC)),
			"Bards of the College of Valor are daring skalds whose tales keep alive the memory of the great heroes of the past, and thereby inspire a new generations of heroes. These bards gather in mead halls or around great bonfires to sing the deeds of the mighty, both past and present. They travel the land to witness great bonfires to sing the deeds of the mighty, both past and present. They travel the land to witness great events firsthand and to ensure that the memory of those events doesn't pass from the world. With their songs, they inspire others to reach the same heights of the accomplishment as the heroes of old.");
	
	// Core Features
	public static final Feature BARD_HP = new HitPointsFeature(D8, "bard");
	public static final Feature BARD_PROFICIENCIES = new ProficienciesFeature(Arrays.asList(ArmorTypes.LIGHT), "Light armor", Weapons.getSimpleWeapons().add(Weapons.HAND_CROSSBOW, Weapons.LONGSWORD, Weapons.RAPIER, Weapons.SHORTSWORD), "Simple weapons, hand crossbows, longswords, rapiers, shortswords", Tools.getMusicalInstruments(), "Three musical instruments of your choice", Arrays.asList(AbilityScores.DEX, AbilityScores.CHA), "Dexterity, Charisma", Arrays.asList(Skills.values()), 3, "Choose any three");
	public static final Feature BARD_SPELLCASTING = new SpellcastingFeature(new Cantrips(new CustomMap<Integer, Integer>().add(Arrays.asList(1, 2, 3), 2).add(Arrays.asList(4, 5, 6, 7, 8, 9), 3).add(Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), 2), "You know two cantrips of your choice from the bard spell list. You learn additional bard cantrips of your choice at higher levels, as shown in the Cantrips Known column of the Bard table."), 
			new SpellSlots(new CustomMap<SpellLevel, Map<Integer, Integer>>().add(SpellLevel.LEVEL_1, new CustomMap<Integer, Integer>().add(1, 2).add(2, 3).add(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), 4)).add(SpellLevel.LEVEL_2, new CustomMap<Integer, Integer>().add(Arrays.asList(1, 2), 0).add(3, 2).add(Arrays.asList(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), 4))
					.add(SpellLevel.LEVEL_3, new CustomMap<Integer, Integer>().add(Arrays.asList(1, 2), 3).add(3, 2).add(Arrays.asList(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), 3)).add(SpellLevel.LEVEL_4, new CustomMap<Integer, Integer>().add(Arrays.asList(1, 2, 3, 4, 5, 6), 0).add(7, 1).add(8, 1).add(Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), 3))
					.add(SpellLevel.LEVEL_5, new CustomMap<Integer, Integer>().add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 0).add(9, 1).add(Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17), 2).add(Arrays.asList(18, 19, 20), 3)).add(SpellLevel.LEVEL_6, new CustomMap<Integer, Integer>().add(Arrays.asList(0, 1,2 ,3, 4, 5, 6, 7, 8, 9, 10), 0).add(Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18), 1).add(Arrays.asList(19, 20), 2))
					.add(SpellLevel.LEVEL_7, new CustomMap<Integer, Integer>().add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), 0).add(Arrays.asList(13, 14, 15, 16, 17, 18, 19, 20), 1)).add(SpellLevel.LEVEL_8, new CustomMap<Integer, Integer>().add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14), 0).add(Arrays.asList(15, 16, 17, 18, 19, 20), 1))
					.add(SpellLevel.LEVEL_9, new CustomMap<Integer, Integer>().add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16), 0).add(Arrays.asList(17, 18, 19, 20), 1)),
					"The Bard table shows how many spell slots you have to cast your spells of 1st level and higher. To cast one of these spells, you must expend a slot of the spell's level or higher. You regain all expended spell slots when you finish a long rest.", "For example, if you know the 1st-level spell Cure Wounds and have a 1st-level and a 2nd-level spell slot available, you can cast cure wounds using either slot."),
			new SpellsKnown(new CustomMap<Integer, Integer>().add(1, 4).add(2, 5).add(3, 6).add(4, 7).add(5, 8).add(6, 9).add(7, 10).add(8, 11).add(9, 12).add(10, 14).add(Arrays.asList(11, 12), 15).add(13, 16).add(14, 18).add(Arrays.asList(15, 16), 19).add(17, 20).add(Arrays.asList(18, 19, 20), 22), "You know four 1st-level spells of your choice from the bard spell list.",
					"The Spells Known column of the Bard table shows when you learn more bard spells of your choice. Each of these spells must be of a level for which you have spell slots, as shown on the table. For instance, when you reach 3rd level in this class, you can learn on new spell of 1st or 2nd level.",
					"Additionally, when you gain a level in this class, you can choose one of the bard spells you know and replace it with another spell from the bard spell list, which also must be of a level for which you have spell slots."),
			new RitualCasting("You can cast any bard spell you know as a ritual if that spell has the ritual tag."),
			new SpellcastingFocus("You can use a musical instrument as a spellcasting focus for your bard spells."),
			"You have learned to untangle and reshape the fabric of reality in harmony with your wishes and music. Your spells are part of your vast repertoire, magic that you can tune to different situations.");
	public static final Feature BARDIC_INSPIRATION = new MappedFeature<Integer, Dice>("Bardic Inspiration", new CustomMap<Integer, Dice>().add(Arrays.asList(1, 2, 3, 4), new Dice(6)).add(Arrays.asList(5, 6, 7, 8, 9), new Dice(8)).add(Arrays.asList(10, 11), new Dice(10)).add(Arrays.asList(15, 16, 17, 18, 19, 20), new Dice(12)),
			"You can inspire others through stirring words or music. To do so, you use a bonus action on your turn to choose on creature other than yourself withing 60 feet of you who can hear you. That creature gains one Bardic Inspiration die, a d6.",
			"Once within the next 10 minuts, the creature can roll the die and add the number rolled to one ability check, attack roll, or saving throw it makes. The creature can wait until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost. A creature can have only one Bardic Inspiration die at a time.",
			"You can use this feature a number of times equal to your Charisma modifier (a minimum of once). You regain any expended uses when you finish a long rest.", "Your bardic Inspiration die changes when you reach certain levels in this class. The die becomes a d8 at 5th level, a d10 at 10th level, and a d12 at 15th level.");
	public static final Feature JACK_OF_ALL_TRADES = new Feature("Jack of All Trades", 2, "Starting at 2nd level, you can add half your proficiency bonus, rounded down, to any ability check you make that doesn't already include your proficiency bonus.");
	public static final Feature SONG_OF_REST = new MappedFeature<Integer, Dice>("Song of Rest", 2, new CustomMap<Integer, Dice>().add(Arrays.asList(2, 3, 4, 5, 6, 7, 8), new Dice(6)).add(Arrays.asList(9, 10, 11, 12), new Dice(8)).add(Arrays.asList(13, 14, 15, 16), new Dice(10)).add(Arrays.asList(17, 18, 19, 20), new Dice(12)), "Beginning at 2nd level, you can use soothing music or oration to help revitalize your wounded allies during a short rest. If you or any friendly creatures who can hear your performance regain hit points at the end of the short rest, each of those creatures regains an extra 1d6 hit points.",
			"The extra hit points increase when you reach certain levels in this class to 1d8 at 9th level, to 1d10 at 13th level, and to 1d12 at 17th level.");
	public static final Feature BARD_COLLEGE = new ListFeature<Feature>("Bard College", 3, Arrays.asList(LORE, VALOR), "At 3rd level, you delve into the advanced techniques of a bard college of your choice: the College of Lore or the College of Valor. Your choice grants you features at 3rd level and again at 6th and 14th level.");
	public static final Feature FONT_OF_INSPIRATION = new Feature("Font of Inspiration", 5, "Beginning when you reach 5th level, you regain all of your expended uses of Bardic Inspiration when you finish a short or long rest.");
	public static final Feature COUNTERCHARM = new Feature("Countercharm", 6, "At 6th level, you gain the ability to use musical notes or words of power to disrupt mind influencing effects. As an action, you can start a performance that lasts until the end of your next turn. During that time, you and any friendly creatures within 30 feet of you have advantage on saving throws against being  frightened or charmed. A creature must be able to hear you to gain this benefit. The performance ends early if you are incapacitated or silenced or if you voluntarily end it (no action required).");
	public static final Feature MAGICAL_SECRETS = new ListFeature<Integer>("Magical Secrets", 10, Arrays.asList(10, 14, 18), "By 10th level, you have plundered magical knowledge from a wide spectrum of disciplines. Choose two spells from any class, including this one. A spell you choose must be of a level you can cast, as shown on the Bard table, or a cantrip.", "The chosen spells count as bard spells for you and are included in the Spells Known column of the Bard table.", "You learn two additional spells from any class at 14th level and again at 18th level.");
	public static final Feature SUPERIOR_INSPIRATION = new Feature("Superior Inspiration", 20, "At 20th level, when you roll initiative and have no uses of Bardic Inspiration left, you regain one use.");
	public static final Map<Integer, List<Feature>> BARD_FEATURES = new CustomMap<Integer, List<Feature>>()
			.add(1, Arrays.asList(BARD_HP, BARD_PROFICIENCIES, BARD_SPELLCASTING, BARDIC_INSPIRATION)).add(2, Arrays.asList(JACK_OF_ALL_TRADES, SONG_OF_REST))
			.add(3, Arrays.asList(BARD_COLLEGE)).add(4, Arrays.asList(ABILITY_SCORE_IMPROVEMENT)).add(5, Arrays.asList(FONT_OF_INSPIRATION))
			.add(6, Arrays.asList(COUNTERCHARM)).add(10, Arrays.asList(MAGICAL_SECRETS)).add(20, Arrays.asList(SUPERIOR_INSPIRATION));
}
