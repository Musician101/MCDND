package io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.totem;

import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.totem.Totem.BearTotem;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.totem.Totem.EagleTotem;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.primalpaths.totem.Totem.WolfTotem;
import io.musician101.sponge.mcdnd.util.MapUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Totems
{
    public static final Totem BEAR_3 = new BearTotem("While raging, you have resistance to all damage except psychic damage. The spirit of the bear makes you tough enough to stand up to any punishment.");
    public static final Totem EAGLE_3 = new EagleTotem("While you're raging and aren't wearing heavy armor, other creatures have disadvantage on opportunity attack rolls against you, and you can use the Dash action as a bonus action on your turn. The spirit of the eagle makes you into a predator who can weave through the fray with ease.");
    public static final Totem WOLF_3 = new WolfTotem("While you're raging, your friends have advantage on melee attack rolls against any creature within 5 feet of you that is hostile to you. The spirit of the wolf makes you a leader of hunters.");
    public static final Totem BEAR_6 = new BearTotem("You gain the might of a bear. Your carrying capacity (including maximum load and maximum lift) is doubled, and you have advantage on Strength checks made to push, pull, lift, or break objects.");
    public static final Totem EAGLE_6 = new EagleTotem("You gain the eyesight of an eagle. You can see up to 1 mile away with no difficulty, able to discern even fine details as though looking at something no more than 100 feet away from you. Additionally, dim light doesn't impose disadvantage on your Wisdom (Perception) checks.");
    public static final Totem WOLF_6 = new WolfTotem("You gain the hunting sensibilities of a wolf. You can track other creatures while traveling at a fast pace, and you can move stealthily while traveling at a normal pace.");
    public static final Totem BEAR_14 = new BearTotem("While you're raging, any creature within 5 feet of you that's hostile to you has disadvantage on attack rolls against targets other than you or another character with this feature. An enemy is immune to this effect if it can't see or hear you or if it can't be frightened.");
    public static final Totem EAGLE_14 = new EagleTotem("While raging, you have a flying speed equal to your current walking speed. This benefit works only in short bursts; you fall if you end your turn in the air and nothing else is holding you aloft.");
    public static final Totem WOLF_14 = new WolfTotem("While you're raging, you can use a bonus action on your turn to knock a Large or smaller creature prone when you hit it with a melee weapon attack.");
    public static final Map<Integer, List<Totem>> ALL_TOTEMS = new MapUtils<Integer, List<Totem>>().add(3, Arrays.asList(BEAR_3, EAGLE_3, WOLF_3)).add(6, Arrays.asList(BEAR_6, EAGLE_6, WOLF_6)).add(14, Arrays.asList(BEAR_14, EAGLE_14, WOLF_14));
}
