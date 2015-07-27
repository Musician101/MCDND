package musician101.mcdnd.clazz.feature.totem;

import musician101.mcdnd.clazz.feature.totem.Totem.BearTotem;
import musician101.mcdnd.clazz.feature.totem.Totem.EagleTotem;
import musician101.mcdnd.clazz.feature.totem.Totem.WolfTotem;

public class Totems
{
	public static final Totem BEAR_3 = new BearTotem("While raging, you have resistance to all damage except psychic damage. The spirit of the bear makes you tough enough to stand up to any punishment.");
	public static final Totem EAGLE_3 = new EagleTotem("While you're raging and aren't wearing heavy armor, other creatures have disadvantage on opportunity attack rolls against you, and you can use the Dash action as a bonus action on your turn. The spirit of the eagle makes you into a predator who can weave through the fray with ease.");
	public static final Totem WOLF_3 = new WolfTotem("While you're raging, your friends have advantage on melee attack rolls against any creature within 5 feet of you that is hostile to you. The spirit of the wolf makes you a leader of hunters.");
	public static final Totem BEAR_6 = new BearTotem("You gain the might of a bear. Your carrying capacity (including maximum load and maximum lift) is doubled, and you have advantage on Strength checks made to push, pull, lift, or break objects.");
	public static final Totem EAGLE_6 = new EagleTotem("You gain the eyesight of an eagle. You can see up to 1 mile away with no difficulty, able to discern even fine details as though looking at something no more than 100 feet away from you. Additionally, dim light doesn't impose disadvantage on your Wisdom (Perception) checks.");
	public static final Totem WOLF_6 = new WolfTotem("You gain the hunting sensibilities of a wolf. You can track other creatures while traveling at a fast pace, and you can move stealthily while traveling at a normal pace.");
}
