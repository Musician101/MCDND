package io.musician101.sponge.mcdnd.clazz.feature.subclass.druidcircle;

import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageType;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes;
import io.musician101.sponge.mcdnd.condition.Conditions;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevels;
import io.musician101.sponge.mcdnd.magic.Spells;
import io.musician101.sponge.mcdnd.util.ActionTimes;
import io.musician101.sponge.mcdnd.util.table.Table;

import java.util.Arrays;
import java.util.List;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;
import static io.musician101.sponge.mcdnd.util.list.SpellList.of;

public class CircleOfTheLand
{
    public static final Feature BONUS_CANTRIP = builder().name("Bonus Cantrip").levelRequirement(2)
            .description("When you choose this circle at 2nd level, you learn one additional druid cantrip of your choice.")
            .addProperty(MCDNDKeys.SPELL_LEVEL, SpellLevels.CANTRIP)
            .build();
    public static final Feature NATURAL_RECOVERY = builder().name("Natural Recovery").levelRequirement(2)
            .addLineToDescription("Starting at 2nd level, you can regain some of your magical energy by sitting in meditation and communing with nature. During a short rest, you choose expended spell slots to recover. The spell slots can have a combined level that is equal to or less than half your druid level (rounded up), and none of the slots can be 6th level or higher. You can't use this feature again until you finish a long rest.")
            .addLineToDescription("For example, when you are a 4th-level druid, you can recover up to two levels worth of spell slots. You can recover either a 2nd-level slot or two 1st-level slots.")
            .addProperty(MCDNDKeys.DUAL_INTEGER_FUNCTION, level -> (int) Math.floor(level / 2D))
            .addProperty(MCDNDKeys.SPELL_LEVELS, Arrays.asList(SpellLevels.L6, SpellLevels.L7, SpellLevels.L8, SpellLevels.L9))
            .build();
    private static final List<Integer> DRUID_LEVELS = Arrays.asList(3, 5, 7, 9);
    public static final Feature CIRCLE_SPELLS = builder().name("Circle Spells").levelRequirement(3)
            .addLineToDescription("Your mystical connection to the land infuses with the ability to cast certain spells. At 3rd, 5th, 7th, and 9th level you gain access to circle spells connected to the land where you became a druid. Choose that land - arctic, coast, desert, forest, grassland, mountain, swamp, or Underdark - and consult the associated list of spells.")
            .addLineToDescription("Once you gain access to a circle spell, you always have it prepared, and it doesn't count against the number of spells you can prepare each day. If you gain access to a spell that doesn't appear on the druid spell list, the spell is nonetheless a druid spell for you.")
            .addProperty(MCDNDKeys.TABLES, Arrays.asList(Table.builder().name("Arctic")
                    .addColumn(MCDNDKeys.DRUID_LEVEL, DRUID_LEVELS)
                    .addColumn(MCDNDKeys.CIRCLE_SPELLS, Arrays.asList(of(Spells.HOLD_PERSON, Spells.SPIKE_GROWTH),
                            of(Spells.SLEET_STORM, Spells.SLOW),
                            of(Spells.FREEDOM_OF_MOVEMENT, Spells.ICE_STORM),
                            of(Spells.COMMUNE_WITH_NATURE, Spells.CONE_OF_COLD))).build(),
                    Table.builder().name("Coast")
                            .addColumn(MCDNDKeys.DRUID_LEVEL, DRUID_LEVELS)
                            .addColumn(MCDNDKeys.CIRCLE_SPELLS, Arrays.asList(of(Spells.MIRROR_IMAGE, Spells.MISTY_STEP),
                                    of(Spells.WATER_BREATHING, Spells.WATER_WALK),
                                    of(Spells.CONTROL_WATER, Spells.FREEDOM_OF_MOVEMENT),
                                    of(Spells.CONJURE_ELEMENTAL, Spells.SCRYING))).build(),
                    Table.builder().name("Desert")
                            .addColumn(MCDNDKeys.DRUID_LEVEL, DRUID_LEVELS)
                            .addColumn(MCDNDKeys.CIRCLE_SPELLS, Arrays.asList(of(Spells.BLUR, Spells.SILENCE),
                                    of(Spells.CREATE_FOOD_AND_WATER, Spells.PROTECTION_FROM_ENERGY),
                                    of(Spells.BLIGHT, Spells.HALLUCINATORY_TERRAIN),
                                    of(Spells.INSECT_PLAGUE, Spells.WALL_OF_STONE))).build(),
                    Table.builder().name("Forest")
                            .addColumn(MCDNDKeys.DRUID_LEVEL, DRUID_LEVELS)
                            .addColumn(MCDNDKeys.CIRCLE_SPELLS, Arrays.asList(of(Spells.BARKSKIN, Spells.SPIDER_CLIMB),
                                    of(Spells.CALL_LIGHTNING, Spells.PLANT_GROWTH),
                                    of(Spells.DIVINATION, Spells.FREEDOM_OF_MOVEMENT),
                                    of(Spells.COMMUNE_WITH_NATURE, Spells.TREE_STRIDE))).build(),
                    Table.builder().name("Grassland")
                            .addColumn(MCDNDKeys.DRUID_LEVEL, DRUID_LEVELS)
                            .addColumn(MCDNDKeys.CIRCLE_SPELLS, Arrays.asList(of(Spells.INVISIBILITY, Spells.PASS_WITHOUT_TRACE),
                                    of(Spells.DAYLIGHT, Spells.HASTE),
                                    of(Spells.DIVINATION, Spells.FREEDOM_OF_MOVEMENT),
                                    of(Spells.DREAM, Spells.INSECT_PLAGUE))).build(),
                    Table.builder().name("Mountain")
                            .addColumn(MCDNDKeys.DRUID_LEVEL, DRUID_LEVELS)
                            .addColumn(MCDNDKeys.CIRCLE_SPELLS, Arrays.asList(of(Spells.SPIDER_CLIMB, Spells.SPIKE_GROWTH),
                                    of(Spells.LIGHTNING_BOLT, Spells.MELD_INTO_STONE),
                                    of(Spells.STONE_SHAPE, Spells.STONESKIN),
                                    of(Spells.PASSWALL, Spells.WALL_OF_STONE))).build(),
                    Table.builder().name("Swamp")
                            .addColumn(MCDNDKeys.DRUID_LEVEL, DRUID_LEVELS)
                            .addColumn(MCDNDKeys.CIRCLE_SPELLS, Arrays.asList(of(Spells.DARKNESS, Spells.MELFS_ACID_ARROW),
                                    of(Spells.WATER_WALK, Spells.STINKING_CLOUD),
                                    of(Spells.FREEDOM_OF_MOVEMENT, Spells.LOCATE_CREATURE),
                                    of(Spells.INSECT_PLAGUE, Spells.SCRYING))).build(),
                    Table.builder().name("Underdark")
                            .addColumn(MCDNDKeys.DRUID_LEVEL, DRUID_LEVELS)
                            .addColumn(MCDNDKeys.CIRCLE_SPELLS, Arrays.asList(of(Spells.SPIDER_CLIMB, Spells.WEB),
                                    of(Spells.GASEOUS_FORM, Spells.STINKING_CLOUD),
                                    of(Spells.GREATER_INVISIBILITY, Spells.STONE_SHAPE),
                                    of(Spells.CLOUDKILL, Spells.INSECT_PLAGUE))).build())).build();
    public static final Feature LANDS_STRIDE = builder().name("Land's Stride").levelRequirement(6)
            .addLineToDescription("Starting 6th level, moving through nonmagical difficult terrain costs you no extra movement. You can also pass through nonmagical plants without being slowed by them and without taking damage from them if they have thorns, spines, or a similar hazard.")
            .addLineToDescription("In addition, you have advantage on saving throws against plants that are magically created or manipulated to impede movement, such those created by the Entangle spell.")
            .build();
    public static final Feature NATURES_WARD = builder().name("Nature's Ward").levelRequirement(10)
            .description("When you reach 10th level, you can't be charmed or frightened by elementals or fey, and you are immune to poison and disease.")
            .addProperty(MCDNDKeys.CONDITIONS, Arrays.asList(Conditions.CHARMED, Conditions.FRIGHTENED))
            .addProperty(MCDNDKeys.DAMAGE_TYPES, Arrays.asList(MCDNDDamageTypes.POISON, new MCDNDDamageType("Disease")))
            .build();
    public static final Feature NATURES_SANCTUARY = builder().name("Nature's Sanctuary").levelRequirement(14)
            .addLineToDescription("When you reach 14th level, creatures of the natural world sense your connection to nature and become hesitant to attack you. When a beast or plant creature attacks you, that creature must make a Wisdom saving throw against your druid spell save DC. On a failed save, the creature must choose a different target, or the attack automatically misses. On a successful save, the creature is immune to this effect for 24 hours.")
            .addLineToDescription("The creature is aware of this effect before it makes its attack against you.")
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.WISDOM)
            .addProperty(MCDNDKeys.DURATION, ActionTimes.ONE_DAY)
            .build();

    private CircleOfTheLand()
    {

    }
}
