package musician101.mcdnd.property;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.util.Interfaces.AbilityScoreDCSave;
import musician101.mcdnd.util.Interfaces.SingleValue;

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

    public static class SavingThrowProperty extends SingleValueProperty<AbilityScoreType> implements AbilityScoreDCSave
    {
        public SavingThrowProperty(String idPrefix, AbilityScoreType abilityScoreType)
        {
            super(idPrefix + ".property.saving_throw", abilityScoreType);
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
    }
}
