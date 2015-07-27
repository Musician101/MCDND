package musician101.mcdnd.clazz.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.clazz.CharacterClasses;
import musician101.mcdnd.clazz.HitDice;
import musician101.mcdnd.clazz.feature.Feature.EquipmentChoicesFeature;
import musician101.mcdnd.clazz.feature.Feature.EquipmentChoicesFeature.EquipmentChoiceFeature;
import musician101.mcdnd.clazz.feature.Feature.EquipmentFeature;
import musician101.mcdnd.clazz.feature.Feature.HitPointsFeature;
import musician101.mcdnd.clazz.feature.Feature.ProficienciesFeature;
import musician101.mcdnd.clazz.feature.Feature.RageFeature;
import musician101.mcdnd.clazz.feature.Feature.UnarmoredDefenseFeature;
import musician101.mcdnd.clazz.feature.ListFeature.AbilityScoreImprovementFeature;
import musician101.mcdnd.clazz.feature.ListFeature.ArmorProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.SavingThrowProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.SkillProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.ToolProficiencyFeature;
import musician101.mcdnd.clazz.feature.ListFeature.WeaponProficiencyFeature;
import musician101.mcdnd.clazz.feature.SingleValueFeature.FirstLevelHPFeature;
import musician101.mcdnd.clazz.feature.SingleValueFeature.HigherLevelHPFeature;
import musician101.mcdnd.clazz.feature.SingleValueFeature.HitDiceFeature;
import musician101.mcdnd.clazz.feature.totem.Totem;
import musician101.mcdnd.clazz.feature.totem.Totems;
import musician101.mcdnd.equipment.Armor.ArmorTypes;
import musician101.mcdnd.equipment.tool.Tool;
import musician101.mcdnd.equipment.weapon.Weapon.WeaponType;
import musician101.mcdnd.equipment.weapon.Weapons;
import musician101.mcdnd.magic.Spell;
import musician101.mcdnd.magic.Spells;
import musician101.mcdnd.skill.Skills;
import musician101.mcdnd.util.CustomHashMap;

public class Features
{
	private static final HitDice D12 = new HitDice(12);
	
	// Barbarian Features
	// Path of the Berserker
	public static final Feature FRENZY = new Feature("Frenzy", 3, "Starting when you choose this path at 3rd level, you can go into a frenzy whn you rage. If you do so, for the duration of your rage you can make a single melee weapon attack as a bonus action on each of your turns after this one. When your rage ends, you suffer one level of exhaustion.");
	public static final Feature MINDLESS_RAGE = new Feature("Mindless Rage", 6, "Beginning at 6th level, you can't be charmed or fightened while raging. If you are charmed or frightened when you enter your rage, the effect is suspended for the duration of the rage.");
	public static final Feature INTIMIDATING_PRESENCE = new DCSaveFeature("Intimidating Presence", 10, AbilityScores.CHA, "Beginning at 10th level, you can use your action to frighten someone with your menacing presence. When you do so, choose one creature that you can see within 30 feet of you. If the creature can see or hear you, it must succeed on a Wisdom saving throw (DC equal to 8 + your proficiency bonus + your Charisma modifier) or be frightened of you until the end of your next turn. On subsequent turns, you can use your action to extend the durationof this effect on the frightened creature until the end of your next turn. This effect ends if the creature ends its turn out of line of sight or more than 60 feet away from you.\n" +
			"If the creature succeeds on its saving throw, you can't use this feature on that creature again for 24 hours.");
	public static final Feature RETALIATION = new Feature("Retaliation", 14, "Starting at 14th level, when you take damage from a creature that is within 5 feet of you, you can use your reaction to make a melee weapon attack against that creature.");
	public static final Feature BERSERKER = new ListFeature<Feature>("Path of the Berserker", Arrays.asList(FRENZY, MINDLESS_RAGE, INTIMIDATING_PRESENCE), "For some barbarians, rage is a means to an end-that end being violence. The Path of the Berserker is a path of untrammeled fury, slick with blood. As you enter the berserker's rage, you thrill in the chaos of battle, heedless of your own health or well-being.");
	
