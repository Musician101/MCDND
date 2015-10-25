package musician101.mcdnd.skill;

import musician101.mcdnd.abilityscore.CharacterAbilityScores;
import musician101.mcdnd.util.CustomMap;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class SkillCarrier
{
    private final Map<SkillType, Skill> skills;
    Skill acrobatics;
    Skill animalHandling;
    Skill arcana;
    Skill athletics;
    Skill deception;
    Skill history;
    Skill insight;
    Skill intimidation;
    Skill investigation;
    Skill medicine;
    Skill nature;
    Skill perception;
    Skill performance;
    Skill persuasion;
    Skill religion;
    Skill sleightOfHand;
    Skill stealth;
    Skill survival;

    public SkillCarrier(CharacterAbilityScores scores, List<SkillType> proficientSkills, List<SkillType> expertSkills)
    {
        skills = new CustomMap<SkillType, Skill>().add(SkillType.ACROBATICS, new Skill(SkillType.ACROBATICS, scores,
                proficientSkills, expertSkills)).add(SkillType.ANIMAL_HANDLING, new Skill(SkillType.ANIMAL_HANDLING,
                scores, proficientSkills, expertSkills)).add(SkillType.ARCANA, new Skill(SkillType.ARCANA, scores,
                proficientSkills, expertSkills)).add(SkillType.ATHLETICS, new Skill(SkillType.ATHLETICS, scores,
                proficientSkills, expertSkills)).add(SkillType.DECEPTION, new Skill(SkillType.DECEPTION, scores,
                proficientSkills, expertSkills)).add(SkillType.HISTORY, new Skill(SkillType.HISTORY, scores,
                proficientSkills, expertSkills)).add(SkillType.INSIGHT, new Skill(SkillType.INSIGHT, scores,
                proficientSkills, expertSkills)).add(SkillType.INTIMIDATION, new Skill(SkillType.INTIMIDATION, scores,
                proficientSkills, expertSkills)).add(SkillType.INVESTIGATION, new Skill(SkillType.INVESTIGATION, scores,
                proficientSkills, expertSkills)).add(SkillType.MEDICINE, new Skill(SkillType.MEDICINE, scores,
                proficientSkills, expertSkills)).add(SkillType.NATURE, new Skill(SkillType.NATURE, scores,
                proficientSkills, expertSkills)).add(SkillType.PERCEPTION, new Skill(SkillType.PERCEPTION, scores,
                proficientSkills, expertSkills)).add(SkillType.PERFORMANCE, new Skill(SkillType.PERFORMANCE, scores,
                proficientSkills, expertSkills)).add(SkillType.PERSUASION, new Skill(SkillType.PERSUASION, scores,
                proficientSkills, expertSkills)).add(SkillType.RELIGION, new Skill(SkillType.RELIGION, scores,
                proficientSkills, expertSkills)).add(SkillType.SLEIGHT_OF_HAND, new Skill(SkillType.SLEIGHT_OF_HAND,
                scores, proficientSkills, expertSkills)).add(SkillType.STEALTH, new Skill(SkillType.STEALTH, scores,
                proficientSkills, expertSkills)).add(SkillType.SURVIVAL, new Skill(SkillType.SURVIVAL, scores,
                proficientSkills, expertSkills));
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
