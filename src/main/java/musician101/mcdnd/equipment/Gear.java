package musician101.mcdnd.equipment;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.currency.CurrencyType;

/** Need to switch over to classes rather than enum */
@Deprecated
public enum Gear
{
	ABACUS("Abacus", new Cost(CurrencyType.GOLD, 2), 2),
	ACID_VIAL("Acid (Vial)", new Cost(CurrencyType.GOLD, 25)),
	ALCHEMIST_S_FIRE_FLASK("Alchemist's Fire (Flask)", new Cost(CurrencyType.GOLD, 50)),
	ARROWS("Arrows", 20, new Cost(CurrencyType.GOLD, 1)),
	BLOWGUN_NEEDLES("Blowgun Needles", 50, new Cost(CurrencyType.GOLD, 1)),
	CROSSBOW_BOLTS("Crossbow Bolts", 20, 1.5),
	SLING_BULLETS("Sling Bullets", new Cost(CurrencyType.COPPER, 4), 1.5),
	ANTITOXIN_VIAL("Antitoxin (Vial)", new Cost(CurrencyType.GOLD, 50), 0),
	ARCANE_FOCUS_Crystal("Arcane Focus (Crystal)", new Cost(CurrencyType.GOLD, 10)),
	ARCANE_FOCUS_ORB("Arcane Focus (Orb)", new Cost(CurrencyType.GOLD, 20), 3),
	ARCANE_FOCUS_ROD("Arcane Focus (Rod)", new Cost(CurrencyType.GOLD, 10), 2),
	ARCANE_FOCUS_STAFF("Arcane Focus (Staff)", new Cost(CurrencyType.GOLD, 5), 4),
	ARCANE_FOCUS_WAND("Arcane Focus (Wand)", new Cost(CurrencyType.GOLD, 10)),
	BACKPACK("Backpack", new Cost(CurrencyType.GOLD, 2), 5),
	BARREL("Barrel", new Cost(CurrencyType.GOLD, 2), 70),
	BASKET("Basket", new Cost(CurrencyType.SILVER, 4), 2),
	BEDROLL("Bedroll", 7),
	BELL("Bell", 0),
	BLANKET("Blanket", new Cost(CurrencyType.SILVER, 5), 3),
	BLOCK_AND_TACKLE("Block and Tackle", 5),
	BOOK("Book", new Cost(CurrencyType.GOLD, 25), 5),
	GLASS_BOTTLE("Glass Bottle", new Cost(CurrencyType.GOLD, 2), 2),
	BUCKET("Bucket", new Cost(CurrencyType.COPPER, 5), 2),
	CALTROPS("Caltrops", 20, 2),
	CANDLE("Candle", new Cost(CurrencyType.COPPER, 1), 0),
	CASE_CROSSBOW_BOLT("Crossbow Bolt Case"),
	CASE_MAP_SCROLL("Map/Scroll Case"),
	CHAIN("Chain", 10, new Cost(CurrencyType.GOLD, 5), 10),
	CHALK("Chalk", new Cost(CurrencyType.COPPER, 1), 0),
	CHEST("Chest", new Cost(CurrencyType.GOLD, 5), 25),
	CLIMBERS_KIT("Climber's Kit", new Cost(CurrencyType.GOLD, 25), 12),
	CLOTHES_COMMON("Common Clothes", new Cost(CurrencyType.SILVER, 5), 3),
	CLOTHES_COSTUME("Costume Clothes", new Cost(CurrencyType.GOLD, 5), 4),
	CLOTHES_FINE("Fine Clothes", new Cost(CurrencyType.GOLD, 15), 6),
	CLOTHES_TRAVELERS("Traveler's Clothes", new Cost(CurrencyType.GOLD, 2), 4),
	COMPONENT_POUCH("Component Pouch", new Cost(CurrencyType.GOLD, 25), 2),
	CROWBAR("Crowbar", new Cost(CurrencyType.GOLD, 2), 5),
	DRUIDIC_FOCUS_SPRIG_MISTLETOE("Druidic Focus (Sprig of Mistletoe)", 0),
	DRUIDIC_FOCUS_TOTEM("Druidic Focus (Totem)", 0),
	DRUIDIC_FOCUS_WOODEN_STAFF("Druidic Focus (Wooden Staff)", new Cost(CurrencyType.GOLD, 5), 4),
	DRUIDIC_FOCUS_YEW_WAND("Yew Wand", new Cost(CurrencyType.GOLD, 10)),
	FISHING_TACKLE("Fishing Tackle", 4),
	FLASK_TANKARD("Flask/Tankard", new Cost(CurrencyType.COPPER, 2)),
	GRAPPLING_HOOK("Grappling Hook", new Cost(CurrencyType.GOLD, 2), 4),
	HAMMER("Hammer", 3),
	HAMMER_SLEDGE("Sledge Hammer", new Cost(CurrencyType.GOLD, 2), 10),
	HEALERS_KIT("Healer's Kit", new Cost(CurrencyType.GOLD, 5), 3),
	HOLY_SYMBOL_AMULET("Holy Symbol (Amulet)", new Cost(CurrencyType.GOLD, 5)),
	HOLY_SYMBOL_EMBLEM("Holy Symbol (Emblem)", new Cost(CurrencyType.GOLD, 5), 0),
	HOLY_SYMBOL_RELIQUARY("Holy Symbol (Reliquary)", new Cost(CurrencyType.GOLD, 5), 2),
	HOLY_WATER("Flask of Holy Water", new Cost(CurrencyType.GOLD, 25)),
	HOURGLASS("Hourglass", new Cost(CurrencyType.GOLD, 25)),
	HUNTING_TRAP("Hunting Trap", new Cost(CurrencyType.GOLD, 5), 25),
	INK("Ink (1 ounce bottle)", new Cost(CurrencyType.GOLD, 10), 0),
	INK_PEN("Ink Pen", new Cost(CurrencyType.COPPER, 2), 0),
	JUG_PITCHER("Jug/Pitcher", new Cost(CurrencyType.COPPER, 2), 4),
	LADDER("Ladder", 10, new Cost(CurrencyType.SILVER, 1), 25),
	LAMP("Lamp", new Cost(CurrencyType.SILVER, 5)),
	LANTERN_BULLSEYE("Bullseye Lantern", new Cost(CurrencyType.GOLD, 10), 2),
	LANTERN_HOODED("Hooded Lantern", new Cost(CurrencyType.GOLD, 5), 2),
	LOCK("Lock", new Cost(CurrencyType.GOLD, 10)),
	MAGNIFYING_GLASS("Magnifying Glass", new Cost(CurrencyType.GOLD, 100)),
	MANACLES("Manacles", new Cost(CurrencyType.GOLD, 2), 6),
	MESS_KIT("Mess Kit", new Cost(CurrencyType.GOLD, 2)),
	MIRROR_STEEL("Steel Mirror", new Cost(CurrencyType.GOLD, 5), 0.5),
	OIL_FLASK("Oil Flask", new Cost(CurrencyType.SILVER, 1)),
	PAPER("Paper", new Cost(CurrencyType.SILVER, 2), 0),
	PARCHMENT("Parchment", new Cost(CurrencyType.SILVER, 1), 0),
	PERFUME("Perfume (vial)", new Cost(CurrencyType.GOLD, 5), 0),
	MINERS_PICK("Miner's Pick", new Cost(CurrencyType.GOLD, 2), 10),
	PITON("Piton", new Cost(CurrencyType.COPPER, 5), 0.25),
	POISON_BASIC("Basic Poison (vial)", new Cost(CurrencyType.GOLD, 100), 0),
	POLE("Pole", 10, new Cost(CurrencyType.COPPER, 5), 7),
	POT_IRON("Iron Pot", new Cost(CurrencyType.GOLD, 2), 10),
	POTION_HEALING("Potion of Healing", new Cost(CurrencyType.GOLD, 50), 0.5),
	POUCH("Pouch", new Cost(CurrencyType.SILVER, 5)),
	QUIVER("Quiver"),
	RAM_PORTABLE("Portable Ram", new Cost(CurrencyType.GOLD, 4), 35),
	RATIONS("Rations", new Cost(CurrencyType.SILVER, 5), 2),
	ROBES("Robes", 4),
	ROPE_HEMPEN("Hempen Rope", 50, 10),
	ROPE_SILK("Silk Rope", 50, new Cost(CurrencyType.GOLD, 10), 5),
	SACK("Sack", new Cost(CurrencyType.COPPER, 1), 0.5),
	SCALE_MERCHANTS("Merchant's Sack", new Cost(CurrencyType.GOLD, 5), 3),
	SEALING_WAX("Sealing Wax", new Cost(CurrencyType.SILVER, 5), 0),
	SHOVEL("Shovel", new Cost(CurrencyType.GOLD, 2), 5),
	SIGNAL_WHISTLE("Signal Whistle", new Cost(CurrencyType.COPPER, 5), 0),
	SIGNET_RING("Signet Ring", new Cost(CurrencyType.GOLD, 5), 0),
	SOAP("Soap", new Cost(CurrencyType.COPPER, 2), 0),
	SPELLBOOK("Spellbook", new Cost(CurrencyType.GOLD, 50), 3),
	SPIKES_IRON("Iron Spikes", 10, 5),
	SPYGLASS("Spyglass", new Cost(CurrencyType.GOLD, 1000)),
	TENT_TWO_PERSON("Two-Person Tent", new Cost(CurrencyType.GOLD, 2), 20),
	TINDERBOX("Tinderbox", new Cost(CurrencyType.SILVER, 5)),
	TORCH("Torch", new Cost(CurrencyType.COPPER, 1)),
	VIAL("Vial", 0),
	WATERSKIN("Waterskin", new Cost(CurrencyType.SILVER, 2), 5),
	WHETSTONE("Whetstone", new Cost(CurrencyType.COPPER, 1));
	
	Cost cost;
	double weight;
	double amount;
	String name;
	
	private Gear(String name)
	{
		this(name, new Cost(CurrencyType.GOLD, 1));
	}
	
	private Gear(String name, Cost cost)
	{
		this(name, cost, 1);
	}
	
	private Gear(String name, double weight)
	{
		this(name, new Cost(CurrencyType.GOLD, 1), weight);
	}
	
	private Gear(String name, double amount, double weight)
	{
		this(name, amount, new Cost(CurrencyType.GOLD, 1), weight);
	}
	
	private Gear(String name, double amount, Cost cost)
	{
		this(name, amount, cost, 1);
	}
	
	private Gear(String name, Cost cost, double weight)
	{
		this(name, 1, cost, weight);
	}
	
	private Gear(String name, double amount, Cost cost, double weight)
	{
		this.name = name;
		this.cost = cost;
		this.weight = weight;
		this.amount = amount;
	}
}
