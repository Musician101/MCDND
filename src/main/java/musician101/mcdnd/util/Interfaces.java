package musician101.mcdnd.util;

import java.util.List;
import java.util.Map;

import musician101.mcdnd.abilityscore.AbilityScore;
import musician101.mcdnd.abilityscore.AbilityScore.AbilityScores;
import musician101.mcdnd.combat.Damage;
import musician101.mcdnd.currency.CurrencyHolder.Cost;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;

public class Interfaces
{
	public static interface Buyable
	{
		Cost getCost();
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
	
	public static interface Described
	{
		String getDescription();
	}
	
	public static interface EffectsArea
	{
		/** Needs to consider diagonals and the choice to include point of origin */
		@Deprecated
		List<BlockPos> getArea(Entity entity);
	}
	
	public static interface Listed<T>
	{
		List<T> getList();
		
		T get(int T);
	}
	
	public static interface Mapped<K, V>
	{
		boolean containsKey(K key);
		
		Map<K, V> getMap();
		
		V get(K key);
	}
	
	public static interface Named
	{
		String getName();
	}
	
	public static interface Weighable
	{
		double getWeight();
	}
}
