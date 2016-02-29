package musician101.mcdnd.property;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.SpellLevel;
import musician101.mcdnd.util.Interfaces.DamageDealer;
import musician101.mcdnd.util.Interfaces.SingleValue;

import java.util.Map;

public class ScalableDamageProperty<K> extends MapProperty<K, Dice> implements SingleValue<DamageType>
{
    DamageType damageType;

    protected ScalableDamageProperty(String idPrefix, String keyType, DamageType damageType, Map<K, Dice> map)
    {
        super(idPrefix + ".property.scalable_damage." + keyType, map);
        this.damageType = damageType;
    }

    public DamageType getValue()
    {
        return damageType;
    }

    public Damage getDamage(K key)
    {
        return new Damage(damageType, map.get(key));
    }

    public static class IntegerScalableDamageProperty extends ScalableDamageProperty<Integer>
    {
        public IntegerScalableDamageProperty(String idPrefix, DamageType damageType, Map<Integer, Dice> map)
        {
            super(idPrefix, "integer", damageType, map);
        }
    }

    public static class SpellLevelScalableDamageProperty extends ScalableDamageProperty<SpellLevel>
    {
        public SpellLevelScalableDamageProperty(String idPrefix, DamageType damageType, Map<SpellLevel, Dice> map)
        {
            super(idPrefix, "spell-level", damageType, map);
        }
    }
}
