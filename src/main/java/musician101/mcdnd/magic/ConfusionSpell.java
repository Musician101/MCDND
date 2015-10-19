package musician101.mcdnd.magic;

import java.util.Arrays;
import java.util.Map;

import musician101.mcdnd.lib.Reference.ActionTimes;
import musician101.mcdnd.magic.MappedSpell.MultipleSpellSlotSpell;
import musician101.mcdnd.util.CustomMap;

public class ConfusionSpell extends MultipleSpellSlotSpell
{
	private final Map<Integer, String> behaviorMap;
	
	public ConfusionSpell()
	{
		super("Confusion", SpellType.ENCHANTMENT, SpellLevel.LEVEL_4, ActionTimes.ACTION, 90, true, true, "three nut shells", 60, true, new CustomMap<SpellLevel, Integer>().add(SpellLevel.LEVEL_5, 95).add(SpellLevel.LEVEL_6, 100).add(SpellLevel.LEVEL_7, 105).add(SpellLevel.LEVEL_8, 110).add(SpellLevel.LEVEL_9, 115), SpellLevel.LEVEL_5,
				"This spell assaults and twists creatures' minds, spawning delusions and provoking uncontrolled action. Each creature in a 10-foot-radius sphere centered on a point you choose within range must succeed on a Wisdom saving throw when you cast this spell or be affected by it.",
				"An affected target can't take reactions and must roll a d10 at the start of each of its to determine its behavior for that turn.",
				"At the end of each of its turns, an affected target can make a Wisdom saving throw. If it succeeds, this effect ends for that target.",
				"At Higher Levels: When you cast this spell using a spell slot of 5th level or higher, the radius of the sphere increases by 5 feet for each slot level above 4th.");
		this.behaviorMap = new CustomMap<Integer, String>().add(1, "The creature uses all its movement to move in a random direction. To determine the direction, roll a d8 and assign a direction to each die face. The creature doesn't take an action this turn.").add(Arrays.asList(2, 3, 4, 5, 6), "The creature doesn't move or take actions this turn.")
				.add(Arrays.asList(7, 8), "The creature uses its action to make a melee attack against a randomly determined creature within its reach. If there is no creature within its reach, the creature does nothing this turn.").add(Arrays.asList(9, 10), "The creature can act and move normally.");
	}
	
	public Map<Integer, String> getBehaviorMap()
	{
		return behaviorMap;
	}
}
