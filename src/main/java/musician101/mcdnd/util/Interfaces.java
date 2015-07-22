package musician101.mcdnd.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.Damage;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;

public class Interfaces
{
	public static interface Described
	{
		String getDescription();
	}
	
	public static interface DamageDealer
	{
		Damage getDamage();
	}
	
	public static interface DCSave
	{
		AbilityScores getAbilitySaveType();
		
		int getDCSave(AbilityScore score, int... bonuses);
	}
	
	public static interface EffectsArea
	{
		/** Needs to consider diagonals and the choice to include point of origin */
		@Deprecated
		List<BlockPos> getArea(Entity entity);
	}
	
	public static interface Mapped<K, V>
	{
		Map<K, V> getMap();
		
		boolean containsKey(K key);
		
		V get(K key);
		
		V remove(K key);
		
		Set<K> keySet();
		
		Set<Entry<K, V>> entrySet();
	}
	
	public static interface Named
	{
		String getName();
	}
	
	public interface ScaleableDamage extends DamageDealer, Mapped<Integer, Damage>
	{
		void updateDamage(int level);
	}
}
