package musician101.mcdnd.skill;

import musician101.mcdnd.abilityscore.CharacterAbilityScores;

import java.util.List;

public class Skill
{
    private final SkillType skill;
    private final boolean isExpert;
    private final boolean isProficient;
    private final int skillMod;

    public Skill(SkillType skill, CharacterAbilityScores scores, List<SkillType> proficientSkills, List<SkillType> expertSkills)
    {
        this.skill = skill;
        this.isProficient = proficientSkills.contains(skill);
        this.isExpert = expertSkills.contains(skill);
        this.skillMod = calcSkillMod(scores);
    }

    public SkillType getSkill()
    {
        return skill;
    }

    public boolean isExpert()
    {
        return isExpert;
    }

    public boolean isProficient()
    {
        return isProficient;
    }

    public String getString()
    {
        return skill.getName();
    }

    public int getSkillMod()
    {
        return skillMod;
    }

    private int calcSkillMod(CharacterAbilityScores scores)
    {
        int mod = skillMod;
        if (isProficient)
            mod = +scores.getProficiencyBonus();

        if (isExpert)
            mod = +2;

        return mod;
    }
}
