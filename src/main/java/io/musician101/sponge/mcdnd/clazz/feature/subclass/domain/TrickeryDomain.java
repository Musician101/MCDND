package io.musician101.sponge.mcdnd.clazz.feature.subclass.domain;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.magic.Spells;
import io.musician101.sponge.mcdnd.util.ActionTimes;
import io.musician101.sponge.mcdnd.util.list.SpellList;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;
import static io.musician101.sponge.mcdnd.util.list.SpellList.of;

public class TrickeryDomain
{
    public static final Feature DOMAIN_SPELLS = builder().name("Trickery Domain Spells")
            .addProperty(MCDNDKeys.SPElLS_MAP, ImmutableMap.<Integer, SpellList>builder()
                    .put(1, of(Spells.CHARM_PERSON, Spells.DISGUISE_SELF))
                    .put(3, of(Spells.MIRROR_IMAGE, Spells.PASS_WITHOUT_TRACE))
                    .put(5, of(Spells.BLINK, Spells.DISPEL_MAGIC))
                    .put(7, of(Spells.DIMENSION_DOOR, Spells.POLYMORPH))
                    .put(9, of(Spells.DOMINATE_PERSON, Spells.MODIFY_MEMORY))
                    .build()).build();
    public static final Feature BLESSING_OF_THE_TRICKSTER = builder().name("Blessing of the Trickster")
            .description("Starting when you choose this domain at 1st level, you can use your action to touch a willing creature other than yourself to give it advantage on Dexterity (Stealth) checks. This blessing lasts for 1 hour or until you use this feature again.")
            .addProperty(MCDNDKeys.SKILL_TYPE, SkillTypes.STEALTH)
            .addProperty(MCDNDKeys.DURATION, ActionTimes.ONE_HOUR)
            .build();
    public static final Feature INVOKE_DUPLICITY = builder().name("Channel Divinity: Invoke Duplicity").levelRequirement(2)
            .addLineToDescription("Starting at 2nd Level, you can use your Channel Divinity to create an illusory duplicate of yourself.")
            .addLineToDescription("As an action, you create a perfect illusion of yourself that lasts for 1 minute, or until you lose your concentration (as if you were concentrating on a spell). The illusion appears in an unoccupied space that you can see within 30 feet of you. As a bonus action on your turn, you can move the illusion up to 30 feet to a space you can see, but it must remain within 120 feet of you.")
            .addLineToDescription("For the duration, you can cast spells as though you were in the illusion's space, but you must use your own senses. Additionally, when both you and your illusion are within 5 feet of a creature that can see the illusion, you have advantage on attack rolls against that creature, given how distracting the illusion is to the target.")
            .levelRequirement(2)
            .addProperty(MCDNDKeys.INTEGER, 5)
            .addProperty(MCDNDKeys.RANGE, 30)
            .addProperty(MCDNDKeys.DISTANCE, 30)
            .addProperty(MCDNDKeys.MAX_RANGE, 120)
            .addProperty(MCDNDKeys.DURATION, ActionTimes.ONE_MINUTE)
            .build();
    public static final Feature CLOAK_OF_SHADOWS = builder().name("Channel Divinity: Cloak of Shadows").levelRequirement(6)
            .addLineToDescription("Starting at 6th level, you can use your Channel Divinity to vanish.")
            .addLineToDescription("As an action, you become invisible until the end of your next turn. You become visible if you attack or cast a spell.")
            .levelRequirement(6)
            .build();
    public static final Feature DIVINE_STRIKE = builder().name("Divine Strike").levelRequirement(8)
            .description("At 8th level, you gain the ability to infuse your weapon strikes with poison - a gift from your deity. Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 poison damage to the target. When you reach 14th level, the extra damage increases to 2d8.")
            .levelRequirement(8)
            .addProperty(MCDNDKeys.INTEGER_DAMAGE_MAP, ImmutableMap.<Integer, Damage>builder()
                    .put(8, new Damage(MCDNDDamageTypes.POISON, new Dice(8)))
                    .put(14, new Damage(MCDNDDamageTypes.POISON, new Dice(8, 2)))
                    .build()).build();
    public static final Feature IMPROVED_DUPLICITY = builder().name("Improved Duplicity").levelRequirement(17)
            .description("At 17th level, you can create up to four duplications of yourself, instead of one, when you use Invoke Duplicity. As a bonus action on your turn, you can move any number of them up to 30 feet, to a maximum range of 120 feet.")
            .levelRequirement(17)
            .addProperty(MCDNDKeys.DISTANCE, 30)
            .addProperty(MCDNDKeys.MAX_RANGE, 120)
            .build();

    private TrickeryDomain()
    {

    }
}
