package musician101.mcdnd.property;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.skill.Skill;
import musician101.mcdnd.skill.SkillType;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;
import musician101.mcdnd.util.Interfaces.SingleValue;
import musician101.mcdnd.util.Interfaces.SkillDCSave;

public class SingleValueProperty<T> extends Property implements SingleValue<T>
{
    T value;

    public SingleValueProperty(String id, T value)
    {
        super(id);
        this.value = value;
    }

    @Override
    public T getValue()
    {
        return value;
    }

    public static class DamageTypeProperty extends SingleValueProperty<DamageType>
    {
        public DamageTypeProperty(String idPrefix, DamageType damageType)
        {
            super(idPrefix + ".property.damage_type", damageType);
        }
    }

    public static class AbilityScoreDCSaveProperty extends Property implements AbilityScoreDCSave
    {
        AbilityScoreType abilityScoreType;

        public AbilityScoreDCSaveProperty(String idPrefix, AbilityScoreType abilityScoreType)
        {
            super(idPrefix + ".property.ability_saving_throw");
            this.abilityScoreType = abilityScoreType;
        }

        @Override
        public int getDCSave(AbilityScore score, int... bonuses)
        {
            if (score.getType() != getValue())
                throw new IllegalArgumentException("Invalid AbilityScore type for DC saving throw.");

            int save = 8 + score.getMod();
            for (int bonus : bonuses)
                save =+ bonus;

            return save;
        }

        @Override
        public AbilityScoreType getValue()
        {
            return abilityScoreType;
        }
    }

    public static class SkillDCSaveProperty extends Property implements SkillDCSave
    {
        SkillType skillType;

        public SkillDCSaveProperty(String idPrefix, SkillType skillType)
        {
            super(idPrefix + ".property.skill_saving_throw");
            this.skillType = skillType;
        }

        @Override
        public int getDCSave(Skill skill, int... bonuses)
        {
            if (skill.getType() != getValue())
                throw new IllegalArgumentException("Invalid AbilityScore type for DC saving throw.");

            int save = 8 + skill.getMod();
            for (int bonus : bonuses)
                save =+ bonus;

            return save;
        }

        @Override
        public SkillType getValue()
        {
            return skillType;
        }
    }
}
