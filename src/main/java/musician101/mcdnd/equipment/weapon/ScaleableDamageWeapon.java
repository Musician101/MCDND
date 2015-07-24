package musician101.mcdnd.equipment.weapon;

import java.util.HashMap;
import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.DamageType;
import musician101.mcdnd.dice.Dice;

public abstract class ScaleableDamageWeapon extends Weapon
{
	protected Map<Integer, Dice> damageMap = new HashMap<Integer, Dice>();

	protected ScaleableDamageWeapon(String name, DamageType damageType, Dice damage, AbilityScores scoreType)
	{
		super(name, damageType, damage, scoreType);
	}
	
	public void updateDamage(int level)
	{
		d = damageMap.get(level);
	}
}
