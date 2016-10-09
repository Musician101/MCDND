package io.musician101.sponge.mcdnd.handler.fightingstyle;

import io.musician101.sponge.mcdnd.armor.CharacterArmorClass;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.handler.Handler;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Map;
import java.util.Optional;

public class DefenseHandler implements Handler<Optional<Integer>>
{
    private final Player player;

    public DefenseHandler(Player player)
    {
        this.player = player;
    }

    @Override
    public Optional<Integer> handle()
    {
        Optional<CharacterArmorClass> acOptional = player.get(MCDNDKeys.CHARACTER_ARMOR_CLASS);
        Optional<Map<AbilityScoreType, Integer>> scoresOptional = player.get(MCDNDKeys.ABILITY_SCORES);
        if (acOptional.isPresent() && scoresOptional.isPresent())
            return Optional.of(acOptional.get().getArmorClass(scoresOptional.get()) + 1);

        return Optional.empty();
    }
}