	// Path of the Totem Warrior
	public static final Feature SPIRIT_SEEKER = new ListFeature<Spell>("Spirit Seeker", 3, Arrays.asList(Spells.BEAST_SENSE, Spells.SPEAK_WITH_ANIMALS), "Yours is a path that seeks attunement with the natural world, giving you a kinship with beasts. At 3rd level when you adopt this path, you gain the ability to cast the Beast Sense and Speak with Animals spells, but only as rituals.");
	public static final Feature TOTEM_SPIRIT = new ListFeature<Totem>("Totem Spirit", 3, Arrays.asList(Totems.BEAR_3, Totems.EAGLE_3, Totems.WOLF_3), "At 3rd level, when you adopt this path, you choose a totem spirit and gain its feature. You must make or acquire a physical totem object-an amulet or similar adornment-that incorporates fur or feathers, cloaws, teeth, or bones of the totem animal. At your option, you also gain minor physical attributes that are reminiscent of your totem spirit. For example, if you have a bear totem spirit, you might be unusually hairy and thick-skinned, or if your totem is the eagle, your eyes turn bright yellow.\n" +
			"Your totem animal might be an animal related to those listed here but more appropriate to you homeland. For example, you could choose a hawk or vulture in place of an eagle.");
	public static final Feature ASPECT_OF_THE_BEAST = new ListFeature<Totem>("Aspect of the Beast", 6, Arrays.asList(Totems.BEAR_6, Totems.EAGLE_6, Totems.WOLF_6), "At 6th level, you gain a magical benefit based on the totem animal of your choice. You can choose the same animal you selected at 3rd level or a different one.");
	public static final Feature SPIRIT_WALKER = new SingleValueFeature<Spell>("Spirit Walker", Spells.COMMUNE_WITH_NATURE, "At 10th level, you can cast the Commune with Nature spell, but only as a ritual. When you do so, a spiritual version of one of the animals you chose for Totem Spirit or Aspect of the Beast appears to you to convey the information you seek.");
	public static final Feature TOTEMIC_ATTUNEMENT = new ListFeature<Totem>("Totemic Attunement", Arrays.asList(Totems.BEAR_14, Totems.EAGLE_14, Totems.WOLF_14), "At 14th level, you gain a magical benefit based on a totem animal of your choice. You can choose the same animal you selected previously or a different one.");
	public static final Feature TOTEM_WARRIOR = new ListFeature<Feature>("Path of the Totem Warrior", Arrays.asList(SPIRIT_SEEKER, TOTEM_SPIRIT, ASPECT_OF_THE_BEAST, SPIRIT_WALKER, TOTEMIC_ATTUNEMENT), "The Path of the Totem Warrior is a spiritual journey, as the barbarian accepts a spirit animal as guide, protector, and inspiration. In battle, your totem spirit fills you with supernatural might, adding magical fuel to your barbarian rage.\n" +
			"Most barbarian tribes consider a totem animal to be kin to a particular clan. In such cases, it is unusal for an individual to have more than one totem animal spirit, though exceptions exist.");
	
