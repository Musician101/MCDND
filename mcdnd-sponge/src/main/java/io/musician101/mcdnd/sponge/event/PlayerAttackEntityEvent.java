package io.musician101.mcdnd.sponge.event;

import javax.annotation.Nonnull;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent;

public class PlayerAttackEntityEvent implements TargetPlayerEvent {

    private final Cause cause;
    private final boolean causedByReroll;
    private final Player player;
    private final Entity targetEntity;

    public PlayerAttackEntityEvent(Player player, Entity targetEntity, boolean causedByReroll, Cause cause) {
        this.player = player;
        this.targetEntity = targetEntity;
        this.causedByReroll = causedByReroll;
        this.cause = cause;
    }

    @Nonnull
    @Override
    public Cause getCause() {
        return cause;
    }

    @Nonnull
    @Override
    public Player getTargetEntity() {
        return player;
    }

    public Entity getTargetedEntity() {
        return targetEntity;
    }

    public boolean isCausedByReroll() {
        return causedByReroll;
    }
}
