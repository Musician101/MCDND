package io.musician101.sponge.mcdnd.equipment.pack;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.currency.CurrencyTypes;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import io.musician101.sponge.mcdnd.equipment.gear.AdventuringGear;
import io.musician101.sponge.mcdnd.equipment.tool.Tools;
import io.musician101.sponge.mcdnd.util.MapUtils;

public class Packs
{
    public static final Pack BURGLARS_PACK = new Pack("Burglar's Pack", new Cost(CurrencyTypes.GOLD, 16), new MapUtils<Equipment, Integer>().add(AdventuringGear.BACKPACK, 1).add(AdventuringGear.BALL_BEARINGS, 1).add(AdventuringGear.STRING, 1).add(AdventuringGear.BELL, 1).add(AdventuringGear.CANDLE, 5).add(AdventuringGear.CROWBAR, 1).add(AdventuringGear.HAMMER, 1).add(AdventuringGear.PITON, 10).add(AdventuringGear.LANTERN_HOODED, 1).add(AdventuringGear.OIL_FLASK, 2).add(AdventuringGear.RATIONS, 5).add(AdventuringGear.TINDERBOX, 1).add(AdventuringGear.WATERSKIN, 1).add(AdventuringGear.ROPE_HEMPEN, 1));
    public static final Pack DIPLOMATS_PACK = new Pack("Diplomat's Pack", new Cost(CurrencyTypes.GOLD, 39), new MapUtils<Equipment, Integer>().add(AdventuringGear.CHEST, 1).add(AdventuringGear.CASE_MAP_SCROLL, 2).add(AdventuringGear.CLOTHES_FINE, 1).add(AdventuringGear.INK, 1).add(AdventuringGear.INK_PEN, 1).add(AdventuringGear.LAMP, 1).add(AdventuringGear.OIL_FLASK, 2).add(AdventuringGear.PAPER, 5).add(AdventuringGear.PERFUME, 1).add(AdventuringGear.SEALING_WAX, 1).add(AdventuringGear.SOAP, 1));
    public static final Pack DUNGEONEERS_PACK = new Pack("Dungeoneer's Pack", new Cost(CurrencyTypes.GOLD, 12), new MapUtils<Equipment, Integer>().add(AdventuringGear.BACKPACK, 1).add(AdventuringGear.CROWBAR, 1).add(AdventuringGear.HAMMER, 1).add(AdventuringGear.PITON, 10).add(AdventuringGear.TORCH, 10).add(AdventuringGear.TINDERBOX, 1).add(AdventuringGear.RATIONS, 10).add(AdventuringGear.WATERSKIN, 1).add(AdventuringGear.ROPE_HEMPEN, 1));
    public static final Pack ENTERTAINERS_PACK = new Pack("Entertainer's Pack", new Cost(CurrencyTypes.GOLD, 40), new MapUtils<Equipment, Integer>().add(AdventuringGear.BACKPACK, 1).add(AdventuringGear.BEDROLL, 1).add(AdventuringGear.CLOTHES_COSTUME, 2).add(AdventuringGear.CANDLE, 5).add(AdventuringGear.RATIONS, 5).add(AdventuringGear.WATERSKIN, 1).add(Tools.DISGUISE_KIT, 1));
    public static final Pack EXPLORERS_PACK = new Pack("Explorer's Pack", new Cost(CurrencyTypes.GOLD, 10), new MapUtils<Equipment, Integer>().add(AdventuringGear.BACKPACK, 1).add(AdventuringGear.BEDROLL, 1).add(AdventuringGear.MESS_KIT, 1).add(AdventuringGear.TINDERBOX, 1).add(AdventuringGear.TORCH, 10).add(AdventuringGear.RATIONS, 10).add(AdventuringGear.WATERSKIN, 1).add(AdventuringGear.ROPE_HEMPEN, 1));
    public static final Pack PRIESTS_PACK = new Pack("Priest's Pack", new Cost(CurrencyTypes.GOLD, 19), new MapUtils<Equipment, Integer>().add(AdventuringGear.BACKPACK, 1).add(AdventuringGear.BLANKET, 1).add(AdventuringGear.CANDLE, 10).add(AdventuringGear.TINDERBOX, 1).add(AdventuringGear.ALMS_BOX, 1).add(AdventuringGear.CENSER, 1).add(AdventuringGear.VESTMENTS, 1).add(AdventuringGear.RATIONS, 2).add(AdventuringGear.WATERSKIN, 1));
    public static final Pack SCHOLARS_PACK = new Pack("Scholar's Pack", new Cost(CurrencyTypes.GOLD, 40), new MapUtils<Equipment, Integer>().add(AdventuringGear.BACKPACK, 1).add(AdventuringGear.BOOK, 1).add(AdventuringGear.INK, 1).add(AdventuringGear.INK_PEN, 1).add(AdventuringGear.PARCHMENT, 10).add(AdventuringGear.LITTLE_BAG_OF_SAND, 1).add(AdventuringGear.SMALL_KNIFE, 1));
}
