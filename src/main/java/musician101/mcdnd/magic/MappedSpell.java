package musician101.mcdnd.magic;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScoreType;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageTypes;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;
import musician101.mcdnd.util.Interfaces.Listed;
import musician101.mcdnd.util.Interfaces.Mapped;

import java.util.List;
import java.util.Map;

@Deprecated
public class MappedSpell<K, V> extends Spell implements Mapped<K, V>
{
    protected Map<K, V> map;

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

    public static class ScaleableDamageSpell<K> extends MappedSpell<K, Dice>
    {
        DamageTypes damageType;

        public DamageTypes getDamageType()
        {
            return damageType;
        }

        public Damage getDamage(K key)
        {
            return new Damage(damageType, map.get(key));
        }

        @Deprecated
        public static class ScaleableDamageAbilityScoreDCSaveSpell<K> extends ScaleableDamageSpell<K> implements AbilityScoreDCSave
        {
            AbilityScoreType scoreType;

            public ScaleableDamageAbilityScoreDCSaveSpell(String name, SpellTypes type, SpellLevels level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, Dice> map, DamageTypes damageType, AbilityScoreType scoreType, String... description)
            {
                super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, damageType, description);
                this.scoreType = scoreType;
            }

            @Override
            public AbilityScoreType getAbilitySaveType()
            {
                return scoreType;
            }

            @Override
            public int getDCSave(AbilityScore score, int... bonuses)
            {
                int mod = score.getMod();
                for (int bonus : bonuses)
                    mod =+ bonus;

                return 8 + mod;
            }

            @Deprecated
            public static class MultiDamageScaleableAbilityScoreDCSaveSpell<K> extends MappedSpell<K, Dice> implements AbilityScoreDCSave, Listed<DamageTypes>
            {
                AbilityScoreType scoreType;
                List<DamageTypes> list;

                public MultiDamageScaleableAbilityScoreDCSaveSpell(String name, SpellTypes type, SpellLevels level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, Dice> map, List<DamageTypes> list, AbilityScoreType scoreType, String... description)
                {
                    super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
                    this.list = list;
                    this.scoreType = scoreType;
                }

                @Override
                public List<DamageTypes> getList()
                {
                    return list;
                }

                @Override
                public DamageTypes get(int index)
                {
                    return list.get(index);
                }

                @Override
                public AbilityScoreType getAbilitySaveType()
                {
                    return scoreType;
                }

                @Override
                public int getDCSave(AbilityScore score, int... bonuses)
                {
                    int mod = score.getMod();
                    for (int bonus : bonuses)
                        mod =+ bonus;

                    return 8 + mod;
                }
            }
        }
    }

    @Deprecated
    public class BehaviorSpell extends MappedSpell<Integer, String>
    {
        public BehaviorSpell(String name, SpellTypes type, SpellLevels level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<Integer, String> map, String... description)
        {
            super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
        }
    }
}
