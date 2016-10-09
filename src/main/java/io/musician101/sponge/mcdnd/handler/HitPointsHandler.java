package io.musician101.sponge.mcdnd.handler;

import io.musician101.sponge.mcdnd.data.type.CharacterClassType;
import io.musician101.sponge.mcdnd.dice.HitDice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated
public class HitPointsHandler implements Handler
{
    private final Map<CharacterClassType, HitDice> hitDiceMap = new HashMap<>();

    public HitPointsHandler(CharacterClassType clazz, HitDice hitDice)
    {
        hitDiceMap.put(clazz, hitDice);
    }

    public Optional<String> getHitPointsAtFirstLevel(CharacterClassType classType)
    {
        if (!hitDiceMap.containsKey(classType))
            return Optional.empty();

        return Optional.of(hitDiceMap.get(classType).sides() + " + your Constitution modifier");
    }

    @Override
    public Object handle()
    {
        return null;
    }
}
