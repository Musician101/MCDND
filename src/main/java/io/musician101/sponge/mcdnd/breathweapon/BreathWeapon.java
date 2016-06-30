package io.musician101.sponge.mcdnd.breathweapon;

import io.musician101.sponge.mcdnd.combat.MCDNDDamageType;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.shape.Shape;
import io.musician101.sponge.mcdnd.util.Interfaces.AbilityScoreDCSave;
import io.musician101.sponge.mcdnd.util.Interfaces.Described;
import io.musician101.sponge.mcdnd.util.Interfaces.Mapped;
import io.musician101.sponge.mcdnd.util.Interfaces.Named;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BreathWeapon implements AbilityScoreDCSave, DataSerializable, Described, Named, Mapped<Integer, Dice>
{
    private final AbilityScoreType abilityScoreType;
    private final MCDNDDamageType damageType;
    private final List<String> description;
    private final Map<Integer, Dice> diceMap;
    private final Shape shape;
    private final String name;

    protected BreathWeapon(String name, MCDNDDamageType damageType, AbilityScoreType abilityScoreType, Shape shape, List<String> description, Map<Integer, Dice> diceMap)
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

    public Shape getShape()
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
        return new MemoryDataContainer()
                .set(MCDNDKeys.NAME, name)
                .set(MCDNDKeys.DESCRIPTION, description)
                .set(MCDNDKeys.ABILITY_SCORE_TYPE, abilityScoreType)
                .set(MCDNDKeys.INTEGER_DICE_MAP, diceMap)
                .set(MCDNDKeys.DAMAGE_TYPE, damageType)
                .set(MCDNDKeys.SHAPE, shape);
    }

    public static BreathWeaponBuilder builder()
    {
        return Sponge.getRegistry().createBuilder(BreathWeaponBuilder.class);
    }
}
