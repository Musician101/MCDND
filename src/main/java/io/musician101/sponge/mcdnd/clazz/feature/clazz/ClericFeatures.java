package io.musician101.sponge.mcdnd.clazz.feature.clazz;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.EquipmentChoices;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.ListChoice;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.MultipleChoice;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.SingleChoice;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.domain.DivineDomains;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.ArmorTypes;
import io.musician101.sponge.mcdnd.equipment.armor.Armors;
import io.musician101.sponge.mcdnd.equipment.gear.AdventuringGear;
import io.musician101.sponge.mcdnd.equipment.pack.Packs;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import io.musician101.sponge.mcdnd.magic.SpellLevel;
import io.musician101.sponge.mcdnd.magic.SpellLevels;
import io.musician101.sponge.mcdnd.property.ProficienciesProperty;
import io.musician101.sponge.mcdnd.property.single.HitPointsProperty;
import io.musician101.sponge.mcdnd.property.spellcasting.SpellcastingProperty;
import io.musician101.sponge.mcdnd.util.DualIntegerMap;

import java.util.ArrayList;
import java.util.Arrays;

import static io.musician101.sponge.mcdnd.clazz.feature.CommonFeatures.D8;
import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;

public class ClericFeatures
{
    public static final Feature HP = builder().name("Hit Points")
            .addProperty(MCDNDKeys.HP_PROPERTY, new HitPointsProperty(D8, "Cleric"))
            .build();
    public static final Feature PROFICIENCIES = builder().name("Proficiencies")
            .addProperty(MCDNDKeys.PROFICIENCIES, new ProficienciesProperty(Arrays.asList(ArmorTypes.LIGHT, ArmorTypes.MEDIUM, ArmorTypes.SHIELD), "Light armor, medium armor, shields",
                    Weapons.getSimpleWeapons(), "All simple weapons",
                    new ArrayList<>(), "None",
                    Arrays.asList(AbilityScoreTypes.WISDOM, AbilityScoreTypes.CHARISMA), "Wisdom, Charisma",
                    Arrays.asList(SkillTypes.HISTORY, SkillTypes.INSIGHT, SkillTypes.MEDICINE, SkillTypes.PERSUASION, SkillTypes.RELIGION), 2, "Choose two from History, Insight, Medicine, Persuasion, and Religion"))
            .build();
    public static final Feature EQUIPMENT = builder().name("Equipment")
            .addProperty(MCDNDKeys.EQUIPMENT_CHOICES_LIST, Arrays.asList(new EquipmentChoices("(a) a mace or (b) a warhammer (if proficient)", new SingleChoice(Weapons.MACE), new SingleChoice(Weapons.WARHAMMER)),
                    new EquipmentChoices("(a) scale mail, (b) leather armor, or (c) chain mail (if proficient)", new SingleChoice(Armors.SCALE_MAIL), new SingleChoice(Armors.LEATHER), new SingleChoice(Armors.CHAIN_MAIL)),
                    new EquipmentChoices("(a) a light crossbow and 20 bolts or (b) any simple weapon", new MultipleChoice(ImmutableMap.<Equipment, Integer>builder().put(Weapons.LIGHT_CROSSBOW, 1).put(AdventuringGear.CROSSBOW_BOLTS, 1).build()), new ListChoice(Weapons.getSimpleWeapons())),
                    new EquipmentChoices("(a) a priest's pack or (b) an explorer's pack", new SingleChoice(Packs.PRIESTS_PACK), new SingleChoice(Packs.EXPLORERS_PACK)), new EquipmentChoices("A shield and a holy symbol", new MultipleChoice(ImmutableMap.<Equipment, Integer>builder().put(Armors.SHIELD, 1).put(AdventuringGear.HOLY_SYMBOL_AMULET, 1).put(AdventuringGear.HOLY_SYMBOL_EMBLEM, 1).put(AdventuringGear.HOLY_SYMBOL_RELIQUARY, 1).build()))))
            .build();
    public static final Feature SPELLCASTING = builder().name("Spellcasting")
            .description("As a conduit for divine power, you can cast cleric spells.")
            .addProperty(MCDNDKeys.SPELLCASTING_PROPERTY, new SpellcastingProperty(builder().name("Cantrips")
                        .description("At 1st level, you know three cantrips of your choice from the cleric spell list. You learn additional cleric cantrips of your choice at higher levels, as shown in the Cantrips Known column of the Cleric table.")
                        .addProperty(MCDNDKeys.CANTRIP_SLOT_AMOUNT, ImmutableMap.<Integer, Integer>builder().put(1, 3).put(4, 4).put(10, 5).build())
                        .build(),
                    builder().name("Preparing and Casting Spells")
                            .description("The Cleric table shows how many spell slots you have to cast your spells of 1st level and higher. To cast one of these spells, you must expend a slot of the spell's level or higher. You regain all expended spell slots when you finish a long rest.", "You prepare the list of cleric spells that are available for you to cast, choosing from the cleric spell list. When you do so, choose a number of cleric spell list. When you do so, choose a number of cleric spells equal to your Wisdom modifier * you cleric level (minimum of one spell). The spells must be of a level for which you have spell slots.", "For example, if you are a 3rd-level cleric, you have four 1st-level and two 2nd-level spell slots. With a Wisdom of 16, your list of prepared spells can included six spells of 1st or 2nd level, in any combination. If you prepare the 1st-level spell Cure Wounds, you can cast it using the 1st-level or 2nd-level slot. Casting the spell doesn't remove it from your list of prepared spells.", "You can change your list of prepared spells when you finish a long rest. Preparing a new list of cleric spells requires time spent in prayer and meditation: at least 1 minute per spell level for each spell on your list.")
                            .addProperty(MCDNDKeys.SPELL_SLOTS_MAP, ImmutableMap.<SpellLevel, DualIntegerMap>builder()
                                    .put(SpellLevels.L1, DualIntegerMap.builder().put(1, 2).put(2, 3).put(3, 4).build())
                                    .put(SpellLevels.L2, DualIntegerMap.builder().put(1, 0).put(3, 2).put(4, 3).build())
                                    .put(SpellLevels.L3, DualIntegerMap.builder().put(1, 0).put(5, 2).put(6, 3).build())
                                    .put(SpellLevels.L4, DualIntegerMap.builder().put(1, 0).put(7, 1).put(8, 1).put(9, 3).build())
                                    .put(SpellLevels.L5, DualIntegerMap.builder().put(1, 0).put(9, 1).put(10, 2).put(18, 3).build())
                                    .put(SpellLevels.L6, DualIntegerMap.builder().put(1, 0).put(11, 1).put(19, 2).build())
                                    .put(SpellLevels.L7, DualIntegerMap.builder().put(1, 0).put(13, 1).put(20, 2).build())
                                    .put(SpellLevels.L8, DualIntegerMap.builder().put(1, 0).put(15, 1).build())
                                    .put(SpellLevels.L9, DualIntegerMap.builder().put(1, 0).put(17, 1).build()).build())
                            .build(),
                    builder().name("Spellcasting Ability")
                            .description("Wisdom is your spellcasting ability for your cleric spells. The power of your spells comes from your devotion to your deity. You use your Wisdom whenever a cleric spell refers to your spellcasting ability. In addition, you use your Wisdom modifier when setting the saving throw DC for a cleric spell you cast and when making an attack roll with one.", "Spell save DC = 8 + your proficiency bonus + your Wisdom modifier", "Spell attack modifier = your proficiency bonus + your Wisdom modifier")
                            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.WISDOM).build(),
                    builder().name("Ritual Casting")
                            .description("You can cast a cleric spell as a ritual if that spell has the ritual tag and you have the spell prepared.")
                            .build(),
                    builder().name("SpellcastingFocus").description("You can use a holy symbol as a spellcasting focus for your cleric spells.")
                            .build())).build();
    public static final Feature DIVINE_DOMAIN = builder().name("Divine Domain")
            .description("Choose one domain related to your entity: Knowledge, Life, Light, Nature, Tempest, Trickery, or War. Each domain is detailed at the end of the class description, and each one provides examples of gods associated with it. Your choice grants you domain spells and other features when you choose it at 1st level. It also grants you additional ways to use Channel Divinity when you gain that feature at 2nd level, and additional benefits at 6th, 8th, and 17th levels.")
            .addProperty(MCDNDKeys.DIVINE_DOMAINS, Arrays.asList(DivineDomains.KNOWLEDGE_DOMAIN, DivineDomains.LIFE_DOMAIN, DivineDomains.LIGHT_DOMAIN, DivineDomains.NATURE_DOMAIN, DivineDomains.TEMPEST_DOMAIN))
            .build();

    private ClericFeatures()
    {

    }
}
