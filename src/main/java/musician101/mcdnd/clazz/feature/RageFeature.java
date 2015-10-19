package musician101.mcdnd.clazz.feature;

import java.util.Map;

import musician101.mcdnd.util.CustomMap;

public class RageFeature extends Feature
{
	private int rageDamage = 2;
	private int rages = 2;
	private final Map<Integer, Integer> rageDamageMap = new CustomMap<Integer, Integer>().add(1, 2).add(9, 3).add(16, 4);
	private final Map<Integer, Integer> ragesMap = new CustomMap<Integer, Integer>().add(1, 2).add(3, 3).add(6, 4).add(12, 5).add(17, 6).add(20, -1);
	
	public RageFeature()
	{
		super("Rage", "In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action.",
				"While raging, you gain the following benefits if you aren't wearing heavy armor:",
				"- You have advantage on Strength checks and Strength saving throws.",
				"- When you make a melee weapon attack using Strength, you gain a bonus to the damage roll that increases as you gain levels as a barbarian.",
				"- You have resistance to bludgeoning, piercing, and slashing damage.",
				"If you are able to cast spells, you can't cast them or concentrate on them while raging.",
				"Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you haven't attacked a hostile creature since your last turn or taken damage since then. You can also end your rage on your turn as a bonus action.",
				"Once you have raged the number of times shown for your barbarian level, you must finish a long rest before you can rage again.");
	}
	
	public int getRageDamage()
	{
		return rageDamage;
	}
	
	public int getRages()
	{
		return rages;
	}
	
	public void update(int level)
	{
		if (rageDamageMap.containsKey(level))
			rageDamage = rageDamageMap.get(level);
		
		if (ragesMap.containsKey(level))
			rages = ragesMap.get(level);
	}
}
