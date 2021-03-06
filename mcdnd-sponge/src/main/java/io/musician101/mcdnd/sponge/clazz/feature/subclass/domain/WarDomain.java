package io.musician101.mcdnd.sponge.clazz.feature.subclass.domain;

import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.combat.MCDNDDamageTypes;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorTypes;
import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapons;
import io.musician101.mcdnd.sponge.magic.Spell;
import io.musician101.mcdnd.sponge.magic.Spells;
import java.util.Arrays;
import java.util.List;

import static io.musician101.mcdnd.sponge.clazz.feature.Feature.builder;

public class WarDomain {

    public static final Feature AVATAR_OF_BATTLE = builder().name("Avatar of Battle").levelRequirement(17).description("At 17th level, you gain resistance to bludgeoning, piercing, and slashing damage from nonmagical weapons.").levelRequirement(17).addProperty(MCDNDKeys.DAMAGE_TYPES, Arrays.asList(MCDNDDamageTypes.BLUDGEONING, MCDNDDamageTypes.PIERCING, MCDNDDamageTypes.SLASHING)).build();
    public static final Feature BONUS_PROFICIENCIES = builder().name("Bonus Proficiencies").description("At 1st level, you gain proficiency with martial weapons and heavy armor.").addProperty(MCDNDKeys.WEAPONS, Weapons.getMartialWeapons()).addProperty(MCDNDKeys.ARMOR_TYPE, MCDNDArmorTypes.HEAVY).build();
    public static final Feature DIVINE_STRIKE = builder().name("Divine Strike").levelRequirement(8).description("At 8th level, you gain the ability to infuse your weapon strikes with divine energy. Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 damage of the same type dealt by the weapon to the target. When you reach 14th level, the extra damage increases to 2d8.").levelRequirement(8).addProperty(MCDNDKeys.INTEGER_DICE_MAP, ImmutableMap.<Integer, Dice>builder().put(8, new Dice(8)).put(14, new Dice(8, 2)).build()).build();
    public static final Feature DOMAIN_SPELLS = builder().name("War Domain Spells").addProperty(MCDNDKeys.SPElLS_MAP, ImmutableMap.<Integer, List<Spell>>builder().put(1, Arrays.asList(Spells.DIVINE_FAVOR, Spells.SHIELD_OF_FAITH)).put(3, Arrays.asList(Spells.MAGIC_WEAPON, Spells.SPIRITUAL_WEAPON)).put(5, Arrays.asList(Spells.CRUSADERS_MANTLE, Spells.SPIRIT_GUARDIANS)).put(7, Arrays.asList(Spells.FREEDOM_OF_MOVEMENT, Spells.STONESKIN)).put(9, Arrays.asList(Spells.FLAME_STRIKE, Spells.HOLD_MONSTER)).build()).build();
    public static final Feature GUIDED_STRIKE = builder().name("Channel Divinity: Guided Strike").levelRequirement(2).description("Starting at 2nd level, you can use your Channel Divinity to strike with supernatural accuracy. When you make an attack roll, you can use your Channel Divinity to gain a +10 bonus to the roll. You make this choice after you see the roll, but before the DM says whether the attack hits or misses.").levelRequirement(2).addProperty(MCDNDKeys.INTEGER, 10).build();
    public static final Feature WAR_GODS_BLESSING = builder().name("Channel Divinity: War God's Blessing").levelRequirement(6).description("At 6th level, when a creature within 30 feet of you makes an attack roll, you can use your reaction to grant that creature a +10 bonus to the roll, using your Channel Divinity. You make this choice after you see the roll, but before the DM says whether the attack hits or misses.").levelRequirement(6).addProperty(MCDNDKeys.INTEGER, 10).build();
    public static final Feature WAR_PRIEST = builder().name("War Priest").addLineToDescription("From 1st level, your god delivers bolts of inspiration to you while you are engaged in battle. When you use the Attack action, you can make one weapon attack as a bonus action.").addLineToDescription("You can use this feature a number of times equal to your Wisdom modifier (a minimum of once). You regain all expended uses when you finish a long rest.").addProperty(MCDNDKeys.DUAL_INTEGER_FUNCTION, mod -> {
        if (mod <= 0) {
            return 1;
        }
        else {
            return mod;
        }
    }).addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.WISDOM).build();

    private WarDomain() {

    }
}
