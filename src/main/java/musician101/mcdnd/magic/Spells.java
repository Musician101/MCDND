package musician101.mcdnd.magic;

import java.util.Arrays;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.lib.Reference.ActionTimes;
import musician101.mcdnd.magic.MappedSpell.MultipleSpellSlotSpell;
import musician101.mcdnd.magic.MappedSpell.ScaleableDamageSpell;
import musician101.mcdnd.magic.Spell.RitualSpell;
import musician101.mcdnd.magic.Spell.SpellLevel;
import musician101.mcdnd.magic.Spell.SpellType;
import musician101.mcdnd.util.CustomMap;

public class Spells
{
	public static final Spell ACID_SPLASH = new ScaleableDamageSpell<Integer>("Acid Splash", SpellType.CONJURATION, SpellLevel.CANTRIP, ActionTimes.ACTION, 60, true, true, "", 0, false,
			new CustomMap<Integer, Dice>().add(1, new Dice(6)).add(5, new Dice(6, 2)).add(11, new Dice(6, 3)).add(17, new Dice(6, 4)), DamageType.ACID,
			"You hurl a bubble of acid. Choose on creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.");
	public static final Spell AID = new MultipleSpellSlotSpell("Aid", SpellType.ABJURATION, SpellLevel.LEVEL_2, ActionTimes.ACTION, 30, true, true, "a tiny strip of whtie cloth", 28800, false,
			new CustomMap<SpellLevel, Integer>().add(SpellLevel.LEVEL_2, 5).add(SpellLevel.LEVEL_3, 10).add(SpellLevel.LEVEL_4, 15).add(SpellLevel.LEVEL_5, 20).add(SpellLevel.LEVEL_6, 25).add(SpellLevel.LEVEL_7, 30).add(SpellLevel.LEVEL_8, 35).add(SpellLevel.LEVEL_9, 40), SpellLevel.LEVEL_3,
			"Your spell bolsters your allies with toughness and resolve. Choose up to three creatures within range. Each target's hit point maximum and current hit points increase by 5 for the duration.",
			"AT HIGHER LEVELS. When you cast this spell using a spell slot of 3rd level or higher, a target's hit points increase by an additional 5 for each slot level above 2nd.");
	public static final Spell ARCANE_EYE = new Spell("Arcane Eye", SpellType.DIVINATION, SpellLevel.LEVEL_4, ActionTimes.ACTION, 30, true, true, "a bit of bat fur", 3600, true,
			"You create an invisible, magical eye within range that hovers in the air for the duration.",
			"You mentally receive visual information from the eye, which has a normal vision and darkvision out to 30 feet. The eye can look in every direction.",
			"As an action, you can move the eye up to 30 feet in any direction. There is no limit to how far away from you the eye can move, but it can't enter another plane of existence. A solid barrier blocks the eye's movement, but the eye can pass through an opening as small as 1 inch in diameter.");
	public static final Spell AUGURY = new RitualSpell("Augury", SpellType.DIVINATION, SpellLevel.LEVEL_2, 60, 0, true, true, "specially marked sticks, bones, or similar tokens worth at least 25 gp", 0, false,
			"By casting gem-inlaid sticks, rolling dragon bones, laying out ornate cards, or employing some other divining tool, you receive an omen from an otherworldly entity about the results of a specific course of action that you plan to take within the next 30 minutes. The DM chooses from the following possible omens:",
			"- Weal, for good resultes",
			"- Woe, for bad results",
			"- Weal and woe, for both good and bad results",
			"- Nothing, for results that aren't especially good or bad",
			"The spell doesn't take into account any possible circumstances that might change the outcome, such as the casting of additional spells or the loss or gain of a companion.",
			"If you cast the spell two or more times before completing your next long rest, there is a cumulative 25 percent chance for each casting after the first that you get a random reading. The DM makes this roll in secret.");
	public static final Spell BEACON_OF_HOPE = new Spell("Beacon of Hope", SpellType.ABJURATION, SpellLevel.LEVEL_3, ActionTimes.ACTION, 30, true, true, "", 60, true,
			"This spell bestows hope and vitality. Choose any number of creatures within range. For the duration, each target has advantage on Wisdom saving throws and death saving throws, and regains the maximum number of hit points possible from any healing.");
	public static final Spell BEAST_SENSE = new RitualSpell("Beast Sense", SpellType.DIVINATION, SpellLevel.LEVEL_2, ActionTimes.ACTION, 0, false, true, "", 3600, true,
			"You touch a willing beast. For the duration of the spell, you can use your action to see through the beast's eyes and hear what it hears, and continue to do so until you use your action to return to your normal senses.",
			"While perceiving through the beast's senses, you gain the benefits of any special senses possessed by that creature, though you are blinded and deafened to your own surroundings.");
	public static final Spell BLESS = new MultipleSpellSlotSpell("Bless", SpellType.ENCHANTMENT, SpellLevel.LEVEL_1, ActionTimes.ACTION, 30, true, true, "a sprinkling of holy water", 60, true,
			new CustomMap<SpellLevel, Integer>().add(SpellLevel.LEVEL_1, 1).add(SpellLevel.LEVEL_2, 2).add(SpellLevel.LEVEL_3, 3).add(SpellLevel.LEVEL_4, 4).add(SpellLevel.LEVEL_5, 5).add(SpellLevel.LEVEL_6, 6).add(SpellLevel.LEVEL_7, 7).add(SpellLevel.LEVEL_8, 8).add(SpellLevel.LEVEL_9, 9), SpellLevel.LEVEL_2,
			"You bless up to three creatures of your choice within range. Whenever a target makes an attack roll or a saving throw before the spell ends, the target can roll a d4 and add the number rolled to the attack roll or saving throw.",
			"At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level above 1st.");
	public static final Spell COMMAND = new MultipleSpellSlotSpell("Command", SpellType.ENCHANTMENT, SpellLevel.LEVEL_1, ActionTimes.ACTION, 60, true, false, "", 6, false,
			new CustomMap<SpellLevel, Integer>().add(SpellLevel.LEVEL_1, 1).add(SpellLevel.LEVEL_2, 2).add(SpellLevel.LEVEL_3, 3).add(SpellLevel.LEVEL_4, 4).add(SpellLevel.LEVEL_5, 5).add(SpellLevel.LEVEL_6, 6).add(SpellLevel.LEVEL_7, 7).add(SpellLevel.LEVEL_8, 8).add(SpellLevel.LEVEL_9, 9), SpellLevel.LEVEL_2,
			"- You speak a one-word command to a creature you can see within range. The target must succeed on a Wisdom saving throw or follow the command on its next turn. The spell has no effect if the target is undead, if it doesn't understand your language, or if your command is directly harmful to it.",
			"- Some typical commands and their effects follow You might issue a command other than one described here. If you do so, the DM determines how the target behaves. If the target can't follow your command, the spell ends.",
			"- Approach: The target moves toward you by the shortest and most direct route, ending its turn if it moves within 5 feet you.",
			"- Drop: The target drops whatever it is holding end then ends its turn.",
			"- Flee: The target spends its turn moving away from you by the fastest available means.",
			"- Grovel: The target falls prone and then ends its turn.",
			"- Halt: The target doesn't move and takes no actions. A flying creature stays aloft, provided that it is able to do so. If it must move to stay aloft, it flies the minimum distance needed to remain in the air.",
			"At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can affect one additional creature for each slot level above 1st. The creatures must be within 30 feet of each other when you target them.");
	public static final Spell COMMUNE_WITH_NATURE = new RitualSpell("Commune with Nature", SpellType.DIVINATION, SpellLevel.LEVEL_5, 60, 0, true, true, "", 0, false,
			"You briefly become one with nature and gain knowledge of the surrounding territory. In the outdoors, the spell gives you knowledge of the land within 3 miles of you. In caves and other natural underground settings, the radius is limited to 300 feet. The spell doesn't function where nature has been replaced by construction, such as in dungeons and towns.",
			"You instantly gain knowledge of up to three facts of your choice about any of the following subjects as they relate to the area:",
			"- terrain and bodies of water", "- prevalent plants, minerals, animals, or peoples", "- influence from other planes of existence", "- buildings",
			"For example, you could determine the location of powerful undead in the are, the location of major sources of safe drinking water, and the location of any nearby towns.");
	public static final Spell CONFUSION = new ConfusionSpell();
	public static final Spell CURE_WOUNDS = new MultipleSpellSlotSpell("Cure Wounds", SpellType.EVOCATION, SpellLevel.LEVEL_1, ActionTimes.ACTION, 0, true, true, "", 0, false,
			new CustomMap<SpellLevel, Integer>().add(SpellLevel.LEVEL_1, 1).add(SpellLevel.LEVEL_2, 2).add(SpellLevel.LEVEL_3, 3).add(SpellLevel.LEVEL_4, 4).add(SpellLevel.LEVEL_5, 5).add(SpellLevel.LEVEL_6, 6).add(SpellLevel.LEVEL_7, 7).add(SpellLevel.LEVEL_8, 8).add(SpellLevel.LEVEL_9, 9), SpellLevel.LEVEL_2,
			"A creature you touch regains a number of hit points equal to 1d8 + your spellcasting ability modifier. This spell has no effect on undead or constructs.",
			"At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the healing increases by 1d8 for each slot level above 1st.");
	public static final Spell DANCING_LIGHTS = new Spell("Dancing Lights", SpellType.EVOCATION, SpellLevel.CANTRIP, ActionTimes.ACTION, 120, true, true, "a bit of phosphorus or wychwood, or a glowworm", 60, true,
			"You create up to four torch-sized lights within range, making them appear as torches, lanterns, or glowing orbs that hover in the air for the duration. You can also combine the four lights into one glowing vaguely humanoid form of Medium size. Whichever form you choose, each light sheds dim light in a 10-foot radius.",
			"As a Bonus action on your turn, you can move the lights up to 60 feet to a new spot within range. A light must be within 20 feet of anther light created by this spell, and a light winks out if it exceeds the spell's range.");
	public static final Spell DARKNESS = new Spell("Darkness", SpellType.EVOCATION, SpellLevel.LEVEL_2, ActionTimes.ACTION, 60, true, false, "bat fur and a drop of pitch or piece of coal", 600, true,
			"Magical darkness spreads from a point you choose within range to fill a 15-foot-radius sphere for the duration. The darkness spreads around corners. A creature with darkvision can't see through this darkness, and nonmagical light can't illuminate it.",
			"If the point you choose is on an object you are holding or one that isn't being worn or carried, the darkness emanates from the object and moves with it. Completely covering the source of the darkness with an opaque object, such as a bowl or a helm, blocks the darkness.",
			"If any of this spell's are overlaps with an area of light created by a spell of 2nd level or lower, the spell that created the light is dispelled.");
	public static final Spell DEATH_WARD = new Spell("Death Ward", SpellType.ABJURATION, SpellLevel.LEVEL_4, ActionTimes.ACTION, 0, true, true, "", 28800, false,
			"You touch a creature and grant it a measure of protection from death.",
			"The first time the target would drop to 0 hit points as a result of taking damage, the target instead drops to 1 hit point, and the spell ends.",
			"If the spell is still in effect when the target is subjected to an effect that would kill it instantaneously without dealing damage, that effect is instead negated against the target, and the spell ends.");
	public static final Spell FAERIE_FIRE = new DCSaveSpell("Faerie Fire", SpellType.EVOCATION, SpellLevel.LEVEL_1, ActionTimes.ACTION, 60, false, false, "", 60, true, AbilityScores.DEX,
			"Each object in a 20-foot cube within range is outlined in blue, green, or violet light (your choice). Any creature in the area when the spell is cast is also outlined in light if it fails a Dexterity saving throw. For the duration, objects and affected creatures shed dim light in a 10-foot radius.",
			"Any attack roll against an affected creature or object has advantage if the attacker can see it, and the affected creature or object can't benefit from being invisible.");
	public static final Spell GUARDIAN_OF_FAITH = new DCSaveSpell("Guardian of Faith", SpellType.CONJURATION, SpellLevel.LEVEL_4, ActionTimes.ACTION, 30, true, false, "", 28800, false, AbilityScores.DEX,
			"A Large spectral guardian appears and hovers for the duration in an unoccupied space of your choice that you can see within range. The guardian occupies that space and is indistinct except for a gleaming sword and shield emblazoned with the symbol of your deity.",
			"Any creature hostile to you that moves to a space within 10 feet of the guardian for the first time on a turn must succeed on a Dexterity saving throw. The creature takes 20 radiant damage on a failed save, or half as much damage on a successful one. The guardian vanishes when it has dealth a total of 60 damage.");
	public static final Spell HELLISH_REBUKE = new ScaleableDamageSpell<SpellLevel>("Hellish Rebuke", SpellType.EVOCATION, SpellLevel.LEVEL_1, ActionTimes.REACTION, 60, true, true, "", 0, false,
			new CustomMap<SpellLevel, Dice>().add(SpellLevel.LEVEL_1, new Dice(10, 2)).add(SpellLevel.LEVEL_2, new Dice(10, 3)).add(SpellLevel.LEVEL_3, new Dice(10, 4)).add(SpellLevel.LEVEL_4, new Dice(10, 5)).add(SpellLevel.LEVEL_5, new Dice(10, 6)).add(SpellLevel.LEVEL_6, new Dice(10, 7)).add(SpellLevel.LEVEL_7, new Dice(10, 8)).add(SpellLevel.LEVEL_8, new Dice(10, 9)).add(SpellLevel.LEVEL_9, new Dice(10, 10)),
			DamageType.FIRE, "You point your finger, and the creature that damaged you is momentarily surrounded by hellish flames. The creature must make a Dexterity saving throw. It takes 2d10 fire damage on a failed save, or half as much damage on a successful one.",
			"At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d10 for each slot level above 1st.");
	public static final Spell IDENTIFY = new RitualSpell("Identify", SpellType.DIVINATION, SpellLevel.LEVEL_1, 60, 0, true, true, "a pearl worth at least 100 gp and an owl feather", 0, false,
			"You choose on object that you must touch throughout the casting of th espell. If it is a magic item or some other magic-imubed object, you learn its properties and how to use them, whether it requires attunement to use, and how many charges it has, if any. You learn whether any spells are affecting the item and what they are. If the item was created by a spell, you learn which spell created it.",
			"If you instead touch a creature throughout the casting, you learn what spells, if any, are currently affecting it.");
	public static final Spell LEGEND_LORE = new Spell("Legend Lore", SpellType.DIVINATION, SpellLevel.LEVEL_5, 600, 0, true, true, "incense worth at least 250 gp, which the spell consumes, and four ivory strips worth at least 50 gp each", 0, false,
			"Name or describe a person, place, or object. The spell brings to your mind a brief summary of the significant lore about the thing you named. The lore might consist of current tales, forgotten stories, or even secret lore that has never been widely known. If the thing you named isn't of legendary importance, you gain no information. The more information you already have about the thing, the more precies and detailed the information you receive is.",
			"The information you learn is accurate but might be couched in figurative language. For example, if you have a mysterious magic axe on hand, the spell might yield this information: \"Woe to the evildoer whose hand touches the axe, for even the haft slices the hand of the evil ones. Only a true Child of Stone, lover and beloved of Moradin, may awaken the true powers of the axe, and only with the sacred word Rudnogg on the lips.\"");
	public static final Spell LESSER_RESTORATION = new Spell("Lesser Restoration", SpellType.ABJURATION, SpellLevel.LEVEL_2, ActionTimes.ACTION, 0, true, true, "", 0, false,
			"You touch a creature and can end either one disease or one condition afflicting it. The condition can be blinded, deafened, paralyzed, or poisoned.");
	public static final Spell MASS_CURE_WOUNDS = new MultipleSpellSlotSpell("Mass Cure Wounds", SpellType.CONJURATION, SpellLevel.LEVEL_5, ActionTimes.ACTION, 60, true, true, "", 0, false,
			new CustomMap<SpellLevel, Integer>().add(SpellLevel.LEVEL_5, 3).add(SpellLevel.LEVEL_6, 4).add(SpellLevel.LEVEL_7, 5).add(SpellLevel.LEVEL_8, 6).add(SpellLevel.LEVEL_9, 7), SpellLevel.LEVEL_5,
			"A wave of healing energy washes out from a point of your choice within range. Choose up to six creatures in a 30-foot-radius sphere centered on that point. Each target regains hit points equal to 3d8 + your spellcasting ability modifier. This spell has no effect on undead or constructs.",
			"At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the healing increases by 1d8 for each slot level above 5th.");
	public static final Spell MINOR_ILLUSION = new DCSaveSpell("Minor Illusion", SpellType.ILLUSION, SpellLevel.CANTRIP, ActionTimes.ACTION, 30, false, true, "a bit of fleece", 60, false, AbilityScores.INT,
			"You create a sound or an image of an object within range that lasts for the duration. The illusion also ends if you dismiss it as an action or cast this spell again.", 
			"If you create a sound, its volume can range from a whisper to a scream. It can be your voice, someone else's voice, a lion's roar, a beating of drums, or any other sound you choose. The sound continues unabated throught the duration, or you can make discreate sounds at different times before the spell ends.", 
			"If you create an image of an object-such as a chair, muddy footprints, or a small chest-it must be no larger than a 5-foot cube. The image can't create sound, light, smell, or any other sensory effect. Physical interaction with the image reveals it to be an illusion, because things can pass through it.", 
			"If a creature uses its action to examine the sound or image, the creature can determine that it is an illusion with a successful Intelligence (Investigation) check against your spell save DC. If a creature discerns the illusion for what it is, the illusion becomes faint to the creature.");
	public static final Spell NONDETECTION = new Spell("Nondetection", SpellType.ABJURATION, SpellLevel.LEVEL_3, ActionTimes.ACTION, 0, true, true, "a pinch of diamond dust worth 25 gp sprinkled over the target, which the spell consumes)", 28800, false,
			"For the duration, you hide a target that you touch from divination magic. The target can be a willing creature or a place or an object no larger than 10 feet in any dimension. The target can't be targeted by any divination magic or perceived through magical scrying sensors.");
	public static final Spell RAISE_DEAD = new Spell("Raise Dead", SpellType.NECROMANCY, SpellLevel.LEVEL_5, 3600, 0, true, true, "a diamond worth at least 500 gp, which the spell consumes", 0, false,
			"You return a dead creature you touch to life, provided that it has been dead no longer than 10 days. If the creature's soul is both willing and at liberty to rejoin the body, the creature returns to life with 1 hit point.",
			"This spell also neutralizes any poisons and cures nonmagical diseases that affected the creature at the time it died. This spell doesn't, however, remove magical diseases, curses, or similar effects; if these aren't first removed prior to casting the spell, they take effect when the creature returns to life.",
			"This spell closes all mortal wounds, but it doesn't restore missing body parts. If the creature is lacking body parts or organs integral for its survival-its hea, for instance-the spell automatically fails.",
			"Coming back from the dead is an ordeal. The target takes a -4 penalty to all attack rolls, saving throws, and ability checks. Every time the target finishes a long rest, the penalty is reduced by 1 until it disappears.");
	public static final Spell REVIVIFY = new Spell("Revivify", SpellType.CONJURATION, SpellLevel.LEVEL_3, ActionTimes.ACTION, 0, true, true, "diamonds worth 300 gp, which the spell consumes", 0, false,
			"You touch a creature that has died within the last minute. That creature returns to life with 1 hit point. This spell can't return to life a creature that has died of old age, nor can it restore any missing body parts.");
	public static final Spell SCRYING = new ScryingSpell();
	public static final Spell SPEAK_WITH_ANIMALS = new RitualSpell("Speak with Animals", SpellType.DIVINATION, SpellLevel.LEVEL_1, ActionTimes.ACTION, 0, true, true, "", 600, false,
			"You gain the ability to comprehend and verbally communicate with beasts for the duration. The knowledge and awareness of many beasts is limited by their intelligence, but at minimum, beasts can give you information about neaby locations and monsters, including whatever they can perceive or have perceived within the past day. You might be able to persuade a beast to perform a small favor for you, at the DM's discretion.");
	public static final Spell SPEAK_WITH_DEAD = new Spell("Speak with Dead", SpellType.NECROMANCY, SpellLevel.LEVEL_3, ActionTimes.ACTION, 10, true, true, "burning incense", 600, false,
			"You grant the semblance of life and intelligence to a corpse of your choice within range, allowing it to answer the questions you pose. The corpse must still have a and can't be undead. The spell fails if the corpse was the target of this spell within the last 10 days.",
			"Until the spell ends, you can ask the corpse up to five questions. The corpse knows only what it knew in life, including the languages it knew. Answeres are usually brief, cryptic, or repetitive, and the corpse is under no compulsion to offer a truthful answer if you are hostile to it or it recognizes you as an enemy. This spell doesn't return the creature's soul to its body, only its animating spirit. Thus, the corpse can't learn new information, doesn't comprehend anything that has happened since it died, and can't speculate about future events.");
	public static final Spell SPIRITUAL_WEAPON = new ScaleableDamageSpell<SpellLevel>("Spiritual Weapon", SpellType.EVOCATION, SpellLevel.LEVEL_2, ActionTimes.BONUS_ACTION, 60, true, true, "", 60, false,
			new CustomMap<SpellLevel, Dice>().add(Arrays.asList(SpellLevel.LEVEL_1, SpellLevel.LEVEL_2, SpellLevel.LEVEL_3), new Dice(8, 1)).add(SpellLevel.LEVEL_4, new Dice(8, 3)).add(SpellLevel.LEVEL_5, new Dice(8, 3)).add(SpellLevel.LEVEL_6, new Dice(8, 5)).add(SpellLevel.LEVEL_7, new Dice(8, 5)).add(Arrays.asList(SpellLevel.LEVEL_8, SpellLevel.LEVEL_9), new Dice(8, 7)), DamageType.FORCE,
			"You create a floating, spectral weapon within range that lasts for the duration or until you cast this spell again. When you cast the spell, you can make melee spell attack against a creature within 5 feet of the weapon. On a hit, the target takes force damage equal to 1d8 + your spellcasting ability modifier.",
			"As a bonus action on your turn, you can move the weapon up to 20 feet and repeat the attack against a creature within 5 feet of it.",
			"The weapon can take whatever form you choose. Clerics of deities who are associated with a particular weapon (as St. Curthbert is known for his mace and Thor for his hammer) make this spell's effect resemble that weapon.",
			"At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, the damage increases by 1d8 for every two slot levels above 2nd.");
	public static final Spell SUGGESTION = new Spell("Suggestions", SpellType.ENCHANTMENT, SpellLevel.LEVEL_2, ActionTimes.ACTION, 30, true, false, "a snake's tongue and either a hit of honeycomb or a drop of sweet oil", 28800, true,
			"You suggest a cours of activity (limited to a sentence or two) and magically influence a creature you can see within range that can hear and understand you. Creatures that can't be charmed are immune to this effect. The suggestion must be worded in such a manner as to make the course of action sound reasonable. Asking the creature to stab itself, throw itself onto a spea, immolate itself or do some other obviously harmful act ends the spell.",
			"The target must make a Wisdom saving throw. On a failed save, it pursues the course of action you described to the best of its ability. The suggested course of action can coninue for the duration. If the suggested activity can be completed in a shorter time, the spell ends when the subject finishes what it was asked to do.",
			"You can also specify conditions that will trigger a special activity during the duration. For example, you might suggest that a knight give her warhorse to the first beggar she meets. If the condition isn't met before the spell expires, the activity isn't performed.",
			"If you or any of your companions damage the targe, the spell ends.");
	public static final Spell THAUMATURGY = new Spell("Thaumaturgy", SpellType.TRANSMUTATION, SpellLevel.CANTRIP, ActionTimes.ACTION, 30, true, false, "", 60, false,
			"You manifest a minor wonder, a sign of supernatural power, within range. You create one of the following magical effects within range:", 
			"- Your voice booms up to three times as loud as normal for 1 minute.", 
			"- You cause flames to flicker, brighten, dim, or change color for 1 minute.",
			"- You cause harmless tremors in the ground for 1 minute.",
			"- You create an instantaneous sound that originates from a point of your choice within range, such as a rumble of thunder, the cry of a raven, or ominous whispers.",
			"- You instantaneously cause an unlocked door or window to fly open or slam shut.",
			"- You alter the appearance of your eyes for 1 minute.",
			"If you cast this spell multiple times, you can have up to three of its 1 minute effects active at a time, and you can dismiss such an effect as an action.");
}
