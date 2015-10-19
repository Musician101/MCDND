package musician101.mcdnd.character;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.alignment.Alignment;
import musician101.mcdnd.clazz.ProficiencyBonus;
import musician101.mcdnd.equipment.armor.Armor;
import musician101.mcdnd.equipment.armor.Armor.ArmorTypes;
import musician101.mcdnd.race.Race;
import musician101.mcdnd.skill.SkillCarrier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class PlayerCharacter extends Character
{
	private Alignment alignment;
	private Armor armor;
	private Armor shield;
	private int armorClassBonus;
	ProficiencyBonus proficiencyBonus;
	private Race race;
	private SkillCarrier skills;
	
	public PlayerCharacter(EntityPlayer player)
	{
		super(player);
	}
	
	public EntityPlayer getPlayer()
	{
		for (Object object : MinecraftServer.getServer().getConfigurationManager().playerEntityList)
		{
			EntityPlayer player = (EntityPlayer) object;
			if (player.getUniqueID() == uuid)
				return player;
		}
		
		return null;
	}
	
	public Alignment getAlignment()
	{
		return alignment;
	}
	
	public Armor getArmor()
	{
		return armor;
	}
	
	public void setArmor(Armor armor)
	{
		this.armor = armor;
	}
	
	public Armor getShield()
	{
		return shield;
	}
	
	public void setShield(Armor shield)
	{
		this.shield = shield;
	}
	
	@Override
	public int getArmorClass()
	{
		int ac = armor.getArmorClass();
		if (armor.getType() != ArmorTypes.HEAVY)
			ac =+ scores.getAbilityMod(AbilityScores.DEX);
		
		if (shield != null)
			ac =+ shield.getArmorClass();
		
		return ac + armorClassBonus;
	}
	
	public Race getRace()
	{
		return race;
	}
	
	public void setRace(Race race)
	{
		this.race = race;
	}
	
	public SkillCarrier getSkillCarrier()
	{
		return skills;
	}
}
