package io.musician101.mcdnd.sponge.clazz.feature.subclass.fightingstyle;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.handler.fightingstyle.ArcheryHandler;
import io.musician101.mcdnd.sponge.handler.fightingstyle.DefenseHandler;
import io.musician101.mcdnd.sponge.handler.fightingstyle.DuelingHandler;
import io.musician101.mcdnd.sponge.handler.fightingstyle.GreatWeaponHandler;
import io.musician101.mcdnd.sponge.handler.fightingstyle.ProtectionHandler;
import io.musician101.mcdnd.sponge.handler.fightingstyle.TwoWeaponFightingHandler;

import static io.musician101.mcdnd.sponge.clazz.feature.subclass.fightingstyle.FightingStyle.builder;

public class FightingStyles
{
    public static final FightingStyle ARCHERY = builder().name("Archery")
            .description("You gain a +2 bonus to attack rolls you make with ranged weapons.")
            .addProperty(MCDNDKeys.ARCHERY_HANDLER, ArcheryHandler.class.getName()).build();
    public static final FightingStyle DEFENSE = builder().name("Defense")
            .description("While you are wearing armor, you gain a +1 bonus to AC.")
            .addProperty(MCDNDKeys.DEFENSE_HANDLER, DefenseHandler.class.getName()).build();
    public static final FightingStyle DUELING = builder().name("Dueling")
            .description("When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon.")
            .addProperty(MCDNDKeys.DUELING_HANDLER, DuelingHandler.class.getName()).build();
    public static final FightingStyle GREAT_WEAPON_FIGHTING = builder().name("Great Weapon Fighting")
            .description("When you roll a 1 or a 2 on a damage die for an attack you make with a melee weapon that you are wielding with two hands, you can reroll the die and must use the new roll, even if the new roll is a 1 or 2. The weapon must have the two-handed or versatile property for you to gain this benefit.")
            .addProperty(MCDNDKeys.GREAT_WEAPON_FIGHTING_HANDLER, GreatWeaponHandler.class.getName()).build();
    public static final FightingStyle PROTECTION = builder().name("Protection")
            .description("When a creature you can see attacks a target other than you that is within 5 feet of you, you can use your reaction to impose disadvantage on the attack roll. You must be wielding a shield.")
            .addProperty(MCDNDKeys.PROTECTION_HANDLER, ProtectionHandler.class.getName()).build();
    public static final FightingStyle TWO_WEAPON_FIGHTING = builder().name("Two-Weapon Fighting")
            .description("When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack.")
            .addProperty(MCDNDKeys.TWO_WEAPON_FIGHTING_HANDLER, TwoWeaponFightingHandler.class.getName())
            .build();

    private FightingStyles()
    {

    }
}
