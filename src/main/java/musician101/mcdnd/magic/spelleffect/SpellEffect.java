package musician101.mcdnd.magic.spelleffect;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.property.Property;
import musician101.mcdnd.skill.Skill;
import musician101.mcdnd.skill.SkillType;
import musician101.mcdnd.skill.SkillTypes;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;
import musician101.mcdnd.util.Interfaces.DamageDealer;
import musician101.mcdnd.util.Interfaces.Described;
import musician101.mcdnd.util.Interfaces.HasProperties;
import musician101.mcdnd.util.Interfaces.Identified;
import musician101.mcdnd.util.Interfaces.Mapped;
import musician101.mcdnd.util.Interfaces.Named;
import musician101.mcdnd.util.Interfaces.SingleValue;
import musician101.mcdnd.util.Interfaces.SkillDCSave;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** SpellEffects also need to be rewritten to use the new Identified interface and Property classes. */
public class SpellEffect implements Described, HasProperties, Identified, Named
{
    List<Property> properties = new ArrayList<>();
    String id;
    String name;
    String[] description;

    protected SpellEffect(String id, String name, String... description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String[] getDescription()
    {
        return description;
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public List<Property> getProperties()
    {
        return properties;
    }

    @Deprecated
    public static class AbilityScoreDCSaveSpellEffect extends SpellEffect implements AbilityScoreDCSave
    {
        AbilityScoreType type;

        public AbilityScoreDCSaveSpellEffect(String id, String name, AbilityScoreType type, String... description)
        {
            super(id, name, description);
            this.type = type;
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

        @Override
        public AbilityScoreType getValue()
        {
            return type;
        }
    }

    @Deprecated
    public static class DamageDealingSkillDCSaveSpellEffect extends SpellEffect implements DamageDealer, SkillDCSave
    {
        Damage damage;
        SkillType skillType;

        public DamageDealingSkillDCSaveSpellEffect(String id, String name, String... description)
        {
            super(id, name, description);
        }

        @Override
        public Damage getDamage()
        {
            return damage;
        }

        @Override
        public SkillType getValue()
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

    @Deprecated
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

    @Deprecated
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
