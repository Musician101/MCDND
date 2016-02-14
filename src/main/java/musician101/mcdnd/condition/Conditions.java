package musician101.mcdnd.condition;

import musician101.mcdnd.abilityscore.AbilityScoreTypes;
import musician101.mcdnd.combat.DamageTypes;
import musician101.mcdnd.property.ListProperty;
import musician101.mcdnd.property.SingleValueProperty;
import musician101.mcdnd.util.Table;
import musician101.mcdnd.util.Table.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class Conditions
{
    public static final Condition BLINDED = new Condition("Blinded", "A blinded creature can't see and automatically fails any ability check that requires sight.", "Attack rolls against the creature have disadvantage, and the creature's attack rolls have disadvantage.");
    public static final Condition CHARMED = new Condition("Charmed", "A charmed creature can't attack the charmer or target the charmer or target the charmer with harmful abilities or magical effects.", "The charmer has advantage on any ability check to interact socially with the creature.");
    public static final Condition DEAFENED = new Condition("Deafened", "A deafened creature can't hear and automatically fails any ability check that requires hearing.");
    public static final Condition EXHAUSTION = new Exhaustion();
    public static final Condition FRIGHTENED = new Condition("Frightened", "A frightened creature has disadvantage on ability checks and attack rolls while the source of its fear is within line of sight.", "The creature can't willingly move closer to the source of its fear.");
    public static final Condition GRAPPLED = new Grappled();
    public static final Condition INCAPACITATED = new Condition("Incapacitated", "An incapacitated creature can't take actions or reactions.");
    public static final Condition INVISIBLE = new Condition("Invisible", "An invisible creature is impossible to see without the aid of magic or a special sense. For the purpose of hiding, the creature is heavily obscured. The creature's location can be detected by any noise it makes or any tracks it leaves.", "Attack rolls against the creature have disadvantage, and the creature's attack rolls have advantage.");
    public static final Condition PARALYZED = new Paralyzed();
    public static final Condition PETRIFIED = new Petrified();
    public static final Condition POISONED = new Condition("Poisoned", "A poisoned creature has disadvantage on attack rolls and ability checks.");
    public static final Condition PRONE = new Prone();
    public static final Condition RESTRAINED = new Restrained();
    public static final Condition STUNNED = new Stunned();
    public static final Condition UNCONSCIOUS = new Unconscious();

    private static class Exhaustion extends Condition
    {
        private Exhaustion()
        {
            super("Exhausted", "Some special abilities and environmental hazards, such as starvation and the long-term effects of freezing or scorching temperatures, can lead to a special condition called exhaustion. Exhaustion is measured in six levels. An effect can give a creature one or more levels of exhaustion, as specified in the effect's description.", "If an already exhausted creature suffers another effect that causes exhaustion, its current level of exhaustion increases by the amount specified in the effect's description.", "A creature suffers the effect of its current level of exhaustion as well as all lower levels. For example, a creature suffering level 2 exhaustion has its speed halved and has disadvantage on ability checks.", "An effect that removes exhaustion reduces its level as specified in the effect's description, with all exhaustion effects ending if a creature's exhaustion level is reduced below 1.", "Finishing a long rest reduces a creature's exhaustion level by 1, provided that the creature has also ingested some food and drink.");
            properties = Collections.singletonList(new SingleValueProperty<>(getId() + ".property.single_value.table", new Table("Exhaustion", new Column<>("Level", 1, 2, 3, 4, 5, 6), new Column<>("Effect", "Disadvantage", "Speed halved", "Disadvantage on attack rolls and saving throws", "Hit point maximum halved", "speed reduced to 0", "Death"))));
        }
    }

    private static class Grappled extends Condition
    {
        private Grappled()
        {
            super("Grappled", "A grappled creature's speed becomes 0, and it can't benefit from any bonus to its speed.", "The condition ends if the grappler is incapacitated (see the condition).", "The condition also ends if an effect removes the grappled creature from the reach of the grappler or grappling effect, such as when a creature is hurled away by the Thunderwave spell.");
            properties = Arrays.asList(new SingleValueProperty<>(getId() + ".property.single_value.integer", 0), new SingleValueProperty<>(getId() + ".property.single_value.condition", INCAPACITATED));
        }
    }

    private static class Paralyzed extends Condition
    {
        private Paralyzed()
        {
            super("Paralyzed", "A paralyzed creature is incapacitated (see the condition) and can't move or speak.", "The creature automatically fails Strength and Dexterity saving throws.", "Attack rolls against the creature have advantage.", "Any attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature.");
            properties = Arrays.asList(new SingleValueProperty<>(getId() + ".property.single_value.condition", INCAPACITATED), new ListProperty<>(getId() + ".property.list.ability_score_type", Arrays.asList(AbilityScoreTypes.STR, AbilityScoreTypes.DEX)), new SingleValueProperty<>(getId() + ".property.single_value.integer", 5));
        }
    }

    private static class Petrified extends Condition
    {
        private Petrified()
        {
            super("Petrified", "A petrified creature is transformed, along with any nonmagical object it is wearing or carrying, into a solid inanimate substance (usually stone). Its weight increases by a factor of ten, and it ceases aging.", "The creature is incapacitated (see the condition), can't move or speak, and is unaware of its surroundings.", "Attack rolls against the creature have advantage.", "The creature automatically fails Strength and Dexterity saving throws.", "The creature has resistance to all damage.", "The creature is immune to poison and disease, although a poison or disease already in its system is suspended, not neutralized.");
            properties = Arrays.asList(new SingleValueProperty<>(getId() + ".property.single_value.condition", INCAPACITATED), new SingleValueProperty<Function<Integer, Integer>>(getId() + ".property.single_value.function", num -> num * 10), new ListProperty<>(getId() + ".property.list.ability_score_type", Arrays.asList(AbilityScoreTypes.STR, AbilityScoreTypes.DEX)), new ListProperty<>(getId() + ".property.list.damage_type", DamageTypes.ALL));
        }
    }

    private static class Prone extends Condition
    {
        private Prone()
        {
            super("Prone", "A prone creature's only movement option is to crawl, unless it stands up and thereby ends the condition.", "The creature has disadvantage on attack rolls.", "An attack roll against the creature has advantage if the attack is within 5 feet of the creature. Otherwise, the attack roll has disadvantage.");
            properties = Collections.singletonList(new SingleValueProperty<>(getId() + ".property.single_value.integer", 5));
        }
    }

    private static class Restrained extends Condition
    {
        private Restrained()
        {
            super("Restrained", "A restrained creature's speed becomes 0, and it can't benefit from any bonus to its speed.", "Attack rolls against the creature have advantage, and the creature's attack rolls have disadvantage.", "The creature has disadvantage on Dexterity saving throws.");
            properties = Arrays.asList(new SingleValueProperty<>(getId() + ".property.single_value.integer", 0), new SingleValueProperty<>(getId() + ".property.single_value.ability_score_type", AbilityScoreTypes.DEX));
        }
    }

    private static class Stunned extends Condition
    {
        private Stunned()
        {
            super("Stunned", "A stunned creature is incapacitated (see the condition), can't move, and can speak only falteringly.", "The creature automatically fails Strength and Dexterity saving throws.");
            properties = Arrays.asList(new SingleValueProperty<>(getId() + ".property.single_value.condition", INCAPACITATED), new ListProperty<>(getId() + ".property.list.ability_score_type", Arrays.asList(AbilityScoreTypes.STR, AbilityScoreTypes.DEX)));
        }
    }

    private static class Unconscious extends Condition
    {
        private Unconscious()
        {
            super("Condition", "An unconscious creature is incapacitated (see the condition), can't move or speak, and is unaware of its surroundings.", "The creature drops whatever it's holding and falls prone.", "The creature automatically fails Strength and Dexterity saving throws.", "Attack rolls against the creature have advantage.", "Any attack that hits the creature is a critical hit if the attacker is within 5 feet of the creature.");
            properties = Arrays.asList(new SingleValueProperty<>(getId() + ".property.single_value.condition", INCAPACITATED), new ListProperty<>(getId() + ".property.list.ability_score_type", Arrays.asList(AbilityScoreTypes.STR, AbilityScoreTypes.DEX)), new SingleValueProperty<>(getId() + ".property.single_value.integer", 5));
        }
    }
}
