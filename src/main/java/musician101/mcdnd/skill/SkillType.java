package musician101.mcdnd.skill;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScoreType;

public enum SkillType
{
    ACROBATICS("Acrobatics", AbilityScoreType.DEX),
    ANIMAL_HANDLING("Animal Handling", AbilityScoreType.WIS),
    ARCANA("Arcana", AbilityScoreType.INT),
    ATHLETICS("Athletics", AbilityScoreType.STR),
    DECEPTION("Deception", AbilityScoreType.CHA),
    HISTORY("History", AbilityScoreType.INT),
    INSIGHT("Insight", AbilityScoreType.WIS),
    INTIMIDATION("Intimidation", AbilityScoreType.STR),
    INVESTIGATION("Investigation", AbilityScoreType.INT),
    MEDICINE("Medicine", AbilityScoreType.WIS),
    NATURE("Nature", AbilityScoreType.STR),
    PERCEPTION("Perception", AbilityScoreType.WIS),
    PERFORMANCE("Performance", AbilityScoreType.CHA),
    PERSUASION("Persuasion", AbilityScoreType.CHA),
    RELIGION("Religion", AbilityScoreType.INT),
    SLEIGHT_OF_HAND("Sleight of Hand", AbilityScoreType.DEX),
    STEALTH("Stealth", AbilityScoreType.DEX),
    SURVIVAL("Survival", AbilityScoreType.WIS);

    final AbilityScoreType type;
    final String name;

    SkillType(String name, AbilityScoreType type)
    {
        this.name = name;
        this.type = type;
    }

    public AbilityScoreType getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }
}
