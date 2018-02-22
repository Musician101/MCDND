package io.musician101.mcdnd.sponge.clazz.feature.subclass.domain;

import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorTypes;
import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.magic.Spell;
import io.musician101.mcdnd.sponge.magic.Spells;
import java.util.Arrays;
import java.util.List;

import static io.musician101.mcdnd.sponge.clazz.feature.Feature.builder;

public class LifeDomain {

    public static final Feature BLESSED_HEALER = builder().name("Blessed Healer").levelRequirement(6).description("Beginning at 6th level, the healing spells you cast on others heal you as well. When you cast a spell of 1st level or higher that restores hit points to a creature other than you, you regain hit points equal to 2 + the spell's level.").levelRequirement(6).build();
    public static final Feature BONUS_PROFICIENCY = builder().name("Bonus Feature").description("When you choose this domain at 1st level, you gain proficiency with heavy armor.").addProperty(MCDNDKeys.ARMOR_TYPE, MCDNDArmorTypes.HEAVY).build();
    public static final Feature DISCIPLE_OF_LIFE = builder().name("Disciple of Life").description("Also starting at 1st level, your healing spells are more effective. Whenever you use a spell of 1st level or higher to restore hit points to a creature, the creature regains additional hit points equal to 2 + the spell's level.").build();
    public static final Feature DIVINE_STRIKE = builder().name("Divine Striker").levelRequirement(8).description("At 8th level, you gain the ability to infuse your weapon strikes with divine energy. Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 radiant damage to the target. When you reach 14th level, the extra damage increases to 2d8.").levelRequirement(8).addProperty(MCDNDKeys.INTEGER_DICE_MAP, ImmutableMap.<Integer, Dice>builder().put(8, new Dice(8)).put(14, new Dice(8)).build()).build();
    public static final Feature DOMAIN_SPELLS = builder().name("Life Domain Spells").addProperty(MCDNDKeys.SPElLS_MAP, ImmutableMap.<Integer, List<Spell>>builder().put(1, Arrays.asList(Spells.BLESS, Spells.CURE_WOUNDS)).put(3, Arrays.asList(Spells.LESSER_RESTORATION, Spells.SPIRITUAL_WEAPON)).put(5, Arrays.asList(Spells.BEACON_OF_HOPE, Spells.REVIVIFY)).put(7, Arrays.asList(Spells.DEATH_WARD, Spells.GUARDIAN_OF_FAITH)).put(9, Arrays.asList(Spells.MASS_CURE_WOUNDS, Spells.RAISE_DEAD)).build()).build();
    public static final Feature PRESERVE_LIFE = builder().name("Channel Divinity: Preserver Life").levelRequirement(2).addLineToDescription("Starting at 2nd level, you can use your Channel Divinity to heal the badly injured.").addLineToDescription("As an action, you present your holy symbol and evoke healing energy that can restore a number of hit points equal to five times your cleric level. Choose any creatures within 30 feet of you, and divide those hit points among them. This feature can restore a creature to no more than half of its hit point maximum. You can't use this feature on an undead or a construct.").levelRequirement(2).build();
    public static final Feature SUPREME_HEALING = builder().name("Supreme Healing").levelRequirement(17).description("Starting at 17th level, when you would normally roll one or more dice to restore hit points with a spell, you instead use the highest number possible for each die. For example, instead of restoring 2d6 hit points to a creature, you restore 12.").build();

    private LifeDomain() {

    }
}
