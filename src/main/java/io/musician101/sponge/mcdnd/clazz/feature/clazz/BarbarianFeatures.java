package io.musician101.sponge.mcdnd.clazz.feature.clazz;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.EquipmentChoices;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.ListChoice;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.MultipleChoice;
import io.musician101.sponge.mcdnd.clazz.feature.equipment.SingleChoice;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.PrimalPaths;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.dice.HitDice;
import io.musician101.sponge.mcdnd.equipment.Equipment;

import io.musician101.sponge.mcdnd.equipment.pack.Packs;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import io.musician101.sponge.mcdnd.property.ProficienciesProperty;
import io.musician101.sponge.mcdnd.property.RageProperty;
import io.musician101.sponge.mcdnd.property.UnarmoredDefenseProperty;
import io.musician101.sponge.mcdnd.property.HitPointsProperty;

import java.util.ArrayList;
import java.util.Arrays;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;

public class BarbarianFeatures
{
    public static final Feature HP = builder().name("Hit Points")
            .addProperty(MCDNDKeys.HP_PROPERTY, new HitPointsProperty(new HitDice(12), "Barbarian"))
            .build();
    public static final Feature PROFICIENCIES = builder().name("Proficiencies")
            .addProperty(MCDNDKeys.PROFICIENCIES, new ProficienciesProperty(Arrays.asList(MCDNDArmorTypes.LIGHT, MCDNDArmorTypes.MEDIUM, MCDNDArmorTypes.SHIELD), "Light armor, medium armor, shields", Weapons.getAll(), "Simple weapons, martial weapons", new ArrayList<>(), "None", Arrays.asList(AbilityScoreTypes.STRENGTH, AbilityScoreTypes.CONSTITUTION), "Strength, Constitution", Arrays.asList(SkillTypes.ANIMAL_HANDLING, SkillTypes.ATHLETICS, SkillTypes.INTIMIDATION, SkillTypes.NATURE, SkillTypes.PERCEPTION, SkillTypes.SURVIVAL), 2, "Choose two from Animal Handling, Athletics, Intimidation, Nature, Perception, and Survival")).build();
    public static final Feature EQUIPMENT = builder().name("Equipment")
            .addProperty(MCDNDKeys.EQUIPMENT_CHOICES_LIST, Arrays.asList(new EquipmentChoices("(a) a greataxe or (b) any martial melee weapon", new SingleChoice(Weapons.GREATAXE), new ListChoice(Weapons.getMartialMeleeWeapons())), new EquipmentChoices("(a) two handaxes or (b) any simple weapon", new SingleChoice(Weapons.HANDAXE, 2), new ListChoice(Weapons.getSimpleWeapons())), new EquipmentChoices("An explorer's pack and four javelins.", new MultipleChoice(ImmutableMap.<Equipment, Integer>builder().put(Packs.EXPLORERS_PACK, 1).put(Weapons.JAVELIN, 4).build())))).build();
    public static final Feature RAGE = builder().name("Rage")
            .addLineToDescription("In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action.")
            .addLineToDescription("While raging, you gain the following benefits if you aren't wearing heavy armor:")
            .addLineToDescription("- You have advantage on Strength checks and Strength saving throws.")
            .addLineToDescription("- When you make a melee weapon attack using Strength, you gain a bonus to the damage roll that increases as you gain levels as a barbarian.")
            .addLineToDescription("- You have resistance to bludgeoning, piercing, and slashing damage.")
            .addLineToDescription("If you are able to cast spells, you can't cast them or concentrate on them while raging.")
            .addLineToDescription("Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you haven't attacked a hostile creature since your last turn or taken damage since then. You can also end your rage on your turn as a bonus action.")
            .addLineToDescription("Once you have raged the number of times shown for your barbarian level, you must finish a long rest before you can rage again.")
            .addProperty(MCDNDKeys.RAGE_PROPERTY, new RageProperty()).build();
    public static final Feature UNARMORED_DEFENSE = builder().name("Unarmored Defense")
            .description("While you are not wearing any armor, your Armor Class equals 10 your Dexterity modifier your Constitution modifier. You can use a shield and still gain this benefit.")
            .addProperty(MCDNDKeys.UNARMORED_DEFENSE_PROPERTY, new UnarmoredDefenseProperty()).build();
    public static final Feature RECKLESS_ATTACK = builder().name("Reckless Attack").levelRequirement(2)
            .description("Starting at 2nd level, you can throw aside all concern for defense to attack with fierce desperation. When you make your first attack on your turn, you can decide to attack recklessly. Doing so gives you advantage on melee weapon attack rolls using Strength during this turn, but attack rolls against you have advantage until your next turn.")
            .build();
    public static final Feature DANGER_SENSE = builder().name("Danger Sense").levelRequirement(2)
            .addLineToDescription("At 2nd level, you gain an uncanny sense of when things nearby aren't as they should be, giving you an edge when you dodge away from danger.")
            .addLineToDescription("You have advantage on Dexterity saving throws against effects that you can see, such as traps and spells. To gain this benefit, you can't be blinded, deafened, or incapacitated.")
            .build();
    public static final Feature PRIMAL_PATH = builder().name("Primal Path").levelRequirement(3)
            .description("At 3rd level, you choose a path that shapes the nature of your rage. Choose the path of the Berserker or the Path of the Totem Warrior, both detailed at the end of the class description. Your choice grants you features at 3rd level and again at 6th, 10th, and 14th levels.")
            .addProperty(MCDNDKeys.PRIMAL_PATHS, Arrays.asList(PrimalPaths.BERSERKER, PrimalPaths.TOTEM_WARRIOR)).build();
    public static final Feature EXTRA_ATTACK = builder().name("Extra Attack").levelRequirement(5)
            .description("Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.")
            .build();
    public static final Feature FAST_MOVEMENT = builder().name("Fast Movement").levelRequirement(5)
            .description("Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.")
            .build();
    public static final Feature FERAL_INSTINCT = builder().name("Feral Instinct").levelRequirement(7)
            .addLineToDescription("By 7th level, your instincts are so honed that you have advantage on initiative rolls.")
            .addLineToDescription("Additionally, if you are surprised at the beginning of combat and aren't incapacitated, you can act normally on your first turn, but only if you enter your rage before doing anything else on that turn.")
            .build();
    public static final Feature BRUTAL_CRITICAL = builder().name("Brutal Critical").levelRequirement(9)
            .addLineToDescription("Beginning at 9th level, you can roll one additional weapon damage die when determining the extra damage for a critical hit with a melee attack.")
            .addLineToDescription("This increases to two additional dice at 13th level and three additional dice at 17th level.")
            .addProperty(MCDNDKeys.BRUTAL_CRITICAL_MAP, ImmutableMap.<Integer, Integer>builder().put(9, 1).put(13, 2).put(17, 3).build()).build();
    public static final Feature RELENTLESS_RAGE = builder().name("Relentless Rage").levelRequirement(11)
            .addLineToDescription("Starting at 11th level, your rage can keep you fighting despite grievous wounds. If you drop to 0 hit points while you're raging and don't die outright, you can make a DC 10 Constitution saving throw. If you succeed, you drop to 1 hit point instead.")
            .addLineToDescription("Each time you use this feature after the first, the DC increases by 5. When you finish a short or long rest, the DC resets to 10.")
            .build();
    public static final Feature PERSISTENT_RAGE = builder().name("Persistent Rage").levelRequirement(15)
            .description("Beginning at 15th level, your rage is so fierce that it ends early only if you fall unconscious or if you choose to end it.")
            .build();
    public static final Feature INDOMITABLE_MIGHT = builder().name("Indomitable Might").levelRequirement(19)
            .description("Beginning at 18th level, if your total for a Strength check is less than your Strength score, you use that score in place of the total.")
            .build();
    public static final Feature PRIMAL_CHAMPION = builder().name("Primal Champion").levelRequirement(20)
            .description("At 20th level, you embody the power of the wilds. Your Strength and Constitution scores increase by 4. Your maximum for those scores is now 24.")
            .build();

    private BarbarianFeatures()
    {

    }
}
