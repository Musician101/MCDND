package io.musician101.mcdnd.sponge.handler.fightingstyle;

import io.musician101.common.java.minecraft.sponge.SpongeRegion;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.equipment.EquippedItems;
import io.musician101.mcdnd.sponge.handler.Handler;
import java.util.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class ProtectionHandler implements Handler<Optional<Location<World>>> {

    private final Player fighter;
    private final Entity target;

    public ProtectionHandler(Entity target, Player fighter) {
        this.target = target;
        this.fighter = fighter;
    }

    @Override
    public Optional<Location<World>> handle() {
        Location<World> targetLocation = target.getLocation();
        Location<World> fighterLocation = fighter.getLocation();
        if (targetLocation.getExtent().getUniqueId().equals(fighterLocation.getExtent().getUniqueId()) && SpongeRegion.createFromLocationRadius(targetLocation, 1).isInRegion(fighterLocation)) {
            Optional<EquippedItems> eiOptional = fighter.get(MCDNDKeys.EQUIPPED_ITEMS);
            if (eiOptional.isPresent()) {
                EquippedItems equippedItems = eiOptional.get();
                if (equippedItems.getShield() != null) {
                    return Optional.of(fighterLocation);
                }
            }
        }

        return Optional.empty();
    }
}
