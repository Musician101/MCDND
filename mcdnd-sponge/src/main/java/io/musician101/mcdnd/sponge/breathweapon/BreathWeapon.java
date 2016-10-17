package io.musician101.mcdnd.sponge.breathweapon;

import io.musician101.mcdnd.sponge.combat.MCDNDDamageType;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.manipulator.mutable.AbilityScoreData;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.shape.Cone;
import io.musician101.mcdnd.sponge.shape.Line;
import io.musician101.mcdnd.sponge.shape.Shape;
import io.musician101.mcdnd.sponge.util.Interfaces.AbilityScoreDCSave;
import io.musician101.mcdnd.sponge.util.Interfaces.Described;
import io.musician101.mcdnd.sponge.util.Interfaces.Mapped;
import io.musician101.mcdnd.sponge.util.Interfaces.Named;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BreathWeapon<S extends Shape> implements AbilityScoreDCSave, DataSerializable, Described, Named, Mapped<Integer, Dice>
{
    private final AbilityScoreType abilityScoreType;
    private final MCDNDDamageType damageType;
    private final List<String> description;
    private final Map<Integer, Dice> diceMap;
    private final S shape;
    private final String name;

    protected BreathWeapon(String name, MCDNDDamageType damageType, AbilityScoreType abilityScoreType, S shape, List<String> description, Map<Integer, Dice> diceMap)
    {
        this.name = name;
        this.description = description;
        this.shape = shape;
        this.abilityScoreType = abilityScoreType;
        this.diceMap = diceMap;
        this.damageType = damageType;
    }

    @Override
    public AbilityScoreType getValue()
    {
        return abilityScoreType;
    }

    @Override
    public boolean containsKey(Integer key)
    {
        return diceMap.containsKey(key);
    }

    public MCDNDDamageType getDamageType()
    {
        return damageType;
    }

    @Override
    public Dice get(Integer key)
    {
        return diceMap.get(key);
    }

    @Override
    public List<String> getDescription()
    {
        return description;
    }

    @Override
    public Optional<Integer> getDCSave(AbilityScoreData score, int... bonuses)
    {
        Optional<Integer> optional = score.get(abilityScoreType);
        if (!optional.isPresent())
            return Optional.empty();

        return Optional.of(8 + abilityScoreType.getMod(optional.get()));
    }

    @Override
    public Map<Integer, Dice> getMap()
    {
        return diceMap;
    }

    public S getShape()
    {
        return shape;
    }

    @Override
    public String getName()
    {
        return null;
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        DataContainer data = new MemoryDataContainer()
                .set(MCDNDKeys.NAME, name)
                .set(MCDNDKeys.DESCRIPTION, description)
                .set(MCDNDKeys.ABILITY_SCORE_TYPE, abilityScoreType)
                .set(MCDNDKeys.INTEGER_DICE_MAP, diceMap)
                .set(MCDNDKeys.DAMAGE_TYPE, damageType);

        if (shape instanceof Cone)
            data.set(MCDNDKeys.CONE, (Cone) shape);
        else if (shape instanceof Line)
            data.set(MCDNDKeys.LINE, (Line) shape);
        
        return data;
    }

    public static BreathWeaponBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(BreathWeaponBuilder.class);
    }
}
