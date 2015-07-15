package musician101.mcdnd.equipment.weapon;

import java.util.ArrayList;
import java.util.List;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.DCSave;
import musician101.mcdnd.combat.DamagePath;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public abstract class BreathWeapon extends ScaleableDamageWeapon implements DCSave
{
	DamagePath damagePath;
	
	protected BreathWeapon(DamageType damageType, AbilityScores scoreType, DamagePath damagePath)
	{
		super("Breath Weapon", damageType, new Dice(6, 2), scoreType);
		this.damagePath = damagePath;
		damageMap.put(1, new Dice(6, 2));
		damageMap.put(6, new Dice(6, 3));
		damageMap.put(11, new Dice(6, 4));
		damageMap.put(16, new Dice(6, 5));
	}
	
	public DamagePath getDamagePath()
	{
		return damagePath;
	}
	
	public abstract List<BlockPos> getAffectedArea(EntityPlayer player);
	
	@Override
	public int getRequiredDCSave(AbilityScore score, int proficiencyBonus)
	{
		if (score.getType() != AbilityScores.CON)
			throw new IllegalArgumentException("Breath Weapon DC requires Consitution modifier!");
		
		return 8 + score.getMod() + proficiencyBonus;
	}
	
	public static abstract class LineBreathWeapon extends BreathWeapon
	{
		protected LineBreathWeapon(DamageType damageType)
		{
			super(damageType, AbilityScores.DEX, DamagePath.LINE);
		}
		
		@Override
		public List<BlockPos> getAffectedArea(EntityPlayer player)
		{
			BlockPos pos = player.getPosition();
			List<BlockPos> list = new ArrayList<BlockPos>();
			for (int i = 1; i < 7; i++)
			{
				int x = pos.getX();
				int z = pos.getZ();
				EnumFacing dir = EnumFacing.fromAngle(player.rotationPitch);
				if (dir == EnumFacing.NORTH)
					z =- i;
				else if (dir == EnumFacing.SOUTH)
					z =+ i;
				else if (dir == EnumFacing.WEST)
					x =- i;
				else if (dir == EnumFacing.EAST)
					x =+ i;
				
				list.add(new BlockPos(x, pos.getY(), z));
			}
			
			return list;
		}
		
		public static class AcidLineBreathWeapon extends LineBreathWeapon
		{
			public AcidLineBreathWeapon()
			{
				super(DamageType.ACID);
			}
		}
		
		public static class FireLineBreathWeapon extends LineBreathWeapon
		{
			public FireLineBreathWeapon()
			{
				super(DamageType.FIRE);
			}
		}
		
		public static class LightningLineBreathWeapon extends LineBreathWeapon
		{
			public LightningLineBreathWeapon()
			{
				super(DamageType.LIGHTNING);
			}
		}
	}
	
	public static abstract class ConeBreathWeapon extends BreathWeapon
	{
		protected ConeBreathWeapon(DamageType damageType, AbilityScores scoreType)
		{
			super(damageType, scoreType, DamagePath.CONE);
		}
		
		@Override
		public List<BlockPos> getAffectedArea(EntityPlayer player)
		{
			BlockPos pos = player.getPosition();
			List<BlockPos> list = new ArrayList<BlockPos>();
			int x = pos.getX();
			int z = pos.getZ();
			EnumFacing dir = EnumFacing.fromAngle(player.rotationPitch);
			if (dir == EnumFacing.NORTH)
				z =- 1;
			else if (dir == EnumFacing.SOUTH)
				z =+ 1;
			else if (dir == EnumFacing.WEST)
				x =- 1;
			else if (dir == EnumFacing.EAST)
				x =+ 1;
			
			list.add(new BlockPos(x, pos.getY(), z));
			
			for (int i = 1; i < 2; i++)
			{
				if (dir == EnumFacing.NORTH)
				{
					z =- i;
					list.add(new BlockPos(x - 1, pos.getY(), z));
					list.add(new BlockPos(x, pos.getY(), z));
					list.add(new BlockPos(x + 1, pos.getY(), z));
				}
				else if (dir == EnumFacing.SOUTH)
				{
					z =+ i;
					list.add(new BlockPos(x - 1, pos.getY(), z));
					list.add(new BlockPos(x, pos.getY(), z));
					list.add(new BlockPos(x + 1, pos.getY(), z));
				}
				else if (dir == EnumFacing.WEST)
				{
					x =- i;
					list.add(new BlockPos(x, pos.getY(), z - 1));
					list.add(new BlockPos(x, pos.getY(), z));
					list.add(new BlockPos(x, pos.getY(), z + 1));
				}
				else if (dir == EnumFacing.EAST)
				{
					x =+ i;
					list.add(new BlockPos(x, pos.getY(), z - 1));
					list.add(new BlockPos(x, pos.getY(), z));
					list.add(new BlockPos(x, pos.getY(), z + 1));
				}
			}
			
			return list;
		}
		
		public static class ColdConeBreathWeapon extends ConeBreathWeapon
		{
			public ColdConeBreathWeapon()
			{
				super(DamageType.COLD, AbilityScores.CON);
			}
		}
		
		public static class FireConeBreathWeapon extends ConeBreathWeapon
		{
			public FireConeBreathWeapon()
			{
				super(DamageType.FIRE, AbilityScores.DEX);
			}
		}
		
		public static class PoisonConeBreathWeapon extends ConeBreathWeapon
		{
			public PoisonConeBreathWeapon()
			{
				super(DamageType.POISON, AbilityScores.CON);
			}
		}
	}
}