	// Core Features
	public static final Feature BARBARIAN_HP = new HitPointsFeature(new HitDiceFeature(D12, D12.toString() + " per barbarian level"), new FirstLevelHPFeature(D12), new HigherLevelHPFeature(D12));
	public static final Feature BARBARIAN_PROFICIENCIES = new ProficienciesFeature(new ArmorProficiencyFeature(Arrays.asList(ArmorTypes.LIGHT, ArmorTypes.MEDIUM, ArmorTypes.SHIELD), "Light armor, medium armor, shields"), new WeaponProficiencyFeature(Arrays.asList(WeaponType.SIMPLE_MELEE, WeaponType.SIMPLE_RANGED, WeaponType.MARTIAL_MELEE, WeaponType.MARTIAL_RANGED), "Simple weapons, martial weapons"),
			new ToolProficiencyFeature(new ArrayList<Tool>(), "None"), new SavingThrowProficiencyFeature(Arrays.asList(AbilityScores.STR, AbilityScores.CON), "Strength, Constitution"), new SkillProficiencyFeature(Arrays.asList(Skills.ANIMAL_HANDLING, Skills.ATHLETICS, Skills.INTIMIDATION, Skills.NATURE, Skills.PERCEPTION, Skills.SURVIVAL), 2, "Choose two from Animal Handling, Athletics, Intimidation, Nature, Perception, and Survival"));
	public static final Feature BARBARIAN_EQUIPMENT = new EquipmentFeature(new EquipmentChoicesFeature(new EquipmentChoiceFeature(Weapons.GREATAXE), new EquipmentChoiceFeature(Arrays.asList(Weapons.BATTLEAXE, Weapons.FLAIL, Weapons.GLAIVE, Weapons.GREATAXE, Weapons.GREATSWORD, Weapons.HALBERD, Weapons.LANCE, Weapons.LONGSWORD, Weapons.MAUL, Weapons.MORNINGSTAR, Weapons.PIKE, Weapons.RAPIER, Weapons.SCIMITAR, Weapons.SHORTSWORD, Weapons.TRIDENT, Weapons.WAR_PICK, Weapons.WARHAMMER, Weapons.WHIP)), "(a) a greataxe or (b) any martial melee weapon"),
			new EquipmentChoicesFeature(new EquipmentChoiceFeature(Weapons.HANDAXE, 2), new EquipmentChoiceFeature(Arrays.asList(Weapons.CLUB, Weapons.DAGGER, Weapons.GREATCLUB, Weapons.HANDAXE, Weapons.JAVELIN, Weapons.LIGHT_HAMMER, Weapons.MACE, Weapons.QUARTERSTAFF, Weapons.SICKLE, Weapons.SPEAR, Weapons.LIGHT_CROSSBOW, Weapons.DART, Weapons.SHORTBOW, Weapons.SLING)), "(a) two handaxes or (b) any simple weapon"),
			new EquipmentChoicesFeature(new EquipmentChoiceFeature(Arrays.asList(Weapons.JAVELIN), 4), "An explorer's pack and four javelins."));
	public static final Feature RAGE = new RageFeature();
	public static final Feature UNARMORED_DEFENSE = new UnarmoredDefenseFeature("While you are not wearing any armor, your Armor Class equals 10 + your Dexterity modifier + your Constitution modifier. You can use a shield and still gain this benefit.");
	public static final Feature RECKLESS_ATTACK = new Feature("Reckless Attack", 2, "Starting at 2nd level, you can throw aside all concern for defense to attack with fierce desperation. When you make your first attack on your turn, you can decide to attack recklessly. Doing so gives you advantage on melee weapon attack rolls using Strength during this turn, but attack rolls against you have advatange until your next turn.");
	public static final Feature DANGER_SENSE = new Feature("Danger Sense", 2, "At 2nd level, you gain an uncanny sense of when things nearby aren't as they should be, giving you an edge when you dodge away from danger.\n" +
			"You have advantage on Dexterity saving throws against effects that you can see, such as traps and spells. To gain this benefit, you can't be blinded, deafened, or incapacitated.");
	public static final Feature PRIMAL_PATH = new ListFeature<Feature>("Primal Path", 3, Arrays.asList(BERSERKER, TOTEM_WARRIOR), "At 3rd level, you choose a path that shapes the nature of your rage. Choose the path of the Berserker or the Path of the Totem Warrior, both detailed at the end of the class description. Your choice grants you features at 3rd level and again at 6th, 10th, and 14th levels.");
	public static final Feature BARBARIAN_ABILITY_SCORE_IMPROVEMENT = new AbilityScoreImprovementFeature(Arrays.asList(4, 8, 12, 16, 19), "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't increase an ability score above 20 using this feature.");
	public static final Feature EXTRA_ATTACK = new Feature("Extra Attack", 5, "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.");
	public static final Feature FAST_MOVEMENT = new Feature("Fast Movement", 5, "Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.");
	public static final Feature FERAL_INSTINCT = new Feature("Feral Instinct", 7, "By 7th level, your insticts are so honed that you have advantage on initiative rolls.\n" + "Additionally, if you are surprised at the beginning of combat and aren't incapacitated, you can act normally on your first turn, but only if you enter your rage before doing anything else on that turn.");
	public static final Feature BRUTAL_CRITICAL = new MappedFeature<Integer, Integer>("Brutal Critical", 9, new CustomHashMap<Integer, Integer>().add(9, 1).add(13, 2).add(17, 3), "Beginning at 9th level, you can roll one additional weapon damage die when determining the extra damage for a critical hit with a melee attack.\n" + "This increases to two additional dice at 13th level and three additional dice at 17th level.");
	public static final Feature RELENTLESS_RAGE = new Feature("Relentless Rage", 11, "Starting at 11th level, your rage can keep you fighting despite grievous wounds. If you drop to 0 hit points while you're raging and don't die outright, you can make a DC 10 Constitution saving throw. If you succeed, you drop to 1 hit point instead.\n" + "Each time you use this feature after the first, the DC increases by 5. When you finish a short or long rest, the DC resets to 10.");
	public static final Feature PERSISTANT_RAGE = new Feature("Persistent Rage", 15, "Beginning at 15th level, your rage is so fierce that it ends early only if you fall unconscious or if you choose to end it.");
	public static final Feature INDOMITABLE_MIGHT = new Feature("Indomitable Might", 19, "Beginning at 18th level, if your total for a Strength check is less than your Strength score, you use that score in place of the total.");
	public static final Feature PRIMAL_CHAMPION = new Feature("Primal Champion", 20, "At 20th level, you embody the power of the wilds. Your Strength and Constitution scores increase by 4. Your maximum for those scores is now 24.");
	public static final List<Feature> BARBARIAN_FEATURES = Arrays.asList(BARBARIAN_HP, BARBARIAN_PROFICIENCIES, BARBARIAN_EQUIPMENT, RAGE, UNARMORED_DEFENSE, RECKLESS_ATTACK, DANGER_SENSE, PRIMAL_PATH, BARBARIAN_ABILITY_SCORE_IMPROVEMENT, EXTRA_ATTACK, FAST_MOVEMENT, FERAL_INSTINCT, BRUTAL_CRITICAL, RELENTLESS_RAGE, PERSISTANT_RAGE, INDOMITABLE_MIGHT, PRIMAL_CHAMPION);
	
	static Map<CharacterClasses, List<Feature>> map = new CustomHashMap<CharacterClasses, List<Feature>>()
			.add(CharacterClasses.BARBARIAN, getBarbarianFeatures()).add(CharacterClasses.BARD, getBardFeatures())
			.add(CharacterClasses.CLERIC, getClericFeatures()).add(CharacterClasses.DRUID, getDruidFeatures())
			.add(CharacterClasses.FIGHTER, getFighterFeatures()).add(CharacterClasses.MONK, getMonkFeatures())
			.add(CharacterClasses.PALADIN, getPaladinFeatures()).add(CharacterClasses.RANGER, getRangerFeatures())
			.add(CharacterClasses.ROGUE, getRogueFeatures()).add(CharacterClasses.SORCERER, getSorcererFeatures())
			.add(CharacterClasses.WIZARD, getWarlockFeatures()).add(CharacterClasses.WIZARD, getWizardFeatures());
	
	public static List<Feature> getFeatures(CharacterClasses cc)
	{
		return map.get(cc);
	}
	
