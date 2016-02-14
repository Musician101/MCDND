package musician101.mcdnd.magic.spelleffect;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.skill.Skill;
import musician101.mcdnd.skill.SkillTypes;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;
import musician101.mcdnd.util.Interfaces.DamageDealer;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.Mapped;
import musician101.mcdnd.util.Interfaces.Named;
import musician101.mcdnd.util.Interfaces.SkillDCSave;

import java.util.List;
import java.util.Map;

/** SpellEffects also need to be rewritten to use the new Identified interface and Property classes. */
public class SpellEffect implements Described, Named
{
    String name;
    String[] description;

    protected SpellEffect(){}

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

    public static class AbilityScoreDCSaveSpellEffect extends SpellEffect implements AbilityScoreDCSave
    {
        AbilityScoreType type;

        protected AbilityScoreDCSaveSpellEffect(){}

        @Override
        public AbilityScoreType getAbilityScoreType()
        {
            return type;
        }

        @Override
        public int getDCSave(AbilityScore score, int... bonuses)
        {
            if (type != score.getType())
                throw new IllegalArgumentException("Invalid AbilityScore type for DC saving throw.");

            int save = 8 + score.getMod();
            for (int bonus : bonuses)
                save = +bonus;

            return save;
        }
    }

    public static class DamageDealingSkillDCSaveSpellEffect extends SpellEffect implements DamageDealer, SkillDCSave
    {
        Damage damage;
        SkillTypes skillType;

        protected DamageDealingSkillDCSaveSpellEffect(){}

        @Override
        public Damage getDamage()
        {
            return damage;
        }

        @Override
        public SkillTypes getSkillSaveType()
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

    public static class DamageDealingMultiDamageTypeSpellEffect extends SpellEffect
    {
        Dice damageAmount;
        List<DamageType> damageTypes;

        protected DamageDealingMultiDamageTypeSpellEffect(){}

        public Dice getDamageAmount()
        {
            return damageAmount;
        }

        public List<DamageType> getDamageTypes()
        {
            return damageTypes;
        }
    }

    public static class MappedSpellEffect<K, V> extends SpellEffect implements Mapped<K, V>
    {
        Map<K, V> map;

        protected MappedSpellEffect(){}

        @Override
        public boolean containsKey(K key)
        {
            return map.containsKey(key);
        }

        @Override
        public Map<K, V> getMap()
        {
            return map;
        }

        @Override
        public V get(K key)
        {
            return map.get(key);
        }

        @Override
        public MappedSpellEffect<K, V> add(K key, V value)
        {
            map.put(key, value);
            return this;
        }
    }
}
