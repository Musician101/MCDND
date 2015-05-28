package musician101.mcdnd.skill;

import java.util.List;

import musician101.mcdnd.abilityscore.CharacterAbilityScores;

public class Skill
{
	private Skills skill;
	private boolean isExpert;
	private boolean isProficient;
	private int skillMod;
	
	public Skill(Skills skill, CharacterAbilityScores scores, List<Skills> proficientSkills, List<Skills> expertSkills)
	{
		this.skill = skill;
		this.isProficient = proficientSkills.contains(skill);
		this.isExpert = expertSkills.contains(skill);
		this.skillMod = calcSkillMod(scores);
	}
	
	public Skills getSkill()
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
			mod =+ scores.getProficiencyBonus();
		
		if (isExpert)
			mod =+ 2;
		
		return mod;
	}
}
