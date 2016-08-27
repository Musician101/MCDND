package io.musician101.sponge.mcdnd.clazz.feature.clazz;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.EquipmentChoices;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.ListChoice;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.MultipleChoice;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.SingleChoice;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.druidcircle.DruidCircles;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevels;
import io.musician101.sponge.mcdnd.dice.HitDice;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.MCDNDArmorTypes;
import io.musician101.sponge.mcdnd.equipment.armor.Armors;
import io.musician101.sponge.mcdnd.equipment.gear.AdventuringGear;
import io.musician101.sponge.mcdnd.equipment.pack.Packs;
import io.musician101.sponge.mcdnd.equipment.tool.Tools;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import io.musician101.sponge.mcdnd.language.Languages;
import io.musician101.sponge.mcdnd.property.HitPointsProperty;
import io.musician101.sponge.mcdnd.property.ProficienciesProperty;
import io.musician101.sponge.mcdnd.property.spellcasting.SpellcastingProperty;
import io.musician101.sponge.mcdnd.util.DualIntegerMap;
import io.musician101.sponge.mcdnd.util.table.Table;

import java.util.Arrays;
import java.util.Collections;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;

public class DruidFeatures
{
    public static final Feature HP = builder().name("Hit Points")
            .addProperty(MCDNDKeys.HP_PROPERTY, new HitPointsProperty(new HitDice(8), "Druid"))
            .build();
    public static final Feature PROFICIENCIES = builder().name("Proficiencies")
            .addProperty(MCDNDKeys.PROFICIENCIES, new ProficienciesProperty(Arrays.asList(MCDNDArmorTypes.LIGHT, MCDNDArmorTypes.MEDIUM, MCDNDArmorTypes.SHIELD), "Light armor, medium armor, shields (druids will not wear armor or use shields made of metal)",
                    Arrays.asList(Weapons.CLUB, Weapons.DAGGER, Weapons.DART, Weapons.JAVELIN, Weapons.MACE, Weapons.QUARTERSTAFF, Weapons.SCIMITAR, Weapons.SICKLE, Weapons.SLING, Weapons.SPEAR), "Clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, spears",
                    Collections.singletonList(Tools.HERBALISM_KIT), "Herbalism Kit",
                    Arrays.asList(AbilityScoreTypes.INTELLIGENCE, AbilityScoreTypes.WISDOM), "Intelligence, Wisdom",
                    Arrays.asList(SkillTypes.ARCANA, SkillTypes.ANIMAL_HANDLING, SkillTypes.INSIGHT, SkillTypes.MEDICINE, SkillTypes.NATURE, SkillTypes.PERCEPTION, SkillTypes.RELIGION, SkillTypes.SURVIVAL), 2, "Choose two from Arcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, and Survival"))
            .build();
    public static final Feature EQUIPMENT = builder().name("Equipment")
            .addProperty(MCDNDKeys.EQUIPMENT_CHOICES_LIST, Arrays.asList(new EquipmentChoices("(a) a wooden shield or (b) any simple weapon", new SingleChoice(Armors.SHIELD), new ListChoice(Weapons.getSimpleWeapons())),
                    new EquipmentChoices("(a) a scimitar or (b) any simple melee weapon", new SingleChoice(Weapons.SCIMITAR), new ListChoice(Weapons.getSimpleMeleeWeapons())),
                    new EquipmentChoices("Leather armor, an explorer's pack, and a druidic focus", new MultipleChoice(ImmutableMap.<Equipment, Integer>builder()
                            .put(Armors.LEATHER, 1).put(Packs.EXPLORERS_PACK, 1).put(AdventuringGear.DRUIDIC_FOCUS_SPRIG_MISTLETOE, 1)
                            .build())))).build();
    public static final Feature DRUIDIC = builder().name("Druidic")
            .description("You know Druidic, the secret language of druids. You can speak the language and use it to leave hidden messages. You and others who know this language automatically spot such a message. Others spot the message's presence with a successful DC 15 Wisdom (Perception) check but can't decipher it without magic.")
            .addProperty(MCDNDKeys.LANGUAGE, Languages.DRUIDIC)
            .addProperty(MCDNDKeys.SKILL_TYPE, SkillTypes.PERCEPTION)
            .addProperty(MCDNDKeys.INTEGER, 15)
            .build();
    public static final Feature SPELLCASTING = builder().name("Spellcasting")
            .description("Drawing on the divine essence of nature itself, you can cast spells to shape that essence to your will.")
            .addProperty(MCDNDKeys.SPELLCASTING_PROPERTY, new SpellcastingProperty(builder().name("Cantrips")
                        .description("At 1st level, you know two cantrips of your choice from the druid spell list. You learn additional druid cantrips of your choice at higher levels, as shown in the Cantrips Known column of the Druid table.")
                        .addProperty(MCDNDKeys.CANTRIP_SLOT_AMOUNT, ImmutableMap.<Integer, Integer>builder().put(1, 2).put(4, 3).put(10, 4).build())
                        .build(),
                    builder().name("Preparing and Casting Spells")
                            .addLineToDescription("The Druid table shows how many spell slots you have to cast your spells, you must expend a slot of the spell's level or higher. You regain all expended spell slots when you finish a long rest.")
                            .addLineToDescription("You prepare the list of druid spells that are available for you to cast, choosing from the druid spell list. When you do so, choose a number of druid spells equal to your Wisdom modifier + your druid level (minimum of one spell). The spells must be of a level for which you have spell slots.")
                            .addLineToDescription("For example, if you are a 3rd-level druid, you have four 1st-level and two 2nd-level spell slots. With a Wisdom of 16, your list of prepared spells can include six spells of 1st or 2nd level, in any combination. If you prepare the 1st-level spell Cure Wounds, you can cast it using a 1st-level or 2nd level slot. Casting the spell doesn't remove it from your list of prepared spells.")
                            .addLineToDescription("You can also change your list of prepared spells when you finish a long rest. Preparing a new list of druid spells requires time spent in prayer and meditation: at least 1 minute per spell level for each spell on your list.")
                            .addProperty(MCDNDKeys.SPELL_SLOTS_MAP, ImmutableMap.<SpellLevel, DualIntegerMap>builder()
                                    .put(SpellLevels.L1, DualIntegerMap.builder().put(1, 2).put(2, 3).put(3, 4).build())
                                    .put(SpellLevels.L2, DualIntegerMap.builder().put(1, 0).put(3, 2).put(4, 3).build())
                                    .put(SpellLevels.L3, DualIntegerMap.builder().put(1, 0).put(5, 2).put(6, 3).build())
                                    .put(SpellLevels.L4, DualIntegerMap.builder().put(1, 0).put(7, 1).put(8, 2).put(9, 3).build())
                                    .put(SpellLevels.L5, DualIntegerMap.builder().put(1, 0).put(9, 1).put(10, 2).put(18, 3).build())
                                    .put(SpellLevels.L6, DualIntegerMap.builder().put(1, 0).put(11, 1).put(19, 2).build())
                                    .put(SpellLevels.L7, DualIntegerMap.builder().put(1, 0).put(13, 1).put(20, 2).build())
                                    .put(SpellLevels.L8, DualIntegerMap.builder().put(1, 0).put(15, 1).build())
                                    .put(SpellLevels.L9, DualIntegerMap.builder().put(1, 0).put(17, 1).build()).build())
                            .build(),
                    builder().name("Spellcasting Ability")
                            .addLineToDescription("Wisdom is your spellcasting ability for your druid spells, since your magic draws upon your devotion and attunement to nature. You use your Wisdom whenever a spell refers to your spellcasting ability. In addition, you use your Wisdom modifier when setting the saving throw DC for a druid spell you cast and when making an attack roll with one.")
                            .addLineToDescription("Spell save DC = 8 + your proficiency bonus + your Wisdom modifier")
                            .addLineToDescription("Spell attack modifier = your proficiency bonus + your Wisdom modifier")
                            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.WISDOM)
                            .build(),
                    builder().name("Ritual Casting")
                            .description("You can cast a druid spell as a ritual if that spell has the ritual tag and you have the spell prepared.")
                            .build(),
                    builder().name("Spellcasting Focus")
                            .description("You can use a druidic focus as a spellcasting focus for your druid spells.")
                            .build())).build();
    public static final Feature WILD_SHAPE = builder().name("Wild Shape").levelRequirement(2)
            .addLineToDescription("Starting at 2nd level, you can use your action to magically assume the shape of a beast that you have seen before. You can use this feature twice. You regain expended uses when you finish a short or long rest.")
            .addLineToDescription("Your druid level determines the beasts you can transform into, as shown in the Beast Shapes table. At 2nd level, for example, you can transform into any beast that has a challenge rating of 1/4 or lower that doesn't have a flying or swimming speed.")
            .addLineToDescription("You can stay in a beast shape for a number of hours equal to half your druid level (rounded down). You then revert to your normal form unless you expend another use of this feature. You can revert to your normal form earlier by using a bonus action on your turn. You automatically revert if you fall unconscious, drop to 0 hit points, or die.")
            .addLineToDescription("While you are transformed, the following rules apply:")
            .addLineToDescription("- Your game statistics are replaced by the statistics of the beast, but you retain your alignment, personality, and Intelligence, Wisdom, and Charisma scores. You also retain all of your skill and saving throw proficiencies, in addition to gaining those of the creature. If the creature has the same proficiency as you and the bonus in its stat block is higher than yours, use the creature's bonus instead of yours. If the creature has any legendary or lair actions, you can't use them.")
            .addLineToDescription("- When you transform, you assume the beast's hit points and Hit Dice. When you revert to your normal form, you return to the number of hit points you had before you transformed. However, if you revert as a result of dropping to 0 hit points, any excess damage carries over to your normal form. For example if you take 10 damage in animal form and have only 1 hit point left, you revert and take 9 damage. As long as the excess damage doesn't reduce your normal form to 0 hit points, you aren't knocked unconscious.")
            .addLineToDescription("- You can't cast spells, and your ability to speak or take any action that requires hands is limited to the capabilities of your beast form. Transforming doesn't break your concentration on a spell you've already cast, however, or prevent you from taking actions that are part of a spell, such as Call Lightning, that you've already cast.")
            .addLineToDescription("- You retain the benefit of any features from your class, race, or other source and can use them if the new form is physically capable of doing so. However, you can't use any of your special senses, such as darkvision, unless your new form also has that sense.")
            .addLineToDescription("- You choose whether your equipment falls ot he ground in your space, merges into your new form, or is worn by it. Worn equipment functions as normal, but the DM decides whether it is practical for the new form to wear a piece of equipment based on the creature's shape and size. Your equipment doesn't change size or shape to match the new form, and any equipment that the new form can't wear must either fall to the ground or merge with it. Equipment that merges with the form has no effect until you leave the form.")
            .addProperty(MCDNDKeys.TABLE, Table.builder().name("Beast Shapes")
                    .addColumn(MCDNDKeys.LEVEL_COLUMN, Arrays.asList(2, 4, 8))
                    .addColumn(MCDNDKeys.MAX_CR_COLUMN, Arrays.asList(0.25, 0.5, 1.0))
                    .addColumn(MCDNDKeys.LIMITATIONS_COLUMN, Arrays.asList("No flying or swimming speed", "No flying speed", "None"))
                    .addColumn(MCDNDKeys.EXAMPLE_COLUMN, Arrays.asList("Wolf", "Crocodile", "Giant eagle")).build())
            .addProperty(MCDNDKeys.DUAL_INTEGER_FUNCTION, level -> level / 2)
            .build();
    public static final Feature DRUID_CIRCLE = builder().name("Druid Circle").levelRequirement(2)
            .addLineToDescription("At 2nd level, you choose to identify with a circle of druids: the Circle of the Land or the Circle of the Moon, both detailed at the end of the class description. You choice grants you features at 2nd level and again at 6th, 10th, and 14th level.")
            .addProperty(MCDNDKeys.DRUID_CIRCLES, Arrays.asList(DruidCircles.CIRCLE_OF_THE_LAND, DruidCircles.CIRCLE_OF_THE_MOON))
            .build();
    public static final Feature TIMELESS_BODY = builder().name("Timeless Body").levelRequirement(18)
            .description("Starting at 18th level, the primal magic that you wield causes you to age more slowly. For every 10 years that pass, your body ages only 1 year.")
            .build();
    public static final Feature BEAST_SPELLS = builder().name("Beast Spells").levelRequirement(18)
            .description("Beginning at 18th level, you can cast many of your druid spells in any shape you assume using Wild Shape. You can perform the somatic and verbal components of a druid spell while in a beast shape, but aren't able to provide material components.")
            .build();
    public static final Feature ARCHDRUID = builder().name("Archdruid").levelRequirement(20)
            .addLineToDescription("At 20th level, you can use your Wild Shape an unlimited number of times.")
            .addLineToDescription("Additionally, you can ignore the verbal and somatic components of your druid spells, as well as any material components that lack a cost and aren't consumed by a spell. You gain this benefit in both your normal shape and your beast shape form Wild Shape.")
            .build();

    private DruidFeatures()
    {

    }
}
