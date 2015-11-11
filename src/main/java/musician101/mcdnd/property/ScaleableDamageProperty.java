package musician101.mcdnd.property;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;

import java.util.Map;

public class ScaleableDamageProperty<K> extends MappedProperty<K, Dice>
{
    DamageType damageType;

    public ScaleableDamageProperty(String id, DamageType damageType, Map<K, Dice> map)
    {
        super(id, map);
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
