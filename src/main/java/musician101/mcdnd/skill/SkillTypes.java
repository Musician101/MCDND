package musician101.mcdnd.skill;

import musician101.mcdnd.abilityscore.AbilityScoreTypes;

import java.util.Arrays;
import java.util.List;

public class SkillTypes
{
    public static final SkillType ACROBATICS = new SkillType("Acrobatics", AbilityScoreTypes.DEX);
    public static final SkillType ANIMAL_HANDLING = new SkillType("Animal Handling", AbilityScoreTypes.WIS);
    public static final SkillType ARCANA = new SkillType("Arcana", AbilityScoreTypes.INT);
    public static final SkillType ATHLETICS = new SkillType("Athletics", AbilityScoreTypes.STR);
    public static final SkillType DECEPTION = new SkillType("Deception", AbilityScoreTypes.CHA);
    public static final SkillType HISTORY = new SkillType("History", AbilityScoreTypes.INT);
    public static final SkillType INSIGHT = new SkillType("Insight", AbilityScoreTypes.WIS);
    public static final SkillType INTIMIDATION = new SkillType("Intimidation", AbilityScoreTypes.STR);
    public static final SkillType INVESTIGATION = new SkillType("Investigation", AbilityScoreTypes.INT);
    public static final SkillType MEDICINE = new SkillType("Medicine", AbilityScoreTypes.WIS);
    public static final SkillType NATURE = new SkillType("Nature", AbilityScoreTypes.STR);
    public static final SkillType PERCEPTION = new SkillType("Perception", AbilityScoreTypes.WIS);
    public static final SkillType PERFORMANCE = new SkillType("Performance", AbilityScoreTypes.CHA);
    public static final SkillType PERSUASION = new SkillType("Persuasion", AbilityScoreTypes.CHA);
    public static final SkillType RELIGION = new SkillType("Religion", AbilityScoreTypes.INT);
    public static final SkillType SLEIGHT_OF_HAND = new SkillType("Sleight of Hand", AbilityScoreTypes.DEX);
    public static final SkillType STEALTH = new SkillType("Stealth", AbilityScoreTypes.DEX);
    public static final SkillType SURVIVAL = new SkillType("Survival", AbilityScoreTypes.WIS);
    public static final List<SkillType> ALL = Arrays.asList(ACROBATICS, ANIMAL_HANDLING, ARCANA, ATHLETICS, DECEPTION, HISTORY, INSIGHT, INTIMIDATION, INVESTIGATION, MEDICINE, NATURE, PERCEPTION, PERFORMANCE, PERSUASION, RELIGION, SLEIGHT_OF_HAND, STEALTH, SURVIVAL);
}
