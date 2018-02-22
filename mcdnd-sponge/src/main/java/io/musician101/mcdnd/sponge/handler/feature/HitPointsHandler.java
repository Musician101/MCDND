package io.musician101.mcdnd.sponge.handler.feature;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.CharacterClassType;
import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.dice.HitDice;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;

public class HitPointsHandler implements DataSerializable {

    private final Map<CharacterClassType, HitDice> hitDiceMap = new HashMap<>();

    public HitPointsHandler(CharacterClassType clazz, HitDice hitDice) {
        hitDiceMap.put(clazz, hitDice);
    }

    public HitPointsHandler addHitDice(CharacterClassType clazz, HitDice hitDice) {
        if (hitDiceMap.containsKey(clazz)) {
            hitDiceMap.put(clazz, new HitDice(hitDice.sides(), hitDiceMap.get(clazz).getAmount() + hitDice.getAmount()));
        }
        else {
            hitDiceMap.put(clazz, hitDice);
        }

        return this;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    public Optional<String> getHitPointsAtFirstLevel(CharacterClassType classType) {
        if (!hitDiceMap.containsKey(classType)) {
            return Optional.empty();
        }

        return Optional.of(hitDiceMap.get(classType).sides() + " + your Constitution modifier");
    }

    public Optional<Integer> handle(boolean takeAverage) {
        HitDice dice = null;
        for (HitDice hitDice : hitDiceMap.values()) {
            if (dice == null || dice.sides() > hitDice.sides()) {
                dice = hitDice;
            }
        }

        if (dice == null) {
            return Optional.empty();
        }

        int roll = 0;
        if (takeAverage) {
            roll = dice.getAverageRoll();
        }
        else {
            for (Entry<Dice, Integer> entry : dice.roll()) {
                roll = +entry.getValue();
            }
        }

        return Optional.of(roll);
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew().set(MCDNDKeys.CHARACTER_HIT_DICE, hitDiceMap);
    }
}
