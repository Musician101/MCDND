package io.musician101.mcdnd.sponge.clazz.feature.subclass.domain;

import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.combat.MCDNDDamageTypes;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.equipment.armor.Armors;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapons;
import io.musician101.mcdnd.sponge.magic.Spell;
import io.musician101.mcdnd.sponge.magic.Spells;

import java.util.Arrays;
import java.util.List;

import static io.musician101.mcdnd.sponge.clazz.feature.Feature.builder;

public class TempestDomain
{
    public static final Feature DOMAIN_SPELLS = builder().name("Tempest Domain Spells")
            .addProperty(MCDNDKeys.SPElLS_MAP, ImmutableMap.<Integer, List<Spell>>builder()
                    .put(1, Arrays.asList(Spells.FOG_CLOUD, Spells.THUNDERWAVE))
                    .put(3, Arrays.asList(Spells.GUST_OF_WIND, Spells.SHATTER))
                    .put(5, Arrays.asList(Spells.CALL_LIGHTNING, Spells.SLEET_STORM))
                    .put(7, Arrays.asList(Spells.CONTROL_WATER, Spells.ICE_STORM))
                    .put(9, Arrays.asList(Spells.DESTRUCTIVE_WAVE, Spells.INSECT_PLAGUE)).build()).build();
    public static final Feature BONUS_PROFICIENCIES = builder().name("Bonus Proficiencies")
            .description("At 1st level, you gain proficiency with martial weapons and heavy armor.")
            .addProperty(MCDNDKeys.ARMORS, Armors.getHeavyArmor()).addProperty(MCDNDKeys.WEAPONS, Weapons.getMartialWeapons()).build();
    public static final Feature WRATH_OF_THE_STORM = builder().name("Wrath of the Storm")
            .addLineToDescription("Also at 1st level, you can thunderously rebuke attackers. When a creature within 5 feet of you that you can see hits you with an attack, you can use your reaction to cause the creature to make a Dexterity saving throw. The creature takes 2d8 lightning or thunder damage (your choice> on a failed saving throw, and half as much damage on a successful one.")
            .addLineToDescription("You can use this feature a number of times equal to your Wisdom modifier (a minimum of once). You regain all expended uses when you finish a long rest.")
            .build();
    public static final Feature DESTRUCTIVE_WRATH = builder().name("Channel Divinity: Destructive Wrath").levelRequirement(2)
            .addLineToDescription("Starting at 2nd level, you can use your Channel Divinity to wield the power of the storm with unchecked ferocity.")
            .addLineToDescription("When you roll lightning or thunder damage, you can use your Channel Divinity to deal maximum damage, instead of rolling.")
            .levelRequirement(2)
            .build();
    public static final Feature THUNDERBOLT_STRIKE = builder().name("Thunderbolt Strike").levelRequirement(6)
            .description("At 6th level, when you deal lightning damage to a Large or smaller creature, you can also push it up to 10 feet away from you.")
            .levelRequirement(6)
            .addProperty(MCDNDKeys.INTEGER, 10).build();
    public static final Feature DIVINE_STRIKE = builder().name("Divine Strike").levelRequirement(8)
            .description("At 8th level, you gain the ability to infuse your weapon strikes with divine energy. Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 thunder damage to the target. When you reach 14th level, the extra damage increases to 2d8.")
            .levelRequirement(8)
            .addProperty(MCDNDKeys.INTEGER_DICE_MAP, ImmutableMap.<Integer, Dice>builder().put(8, new Dice(8)).put(14, new Dice(8, 2)).build()).addProperty(MCDNDKeys.DAMAGE_TYPE, MCDNDDamageTypes.THUNDER).build();
    public static final Feature STORMBORN = builder().name("Stormborn").levelRequirement(17).description("At 17th level, you have a flying speed equal to your current walking speed whenever you are not underground or indoors.").build();

    private TempestDomain()
    {

    }
}
