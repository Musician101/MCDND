package musician101.mcdnd.equipment.tool;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.currency.CurrencyType;
import musician101.mcdnd.equipment.Equipment;

public class Tool extends Equipment
{
	public static final ArtisanTool ALCHEMISTS_SUPPLIES = new ArtisanTool("Aclhemist's Supplies", new Cost(CurrencyType.GOLD, 50), 8);
	public static final ArtisanTool BREWERS_SUPPLIES = new ArtisanTool("Brewer's Supplies", new Cost(CurrencyType.GOLD, 20), 9);
	public static final ArtisanTool CALLIGRAPHERS_SUPPLIES = new ArtisanTool("Calligrapher's Supplies", new Cost(CurrencyType.GOLD, 10), 5);
	public static final ArtisanTool CARPENTERS_TOOLS = new ArtisanTool("Carpenter's Tools", new Cost(CurrencyType.GOLD, 8), 6);
	public static final ArtisanTool CARTOGRAPHERS_TOOLS = new ArtisanTool("Cartographer's Tools", new Cost(CurrencyType.GOLD, 15), 6);
	public static final ArtisanTool COBBLERS_TOOLS = new ArtisanTool("Cobbler's Tools", new Cost(CurrencyType.GOLD, 5), 5);
	public static final ArtisanTool COOKS_UTENSILS = new ArtisanTool("Cook's Utensils", new Cost(CurrencyType.GOLD, 1), 8);
	public static final ArtisanTool GLASSBLOWERS_TOOLS = new ArtisanTool("Glassblower's Tools", new Cost(CurrencyType.GOLD, 30), 5);
	public static final ArtisanTool JEWELERS_TOOLS = new ArtisanTool("Jeweler's Tools", new Cost(CurrencyType.GOLD, 25), 2);
	public static final ArtisanTool LEATHERWORKERS_TOOLS = new ArtisanTool("Leatherworker's Tools", new Cost(CurrencyType.GOLD, 5), 5);
	public static final ArtisanTool MASONS_TOOLS = new ArtisanTool("Mason's Tools", new Cost(CurrencyType.GOLD, 10), 8);
	public static final ArtisanTool PAINTERS_SUPPLIES = new ArtisanTool("Painter's Supplies", new Cost(CurrencyType.GOLD, 10), 5);
	public static final ArtisanTool POTTERS_TOOLS = new ArtisanTool("Potter's Tools", new Cost(CurrencyType.GOLD, 10), 3);
	public static final ArtisanTool SMITHS_TOOLS = new ArtisanTool("Smith's Tools", new Cost(CurrencyType.GOLD, 20), 8);
	public static final ArtisanTool TINKERS_TOOLS = new ArtisanTool("Tinker's Tools", new Cost(CurrencyType.GOLD, 50), 10);
	public static final ArtisanTool WEAVERS_TOOLS = new ArtisanTool("Weaver's Tools", new Cost(CurrencyType.GOLD, 1), 5);
	public static final ArtisanTool WOODCARVERS_TOOLS = new ArtisanTool("Woodcarver's Tools", new Cost(CurrencyType.GOLD, 1), 5);
	
	public static final GamingSet DICE_SET = new GamingSet("Dice Set", new Cost(CurrencyType.SILVER, 1), 0);
	public static final GamingSet DRAGONCHESS_SET = new GamingSet("Dragonchess Set", new Cost(CurrencyType.GOLD, 1), 0.5);
	public static final GamingSet PLAYING_CARD_SET = new GamingSet("Playing Card Set", new Cost(CurrencyType.SILVER, 5), 0);
	public static final GamingSet THREE_DRAGON_ANTE_SET = new GamingSet("Three Dragon Ante Set", new Cost(CurrencyType.GOLD, 1), 0);
	
	public static final MusicalInstrument BAGPIPES = new MusicalInstrument("Bagpipes", new Cost(CurrencyType.GOLD, 30), 6);
	public static final MusicalInstrument DRUM = new MusicalInstrument("Drum", new Cost(CurrencyType.GOLD, 6), 3);
	public static final MusicalInstrument DULCIMER = new MusicalInstrument("Dulcimer", new Cost(CurrencyType.GOLD, 25), 10);
	public static final MusicalInstrument FLUTE = new MusicalInstrument("Flute", new Cost(CurrencyType.GOLD, 2), 1);
	public static final MusicalInstrument LUTE = new MusicalInstrument("Lute", new Cost(CurrencyType.GOLD, 35), 2);
	public static final MusicalInstrument LYRE = new MusicalInstrument("Lyre", new Cost(CurrencyType.GOLD, 30), 2);
	public static final MusicalInstrument HORN = new MusicalInstrument("Horn", new Cost(CurrencyType.GOLD, 3), 2);
	public static final MusicalInstrument PAN_FLUTE = new MusicalInstrument("Pan Flute", new Cost(CurrencyType.GOLD, 12), 2);
	public static final MusicalInstrument SHAWM = new MusicalInstrument("Shawm", new Cost(CurrencyType.GOLD, 2), 1);
	public static final MusicalInstrument VIOL = new MusicalInstrument("Viol", new Cost(CurrencyType.GOLD, 30), 1);
	
	public static final Tool DISGUISE_KIT = new Tool("Disguise Kit", new Cost(CurrencyType.GOLD, 25), 3);
	public static final Tool FORGERY_KIT = new Tool("Forgery Kit", new Cost(CurrencyType.GOLD, 15), 5);
	public static final Tool HERBALISM_KIT = new Tool("Herbalism Kit", new Cost(CurrencyType.GOLD, 5), 3);
	public static final Tool NAVIGATORS_TOOLS = new Tool("Navigator's Tools", new Cost(CurrencyType.GOLD, 25), 2);
	public static final Tool POISONERS_KIT = new Tool("Poisoner's Kit", new Cost(CurrencyType.GOLD, 50), 2);
	public static final Tool THIEVES_TOOLS = new Tool("Thieve's Tools", new Cost(CurrencyType.GOLD, 25), 1);
	
	public Tool(String name, Cost cost, double weight)
	{
		super(name, cost, weight);
	}
	
	public static class ArtisanTool extends Tool
	{
		public ArtisanTool(String name, Cost cost, double weight)
		{
			super(name, cost, weight);
		}
	}
	
	public static class GamingSet extends Tool
	{
		public GamingSet(String name, Cost cost, double weight)
		{
			super(name, cost, weight);
		}
	}
	
	public static class MusicalInstrument extends Tool
	{
		public MusicalInstrument(String name, Cost cost, double weight)
		{
			super(name, cost, weight);
		}
	}
}
