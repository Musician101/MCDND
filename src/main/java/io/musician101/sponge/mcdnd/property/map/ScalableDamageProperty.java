package io.musician101.sponge.mcdnd.property.map;

import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageType;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevel;
import io.musician101.sponge.mcdnd.util.Interfaces.SingleValue;

import java.util.Map;

public class ScalableDamageProperty<K> extends MappedProperty<K, Dice> implements SingleValue<MCDNDDamageType>
{
    MCDNDDamageType damageType;

    protected ScalableDamageProperty(String idPrefix, String keyType, MCDNDDamageType damageType, Map<K, Dice> map)
    {
        super(idPrefix + ".property.scalable_damage." + keyType, map);
        this.damageType = damageType;
    }

    public MCDNDDamageType getValue()
    {
        return damageType;
    }

    public Damage getDamage(K key)
    {
        return new Damage(damageType, map.get(key));
    }

    public static class IntegerScalableDamageProperty extends ScalableDamageProperty<Integer>
    {
        public IntegerScalableDamageProperty(String idPrefix, MCDNDDamageType damageType, Map<Integer, Dice> map)
        {
            super(idPrefix, "integer", damageType, map);
        }
    }

    public static class SpellLevelScalableDamageProperty extends ScalableDamageProperty<SpellLevel>
    {
        public SpellLevelScalableDamageProperty(String idPrefix, MCDNDDamageType damageType, Map<SpellLevel, Dice> map)
        {
            super(idPrefix, "spell-level", damageType, map);
        }
    }
}
