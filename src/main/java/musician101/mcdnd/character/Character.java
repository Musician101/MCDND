package musician101.mcdnd.character;

import musician101.mcdnd.abilityscore.CharacterAbilityScores;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.World;

import java.util.Optional;
import java.util.UUID;

public abstract class Character<E extends Entity>
{
    final UUID uuid;
    CharacterAbilityScores scores;

    public Character(E entity)
    {
        uuid = entity.getUniqueId();
    }

    public CharacterAbilityScores getAbilityScores()
    {
        return scores;
    }

    public void setAbilityScores(CharacterAbilityScores scores)
    {
        this.scores = scores;
    }

    @SuppressWarnings("unchecked")
    public E getEntity()
    {
        for (World world : Sponge.getServer().getWorlds())
        {
            Optional<Entity> entityOptional = world.getEntity(uuid);
            if (entityOptional.isPresent())
                return (E) entityOptional.get();
        }

        return null;
    }

    public abstract int getArmorClass();

    public UUID getUniqueId()
    {
        return uuid;
    }
}
