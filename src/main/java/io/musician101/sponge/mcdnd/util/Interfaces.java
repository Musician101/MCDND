package io.musician101.sponge.mcdnd.util;

import io.musician101.sponge.mcdnd.clazz.ProficiencyBonus;
import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.SkillProficiencyData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.skill.SkillType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Interfaces
{
    public interface AbilityScoreDCSave extends SingleValue<AbilityScoreType>
    {
        Optional<Integer> getDCSave(AbilityScoreData score, int... bonuses);
    }

    @FunctionalInterface
    public interface Buyable
    {
        Cost getCost();
    }

    @FunctionalInterface
    public interface DamageDealer
    {
        Damage getDamage();
    }

    @FunctionalInterface
    public interface Described
    {
        List<String> getDescription();
    }

    @FunctionalInterface
    public interface EffectsArea
    {
        /** Location parameter can refer to the spell's origin and/or center point */
        List<Location<World>> getArea(Direction direction, Location<World> location);
    }

    @FunctionalInterface
    public interface Identified
    {
        String getId();
    }

    @FunctionalInterface
    public interface HasProperties
    {
        DataContainer getProperties();
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
    }

    @FunctionalInterface
    public interface Named
    {
        String getName();
    }

    @FunctionalInterface
    public interface SingleValue<T>
    {
        T getValue();
    }

    public interface SkillDCSave extends SingleValue<SkillType>
    {
        Optional<Integer> getDCSave(AbilityScoreData scoreData, SkillProficiencyData skillData, ProficiencyBonus bonus);
    }

    @FunctionalInterface
    public interface Weighable
    {
        double getWeight();
    }
}
