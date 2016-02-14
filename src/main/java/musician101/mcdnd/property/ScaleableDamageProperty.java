package musician101.mcdnd.property;

import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageTypes;
import musician101.mcdnd.dice.Dice;

import java.util.Map;

public class ScaleableDamageProperty<K> extends MappedProperty<K, Dice>
{
    DamageTypes damageType;

    public ScaleableDamageProperty(String id, DamageTypes damageType, Map<K, Dice> map)
    {
        super(id, map);
        this.damageType = damageType;
    }

    public DamageTypes getDamageType()
    {
        return damageType;
    }

    public Damage getDamage(K key)
    {
        return new Damage(damageType, map.get(key));
    }
}
