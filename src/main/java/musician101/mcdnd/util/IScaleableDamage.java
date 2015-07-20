package musician101.mcdnd.util;

import musician101.mcdnd.combat.Damage;

public interface IScaleableDamage extends IDamage, IMapped<Integer, Damage>
{
	void updateDamage(int level);
}
