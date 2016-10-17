package io.musician101.mcdnd.sponge.data.type;

public class ActionTypes
{
    public static final ActionType ATTACK = new ActionType("Attack",
            "The most common action to take in combat is the Attack action, whether you are swinging a sword, firing an arrow from a bow, or brawling with your fists.",
            "With this action, you make one melee or ranged attack.",
            "Certain features, such as the Extra Attack feature of the fighter, allow you to make more than one attack with this action.");
    public static final ActionType CAST_A_SPELL = new ActionType("Cast a Spell",
            "Spellcasters such as wizards and clerics, as well as many monsters, have access to spells and can use them to great effect in combat. Each spell has a casting time, which specifies whether the caster must us an action, a reaction, minutes, or even hours to cast the spell. Casting a spell is, therefore, not necessarily an action. Most spells do have a casting time of 1 action, so a spellcaster often uses his or her action in combat to cast such a spell.");
    public static final ActionType DASH = new ActionType("Dash",
            "When you take the Dash action, you gain extra movement for the current turn. The increase your speed, after applying any modifiers. With a speed of 30 feet, for example, you can move up to 60 feet on your turn if you dash.",
            "Any increase or decrease to your speed changes this additional movement by the same amount. If your speed of 30 feet is reduced to 15 feet, for instance, you can move up to 30 feet this turn if you dash.");
    public static final ActionType DISENGAGE = new ActionType("Disengage",
            "If you take the Disengage action, your movement doesn't provoke opportunity attacks for the rest of the turn.");
    public static final ActionType DODGE = new ActionType("Dodge",
            "When you take the Dodge action, you focus entirely on avoiding attacks. Until the start of your next turn, any attack roll made against you has disadvantage if you can see the attacker, and you make Dexterity saving throws with advantage. You lose this benefit if you are incapacitated or if your speed drops to 0.");
    public static final ActionType HELP = new ActionType("Help",
            "You can lend your aid to another creature in the completion of a task. When you take the Help action, the creature you aid gains advantage on the next ability check it makes to perform the task you are helping with, provided that it makes the check before the start of your next turn.",
            "Alternatively, you can aid a friendly creature in attacking a creature within 5 feet of you. You feint, distract the target, or in some other way team up to make your ally's attack more effective. If your ally attacks the target before your next turn, the first attack roll is made with advantage.");
    public static final ActionType HIDE = new ActionType("Hide",
            "When you take the Hide action, you make a Dexterity (Stealth) check in an attempt to hide. If you succeed, you gain certain benefits.");
    public static final ActionType READY = new ActionType("Ready",
            "Sometimes you want to get the jump on a foe or wait for a particular circumstance before you act. To do so, you can take the Ready action on your turn so that you can act later in the round using your reaction.",
            "First, you decide what perceivable circumstance will trigger your reaction. Then, you choose the action you will take in response to that trigger, or you choose to move up to your speed in response to it.",
            "When the trigger occurs, you can either take your reaction right after the trigger finishes or ignore the trigger. Remember that you can take only one reaction per round.",
            "When you ready a spell, you cast it as normal but hold its energy, which you release with your reaction when the trigger occurs. To be readied, a spell must have a casting time of 1 action, and holding onto the spell's magic requires concentration. If your concentration is broken, the spell dissipates without taking effect.");
    public static final ActionType SEARCH = new ActionType("Search",
            "When you take the Search action, you devote your attention to finding something. Depending on the nature of your search, the DM might have you make a Wisdom (Perception) check or an Intelligence (Investigation) check.");
    public static final ActionType USE_AN_OBJECT = new ActionType("Use an Object",
            "You normally interact with an object while doing something else, such as when you draw a sword as part of an attack. When an object requires your action for its use, you take the Use an Object action. This action is also useful when you want to interact with more than one object on your turn.");

    private ActionTypes()
    {

    }
}
