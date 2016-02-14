package musician101.mcdnd.magic;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;
import musician101.mcdnd.util.Interfaces.DamageDealer;

public class AbilityScoreDCSaveSpell extends Spell implements AbilityScoreDCSave
{
    private final AbilityScoreType type;

    public AbilityScoreDCSaveSpell(String name, SpellTypes type, SpellLevels level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, AbilityScoreType scoreType, String... description)
    {
        //TODO need to change super() to match Spell class
        super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
        this.type = scoreType;
    }

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

    public static class DamageDealingAbilityScoreDCSaveSpell extends AbilityScoreDCSaveSpell implements DamageDealer
    {
        Damage damage;

        public DamageDealingAbilityScoreDCSaveSpell(String name, SpellTypes type, SpellLevels level, double castingTime, int range, boolean isVerbal, boolean isSomatic, String materials, int duration, boolean needsConcentration, AbilityScoreType scoreType, Damage damage, String... description)
        {
            super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, scoreType, description);
            this.damage = damage;
        }

        @Override
        public Damage getDamage()
        {
            return damage;
        }
    }
}
