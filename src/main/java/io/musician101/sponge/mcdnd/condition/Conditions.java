package io.musician101.sponge.mcdnd.condition;

import io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.util.table.Table;

import java.util.Arrays;

import static io.musician101.sponge.mcdnd.condition.Condition.builder;

public class Conditions
{
    public static final Condition BLINDED = builder().name("Blinded")
            .addLineToDescription("A blinded creature can't see and automatically fails any ability check that requires sight.")
            .addLineToDescription("Attack rolls against the creature have disadvantage, and the creature's attack rolls have disadvantage.")
            .build();
    public static final Condition CHARMED = builder().name("Charmed")
            .addLineToDescription("A charmed creature can't attack the charmer or target the charmer or target the charmer with harmful abilities or magical effects.")
            .addLineToDescription("The charmer has advantage on any ability check to interact socially with the creature.")
            .build();
    public static final Condition DEAFENED = builder().name("Deafened")
            .description("A deafened creature can't hear and automatically fails any ability check that requires hearing.")
            .build();
    public static final Condition EXHAUSTION = builder().name("Exhausted")
            .addLineToDescription("Some special abilities and environmental hazards, such as starvation and the long-term effects of freezing or scorching temperatures, can lead to a special condition called exhaustion. Exhaustion is measured in six levels. An effect can give a creature one or more levels of exhaustion, as specified in the effect's description.")
            .addLineToDescription("If an already exhausted creature suffers another effect that causes exhaustion, its current level of exhaustion increases by the amount specified in the effect's description.")
            .addLineToDescription("A creature suffers the effect of its current level of exhaustion as well as all lower levels. For example, a creature suffering level 2 exhaustion has its speed halved and has disadvantage on ability checks.")
            .addLineToDescription("An effect that removes exhaustion reduces its level as specified in the effect's description, with all exhaustion effects ending if a creature's exhaustion level is reduced below 1.")
            .addLineToDescription("Finishing a long rest reduces a creature's exhaustion level by 1, provided that the creature has also ingested some food and drink.")
            .addProperty(MCDNDKeys.TABLE, Table.builder().name("Exhaustion").addColumn(MCDNDKeys.LEVEL_COLUMN, Arrays.asList(1, 2, 3, 4, 5, 6))
                    .addColumn(MCDNDKeys.EFFECT_COLUMN, Arrays.asList("Disadvantage", "Speed halved", "Disadvantage on attack rolls and saving throws", "Hit point maximum halved", "Speed reduced to 0", "Death"))
                    .build()).build();
    public static final Condition FRIGHTENED = builder().name("Frightened")
            .description("A frightened creature has disadvantage on ability checks and attack rolls while the source of its fear is within line of sight.")
            .addLineToDescription("The creature can't willingly move closer to the source of its fear.")
            .build();
    public static final Condition INCAPACITATED = builder().name("Incapacitated")
            .description("An incapacitated creature can't take actions or reactions.")
            .build();
    public static final Condition GRAPPLED = builder().name("Grappled")
            .addLineToDescription("A grappled creature's speed becomes 0, and it can't benefit from any bonus to its speed.")
            .addLineToDescription("The condition ends if the grappler is incapacitated (see the condition).")
            .addLineToDescription("The condition also ends if an effect removes the grappled creature from the reach of the grappler or grappling effect, such as when a creature is hurled away by the Thunderwave spell.")
            .addProperty(MCDNDKeys.INTEGER, 0).addProperty(MCDNDKeys.CONDITION, INCAPACITATED)
            .build();
    public static final Condition INVISIBLE = builder().name("Invisible")
            .addLineToDescription("An invisible creature is impossible to see without the aid of magic or a special sense. For the purpose of hiding, the creature is heavily obscured. The creature's location can be detected by any noise it makes or any tracks it leaves.")
            .addLineToDescription("Attack rolls against the creature have disadvantage, and the creature's attack rolls have advantage.")
            .build();
    public static final Condition PARALYZED = builder().name("Paralyzed")
            .addLineToDescription("A paralyzed creature is incapacitated (see the condition) and can't move or speak.")
            .addLineToDescription("The creature automatically fails Strength and Dexterity saving throws.")//NOSONAR
            .addLineToDescription("Attack rolls against the creature have advantage.")//NOSONAR
            .addLineToDescription("Any attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature.")
            .addProperty(MCDNDKeys.CONDITION, INCAPACITATED)
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPES, Arrays.asList(AbilityScoreTypes.STRENGTH, AbilityScoreTypes.DEXTERITY))
            .addProperty(MCDNDKeys.INTEGER, 5)
            .build();
    public static final Condition PETRIFIED = builder().name("Petrified")
            .addLineToDescription("A petrified creature is transformed, along with any nonmagical object it is wearing or carrying, into a solid inanimate substance (usually stone). Its weight increases by a factor of ten, and it ceases aging.")
            .addLineToDescription("The creature is incapacitated (see the condition), can't move or speak, and is unaware of its surroundings.")
            .addLineToDescription("Attack rolls against the creature have advantage.")
            .addLineToDescription("The creature automatically fails Strength and Dexterity saving throws.")
            .addLineToDescription("The creature has resistance to all damage.")
            .addLineToDescription("The creature is immune to poison and disease, although a poison or disease already in its system is suspended, not neutralized.")
            .addProperty(MCDNDKeys.CONDITION, INCAPACITATED)
            .addProperty(MCDNDKeys.DUAL_INTEGER_FUNCTION, num -> num * 10)
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPES, Arrays.asList(AbilityScoreTypes.STRENGTH, AbilityScoreTypes.DEXTERITY))
            .addProperty(MCDNDKeys.DAMAGE_TYPES, MCDNDDamageTypes.ALL)
            .build();
    public static final Condition POISONED = builder().name("Poisoned")
            .description("A poisoned creature has disadvantage on attack rolls and ability checks.")
            .build();
    public static final Condition PRONE = builder().name("Prone")
            .addLineToDescription("A prone creature's only movement option is to crawl, unless it stands up and thereby ends the condition.")
            .addLineToDescription("The creature has disadvantage on attack rolls.")
            .addLineToDescription("An attack roll against the creature has advantage if the attack is within 5 feet of the creature. Otherwise, the attack roll has disadvantage.")
            .addProperty(MCDNDKeys.INTEGER, 5)
            .build();
    public static final Condition RESTRAINED = builder().name("Restrained")
            .addLineToDescription("A restrained creature's speed becomes 0, and it can't benefit from any bonus to its speed.")
            .addLineToDescription("Attack rolls against the creature have advantage, and the creature's attack rolls have disadvantage.")
            .addLineToDescription("The creature has disadvantage on Dexterity saving throws.")
            .addProperty(MCDNDKeys.INTEGER, 0)
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPE, AbilityScoreTypes.DEXTERITY)
            .build();
    public static final Condition STUNNED = builder().name("Stunned")
            .addLineToDescription("A stunned creature is incapacitated (see the condition), can't move, and can speak only falteringly.")
            .addLineToDescription("The creature automatically fails Strength and Dexterity saving throws.")
            .addProperty(MCDNDKeys.CONDITION, INCAPACITATED)
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPES, Arrays.asList(AbilityScoreTypes.STRENGTH, AbilityScoreTypes.DEXTERITY))
            .build();
    public static final Condition UNCONSCIOUS = builder().name("Unconscious")
            .addLineToDescription("An unconscious creature is incapacitated (see the condition), can't move or speak, and is unaware of its surroundings.")
            .addLineToDescription("The creature drops whatever it's holding and falls prone.")
            .addLineToDescription("The creature automatically fails Strength and Dexterity saving throws.")
            .addLineToDescription("Attack rolls against the creature have advantage.")
            .addLineToDescription("Any attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature.")
            .addProperty(MCDNDKeys.CONDITION, INCAPACITATED)
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPES, Arrays.asList(AbilityScoreTypes.STRENGTH, AbilityScoreTypes.DEXTERITY))
            .addProperty(MCDNDKeys.INTEGER, 5)
            .build();

    private Conditions()
    {

    }
}
