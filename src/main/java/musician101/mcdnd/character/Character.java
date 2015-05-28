package musician101.mcdnd.character;

import java.util.UUID;

import musician101.mcdnd.abilityscore.CharacterAbilityScores;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.DimensionManager;

public abstract class Character
{
	//TODO redo this so that we have PlayerCharacter and NonPlayerCharacter classes?
	CharacterAbilityScores scores;
	UUID uuid;
	
	public Character(Entity entity)
	{
		uuid = entity.getUniqueID();
	}
	
	public CharacterAbilityScores getAbilityScores()
	{
		return scores;
	}
	
	public void setAbilityScores(CharacterAbilityScores scores)
	{
		this.scores = scores;
	}
	
	/**
	 * @deprecated Method needs to be moved to the NPC class
	 * @return
	 */
	@Deprecated
	public Entity getEntity()
	{
		for (int id : DimensionManager.getIDs())
		{
			for (Object object : DimensionManager.getWorld(id).loadedEntityList)
			{
				Entity entity = (Entity) object;
				if (entity.getUniqueID() == uuid)
					return entity;
			}
		}
		
		return null;
	}
	
	public abstract int getArmorClass();
	
	public UUID getUniqueId()
	{
		return uuid;
	}
}
