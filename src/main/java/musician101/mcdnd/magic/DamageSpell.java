package musician101.mcdnd.magic;

import java.util.List;

import musician101.mcdnd.dice.Dice;

public class DamageSpell extends Spell
{
	Dice damage;
	
	protected DamageSpell(String name, SpellType type, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, List<String> materials, int duration, boolean needsConcentration, Dice damage, String description)
	{
		super(name, type, level, castingTime, range, isVerbal, isSomatic, materials, duration, needsConcentration, description);
		this.damage = damage;
	}
	
	public int rollDamage()
	{
		return damage.roll();
	}
}
