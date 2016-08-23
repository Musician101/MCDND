package io.musician101.sponge.mcdnd.magic;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.condition.Conditions;
import io.musician101.sponge.mcdnd.data.type.CharacterSizes;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.magic.spelleffect.AlterSelfSpellEffects;
import io.musician101.sponge.mcdnd.magic.spelleffect.AntimagicFieldSpellEffects;
import io.musician101.sponge.mcdnd.magic.spelleffect.AntipathySympathySpellEffects;
import io.musician101.sponge.mcdnd.magic.spelleffect.ControlWaterSpellEffects;
import io.musician101.sponge.mcdnd.shape.Cone;
import io.musician101.sponge.mcdnd.shape.Cube;
import io.musician101.sponge.mcdnd.util.ActionTimes;
import io.musician101.sponge.mcdnd.util.list.SpellList;
import io.musician101.sponge.mcdnd.util.table.Table;

import java.util.Arrays;

import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.ACID;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.BLUDGEONING;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.COLD;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.FIRE;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.FORCE;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.LIGHTNING;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.NECROTIC;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.PIERCING;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.POISON;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.RADIANT;
import static io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes.THUNDER;
import static io.musician101.sponge.mcdnd.condition.Conditions.CHARMED;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.ABILITY_SCORE_TYPE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.AC_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.ATTACK_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.CONDITION;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.CONDITIONS;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.CONNECTION_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DAMAGE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DAMAGE_TYPE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DAMAGE_TYPES;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DEX_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DICE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DUAL_INTEGER_FUNCTION;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.DURATION;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.HP_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.INTEGER;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.INTEGER_DICE_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.INTEGER_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.INTEGER_STRING_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.KNOWLEDGE_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.MAX_RANGE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.MIN_ROLL;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.RANGE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SAVE_MODIFIER_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SAVING_THROW;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SHAPE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SIGHTS;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SIZE_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SKILL_TYPE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELLS;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_EFFECTS;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_LEVEL_DICE_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_LEVEL_DOUBLE_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_LEVEL_DURATION_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_LEVEL_INTEGER_FUNCTION;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.SPELL_LEVEL_INTEGER_MAP;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.STR_COLUMN;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.TABLE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.TABLES;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.VISIBILITY_RANGE;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.VOLUME;
import static io.musician101.sponge.mcdnd.data.key.MCDNDKeys.WEIGHT;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.CONSTITUTION;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.DEXTERITY;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.INTELLIGENCE;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.STRENGTH;
import static io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes.WISDOM;
import static io.musician101.sponge.mcdnd.data.type.skill.SkillTypes.INVESTIGATION;
import static io.musician101.sponge.mcdnd.data.type.skill.SkillTypes.PERCEPTION;
import static io.musician101.sponge.mcdnd.data.type.skill.SkillTypes.STEALTH;
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
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.ENCHANTMENT;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.EVOCATION;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.ILLUSION;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.NECROMANCY;
import static io.musician101.sponge.mcdnd.data.type.spell.SpellTypes.TRANSMUTATION;
import static io.musician101.sponge.mcdnd.magic.Spell.builder;
import static io.musician101.sponge.mcdnd.util.ActionTimes.ACTION;
import static io.musician101.sponge.mcdnd.util.ActionTimes.BONUS_ACTION;
import static io.musician101.sponge.mcdnd.util.ActionTimes.EIGHT_HOURS;
import static io.musician101.sponge.mcdnd.util.ActionTimes.ONE_DAY;
import static io.musician101.sponge.mcdnd.util.ActionTimes.ONE_HOUR;
import static io.musician101.sponge.mcdnd.util.ActionTimes.ONE_MINUTE;
import static io.musician101.sponge.mcdnd.util.ActionTimes.TEN_MINUTES;
import static io.musician101.sponge.mcdnd.util.MapUtils.populateSpellLevelDiceMap;
import static io.musician101.sponge.mcdnd.util.MapUtils.populateSpellLevelDoubleMap;
import static io.musician101.sponge.mcdnd.util.MapUtils.populateSpellLevelIntegerMap;