	private static List<Feature> getBarbarianFeatures()
	{
		return Arrays.asList(new Feature("Rage", "Enter (or end) a rage as a bonus action gaining the following benefits if not wearing heavy armor.\n"
				+ "- Advantage on STR checks and STR saving throws\n"
				+ "- When making a melee weapon attack using STR, gain a +4 bonus to the damage roll\n"
				+ "- Resistance to bludgeoning, piercing, and slashing damage\n"
				+ "Rage lasts 1 min, ends if unconscious or hanven't attacked a hostile creature since last turn or taken damage since then.\n"
				+ "You can't cast spells or concentrate on them while raging.\n"
				+ "You have a limited number of Rages until 20th level.\n"
				+ "Rage Damage: 1st-8th levels = +2, 9th-15th levels = +3, 16th-20th levels = +4"),
			new Feature("Unarmored Defense", "While you are not wearing any armor, your Armor Class equals 10 + your DEX mod + your CON mod. You can use a shield and still gain this benefit."),
			new Feature("Reckless Attack", "Starting at 2nd level, Gain advantage on first melee weapon attack using STR this turn, attacks against you have advantage until next turn."),
			new Feature("Danger Sense", "Advantage on DEX saving throws against effects that you can see."),
			new Feature("Primal Path", "At 3rd level, choose the Path of the Berserker or Totem Warrior and gain their feats at 3rd, 6th, 10th, and 14th levels."),
			new Feature("Ability Score Improvement", "At 4th, 8th, 12th, 16th, and 19th level, you can increase one ability score by 2 or two ability scores of your choice by 1. You can't increase an ability score above 20 using this feature."),
			new Feature("Extra Attack", "Starting at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn."),
			new Feature("Fast Movement", "Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor."),
			new Feature("Feral Instinct", "Starting at 7th level, you have advantage on Initiative rolls.\n"
					+ "Additionally, if you are surprised at the beginning of combat and aren't incapacitated, you can act normally on your first turn, but only if you enter Rage before doing anything else on that turn."),
			new Feature("Brutal Critical", "Starting at 9th level, you can roll one additional wepaon damage die when determining extra damage for a critical hit with a melee attack. You gain another die at 13th and 17th levels."),
			new Feature("Relentless Rage", "Starting at 11th level, while raging and you don't die outright, make a DC 10 CON saving throw to drop to 1 HP instead. The DC increases by 5 each time this feature is used after the first. A short or long rest resets the DC to 10."),
			new Feature("Persistent Rage", "Starting at 15th level, your Rage ends early only if you fall unconscious or choose to end it."),
			new Feature("Indomitable Might", "Starting at 18th level, if the total for a STR check is less than your STR score, use the STR score instead."));
	}
	
	private static List<Feature> getBardFeatures()
	{
		return Arrays.asList(new Feature("Spellcasting", "Cast any known bard spell as a ritual spell if that spell has the ritual tag. Spellcasting focus: musical instrument."),
				new Feature("Bardic Inspiration", "As a bonus action, choose on creature other than yourself within 60 feet. That creature gains one Bardic Inspiration die, a d6.\n"
						+ "Once within the next 10 minutes, the creature can roll the die to add the number rolled to one ability check, attack roll, or saving throw it makes. The die can be rolled after the d20, but before the DM says whether the roll succeeds or fails. The die is lost once it is used. A creature can have only one Bardic Inspiration die at a time."
						+ "The number of uses for this feature equals your Charisma modifier (min. 1)."
						+ "The die becomes a d8 at 5th level, d10 at 10th level, and d12 at 15th level."),
				new Feature("Jack of All Trades", "Starting at 2nd level, you can add half your proficiency bonus, rounded down, to any ability check you make that doesn't already include your proficiency bonus."),
				new Feature("Song of Rest", "Starting at 2nd level, you can use soothing music or oration to help heal your allies during a short rest. If friendly creatures who can hear your performance regain hit points at the end of the short rest, each of those creatures regains an extra 1d6 in hit points."
						+ "The die for extra hit points  changes to 1d8 at 9th level, 1d10 at 13th level, and 1d12 at 17th level."),
				new Feature("Bard College", "At 3rd level, you delve into the advanced techniques of a bard college of your choice: the College of Lore or the College of Valor. Your choice grants you features at 3rd, 6th, and 14th levels."),
				new Feature("Expertise", "At 3rd and 10th levels, choose two of your skill proficiencies. Your proficiency bonus is doubled for any ability check you make that uses either of the chosen proficiencies."),
				new Feature("Ability Score Improvement", "When you reach 4th, 8th, 12th, 16 and 19th levels, you can increase one ability score of your choice by 2, or increase two ability scores of your choice by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Font of Inspiration", "Starting at 5th level, you regain all of your expended uses of Bardic Inspiration when you finish a short or long rest."),
				new Feature("Countercharm", "At 6th level, you gain the ability to use music or words of power to disrupt mind influencing effects. As an action, you can start a performance that lasts until the end of your next turn."));
	}
	
	private static List<Feature> getClericFeatures()
	{
		return Arrays.asList(new Feature("Spellcasting", "As a conduit for divine power, you can cast cleric spells."),
				new Feature("Divine Domain", "Choose one domain related to your deity: Knowledge, Life, Light, Nature, Tempest, Trickery, or War."),
				new Feature("Channel Divinity", "At 2nd level, you gain the ability to channel divine energy directly from your deity, using that energy to fuel magical effects. You start with two such effects: Turn Undead and an effect determined by your domain. Some domains grant you additional effects as you advance in levels.\n"
						+ "When you use this, you chose which effect to create. You must then finish a short or long rest to use it again.\n"
						+ "Some effects require saving throws. The DC equals your cleric spell save DC.\n"
						+ "Starting at 6th level, you can use Channel Divinity twice (three times at 18th level) between rests."),
				new Feature("Ability Score Improvement", "At 4th, 8th, 12th, 16, and 19th levels, you can increase one ability score of your choic by 2, or two ability scores of your choice by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Destroy Undead", "Starting at 5th level, when an undead fails its saving throw against your Turn Undead feature, the creature is instantly destroyed if its challenge rating is at or below a certain threshold."),
				new Feature("Divine Intervention", "Starting at 10th level, you can call on your deity to intervene on your behalf when your need is great.\n"
						+ "Describe the assistance you seek and roll percentile dice. If you roll a number equal to or lower than your cleric level, your deity intervenes. The DM chooses the nature of the intervention; the effect of any cleric spell or domain would be appropriate.\n"
						+ "If your deity intervenes, you can't use this feature again for 7 days.\n"
						+ "At 20th level, your call for intervention succeeds automatically, no roll required."));
	}
	
