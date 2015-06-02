package musician101.mcdnd.clazz.features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import musician101.mcdnd.clazz.CharacterClasses;
import musician101.mcdnd.util.CustomHashMap;

public class Features
{
	Map<CharacterClasses, List<Feature>> map = new CustomHashMap<CharacterClasses, List<Feature>>()
			.add(CharacterClasses.BARBARIAN, getBarbarianFeatures()).add(CharacterClasses.BARD, getBardFeatures())
			.add(CharacterClasses.CLERIC, getClericFeatures()).add(CharacterClasses.DRUID, getDruidFeatures())
			.add(CharacterClasses.FIGHTER, getFighterFeatures()).add(CharacterClasses.MONK, getMonkFeatures());
	
	private List<Feature> getBarbarianFeatures()
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
	
	private List<Feature> getBardFeatures()
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
	
	private List<Feature> getClericFeatures()
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
	
	private List<Feature> getDruidFeatures()
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
	
	private List<Feature> getFighterFeatures()
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
	
	private List<Feature> getMonkFeatures()
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
}
