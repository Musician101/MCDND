package io.musician101.sponge.mcdnd.equipment.tool;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.type.CurrencyTypes;
import io.musician101.sponge.mcdnd.equipment.tool.Tool.ArtisanTool;
import io.musician101.sponge.mcdnd.equipment.tool.Tool.GamingSet;
import io.musician101.sponge.mcdnd.equipment.tool.Tool.MusicalInstrument;

import java.util.Arrays;
import java.util.List;

//TODO separate into multiple classes
public class Tools
{
    public static final Tool ALCHEMISTS_SUPPLIES = new ArtisanTool("Alchemist's Supplies", new Cost(CurrencyTypes.GOLD, 50), 8);
    public static final Tool BREWERS_SUPPLIES = new ArtisanTool("Brewer's Supplies", new Cost(CurrencyTypes.GOLD, 20),9);
    public static final Tool CALLIGRAPHERS_SUPPLIES = new ArtisanTool("Calligrapher's Supplies", new Cost(CurrencyTypes.GOLD, 10), 5);
    public static final Tool CARPENTERS_TOOLS = new ArtisanTool("Carpenter's Tools", new Cost(CurrencyTypes.GOLD, 8), 6);
    public static final Tool CARTOGRAPHERS_TOOLS = new ArtisanTool("Cartographer's Tools", new Cost(CurrencyTypes.GOLD, 15), 6);
    public static final Tool COBBLERS_TOOLS = new ArtisanTool("Cobbler's Tools", new Cost(CurrencyTypes.GOLD, 5), 5);
    public static final Tool COOKS_UTENSILS = new ArtisanTool("Cook's Utensils", new Cost(CurrencyTypes.GOLD, 1), 8);
    public static final Tool GLASSBLOWERS_TOOLS = new ArtisanTool("Glassblower's Tools", new Cost(CurrencyTypes.GOLD,30), 5);
    public static final Tool JEWELERS_TOOLS = new ArtisanTool("Jeweler's Tools", new Cost(CurrencyTypes.GOLD, 25), 2);
    public static final Tool LEATHERWORKERS_TOOLS = new ArtisanTool("Leatherworker's Tools", new Cost(CurrencyTypes.GOLD, 5), 5);
    public static final Tool MASONS_TOOLS = new ArtisanTool("Mason's Tools", new Cost(CurrencyTypes.GOLD, 10), 8);
    public static final Tool PAINTERS_SUPPLIES = new ArtisanTool("Painter's Supplies", new Cost(CurrencyTypes.GOLD,10), 5);
    public static final Tool POTTERS_TOOLS = new ArtisanTool("Potter's Tools", new Cost(CurrencyTypes.GOLD, 10), 3);
    public static final Tool SMITHS_TOOLS = new ArtisanTool("Smith's Tools", new Cost(CurrencyTypes.GOLD, 20), 8);
    public static final Tool TINKERS_TOOLS = new ArtisanTool("Tinker's Tools", new Cost(CurrencyTypes.GOLD, 50), 10);
    public static final Tool WEAVERS_TOOLS = new ArtisanTool("Weaver's Tools", new Cost(CurrencyTypes.GOLD, 1), 5);
    public static final Tool WOODCARVERS_TOOLS = new ArtisanTool("Woodcarver's Tools", new Cost(CurrencyTypes.GOLD, 1), 5);

    public static final Tool DICE_SET = new GamingSet("Dice Set", new Cost(CurrencyTypes.SILVER, 1), 0);
    public static final Tool DRAGONCHESS_SET = new GamingSet("Dragonchess Set", new Cost(CurrencyTypes.GOLD, 1), 0.5);
    public static final Tool PLAYING_CARD_SET = new GamingSet("Playing Card Set", new Cost(CurrencyTypes.SILVER, 5), 0);
    public static final Tool THREE_DRAGON_ANTE_SET = new GamingSet("Three Dragon Ante Set", new Cost(CurrencyTypes.GOLD, 1), 0);

    public static final Tool BAGPIPES = new MusicalInstrument("Bagpipes", new Cost(CurrencyTypes.GOLD, 30), 6);
    public static final Tool DRUM = new MusicalInstrument("Drum", new Cost(CurrencyTypes.GOLD, 6), 3);
    public static final Tool DULCIMER = new MusicalInstrument("Dulcimer", new Cost(CurrencyTypes.GOLD, 25), 10);
    public static final Tool FLUTE = new MusicalInstrument("Flute", new Cost(CurrencyTypes.GOLD, 2), 1);
    public static final Tool LUTE = new MusicalInstrument("Lute", new Cost(CurrencyTypes.GOLD, 35), 2);
    public static final Tool LYRE = new MusicalInstrument("Lyre", new Cost(CurrencyTypes.GOLD, 30), 2);
    public static final Tool HORN = new MusicalInstrument("Horn", new Cost(CurrencyTypes.GOLD, 3), 2);
    public static final Tool PAN_FLUTE = new MusicalInstrument("Pan Flute", new Cost(CurrencyTypes.GOLD, 12), 2);
    public static final Tool SHAWM = new MusicalInstrument("Shawm", new Cost(CurrencyTypes.GOLD, 2), 1);
    public static final Tool VIOL = new MusicalInstrument("Viol", new Cost(CurrencyTypes.GOLD, 30), 1);

    public static final Tool DISGUISE_KIT = new Tool("Disguise Kit", new Cost(CurrencyTypes.GOLD, 25), 3);
    public static final Tool FORGERY_KIT = new Tool("Forgery Kit", new Cost(CurrencyTypes.GOLD, 15), 5);
    public static final Tool HERBALISM_KIT = new Tool("Herbalism Kit", new Cost(CurrencyTypes.GOLD, 5), 3);
    public static final Tool NAVIGATORS_TOOLS = new Tool("Navigator's Tools", new Cost(CurrencyTypes.GOLD, 25), 2);
    public static final Tool POISONERS_KIT = new Tool("Poisoner's Kit", new Cost(CurrencyTypes.GOLD, 50), 2);
    public static final Tool THIEVES_TOOLS = new Tool("Thieve's Tools", new Cost(CurrencyTypes.GOLD, 25), 1);

    public static List<Tool> getArtisanTools()
    {
        return Arrays.asList(ALCHEMISTS_SUPPLIES, BREWERS_SUPPLIES, CALLIGRAPHERS_SUPPLIES, CARPENTERS_TOOLS, CARTOGRAPHERS_TOOLS, COBBLERS_TOOLS, COOKS_UTENSILS, GLASSBLOWERS_TOOLS, JEWELERS_TOOLS, LEATHERWORKERS_TOOLS,    MASONS_TOOLS, PAINTERS_SUPPLIES, POTTERS_TOOLS, SMITHS_TOOLS, TINKERS_TOOLS, WEAVERS_TOOLS,    WOODCARVERS_TOOLS);
    }

    public static List<Tool> getGamingSets()
    {
        return Arrays.asList(DICE_SET, DRAGONCHESS_SET, PLAYING_CARD_SET, THREE_DRAGON_ANTE_SET);
    }

    public static List<Tool> getMusicalInstruments()
    {
        return Arrays.asList(BAGPIPES, DRUM, DULCIMER, FLUTE, LUTE, LYRE, HORN, PAN_FLUTE, SHAWM, VIOL);
    }

    public static List<Tool> getMiscTools()
    {
        return Arrays.asList(DISGUISE_KIT, FORGERY_KIT, HERBALISM_KIT, NAVIGATORS_TOOLS, POISONERS_KIT,    THIEVES_TOOLS);
    }
}
