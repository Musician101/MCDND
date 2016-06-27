package io.musician101.sponge.mcdnd.magic;

import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.combat.DamageType;
import io.musician101.sponge.mcdnd.combat.DamageTypes;
import io.musician101.sponge.mcdnd.data.type.spell.SpellLevels;
import io.musician101.sponge.mcdnd.data.type.spell.SpellTypes;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.magic.Shape.Cone;
import io.musician101.sponge.mcdnd.magic.Shape.Line;
import io.musician101.sponge.mcdnd.util.Interfaces.AbilityScoreDCSave;
import io.musician101.sponge.mcdnd.util.Interfaces.Mapped;

import java.util.HashMap;
import java.util.Map;

public abstract class BreathWeapon extends Spell implements AbilityScoreDCSave, Mapped<Integer, Damage>
{
    private final AbilityScoreType abilityScoreType;
    private final Map<Integer, Damage> damageMap = new HashMap<>();
    private final Shape shape;

    /** This will be rewritten to the new Spell format once all of the other spells are finished */
    protected BreathWeapon(DamageType damageType, AbilityScoreType abilityScoreType, Shape shape)
    {
        super("breath_weapon", "Breath Weapon", "You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation", "When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at the 6th level, 4d6 at 11th level, and 5d6 at 16th level.", "After you use your breath weapon, you can't use it again until you complete a short or long rest.");
        spellType = SpellTypes.EVOCATION;
        spellLevel = SpellLevels.CANTRIP;
        this.shape = shape;
        this.abilityScoreType = abilityScoreType;
        damageMap.put(1, new Damage(damageType, new Dice(6, 2)));
        damageMap.put(6, new Damage(damageType, new Dice(6, 3)));
        damageMap.put(11, new Damage(damageType, new Dice(6, 4)));
        damageMap.put(16, new Damage(damageType, new Dice(6, 5)));
    }

    @Override
    public BreathWeapon add(Integer key, Damage value)
    {
        damageMap.put(key, value);
        return this;
    }

    @Override
    public boolean containsKey(Integer key)
    {
        return damageMap.containsKey(key);
    }

    @Override
    public Damage get(Integer key)
    {
        return damageMap.get(key);
    }

    @Override
    public int getDCSave(AbilityScoreData score, int... bonuses)
    {
        if (score.getType() != AbilityScoreTypes.CONSTITUTION)
            throw new IllegalArgumentException("Breath Weapon DC requires Constitution modifier!");

        int save = 8 + score.getMod();
        for (int bonus : bonuses)
            save = +bonus;

        return save;
    }

    @Override
    public Map<Integer, Damage> getMap()
    {
        return damageMap;
    }

    public Shape getShape()
    {
        return shape;
    }

    @Override
    public AbilityScoreType getValue()
    {
        return abilityScoreType;
    }

    public static abstract class LineBreathWeapon extends BreathWeapon
    {
        protected LineBreathWeapon(DamageType damageType)
        {
            super(damageType, AbilityScoreTypes.DEXTERITY, new Line(5, 30));
        }

        public static class AcidLineBreathWeapon extends LineBreathWeapon
        {
            public AcidLineBreathWeapon()
            {
                super(DamageTypes.ACID);
            }
        }

        public static class FireLineBreathWeapon extends LineBreathWeapon
        {
            public FireLineBreathWeapon()
            {
                super(DamageTypes.FIRE);
            }
        }

        public static class LightningLineBreathWeapon extends LineBreathWeapon
        {
            public LightningLineBreathWeapon()
            {
                super(DamageTypes.LIGHTNING);
            }
        }
    }

    public static abstract class ConeBreathWeapon extends BreathWeapon
    {
        protected ConeBreathWeapon(DamageType damageType, AbilityScoreType scoreType)
        {
            super(damageType, scoreType, new Cone(15));
        }

        public static class ColdConeBreathWeapon extends ConeBreathWeapon
        {
            public ColdConeBreathWeapon()
            {
                super(DamageTypes.COLD, AbilityScoreTypes.CONSTITUTION);
            }
        }

        public static class FireConeBreathWeapon extends ConeBreathWeapon
        {
            public FireConeBreathWeapon()
            {
                super(DamageTypes.FIRE, AbilityScoreTypes.DEXTERITY);
            }
        }

        public static class PoisonConeBreathWeapon extends ConeBreathWeapon
        {
            public PoisonConeBreathWeapon()
            {
                super(DamageTypes.POISON, AbilityScoreTypes.CONSTITUTION);
            }
        }
    }
}
