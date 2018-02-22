package io.musician101.mcdnd.sponge.handler.fightingstyle;

import io.musician101.mcdnd.sponge.armor.CharacterArmorClass;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.handler.Handler;
import java.util.Map;
import java.util.Optional;
import org.spongepowered.api.entity.living.player.Player;

public class DefenseHandler implements Handler<Optional<Integer>> {

    private final Player player;

    public DefenseHandler(Player player) {
        this.player = player;
    }

    @Override
    public Optional<Integer> handle() {
        Optional<CharacterArmorClass> acOptional = player.get(MCDNDKeys.CHARACTER_ARMOR_CLASS);
        Optional<Map<AbilityScoreType, Integer>> scoresOptional = player.get(MCDNDKeys.ABILITY_SCORES);
        if (acOptional.isPresent() && scoresOptional.isPresent()) {
            return Optional.of(acOptional.get().getArmorClass(scoresOptional.get()) + 1);
        }

        return Optional.empty();
    }
}
