package io.musician101.sponge.mcdnd.clazz.feature.subclass.domain;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.MCDNDArmorTypes;
import io.musician101.sponge.mcdnd.magic.Spells;
import io.musician101.sponge.mcdnd.util.list.SpellList;

import java.util.Arrays;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;
import static io.musician101.sponge.mcdnd.util.list.SpellList.of;

public class NatureDomain
{
    public static final Feature DOMAIN_SPELLS = builder().name("Nature Domain Spells")
            .addProperty(MCDNDKeys.SPElLS_MAP, ImmutableMap.<Integer, SpellList>builder().put(1, of(Arrays.asList(Spells.ANIMAL_FRIENDSHIP, Spells.SPEAK_WITH_ANIMALS))).put(3, of(Arrays.asList(Spells.BARKSKIN, Spells.SPIKE_GROWTH))).put(5, of(Arrays.asList(Spells.PLANT_GROWTH, Spells.WIND_WALL))).put(7, of(Arrays.asList(Spells.DOMINATE_BEAST, Spells.GRASPING_VINE))).put(9, of(Arrays.asList(Spells.INSECT_PLAGUE, Spells.TREE_STRIDE))).build())
            .build();
    public static final Feature ACOLYTE_OF_NATURE = builder().name("Acolyte of Nature").description("At 1st level, you learn one druid cantrip of your choice. You also gain proficiency in one of the following skills of your choice: Animal Handling, Nature, or Survival.")
            .addProperty(MCDNDKeys.SKILL_TYPES, Arrays.asList(SkillTypes.ANIMAL_HANDLING, SkillTypes.NATURE, SkillTypes.SURVIVAL))
            .build();
    public static final Feature BONUS_PROFICIENCY = builder().name("Bonus Feature").description("When you choose this domain at 1st level, you gain proficiency with heavy armor.").addProperty(MCDNDKeys.ARMOR_TYPE, MCDNDArmorTypes.HEAVY).build();
    public static final Feature CHARM_ANIMALS_AND_PLANTS = builder().name("Channel Divinity: Charm Animals and Plants").levelRequirement(2)
            .addLineToDescription("Starting at 2nd level, you can use your Channel Divinity to charm animals and plants.")
            .addLineToDescription("As an action, you present your holy symbol invoke the name of your deity. Each beast or plant creature that can see you within 30 feet of you must make a Wisdom saving throw. If the creature fails its saving throw, it is charmed by you for 1 minute or until it takes damage. While it is charmed by you, it is friendly to you and other creatures you designate.")
            .build();
    public static final Feature DAMPEN_ELEMENTS = builder().name("Dampen Elements").levelRequirement(6).description("Starting at 6th level, when you or a creature within 30 feet of you takes acid, cold, fire, lightning, or thunder damage, you can use your reaction to grant resistance to the creature against that instance of the damage.")
            .addProperty(MCDNDKeys.DAMAGE_TYPES, Arrays.asList(MCDNDDamageTypes.ACID, MCDNDDamageTypes.COLD, MCDNDDamageTypes.FIRE, MCDNDDamageTypes.LIGHTNING, MCDNDDamageTypes.THUNDER))
            .build();
    public static final Feature DIVINE_STRIKE = builder().name("Divine Strike").levelRequirement(8).description("At 8th level, you gain the ability to infuse your weapon strikes with divine energy. Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 cold, fire, or lightning damage (your choice) to the target. When you reach 14th level, the extra damage increases to 2d8.")
            .addProperty(MCDNDKeys.INTEGER_DICE_MAP, ImmutableMap.<Integer, Dice>builder().put(8, new Dice(8)).put(14, new Dice(8, 2)).build()).addProperty(MCDNDKeys.DAMAGE_TYPES, Arrays.asList(MCDNDDamageTypes.COLD, MCDNDDamageTypes.FIRE, MCDNDDamageTypes.LIGHTNING))
            .build();
    public static final Feature MASTER_OF_NATURE = builder().name("Master of Nature").levelRequirement(17)
            .description("At 17th level, you gain the ability to command animals and plant creatures. While creatures are charmed by your Charm Animals and Plants feature, you can take a bonus on your turn to verbally command what each of those creatures will do on its next turn.")
            .build();

    private NatureDomain()
    {

    }
}
