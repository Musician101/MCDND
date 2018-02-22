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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public class BreathWeapon<S extends Shape> implements AbilityScoreDCSave, DataSerializable, Described, Named, Mapped<Integer, Dice> {

    private final AbilityScoreType abilityScoreType;
    private final MCDNDDamageType damageType;
    private final List<String> description;
    private final Map<Integer, Dice> diceMap;
    private final String name;
    private final S shape;

    protected BreathWeapon(String name, MCDNDDamageType damageType, AbilityScoreType abilityScoreType, S shape, List<String> description, Map<Integer, Dice> diceMap) {
        this.name = name;
        this.description = description;
        this.shape = shape;
        this.abilityScoreType = abilityScoreType;
        this.diceMap = diceMap;
        this.damageType = damageType;
    }

    public static BreathWeaponBuilder builder() {
        return Sponge.getRegistry().createBuilder(BreathWeaponBuilder.class);
    }

    @Override
    public boolean containsKey(Integer key) {
        return diceMap.containsKey(key);
    }

    @Override
    public Dice get(Integer key) {
        return diceMap.get(key);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public Optional<Integer> getDCSave(AbilityScoreData score, int... bonuses) {
        Optional<Integer> optional = score.get(abilityScoreType);
        if (!optional.isPresent()) {
            return Optional.empty();
        }

        return Optional.of(8 + abilityScoreType.getMod(optional.get()));
    }

    public MCDNDDamageType getDamageType() {
        return damageType;
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Override
    public Map<Integer, Dice> getMap() {
        return diceMap;
    }

    @Override
    public String getName() {
        return null;
    }

    public S getShape() {
        return shape;
    }

    @Override
    public AbilityScoreType getValue() {
        return abilityScoreType;
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        DataContainer data = DataContainer.createNew().set(MCDNDKeys.NAME, name).set(MCDNDKeys.DESCRIPTION, description).set(MCDNDKeys.ABILITY_SCORE_TYPE, abilityScoreType).set(MCDNDKeys.INTEGER_DICE_MAP, diceMap).set(MCDNDKeys.DAMAGE_TYPE, damageType);

        if (shape instanceof Cone) {
            data.set(MCDNDKeys.CONE, (Cone) shape);
        }
        else if (shape instanceof Line) {
            data.set(MCDNDKeys.LINE, (Line) shape);
        }

        return data;
    }
}
