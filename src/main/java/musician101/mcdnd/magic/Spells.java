package musician101.mcdnd.magic;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.MappedSpell.MultipleSpellSlotSpell;
import musician101.mcdnd.magic.MappedSpell.ScaleableDamageSpell;
import musician101.mcdnd.magic.Spell.RitualSpell;
import musician101.mcdnd.magic.Spell.SpellLevel;
import musician101.mcdnd.magic.Spell.SpellType;
import musician101.mcdnd.util.CustomHashMap;

public class Spells
{
	public static final Spell ACID_SPLASH = new ScaleableDamageSpell<Integer>("Acid Splash", SpellType.CONJURATION, SpellLevel.CANTRIP, -1, 60, true, true, false, new CustomHashMap<Integer, Dice>().add(1, new Dice(6)).add(5, new Dice(6, 2)).add(11, new Dice(6, 3)).add(17, new Dice(6, 4)), DamageType.ACID, "You hurl a bubble of acid. Choose on creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.");
	public static final Spell AID = new MultipleSpellSlotSpell("Aid", SpellType.ABJURATION, SpellLevel.LEVEL_2, -1, 30, true, true, "a tiny strip of whtie cloth", 28800, false, new CustomHashMap<SpellLevel, Integer>().add(SpellLevel.LEVEL_2, 5).add(SpellLevel.LEVEL_3, 10)
			.add(SpellLevel.LEVEL_4, 15).add(SpellLevel.LEVEL_5, 20).add(SpellLevel.LEVEL_6, 25).add(SpellLevel.LEVEL_7, 30).add(SpellLevel.LEVEL_8, 35).add(SpellLevel.LEVEL_9, 40), SpellLevel.LEVEL_3, "Your spell bolsters your allies with toughness and resolve. Choose up to three creatures within range. Each target's hit point maximum and current hit points increase by 5 for the duration.\nAT HIGHER LEVELS. When you cast this spell using a spell slot of 3rd level or higher, a target's hit points increase by an additional 5 for each slot level above 2nd.");
	public static final Spell BEAST_SENSE = new RitualSpell("Beast Sense", SpellType.DIVINATION, SpellLevel.LEVEL_2, -1, 0, false, true, "", 3600, true, "You touch a willing beast. For the duration of the spell, you can use your action to see through the beast's eyes and hear what it hears, and continue to do so until you use your action to return to your normal senses.\n" +
			"While perceiving through the beast's senses, you gain the benefits of any special senses possessed by that creature, though you are blinded and deafened to your own surroundings.");
	public static final Spell DANCING_LIGHTS = new Spell("Dancing Lights", SpellType.EVOCATION, SpellLevel.CANTRIP, -1, 120, true, true, "a bit of phosphorus or wychwood, or a glowworm", 60, true, "You create up to four torch-sized lights within range, making them appear as torches, lanterns, or glowing orbs that hover in the air for the duration. You can also combine the four lights into one glowing vaguely humanoid form of Medium size. Whichever form you choose, each light sheds dim light in a 10-foot radius.\n" +
			"As a Bonus action on your turn, you can move the lights up to 60 feet to a new spot within range. A light must be within 20 feet of anther light created by this spell, and a light winks out if it exceeds the spell's range.");
	public static final Spell DARKNESS = new Spell("Darkness", SpellType.EVOCATION, SpellLevel.LEVEL_2, -1, 60, true, false, "bat fur and a drop of pitch or piece of coal", 600, true, "Magical darkness spreads from a point you choose within range to fill a 15-foot-radius sphere for the duration. The darkness spreads around corners. A creature with darkvision can't see through this darkness, and nonmagical light can't illuminate it.\n" +
			"If the point you choose is on an object you are holding or one that isn't being worn or carried, the darkness emanates from the object and moves with it. Completely covering the source of the darkness with an opaque object, such as a bowl or a helm, blocks the darkness.\nIf any of this spell's are overlaps with an area of light created by a spell of 2nd level or lower, the spell that created the light is dispelled.");
	public static final Spell FAERIE_FIRE = new DCSaveSpell("Faerie Fire", SpellType.EVOCATION, SpellLevel.LEVEL_1, -1, 60, false, false, 60, true, AbilityScores.DEX, "Each object in a 20-foot cube within range is outlined in blue, green, or violet light (your choice). Any creature in the area when the spell is cast is also outlined in light if it fails a Dexterity saving throw. For the duration, objects and affected creatures shed dim light in a 10-foot radius.\n" +
			"Any attack roll against an affected creature or object has advantage if the attacker can see it, and the affected creature or object can't benefit from being invisible.");
	public static final Spell MINOR_ILLUSION = new DCSaveSpell("Minor Illusion", SpellType.ILLUSION, SpellLevel.CANTRIP, -1, 30, false, true, "a bit of fleece", 60, false, AbilityScores.INT, "You create a sound or an image of an object within range that lasts for the duration. The illusion also ends if you dismiss it as an action or cast this spell again.\n" + 
			"If you create a sound, its volume can range from a whisper to a scream. It can be your voice, someone else's voice, a lion's roar, a beating of drums, or any other sound you choose. The sound continues unabated throught the duration, or you can make discreate sounds at different times before the spell ends.\n" + 
			"If you create an image of an object-such as a chair, muddy footprints, or a small chest-it must be no larger than a 5-foot cube. The image can't create sound, light, smell, or any other sensory effect. Physical interaction with the image reveals it to be an illusion, because things can pass through it.\n" + 
			"If a creature uses its action to examine the sound or image, the creature can determine that it is an illusion with a successful Intelligence (Investigation) check against your spell save DC. If a creature discerns the illusion for what it is, the illusion becomes faint to the creature.");
	public static final Spell HELLISH_REBUKE = new ScaleableDamageSpell<SpellLevel>("Hellish Rebuke", SpellType.EVOCATION, SpellLevel.LEVEL_1, -1, 60, true, true, false, new CustomHashMap<SpellLevel, Dice>().add(SpellLevel.LEVEL_1, new Dice(10, 2)).add(SpellLevel.LEVEL_2, new Dice(10, 3)).add(SpellLevel.LEVEL_3, new Dice(10, 4)).add(SpellLevel.LEVEL_4, new Dice(10, 5)).add(SpellLevel.LEVEL_5, new Dice(10, 6)).add(SpellLevel.LEVEL_6, new Dice(10, 7)).add(SpellLevel.LEVEL_7, new Dice(10, 8)).add(SpellLevel.LEVEL_8, new Dice(10, 9)).add(SpellLevel.LEVEL_9, new Dice(10, 10)),
			DamageType.FIRE, "You point your finger, and the creature that damaged you is momentarily surrounded by hellish flames. The creature must make a Dexterity saving throw. It takes 2d10 fire damage on a failed save, or half as much damage on a successful one.\n" +
			"At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d10 for each slot level above 1st.");
	public static final Spell SPEAK_WITH_ANIMALS = new RitualSpell("Speak with Animals", SpellType.DIVINATION, SpellLevel.LEVEL_1, -1, 0, true, true, "", 600, false, "You gain the ability to comprehend and verbally communicate with beasts for the duration. The knowledge and awareness of many beasts is limited by their intelligence, but at minimum, beasts can give you information about neaby locations and monsters, including whatever they can perceive or have perceived within the past day. You might be able to persuade a beast to perform a small favor for you, at the DM's discretion.");
	public static final Spell THAUMATURGY = new Spell("Thaumaturgy", SpellType.TRANSMUTATION, SpellLevel.CANTRIP, -1, 30, true, false, "", 60, false, "You manifest a minor wonder, a sign of supernatural power, within range. You create one of the following magical effects within range:\n" + 
			"- Your voice booms up to three times as loud as normal for 1 minute.\n" + 
			"- You cause flames to flicker, brighten, dim, or change color for 1 minute.\n" +
			"- You cause harmless tremors in the ground for 1 minute.\n" +
			"- You create an instantaneous sound that originates from a point of your choice within range, such as a rumble of thunder, the cry of a raven, or ominous whispers.\n" +
			"- You instantaneously cause an unlocked door or window to fly open or slam shut.\n" +
			"- You alter the appearance of your eyes for 1 minute.\n" +
			"If you cast this spell multiple times, you can have up to three of its 1 minute effects active at a time, and you can dismiss such an effect as an action.");
}
