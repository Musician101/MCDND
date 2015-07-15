package musician101.mcdnd.magic;

import java.util.Arrays;

import musician101.mcdnd.dice.Dice;
import musician101.mcdnd.magic.Spell.SpellLevel;
import musician101.mcdnd.magic.Spell.SpellType;
import musician101.mcdnd.util.CustomHashMap;

public class Spells
{
	//TODO left off here. page 211
	// String name, SpellType typ, SpellLevel level, int castingTime, int range, boolean isVerbal, boolean isSomatic, List<String> materials, int duration, boolean needsConcentration, String description
	public static final ScaleableDamageSpell ACID_SPLASH = new ScaleableDamageSpell("Acid Splash", SpellType.CONJURATION, SpellLevel.CANTRIP, -1, 60, true, true, false, new CustomHashMap<Integer, Dice>().add(1, new Dice(6)).add(5, new Dice(6, 2)).add(11, new Dice(6, 3)).add(17, new Dice(6, 4)), "You hurl a buble of acid. Choose on creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.");
	public static final Spell DANCING_LIGHTS = new Spell("Dancing Lights", SpellType.EVOCATION, SpellLevel.CANTRIP, -1, 120, true, true, Arrays.asList("Phosphorus", "Wychwood", "Glowworm"), 60, true, "You create up to four torch-sized lights within range, making them appear as torches, lanterns, or glowing orbs that hover in the air for the duration. You can also combine the four lights into one glowing vaguely humanoid form of Medium size. Whichever form you choose, each light sheds dim light in a 10-foot radius.\nAs a Bonus action on your turn, you can move the lights up to 60 feet to a new spot within range. A light must be within 20 feet of anther light created by this spell, and a light winks out if it exceeds the spell's range.");
}