	private static List<Feature> getDruidFeatures()
	{
		return Arrays.asList(new Feature("Druidic", "You know Druidic, the secret language of druids. You can speak the language and use it to leave hidden messages. You and others who know this language automatically spot such a message. Others spot the message's presence with a successful DC 15 Wisdom (Perception) check but can't decipther it without magic."),
				new Feature("Spellcasting", "Drawing on the divine essence of nature itself, you can cast spells to shape that essence to your will."),
				new Feature("Wild Shape", "Starting at 2nd level, you can use your action to magically assume the shape of a beast that you have seen before. You can use this feature twice and regain expended uses when you finish a short or long rest.\n"
						+ "Your druid level determines the beasts you can transform into.\n"
						+ "You can stay in a beast shape for a number of hours equal to half your druid level (rounded down). You then revert to your normal form unless you expend another use of this feature. You can revert to your normal form earlier by using a bonus action on your turn. you automatically revert if you fall unconscious, drop to 0 HP, or die."),
				new Feature("Druid Circle", "At 2nd level, you choose to identify with a circle of druids: the Circle of the Land or the Circle of the Moon."),
				new Feature("Ability Score Improvement", "When you reach 4th, 8th, 12th, 16th, and 19th levels, you can increase one ability score by 2, or increase two ability scores of your choice by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Timeless Body", "Starting at 18th level, the primal magic that you wield causes you to age more slowly. For every 10 years that pass, your body ages only 1 year."),
				new Feature("Beast Spells", "Starting at 18th level, you can cast many of your druid spells in any shape you assume using Wild Shape. You can perform the somatic and verbal components of a druid spell while in a beast shape, but you aren't able to provide material components."),
				new Feature("Archdruid", "At 20th level, you can use your Wild Shape an unlimited number of times.\n"
						+ "Additionally, you can ignore the verbal and somatic components of your druid spells, as well as any material components that lack a cost and aren't consumed by a spell. You gain this benefit in both your normal and beast shapes."));
	}
	
	private static List<Feature> getFighterFeatures()
	{
		return Arrays.asList(new Feature("Fighting Style", "You adopt a particular style of fighting as your specialty: Archery, Defense, Dueling, Great Weapon Fighting, Protection, Two-Weapon Fighting."),
				new Feature("Second Wind", "You have a limited well of stamina that you can draw on to protect yourself from harm. On your turn, you can use a bonus action to regain hit points equal to 1d10 + your fighter level. You must finish a short or long rest before you can use it again."),
				new Feature("Action Surge", "Starting at 2nd level, you can push yourself beyond your normal limits for a moment. On your turn, you can take one additional action on top of your regular action and a possible bonus action.\n"
						+ "You must finish a short or long rest before you can use it again. Starting at 17th level, you can use it twice before a rest, but only once per turn."),
						new Feature("Martial Archetype", "At 3rd level, you choose an archetype that you strive to emulate in your combat styles and techniques. Choose Champion, Battle Master, or Eldritch Knight."),
						new Feature("Ability Score Improvement", "When you reach 4th, 6th, 8th, 12th, 14th, 16th, and 19th levels, you can increase one ability score by 2 or increase two ability scores of your choice by 1. You can't increase an ability score above 20 using this feature."),
						new Feature("Extra Attack", "Beginning at 5th level, you can attack twice whenever you take the Attack action on your turn.\n"
								+ "The number of attacks increases to three when you reach 11th level and to four when you reach 20th level."),
						new Feature("Indomitable", "Beginning at 9th level, you can reroll a saving throw that you fail. If you do so, you must use the new roll, and you can't use this feature again until you finish a long rest.\n"
								+ "You can use this feature twice between long rests at 13th level and three times at 17th level."));
	}
	
