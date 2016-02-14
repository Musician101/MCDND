package musician101.mcdnd.skill;

import musician101.mcdnd.abilityscore.CharacterAbilityScores;
import musician101.mcdnd.util.CustomMap;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class SkillCarrier
{
    private final Map<SkillType, Skill> skills;

    public SkillCarrier(CharacterAbilityScores scores, List<SkillType> proficientSkills, List<SkillType> expertSkills)
    {
        skills = new CustomMap<SkillType, Skill>().add(SkillTypes.ACROBATICS, new Skill(SkillTypes.ACROBATICS, scores, proficientSkills, expertSkills)).add(SkillTypes.ANIMAL_HANDLING, new Skill(SkillTypes.ANIMAL_HANDLING, scores, proficientSkills, expertSkills)).add(SkillTypes.ARCANA, new Skill(SkillTypes.ARCANA, scores, proficientSkills, expertSkills)).add(SkillTypes.ATHLETICS, new Skill(SkillTypes.ATHLETICS, scores, proficientSkills, expertSkills)).add(SkillTypes.DECEPTION, new Skill(SkillTypes.DECEPTION, scores, proficientSkills, expertSkills)).add(SkillTypes.HISTORY, new Skill(SkillTypes.HISTORY, scores, proficientSkills, expertSkills)).add(SkillTypes.INSIGHT, new Skill(SkillTypes.INSIGHT, scores, proficientSkills, expertSkills)).add(SkillTypes.INTIMIDATION, new Skill(SkillTypes.INTIMIDATION, scores, proficientSkills, expertSkills)).add(SkillTypes.INVESTIGATION, new Skill(SkillTypes.INVESTIGATION, scores, proficientSkills, expertSkills)).add(SkillTypes.MEDICINE, new Skill(SkillTypes.MEDICINE, scores, proficientSkills, expertSkills)).add(SkillTypes.NATURE, new Skill(SkillTypes.NATURE, scores, proficientSkills, expertSkills)).add(SkillTypes.PERCEPTION, new Skill(SkillTypes.PERCEPTION, scores, proficientSkills, expertSkills)).add(SkillTypes.PERFORMANCE, new Skill(SkillTypes.PERFORMANCE, scores, proficientSkills, expertSkills)).add(SkillTypes.PERSUASION, new Skill(SkillTypes.PERSUASION, scores, proficientSkills, expertSkills)).add(SkillTypes.RELIGION, new Skill(SkillTypes.RELIGION, scores, proficientSkills, expertSkills)).add(SkillTypes.SLEIGHT_OF_HAND, new Skill(SkillTypes.SLEIGHT_OF_HAND, scores, proficientSkills, expertSkills)).add(SkillTypes.STEALTH, new Skill(SkillTypes.STEALTH, scores, proficientSkills, expertSkills)).add(SkillTypes.SURVIVAL, new Skill(SkillTypes.SURVIVAL, scores, proficientSkills, expertSkills));
    }

    public int getSkillMod(SkillType skill)
    {
        return skills.get(skill).getSkillMod();
    }

    public void updateSkill(Skill... skills)
    {
        for (Skill skill : skills)
            this.skills.put(skill.getSkill(), skill);
    }

    public int rollSkill(SkillType skill)
    {
        return new Random().nextInt(19) + 1 + getSkillMod(skill);
    }
}
