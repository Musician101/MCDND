package io.musician101.mcdnd.sponge.equipment.pack;

import com.google.common.collect.ImmutableMap;
import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.type.CurrencyTypes;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import io.musician101.mcdnd.sponge.equipment.gear.AdventuringGear;
import io.musician101.mcdnd.sponge.equipment.tool.Tools;

public class Packs
{
    public static final Pack BURGLARS_PACK = new Pack("Burglar's Pack", new Cost(CurrencyTypes.GOLD, 16),
            ImmutableMap.<Equipment, Integer>builder().put(AdventuringGear.BACKPACK, 1).put(AdventuringGear.BALL_BEARINGS, 1)
                    .put(AdventuringGear.STRING, 1).put(AdventuringGear.BELL, 1).put(AdventuringGear.CANDLE, 5)
                    .put(AdventuringGear.CROWBAR, 1).put(AdventuringGear.HAMMER, 1).put(AdventuringGear.PITON, 10)
                    .put(AdventuringGear.LANTERN_HOODED, 1).put(AdventuringGear.OIL_FLASK, 2).put(AdventuringGear.RATIONS, 5)
                    .put(AdventuringGear.TINDERBOX, 1).put(AdventuringGear.WATERSKIN, 1).put(AdventuringGear.ROPE_HEMPEN, 1)
                    .build());
    public static final Pack DIPLOMATS_PACK = new Pack("Diplomat's Pack", new Cost(CurrencyTypes.GOLD, 39),
            ImmutableMap.<Equipment, Integer>builder().put(AdventuringGear.CHEST, 1).put(AdventuringGear.CASE_MAP_SCROLL, 2)
                    .put(AdventuringGear.CLOTHES_FINE, 1).put(AdventuringGear.INK, 1).put(AdventuringGear.INK_PEN, 1)
                    .put(AdventuringGear.LAMP, 1).put(AdventuringGear.OIL_FLASK, 2).put(AdventuringGear.PAPER, 5)
                    .put(AdventuringGear.PERFUME, 1).put(AdventuringGear.SEALING_WAX, 1).put(AdventuringGear.SOAP, 1)
                    .build());
    public static final Pack DUNGEONEERS_PACK = new Pack("Dungeoneer's Pack", new Cost(CurrencyTypes.GOLD, 12),
            ImmutableMap.<Equipment, Integer>builder().put(AdventuringGear.BACKPACK, 1).put(AdventuringGear.CROWBAR, 1)
                    .put(AdventuringGear.HAMMER, 1).put(AdventuringGear.PITON, 10).put(AdventuringGear.TORCH, 10)
                    .put(AdventuringGear.TINDERBOX, 1).put(AdventuringGear.RATIONS, 10).put(AdventuringGear.WATERSKIN, 1)
                    .put(AdventuringGear.ROPE_HEMPEN, 1).build());
    public static final Pack ENTERTAINERS_PACK = new Pack("Entertainer's Pack", new Cost(CurrencyTypes.GOLD, 40),
            ImmutableMap.<Equipment, Integer>builder().put(AdventuringGear.BACKPACK, 1).put(AdventuringGear.BEDROLL, 1)
                    .put(AdventuringGear.CLOTHES_COSTUME, 2).put(AdventuringGear.CANDLE, 5)
                    .put(AdventuringGear.RATIONS, 5).put(AdventuringGear.WATERSKIN, 1)
                    .put(Tools.DISGUISE_KIT, 1).build());
    public static final Pack EXPLORERS_PACK = new Pack("Explorer's Pack", new Cost(CurrencyTypes.GOLD, 10),
            ImmutableMap.<Equipment, Integer>builder().put(AdventuringGear.BACKPACK, 1).put(AdventuringGear.BEDROLL, 1)
                    .put(AdventuringGear.MESS_KIT, 1).put(AdventuringGear.TINDERBOX, 1).put(AdventuringGear.TORCH, 10)
                    .put(AdventuringGear.RATIONS, 10).put(AdventuringGear.WATERSKIN, 1).put(AdventuringGear.ROPE_HEMPEN, 1)
                    .build());
    public static final Pack PRIESTS_PACK = new Pack("Priest's Pack", new Cost(CurrencyTypes.GOLD, 19),
            ImmutableMap.<Equipment, Integer>builder().put(AdventuringGear.BACKPACK, 1).put(AdventuringGear.BLANKET, 1)
                    .put(AdventuringGear.CANDLE, 10).put(AdventuringGear.TINDERBOX, 1).put(AdventuringGear.ALMS_BOX, 1)
                    .put(AdventuringGear.CENSER, 1).put(AdventuringGear.VESTMENTS, 1).put(AdventuringGear.RATIONS, 2)
                    .put(AdventuringGear.WATERSKIN, 1).build());
    public static final Pack SCHOLARS_PACK = new Pack("Scholar's Pack", new Cost(CurrencyTypes.GOLD, 40),
            ImmutableMap.<Equipment, Integer>builder().put(AdventuringGear.BACKPACK, 1).put(AdventuringGear.BOOK, 1)
                    .put(AdventuringGear.INK, 1).put(AdventuringGear.INK_PEN, 1).put(AdventuringGear.PARCHMENT, 10)
                    .put(AdventuringGear.LITTLE_BAG_OF_SAND, 1).put(AdventuringGear.SMALL_KNIFE, 1).build());

    private Packs()
    {

    }
}