	private static List<Feature> getMonkFeatures()
	{
		return Arrays.asList(new Feature("Unarmored Defense", "Beginning at 1st level, while you are wearing no armor and not wielding a shield, your AC equals 10 + your DEX mod + your WIS mod."),
				new Feature("Martial Arts", "At 1st level, when you use the Attack action with an unarmed strike or a monk weapon on your turn, you can make one unarmed strike as a bonus action."),
				new Feature("Ki", "Starting at 2nd level, your training allows you to harness the mystic energy of ki. Your monk level determines the number of ki points you have.\n"
						+ "Ki features requiring saving throws have a DC equal to 8 plus your proficiency bonus plus your WIS mod.\n"
						+ "You start with 3 ki features:\n"
						+ "- Flurry of Blows: Immediately after you take the Attack action on your turn, you can spend 1 ki point to make two unarmed strikes as a bonus action.\n"
						+ "- Patient Defense: You can spend 1 ki point to take the Dodge action as a bonus action on you turn.\n"
						+ "- Step of the Wind: You can spend 1 ki point to take the Disengage or Dash action as a bonus action on your turn, and your jump distance is doubled for the turn."),
				new Feature("Unarmored Movement", "Starting at 2nd level, your speed increases by 10 feet while you are not wearing armor or wielding a shield. This bonus increases as you gain levels.\n"
						+ "At 9th level, you gain the ability to move along vertical surfaces and across liquids on your turn without falling during the move."),
				new Feature("Monastic Tradition", "When you reach 3rd level, you commit yourself to a monastic tradition: the Way of the Open Hand, the Way of Shadow, or the Way of the Four Elements."),
				new Feature("Deflect Missiles", "Starting at 3rd level, you can use your reaction to deflect or catch the missile when you are hit by a ranged weapon attack. The damage you take from the attack is reduced by 1d10 + your DEX mod + your monk level.\n"
						+ "If you reduce the damage to 0 and the missile is small enough for you to hold with one hand and you have a one hand free, you can spend 1 ki point to make a ranged attack with the weapon or piece of ammunition you just caught as part of the same reaction. You make this attack with proficiency, regardless of your weapon proficiencies, and the missile counts as a monk weapon."),
				new Feature("Ability Score Improvement", "At 4th, 8th, 12th, 16th, and 19th levels, you can increase one ability score by 2, or you can increase two ability scores by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Slow Fall", "Beginning at 4th level, you can use your reaction when you fall to reduce any falling damage you take by an amount equal to five times your monk level."),
				new Feature("Extra Attack", "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn."),
				new Feature("Stunning Strike", "Starting at 5th level, when you hit another creature witha a melee weapon attack, you can spend 1 ki point to attempt a stunning strike. The target must succedd on a CON saving throw or be stunned until the end of your next turn."),
				new Feature("Ki-Empowered Strikes", "Starting at 6th level, your unarmed strikes count as magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage."),
				new Feature("Evasion", "Starting at 7th level, when you are subjected to an effect that allows you to make a DEX saving throw to take only half damage, you instead take no damage if you succeed, and only half damage if you fail."),
				new Feature("Stillness of Mind", "Starting at 7th level, you can use your action to end one effect on yourself that is causing you to be charmed or frightened."),
				new Feature("Purity of Body", "At 10th level, your mastery of the ki flowing through you immune to disease and poison."),
				new Feature("Tongue of the Sun and Moon", "Starting at 13th level, you learn to touch the ki of other minds so that you understand all spoken languages. Moreover, any creature that can understand a language can understand what you say."),
				new Feature("Diamond Soul", "Beginning at 14th level, your mastery of ki grants you proficiency in all saving throws.\n"
						+ "Additionally, whenever you make a saving throw and fail, you can spend 1 ki point to reroll it and take the second result."),
				new Feature("Timeless Body", "At 15th level, you ki sustains you so that you suffer none of the frailty of old age, and you can't be aged magically. You can still die of old age, however. In addition, you no longer need food or water."),
				new Feature("Empty Body", "Beginning at 18th level, you can use your action to spend 4 ki points to become invisible for 1 minute. During that time, you also have resistance to all damage but force damage.\n"
						+ "Additionally, you can spend 8 ki points to cast the astral projection spell, without needing material components. When you do so, you can't take any other creatures with you."),
				new Feature("Perfect Self", "At 20th level, when you roll for initiative and have no ki points remaining, you regain 4 ki points."));
	}
	
	private static List<Feature> getPaladinFeatures()
	{
		return Arrays.asList(new Feature("Divine Sense", "As an action, know the location of any celestial, fiend, or undead within 60ft (not in total cover) until the end of your next turn.\n"
					+ "You also detect the presence of any place or object that has been consecrated or desecrated, as with the Hallow Spell.\n"
					+ "You can use this feature 1 time and recover uses after a long rest."),
				new Feature("Lay on Hands", "As an action, touch a creature and restore its hit points from your healing pool (your paladin level * 5). Expend 5 hit points from your pool of healing to cure a disease or neutralize a poison affecting it. It has no effect on undead or constucts."),
				new Feature("Spellcasting", "Starting at 2nd level, you can draw on divine magic through meditation and prayer to cast spells."),
				new Feature("Fighting Style", "At 2nd level, you adopt a style of fighting as your specialty. You can't take a Fighting Style option more than once, even if you later get to choose agin."),
				new Feature("Divine Smite", "Starting at 2nd level, when you hit a creature witha  melee weapon attack, you can expend one paladin spell slot to deal radiant damage to the target. The extra damage is 2d8 for a 1st-level spell, plus 1d8 for each spell level higher than 1st, to a max of 5d8. The damage increases by 1d8 if the target is undead or a fiend."),
				new Feature("Divine Health", "By 3rd level, the divine magic flowing through you makes you immune to dease."),
				new Feature("Sacred Oath", "When you reach 3rd level, you swear the oath that binds you as a paladin forever. You can choose either the Oath of Devotion, Oath of the Ancients, or the Oath of Vengeance."),
				new Feature("Ability Score Improvement", "When you reach 4th, 8th, 12th, 16th, and 19th levels, you can increase one ability score by 2 or increase two ability scores by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Extra Attack", "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn."),
				new Feature("Aura of Protection", "Starting at 6th level, whenever you or a friendly creature within 10 feet (30ft at 18th level) of you must make a saving throw, the creature gains a bonus to the saving throw equal to your CHA mod (with a minimum of +1). You must be conscious to grant this bonus."),
				new Feature("Aura of Courage", "Starting at 10th level, you and friendly creatures within 10 feet (30 feet at 18th level) of you can't be frightened while you are conscious."),
				new Feature("Cleansing Touch", "Beginning at 14th level, you can use your action to end one spell on yourself or on one willing creature that you touch. You can use this feature a number of times equal to your CHA mod (min. 1). You regain uses when you finish a long rest."));
	}
	
