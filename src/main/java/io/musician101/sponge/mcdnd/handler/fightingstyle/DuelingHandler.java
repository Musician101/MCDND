package io.musician101.sponge.mcdnd.handler.fightingstyle;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.equipment.EquippedItems;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapon;
import io.musician101.sponge.mcdnd.equipment.weapon.property.WeaponProperties;
import io.musician101.sponge.mcdnd.handler.Handler;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Optional;

public class DuelingHandler implements Handler<Optional<Integer>>
{
    private final Player player;
    private final Weapon weapon;

    public DuelingHandler(Player player, Weapon weapon)
    {
        this.player = player;
        this.weapon = weapon;
    }

    @Override
    public Optional<Integer> handle()
    {
        Optional<Integer> attackRoll = weapon.rollDamage(player, false);
        Optional<EquippedItems> eiOptional = player.get(MCDNDKeys.EQUIPPED_ITEMS);
        if (attackRoll.isPresent() && eiOptional.isPresent())
        {
            EquippedItems ei = eiOptional.get();
            if (ei.getOffHand() != null && !ei.getMainHand().getProperties().contains(WeaponProperties.TWO_HANDED))
                return Optional.of(attackRoll.get() + 2);

            return Optional.of(attackRoll.get());
        }

        return Optional.empty();
    }
}