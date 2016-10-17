package io.musician101.mcdnd.sponge.event;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent;

import javax.annotation.Nonnull;

public class PlayerAttackEntityEvent implements TargetPlayerEvent
{
    private final boolean causedByReroll;
    private final Cause cause;
    private final Entity targetEntity;
    private final Player player;

    public PlayerAttackEntityEvent(Player player, Entity targetEntity, boolean causedByReroll, Cause cause)
    {
        this.player = player;
        this.targetEntity = targetEntity;
        this.causedByReroll = causedByReroll;
        this.cause = cause;
    }

    public boolean isCausedByReroll()
    {
        return causedByReroll;
    }

    @Nonnull
    @Override
    public Cause getCause()
    {
        return cause;
    }

    public Entity getTargetedEntity()
    {
        return targetEntity;
    }

    @Nonnull
    @Override
    public Player getTargetEntity()
    {
        return player;
    }
}
