package musician101.mcdnd.util;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScoreType;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.property.Property;
import musician101.mcdnd.skill.Skill;
import musician101.mcdnd.skill.SkillType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Map;

public class Interfaces
{
    public interface AbilityScoreDCSave
    {
        AbilityScoreType getAbilityScoreType();

        int getDCSave(AbilityScore score, int... bonuses);
    }

    public interface Buyable
    {
        Cost getCost();
    }

    public interface DamageDealer
    {
        Damage getDamage();
    }

    public interface Described
    {
        String[] getDescription();
    }

    public interface EffectsArea
    {
        /** Needs to consider diagonals and the choice to include point of origin */
        @Deprecated
        List<Location<World>> getArea(Entity entity);
    }

    public interface Identified
    {
        String getId();
    }

    public interface HasProperties
    {
        List<Property> getProperties();
    }

    public interface Listed<T>
    {
        List<T> getList();

        T get(int index);
    }

    public interface Mapped<K, V>
    {
        boolean containsKey(K key);

        Map<K, V> getMap();

        V get(K key);

        Mapped<K, V> add(K key, V value);
    }

    public interface Named
    {
        String getName();
    }

    public interface SingleValue<T>
    {
        T getValue();
    }

    public interface SkillDCSave
    {
        int getDCSave(Skill skill, int... bonuses);

        SkillType getSkillSaveType();
    }

    public interface Weighable
    {
        double getWeight();
    }
}
