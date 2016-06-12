package io.musician101.sponge.mcdnd.clazz.feature.subclass.domain;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.magic.Spells;
import io.musician101.sponge.mcdnd.util.list.SpellList;

import java.util.Arrays;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;
import static io.musician101.sponge.mcdnd.util.list.SpellList.of;

public class LightDomain
{
    public static final Feature DOMAIN_SPELLS = builder().name("Light Domain Spells")
            .addProperty(MCDNDKeys.SPELL_LIST_MAP, ImmutableMap.<Integer, SpellList>builder().put(1, of(Arrays.asList(Spells.BURNING_HANDS, Spells.FAERIE_FIRE))).put(3, of(Arrays.asList(Spells.FLAMING_SPHERE, Spells.SCORCHING_RAY))).put(5, of(Arrays.asList(Spells.DAYLIGHT, Spells.FIREBALL))).put(7, of(Arrays.asList(Spells.GUARDIAN_OF_FAITH, Spells.WALL_OF_FIRE))).put(9, of(Arrays.asList(Spells.FLAME_STRIKE, Spells.SCRYING))).build())
            .build();
    public static final Feature BONUS_CANTRIP = builder().name("Bonus Cantrip")
            .description("When you choose this domain at 1st level, you gain the Light Cantrip if you don't already know it.")
            .addProperty(MCDNDKeys.SPELL, Spells.LIGHT).build();
    public static final Feature WARDING_FLARE = builder().name("Warding Flare")
            .description("Also at 1st level, you can interpose divine light between yourself and an attacking enemy. When you are attacked by a creature within 30 feet of you that you can see, you can use your reaction to impose disadvantage on the attack roll, causing light to flare before the attacker before it hits or misses. An attacker that can't be blinded is immune to this feature.", "You can use this feature a number of times equal to your Wisdom modifier (a minimum of once). You regain all expended uses when you finish a long rest.")
            .build();
    public static final Feature RADIANCE_OF_THE_DAWN = builder().name("Channel Divinity: Radiance of the Dawn").levelRequirement(2)
            .description("Starting at 2nd level, you can use your Channel Divinity to harness sunlight, banishing darkness and dealing radiant damage to your foes.", "As an action, you present your holy symbol, and any magical darkness within 30 feet of you is dispelled. Additionally, each hostile creature within 30 feet of you must make a Constitution saving throw. A creature takes radiant damage equal 2d10 + your cleric level on a failed saving throw, and half as much damage on a successful one. A creature that has total cover from you is not affected.")
            .build();
    public static final Feature IMPROVED_FLARE = builder().name("Improved Flare").levelRequirement(6)
            .description("Starting at 6th level, you can also use your Warding Flare feature when a creature that you can see within 30 feet of you attacks a creature other than you.")
            .build();
    public static final Feature POTENT_SPELLCASTING = builder().name("Potent Spellcasting").levelRequirement(8)
            .description("Starting at 8th level, you add your Wisdom modifier to the damage you deal with any cleric cantrip.")
            .build();
    public static final Feature CORONA_OF_LIGHT = builder().name("Corona of Light").levelRequirement(17)
            .description("Starting at 17th level, you can use your action to activate an aura of sunlight that lasts for 1 minute or until you dismiss it using another action. You emit bright light in a 60-foot radius and dim light 30 feet beyond that. Your enemies in the bright light have disadvantage on saving throws against any spell that deals fire or radiant damage.")
            .build();

    private LightDomain()
    {

    }
}
