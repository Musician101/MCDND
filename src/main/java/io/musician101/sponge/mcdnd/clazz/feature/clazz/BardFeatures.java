package io.musician101.sponge.mcdnd.clazz.feature.clazz;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.EquipmentChoices;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.ListChoice;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.SingleChoice;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.college.BardColleges;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.skill.SkillType;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevels;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.ArmorTypes;
import io.musician101.sponge.mcdnd.equipment.pack.Packs;
import io.musician101.sponge.mcdnd.equipment.tool.MusicalInstruments;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapon;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import io.musician101.sponge.mcdnd.property.HitPointsProperty;
import io.musician101.sponge.mcdnd.property.ProficienciesProperty;
import io.musician101.sponge.mcdnd.property.spellcasting.SpellsKnownSpellcastingProperty;
import io.musician101.sponge.mcdnd.util.DualIntegerMap;
import org.spongepowered.api.Sponge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static io.musician101.sponge.mcdnd.clazz.feature.CommonFeatures.D8;
import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;

public class BardFeatures
{
    public static final Feature HP = builder().name("Hit Points").addProperty(MCDNDKeys.HP_PROPERTY, new HitPointsProperty(D8, "Bard")).build();
    public static final Feature EQUIPMENT = builder().name("Equipment").addProperty(MCDNDKeys.EQUIPMENT_CHOICES_LIST, Arrays.asList(new EquipmentChoices("(a) a rapier, (b) a longsword, or (c) any simple weapon", new SingleChoice(Weapons.RAPIER), new SingleChoice(Weapons.LONGSWORD), new ListChoice(Weapons.getSimpleWeapons())),
            new EquipmentChoices("(a) diplomat's pack or (b) an entertainer's pack", new SingleChoice(Packs.DIPLOMATS_PACK), new SingleChoice(Packs.ENTERTAINERS_PACK)),
            new EquipmentChoices("(a) a lute or (b) any other musical instrument", new SingleChoice(MusicalInstruments.LUTE), new ListChoice(MusicalInstruments.ALL)))).build();
    public static final Feature PROFICIENCIES = builder().name("Proficiencies").addProperty(MCDNDKeys.PROFICIENCIES, new ProficienciesProperty(Collections.singletonList(ArmorTypes.LIGHT), "Light armor",
            ImmutableList.<Weapon>builder().addAll(Weapons.getSimpleWeapons()).add(Weapons.HAND_CROSSBOW, Weapons.LONGSWORD, Weapons.RAPIER, Weapons.SHORTSWORD).build(), "Simple weapons, hand crossbows, longswords, rapiers, shortswords",
            new ArrayList<>(MusicalInstruments.ALL), "Three musical instruments of your choice", Arrays.asList(AbilityScoreTypes.DEXTERITY, AbilityScoreTypes.CHARISMA), "Dexterity, Charisma",
            new ArrayList<>(Sponge.getRegistry().getAllOf(SkillType.class)), 3, "Choose any three")).build();
    public static final Feature SPELLCASTING = builder().name("Spellcasting").description("You have learned to untangle and reshape the fabric of reality in harmony with your wishes and music. Your spells are part of your vast repertoire, magic that you can tune to different situations.")
            .addProperty(MCDNDKeys.SPELLS_KNOWN_SPELLCASTING_PROPERTY, new SpellsKnownSpellcastingProperty(builder().name("Cantrips")
                            .description("You know two cantrips of your choice from the bard spell list. You learn additional bard cantrips of your choice at higher levels, as shown in the Cantrips Known column of the Bard table.")
                            .addProperty(MCDNDKeys.CANTRIP_SLOT_AMOUNT, ImmutableMap.<Integer, Integer>builder().put(1, 2).put(4, 3).put(10, 4).build()).build(),
                    builder().name("Spell Slots")
                            .description("The Bard table shows how many spell slots you have to cast your spells of 1st level and higher. To cast one of these spells, you must expend a slot of the spell's level or higher. You regain all expended spell slots when you finish a long rest.", "For example, if you know the 1st-level spell Cure Wounds and have a 1st-level and a 2nd-level spell slot available, you can cast cure wounds using either slot.")
                            .addProperty(MCDNDKeys.SPELL_SLOTS_MAP, ImmutableMap.<SpellLevel, DualIntegerMap>builder()
                                    .put(SpellLevels.L1, DualIntegerMap.builder().put(1, 2).put(2, 3).put(3, 4).build())
                                    .put(SpellLevels.L2, DualIntegerMap.builder().put(1, 0).put(3, 2).put(4, 3).build())
                                    .put(SpellLevels.L3, DualIntegerMap.builder().put(1, 0).put(5, 2).put(6, 3).build())
                                    .put(SpellLevels.L4, DualIntegerMap.builder().put(1, 0).put(7, 1).put(8, 2).put(9, 3).build())
                                    .put(SpellLevels.L5, DualIntegerMap.builder().put(1, 0).put(9, 1).put(10, 2).put(18, 3).build())
                                    .put(SpellLevels.L6, DualIntegerMap.builder().put(1, 0).put(11, 1).put(19, 2).build())
                                    .put(SpellLevels.L7, DualIntegerMap.builder().put(1, 0).put(13, 1).put(20, 2).build())
                                    .put(SpellLevels.L8, DualIntegerMap.builder().put(1, 0).put(15, 1).build())
                                    .put(SpellLevels.L9, DualIntegerMap.builder().put(1, 0).put(17, 1).build()).build()).build(),
                    builder().name("Spells Known")
                            .description("You know four 1st-level spells of your choice from the bard spell list.", "The Spells Known column of the Bard table shows when you learn more bard spells of your choice. Each of these spells must be of a level for which you have spell slots, as shown on the table. For instance, when you reach 3rd level in this class, you can learn on new spell of 1st or 2nd level.", "Additionally, when you gain a level in this class, you can choose one of the bard spells you know and replace it with another spell from the bard spell list, which also must be of a level for which you have spell slots.")
                            .addProperty(MCDNDKeys.SPELLS_KNOWN_MAP, DualIntegerMap.builder().put(1, 4).put(2, 5).put(3, 6).put(4, 7).put(5, 8).put(6, 9).put(7, 10).put(8, 11).put(9, 12).put(10, 14).put(11, 15).put(13, 16).put(14, 18).put(15, 19).put(17, 20).put(18, 22).build()).build(),
                    builder().name("Spellcasting Ability")
                            .description("Charisma is your spellcasting ability for your bard spells. Your magic comes from the heart and soul you pour into the performance of your music oration. You use your Charisma whenever a spell refers to your spellcasting ability. In addition, you use your Charisma modifier when setting the saving throw DC for a bard spell you cast and when making an attack roll with one.", "Spell save DC = 8 + your proficiency bonus + your Charisma modifier", "Spell attack modifier = your proficiency bonus + your Charisma modifier")
                            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.CHARISMA).build(),
                    builder().name("Ritual Casting").description("You can cast any bard spell you know as a ritual if that spell has the ritual tag.").build(),
                    builder().name("Spellcasting Focus").description("You can use a musical instrument as a spellcasting focus for your bard spells.").build())).build();
    public static final Feature BARDIC_INSPIRATION = builder().name("Bardic Inspiration")
            .description("You can inspire others through stirring words or music. To do so, you use a bonus action on your turn to choose on creature other than yourself withing 60 feet of you who can hear you. That creature gains one Bardic Inspiration die, a d6.", "Once within the next 10 minutes, the creature can roll the die and add the number rolled to one ability check, attack roll, or saving throw it makes. The creature can wait until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost. A creature can have only one Bardic Inspiration die at a time.", "You can use this feature a number of times equal to your Charisma modifier (a minimum of once). You regain any expended uses when you finish a long rest.", "Your bardic Inspiration die changes when you reach certain levels in this class. The die becomes a d8 at 5th level, a d10 at 10th level, and a d12 at 15th level.")
            .addProperty(MCDNDKeys.BARDIC_INSPIRATION_MAP, ImmutableMap.<Integer, Dice>builder().put(1, new Dice(6)).put(5, new Dice(8)).put(10, new Dice(10)).put(15, new Dice(12)).build()).build();
    public static final Feature JACK_OF_ALL_TRADES = builder().name("Jack of All Trades").levelRequirement(2)
            .description("Starting at 2nd level, you can add half your proficiency bonus, rounded down, to any ability check you make that doesn't already include your proficiency bonus.").build();
    public static final Feature SONG_OF_REST = builder().name("Song of Rest").levelRequirement(2)
            .description("Beginning at 2nd level, you can use soothing music or oration to help revitalize your wounded allies during a short rest. If you or any friendly creatures who can hear your performance regain hit points at the end of the short rest, each of those creatures regains an extra 1d6 hit points.", "The extra hit points increase when you reach certain levels in this class to 1d8 at 9th level, to 1d10 at 13th level, and to 1d12 at 17th level.")
            .addProperty(MCDNDKeys.SONG_OF_REST_MAP, ImmutableMap.<Integer, Dice>builder().put(2, new Dice(6)).put(9, new Dice(8)).put(13, new Dice(10)).put(17, new Dice(12)).build()).build();
    public static final Feature BARD_COLLEGE = builder().name("Bard College").levelRequirement(3)
            .description("At 3rd level, you delve into the advanced techniques of a bard college of your choice: the College of Lore or the College of Valor. Your choice grants you features at 3rd level and again at 6th and 14th level.")
            .addProperty(MCDNDKeys.BARD_COLLEGES, Arrays.asList(BardColleges.LORE, BardColleges.VALOR)).build();
    public static final Feature FONT_OF_INSPIRATION = builder().name("Font of Inspiration").levelRequirement(5)
            .description("Beginning when you reach 5th level, you regain all of your expended uses of Bardic Inspiration when you finish a short or long rest.").build();
    public static final Feature COUNTERCHARM = builder().name("Countercharm").levelRequirement(6)
            .description("At 6th level, you gain the ability to use musical notes or words of power to disrupt mind influencing effects. As an action, you can start a performance that lasts until the end of your next turn. During that time, you and any friendly creatures within 30 feet of you have advantage on saving throws against being  frightened or charmed. A creature must be able to hear you to gain this benefit. The performance ends early if you are incapacitated or silenced or if you voluntarily end it (no action required).")
            .build();
    public static final Feature MAGICAL_SECRETS = builder().name("Magical Secrets").levelRequirement(10)
            .description("By 10th level, you have plundered magical knowledge from a wide spectrum of disciplines. Choose two spells from any class, including this one. A spell you choose must be of a level you can cast, as shown on the Bard table, or a cantrip.", "The chosen spells count as bard spells for you and are included in the Spells Known column of the Bard table.", "You learn two additional spells from any class at 14th level and again at 18th level.")
            .addProperty(MCDNDKeys.INTEGERS, Arrays.asList(10, 14, 18)).build();
    public static final Feature SUPERIOR_INSPIRATION = builder().name("Superior Inspiration").levelRequirement(20)
            .description("At 20th level, when you roll initiative and have no uses of Bardic Inspiration left, you regain one use.").build();

    private BardFeatures()
    {

    }
}
