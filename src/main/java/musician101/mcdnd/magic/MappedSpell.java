package musician101.mcdnd.magic;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScoreType;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;
import musician101.mcdnd.util.Interfaces.Listed;
import musician101.mcdnd.util.Interfaces.Mapped;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MappedSpell<K, V> extends Spell implements Mapped<K, V>
{
    final Map<K, V> map;

    public MappedSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, V> map, String... description)
    {
        super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
        this.map = map;
    }

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

    public static class MultipleSpellSlotSpell extends MappedSpell<SpellLevel, Integer>
    {
        public final SpellLevel startingLevel;

        public MultipleSpellSlotSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<SpellLevel, Integer> map, SpellLevel startingLevel, String... description)
        {
            super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration,
                    needsConcentration, map, description);
            this.startingLevel = startingLevel;
        }

        public SpellLevel getStartingLevel()
        {
            return startingLevel;
        }
    }

    public static class ScaleableDamageSpell<K> extends MappedSpell<K, Dice>
    {
        Damage damage;

        public ScaleableDamageSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, Dice> map, DamageType damageType, String... description)
        {
            super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
            List<K> list = new ArrayList<>();
            map.keySet().forEach(object -> list.add((K) object));
            this.damage = new Damage(damageType, map.get(list.get(1)));
        }

        public Damage getDamage()
        {
            return damage;
        }

        public void updateDamage(K level)
        {
            if (map.containsKey(level))
                damage = new Damage(damage.getDamageType(), map.get(level));
        }

        public static class ScaleableDamageAbilityScoreDCSaveSpell<K> extends ScaleableDamageSpell<K> implements AbilityScoreDCSave
        {
            AbilityScoreType scoreType;

            public ScaleableDamageAbilityScoreDCSaveSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, Dice> map, DamageType damageType, AbilityScoreType scoreType, String... description)
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

            public static class MultiDamageScaleableAbilityScoreDCSaveSpell<K> extends MappedSpell<K, Dice> implements AbilityScoreDCSave, Listed<DamageType>
            {
                AbilityScoreType scoreType;
                List<DamageType> list;

                public MultiDamageScaleableAbilityScoreDCSaveSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<K, Dice> map, List<DamageType> list, AbilityScoreType scoreType, String... description)
                {
                    super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
                    this.list = list;
                    this.scoreType = scoreType;
                }

                @Override
                public List<DamageType> getList()
                {
                    return list;
                }

                @Override
                public DamageType get(int index)
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

    public class BehaviorSpell extends MappedSpell<Integer, String>
    {
        public BehaviorSpell(String name, SpellType type, SpellLevel level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, Map<Integer, String> map, String... description)
        {
            super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, map, description);
        }
    }
}
