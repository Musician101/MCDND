package musician101.mcdnd.magic.spelleffect;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.skill.Skill;
import musician101.mcdnd.skill.SkillType;
import musician101.mcdnd.util.Interfaces.DamageDealer;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Named;
import musician101.mcdnd.util.Interfaces.SkillDCSave;

public class SpellEffect implements Described, Named
{
    String name;
    String[] description;

    public SpellEffect(String name, String... description)
    {
        this.name = name;
        this.description = description;
    }

    @Override
    public String[] getDescription()
    {
        return description;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public static class DamageDealingSkillDCSaveSpellEffect extends SpellEffect implements DamageDealer, SkillDCSave
    {
        Damage damage;
        SkillType skillType;

        public DamageDealingSkillDCSaveSpellEffect(String name, Damage damage, SkillType skillType, String... description)
        {
            super(name, description);
            this.damage = damage;
            this.skillType = skillType;
        }

        @Override
        public Damage getDamage()
        {
            return damage;
        }

        @Override
        public SkillType getSkillSaveType()
        {
            return skillType;
        }

        @Override
        public int getDCSave(Skill skill, int... bonuses)
        {
            int mod = skill.getSkillMod();
            for (int bonus : bonuses)
                mod =+ bonus;

            return 8 + mod;
        }
    }
}