	private static List<Feature> getRangerFeatures()
	{
		return Arrays.asList(new Feature("Favored Enemy", "At 1st, 6th, and 14th levels, you choose a type of enemy to be familiar with. You have advantage on WIS (Survival) checks to track your favored enemies, as well as on INT checks to recall info about them."),
				new Feature("Natural Explorer", "At 1st, 6th, and 10th levels, you choose a favored terrain. When you make an INT or WIS check related to your favored terrain, your proficiency bonus is doubled if you're using a skill that you're proficient in.\n"
						+ "While traveling for an hour or more in your favored terrain, you gain the following benefits:\n"
						+ "- Difficult terratin doesn't slow your group's travel.\n"
						+ "Your group can't become lost except by magical means.\n"
						+ "Even when you are engaged in another activity while traveling (such as foraging, navigating, or tracking), you remain alert to danger.\n"
						+ "If you are traveling alone, you can move stealthily at a normal place.\n"
						+ "When you forage, you find twice as much food as you normally would.\n"
						+ "While tracking other creatures, you also learn their exact number, their sizes, and how long ago they passed through the area."),
				new Feature("Fighting Style", "At 2nd level, you adopt a particular style of fighting as your specialty. You can't take a the same option more than once, even if you later get to choose again."),
				new Feature("Spellcasting", "By 2nd level, you have learned to use the magical essence of nature to cast spells."),
				new Feature("Ranger Archetype", "At 3rd level, you choose an archetype that you strive to emulate: Hunter or Beast Master."),
				new Feature("Primeval Awareness", "Beginning at 3rd level, you can use your action and expend on ranger spell slot to focus your awareness on the region around you. For 1 minute per level of the spell slot you expend, you can sense whether the following types of creatures are present within 1 mile of you (or within up to 6 miles if you are in your favored terrain): aberrations, celestials, dragons, elementals, fey, fiends, and undead. This feature doesn't reveal the creatures' location or number."),
				new Feature("Ability Score Improvement", "When you reach 4th, 8th, 12th, 16th, and 19th level, you can increase one ability score by 2, or increase two ability scores by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Extra Attack", "Beginning at 5th level, you can attack twice, instead of once whenever you take the Attack aciont on you turn."),
				new Feature("Land's Stride", "Starting at 8th level, moving through nonmagical difficult terrain costs you no extra movement. You can also pass through nonmagical plants with being slowed by them and without taking damage from them if they have throns, spines, or a similar hazard.\n"
						+ "In addition, you have advantage on saving throws against plants that are magically created or manipulated to impede movement."),
				new Feature("Hide in Plain Sight", "Starting at 10th level, you can spend 1 minute creating camoflauge for yourself. You must have access to fresh mud, dirt, plants, soot, and other naturally occurring materials with which to create your camouflage."),
				new Feature("Vanish", "Starting at 14th level, you can use the Hide action as a bonus action on you turn. Also you can't be tracked by nonmagical means, unless you choose to leave a trail."),
				new Feature("Feral Senses", "At 18th level, you gain preternatural senses that help you fight creatures you can't see. When you attack a creature you can't see, your inability to see it doesn't impose disadvantage on your attack rolls against it.\n"
						+ "You are alos aware of the location of any invisible creature within 30 feet of you, provided that the creature isn't hidden from you and you aren't blinded or deafened."),
				new Feature("Foe Slayer", "At 20th level, once on each of your turns , you can add your WIS mod to the attack roll or the damage roll of an attack you make against one of your favored enemies. You can choose to use this feature before or after the roll, but before any effects of the roll are applied."));
	}
	
	private static List<Feature> getRogueFeatures()
	{
		return Arrays.asList(new Feature("Expertise", "At 1st level, choose two of your skill proficiencies, or one of your skill proficiencies and your proficiency with thieves' tools. Your proficiency bonus is doubled for any ability check you make that uses either of the chosen proficiencies.\n"
						+ "At 6th level, you can choose two more of your proficiencies (in skills or thieves' tools) to gain this benefit."),
				new Feature("Thieves' Cant", "During your rogue training you learned a secret mix of dialect, jargon, and code that allows you to hide messages in seemingly normal conversation. It takes four times longer to convey such a message than it does to speak the same idea plainly.\n"
						+ "In addition, you understand a set of secret signs and symbols used to convey short, simple messages."),
				new Feature("Cunning Action", "Starting at 2nd level, you can take a bonus action on each of your turns in combat to Dash, Disengage, or Hide."),
				new Feature("Roguish Archetype", "At 3rd level, you choose an arcetype that you emulate in the exercise of your rogue abilities: Thief, Assassin, or Arcane Trickster."),
				new Feature("Ability Score Improvement", "When you reach 4th, 8th, 10th, 12th, 16th, or 19th level, you can increase an ability score of your choice by 2, or increase two ability scores by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Uncanny Dodge", "Starting at 5th level, when an attacker that you can see hits you with an attack, you can use your reaction to halve the attack's damage against you."),
				new Feature("Evasion", "Beginning at 7th level, when you are subjected to an effect that allows you to make a DEX saving throw to take half damage, you instead take no damage if you succeed, and only half damage if you fail."),
				new Feature("Reliable Talent", "By 11th level, whenever you make an ability check that lets you add your proficiency bonus, you can treat a d20 roll of 9 or lower as a 10."),
				new Feature("Blindsense", "Starting at 14th level, if you are able to hear, you are aware of the location of any hidden or invisible creature within 10 feet of you."),
				new Feature("Slippery Mind", "By 15th level, you gain proficiency in Wisdom saving throws."),
				new Feature("Stroke of Luck", "At 20th level, if your attack misses a target within range, you can turn the miss into a hit. Alternatively, if you fail an ability check, you can treat the d20 roll as a 20. Once you use this feature, you can't use it again until you finish a short or long rest."));
	}
	
