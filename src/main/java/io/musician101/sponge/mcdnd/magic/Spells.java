package io.musician101.sponge.mcdnd.magic;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.condition.Conditions;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.magic.spelleffect.AlterSelfSpellEffects;
import io.musician101.sponge.mcdnd.magic.spelleffect.AntimagicFieldSpellEffects;
import io.musician101.sponge.mcdnd.magic.spelleffect.AntipathySympathySpellEffects;
import io.musician101.sponge.mcdnd.magic.spelleffect.ControlWaterSpellEffects;
import io.musician101.sponge.mcdnd.race.Race.CharacterSize;
import io.musician101.sponge.mcdnd.util.ActionTimes;
import io.musician101.sponge.mcdnd.util.table.Table;

import java.util.Arrays;

import static io.musician101.sponge.mcdnd.combat.DamageTypes.ACID;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.BLUDGEONING;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.COLD;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.FIRE;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.FORCE;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.LIGHTNING;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.NECROTIC;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.PIERCING;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.POISON;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.RADIANT;
import static io.musician101.sponge.mcdnd.combat.DamageTypes.THUNDER;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.ABILITY_SCORE_TYPE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.AC_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.ATTACK_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.CONNECTION_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DAMAGE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DAMAGE_TYPE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DAMAGE_TYPES;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DEX_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.HP_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.KNOWLEDGE_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SAVE_MODIFIER_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SAVING_THROW;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SIZE_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_EFFECTS;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_LEVEL_DICE_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_LEVEL_DOUBLE_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_LEVEL_INTEGER_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.STR_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.TABLE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.TABLES;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.CONSTITUTION;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.DEXTERITY;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.INTELLIGENCE;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.STRENGTH;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.WISDOM;
import static io.musician101.sponge.mcdnd.data.type.skill.SkillTypes.PERCEPTION;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.CANTRIP;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L1;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L2;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L3;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L4;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L5;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L6;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L7;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L8;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellLevels.L9;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.ABJURATION;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.CONJURATION;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.DIVINATION;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.ENCHANTMENT;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.EVOCATION;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.ILLUSION;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.NECROMANCY;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.TRANSMUTATION;
import static io.musician101.sponge.mcdnd.magic.Spell.builder;
import static io.musician101.sponge.mcdnd.util.MapUtils.populateSpellLevelDiceMap;
import static io.musician101.sponge.mcdnd.util.MapUtils.populateSpellLevelDoubleMap;
import static io.musician101.sponge.mcdnd.util.MapUtils.populateSpellLevelIntegerMap;

