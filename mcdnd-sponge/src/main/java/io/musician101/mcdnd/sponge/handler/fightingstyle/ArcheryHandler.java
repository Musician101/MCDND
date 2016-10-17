package io.musician101.mcdnd.sponge.handler.fightingstyle;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.EquippedItems;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapon;
import io.musician101.mcdnd.sponge.handler.Handler;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Optional;

public class ArcheryHandler implements Handler<Optional<Integer>>
{
    private final Player player;
    private final Weapon weapon;

    public ArcheryHandler(Player player, Weapon weapon)
    {
        this.player = player;
        this.weapon = weapon;
    }

    @Override
    public Optional<Integer> handle()
    {
        Optional<Integer> attackRoll = weapon.rollDamage(player, true);
        Optional<EquippedItems> eiOptional = player.get(MCDNDKeys.EQUIPPED_ITEMS);
        if (attackRoll.isPresent() && eiOptional.isPresent())
        {
            EquippedItems ei = eiOptional.get();
            if (ei.getOffHand() != null)
                return Optional.of(attackRoll.get() + 2);

            return Optional.of(attackRoll.get());
        }

        return Optional.empty();
    }
}
