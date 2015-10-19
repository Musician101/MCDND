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
	public interface Buyable
	{
		Cost getCost();
	}
	
	public interface DamageDealer
	{
		Damage getDamage();
	}
	
	public interface DCSave
	{
		AbilityScores getAbilitySaveType();
		
		int getDCSave(AbilityScore score, int... bonuses);
	}
	
	public interface Described
	{
		String[] getDescription();
	}
	
	public interface EffectsArea
	{
		/** Needs to consider diagonals and the choice to include point of origin */
		@Deprecated
		List<BlockPos> getArea(Entity entity);
	}
	
	public interface Listed<T>
	{
		List<T> getList();
		
		T get(int T);
	}
	
	public interface Mapped<K, V>
	{
		boolean containsKey(K key);
		
		Map<K, V> getMap();
		
		V get(K key);
	}
	
	public interface Named
	{
		String getName();
	}
	
	public interface Weighable
	{
		double getWeight();
	}
}