//TODO reread all spells for missing properties and add shape as property
//TODO add spell lists (bard spell list, cleric spell list, etc.)
public class Spells
{
    public static final Spell ACID_SPLASH = builder().name("Acid Splash")
            .description("You hurl a bubble of acid. Choose on creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.", "This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).")
            .type(CONJURATION).level(CANTRIP).castingTime(ActionTimes.ACTION).range(60)
            .components(SpellComponents.of(true, true))
            .addProperty(SAVING_THROW, DEXTERITY).addProperty(DAMAGE_TYPE, ACID)
            .addProperty(MCDNDKeys.INTEGER_DICE_MAP, ImmutableMap.<Integer, Dice>builder().put(1, new Dice(6)).put(5, new Dice(6, 2)).put(11, new Dice(6, 3)).put(17, new Dice(6, 4)).build())
            .build();
    public static final Spell AID = builder().name("Aid")
            .description("Your spell bolsters your allies with toughness and resolve. Choose up to three creatures within range. Each target's hit point maximum and current hit points increase by 5 for the duration.", "At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, a target's hit points increase by an additional 5 for each slot level above 2nd.")
            .type(ABJURATION).level(L2).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(true, true, "a tiny strip of white cloth")).duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L2, level -> 5 * (level.getValue() - 1)))
            .build();
    public static final Spell ALARM = builder().name("Alarm")
            .description("You set an alarm against unwanted intrusion. Choose a door, a window, or an area within range that is no larger than a 20-foot cube. Until the spell ends, an alarm alerts you whenever a Tiny or larger creature touches or enters the warded area. When you cast the spell, you can designate creatures that won't set off the alarm. You also choose whether the alarm is mental or audible.", "A mental alarm alerts you with a ping in your mind if you are within 1 mile of the warded area. This ping awakens you if you are sleeping.", "An audible alarm produces the sound of a hand bell for 10 seconds within 60 feet.")
            .type(ABJURATION).level(L1).castingTime(ActionTimes.ONE_MINUTE).range(30)
            .components(SpellComponents.of(true, true, "a tiny bell and a piece of fine silver wire")).duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .build();
    public static final Spell ALTER_SELF = builder().name("Alter Self")
            .description("You assume a different form. When you cast the spell, choose one of the following options, the effects of which last for the duration of the spell. While the spell lasts, you can end on option as an action to gain the benefits of a different one.")
            .type(TRANSMUTATION).level(L2).castingTime(ActionTimes.ACTION).range(30).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .addProperty(SPELL_EFFECTS, AlterSelfSpellEffects.ALL)
            .build();
    public static final Spell ANIMAL_FRIENDSHIP = builder().name("Animal Friendship")
            .description("This spell lets you convince a beast that you mean it no harm. Choose a beast that you can see within range. It must see and hear you. If the beast's Intelligence is 4 or higher, the spell fails. Otherwise, the beast must succeed on a Wisdom saving throw or be charmed by you for the spell's duration. If you or one of your companions harms the target, the spell ends.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can affect one additional beast for each slot level above 1st.")
            .type(ENCHANTMENT).level(L2).castingTime(ActionTimes.ACTION).range(30).components(SpellComponents.of(true, true, "a morsel of food"))
            .duration(SpellDuration.of(ActionTimes.ONE_DAY))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L2, SpellLevel::getValue))
            .addProperty(SAVING_THROW, WISDOM)
            .build();
    public static final Spell ANIMAL_MESSENGER = builder().name("Animal Messenger")
            .description("By means of this spell, you use an animal to deliver a message. Choose a Tiny beast you can see within range, such as a squirrel, a blue jay, or a bat. You specify a location, which you must have visited, and a recipient who matches a general description, such as \"a man or woman dressed in the uniform of the town guard\" or \"a red-haired dwarf wearing a pointed hat.\" You also speak a message of up to twenty-five words. The target beast travels for the duration of the spell toward the specified location, covering about 50 miles per 24 hours for a flying messenger, or 25 miles for other animals.", "When the messenger arrives, it delivers your message to the creature that you described, replicating the sound of your voice. The messenger speaks only to a creature matching the description you gave. If the messenger doesn't reach its destination before the spell ends, the message is lost, and the beast makes its way back to where you cast this spell.", "At Higher Levels: If you cast this spell using a spell slot of 3rd level or higher, the duration of the spell increases by 48 hours for each slot level above 2nd.")
            .type(ENCHANTMENT).level(L2).isRitual(true).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(true, true, "a morsel of food"))
            //This spell has a special condition that changes duration based on the Spell Slot used to cast the spell.
            .duration(SpellDuration.of(-1))
            .addProperty(SPELL_LEVEL_DOUBLE_MAP, populateSpellLevelDoubleMap(L2, level -> ActionTimes.ONE_DAY + (level.getValue() - 2) * ActionTimes.TWO_DAYS))
            .build();
    public static final Spell ANIMAL_SHAPES = builder().name("Animal Shapes")
            .description("Your magic turns others into beasts. Choose any number of willing creatures that you can see within range. you transform each target into the form of a Large or smaller beast with a challenge rating of 4 or lower. On subsequent turns, you can use your action to transform affected creatures into new forms.", "The transformation lasts for the duration for each target, or until the target drops to 0 hit points or dies. You can choose a different form for each target. A target's game statistics are replaced by the statistics of the chosen beast, though the target retains its alignment and Intelligence, Wisdom, and Charisma scores. The target assumes the hit points. The target assumes the hit points of its new form, and when it reverts to its normal form, it returns to the number of hit points it had before it transformed. If it reverts as a result of dropping to 0 hit points, any excess damage carries over to its normal form. As long as the excess damage doesn't reduce the creature's normal form to 0 hit points, it isn't knocked unconscious. The creature is limited in th actions it can perform by the nature of its new form, and it can't speak or cast spells.", "The target's gear melds into the new form. The target can't activate, wield, or otherwise benefit from any of its equipment.")
            .type(TRANSMUTATION).level(L8).castingTime(ActionTimes.ACTION).range(30).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_DAY, true))
            .build();
    public static final Spell ANIMATE_DEAD = builder().name("Animate Dead")
            .description("This spell creates an undead servant. Choose a pile of bones or a corpse of Medium or Small humanoid within range. Your spell imbues the target with a foul mimicry of life, raising it as an undead creature. The target becomes a skeleton if you chose bones or a zombie if you chose a corpse (the DM has the creature's game statistics).", "On each of your turns, you can use a bonus action to mentally command any creature you made with this spell if the creature is within 60 feet of you (if you control multiple creatures, you can command any or all of them at the same time, issuing the same command to each one). You decide what action the creature will take and where it will move during its next turn, or you can issue a general command, such as to guard a particular chamber or corridor. If you issue no commands, the creature only defends itself against hostile creatures. Once given an order, the creature continues to follow it until its task is complete.", "The creature is under your control for 24 hours, after which it stops obeying any command you've given it. To maintain control of the creature for another 24 hours, you must cast this spell on the creature again before the current 24-hour period ends. This use of the spell reasserts your control over up to four creatures you have animated with this spell, rather than animating a new one.", "At Higher Levels: When you cast this spell using a spell slot of 4th level or higher, you animate or reassert control over two additional undead creatures for each slot level above 3rd. Each of the creatures must come from a different corpse or pile of bones.")
            .type(NECROMANCY).level(L3).castingTime(ActionTimes.ONE_MINUTE).range(10)
            .components(SpellComponents.of(true, true, "a drop of blood, a piece of flesh, and a pinch of bone dust"))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L3, level -> level.getValue() - 2))
            .build();
    public static final Spell ANIMATE_OBJECTS = builder().name("Animate Objects")
            .description("Objects come to life at your command. Choose up to ten nonmagical objects within range that are not being worn or carried. Medium targets count as two objects, Large targets count as four objects. Huge targets count as eight objects. You can't animate any object larger than Huge. Each target animates and becomes a creature under your control until the spell ends or until reduced to 0 hit points", "As a bonus action, you can mentally command any creature you made with this spell if the creature is within 500 feet of you (if you control multiple creatures, you can command any or all of them at the same time, issuing the same command to each one). You decide what action the creature will take and where it will move during its next turn, or you can issue a general command, such as to guard a particular chamger or corridor. If you issue no commands, the creature only defends itself against hostile creatures. Once given an order, the creature continues to follow it until its task is complete.", "An animated object is a construct with AC, hit points, attacks, Strength, and Dexterity determined by its size.", "Its Constitution is 10 and its Intelligence and Wisdom are 3, and its Charisma is 1. Its speed is 30 feet; if the object lacks legs or other appendages it can use for locomotion, it instead has a flying speed of 30 feet and can hover. If the object is securely attached to a surface or a larger object, such as a chain bolted to a wall, its speed is 0. It has blindsight with a radius of 30 feet and is blind beyond that distance. When the animated object drops to 0 hit points, it reverts to its original object form, and any remaining damage carries over to its original object form.", "If you command an object to attack, it can make a single melee attack against a creature within 5 feet of it. It makes a slam attack with an attack bonus and bludgeoning damage determined by its size. The DM might rule that a specific object inflicts slashing or piercing damage based on its form.", "At Higher Levels: If you cast this spell using a spell slot of 6th level or higher, you can animate two additional objects for each slot level above 5th.")
            .type(TRANSMUTATION).level(L5).castingTime(ActionTimes.ACTION).range(120)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L5, level -> level.getValue() * 2))
            .addProperty(TABLE, Table.builder().name("Animated Object Statistics")
                    .addColumn(SIZE_COLUMN, Arrays.asList(CharacterSize.TINY, CharacterSize.SMALL, CharacterSize.MEDIUM, CharacterSize.LARGE, CharacterSize.HUGE))
                    .addColumn(HP_COLUMN, Arrays.asList(20, 25, 40, 50, 80)).addColumn(AC_COLUMN, Arrays.asList(18, 16, 13, 10, 10))
                    .addColumn(ATTACK_COLUMN, Arrays.asList("+8 to hit, 1d4 + 4 damage", "+6 to hit, 1d8 + 2 damage", "+5 to hit, 2d6 + 1 damage", "+6 to hit, 2d10 + 2 damage", "+8 to hit, 2d12 + 4 damage"))
                    .addColumn(STR_COLUMN, Arrays.asList(4, 6, 10, 14, 18)).addColumn(DEX_COLUMN, Arrays.asList(18, 14, 12, 10, 6))
                    .build()).build();
    public static final Spell ANTILIFE_SHELL = builder().name("Antilife")
            .description("A shimmering barrier extends out from you in a 10-foot radius and moves with you, remaining centered on you and hedging out creatures other than undead and constructs. The barrier lasts for the duration.", "The barrier prevents an affected creature from passing or reaching through. An affected creature can cast spells or make attacks with ranged or reach weapons through the barrier.", "If you move so that an affected creature is forced to pass through the barrier, the spell ends.")
            .type(ABJURATION).level(L5).castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true)).build();
    public static final Spell ANTIMAGIC_FILED = builder().name("Antimagic Field")
            .description("A 10-foot-radius invisible sphere of antimagic surrounds you. This area is divorced from the magical energy that suffuses the multiverse. Within the sphere, spells can't be cast, summoned creatures disappear, and even magic items become mundane. Until the spell ends, the sphere moves with you, centered on you.", "Spells and other magical effects, except those created by an artifact or a deity, are suppressed in the sphere and can't protrude into it. A slot expended to cast a suppressed spell is consumed. While an effect is suppressed, it doesn't function, but the time it spends suppressed counts against its duration.")
            .type(ABJURATION).level(L8).castingTime(ActionTimes.ACTION)
            .components(SpellComponents.of(true, true, "a pinch of powdered iron or iron filings"))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .addProperty(SPELL_EFFECTS, AntimagicFieldSpellEffects.ALL)
            .build();
    public static final Spell ANTIPATHY_SYMPATHY = builder().name("Antipathy/Sympathy")
            .description("This spell attracts or repels creatures of your choice. You target something within range, either a Huge or smaller object or creature or an area that is no larger than a 200-foot cube. Then specify a kind of intelligent creature, such as red dragons, goblins, or vampires. You invest the target with an aura that either attracts or repels the specified creatures for the duration. Choose Antipathy or Sympathy as the aura's effect")
            .type(ENCHANTMENT).level(L8).castingTime(ActionTimes.ONE_HOUR).range(60)
            .components(SpellComponents.of(true, true, "either a lump of alum soaked in vinegar for the Antipathy effect or a drop of honey for the Sympathy effect"))
            .duration(SpellDuration.of(ActionTimes.ONE_DAY * 10))
            .addProperty(SPELL_EFFECTS, AntipathySympathySpellEffects.ALL)
            .build();
    public static final Spell ARCANE_EYE = builder().name("Arcane Eye")
            .description("You create an invisible, magical eye within range that hovers in the air for the duration.", "You mentally receive visual information from the eye, which has a normal vision and darkvision out to 30 feet. The eye can look in every direction.", "As an action, you can move the eye up to 30 feet in any direction. There is no limit to how far away from you the eye can move, but it can't enter another plane of existence. A solid barrier blocks the eye's movement, but the eye can pass through an opening as small as 1 inch in diameter.")
            .type(DIVINATION).level(L4).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(true, true, "a bit of bat fur")).duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .build();
    public static final Spell ARCANE_LOCK = builder().name("Arcane Lock")
            .description("You touch a closed door, window, gate, chest, or other entryway, and it becomes locked for the duration. You and the creatures you designate when you cast this spell can open the object normally. You can also set a password that, when spoken within 5 feet of the object, supresses this spell for 1 minute. Otherwise, it is impassible until it is broken or the spell is dispelled or suppresed. Casting Knock on the object suppresses Arcane Lock for 10 minutes.", "While affected by this spell, the object is more difficult to break or force open; the DC to break it or pick any locks on it increases by 10.")
            .type(ABJURATION).level(L2).castingTime(ActionTimes.ACTION)
            .components(SpellComponents.of(true, true, "gold dust worth at least 25 gp, which the spell consumes"))
            /** Spell ends when dispelled */
            .duration(SpellDuration.of(-1))
            .addProperty(MCDNDKeys.DUAL_INTEGER_FUNCTION, dc -> dc + 10)
            .build();
    public static final Spell ARMOR_OF_AGATHYS = builder().name("Armor of Agathys")
            .description("A protective magical force surrounds you, manifesting as a spectral frost that covers you and your gear. You gain 5 temporary hit points for the duration. If a creature hits you with a melee attack while you have these hit points, the creature takes 5 cold damage.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, both the temporary hit points and the cold damage increase by 5 for each slot level above 1st.")
            .type(ABJURATION).level(L1).castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, true, "a cup of water"))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, level -> level.getValue() * 5))
            .addProperty(DAMAGE_TYPE, COLD)
            .build();
    public static final Spell ARMS_OF_HADAR = builder().name("Arms of Hadar")
            .description("You invoke the power of Hadar, the Dark Hunger. Tendrils of dark energy erupt from you and batter all creatures within 10 feet of you. Each creature in that area must make a Strength saving throw. On a failed save, a target takes 2d6 necrotic damage and can't take reactions until its next turn. On a successful save, the creature takes half damage, but suffers no other effect.", "At HigherLevels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.")
            .type(CONJURATION).level(L1).components(SpellComponents.of(true, true))
            .addProperty(DAMAGE_TYPE, NECROTIC)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L1, 6, level -> level.getValue() + 1))
            .build();
    public static final Spell ASTRAL_PROJECTION = builder().name("Astral Projection")
            .description("You and up to eight willing creatures within range project your astral bodies into the Astral Plane (the spell fails and the casting is wasted if you are already on that plane). The material body you leave behind is unconscious and in a state of suspended animation; it doesn't need food or air and doesn't age.", "Your astral body resembles your mortal form in almost every way, replicating your game statistics and possessions. The principal difference is the addition of a silvery cord that extends from between your shoulder blades and trails behind you, fading to invisibility after 1 foot. This cord is your tether to your material body. As long as the thether remains intact, you can find your way home. If the cord is cut-something that can happen only when an effect specifically states that it does-your soul and body are separated, killing you instantly.", "Your astral form can freely travel through the Astral Plane and can pass through portals there leading to any other plane. If you enter a new plane or return to the plane you were on when casting this spell, your body and possesions are transported along the silver cord, allowing you to re-enter your body as you enter the new plane. Your astral form is a separate incarnation. Any damage or other effects that apply to it have no effect on your physical body nor do they persist when you return to it.", "The spell ends for you and your companions when you use your action to dismiss it. When the spell ends, the affected creature returns to its physical body, and it awakens.", "The spell might also end early for you or one of your companions. A successful Dispel Magic spell used against an astral or physical body ends the spell for that creature. If a creature's original body or its astral form drops to 0 hit points, the spell ends for that creature. If the spell ends and the silver cord is intact, the cord pulls the creature's astral form back to its body, ending its state of suspended animation.", "If you are returned to your body prematurely, your companions remain in their astral forms and must find their own way back to their bodies, usually by dropping to 0 hit points.")
            .type(NECROMANCY).level(L9)
            /** Special Conditions */
            .duration(SpellDuration.of(-1))
            .components(SpellComponents.of(true, true, "for each creature you affect with this spell, you must provide one jacinth worth at least 1,000 gp and one ornately carved bar of silver worth at least 100 gp, all of which the spell consumes"))
            .build();
    public static final Spell AUGURY = builder().name("Augury")
            .description("By casting gem-inlaid sticks, rolling dragon bones, laying out ornate cards, or employing some other divining tool, you receive an omen from an otherworldly entity about the results of a specific course of action that you plan to take within the next 30 minutes. The DM chooses from the following possible omens:", "- Weal, for good results", "- Woe, for bad results", "- Weal and woe, for both good and bad results", "- Nothing, for results that aren't especially good or bad", "The spell doesn't take into account any possible circumstances that might change the outcome, such as the casting of additional spells or the loss or gain of a companion.", "If you cast the spell two or more times before completing your next long rest, there is a cumulative 25 percent chance for each casting after the first that you get a random reading. The DM makes this roll in secret.")
            .type(DIVINATION).level(L2).castingTime(ActionTimes.ONE_MINUTE)
            .components(SpellComponents.of(true, true, "specially marked sticks, bones, or similar tokens worth at least 25 gp"))
            .build();
    public static final Spell AURA_OF_LIFE = builder().name("Aura of Life")
            .description("Life-preserving energy radiates from you in an aura with a 30-foot radius. Until the spell ends, the aura moves with you, centered on you. Each nonhostile creature in the aura (including you) has resistance to necrotic damage, and its hit point maximum can't be reduced. In addition, a nonhostile, living creature regains 1 hit point when it starts its turn in the aura with 0 hit points.")
            .castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE * 10, true))
            .addProperty(DAMAGE_TYPE, NECROTIC)
            .build();
    public static final Spell AURA_OF_PURITY = builder().name("Aura of Purity")
            .description("Purifying energy radiates from you in an aura with a 30-foot radius. Until the spell ends, the aura moves with you, centered on you. Each nonhostile creature in the aura (including you) can't become diseased, has resistance to poison damage, and has advantage on saving throws against effects that cause any of the following conditions: blinded, charmed, deafened, frightened, paralyzed, poisoned, and stunned.")
            .type(ABJURATION).level(L4).components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE * 10, true))
            .addProperty(DAMAGE_TYPE, POISON)
            .addProperty(MCDNDKeys.CONDITIONS, Arrays.asList(Conditions.BLINDED, Conditions.CHARMED, Conditions.DEAFENED, Conditions.FRIGHTENED, Conditions.PARALYZED, Conditions.POISONED, Conditions.STUNNED))
            .build();
    public static final Spell BARKSKIN = builder().name("Barkskin")
            .description("You touch a willing creature. Until the spell ends, the target's skin has a rough, bark-like appearance, and the target's AC can't be less than 16, regardless of what kind of armor it is wearing.")
            .type(TRANSMUTATION).level(L2).castingTime(ActionTimes.ACTION)
            .components(SpellComponents.of(true, true, "a handful of oak bark"))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .build();
    public static final Spell BEACON_OF_HOPE = builder().name("Beacon of Hope")
            .description("This spell bestows hope and vitality. Choose any number of creatures within range. For the duration, each target has advantage on Wisdom saving throws and death saving throws, and regains the maximum number of hit points possible from any healing.")
            .type(ABJURATION).level(L3).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .build();
    public static final Spell BEAST_SENSE = builder().name("Beast Sense")
            .description("You touch a willing beast. For the duration of the spell, you can use your action to see through the beast's eyes and hear what it hears, and continue to do so until you use your action to return to your normal senses.", "While perceiving through the beast's senses, you gain the benefits of any special senses possessed by that creature, though you are blinded and deafened to your own surroundings.")
            .isRitual(true).type(DIVINATION).level(L2).castingTime(ActionTimes.ACTION)
            .components(SpellComponents.of(false, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .build();
    public static final Spell BLESS = builder().name("Bless")
            .description("You bless up to three creatures of your choice within range. Whenever a target makes an attack roll or a saving throw before the spell ends, the target can roll a d4 and add the number rolled to the attack roll or saving throw.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level above 1st.")
            .type(ENCHANTMENT).level(L1).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(true, true, "a sprinkling of holy water"))
            .duration(SpellDuration.of(60, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, SpellLevel::getValue))
            .build();
    public static final Spell BURNING_HANDS = builder().name("Burning Hands")
            .description("As you hold your hands with thumbs touching and fingers spread, a thin sheet of flames shoots forth from your outstretched fingertips. Each creature in a 15-foot cone must make a Dexterity saving throw. A creature takes 3d6 fire damage on a failed save, or half as much damage on a successful one.", "The fire ignites any flammable objects in the area that aren't being worn or carried.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.")
            .type(EVOCATION).level(L1).castingTime(ActionTimes.ACTION).range(15)
            .components(SpellComponents.of(true, true))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L1, 6, level -> level.getValue() + 2))
            .build();
    public static final Spell CALL_LIGHTNING = builder().name("Call Lightning")
            .description("A storm cloud appears in the shape of a cylinder that is 10 feet tall with a 60-foot radius, centered on a point you can see 100 feet directly above you. The spell fails if you can't see a point in the air where the storm cloud could appear (for example, if you in a room that can't accommodate the cloud).", "When you cast the spell, choose a point you can see within range. A bolt of lightning flashes down from the cloud from that point. Each creature within 5 feet of that point must make a Dexterity saving throw. A creature takes 3d10 lightning damage on a failed save, or half as much damage on a successful one. On each of your turns until the spell ends, you can use your action to call down lightning in this way again, targeting the same point or a different one.", "If you are outdoors in stormy conditions when you cast this spell, the spell gives you control over the existing storm instead of creating a new one. Under such conditions, the spell's damage increases by 1d10.", "At Higher Levels: When you cast this spell using a spell slot of 4th or higher level, the damage increases by 1d10 for each slot level above 3rd.")
            .type(CONJURATION).level(L3).castingTime(ActionTimes.ACTION).range(120)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(600, true))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L3, 10, level -> level.getValue() - 1))
            .addProperty(DAMAGE_TYPE, LIGHTNING).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell COMMAND = builder().name("Command")
            .description("You speak a one-word command to a creature you can see within range. The target must succeed on a Wisdom saving throw or follow the command on its next turn. The spell has no effect if the target is undead, if it doesn't understand your language, or if your command is directly harmful to it.", "Some typical commands and their effects follow You might issue a command other than one described here. If you do so, the DM determines how the target behaves. If the target can't follow your command, the spell ends.", "- Approach: The target moves toward you by the shortest and most direct route, ending its turn if it moves within 5 feet you.", "- Drop: The target drops whatever it is holding end then ends its turn.", "- Flee: The target spends its turn moving away from you by the fastest available means.", "- Grovel: The target falls prone and then ends its turn.", "- Halt: The target doesn't move and takes no actions. A flying creature stays aloft, provided that it is able to do so. If it must move to stay aloft, it flies the minimum distance needed to remain in the air.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can affect one additional creature for each slot level above 1st. The creatures must be within 30 feet of each other when you target them.")
            .type(ENCHANTMENT).level(L1).castingTime(ActionTimes.ACTION).range(60)
            .components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(6))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, SpellLevel::getValue))
            .build();
    public static final Spell COMMUNE_WITH_NATURE = builder().name("Commune with Nature")
            .description("You briefly become one with nature and gain knowledge of the surrounding territory. In the outdoors, the spell gives you knowledge of the land within 3 miles of you. In caves and other natural underground settings, the radius is limited to 300 feet. The spell doesn't function where nature has been replaced by construction, such as in dungeons and towns.", "You instantly gain knowledge of up to three facts of your choice about any of the following subjects as they relate to the area:", "- terrain and bodies of water", "- prevalent plants, minerals, animals, or peoples", "- influence from other planes of existence", "- buildings", "For example, you could determine the location of powerful undead in the are, the location of major sources of safe drinking water, and the location of any nearby towns.")
            .isRitual(true).type(DIVINATION).level(L5).castingTime(ActionTimes.ONE_MINUTE)
            .components(SpellComponents.of(true, true))
            .build();
    public static final Spell CONFUSION = builder().name("Confusion")
            .description("This spell assaults and twists creatures' minds, spawning delusions and provoking uncontrolled action. Each creature in a 10-foot-radius sphere centered on a point you choose within range must succeed on a Wisdom saving throw when you cast this spell or be affected by it.", "An affected target can't take reactions and must roll a d10 at the start of each of its to determine its behavior for that turn.", "At the end of each of its turns, an affected target can make a Wisdom saving throw. If it succeeds, this effect ends for that target.", "At Higher Levels:When you cast this spell using a spell slot of 5th level or higher, the radius of the sphere increases by 5 feet for each slot level above 4th.")
            .type(ENCHANTMENT).level(L4).castingTime(ActionTimes.ACTION).range(90)
            .components(SpellComponents.of(true, true, "three nut shells"))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L4, level -> level.getValue() * 5 + 70))
            .addProperty(MCDNDKeys.INTEGER_STRING_MAP, ImmutableMap.<Integer, String>builder().put(1, "The creature uses all its movement to move in a random direction. To determine the direction, roll a d8 and assign a direction to each die face. The creature doesn't take an action this turn.").put(2, "The creature doesn't move or take actions this turn.").put(7, "The creature uses its action to make a melee attack against a randomly determined creature within its reach. If there is no creature within its reach, the creature does nothing this turn.").put(9, "The creature can act and move normally.").build())
            .build();
    public static final Spell CONTROL_WATER = builder().name("Control Water")
            .description("Until the spell ends, you control any freestanding water inside an area you choose that is a cube up to 100 feet on a side. You can choose from any of the following effects when you cast this spell. As an action on your turn, you can repeat the same effect or choose a different one.")
            .type(TRANSMUTATION).level(L4).castingTime(ActionTimes.ACTION).range(300)
            .components(SpellComponents.of(true, true, "a drop of water and a pinch of dust"))
            .duration(SpellDuration.of(600, true))
            .addProperty(SPELL_EFFECTS, ControlWaterSpellEffects.ALL)
            .build();
    public static final Spell CURE_WOUNDS = builder().name("Cure Wounds")
            .description("A creature you touch regains a number of hit points equal to 1d8 + your spellcasting ability modifier. This spell has no effect on undead or constructs.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the healing increases by 1d8 for each slot level above 1st.")
            .type(EVOCATION).level(L1).castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(0, false))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, SpellLevel::getValue))
            .build();
    public static final Spell DANCING_LIGHTS = builder().name("Dancing Lights")
            .description("You create up to four torch-sized lights within range, making them appear as torches, lanterns, or glowing orbs that hover in the air for the duration. You can also combine the four lights into one glowing vaguely humanoid form of Medium size. Whichever form you choose, each light sheds dim light in a 10-foot radius.", "As a Bonus action on your turn, you can move the lights up to 60 feet to a new spot within range. A light must be within 20 feet of anther light created by this spell, and a light winks out if it exceeds the spell's range.")
            .type(EVOCATION).level(CANTRIP).castingTime(ActionTimes.ACTION).range(120)
            .components(SpellComponents.of(true, true, "a bit of phosphorus or wychwood, or a glowworm"))
            .duration(SpellDuration.of(60, true))
            .build();
    public static final Spell DARKNESS = builder().name("Darkness")
            .description("Magical darkness spreads from a point you choose within range to fill a 15-foot-radius sphere for the duration. The darkness spreads around corners. A creature with darkvision can't see through this darkness, and nonmagical light can't illuminate it.", "If the point you choose is on an object you are holding or one that isn't being worn or carried, the darkness emanates from the object and moves with it. Completely covering the source of the darkness with an opaque object, such as a bowl or a helm, blocks the darkness.", "If any of this spell's are overlaps with an area of light created by a spell of 2nd level or lower, the spell that created the light is dispelled.")
            .type(EVOCATION).level(L2).castingTime(ActionTimes.ACTION).range(60)
            .components(SpellComponents.of(true, false, "bat fur and a drop of pitch or piece of coal"))
            .duration(SpellDuration.of(600, true))
            .build();
    public static final Spell DAYLIGHT = builder().name("Daylight")
            .description("A 60-foot-radius sphere of light spreads out from a point you choose within range. The sphere is bright light and sheds dim light for an additional 60 feet.", "If you chose a point on an object you are holding or one that isn't being worn or carried, the light shines from the object and moves with it. Completely covering the affected object with an opaque object, such as a bowl, or a helm, blocks the light.", "if any of this spell's area overlaps with an area of darkness created by a spell of 3rd level or lower, the spell that created the darkness is dispelled.")
            .type(EVOCATION).level(L3).castingTime(ActionTimes.ACTION).range(60).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR))
            .build();
    public static final Spell DEATH_WARD = builder().name("Death Ward")
            .description("You touch a creature and grant it a measure of protection from death.", "The first time the target would drop to 0 hit points as a result of taking damage, the target instead drops to 1 hit point, and the spell ends.", "If the spell is still in effect when the target is subjected to an effect that would kill it instantaneously without dealing damage, that effect is instead negated against the target, and the spell ends.")
            .type(ABJURATION).level(L4).castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .build();
    public static final Spell DESTRUCTIVE_WAVE = builder().name("Destructive Wave")
            .description("You strike the ground, creating a burst of divine energy that ripples outward from you. Each creature you choose within 30 feet of you must succeed on a Constitution saving throw or take 5d6 thunder damage, as well as 5d6 radiant or necrotic damage (your choice), and be knocked prone. A ccreature that succeeds on its saving throw takes half as much damage and isn't knocked prone.")
            .type(EVOCATION).level(L5).castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(0))
            .build();
    public static final Spell DOMINATE_BEAST = builder().name("Dominate Beast")
            .description("You attempt to beguile a beast that you can see within range. It must succeed on a Wisdom saving throw or be charmed by you for the duration. If you or creatures that are friendly to you are fighting it, it has advantage on the saving throw.", "While the beast is charmed, you have a telepathic link with it as long as the two of you are on the same plane of existence. You can use this telepathic link to issue commands to the creature while you are conscious (no action required), which it does its best to obey. You can specify a simple and general course of action, such as \"Attack that creature,\" \"Run over there,\", or \"Fetch that object.\" If the creature completes the order and doesn't receive further direction from you, it defends and preserves itself to the best of its ability.", "You can use your action to take total and precise control of the target. until the end of your next turn, the creature takes only the actions you choose, and doesn't do anything that you don't allow it to do. During this time, you can also cause the creature to use a reaction, but this requires you to use your own reaction as well.", "Each time the target takes damage, it makes a new Wisdom saving throw against the spell. If the saving throw succeeds, the spell ends.", "At Higher Levels: When you cast this spell with a 5th-level spell slot, the duration is concentration, up to 10 minutes. When you use a 6th-level spell slot, the duration is concentration, up to 1hour. When you use a spell slot of 7th level or higher, the duration is concentration, up to 8 hours.")
            .type(ENCHANTMENT).level(L1).castingTime(ActionTimes.ACTION).range(60)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, ImmutableMap.<SpellLevel, Integer>builder().put(L4, 60).put(L5, 600).put(L6, 3600).put(L7, 28800).build())
            .build();
    public static final Spell FAERIE_FIRE = builder().name("Faerie Fire")
            .description("Each object in a 20-foot cube within range is outlined in blue, green, or violet light (your choice). Any creature in the area when the spell is cast is also outlined in light if it fails a Dexterity saving throw. For the duration, objects and affected creatures shed dim light in a 10-foot radius.", "Any attack roll against an affected creature or object has advantage if the attacker can see it, and the affected creature or object can't benefit from being invisible.")
            .type(EVOCATION).level(L1).castingTime(ActionTimes.ACTION).range(60).duration(SpellDuration.of(60, true))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell FIREBALL = builder().name("Fireball")
            .description("A bright streak flashes from your pointing finger to a point you choose within range and then blossoms with a low roar into an explosion of flame. Each creature in a 20-foot-radius sphere centered on that point must make a Dexterity saving throw. A target takes 8d6 fire damage on a failed save, or half as much damage on a successful one.", "The fire spreads around corners. It ignites flammable objects in the area that aren't being worn or carried.", "At Higher Levels: When you cast this spell using a spell slot of 4th level or higher, the damage increases by 1d6 for each slot level above 3rd.")
            .type(EVOCATION).level(L3).castingTime(ActionTimes.ACTION).range(150)
            .components(SpellComponents.of(true, true, "a tiny ball of bat guano and sulfur"))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L3, 6, level -> level.getValue() + 5))
            .addProperty(DAMAGE_TYPE, FIRE).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell FLAME_STRIKE = builder().name("Flame Strike")
            .description("A vertical column of divine fire roars down from the heavens in a location you specify. Each creature in a 10-foot-radius, 40-foot-high cylinder centered on a point within range must make a Dexterity saving throw. A creature takes 4d6 fire damage and 4d6 radiant damage on a failed save, or half as much damage on a successful one.", "At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the fire damage or the radiant damage (your choice) increases by 1d6 for each slot level above 5th.")
            .type(EVOCATION).level(L5).castingTime(ActionTimes.ACTION).range(60)
            .components(SpellComponents.of(true, true, "pinch of sulfur"))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L5, 6, level -> level.getValue() - 1))
            .addProperty(DAMAGE_TYPES, Arrays.asList(FIRE, RADIANT))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell FLAMING_SPHERE = builder().name("Flaming Sphere")
            .description("A 5-foot-diameter sphere of fire appears in an unoccupied space of your choice within range and lasts for the duration. Any creature that ends its turn within 5 feet of the sphere must make a Dexterity saving throw. The creature takes 2d6 fire damage on a failed save, or half as much damage on a successful one.", "As a bonus action, you can move the sphere up to 30 feet. If you ram the sphere into a creature, that creature must take make the saving throw against the sphere's damage, and the sphere stops moving this turn.", "When you move the sphere, you can direct it over barriers up to 5 feet tall and jump it across pits up to 10 feet wide. The sphere ignites flammable objects not being worn or carried, and it sheds bright light in a 20-foot radius and dim light for an additional 20 feet.", "At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, the damage increases by 1d6 for each slot level above 2nd.")
            .type(CONJURATION).level(L2).castingTime(ActionTimes.ACTION).range(60)
            .components(SpellComponents.of(true, true, "a bit of tallow, a pinch of brimstone, and a dusting of powdered iron"))
            .duration(SpellDuration.of(60, true))
            .addProperty(DAMAGE_TYPE, FIRE)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L2, 6, SpellLevel::getValue))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell FOG_CLOUD = builder().name("Fog Cloud")
            .description("You create a 20-foot-radius sphere of fog centered on a point within range. the sphere spreads around corners, and it's area is heavily obscured. It lasts for the duration or until a wind of moderate or greater speed (at least 10 miles per hour) disperses it.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the radius of the fog increases by 20 feet for each slot level above 1st.")
            .type(CONJURATION).level(L1).castingTime(ActionTimes.ACTION).range(120)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, level -> level.getValue() * 20))
            .build();
    public static final Spell GRASPING_VINE = builder().name("Grasping Vine")
            .description("You conjure a vine that sprouts from the ground in an unoccupied space of your choice that you can see within range. When you cast this spell, you can direct the vine to lash out at a creature within 30 feet of it that you can see. That creature must succeed on a Dexterity saving throw or be pulled 20 feet directly toward the vine.", "Until the spell ends, you can direct the vine to lash out at the same creature or another one as a bonus action on each of your turns.")
            .type(CONJURATION).level(L4).castingTime(ActionTimes.BONUS_ACTION).range(30)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell GUARDIAN_OF_FAITH = builder().name("Guardian of Faith")
            .description("A Large spectral guardian appears and hovers for the duration in an unoccupied space of your choice that you can see within range. The guardian occupies that space and is indistinct except for a gleaming sword and shield emblazoned with the symbol of your deity.", "Any creature hostile to you that moves to a space within 10 feet of the guardian for the first time on a turn must succeed on a Dexterity saving throw. The creature takes 20 radiant damage on a failed save, or half as much damage on a successful one. The guardian vanishes when it has death a total of 60 damage.")
            .type(CONJURATION).level(L4).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell GUST_OF_WIND = builder().name("Gust of Wind")
            .description("A line of strong wind 60 feet long and 10 feet wide blasts from you in a direction you choose for the spell's duration. Each creature that starts its turn in the line must succeed on a Strength saving throw or be pushed 15 feet away from you in a direciton following the line.", "Any creature in the line must spend 2 feet of movement for every 1 foot it moves when moving closer to you.", "The gust disperses gas or vapor, and it extinguishes candles, torches, and similar unprotected flames in the area. It causes protected flames, such as those of lanterns, to dance wildly and has a 50 percent chance to extinguish them.", "As a bonus action on each of your turns before the spell ends, you can change the direction in which the line blasts from you.")
            .type(EVOCATION).level(L2).castingTime(ActionTimes.ACTION)
            .components(SpellComponents.of(true, true, "a legume seed"))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .build();
    public static final Spell HELLISH_REBUKE = builder().name("Hellish Rebuke")
            .description("You point your finger, and the creature that damaged you is momentarily surrounded by hellish flames. The creature must make a Dexterity saving throw. It takes 2d10 fire damage on a failed save, or half as much damage on a successful one.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d10 for each slot level above 1st.")
            .type(EVOCATION).level(L1).castingTime(ActionTimes.REACTION).range(60)
            .components(SpellComponents.of(true, true))
            .addProperty(DAMAGE_TYPE, FIRE)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L1, 10, level -> level.getValue() + 1))
            .build();
    public static final Spell ICE_STORM = builder().name("Ice Storm")
            .description("A hail of rock-hard ice pounds to the ground in a 20-foot-radius, 40-foot-high cylinder centered on a point within range. Each creature in the cylinder must make a Dexterity saving throw. A creature takes 2d8 bludgeoning damage and 4d6 cold damage on a failed save, or half as much on a successful one.", "Hailstones turn the storm's area of effect into difficult terrain until the end of your next turn.", "At Higher Levels: When you cast this spell using a spell slot of 5th level or higher, the bludgeoning damage increases by 1d8 for each slot level above 4th.")
            .type(EVOCATION).level(L4).castingTime(ActionTimes.ACTION).range(300)
            .components(SpellComponents.of(true, true, "a pinch of dust and a few drops of water"))
            .addProperty(DAMAGE_TYPE, BLUDGEONING).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L4, 8, level -> level.getValue() - 2))
            .build();
    public static final Spell IDENTIFY = builder().name("Identify")
            .description("You choose on object that you must touch throughout the casting of th spell. If it is a magic item or some other magic-imbued object, you learn its properties and how to use them, whether it requires attunement to use, and how many charges it has, if any. You learn whether any spells are affecting the item and what they are. If the item was created by a spell, you learn which spell created it.", "If you instead touch a creature throughout the casting, you learn what spells, if any, are currently affecting it.")
            .type(DIVINATION).level(L1).castingTime(ActionTimes.ONE_MINUTE).isRitual(true)
            .components(SpellComponents.of(true, true, "a pearl worth at least 100 gp and an owl feather"))
            .build();
    public static final Spell INSECT_PLAGUE = builder().name("Insect Plague")
            .description("Swarming, biting locusts fill a 20-foot-radius sphere centered on a point you choose within range. The sphere spreads around corners. The sphere remains for the duration, and its area is lightly obscured. The sphere's area is difficult terrain.", "When the area appears, each creature in it must make a Constitution saving throw. A creature takes 4d10 Piercing damage on a failed save, or half as much on a successful one. A creature must also make this saving throw when it enters the spell's area for the first time on a turn or ends its turn there.", "At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the damage increases by 1d10 for each slot level above 5th.")
            .type(CONJURATION).level(L5).castingTime(ActionTimes.ACTION).range(300)
            .components(SpellComponents.of(true, true, "a few grains of sugar, some kernels of grain, and a smear of fat"))
            .duration(SpellDuration.of(600, true))
            .addProperty(DAMAGE_TYPE, PIERCING).addProperty(ABILITY_SCORE_TYPE, CONSTITUTION)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L5, 10, level -> level.getValue() - 1))
            .build();
    public static final Spell LEGEND_LORE = builder().name("Legend Lore")
            .description("Name or describe a person, place, or object. The spell brings to your mind a brief summary of the significant lore about the thing you named. The lore might consist of current tales, forgotten stories, or even secret lore that has never been widely known. If the thing you named isn't of legendary importance, you gain no information. The more information you already have about the thing, the more precise and detailed the information you receive is.", "The information you learn is accurate but might be couched in figurative language. For example, if you have a mysterious magic axe on hand, the spell might yield this information: \"Woe to the evildoer whose hand touches the axe, for even the haft slices the hand of the evil ones. Only a true Child of Stone, lover and beloved of Moradin, may awaken the true powers of the axe, and only with the sacred word Rudnogg on the lips.\"")
            .type(DIVINATION).level(L5).castingTime(600)
            .components(SpellComponents.of(true, true, "incense worth at least 250 gp, which the spell consumes, and four ivory strips worth at least 50 gp each"))
            .build();
    public static final Spell LESSER_RESTORATION = builder().name("Lesser Restoration")
            .description("You touch a creature and can end either one disease or one condition afflicting it. The condition can be blinded, deafened, paralyzed, or poisoned.")
            .type(ABJURATION).level(L2).castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, true))
            .build();
    public static final Spell LIGHT = builder().name("Light")
            .description("You touch one object that is no larger than 10 feet in any dimension. Until the spell ends, the object sheds bright light in a 20-foot radius and dim light for an additional 20 feet. The light can be colored as you like. Completely covering the object with something opaque blocks the light. The spell ends if you cast it again or dismiss it as an action.", "If you target an object held or worn by a hostile creature, that creature must succeed on a Dexterity saving throw to avoid the spell.")
            .type(EVOCATION).level(CANTRIP).castingTime(ActionTimes.ACTION)
            .components(SpellComponents.of(true, false, "a firefly or phosphorescent moss"))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell MASS_CURE_WOUNDS = builder().name("Mass Cure Wounds")
            .description("A wave of healing energy washes out from a point of your choice within range. Choose up to six creatures in a 30-foot-radius sphere centered on that point. Each target regains hit points equal to 3d8 + your spellcasting ability modifier. This spell has no effect on undead or constructs.", "At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the healing increases by 1d8 for each slot level above 5th.")
            .type(CONJURATION).level(L5).castingTime(ActionTimes.ACTION).range(60)
            .components(SpellComponents.of(true, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L5, level -> level.getValue() - 2))
            .build();
    public static final Spell MINOR_ILLUSION = builder().name("Minor Illusion")
            .description("You create a sound or an image of an object within range that lasts for the duration. The illusion also ends if you dismiss it as an action or cast this spell again.", "If you create a sound, its volume can range from a whisper to a scream. It can be your voice, someone else's voice, a lion's roar, a beating of drums, or any other sound you choose. The sound continues unabated thought the duration, or you can make discrete sounds at different times before the spell ends.", "If you create an image of an object-such as a chair, muddy footprints, or a small chest-it must be no larger than a 5-foot cube. The image can't create sound, light, smell, or any other sensory effect. Physical interaction with the image reveals it to be an illusion, because things can pass through it.", "If a creature uses its action to examine the sound or image, the creature can determine that it is an illusion with a successful Intelligence (Investigation) check against your spell save DC. If a creature discerns the illusion for what it is, the illusion becomes faint to the creature.")
            .type(ILLUSION).level(CANTRIP).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(false, true, "a bit of fleece"))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .addProperty(ABILITY_SCORE_TYPE, INTELLIGENCE)
            .build();
    public static final Spell NONDETECTION = builder().name("Nondetection")
            .description("For the duration, you hide a target that you touch from divination magic. The target can be a willing creature or a place or an object no larger than 10 feet in any dimension. The target can't be targeted by any divination magic or perceived through magical scrying sensors.")
            .type(ABJURATION).level(L3).castingTime(ActionTimes.ACTION)
            .components(SpellComponents.of(true, true, "a pinch of diamond dust worth 25 gp sprinkled over the target, which the spell consumes)"))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .build();
    public static final Spell PLANT_GROWTH = builder().name("Plant Growth")
            .description("This spell channels vitality into plants within a specific area. There are two possible uses for the spell, granting either immediate or long-term benefits.", "If you cast this spell using 1 action, choose a point within range. All normal plants in a 100-foot radius centered on that point become thick and overgrown. A creature moving through the area must spend 4 feet of movement for every 1 foot it moves.", "You can exclude one or more areas of any size within the spell's area from being affected.", "If you cast this spell over 8 hours, you enrich the land. All plants in a half-mile radius centered on a point within range become enriched for 1 year. The plants yield twice the normal amount of food when harvested.")
            .type(TRANSMUTATION).level(L3).castingTime(ActionTimes.ACTION).range(150)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .build();
    public static final Spell RAISE_DEAD = builder().name("Raise Dead")
            .description("You return a dead creature you touch to life, provided that it has been dead no longer than 10 days. If the creature's soul is both willing and at liberty to rejoin the body, the creature returns to life with 1 hit point.", "This spell also neutralizes any poisons and cures nonmagical diseases that affected the creature at the time it died. This spell doesn't, however, remove magical diseases, curses, or similar effects; if these aren't first removed prior to casting the spell, they take effect when the creature returns to life.", "This spell closes all mortal wounds, but it doesn't restore missing body parts. If the creature is lacking body parts or organs integral for its survival-its hea, for instance-the spell automatically fails.", "Coming back from the dead is an ordeal. The target takes a -4 penalty to all attack rolls, saving throws, and ability checks. Every time the target finishes a long rest, the penalty is reduced by 1 until it disappears.")
            .type(NECROMANCY).level(L5).castingTime(ActionTimes.ONE_HOUR)
            .components(SpellComponents.of(true, true, "a diamond worth at least 500 gp, which the spell consumes"))
            .build();
    public static final Spell REVIVIFY = builder().name("Revivify")
            .description("You touch a creature that has died within the last minute. That creature returns to life with 1 hit point. This spell can't return to life a creature that has died of old age, nor can it restore any missing body parts.")
            .type(CONJURATION).level(L3).castingTime(ActionTimes.ACTION)
            .components(SpellComponents.of(true, true, "diamonds worth 300 gp, which the spell consumes"))
            .build();
    public static final Spell SCORCHING_RAY = builder().name("Scorching Ray")
            .description("You create three rays of fire and hurl them at targets within range. You can hurl them at one target or several.", "Make a ranged spell attack for each ray. On a hit, the target takes 2d6 fire damage.", "At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, you create one additional ray for each slot level above 2nd.")
            .type(EVOCATION).level(L2).castingTime(ActionTimes.ACTION).range(120)
            .components(SpellComponents.of(true, true))
            .addProperty(DAMAGE_TYPE, FIRE)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L2, 6, SpellLevel::getValue))
            .build();
    public static final Spell SCRYING = builder().name("Scrying")
            .description("You can see and hear a particular creature you choose that is on the same plane of existence as you. The target must make a Wisdom saving throw, which is modified by how well you know the target and the sort of physical connection you have to it. If a target knows you're casting this spell, it can fail the saving throw voluntarily if it wants to be observed.", "On a successful save, the target isn't affected, and you can't use this spell against it again for 24 hours.", "On a failed save, the spell creates an invisible sensor within 10 feet of the target. You can see and hear through the sensor as if you were there. The sensor moves with the target, remaining within 10 feet of it for the duration. A creature that can see invisible objects sees the sensor as a luminous orb about the size of your fist.", "Instead of targeting a creature, you can choose a location you have seen before as the target of this spell. When you do, the sensor appears at that location and doesn't move.")
            .type(DIVINATION).level(L5).castingTime(600)
            .components(SpellComponents.of(true, true, "a focus worth at least 1,000 gp, such as a crystal ball, a silver mirror, or a font filled with holy water"))
            .duration(SpellDuration.of(600, true))
            .addProperty(TABLES, Arrays.asList(Table.builder().name("Connection")
                    .addColumn(CONNECTION_COLUMN, Arrays.asList("Likeness or picture", "Possession or garment", "Body part, lock of hair, bit of nail, or the like"))
                    .addColumn(SAVE_MODIFIER_COLUMN, Arrays.asList(5, 0, -5)).build(),
                    Table.builder().name("Knowledge")
                    .addColumn(KNOWLEDGE_COLUMN, Arrays.asList("Secondhand (you have heard of the target)", "Firsthand (you have met the target)", "Familiar (you know the target well)"))
                    .addColumn(SAVE_MODIFIER_COLUMN, Arrays.asList(-2, -4, -10)).build())).build();
    public static final Spell SHATTER = builder().name("Shatter")
            .description("A sudden loud ringing noise, painfully intense, erupts from a point of your choice within range. Each creature in a 10-foot-radius sphere centered on that point must make a Constitution saving throw. A creature takes 3d8 thunder damage on a failed save, or half as much damage on a successful one. Acreature made of inorganic material such as stone, crystal, or metal has disadvantage on this saving throw.", "A nonmagical object that isn't being worn or carried also takes the damage if it's in the spell's area.", "At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, the damage increases by 1d8 for each slot level above 2nd.")
            .type(EVOCATION).level(L2).castingTime(ActionTimes.ACTION).range(60)
            .components(SpellComponents.of(true, true, "a chip of mica"))
            .addProperty(DAMAGE_TYPE, THUNDER)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L2, 8, level -> level.getValue() + 1))
            .addProperty(ABILITY_SCORE_TYPE, CONSTITUTION)
            .build();
    public static final Spell SLEET_STORM = builder().name("Sleet Storm")
            .description("Until the spell ends, freezing rain and sleet fall in a 20-foot-tall cylinder with a 40-foot radius centered on a point you choose within range. The area is heavily obscured, and exposed flames in the area are doused.", "The ground in the area is covered with slick ice, making it difficult terrain. When a creature enters the spell's area for the first time on a turn or starts its turn there, it makes a Dexterity saving throw. On a failed save, it falls prone.", "If a creature is concentrating in the spell's area, the creature must make a successful Constitution saving throw against your spell save DC or lose concentration.")
            .type(CONJURATION).level(L3).castingTime(ActionTimes.ACTION).range(150)
            .components(SpellComponents.of(true, true, "a pinch of dust and a few drops of water"))
            .duration(SpellDuration.of(60, true))
            .addProperty(ABILITY_SCORE_TYPE, CONSTITUTION)
            .build();
    public static final Spell SPEAK_WITH_ANIMALS = builder().name("Speak with Animals")
            .description("You gain the ability to comprehend and verbally communicate with beasts for the duration. The knowledge and awareness of many beasts is limited by their intelligence, but at minimum, beasts can give you information about nearby locations and monsters, including whatever they can perceive or have perceived within the past day. You might be able to persuade a beast to perform a small favor for you, at the DM's discretion.")
            .type(DIVINATION).level(L1).castingTime(ActionTimes.ACTION).isRitual(true)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(600))
            .build();
    public static final Spell SPEAK_WITH_DEAD = builder().name("Speak with Dead")
            .description("You grant the semblance of life and intelligence to a corpse of your choice within range, allowing it to answer the questions you pose. The corpse must still have a and can't be undead. The spell fails if the corpse was the target of this spell within the last 10 days.", "Until the spell ends, you can ask the corpse up to five questions. The corpse knows only what it knew in life, including the languages it knew. Answers are usually brief, cryptic, or repetitive, and the corpse is under no compulsion to offer a truthful answer if you are hostile to it or it recognizes you as an enemy. This spell doesn't return the creature's soul to its body, only its animating spirit. Thus, the corpse can't learn new information, doesn't comprehend anything that has happened since it died, and can't speculate about future events.")
            .type(NECROMANCY).level(L3).castingTime(ActionTimes.ACTION).range(10)
            .components(SpellComponents.of(true, true, "burning incense")).duration(SpellDuration.of(600))
            .build();
    public static final Spell SPIKE_GROWTH = builder().name("Spike Growth")
            .description("The ground in a 20-foot radius centered on a point within range twists and sprouts hard spikes and thorns. The area becomes difficult terrain for the duration. When a creature moves into or within the area, it takes 2d4 piercing damage for every 5 feet it travels.", "The transformation of the ground is camouflaged to look natural. Any creature that can't see the area at the time the spell is cast must make a Wisdom (Perception) check against your spell save DC to recognize the terrain as hazardous before entering it.")
            .type(TRANSMUTATION).level(L2).castingTime(ActionTimes.ACTION).range(150)
            .components(SpellComponents.of(true, true, "seven sharp thorns or seven small twigs, each sharpened to a point"))
            .duration(SpellDuration.of(600, true))
            .addProperty(DAMAGE, new Damage(PIERCING, new Dice(4, 2))).addProperty(MCDNDKeys.INTEGER, 5).addProperty(MCDNDKeys.SKILL_TYPE, PERCEPTION)
            .build();
    public static final Spell SPIRITUAL_WEAPON = builder().name("Spiritual Weapon")
            .description("You create a floating, spectral weapon within range that lasts for the duration or until you cast this spell again. When you cast the spell, you can make melee spell attack against a creature within 5 feet of the weapon. On a hit, the target takes force damage equal to 1d8 + your spellcasting ability modifier.", "As a bonus action on your turn, you can move the weapon up to 20 feet and repeat the attack against a creature within 5 feet of it.", "The weapon can take whatever form you choose. Clerics of deities who are associated with a particular weapon (as St. Curthbert is known for his mace and Thor for his hammer) make this spell's effect resemble that weapon.", "At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, the damage increases by 1d8 for every two slot levels above 2nd.")
            .type(EVOCATION).level(L2).castingTime(ActionTimes.BONUS_ACTION).range(60)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .addProperty(DAMAGE_TYPE, FORCE)
            .addProperty(SPELL_LEVEL_DICE_MAP, ImmutableMap.<SpellLevel, Dice>builder().put(L1, new Dice(8, 1)).put(L4, new Dice(8, 3)).put(L5, new Dice(8, 3)).put(L6, new Dice(8, 5)).put(L7, new Dice(8, 5)).put(L8, new Dice(8, 7)).build())
            .build();
    public static final Spell SUGGESTION = builder().name("Suggestions")
            .description("You suggest a course of activity (limited to a sentence or two) and magically influence a creature you can see within range that can hear and understand you. Creatures that can't be charmed are immune to this effect. The suggestion must be worded in such a manner as to make the course of action sound reasonable. Asking the creature to stab itself, throw itself onto a spear, immolate itself or do some other obviously harmful act ends the spell.", "The target must make a Wisdom saving throw. On a failed save, it pursues the course of action you described to the best of its ability. The suggested course of action can continue for the duration. If the suggested activity can be completed in a shorter time, the spell ends when the subject finishes what it was asked to do.", "You can also specify conditions that will trigger a special activity during the duration. For example, you might suggest that a knight give her warhorse to the first beggar she meets. If the condition isn't met before the spell expires, the activity isn't performed.", "If you or any of your companions damage the target, the spell ends.")
            .type(ENCHANTMENT).level(L2).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(true, false, "a snake's tongue and either a hit of honeycomb or a drop of sweet oil"))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS, true))
            .build();
    public static final Spell THAUMATURGY = builder().name("Thaumaturgy")
            .description("You manifest a minor wonder, a sign of supernatural power, within range. You create one of the following magical effects within range:", "- Your voice booms up to three times as loud as normal for 1 minute.", "- You cause flames to flicker, brighten, dim, or change color for 1 minute.", "- You cause harmless tremors in the ground for 1 minute.", "- You create an instantaneous sound that originates from a point of your choice within range, such as a rumble of thunder, the cry of a raven, or ominous whispers.", "- You instantaneously cause an unlocked door or window to fly open or slam shut.", "- You alter the appearance of your eyes for 1 minute.", "If you cast this spell multiple times, you can have up to three of its 1 minute effects active at a time, and you can dismiss such an effect as an action.")
            .type(TRANSMUTATION).level(CANTRIP).castingTime(ActionTimes.ACTION).range(30)
            .components(SpellComponents.of(true, false, "")).duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .build();
    public static final Spell THUNDERWAVE = builder().name("Thunderwave")
            .description("A wave of thunderous force sweeps out from you. Each creature in a 15-foot cube originating from you must make a Constitution saving throw. On a failed save, a creature takes 2d8 thunder damage and is pushed 10 feet away from. On a successful save, the creature takes half as much damage and isn't pushed.", "In addition, unsecured objects that are completely within the area of effect are automatically pushed 10 feet away from you by the spell's effect, and the spell emits a thunderous boom audible out to 300 feet.", "At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d8 for each slot level above 1st.")
            .type(EVOCATION).level(L1).castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .addProperty(DAMAGE_TYPE, THUNDER).addProperty(ABILITY_SCORE_TYPE, CONSTITUTION)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L1, 8, level -> level.getValue() + 1))
            .build();
    public static final Spell TREE_STRIDE = builder().name("Tree Stride")
            .description("You gain the ability to enter a tree and move from inside it to inside another tree of the same kind within 500 feet. Both trees must be living and at least the same size as you. You must use 5 feet of movement to enter a tree. You instantly know the location of all other trees of the same kind within 500 feet and, as part of the move used to enter the tree, can either pass into one of those trees or step out of the tree you're in. You appear in a spot of your choice within 5 feet of the destination tree, using another 5 feet of movement. If you have no movement left, you appear within 5 feet of the tree you entered.", "You can use this transportation ability once per round for the duration. You must end each turn outside a tree.")
            .type(CONJURATION).level(L5).castingTime(ActionTimes.ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .build();
    public static final Spell WALL_OF_FIRE = builder().name("Wall of Fire")
            .description("You create a wall of fire on a solid surface within range. You can make the wall up to 60 feet long, 20 feet high, and 1 foot thick. The wall is opaque and lasts for the duration.", "When the wall appears, each creature within its area must make a Dexterity saving throw. On a failed save, a creature takes 5d8 fire damage, or half as much damage on a successful save.", "One side of the wall, selected by you when you cast this spell, deals 5d8 damage to each creature that ends its turn within 10 feet of that side or inside the wall. A creature takes the same damage when it enters the wall for the first time on a turn or ends its turn there. The other side of the wall deals no damage.", "At Higher Levels: When you cast this spell using a spell slot of 5th level or higher, the damage increases by 1d8 for each slot level above 4th.")
            .type(EVOCATION).level(L4).castingTime(ActionTimes.ACTION).range(120)
            .components(SpellComponents.of(true, true, "a small piece of phosphorus"))
            .duration(SpellDuration.of(60, true))
            .addProperty(DAMAGE_TYPE, FIRE).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L4, 8, level -> level.getValue() + 1))
            .build();
    public static final Spell WIND_WALL = builder().name("Wind Wall")
            .description("A wall of strong wind rises from the ground at a point you choose within range. You can make the wall up to 50 feet long, 15 feet high, and 1 foot thick. You can shape the wall in any way you choose so long as it makes one continuous path along the ground. The wall lasts for the duration.", "When the wall appears each creature within its area must make a Strength saving throw. A creature takes 3d8 bludgeoning damage on a failed save, or half as much damage on a successful one.", "The strong winds keep fog, smoke, and other gases at bay. Small or smaller flying creatures or objects can't pass through the wall. loose, lightweight materials brought into the wall fly upward. Arrows, bolts, and other ordinary projectiles launched at targets behind the wall are deflected upward and automatically miss. (Boulders hurled by giants or siege engines, and similar projectiles are unaffected.) Creatures in a gaseous form can't pass through it.")
            .type(EVOCATION).level(L3)
            .castingTime(ActionTimes.ACTION)
            .range(120).components(SpellComponents.of(true, true, "a tiny fan and a feather of exotic origin"))
            .duration(SpellDuration.of(60, true))
            .addProperty(ABILITY_SCORE_TYPE, STRENGTH).addProperty(DAMAGE, new Damage(BLUDGEONING, new Dice(8, 3)))
            .build();
}