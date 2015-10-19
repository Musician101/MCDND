package musician101.mcdnd.skill;

import musician101.mcdnd.abilityscore.CharacterAbilityScores;
import musician101.mcdnd.util.CustomMap;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class SkillCarrier
{
    private final Map<Skills, Skill> skills;
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

    public SkillCarrier(CharacterAbilityScores scores, List<Skills> proficientSkills, List<Skills> expertSkills)
    {
        skills = new CustomMap<Skills, Skill>().add(Skills.ACROBATICS, new Skill(Skills.ACROBATICS, scores,
                proficientSkills, expertSkills)).add(Skills.ANIMAL_HANDLING, new Skill(Skills.ANIMAL_HANDLING,
                scores, proficientSkills, expertSkills)).add(Skills.ARCANA, new Skill(Skills.ARCANA, scores,
                proficientSkills, expertSkills)).add(Skills.ATHLETICS, new Skill(Skills.ATHLETICS, scores,
                proficientSkills, expertSkills)).add(Skills.DECEPTION, new Skill(Skills.DECEPTION, scores,
                proficientSkills, expertSkills)).add(Skills.HISTORY, new Skill(Skills.HISTORY, scores,
                proficientSkills, expertSkills)).add(Skills.INSIGHT, new Skill(Skills.INSIGHT, scores,
                proficientSkills, expertSkills)).add(Skills.INTIMIDATION, new Skill(Skills.INTIMIDATION, scores,
                proficientSkills, expertSkills)).add(Skills.INVESTIGATION, new Skill(Skills.INVESTIGATION, scores,
                proficientSkills, expertSkills)).add(Skills.MEDICINE, new Skill(Skills.MEDICINE, scores,
                proficientSkills, expertSkills)).add(Skills.NATURE, new Skill(Skills.NATURE, scores,
                proficientSkills, expertSkills)).add(Skills.PERCEPTION, new Skill(Skills.PERCEPTION, scores,
                proficientSkills, expertSkills)).add(Skills.PERFORMANCE, new Skill(Skills.PERFORMANCE, scores,
                proficientSkills, expertSkills)).add(Skills.PERSUASION, new Skill(Skills.PERSUASION, scores,
                proficientSkills, expertSkills)).add(Skills.RELIGION, new Skill(Skills.RELIGION, scores,
                proficientSkills, expertSkills)).add(Skills.SLEIGHT_OF_HAND, new Skill(Skills.SLEIGHT_OF_HAND,
                scores, proficientSkills, expertSkills)).add(Skills.STEALTH, new Skill(Skills.STEALTH, scores,
                proficientSkills, expertSkills)).add(Skills.SURVIVAL, new Skill(Skills.SURVIVAL, scores,
                proficientSkills, expertSkills));
    }

    public int getSkillMod(Skills skill)
    {
        return skills.get(skill).getSkillMod();
    }

    public void updateSkill(Skill... skills)
    {
        for (Skill skill : skills)
            this.skills.put(skill.getSkill(), skill);
    }

    public int rollSkill(Skills skill)
    {
        return new Random().nextInt(19) + 1 + getSkillMod(skill);
    }
}
