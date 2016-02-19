package musician101.mcdnd.property;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;

import java.util.Map;

public class ScalableDamageProperty<K> extends MapProperty<K, Dice>
{
    DamageType damageType;

    public ScalableDamageProperty(String idPrefix, DamageType damageType, Map<K, Dice> map)
    {
        super(idPrefix + ".property.scalable_damage", map);
        this.damageType = damageType;
    }

    public DamageType getDamageType()
    {
        return damageType;
    }

    public Damage getDamage(K key)
    {
        return new Damage(damageType, map.get(key));
    }
}
