package musician101.mcdnd.magic;

import java.util.HashMap;
import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.Shape.Cone;
import musician101.mcdnd.magic.Shape.Line;
import musician101.mcdnd.util.Interfaces.DCSave;
import musician101.mcdnd.util.Interfaces.Mapped;

public abstract class BreathWeapon extends Spell implements DCSave, Mapped<Integer, Damage>
{
	private final AbilityScores saveType;
	private final Map<Integer, Damage> damageMap = new HashMap<>();
	private final Shape shape;
	
	protected BreathWeapon(DamageType damageType, AbilityScores saveType, Shape shape)
	{
		super("Breath Weapon", SpellType.EVOCATION, SpellLevel.CANTRIP, 0, 0, false, false, "", 0, false, "You can use your action to exhale destructive energy. Your draconic ancestry determines the size, shape, and damage type of the exhalation", 
				"When you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at the 6th level, 4d6 at 11th level, and 5d6 at 16th level.", 
				"After you use your breath weapon, you can't use it again until you complete a short or long rest.");
		
		this.shape = shape;
		this.saveType = saveType;
		damageMap.put(1, new Damage(damageType, new Dice(6, 2)));
		damageMap.put(6, new Damage(damageType, new Dice(6, 3)));
		damageMap.put(11, new Damage(damageType, new Dice(6, 4)));
		damageMap.put(16, new Damage(damageType, new Dice(6, 5)));
	}
	
	@Override
	public AbilityScores getAbilitySaveType()
	{
		return saveType;
	}
	
	@Override
	public boolean containsKey(Integer key)
	{
		return damageMap.containsKey(key);
	}
	
	@Override
	public Damage get(Integer key)
	{
		return damageMap.get(key);
	}
	
	@Override
	public int getDCSave(AbilityScore score, int... bonuses)
	{
		if (score.getType() != AbilityScores.CON)
			throw new IllegalArgumentException("Breath Weapon DC requires Constitution modifier!");
		
		int save = 8 + score.getMod();
		for (int bonus : bonuses)
			save =+ bonus;
			
		return save;
	}
	
	@Override
	public Map<Integer, Damage> getMap()
	{
		return damageMap;
	}
	
	public Shape getShape()
	{
		return shape;
	}
	
	public static abstract class LineBreathWeapon extends BreathWeapon
	{
		protected LineBreathWeapon(DamageType damageType)
		{
			super(damageType, AbilityScores.DEX, new Line(5, 30));
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
			super(damageType, scoreType, new Cone(15));
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