	private static List<Feature> getSorcererFeatures()
	{
		return Arrays.asList(new Feature("Spellcasting", "An event in your past, or in the life of a parent or ancestor, left an idelible mark on you, infusing you with arcane magic."),
				new Feature("Sorcerous Origin", "Choose a sorcerous origin, which describes the source of your innate magical power: Draconic Bloodline or Wild Magic."),
				new Feature("Font of Magic", "At 2nd level, you tap into a deep wellspring of magic within yourself (represented by sorcery points).\n"
						+ "You start with 2 sorcery points, and gain more as you reach higher levels. You regain all spent sorcery points when you finish a long rest.\n"
						+ "You can use your sorcery points to gain additional spell slots, or sacrifice spell slots to gain additional sorcery points."),
				new Feature("Metamagic", "At 3rd, 10th, and 17th levels, you gain the ability to twist your spells to suit your needs."),
				new Feature("Ability Score Improvement", "When you reach 4th, 8th, 12th, 16th, and 19th levels, you can increase one ability score by 2, or increase two ability scores by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Sorcerous Restoration", "At 20th level, you regain 4 expended sorcery points whenever you finish a short rest."));
	}
	
	private static List<Feature> getWarlockFeatures()
	{
		return Arrays.asList(new Feature("Otherworldly Patron", "At 1st level, you have struck a bargain with an otherworldly being of your choice: the Archfey, the Fiend, or the Greate Old One."),
				new Feature("Pact Magic", "Your arcane research and the magic bestowed on you by your patron have given you facility with spells."),
				new Feature("Eldritch Invocations", "At 2nd level, you gain two eldritch invocations of your choice. You gain additional invocations as you gain more warlock levels. Additionally, when you gain a level int this class, you can choose one of the invocations you know and replace it with another invocation that you could learn at that level."),
				new Feature("Pact Boon", "At 3rd level, your otherworldly patron bestows a gift upon you for your loyal service."),
				new Feature("Ability Score Improvement", "When you reach 4th, 8th, 12th, 16th, and 19th levels, you can increase one ability score by 2, or increase two ability scores by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Mystic Arcanum", "At 11th level, choose one 6th-level spell from the warlock spell list. You can cast this spell once without expending a spell slot. You must finish a long rest before you can do so again.\n"
						+ "At higher levels, you gain more spells of your choice that can be cast in this way: one 7th-level spell at 13th level, one 8th-level spell at 15th-level, and one 9th-level spell at 17th level. You regain all uses when you finish a long rest."),
				new Feature("Eldritch master", "At 20th level, You can spend 1 minute entreating your patron for aid to regain all your expended spell slots from your Pact Magic feature. You must finish a long rest before you can do this again."));
	}
	
	private static List<Feature> getWizardFeatures()
	{
		return Arrays.asList(new Feature("Spellcasting", "As a student of arcane magic, you have a spellbook containing spells that show the first glimmerings of your true power."),
				new Feature("Arcane Recovery", "Oncer per day when you finish a short rest, you can choose expended spell slots to recover. The spell slots can have a combined level that is equal to or less than half your wizard level (rounded up), and none of the slots can be 6th level or higher."),
				new Feature("Arcane Tradition", "When you reach 2nd level, you can choose an arcane tradition, shaping your practice of magic through one of eight schools: Abjuration, Conjuration, Divination, Enchantment, Evocation, Illusion, Necromancy, or Transmutation."),
				new Feature("Ability Score Imporvement", "When you reach 4th, 8th, 12th, 16th, and 19th levels, you can increase on ability score by 2, or increase two ability scores by 1. You can't increase an ability score above 20 using this feature."),
				new Feature("Spell Mastery", "At 18th level, choose a 1st-level wizard spell and a 2nd-level wizrd spell that are in your spell book. You can cast those spells at their lowest level without expending a spell slot when you have them prepared. If you want to cast either spell at a higher level, you must expend a spell slot as normal.\n"
						+ "By spending 8 hours in study, you can exchange one or both of the spells you chose for different spells of the same levels."),
				new Feature("Signature Spells", "When you reach 20th level, choose two 3rd-level wizard spells in your spellbook as signature spells. You always have these spells prepared, they don't count against the number of spells you ahve prepared, and you can cast each of them once 3rd level without expending a spell slot. When you do so, you can't do so again until you finish a short or long rest. If you want to cast either spell at a higher level, you must expend a spell slot as normal."));
	}
}
