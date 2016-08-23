package io.musician101.sponge.mcdnd.equipment.tool;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.type.CurrencyTypes;
import io.musician101.sponge.mcdnd.equipment.tool.Tool.ArtisanTool;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArtisanTools
{
    public static final ArtisanTool ALCHEMISTS_SUPPLIES = new ArtisanTool("Alchemist's Supplies", new Cost(CurrencyTypes.GOLD, 50), 8);
    public static final ArtisanTool BREWERS_SUPPLIES = new ArtisanTool("Brewer's Supplies", new Cost(CurrencyTypes.GOLD, 20),9);
    public static final ArtisanTool CALLIGRAPHERS_SUPPLIES = new ArtisanTool("Calligrapher's Supplies", new Cost(CurrencyTypes.GOLD, 10), 5);
    public static final ArtisanTool CARPENTERS_TOOLS = new ArtisanTool("Carpenter's Tools", new Cost(CurrencyTypes.GOLD, 8), 6);
    public static final ArtisanTool CARTOGRAPHERS_TOOLS = new ArtisanTool("Cartographer's Tools", new Cost(CurrencyTypes.GOLD, 15), 6);
    public static final ArtisanTool COBBLERS_TOOLS = new ArtisanTool("Cobbler's Tools", new Cost(CurrencyTypes.GOLD, 5), 5);
    public static final ArtisanTool COOKS_UTENSILS = new ArtisanTool("Cook's Utensils", new Cost(CurrencyTypes.GOLD, 1), 8);
    public static final ArtisanTool GLASSBLOWERS_TOOLS = new ArtisanTool("Glassblower's Tools", new Cost(CurrencyTypes.GOLD,30), 5);
    public static final ArtisanTool JEWELERS_TOOLS = new ArtisanTool("Jeweler's Tools", new Cost(CurrencyTypes.GOLD, 25), 2);
    public static final ArtisanTool LEATHERWORKERS_TOOLS = new ArtisanTool("Leatherworker's Tools", new Cost(CurrencyTypes.GOLD, 5), 5);
    public static final ArtisanTool MASONS_TOOLS = new ArtisanTool("Mason's Tools", new Cost(CurrencyTypes.GOLD, 10), 8);
    public static final ArtisanTool PAINTERS_SUPPLIES = new ArtisanTool("Painter's Supplies", new Cost(CurrencyTypes.GOLD,10), 5);
    public static final ArtisanTool POTTERS_TOOLS = new ArtisanTool("Potter's Tools", new Cost(CurrencyTypes.GOLD, 10), 3);
    public static final ArtisanTool SMITHS_TOOLS = new ArtisanTool("Smith's Tools", new Cost(CurrencyTypes.GOLD, 20), 8);
    public static final ArtisanTool TINKERS_TOOLS = new ArtisanTool("Tinker's Tools", new Cost(CurrencyTypes.GOLD, 50), 10);
    public static final ArtisanTool WEAVERS_TOOLS = new ArtisanTool("Weaver's Tools", new Cost(CurrencyTypes.GOLD, 1), 5);
    public static final ArtisanTool WOODCARVERS_TOOLS = new ArtisanTool("Woodcarver's Tools", new Cost(CurrencyTypes.GOLD, 1), 5);
    public static final List<ArtisanTool> ALL = Collections.unmodifiableList(Arrays.asList(ALCHEMISTS_SUPPLIES, BREWERS_SUPPLIES, CALLIGRAPHERS_SUPPLIES, CARPENTERS_TOOLS, CARTOGRAPHERS_TOOLS, COBBLERS_TOOLS, COOKS_UTENSILS, GLASSBLOWERS_TOOLS, JEWELERS_TOOLS, LEATHERWORKERS_TOOLS, MASONS_TOOLS, PAINTERS_SUPPLIES, POTTERS_TOOLS, SMITHS_TOOLS, TINKERS_TOOLS, WEAVERS_TOOLS, WOODCARVERS_TOOLS));

    private ArtisanTools()
    {

    }
}