//TODO reread all spells for missing properties and add shape as property
//TODO add spell lists (bard spell list, cleric spell list, etc.)
public class Spells
{
    public static final Spell BLIGHT = builder().name("Blight")
            .addLineToDescription("Necromantic energy washes over a creature of your choice that you can see within range, draining moisture and vitality from it. The target must make a Constituion saving throw. The target takes 8d8 necrotic damage on a failed save, or half as much damage on a successful one. This spell has no effect on undead or constructs.")
            .addLineToDescription("If you target a plant creature or a magical plant, it makes the saving throw with disadvantage, and the spell deals maximum damage to it.")
            .addLineToDescription("If you target a nonmagical plant that isn't a creature, such as a tree or shrub, it doesn't make a saving throw; it simply withers and dies.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 5th level or higher, the damage increases by 1d8 for each slot level above 4th.")
            .type(NECROMANCY).level(L4).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, true))
            .addProperty(ABILITY_SCORE_TYPE, CONSTITUTION).addProperty(DAMAGE_TYPE, NECROTIC)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L4, 8, level -> level.getValue() + 4))
            .build();
    public static final Spell BLUR = builder().name("Blur")
            .description("Your body becomes blurred, shifting and wavering ot all who can see you. For the duration, any creature has disadvantage on attack rolls against you. An attacker is immune to this effect if it doesn' rely on sight, as with blindsight, or can see through illusions, as with truesight.")
            .type(ILLUSION).level(L2).castingTime(ACTION)
            .components(SpellComponents.of(true, false)).duration(SpellDuration.of(ONE_MINUTE, true))
            .addProperty(SIGHTS, Arrays.asList("Blindsight", "Truesight"))
            .build();
    public static final Spell CLOUDKILL = builder().name("Cloudkill")
            .addLineToDescription("You create a 20-foot-radius sphere poisonous, yellow-green fog centered on a point you choose within range.")
            .addLineToDescription("When a creature enters the spell's area for the first time on a turn or starts its turn there, that creature must make a Constitution saving throw. The creature takes 5d8 poison damage on a failed save, or half as much damage on a successful one. Creatures are affected even if they hold their breath or don't need to breathe.")
            .addLineToDescription("The fog moves 10 feet away from you at the start of each of your turns, rolling along the surface of the ground. The vapors, being heavier than air, sink to the lowest level of the land, even pouring down openeings.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the damage increases by 1d8 for each slot level above 5th.")
            .type(CONJURATION).level(L5).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(TEN_MINUTES, true))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L5, 8, SpellLevel::getValue))
            .addProperty(DAMAGE_TYPE, POISON).build();
    public static final Spell CONE_OF_COLD = builder().name("Cone of Cold")
            .addLineToDescription("A blast of cold air erupts from your hands. Each creature in a 60-foot cone must make a Constitution saving throw. A creature takes 8d8 cold damage on a failed save, or half as much damage on a successful one.")
            .addLineToDescription("A creature killed by this spell becomes a frozen statue until it thaws.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the damage increases by 1d8 for each slot level above 5th.")
            .type(EVOCATION).level(L5).castingTime(ACTION)
            .components(SpellComponents.of(true, true, "a small crystal or glass cone"))
            .addProperty(SHAPE, new Cone(60)).addProperty(DAMAGE_TYPE, COLD)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L5, 8, level -> level.getValue() + 3))
            .build();
    public static final Spell CONJURE_ELEMENTAL = builder().name("Conjure Elemental")
            .addLineToDescription("You call forth an elemental servant. Choose an area of air, earth, fire, or water that fills a 10-foot cube within range. An elemental of challenge rating 5 or lower appropriate to the area you chose appears in an unoccupied space within 10 feet of it. For example, a fire elemental emerges from a bonfire, and an earth elemental rises from the ground. The elemental disappears when it drops to 0 hit points or when the spell ends.")
            .addLineToDescription("The elemental is friendly to you and your companions for the duration. Roll initiative for the elemental, which has its own turns. It obeys any verbal commands that you issue to it (no action required by you). If you don't issue any commands to the elemental, it defends itself from hostile creatures but otherwise takes no actions.")
            .addLineToDescription("If your concentration is broken, the elemental doesn' disappear. Instead, you lose control of the elemental, it becomes hostile toward you and your companions, and it might attack. An uncontrolled elemental can't be dismissed by you, and it disappears 1 hour after you summoned it.")
            .addLineToDescription("The DM has the elemental's statistics.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the challenge rating increases by 1 for each slot level above 5th.")
            .type(CONJURATION).level(L5).castingTime(ONE_MINUTE).range(90)
            .components(SpellComponents.of(true, true, "burning incense for air, soft clay for earth, sulfur and phosphorus for fire, or water and sand for water"))
            .duration(SpellDuration.of(ONE_HOUR, true))
            .addProperty(SHAPE, new Cube(10)).addProperty(DURATION, ONE_HOUR)
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L5, SpellLevel::getValue))
            .build();
    public static final Spell CREATE_FOOD_AND_WATER = builder().name("Create Food and Water")
            .description("You create 45 pounds of food and 30 gallons of water on the ground or in containers within range, enough to sustain up to fifteen humanoids or five steeds for 24 hours. The food is bland but nourishing, and spoils if uneaten after 24 hours. The water si clean and doesn't go bad.")
            .type(CONJURATION).level(L3).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, true))
            .addProperty(WEIGHT, 45.0).addProperty(VOLUME, 30).addProperty(DURATION, ONE_DAY)
            .build();
    //TODO left off here 216
    public static final Spell DIVINATION = builder().name("Divination")
            .build();
    public static final Spell DREAM = builder().name("Dream")
            .build();
    public static final Spell FREEDOM_OF_MOVEMENT = builder().name("Freedom of Movement")
            .build();
    public static final Spell GASEOUS_FORM = builder().name("Gaseous Form")
            .build();
    public static final Spell GREATER_INVISIBILITY = builder().name("Greater Invisibility")
            .build();
    public static final Spell HALLUCINATORY_TERRAIN = builder().name("Hallucinatory Terrain")
            .build();
    public static final Spell HASTE = builder().name("Haste")
            .build();
    public static final Spell HOLD_PERSON = builder().name("Hold Person")
            .build();
    public static final Spell INVISIBILITY = builder().name("Invisibility")
            .build();
    public static final Spell LIGHTNING_BOLT = builder().name("Lightning Bolt")
            .build();
    public static final Spell LOCATE_CREATURE = builder().name("Locate Creature")
            .build();
    public static final Spell MELD_INTO_STONE = builder().name("Meld Into Stone")
            .build();
    public static final Spell MELFS_ACID_ARROW = builder().name("Melf's Acid Arrow")
            .build();
    public static final Spell MISTY_STEP = builder().name("Misty Step")
            .build();
    public static final Spell PASSWALL = builder().name("Passwall")
            .build();
    public static final Spell PROTECTION_FROM_ENERGY = builder().name("Protection From Energy")
            .build();
    public static final Spell SILENCE = builder().name("Silence")
            .build();
    public static final Spell SLOW = builder().name("Slow")
            .build();
    public static final Spell SPIDER_CLIMB = builder().name("Spider Climb")
            .build();
    public static final Spell STINKING_CLOUD = builder().name("Stinking Cloud")
            .build();
    public static final Spell STONESKIN = builder().name("Stoneskin")
            .build();
    public static final Spell STONE_SHAPE = builder().name("Stone Shape")
            .build();
    public static final Spell WALL_OF_STONE = builder().name("Wall of Stone")
            .build();
    public static final Spell WATER_BREATHING = builder().name("Water Breathing")
            .build();
    public static final Spell WATER_WALK = builder().name("Water Walk")
            .build();
    public static final Spell WEB = builder().name("Web")
            .build();
    public static final Spell ACID_SPLASH = builder().name("Acid Splash")
            .addLineToDescription("You hurl a bubble of acid. Choose on creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.")
            .addLineToDescription("This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).")
            .type(CONJURATION).level(CANTRIP).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, true))
            .addProperty(SAVING_THROW, DEXTERITY).addProperty(DAMAGE_TYPE, ACID)
            .addProperty(INTEGER_DICE_MAP, ImmutableMap.<Integer, Dice>builder().put(1, new Dice(6)).put(5, new Dice(6, 2)).put(11, new Dice(6, 3)).put(17, new Dice(6, 4)).build())
            .build();
    public static final Spell AID = builder().name("Aid")
            .addLineToDescription("Your spell bolsters your allies with toughness and resolve. Choose up to three creatures within range. Each target's hit point maximum and current hit points increase by 5 for the duration.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, a target's hit points increase by an additional 5 for each slot level above 2nd.")
            .type(ABJURATION).level(L2).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, true, "a tiny strip of white cloth")).duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L2, level -> 5 * (level.getValue() - 1)))
            .build();
    public static final Spell ALARM = builder().name("Alarm")
            .addLineToDescription("You set an alarm against unwanted intrusion. Choose a door, a window, or an area within range that is no larger than a 20-foot cube. Until the spell ends, an alarm alerts you whenever a Tiny or larger creature touches or enters the warded area. When you cast the spell, you can designate creatures that won't set off the alarm. You also choose whether the alarm is mental or audible.")
            .addLineToDescription("A mental alarm alerts you with a ping in your mind if you are within 1 mile of the warded area. This ping awakens you if you are sleeping.")
            .addLineToDescription("An audible alarm produces the sound of a hand bell for 10 seconds within 60 feet.")
            .type(ABJURATION).level(L1).castingTime(ActionTimes.ONE_MINUTE).range(30)
            .components(SpellComponents.of(true, true, "a tiny bell and a piece of fine silver wire")).duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .build();
    public static final Spell ALTER_SELF = builder().name("Alter Self")
            .description("You assume a different form. When you cast the spell, choose one of the following options, the effects of which last for the duration of the spell. While the spell lasts, you can end on option as an action to gain the benefits of a different one.")
            .type(TRANSMUTATION).level(L2).castingTime(ACTION).range(30).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .addProperty(SPELL_EFFECTS, AlterSelfSpellEffects.ALL)
            .build();
    public static final Spell ANIMAL_FRIENDSHIP = builder().name("Animal Friendship")
            .addLineToDescription("This spell lets you convince a beast that you mean it no harm. Choose a beast that you can see within range. It must see and hear you. If the beast's Intelligence is 4 or higher, the spell fails. Otherwise, the beast must succeed on a Wisdom saving throw or be charmed by you for the spell's duration. If you or one of your companions harms the target, the spell ends.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can affect one additional beast for each slot level above 1st.")
            .type(ENCHANTMENT).level(L2).castingTime(ACTION).range(30).components(SpellComponents.of(true, true, "a morsel of food"))
            .duration(SpellDuration.of(ActionTimes.ONE_DAY))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L2, SpellLevel::getValue))
            .addProperty(SAVING_THROW, WISDOM)
            .build();
    public static final Spell ANIMAL_MESSENGER = builder().name("Animal Messenger")
            .addLineToDescription("By means of this spell, you use an animal to deliver a message. Choose a Tiny beast you can see within range, such as a squirrel, a blue jay, or a bat. You specify a location, which you must have visited, and a recipient who matches a general description, such as \"a man or woman dressed in the uniform of the town guard\" or \"a red-haired dwarf wearing a pointed hat.\" You also speak a message of up to twenty-five words. The target beast travels for the duration of the spell toward the specified location, covering about 50 miles per 24 hours for a flying messenger, or 25 miles for other animals.")
            .addLineToDescription("When the messenger arrives, it delivers your message to the creature that you described, replicating the sound of your voice. The messenger speaks only to a creature matching the description you gave. If the messenger doesn't reach its destination before the spell ends, the message is lost, and the beast makes its way back to where you cast this spell.")
            .addLineToDescription("At Higher Levels: If you cast this spell using a spell slot of 3rd level or higher, the duration of the spell increases by 48 hours for each slot level above 2nd.")
            .type(ENCHANTMENT).level(L2).isRitual(true).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, true, "a morsel of food"))
            //This spell has a special condition that changes duration based on the Spell Slot used to cast the spell.
            .duration(SpellDuration.of(-1))
            .addProperty(SPELL_LEVEL_DOUBLE_MAP, populateSpellLevelDoubleMap(L2, level -> ActionTimes.ONE_DAY + (level.getValue() - 2) * ActionTimes.TWO_DAYS))
            .build();
    public static final Spell ANIMAL_SHAPES = builder().name("Animal Shapes")
            .addLineToDescription("Your magic turns others into beasts. Choose any number of willing creatures that you can see within range. you transform each target into the form of a Large or smaller beast with a challenge rating of 4 or lower. On subsequent turns, you can use your action to transform affected creatures into new forms.")
            .addLineToDescription("The transformation lasts for the duration for each target, or until the target drops to 0 hit points or dies. You can choose a different form for each target. A target's game statistics are replaced by the statistics of the chosen beast, though the target retains its alignment and Intelligence, Wisdom, and Charisma scores. The target assumes the hit points. The target assumes the hit points of its new form, and when it reverts to its normal form, it returns to the number of hit points it had before it transformed. If it reverts as a result of dropping to 0 hit points, any excess damage carries over to its normal form. As long as the excess damage doesn't reduce the creature's normal form to 0 hit points, it isn't knocked unconscious. The creature is limited in th actions it can perform by the nature of its new form, and it can't speak or cast spells.")
            .addLineToDescription("The target's gear melds into the new form. The target can't activate, wield, or otherwise benefit from any of its equipment.")
            .type(TRANSMUTATION).level(L8).castingTime(ACTION).range(30).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_DAY, true))
            .build();
    public static final Spell ANIMATE_DEAD = builder().name("Animate Dead")
            .addLineToDescription("This spell creates an undead servant. Choose a pile of bones or a corpse of Medium or Small humanoid within range. Your spell imbues the target with a foul mimicry of life, raising it as an undead creature. The target becomes a skeleton if you chose bones or a zombie if you chose a corpse (the DM has the creature's game statistics).")
            .addLineToDescription("On each of your turns, you can use a bonus action to mentally command any creature you made with this spell if the creature is within 60 feet of you (if you control multiple creatures, you can command any or all of them at the same time, issuing the same command to each one). You decide what action the creature will take and where it will move during its next turn, or you can issue a general command, such as to guard a particular chamber or corridor. If you issue no commands, the creature only defends itself against hostile creatures. Once given an order, the creature continues to follow it until its task is complete.")
            .addLineToDescription("The creature is under your control for 24 hours, after which it stops obeying any command you've given it. To maintain control of the creature for another 24 hours, you must cast this spell on the creature again before the current 24-hour period ends. This use of the spell reasserts your control over up to four creatures you have animated with this spell, rather than animating a new one.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 4th level or higher, you animate or reassert control over two additional undead creatures for each slot level above 3rd. Each of the creatures must come from a different corpse or pile of bones.")
            .type(NECROMANCY).level(L3).castingTime(ActionTimes.ONE_MINUTE).range(10)
            .components(SpellComponents.of(true, true, "a drop of blood, a piece of flesh, and a pinch of bone dust"))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L3, level -> level.getValue() - 2))
            .build();
    public static final Spell ANIMATE_OBJECTS = builder().name("Animate Objects")
            .addLineToDescription("Objects come to life at your command. Choose up to ten nonmagical objects within range that are not being worn or carried. Medium targets count as two objects, Large targets count as four objects. Huge targets count as eight objects. You can't animate any object larger than Huge. Each target animates and becomes a creature under your control until the spell ends or until reduced to 0 hit points")
            .addLineToDescription("As a bonus action, you can mentally command any creature you made with this spell if the creature is within 500 feet of you (if you control multiple creatures, you can command any or all of them at the same time, issuing the same command to each one). You decide what action the creature will take and where it will move during its next turn, or you can issue a general command, such as to guard a particular chamger or corridor. If you issue no commands, the creature only defends itself against hostile creatures. Once given an order, the creature continues to follow it until its task is complete.")
            .addLineToDescription("An animated object is a construct with AC, hit points, attacks, Strength, and Dexterity determined by its size.")
            .addLineToDescription("Its Constitution is 10 and its Intelligence and Wisdom are 3, and its Charisma is 1. Its speed is 30 feet; if the object lacks legs or other appendages it can use for locomotion, it instead has a flying speed of 30 feet and can hover. If the object is securely attached to a surface or a larger object, such as a chain bolted to a wall, its speed is 0. It has blindsight with a radius of 30 feet and is blind beyond that distance. When the animated object drops to 0 hit points, it reverts to its original object form, and any remaining damage carries over to its original object form.")
            .addLineToDescription("If you command an object to attack, it can make a single melee attack against a creature within 5 feet of it. It makes a slam attack with an attack bonus and bludgeoning damage determined by its size. The DM might rule that a specific object inflicts slashing or piercing damage based on its form.")
            .addLineToDescription("At Higher Levels: If you cast this spell using a spell slot of 6th level or higher, you can animate two additional objects for each slot level above 5th.")
            .type(TRANSMUTATION).level(L5).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L5, level -> level.getValue() * 2))
            .addProperty(TABLE, Table.builder().name("Animated Object Statistics")
                    .addColumn(SIZE_COLUMN, Arrays.asList(CharacterSizes.TINY, CharacterSizes.SMALL, CharacterSizes.MEDIUM, CharacterSizes.LARGE, CharacterSizes.HUGE))
                    .addColumn(HP_COLUMN, Arrays.asList(20, 25, 40, 50, 80)).addColumn(AC_COLUMN, Arrays.asList(18, 16, 13, 10, 10))
                    .addColumn(ATTACK_COLUMN, Arrays.asList("+8 to hit, 1d4 + 4 damage", "+6 to hit, 1d8 + 2 damage", "+5 to hit, 2d6 + 1 damage", "+6 to hit, 2d10 + 2 damage", "+8 to hit, 2d12 + 4 damage"))
                    .addColumn(STR_COLUMN, Arrays.asList(4, 6, 10, 14, 18)).addColumn(DEX_COLUMN, Arrays.asList(18, 14, 12, 10, 6))
                    .build()).build();
    public static final Spell ANTILIFE_SHELL = builder().name("Antilife")
            .addLineToDescription("A shimmering barrier extends out from you in a 10-foot radius and moves with you, remaining centered on you and hedging out creatures other than undead and constructs. The barrier lasts for the duration.")
            .addLineToDescription("The barrier prevents an affected creature from passing or reaching through. An affected creature can cast spells or make attacks with ranged or reach weapons through the barrier.")
            .addLineToDescription("If you move so that an affected creature is forced to pass through the barrier, the spell ends.")
            .type(ABJURATION).level(L5).castingTime(ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true)).build();
    public static final Spell ANTIMAGIC_FILED = builder().name("Antimagic Field")
            .addLineToDescription("A 10-foot-radius invisible sphere of antimagic surrounds you. This area is divorced from the magical energy that suffuses the multiverse. Within the sphere, spells can't be cast, summoned creatures disappear, and even magic items become mundane. Until the spell ends, the sphere moves with you, centered on you.")
            .addLineToDescription("Spells and other magical effects, except those created by an artifact or a deity, are suppressed in the sphere and can't protrude into it. A slot expended to cast a suppressed spell is consumed. While an effect is suppressed, it doesn't function, but the time it spends suppressed counts against its duration.")
            .type(ABJURATION).level(L8).castingTime(ACTION)
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
            .addLineToDescription("You create an invisible, magical eye within range that hovers in the air for the duration.")
            .addLineToDescription("You mentally receive visual information from the eye, which has a normal vision and darkvision out to 30 feet. The eye can look in every direction.")
            .addLineToDescription("As an action, you can move the eye up to 30 feet in any direction. There is no limit to how far away from you the eye can move, but it can't enter another plane of existence. A solid barrier blocks the eye's movement, but the eye can pass through an opening as small as 1 inch in diameter.")
            .type(SpellTypes.DIVINATION).level(L4).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, true, "a bit of bat fur")).duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .build();
    public static final Spell ARCANE_LOCK = builder().name("Arcane Lock")
            .addLineToDescription("You touch a closed door, window, gate, chest, or other entryway, and it becomes locked for the duration. You and the creatures you designate when you cast this spell can open the object normally. You can also set a password that, when spoken within 5 feet of the object, supresses this spell for 1 minute. Otherwise, it is impassible until it is broken or the spell is dispelled or suppresed. Casting Knock on the object suppresses Arcane Lock for 10 minutes.")
            .addLineToDescription("While affected by this spell, the object is more difficult to break or force open; the DC to break it or pick any locks on it increases by 10.")
            .type(ABJURATION).level(L2).castingTime(ACTION)
            .components(SpellComponents.of(true, true, "gold dust worth at least 25 gp, which the spell consumes"))
            /* Spell ends when dispelled */
            .duration(SpellDuration.of(-1))
            .addProperty(DUAL_INTEGER_FUNCTION, dc -> dc + 10)
            .build();
    public static final Spell ARMOR_OF_AGATHYS = builder().name("Armor of Agathys")
            .addLineToDescription("A protective magical force surrounds you, manifesting as a spectral frost that covers you and your gear. You gain 5 temporary hit points for the duration. If a creature hits you with a melee attack while you have these hit points, the creature takes 5 cold damage.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, both the temporary hit points and the cold damage increase by 5 for each slot level above 1st.")
            .type(ABJURATION).level(L1).castingTime(ACTION).components(SpellComponents.of(true, true, "a cup of water"))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, level -> level.getValue() * 5))
            .addProperty(DAMAGE_TYPE, COLD)
            .build();
    public static final Spell ARMS_OF_HADAR = builder().name("Arms of Hadar")
            .addLineToDescription("You invoke the power of Hadar, the Dark Hunger. Tendrils of dark energy erupt from you and batter all creatures within 10 feet of you. Each creature in that area must make a Strength saving throw. On a failed save, a target takes 2d6 necrotic damage and can't take reactions until its next turn. On a successful save, the creature takes half damage, but suffers no other effect.")
            .addLineToDescription("At HigherLevels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.")
            .type(CONJURATION).level(L1).components(SpellComponents.of(true, true))
            .addProperty(DAMAGE_TYPE, NECROTIC)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L1, 6, level -> level.getValue() + 1))
            .build();
    public static final Spell ASTRAL_PROJECTION = builder().name("Astral Projection")
            .addLineToDescription("You and up to eight willing creatures within range project your astral bodies into the Astral Plane (the spell fails and the casting is wasted if you are already on that plane). The material body you leave behind is unconscious and in a state of suspended animation; it doesn't need food or air and doesn't age.")
            .addLineToDescription("Your astral body resembles your mortal form in almost every way, replicating your game statistics and possessions. The principal difference is the addition of a silvery cord that extends from between your shoulder blades and trails behind you, fading to invisibility after 1 foot. This cord is your tether to your material body. As long as the thether remains intact, you can find your way home. If the cord is cut-something that can happen only when an effect specifically states that it does-your soul and body are separated, killing you instantly.")
            .addLineToDescription("Your astral form can freely travel through the Astral Plane and can pass through portals there leading to any other plane. If you enter a new plane or return to the plane you were on when casting this spell, your body and possesions are transported along the silver cord, allowing you to re-enter your body as you enter the new plane. Your astral form is a separate incarnation. Any damage or other effects that apply to it have no effect on your physical body nor do they persist when you return to it.")
            .addLineToDescription("The spell ends for you and your companions when you use your action to dismiss it. When the spell ends, the affected creature returns to its physical body, and it awakens.")
            .addLineToDescription("The spell might also end early for you or one of your companions. A successful Dispel Magic spell used against an astral or physical body ends the spell for that creature. If a creature's original body or its astral form drops to 0 hit points, the spell ends for that creature. If the spell ends and the silver cord is intact, the cord pulls the creature's astral form back to its body, ending its state of suspended animation.")
            .addLineToDescription("If you are returned to your body prematurely, your companions remain in their astral forms and must find their own way back to their bodies, usually by dropping to 0 hit points.")
            .type(NECROMANCY).level(L9)
            /* Special Conditions */
            .duration(SpellDuration.of(-1))
            .components(SpellComponents.of(true, true, "for each creature you affect with this spell, you must provide one jacinth worth at least 1,000 gp and one ornately carved bar of silver worth at least 100 gp, all of which the spell consumes"))
            .build();
    public static final Spell AUGURY = builder().name("Augury")
            .addLineToDescription("By casting gem-inlaid sticks, rolling dragon bones, laying out ornate cards, or employing some other divining tool, you receive an omen from an otherworldly entity about the results of a specific course of action that you plan to take within the next 30 minutes. The DM chooses from the following possible omens:")
            .addLineToDescription("- Weal, for good results")
            .addLineToDescription("- Woe, for bad results")
            .addLineToDescription("- Weal and woe, for both good and bad results")
            .addLineToDescription("- Nothing, for results that aren't especially good or bad")
            .addLineToDescription("The spell doesn't take into account any possible circumstances that might change the outcome, such as the casting of additional spells or the loss or gain of a companion.")
            .addLineToDescription("If you cast the spell two or more times before completing your next long rest, there is a cumulative 25 percent chance for each casting after the first that you get a random reading. The DM makes this roll in secret.")
            .type(SpellTypes.DIVINATION).level(L2).castingTime(ActionTimes.ONE_MINUTE)
            .components(SpellComponents.of(true, true, "specially marked sticks, bones, or similar tokens worth at least 25 gp"))
            .build();
    public static final Spell AURA_OF_LIFE = builder().name("Aura of Life")
            .description("Life-preserving energy radiates from you in an aura with a 30-foot radius. Until the spell ends, the aura moves with you, centered on you. Each nonhostile creature in the aura (including you) has resistance to necrotic damage, and its hit point maximum can't be reduced. In addition, a nonhostile, living creature regains 1 hit point when it starts its turn in the aura with 0 hit points.")
            .castingTime(ACTION).components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE * 10, true))
            .addProperty(DAMAGE_TYPE, NECROTIC)
            .build();
    public static final Spell AURA_OF_PURITY = builder().name("Aura of Purity")
            .description("Purifying energy radiates from you in an aura with a 30-foot radius. Until the spell ends, the aura moves with you, centered on you. Each nonhostile creature in the aura (including you) can't become diseased, has resistance to poison damage, and has advantage on saving throws against effects that cause any of the following conditions: blinded, charmed, deafened, frightened, paralyzed, poisoned, and stunned.")
            .type(ABJURATION).level(L4).components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE * 10, true))
            .addProperty(DAMAGE_TYPE, POISON)
            .addProperty(CONDITIONS, Arrays.asList(Conditions.BLINDED, CHARMED, Conditions.DEAFENED, Conditions.FRIGHTENED, Conditions.PARALYZED, Conditions.POISONED, Conditions.STUNNED))
            .build();
    public static final Spell BARKSKIN = builder().name("Barkskin")
            .description("You touch a willing creature. Until the spell ends, the target's skin has a rough, bark-like appearance, and the target's AC can't be less than 16, regardless of what kind of armor it is wearing.")
            .type(TRANSMUTATION).level(L2).castingTime(ACTION)
            .components(SpellComponents.of(true, true, "a handful of oak bark"))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .build();
    public static final Spell BEACON_OF_HOPE = builder().name("Beacon of Hope")
            .description("This spell bestows hope and vitality. Choose any number of creatures within range. For the duration, each target has advantage on Wisdom saving throws and death saving throws, and regains the maximum number of hit points possible from any healing.")
            .type(ABJURATION).level(L3).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .build();
    public static final Spell BEAST_SENSE = builder().name("Beast Sense")
            .addLineToDescription("You touch a willing beast. For the duration of the spell, you can use your action to see through the beast's eyes and hear what it hears, and continue to do so until you use your action to return to your normal senses.")
            .addLineToDescription("While perceiving through the beast's senses, you gain the benefits of any special senses possessed by that creature, though you are blinded and deafened to your own surroundings.")
            .isRitual(true).type(SpellTypes.DIVINATION).level(L2).castingTime(ACTION)
            .components(SpellComponents.of(false, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .build();
    public static final Spell BLESS = builder().name("Bless")
            .addLineToDescription("You bless up to three creatures of your choice within range. Whenever a target makes an attack roll or a saving throw before the spell ends, the target can roll a d4 and add the number rolled to the attack roll or saving throw.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can target one additional creature for each slot level above 1st.")
            .type(ENCHANTMENT).level(L1).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, true, "a sprinkling of holy water"))
            .duration(SpellDuration.of(60, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, SpellLevel::getValue))
            .build();
    public static final Spell BLINK = builder().name("Blink")
            .addLineToDescription("Roll a d20 at the end of each of your turns for the duration of the spell. On a roll of 11 or higher, you vanish from your current plane of existence and appear in the Ethereal Plane (the spell fails and the casting is wasted if you were already on that plane). At the start of your next turn, and when the spell ends if you are on the Ethereal Plane, you return to an unoccupied space of your choice that you can see within 10 feet of the space you vanished from. If no unoccupied space is available within range, you appear in the nearest unoccupied space (chosen at random if more than one space is equally near). You can dismiss this spell as an action.")
            .addLineToDescription("While on the Etheral Plane, you can see and hear the plane you originated from, which is cast in shades of gray, and you can't see anything there more than 60 feet away. You can only affect and be affected by other creatures on the Ethereal Plane. Creatures that aren't there can't perceive you or interact with you unless they have the ability to do so.")
            .type(TRANSMUTATION).level(L3).castingTime(ACTION)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .addProperty(DICE, new Dice(20)).addProperty(MIN_ROLL, 11).addProperty(VISIBILITY_RANGE, 60)
            .build();
    public static final Spell BURNING_HANDS = builder().name("Burning Hands")
            .addLineToDescription("As you hold your hands with thumbs touching and fingers spread, a thin sheet of flames shoots forth from your outstretched fingertips. Each creature in a 15-foot cone must make a Dexterity saving throw. A creature takes 3d6 fire damage on a failed save, or half as much damage on a successful one.")
            .addLineToDescription("The fire ignites any flammable objects in the area that aren't being worn or carried.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d6 for each slot level above 1st.")
            .type(EVOCATION).level(L1).castingTime(ACTION).range(15)
            .components(SpellComponents.of(true, true))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L1, 6, level -> level.getValue() + 2))
            .build();
    public static final Spell CALL_LIGHTNING = builder().name("Call Lightning")
            .addLineToDescription("A storm cloud appears in the shape of a cylinder that is 10 feet tall with a 60-foot radius, centered on a point you can see 100 feet directly above you. The spell fails if you can't see a point in the air where the storm cloud could appear (for example, if you in a room that can't accommodate the cloud).")
            .addLineToDescription("When you cast the spell, choose a point you can see within range. A bolt of lightning flashes down from the cloud from that point. Each creature within 5 feet of that point must make a Dexterity saving throw. A creature takes 3d10 lightning damage on a failed save, or half as much damage on a successful one. On each of your turns until the spell ends, you can use your action to call down lightning in this way again, targeting the same point or a different one.")
            .addLineToDescription("If you are outdoors in stormy conditions when you cast this spell, the spell gives you control over the existing storm instead of creating a new one. Under such conditions, the spell's damage increases by 1d10.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 4th or higher level, the damage increases by 1d10 for each slot level above 3rd.")
            .type(CONJURATION).level(L3).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(600, true))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L3, 10, level -> level.getValue() - 1))
            .addProperty(DAMAGE_TYPE, LIGHTNING).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell CHARM_PERSON = builder().name("Charm Person")
            .addLineToDescription("You attempt to charm a humanoid you can see within range. It must make a Wisdom saving throw, and does so with advantage if you or your companions are fighting it. If it fails the saving throw, it is charmed by you until the spell ends or until you or your companions do anything to harmful to it. The charmed creature regards you as a friendly acquaintance. When the spell ends the creature knows it was charmed by you.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can target one additional ceature for each slot level above 1st. The creatures must be within 30 feet of each other when you target them.")
            .type(ENCHANTMENT).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_HOUR))
            .addProperty(ABILITY_SCORE_TYPE, WISDOM).addProperty(CONDITION, CHARMED).addProperty(MAX_RANGE, 30)
            .build();
    public static final Spell COMMAND = builder().name("Command")
            .addLineToDescription("You speak a one-word command to a creature you can see within range. The target must succeed on a Wisdom saving throw or follow the command on its next turn. The spell has no effect if the target is undead, if it doesn't understand your language, or if your command is directly harmful to it.")
            .addLineToDescription("Some typical commands and their effects follow You might issue a command other than one described here. If you do so, the DM determines how the target behaves. If the target can't follow your command, the spell ends.")
            .addLineToDescription("- Approach: The target moves toward you by the shortest and most direct route, ending its turn if it moves within 5 feet you.")
            .addLineToDescription("- Drop: The target drops whatever it is holding end then ends its turn.")
            .addLineToDescription("- Flee: The target spends its turn moving away from you by the fastest available means.")
            .addLineToDescription("- Grovel: The target falls prone and then ends its turn.")
            .addLineToDescription("- Halt: The target doesn't move and takes no actions. A flying creature stays aloft, provided that it is able to do so. If it must move to stay aloft, it flies the minimum distance needed to remain in the air.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, you can affect one additional creature for each slot level above 1st. The creatures must be within 30 feet of each other when you target them.")
            .type(ENCHANTMENT).level(L1).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(6))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, SpellLevel::getValue))
            .build();
    public static final Spell COMMUNE_WITH_NATURE = builder().name("Commune with Nature")
            .addLineToDescription("You briefly become one with nature and gain knowledge of the surrounding territory. In the outdoors, the spell gives you knowledge of the land within 3 miles of you. In caves and other natural underground settings, the radius is limited to 300 feet. The spell doesn't function where nature has been replaced by construction, such as in dungeons and towns.")
            .addLineToDescription("You instantly gain knowledge of up to three facts of your choice about any of the following subjects as they relate to the area:")
            .addLineToDescription("- terrain and bodies of water")
            .addLineToDescription("- prevalent plants, minerals, animals, or peoples")
            .addLineToDescription("- influence from other planes of existence")
            .addLineToDescription("- buildings")
            .addLineToDescription("For example, you could determine the location of powerful undead in the are, the location of major sources of safe drinking water, and the location of any nearby towns.")
            .isRitual(true).type(SpellTypes.DIVINATION).level(L5).castingTime(ActionTimes.ONE_MINUTE)
            .components(SpellComponents.of(true, true))
            .build();
    public static final Spell CONFUSION = builder().name("Confusion")
            .addLineToDescription("This spell assaults and twists creatures' minds, spawning delusions and provoking uncontrolled action. Each creature in a 10-foot-radius sphere centered on a point you choose within range must succeed on a Wisdom saving throw when you cast this spell or be affected by it.")
            .addLineToDescription("An affected target can't take reactions and must roll a d10 at the start of each of its to determine its behavior for that turn.")
            .addLineToDescription("At the end of each of its turns, an affected target can make a Wisdom saving throw. If it succeeds, this effect ends for that target.")
            .addLineToDescription("At Higher Levels:When you cast this spell using a spell slot of 5th level or higher, the radius of the sphere increases by 5 feet for each slot level above 4th.")
            .type(ENCHANTMENT).level(L4).castingTime(ACTION).range(90)
            .components(SpellComponents.of(true, true, "three nut shells"))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L4, level -> level.getValue() * 5 + 70))
            .addProperty(INTEGER_STRING_MAP, ImmutableMap.<Integer, String>builder().put(1, "The creature uses all its movement to move in a random direction. To determine the direction, roll a d8 and assign a direction to each die face. The creature doesn't take an action this turn.").put(2, "The creature doesn't move or take actions this turn.").put(7, "The creature uses its action to make a melee attack against a randomly determined creature within its reach. If there is no creature within its reach, the creature does nothing this turn.").put(9, "The creature can act and move normally.").build())
            .build();
    public static final Spell CONTROL_WATER = builder().name("Control Water")
            .description("Until the spell ends, you control any freestanding water inside an area you choose that is a cube up to 100 feet on a side. You can choose from any of the following effects when you cast this spell. As an action on your turn, you can repeat the same effect or choose a different one.")
            .type(TRANSMUTATION).level(L4).castingTime(ACTION).range(300)
            .components(SpellComponents.of(true, true, "a drop of water and a pinch of dust"))
            .duration(SpellDuration.of(600, true))
            .addProperty(SPELL_EFFECTS, ControlWaterSpellEffects.ALL)
            .build();
    public static final Spell CRUSADERS_MANTLE = builder().name("Crusader's Mantle")
            .description("Holy power radiates from you in an aura with a 30-foot radius, awakening boldness in friendly creatures. Until the spell ends, the aura moves with you, centered on you. While in the aura, each nonhostile creature in the aura (including you) deals an extra 1d4 radiant damage when it hits with a weapon attack.")
            .type(EVOCATION).level(L3).castingTime(ACTION).components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(ONE_MINUTE, true))
            .addProperty(INTEGER, 30).addProperty(DAMAGE, new Damage(RADIANT, new Dice(4)))
            .build();
    public static final Spell CURE_WOUNDS = builder().name("Cure Wounds")
            .addLineToDescription("A creature you touch regains a number of hit points equal to 1d8 + your spellcasting ability modifier. This spell has no effect on undead or constructs.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the healing increases by 1d8 for each slot level above 1st.")
            .type(EVOCATION).level(L1).castingTime(ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(0, false))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, SpellLevel::getValue))
            .build();
    public static final Spell DANCING_LIGHTS = builder().name("Dancing Lights")
            .addLineToDescription("You create up to four torch-sized lights within range, making them appear as torches, lanterns, or glowing orbs that hover in the air for the duration. You can also combine the four lights into one glowing vaguely humanoid form of Medium size. Whichever form you choose, each light sheds dim light in a 10-foot radius.")
            .addLineToDescription("As a Bonus action on your turn, you can move the lights up to 60 feet to a new spot within range. A light must be within 20 feet of anther light created by this spell, and a light winks out if it exceeds the spell's range.")
            .type(EVOCATION).level(CANTRIP).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true, "a bit of phosphorus or wychwood, or a glowworm"))
            .duration(SpellDuration.of(60, true))
            .build();
    public static final Spell DARKNESS = builder().name("Darkness")
            .addLineToDescription("Magical darkness spreads from a point you choose within range to fill a 15-foot-radius sphere for the duration. The darkness spreads around corners. A creature with darkvision can't see through this darkness, and nonmagical light can't illuminate it.")
            .addLineToDescription("If the point you choose is on an object you are holding or one that isn't being worn or carried, the darkness emanates from the object and moves with it. Completely covering the source of the darkness with an opaque object, such as a bowl or a helm, blocks the darkness.")
            .addLineToDescription("If any of this spell's are overlaps with an area of light created by a spell of 2nd level or lower, the spell that created the light is dispelled.")
            .type(EVOCATION).level(L2).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, false, "bat fur and a drop of pitch or piece of coal"))
            .duration(SpellDuration.of(600, true))
            .build();
    public static final Spell DAYLIGHT = builder().name("Daylight")
            .addLineToDescription("A 60-foot-radius sphere of light spreads out from a point you choose within range. The sphere is bright light and sheds dim light for an additional 60 feet.")
            .addLineToDescription("If you chose a point on an object you are holding or one that isn't being worn or carried, the light shines from the object and moves with it. Completely covering the affected object with an opaque object, such as a bowl, or a helm, blocks the light.")
            .addLineToDescription("if any of this spell's area overlaps with an area of darkness created by a spell of 3rd level or lower, the spell that created the darkness is dispelled.")
            .type(EVOCATION).level(L3).castingTime(ACTION).range(60).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR))
            .build();
    public static final Spell DEATH_WARD = builder().name("Death Ward")
            .addLineToDescription("You touch a creature and grant it a measure of protection from death.")
            .addLineToDescription("The first time the target would drop to 0 hit points as a result of taking damage, the target instead drops to 1 hit point, and the spell ends.")
            .addLineToDescription("If the spell is still in effect when the target is subjected to an effect that would kill it instantaneously without dealing damage, that effect is instead negated against the target, and the spell ends.")
            .type(ABJURATION).level(L4).castingTime(ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .build();
    public static final Spell DESTRUCTIVE_WAVE = builder().name("Destructive Wave")
            .description("You strike the ground, creating a burst of divine energy that ripples outward from you. Each creature you choose within 30 feet of you must succeed on a Constitution saving throw or take 5d6 thunder damage, as well as 5d6 radiant or necrotic damage (your choice), and be knocked prone. A creature that succeeds on its saving throw takes half as much damage and isn't knocked prone.")
            .type(EVOCATION).level(L5).castingTime(ACTION).components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(0))
            .build();
    public static final Spell DIMENSION_DOOR = builder().name("Dimension Door")
            .addLineToDescription("You teleport yourself from your current location to any other spot within range. You arrive at exactly the spot desired. It can be a place you can see, one you can visualize, or one you can describe by stating distance and direction, such as \"200 feet straight downward\" or \"upward to the northwest at a 45-degree angle, 300 feet.\"")
            .addLineToDescription("You can bring along objects as long as their weight doesn't exceed what you can carry. You can also bring one willing creature of your size or smaller who is carrying gear up to its carrying capacity. The creature must be within 5 feet of you when you cast this spell.")
            .addLineToDescription("if you would arrive in a place already occupied by an object or a creature, you and any creature traveling with you each take 4d6 force damage, and the spell fails to teleport you.")
            .type(CONJURATION).level(L4).range(500).castingTime(ACTION)
            .components(SpellComponents.of(true, false))
            .addProperty(DAMAGE, new Damage(FORCE, new Dice(6, 4)))
            .addProperty(MAX_RANGE, 5)
            .build();
    public static final Spell DISGUISE_SELF = builder().name("Disguise Self")
            .addLineToDescription("You make yourself - including your clothing, armor, weapons, and other belongings on your person - look different until the spell ends or until you use your action to dismiss it. You can seem 1 foot shorter or taller and appear thin, fat, or in between. You can't change your body type, so you must adopt a form that has the same basic arrangement of limbs. Otherwise, the extent of the illusion is up to you.")
            .addLineToDescription("The changes wrought by this spell fail to hold up to physical inspection. Otherwise, the extent of the illusion is up to you. For example, if you use this spell to add a hat to your outfit, objects pass through the hat, and anyone who toches it would feel nothing or would feel your head and hair. If you use this spell to appear thinner than you are, the hand of someone who reaches out to touch you would bump into you while it was seemingly still in midair.")
            .addLineToDescription("To discern that you are disguised, a creature can use its action to inspect your appearance and must succeed on an Intelligence (Investigation) check against your spell save DC.")
            .type(ILLUSION).level(L1).castingTime(ACTION)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_HOUR))
            .addProperty(SKILL_TYPE, INVESTIGATION)
            .build();
    public static final Spell DISPEL_MAGIC = builder().name("Dispel Magic")
            .addLineToDescription("Choose one creature, object, or magical effect within range. Any spell of 3rd level or lower on the target ends. For each spell of 4th level  or higher on the target, make an ability check using your spellcasting ability. The DC equals 10 the spell's level. On a successful check, the spell ends.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 4th level or higher, you automatically end the effects of a spell on the target if the spell's level is equal to or less than the level of the spell slot you used.")
            .type(ABJURATION).level(L3).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true))
            .addProperty(DUAL_INTEGER_FUNCTION, level -> 10 + level)
            .build();
    public static final Spell DIVINE_FAVOR = builder().name("Divine Favor")
            .description("Your prayer empowers you with divine radiance. Until the spell ends, your weapon attacks deal an extra 1d4 radiant damage on a hit.")
            .type(EVOCATION).level(L1).castingTime(ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ONE_MINUTE, true))
            .addProperty(DAMAGE, new Damage(RADIANT, new Dice(4)))
            .build();
    public static final Spell DOMINATE_BEAST = builder().name("Dominate Beast")
            .addLineToDescription("You attempt to beguile a beast that you can see within range. It must succeed on a Wisdom saving throw or be charmed by you for the duration. If you or creatures that are friendly to you are fighting it, it has advantage on the saving throw.")
            .addLineToDescription("While the beast is charmed, you have a telepathic link with it as long as the two of you are on the same plane of existence. You can use this telepathic link to issue commands to the creature while you are conscious (no action required), which it does its best to obey. You can specify a simple and general course of action, such as \"Attack that creature,\" \"Run over there,\", or \"Fetch that object.\" If the creature completes the order and doesn't receive further direction from you, it defends and preserves itself to the best of its ability.")
            .addLineToDescription("You can use your action to take total and precise control of the target. until the end of your next turn, the creature takes only the actions you choose, and doesn't do anything that you don't allow it to do. During this time, you can also cause the creature to use a reaction, but this requires you to use your own reaction as well.")
            .addLineToDescription("Each time the target takes damage, it makes a new Wisdom saving throw against the spell. If the saving throw succeeds, the spell ends.")
            .addLineToDescription("At Higher Levels: When you cast this spell with a 5th-level spell slot, the duration is concentration, up to 10 minutes. When you use a 6th-level spell slot, the duration is concentration, up to 1hour. When you use a spell slot of 7th level or higher, the duration is concentration, up to 8 hours.")
            .type(ENCHANTMENT).level(L1).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, ImmutableMap.<SpellLevel, Integer>builder().put(L4, 60).put(L5, 600).put(L6, 3600).put(L7, 28800).build())
            .build();
    public static final Spell DOMINATE_PERSON = builder().name("Dominate Person")
            .addLineToDescription("You attempt to beguile a humanoid that you can see within range. It must succeed on a Wisdom saving throw or be charmed by you for the duration. If your or creatures that are friendly to you are fighting it, it has advantage on the saving throw.")
            .addLineToDescription("While the target is charmed, you have a telepathic link with it as long as the two of you are on the same plane of existence. You can use this telepathic link to issue commands to the creature while you are conscious (no action required), which it does its best to obey. You can specify a simple and general course of action, such as \"Attack that creature,\" \"Run over there\", or \"Fetch that object.\" If the creature completes the order and doesn't receive further direction from you, it defends and preserves itself to the best of its ability.")
            .addLineToDescription("You can use your action to take total and precise control of the target. Until the end of your next turn, the creature takes only the actions you choose, and doesn't do anything that you don't allow it to do. During this time you can also cause the creature to use a reaction, but theis requries you to use your own reaction as well.")
            .addLineToDescription("Each time the target takes damage, it makes a new Wisdom saving throw against the spell. If the saving throw succeeds, the spell ends.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a 6th-level spell slot, the duration is concentration, up to 10 minutes. When you use a 7th-level spell slot, the duraiton is concentration, up to 1 hour. When you use a spell slot of 8th level or higher, the duration is concentration, up to 8 hours.")
            .type(ENCHANTMENT).level(L5).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ONE_MINUTE, true))
            .addProperty(ABILITY_SCORE_TYPE, WISDOM).addProperty(CONDITION, CHARMED)
            .addProperty(SPELL_LEVEL_DURATION_MAP, ImmutableMap.<SpellLevel, SpellDuration>builder()
                    .put(L5, SpellDuration.of(ONE_MINUTE, true)).put(L6, SpellDuration.of(TEN_MINUTES, true))
                    .put(L7, SpellDuration.of(ONE_HOUR, true)).put(L7, SpellDuration.of(EIGHT_HOURS, true))
                    .build()).build();
    public static final Spell FAERIE_FIRE = builder().name("Faerie Fire")
            .addLineToDescription("Each object in a 20-foot cube within range is outlined in blue, green, or violet light (your choice). Any creature in the area when the spell is cast is also outlined in light if it fails a Dexterity saving throw. For the duration, objects and affected creatures shed dim light in a 10-foot radius.")
            .addLineToDescription("Any attack roll against an affected creature or object has advantage if the attacker can see it, and the affected creature or object can't benefit from being invisible.")
            .type(EVOCATION).level(L1).castingTime(ACTION).range(60).duration(SpellDuration.of(60, true))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY).build();
    public static final Spell FIREBALL = builder().name("Fireball")
            .addLineToDescription("A bright streak flashes from your pointing finger to a point you choose within range and then blossoms with a low roar into an explosion of flame. Each creature in a 20-foot-radius sphere centered on that point must make a Dexterity saving throw. A target takes 8d6 fire damage on a failed save, or half as much damage on a successful one.")
            .addLineToDescription("The fire spreads around corners. It ignites flammable objects in the area that aren't being worn or carried.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 4th level or higher, the damage increases by 1d6 for each slot level above 3rd.")
            .type(EVOCATION).level(L3).castingTime(ACTION).range(150)
            .components(SpellComponents.of(true, true, "a tiny ball of bat guano and sulfur"))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L3, 6, level -> level.getValue() + 5))
            .addProperty(DAMAGE_TYPE, FIRE).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell FLAME_STRIKE = builder().name("Flame Strike")
            .addLineToDescription("A vertical column of divine fire roars down from the heavens in a location you specify. Each creature in a 10-foot-radius, 40-foot-high cylinder centered on a point within range must make a Dexterity saving throw. A creature takes 4d6 fire damage and 4d6 radiant damage on a failed save, or half as much damage on a successful one.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the fire damage or the radiant damage (your choice) increases by 1d6 for each slot level above 5th.")
            .type(EVOCATION).level(L5).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, true, "pinch of sulfur"))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L5, 6, level -> level.getValue() - 1))
            .addProperty(DAMAGE_TYPES, Arrays.asList(FIRE, RADIANT)).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell FLAMING_SPHERE = builder().name("Flaming Sphere")
            .addLineToDescription("A 5-foot-diameter sphere of fire appears in an unoccupied space of your choice within range and lasts for the duration. Any creature that ends its turn within 5 feet of the sphere must make a Dexterity saving throw. The creature takes 2d6 fire damage on a failed save, or half as much damage on a successful one.")
            .addLineToDescription("As a bonus action, you can move the sphere up to 30 feet. If you ram the sphere into a creature, that creature must take make the saving throw against the sphere's damage, and the sphere stops moving this turn.")
            .addLineToDescription("When you move the sphere, you can direct it over barriers up to 5 feet tall and jump it across pits up to 10 feet wide. The sphere ignites flammable objects not being worn or carried, and it sheds bright light in a 20-foot radius and dim light for an additional 20 feet.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, the damage increases by 1d6 for each slot level above 2nd.")
            .type(CONJURATION).level(L2).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, true, "a bit of tallow, a pinch of brimstone, and a dusting of powdered iron"))
            .duration(SpellDuration.of(60, true))
            .addProperty(DAMAGE_TYPE, FIRE).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L2, 6, SpellLevel::getValue))
            .build();
    public static final Spell FOG_CLOUD = builder().name("Fog Cloud")
            .addLineToDescription("You create a 20-foot-radius sphere of fog centered on a point within range. the sphere spreads around corners, and it's area is heavily obscured. It lasts for the duration or until a wind of moderate or greater speed (at least 10 miles per hour) disperses it.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the radius of the fog increases by 20 feet for each slot level above 1st.")
            .type(CONJURATION).level(L1).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L1, level -> level.getValue() * 20))
            .build();
    public static final Spell GRASPING_VINE = builder().name("Grasping Vine")
            .addLineToDescription("You conjure a vine that sprouts from the ground in an unoccupied space of your choice that you can see within range. When you cast this spell, you can direct the vine to lash out at a creature within 30 feet of it that you can see. That creature must succeed on a Dexterity saving throw or be pulled 20 feet directly toward the vine.")
            .addLineToDescription("Until the spell ends, you can direct the vine to lash out at the same creature or another one as a bonus action on each of your turns.")
            .type(CONJURATION).level(L4).castingTime(ActionTimes.BONUS_ACTION).range(30)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell GREATER_RESTORATION = builder().name("Greater Restoration")
            .addLineToDescription("You imbue a creature you touch with positive energy to undo a debilitating effect. You can reduce the target's exhaustion level by one, or end one of the following effects on the target:")
            .addLineToDescription("- One effect that charmed or petrified the target")
            .addLineToDescription("- One curse, including the target's attunement to a cursed magic item")
            .addLineToDescription("- Any reduction to one of the target's ability scores")
            .addLineToDescription("- One effect reducing the target's hit point maximum")
            .type(ABJURATION).level(L5).castingTime(ACTION)
            .components(SpellComponents.of(true, true, "diamond dust worth at least 100 gp, which the spell consumes"))
            .build();
    public static final Spell GUARDIAN_OF_FAITH = builder().name("Guardian of Faith")
            .addLineToDescription("A Large spectral guardian appears and hovers for the duration in an unoccupied space of your choice that you can see within range. The guardian occupies that space and is indistinct except for a gleaming sword and shield emblazoned with the symbol of your deity.")
            .addLineToDescription("Any creature hostile to you that moves to a space within 10 feet of the guardian for the first time on a turn must succeed on a Dexterity saving throw. The creature takes 20 radiant damage on a failed save, or half as much damage on a successful one. The guardian vanishes when it has death a total of 60 damage.")
            .type(CONJURATION).level(L4).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, false))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .build();
    public static final Spell GUST_OF_WIND = builder().name("Gust of Wind")
            .addLineToDescription("A line of strong wind 60 feet long and 10 feet wide blasts from you in a direction you choose for the spell's duration. Each creature that starts its turn in the line must succeed on a Strength saving throw or be pushed 15 feet away from you in a direciton following the line.")
            .addLineToDescription("Any creature in the line must spend 2 feet of movement for every 1 foot it moves when moving closer to you.")
            .addLineToDescription("The gust disperses gas or vapor, and it extinguishes candles, torches, and similar unprotected flames in the area. It causes protected flames, such as those of lanterns, to dance wildly and has a 50 percent chance to extinguish them.")
            .addLineToDescription("As a bonus action on each of your turns before the spell ends, you can change the direction in which the line blasts from you.")
            .type(EVOCATION).level(L2).castingTime(ACTION)
            .components(SpellComponents.of(true, true, "a legume seed"))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .build();
    public static final Spell HELLISH_REBUKE = builder().name("Hellish Rebuke")
            .addLineToDescription("You point your finger, and the creature that damaged you is momentarily surrounded by hellish flames. The creature must make a Dexterity saving throw. It takes 2d10 fire damage on a failed save, or half as much damage on a successful one.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d10 for each slot level above 1st.")
            .type(EVOCATION).level(L1).castingTime(ActionTimes.REACTION).range(60)
            .components(SpellComponents.of(true, true))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L1, 10, level -> level.getValue() + 1))
            .addProperty(DAMAGE_TYPE, FIRE).build();
    public static final Spell ICE_STORM = builder().name("Ice Storm")
            .addLineToDescription("A hail of rock-hard ice pounds to the ground in a 20-foot-radius, 40-foot-high cylinder centered on a point within range. Each creature in the cylinder must make a Dexterity saving throw. A creature takes 2d8 bludgeoning damage and 4d6 cold damage on a failed save, or half as much on a successful one.")
            .addLineToDescription("Hailstones turn the storm's area of effect into difficult terrain until the end of your next turn.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 5th level or higher, the bludgeoning damage increases by 1d8 for each slot level above 4th.")
            .type(EVOCATION).level(L4).castingTime(ACTION).range(300)
            .components(SpellComponents.of(true, true, "a pinch of dust and a few drops of water"))
            .addProperty(DAMAGE_TYPE, BLUDGEONING).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L4, 8, level -> level.getValue() - 2))
            .build();
    public static final Spell IDENTIFY = builder().name("Identify")
            .addLineToDescription("You choose on object that you must touch throughout the casting of th spell. If it is a magic item or some other magic-imbued object, you learn its properties and how to use them, whether it requires attunement to use, and how many charges it has, if any. You learn whether any spells are affecting the item and what they are. If the item was created by a spell, you learn which spell created it.")
            .addLineToDescription("If you instead touch a creature throughout the casting, you learn what spells, if any, are currently affecting it.")
            .type(SpellTypes.DIVINATION).level(L1).castingTime(ActionTimes.ONE_MINUTE).isRitual(true)
            .components(SpellComponents.of(true, true, "a pearl worth at least 100 gp and an owl feather"))
            .build();
    public static final Spell INSECT_PLAGUE = builder().name("Insect Plague")
            .addLineToDescription("Swarming, biting locusts fill a 20-foot-radius sphere centered on a point you choose within range. The sphere spreads around corners. The sphere remains for the duration, and its area is lightly obscured. The sphere's area is difficult terrain.")
            .addLineToDescription("When the area appears, each creature in it must make a Constitution saving throw. A creature takes 4d10 Piercing damage on a failed save, or half as much on a successful one. A creature must also make this saving throw when it enters the spell's area for the first time on a turn or ends its turn there.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the damage increases by 1d10 for each slot level above 5th.")
            .type(CONJURATION).level(L5).castingTime(ACTION).range(300)
            .components(SpellComponents.of(true, true, "a few grains of sugar, some kernels of grain, and a smear of fat"))
            .duration(SpellDuration.of(600, true))
            .addProperty(DAMAGE_TYPE, PIERCING).addProperty(ABILITY_SCORE_TYPE, CONSTITUTION)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L5, 10, level -> level.getValue() - 1))
            .build();
    public static final Spell LEGEND_LORE = builder().name("Legend Lore")
            .addLineToDescription("Name or describe a person, place, or object. The spell brings to your mind a brief summary of the significant lore about the thing you named. The lore might consist of current tales, forgotten stories, or even secret lore that has never been widely known. If the thing you named isn't of legendary importance, you gain no information. The more information you already have about the thing, the more precise and detailed the information you receive is.")
            .addLineToDescription("The information you learn is accurate but might be couched in figurative language. For example, if you have a mysterious magic axe on hand, the spell might yield this information: \"Woe to the evildoer whose hand touches the axe, for even the haft slices the hand of the evil ones. Only a true Child of Stone, lover and beloved of Moradin, may awaken the true powers of the axe, and only with the sacred word Rudnogg on the lips.\"")
            .type(SpellTypes.DIVINATION).level(L5).castingTime(600)
            .components(SpellComponents.of(true, true, "incense worth at least 250 gp, which the spell consumes, and four ivory strips worth at least 50 gp each"))
            .build();
    public static final Spell LESSER_RESTORATION = builder().name("Lesser Restoration")
            .description("You touch a creature and can end either one disease or one condition afflicting it. The condition can be blinded, deafened, paralyzed, or poisoned.")
            .type(ABJURATION).level(L2).castingTime(ACTION).components(SpellComponents.of(true, true))
            .build();
    public static final Spell LIGHT = builder().name("Light")
            .addLineToDescription("You touch one object that is no larger than 10 feet in any dimension. Until the spell ends, the object sheds bright light in a 20-foot radius and dim light for an additional 20 feet. The light can be colored as you like. Completely covering the object with something opaque blocks the light. The spell ends if you cast it again or dismiss it as an action.")
            .addLineToDescription("If you target an object held or worn by a hostile creature, that creature must succeed on a Dexterity saving throw to avoid the spell.")
            .type(EVOCATION).level(CANTRIP).castingTime(ACTION)
            .components(SpellComponents.of(true, false, "a firefly or phosphorescent moss"))
            .duration(SpellDuration.of(ActionTimes.ONE_HOUR))
            .addProperty(ABILITY_SCORE_TYPE, DEXTERITY).build();
    public static final Spell MAGIC_WEAPON = builder().name("Magic Weapon")
            .addLineToDescription("You touch a nonmagical weapon. Until the spell ends, that weapon becomes a magic weapon with a +1 bonus to attack rolls and damage rolls.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 4th level or higher, the bonus increases to +2. When you use a spell slot of 6th level or higher, the bonus increases to +3.")
            .type(TRANSMUTATION).level(L2).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ONE_HOUR, true))
            .addProperty(SPELL_LEVEL_INTEGER_FUNCTION, spellLevel ->
            {
                switch (spellLevel.getValue())
                {
                    case 2:
                    case 3:
                        return 1;
                    case 4:
                    case 5:
                        return 2;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        return 3;
                    default:
                        return 0;
                }
            }).build();
    public static final Spell MASS_CURE_WOUNDS = builder().name("Mass Cure Wounds")
            .addLineToDescription("A wave of healing energy washes out from a point of your choice within range. Choose up to six creatures in a 30-foot-radius sphere centered on that point. Each target regains hit points equal to 3d8 + your spellcasting ability modifier. This spell has no effect on undead or constructs.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 6th level or higher, the healing increases by 1d8 for each slot level above 5th.")
            .type(CONJURATION).level(L5).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, true))
            .addProperty(SPELL_LEVEL_INTEGER_MAP, populateSpellLevelIntegerMap(L5, level -> level.getValue() - 2))
            .build();
    public static final Spell MINOR_ILLUSION = builder().name("Minor Illusion")
            .addLineToDescription("You create a sound or an image of an object within range that lasts for the duration. The illusion also ends if you dismiss it as an action or cast this spell again.")
            .addLineToDescription("If you create a sound, its volume can range from a whisper to a scream. It can be your voice, someone else's voice, a lion's roar, a beating of drums, or any other sound you choose. The sound continues unabated thought the duration, or you can make discrete sounds at different times before the spell ends.")
            .addLineToDescription("If you create an image of an object-such as a chair, muddy footprints, or a small chest-it must be no larger than a 5-foot cube. The image can't create sound, light, smell, or any other sensory effect. Physical interaction with the image reveals it to be an illusion, because things can pass through it.")
            .addLineToDescription("If a creature uses its action to examine the sound or image, the creature can determine that it is an illusion with a successful Intelligence (Investigation) check against your spell save DC. If a creature discerns the illusion for what it is, the illusion becomes faint to the creature.")
            .type(ILLUSION).level(CANTRIP).castingTime(ACTION).range(30)
            .components(SpellComponents.of(false, true, "a bit of fleece"))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .addProperty(ABILITY_SCORE_TYPE, INTELLIGENCE)
            .build();
    public static final Spell MIRROR_IMAGE = builder().name("Mirror Image")
            .addLineToDescription("Three illusory duplicates of yourself appear in your space. Until the spell ends, the duplicates move with you and mimic your actions, shifting position so it's impossible to track which image is real. You can use your action to dismiss the illusory duplicates.")
            .addLineToDescription("Each time a creature targets you with an attack during the spell's duration, roll a d20 to determine whether the attack instead targets one of your duplicates.")
            .addLineToDescription("If you have three duplicates, you must roll a 6 or higher to change the attack's target to a duplicate. With two duplicates, you must roll an 8 or higher. With one duplicate, you must roll an 11 or higher.")
            .addLineToDescription("A duplicate's AC equals 10 + your dexterity modifier. If an attack hits a duplicate, the duplicate is destroyed. A duplicate can be destroyed only by an attack that hits it. It ignores all other damage and effects. The spell ends when all three duplicates are destroyed.")
            .addLineToDescription("A creature is unaffected by this spell if it can't see, if it relies on senses other than sight, such as blindsight, or if it can perceive illusions as false, as with truesight.")
            .type(ILLUSION).level(L2).castingTime(ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ONE_MINUTE))
            .addProperty(DUAL_INTEGER_FUNCTION, dexMod -> 10 + dexMod).addProperty(DICE, new Dice(20))
            .addProperty(INTEGER_MAP, ImmutableMap.<Integer, Integer>builder().put(3, 6).put(2, 8).put(1, 11).build())
            //TODO sights are stored as Strings for now
            .addProperty(SIGHTS, Arrays.asList("Blindsight", "Truesight")).build();
    public static final Spell NONDETECTION = builder().name("Nondetection")
            .description("For the duration, you hide a target that you touch from divination magic. The target can be a willing creature or a place or an object no larger than 10 feet in any dimension. The target can't be targeted by any divination magic or perceived through magical scrying sensors.")
            .type(ABJURATION).level(L3).castingTime(ACTION)
            .components(SpellComponents.of(true, true, "a pinch of diamond dust worth 25 gp sprinkled over the target, which the spell consumes)"))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS)).build();
    public static final Spell PASS_WITHOUT_TRACE = builder().name("Pass Without Trace")
            .description("A veil of shadows and silence radiates from you, masking you and your companions from detection. For the duration, each creature you choose within 30 feet of you (including you) has a +10 bonus to Dexterity (Stealth) checks and can't be tracked except by magical means. A creature that receives this bonus leaves behind no tracks or other traces of its passage.")
            .type(ABJURATION).level(L2).castingTime(ACTION)
            .components(SpellComponents.of(true, true, "ashes from a burned leaf of mistletoe and a sprig of spruce"))
            .duration(SpellDuration.of(ONE_HOUR, true))
            .addProperty(DUAL_INTEGER_FUNCTION, skillCheck -> skillCheck + 10)
            .addProperty(SKILL_TYPE, STEALTH).addProperty(RANGE, 30).build();
    public static final Spell PLANT_GROWTH = builder().name("Plant Growth")
            .addLineToDescription("This spell channels vitality into plants within a specific area. There are two possible uses for the spell, granting either immediate or long-term benefits.")
            .addLineToDescription("If you cast this spell using 1 action, choose a point within range. All normal plants in a 100-foot radius centered on that point become thick and overgrown. A creature moving through the area must spend 4 feet of movement for every 1 foot it moves.")
            .addLineToDescription("You can exclude one or more areas of any size within the spell's area from being affected.")
            .addLineToDescription("If you cast this spell over 8 hours, you enrich the land. All plants in a half-mile radius centered on a point within range become enriched for 1 year. The plants yield twice the normal amount of food when harvested.")
            .type(TRANSMUTATION).level(L3).castingTime(ACTION).range(150)
            .components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS)).build();
    public static final Spell POLYMORPH = builder().name("Polymorph")
            .addLineToDescription("This spell transforms a creature that you can see within range into a new form. An unwilling creature must make a wisdom saving throw to avoid the effect. A shapechanger automatically succeeds on this saving throw.")
            .addLineToDescription("The transformation lasts for the duration, or until the target drops to 0 hit points or dies. The new form can be any beast whose challenge rating is equal to or less than the target's (or the target's level, if it doesn't have a challenge rating). The target's game statistics, including mental ability scores, are replaced by the statistics of the chosen beast. It retains its alignment and personality.")
            .addLineToDescription("The target assumes the hit points of its new form. When it reverts to its normal form, the creature returns to the number of hit points it had before it transformed. If it reverts as a result of dropping to 0 hit points, any excess damage carries over to its normal form. As long as the excess damage doesn't reduce the creature's normal form to 0 hit points, it isn't knocked unconscious.")
            .addLineToDescription("The creature is limited in the actions it can perform by the nature of its new form, and it can't speak, cast spells, or take any other action that requires hands or speech.")
            .addLineToDescription("The target's gear melds into the new form. The creature can't activate, use, wield, or otherwise benefit from any of its equipment.")
            .type(TRANSMUTATION).level(L4).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, true, "a caterpillar cocoon")).duration(SpellDuration.of(ONE_HOUR, true))
            .addProperty(ABILITY_SCORE_TYPE, WISDOM).build();
    public static final Spell RAISE_DEAD = builder().name("Raise Dead")
            .addLineToDescription("You return a dead creature you touch to life, provided that it has been dead no longer than 10 days. If the creature's soul is both willing and at liberty to rejoin the body, the creature returns to life with 1 hit point.")
            .addLineToDescription("This spell also neutralizes any poisons and cures nonmagical diseases that affected the creature at the time it died. This spell doesn't, however, remove magical diseases, curses, or similar effects; if these aren't first removed prior to casting the spell, they take effect when the creature returns to life.")
            .addLineToDescription("This spell closes all mortal wounds, but it doesn't restore missing body parts. If the creature is lacking body parts or organs integral for its survival-its hea, for instance-the spell automatically fails.")
            .addLineToDescription("Coming back from the dead is an ordeal. The target takes a -4 penalty to all attack rolls, saving throws, and ability checks. Every time the target finishes a long rest, the penalty is reduced by 1 until it disappears.")
            .type(NECROMANCY).level(L5).castingTime(ActionTimes.ONE_HOUR)
            .components(SpellComponents.of(true, true, "a diamond worth at least 500 gp, which the spell consumes"))
            .build();
    public static final Spell REMOVE_CURSE = builder().name("Remove Curse")
            .description("At your touch, all curses affecting one creature or object end. If the object is a cursed magic item, its curse remains, but the spell breaks its owner's attunement to the object so it can be removed or discarded.")
            .type(ABJURATION).level(L3).castingTime(ACTION).components(SpellComponents.of(true, true))
            .build();
    public static final Spell MODIFY_MEMORY = builder().name("Modify Memory")
            .addLineToDescription("You attempt to reshape another creature's memories. One creature that you can see must make a Wisdom saving throw. If you are fighting the creature, it has advantage on the saving throw. On a failed save, the target becomes charmed by you for the duration. The charmed target is incapacitated and unaware of its surroundings, though it can still hear you. If it takes any damage, or is targeted by another spell, this spell ends, and none of the target's memories are modified.")
            .addLineToDescription("While this charm lasts, you can affect the target's memory of an event that it experienced within the last 24 hours and that lasted no more than 10 minutes. You can permanently eliminate all memory of the event, allow the target to recall the even with perfect clarity and exacting detail, change its memory of the details of the event, or create a memory of some other event.")
            .addLineToDescription("You must speak to the target to describe how its memories are affected, and it must be able to understand your language for the modified memories to take root. Its mind fills in any gaps in the details of your description. If the spell ends before you have finished describing the modified memories, the creature's memory isn't altered. Otherwise, the modified memories take hold when the spell ends.")
            .addLineToDescription("A modified memory doesn't necessarily affect how a creature behaves, particularly if the memory contradicts the creature's natural inclinations, alignment, or beliefs. An illogical modified memory, such as implanting a memory of how much the creature enjoyed dousing itself in acid, is dismissed, perhaps as a bad dream. The DM might deem a modified memory too nonsensical to affect a creature in a significant manner.")
            .addLineToDescription("A Remove Curse or Greater Restoration spell cast on the target restores the creature's true memory.")
            .addLineToDescription("At Higher Levels: If you cast this spell using a spell slot of 6th level or higher, you can alter the target's memories of an event that took place up to 7 days ago (6th level), 30 days ago (7th level), 1 year ago (8th level), or any time in the creature's past (9th level).")
            .type(ENCHANTMENT).level(L5).range(30).castingTime(ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ONE_MINUTE, true))
            .addProperty(SPELLS, SpellList.of(Arrays.asList(REMOVE_CURSE, GREATER_RESTORATION)))
            .addProperty(SPELL_LEVEL_DOUBLE_MAP, ImmutableMap.<SpellLevel, Double>builder().put(L5, ONE_DAY)
                    .put(L6, ONE_DAY * 7D).put(L7, ONE_DAY * 30D).put(L8, ONE_DAY * 365D).put(L9, -1D).build())
            .addProperty(SAVING_THROW, WISDOM).addProperty(MAX_RANGE, 24).addProperty(INTEGER, 10).build();
    public static final Spell REVIVIFY = builder().name("Revivify")
            .description("You touch a creature that has died within the last minute. That creature returns to life with 1 hit point. This spell can't return to life a creature that has died of old age, nor can it restore any missing body parts.")
            .type(CONJURATION).level(L3).castingTime(ACTION)
            .components(SpellComponents.of(true, true, "diamonds worth 300 gp, which the spell consumes"))
            .build();
    public static final Spell SCORCHING_RAY = builder().name("Scorching Ray")
            .addLineToDescription("You create three rays of fire and hurl them at targets within range. You can hurl them at one target or several.")
            .addLineToDescription("Make a ranged spell attack for each ray. On a hit, the target takes 2d6 fire damage.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, you create one additional ray for each slot level above 2nd.")
            .type(EVOCATION).level(L2).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L2, 6, SpellLevel::getValue))
            .addProperty(DAMAGE_TYPE, FIRE).build();
    public static final Spell SCRYING = builder().name("Scrying")
            .addLineToDescription("You can see and hear a particular creature you choose that is on the same plane of existence as you. The target must make a Wisdom saving throw, which is modified by how well you know the target and the sort of physical connection you have to it. If a target knows you're casting this spell, it can fail the saving throw voluntarily if it wants to be observed.")
            .addLineToDescription("On a successful save, the target isn't affected, and you can't use this spell against it again for 24 hours.")
            .addLineToDescription("On a failed save, the spell creates an invisible sensor within 10 feet of the target. You can see and hear through the sensor as if you were there. The sensor moves with the target, remaining within 10 feet of it for the duration. A creature that can see invisible objects sees the sensor as a luminous orb about the size of your fist.")
            .addLineToDescription("Instead of targeting a creature, you can choose a location you have seen before as the target of this spell. When you do, the sensor appears at that location and doesn't move.")
            .type(SpellTypes.DIVINATION).level(L5).castingTime(600)
            .components(SpellComponents.of(true, true, "a focus worth at least 1,000 gp, such as a crystal ball, a silver mirror, or a font filled with holy water"))
            .duration(SpellDuration.of(600, true))
            .addProperty(TABLES, Arrays.asList(Table.builder().name("Connection")
                            .addColumn(CONNECTION_COLUMN, Arrays.asList("Likeness or picture", "Possession or garment", "Body part, lock of hair, bit of nail, or the like"))
                            .addColumn(SAVE_MODIFIER_COLUMN, Arrays.asList(5, 0, -5)).build(),
                    Table.builder().name("Knowledge")
                            .addColumn(KNOWLEDGE_COLUMN, Arrays.asList("Secondhand (you have heard of the target)", "Firsthand (you have met the target)", "Familiar (you know the target well)"))
                            .addColumn(SAVE_MODIFIER_COLUMN, Arrays.asList(-2, -4, -10)).build())).build();
    public static final Spell SHATTER = builder().name("Shatter")
            .addLineToDescription("A sudden loud ringing noise, painfully intense, erupts from a point of your choice within range. Each creature in a 10-foot-radius sphere centered on that point must make a Constitution saving throw. A creature takes 3d8 thunder damage on a failed save, or half as much damage on a successful one. Acreature made of inorganic material such as stone, crystal, or metal has disadvantage on this saving throw.")
            .addLineToDescription("A nonmagical object that isn't being worn or carried also takes the damage if it's in the spell's area.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, the damage increases by 1d8 for each slot level above 2nd.")
            .type(EVOCATION).level(L2).castingTime(ACTION).range(60)
            .components(SpellComponents.of(true, true, "a chip of mica"))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L2, 8, level -> level.getValue() + 1))
            .addProperty(DAMAGE_TYPE, THUNDER).addProperty(ABILITY_SCORE_TYPE, CONSTITUTION).build();
    public static final Spell SHIELD_OF_FAITH = builder().name("Shield of Faith")
            .description("A shimmering field appears and surrounds a creature of your choice within range, granting it a +2 bonus to AC for the duration.")
            .type(ABJURATION).level(L1).castingTime(BONUS_ACTION).range(60)
            .components(SpellComponents.of(true, true, "a small parchment with a bit of holy text written on it"))
            .duration(SpellDuration.of(TEN_MINUTES, true))
            .addProperty(DUAL_INTEGER_FUNCTION, armorClass -> armorClass + 2).build();
    public static final Spell SLEET_STORM = builder().name("Sleet Storm")
            .addLineToDescription("Until the spell ends, freezing rain and sleet fall in a 20-foot-tall cylinder with a 40-foot radius centered on a point you choose within range. The area is heavily obscured, and exposed flames in the area are doused.")
            .addLineToDescription("The ground in the area is covered with slick ice, making it difficult terrain. When a creature enters the spell's area for the first time on a turn or starts its turn there, it makes a Dexterity saving throw. On a failed save, it falls prone.")
            .addLineToDescription("If a creature is concentrating in the spell's area, the creature must make a successful Constitution saving throw against your spell save DC or lose concentration.")
            .type(CONJURATION).level(L3).castingTime(ACTION).range(150)
            .components(SpellComponents.of(true, true, "a pinch of dust and a few drops of water"))
            .duration(SpellDuration.of(60, true))
            .addProperty(ABILITY_SCORE_TYPE, CONSTITUTION).build();
    public static final Spell SPEAK_WITH_ANIMALS = builder().name("Speak with Animals")
            .description("You gain the ability to comprehend and verbally communicate with beasts for the duration. The knowledge and awareness of many beasts is limited by their intelligence, but at minimum, beasts can give you information about nearby locations and monsters, including whatever they can perceive or have perceived within the past day. You might be able to persuade a beast to perform a small favor for you, at the DM's discretion.")
            .type(SpellTypes.DIVINATION).level(L1).castingTime(ACTION).isRitual(true)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(600))
            .build();
    public static final Spell SPEAK_WITH_DEAD = builder().name("Speak with Dead")
            .addLineToDescription("You grant the semblance of life and intelligence to a corpse of your choice within range, allowing it to answer the questions you pose. The corpse must still have a and can't be undead. The spell fails if the corpse was the target of this spell within the last 10 days.")
            .addLineToDescription("Until the spell ends, you can ask the corpse up to five questions. The corpse knows only what it knew in life, including the languages it knew. Answers are usually brief, cryptic, or repetitive, and the corpse is under no compulsion to offer a truthful answer if you are hostile to it or it recognizes you as an enemy. This spell doesn't return the creature's soul to its body, only its animating spirit. Thus, the corpse can't learn new information, doesn't comprehend anything that has happened since it died, and can't speculate about future events.")
            .type(NECROMANCY).level(L3).castingTime(ACTION).range(10)
            .components(SpellComponents.of(true, true, "burning incense")).duration(SpellDuration.of(600))
            .build();
    public static final Spell SPIKE_GROWTH = builder().name("Spike Growth")
            .addLineToDescription("The ground in a 20-foot radius centered on a point within range twists and sprouts hard spikes and thorns. The area becomes difficult terrain for the duration. When a creature moves into or within the area, it takes 2d4 piercing damage for every 5 feet it travels.")
            .addLineToDescription("The transformation of the ground is camouflaged to look natural. Any creature that can't see the area at the time the spell is cast must make a Wisdom (Perception) check against your spell save DC to recognize the terrain as hazardous before entering it.")
            .type(TRANSMUTATION).level(L2).castingTime(ACTION).range(150)
            .components(SpellComponents.of(true, true, "seven sharp thorns or seven small twigs, each sharpened to a point"))
            .duration(SpellDuration.of(600, true))
            .addProperty(DAMAGE, new Damage(PIERCING, new Dice(4, 2))).addProperty(INTEGER, 5).addProperty(SKILL_TYPE, PERCEPTION)
            .build();
    public static final Spell SPIRITUAL_WEAPON = builder().name("Spiritual Weapon")
            .addLineToDescription("You create a floating, spectral weapon within range that lasts for the duration or until you cast this spell again. When you cast the spell, you can make melee spell attack against a creature within 5 feet of the weapon. On a hit, the target takes force damage equal to 1d8 + your spellcasting ability modifier.")
            .addLineToDescription("As a bonus action on your turn, you can move the weapon up to 20 feet and repeat the attack against a creature within 5 feet of it.")
            .addLineToDescription("The weapon can take whatever form you choose. Clerics of deities who are associated with a particular weapon (as St. Curthbert is known for his mace and Thor for his hammer) make this spell's effect resemble that weapon.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, the damage increases by 1d8 for every two slot levels above 2nd.")
            .type(EVOCATION).level(L2).castingTime(ActionTimes.BONUS_ACTION).range(60)
            .components(SpellComponents.of(true, true)).duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .addProperty(SPELL_LEVEL_DICE_MAP, ImmutableMap.<SpellLevel, Dice>builder().put(L1, new Dice(8, 1)).put(L4, new Dice(8, 3)).put(L5, new Dice(8, 3)).put(L6, new Dice(8, 5)).put(L7, new Dice(8, 5)).put(L8, new Dice(8, 7)).build())
            .addProperty(DAMAGE_TYPE, FORCE).build();
    public static final Spell SPIRIT_GUARDIANS = builder().name("Spirit Guardians")
            .addLineToDescription("You call forth spirits to protect you. They flit around you to a distance of 15 feet for the duration. If you are good or neutral, their spectral form appears angelic or fey (your choice). If you are evil, they appear fiendish.")
            .addLineToDescription("When you cast this spell, you can designate any number of creatures you can see to be unaffected by it. An affected creature's speed is halved in the area, and when the creature enters the area for the first time on a turn or starts its turn there, it must make a Wisdom saving throw. On a failed save, the creature takes 3d8 radiant damage (if you are good or neutral) or 3d8 necrotic damage (if you are evil). On a successful save, the creature takes half as much damage.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 4th level or higher, the damage increases by 1d8 for each slot level above 3rd.")
            .type(CONJURATION).level(L3).castingTime(ACTION).range(15)
            .components(SpellComponents.of(true, true, "a holy symbol"))
            .duration(SpellDuration.of(TEN_MINUTES, true))
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L3, 8, SpellLevel::getValue))
            .addProperty(DAMAGE_TYPES, Arrays.asList(NECROTIC, RADIANT)).build();
    public static final Spell SUGGESTION = builder().name("Suggestions")
            .addLineToDescription("You suggest a course of activity (limited to a sentence or two) and magically influence a creature you can see within range that can hear and understand you. Creatures that can't be charmed are immune to this effect. The suggestion must be worded in such a manner as to make the course of action sound reasonable. Asking the creature to stab itself, throw itself onto a spear, immolate itself or do some other obviously harmful act ends the spell.")
            .addLineToDescription("The target must make a Wisdom saving throw. On a failed save, it pursues the course of action you described to the best of its ability. The suggested course of action can continue for the duration. If the suggested activity can be completed in a shorter time, the spell ends when the subject finishes what it was asked to do.")
            .addLineToDescription("You can also specify conditions that will trigger a special activity during the duration. For example, you might suggest that a knight give her warhorse to the first beggar she meets. If the condition isn't met before the spell expires, the activity isn't performed.")
            .addLineToDescription("If you or any of your companions damage the target, the spell ends.")
            .type(ENCHANTMENT).level(L2).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, false, "a snake's tongue and either a hit of honeycomb or a drop of sweet oil"))
            .duration(SpellDuration.of(ActionTimes.EIGHT_HOURS, true))
            .build();
    public static final Spell THAUMATURGY = builder().name("Thaumaturgy")
            .addLineToDescription("You manifest a minor wonder, a sign of supernatural power, within range. You create one of the following magical effects within range:")
            .addLineToDescription("- Your voice booms up to three times as loud as normal for 1 minute.")
            .addLineToDescription("- You cause flames to flicker, brighten, dim, or change color for 1 minute.")
            .addLineToDescription("- You cause harmless tremors in the ground for 1 minute.")
            .addLineToDescription("- You create an instantaneous sound that originates from a point of your choice within range, such as a rumble of thunder, the cry of a raven, or ominous whispers.")
            .addLineToDescription("- You instantaneously cause an unlocked door or window to fly open or slam shut.")
            .addLineToDescription("- You alter the appearance of your eyes for 1 minute.")
            .addLineToDescription("If you cast this spell multiple times, you can have up to three of its 1 minute effects active at a time, and you can dismiss such an effect as an action.")
            .type(TRANSMUTATION).level(CANTRIP).castingTime(ACTION).range(30)
            .components(SpellComponents.of(true, false, "")).duration(SpellDuration.of(ActionTimes.ONE_MINUTE))
            .build();
    public static final Spell THUNDERWAVE = builder().name("Thunderwave")
            .addLineToDescription("A wave of thunderous force sweeps out from you. Each creature in a 15-foot cube originating from you must make a Constitution saving throw. On a failed save, a creature takes 2d8 thunder damage and is pushed 10 feet away from. On a successful save, the creature takes half as much damage and isn't pushed.")
            .addLineToDescription("In addition, unsecured objects that are completely within the area of effect are automatically pushed 10 feet away from you by the spell's effect, and the spell emits a thunderous boom audible out to 300 feet.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the damage increases by 1d8 for each slot level above 1st.")
            .type(EVOCATION).level(L1).castingTime(ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true))
            .addProperty(DAMAGE_TYPE, THUNDER).addProperty(ABILITY_SCORE_TYPE, CONSTITUTION)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L1, 8, level -> level.getValue() + 1))
            .build();
    public static final Spell TREE_STRIDE = builder().name("Tree Stride")
            .addLineToDescription("You gain the ability to enter a tree and move from inside it to inside another tree of the same kind within 500 feet. Both trees must be living and at least the same size as you. You must use 5 feet of movement to enter a tree. You instantly know the location of all other trees of the same kind within 500 feet and, as part of the move used to enter the tree, can either pass into one of those trees or step out of the tree you're in. You appear in a spot of your choice within 5 feet of the destination tree, using another 5 feet of movement. If you have no movement left, you appear within 5 feet of the tree you entered.")
            .addLineToDescription("You can use this transportation ability once per round for the duration. You must end each turn outside a tree.")
            .type(CONJURATION).level(L5).castingTime(ACTION).components(SpellComponents.of(true, true))
            .duration(SpellDuration.of(ActionTimes.ONE_MINUTE, true)).build();
    public static final Spell WALL_OF_FIRE = builder().name("Wall of Fire")
            .addLineToDescription("You create a wall of fire on a solid surface within range. You can make the wall up to 60 feet long, 20 feet high, and 1 foot thick. The wall is opaque and lasts for the duration.")
            .addLineToDescription("When the wall appears, each creature within its area must make a Dexterity saving throw. On a failed save, a creature takes 5d8 fire damage, or half as much damage on a successful save.")
            .addLineToDescription("One side of the wall, selected by you when you cast this spell, deals 5d8 damage to each creature that ends its turn within 10 feet of that side or inside the wall. A creature takes the same damage when it enters the wall for the first time on a turn or ends its turn there. The other side of the wall deals no damage.")
            .addLineToDescription("At Higher Levels: When you cast this spell using a spell slot of 5th level or higher, the damage increases by 1d8 for each slot level above 4th.")
            .type(EVOCATION).level(L4).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true, "a small piece of phosphorus"))
            .duration(SpellDuration.of(60, true))
            .addProperty(DAMAGE_TYPE, FIRE).addProperty(ABILITY_SCORE_TYPE, DEXTERITY)
            .addProperty(SPELL_LEVEL_DICE_MAP, populateSpellLevelDiceMap(L4, 8, level -> level.getValue() + 1))
            .build();
    public static final Spell WIND_WALL = builder().name("Wind Wall")
            .addLineToDescription("A wall of strong wind rises from the ground at a point you choose within range. You can make the wall up to 50 feet long, 15 feet high, and 1 foot thick. You can shape the wall in any way you choose so long as it makes one continuous path along the ground. The wall lasts for the duration.")
            .addLineToDescription("When the wall appears each creature within its area must make a Strength saving throw. A creature takes 3d8 bludgeoning damage on a failed save, or half as much damage on a successful one.")
            .addLineToDescription("The strong winds keep fog, smoke, and other gases at bay. Small or smaller flying creatures or objects can't pass through the wall. loose, lightweight materials brought into the wall fly upward. Arrows, bolts, and other ordinary projectiles launched at targets behind the wall are deflected upward and automatically miss. (Boulders hurled by giants or siege engines, and similar projectiles are unaffected.) Creatures in a gaseous form can't pass through it.")
            .type(EVOCATION).level(L3).castingTime(ACTION).range(120)
            .components(SpellComponents.of(true, true, "a tiny fan and a feather of exotic origin"))
            .duration(SpellDuration.of(60, true))
            .addProperty(ABILITY_SCORE_TYPE, STRENGTH).addProperty(DAMAGE, new Damage(BLUDGEONING, new Dice(8, 3)))
            .build();

    private Spells()
    {

    }
}
