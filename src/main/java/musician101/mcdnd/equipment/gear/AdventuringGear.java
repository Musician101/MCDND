package musician101.mcdnd.equipment.gear;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.currency.CurrencyType;
import musician101.mcdnd.equipment.gear.Gear.AmmunitionGear;
import musician101.mcdnd.equipment.gear.Gear.ArcaneFocusGear;
import musician101.mcdnd.equipment.gear.Gear.BundledGear;
import musician101.mcdnd.equipment.gear.Gear.DruidicFocusGear;

public class AdventuringGear
{
    public static final Gear ABACUS = new Gear("Abacus", new Cost(CurrencyType.GOLD, 2), 2);
    public static final Gear ACID_VIAL = new Gear("Acid (Vial)", new Cost(CurrencyType.GOLD, 25), 1);
    public static final Gear ALCHEMIST_S_FIRE_FLASK = new Gear("Alchemist's Fire (Flask)", new Cost(CurrencyType
            .GOLD, 50), 1);
    public static final Gear ALMS_BOX = new Gear("Alms Box", new Cost(CurrencyType.GOLD, 0), 0);
    public static final Gear ARROWS = new AmmunitionGear("Arrows", 20, new Cost(CurrencyType.GOLD, 1), 1);
    public static final Gear BLOWGUN_NEEDLES = new AmmunitionGear("Blowgun Needles", 50, new Cost(CurrencyType.GOLD,
            1), 1);
    public static final Gear CROSSBOW_BOLTS = new AmmunitionGear("Crossbow Bolts", 20, new Cost(CurrencyType.GOLD, 1)
            , 1.5);
    public static final Gear SLING_BULLETS = new AmmunitionGear("Sling Bullets", 20, new Cost(CurrencyType.COPPER, 4)
            , 1.5);
    public static final Gear ANTITOXIN_VIAL = new Gear("Antitoxin (Vial)", new Cost(CurrencyType.GOLD, 50), 0);
    public static final Gear ARCANE_FOCUS_CRYSTAL = new ArcaneFocusGear("Arcane Focus (Crystal)", new Cost
            (CurrencyType.GOLD, 10), 1);
    public static final Gear ARCANE_FOCUS_ORB = new ArcaneFocusGear("Arcane Focus (Orb)", new Cost(CurrencyType.GOLD,
            20), 3);
    public static final Gear ARCANE_FOCUS_ROD = new ArcaneFocusGear("Arcane Focus (Rod)", new Cost(CurrencyType.GOLD,
            10), 2);
    public static final Gear ARCANE_FOCUS_STAFF = new ArcaneFocusGear("Arcane Focus (Staff)", new Cost(CurrencyType
            .GOLD, 5), 4);
    public static final Gear ARCANE_FOCUS_WAND = new ArcaneFocusGear("Arcane Focus (Wand)", new Cost(CurrencyType
            .GOLD, 10), 1);
    public static final Gear BACKPACK = new Gear("Backpack", new Cost(CurrencyType.GOLD, 2), 5);
    public static final Gear BALL_BEARINGS = new BundledGear("Ball Bearings (bag of 1,000)", 1000, new Cost
            (CurrencyType.GOLD, 1), 2);
    public static final Gear BARREL = new Gear("Barrel", new Cost(CurrencyType.GOLD, 2), 70);
    public static final Gear BASKET = new Gear("Basket", new Cost(CurrencyType.SILVER, 4), 2);
    public static final Gear BEDROLL = new Gear("Bedroll", new Cost(CurrencyType.GOLD, 1), 7);
    public static final Gear BELL = new Gear("Bell", new Cost(CurrencyType.GOLD, 1), 0);
    public static final Gear BLANKET = new Gear("Blanket", new Cost(CurrencyType.SILVER, 5), 3);
    public static final Gear BLOCK_AND_TACKLE = new Gear("Block and Tackle", new Cost(CurrencyType.GOLD, 1), 5);
    public static final Gear BOOK = new Gear("Book", new Cost(CurrencyType.GOLD, 25), 5);
    public static final Gear GLASS_BOTTLE = new Gear("Glass Bottle", new Cost(CurrencyType.GOLD, 2), 2);
    public static final Gear BUCKET = new Gear("Bucket", new Cost(CurrencyType.COPPER, 5), 2);
    public static final Gear CALTROPS = new BundledGear("Caltrops (bag of 20)", 20, new Cost(CurrencyType.GOLD, 1), 2);
    public static final Gear CANDLE = new Gear("Candle", new Cost(CurrencyType.COPPER, 1), 0);
    public static final Gear CASE_CROSSBOW_BOLT = new Gear("Crossbow Bolt Case", new Cost(CurrencyType.GOLD, 1), 1);
    public static final Gear CASE_MAP_SCROLL = new Gear("Map/Scroll Case", new Cost(CurrencyType.GOLD, 1), 1);
    public static final Gear CENSER = new Gear("Censer", new Cost(CurrencyType.GOLD, 0), 0);
    public static final Gear CHAIN = new BundledGear("Chain (10 feet)", 10, new Cost(CurrencyType.GOLD, 5), 10);
    public static final Gear CHALK = new BundledGear("Chalk (1 piece)", 1, new Cost(CurrencyType.COPPER, 1), 0);
    public static final Gear CHEST = new Gear("Chest", new Cost(CurrencyType.GOLD, 5), 25);
    public static final Gear CLIMBERS_KIT = new Gear("Climber's Kit", new Cost(CurrencyType.GOLD, 25), 12);
    public static final Gear CLOTHES_COMMON = new Gear("Common Clothes", new Cost(CurrencyType.SILVER, 5), 3);
    public static final Gear CLOTHES_COSTUME = new Gear("Costume Clothes", new Cost(CurrencyType.GOLD, 5), 4);
    public static final Gear CLOTHES_FINE = new Gear("Fine Clothes", new Cost(CurrencyType.GOLD, 15), 6);
    public static final Gear CLOTHES_TRAVELERS = new Gear("Traveler's Clothes", new Cost(CurrencyType.GOLD, 2), 4);
    public static final Gear COMPONENT_POUCH = new Gear("Component Pouch", new Cost(CurrencyType.GOLD, 25), 2);
    public static final Gear CROWBAR = new Gear("Crowbar", new Cost(CurrencyType.GOLD, 2), 5);
    public static final Gear DRUIDIC_FOCUS_SPRIG_MISTLETOE = new DruidicFocusGear("Sprig of Mistletoe", new Cost
            (CurrencyType.GOLD, 1), 0);
    public static final Gear DRUIDIC_FOCUS_TOTEM = new DruidicFocusGear("Totem", new Cost(CurrencyType.GOLD, 1), 0);
    public static final Gear DRUIDIC_FOCUS_WOODEN_STAFF = new DruidicFocusGear("Wooden Staff", new Cost(CurrencyType
            .GOLD, 5), 4);
    public static final Gear DRUIDIC_FOCUS_YEW_WAND = new DruidicFocusGear("Yew Wand", new Cost(CurrencyType.GOLD,
            10), 1);
    public static final Gear FISHING_TACKLE = new Gear("Fishing Tackle", new Cost(CurrencyType.GOLD, 1), 4);
    public static final Gear FLASK_TANKARD = new Gear("Flask/Tankard", new Cost(CurrencyType.COPPER, 2), 1);
    public static final Gear GRAPPLING_HOOK = new Gear("Grappling Hook", new Cost(CurrencyType.GOLD, 2), 4);
    public static final Gear HAMMER = new Gear("Hammer", new Cost(CurrencyType.GOLD, 1), 3);
    public static final Gear HAMMER_SLEDGE = new Gear("Sledge Hammer", new Cost(CurrencyType.GOLD, 2), 10);
    public static final Gear HEALERS_KIT = new Gear("Healer's Kit", new Cost(CurrencyType.GOLD, 5), 3);
    public static final Gear HOLY_SYMBOL_AMULET = new Gear("Holy Symbol (Amulet)", new Cost(CurrencyType.GOLD, 5), 1);
    public static final Gear HOLY_SYMBOL_EMBLEM = new Gear("Holy Symbol (Emblem)", new Cost(CurrencyType.GOLD, 5), 0);
    public static final Gear HOLY_SYMBOL_RELIQUARY = new Gear("Holy Symbol (Reliquary)", new Cost(CurrencyType.GOLD,
            5), 2);
    public static final Gear HOLY_WATER = new Gear("Flask of Holy Water", new Cost(CurrencyType.GOLD, 25), 1);
    public static final Gear HOURGLASS = new Gear("Hourglass", new Cost(CurrencyType.GOLD, 25), 1);
    public static final Gear HUNTING_TRAP = new Gear("Hunting Trap", new Cost(CurrencyType.GOLD, 5), 25);
    public static final Gear INK = new Gear("Ink (1 ounce bottle)", new Cost(CurrencyType.GOLD, 10), 0);
    public static final Gear INK_PEN = new Gear("Ink Pen", new Cost(CurrencyType.COPPER, 2), 0);
    public static final Gear JUG_PITCHER = new Gear("Jug/Pitcher", new Cost(CurrencyType.COPPER, 2), 4);
    public static final Gear LADDER = new BundledGear("Ladder", 10, new Cost(CurrencyType.SILVER, 1), 25);
    public static final Gear LAMP = new Gear("Lamp", new Cost(CurrencyType.SILVER, 5), 1);
    public static final Gear LANTERN_BULLSEYE = new Gear("Bullseye Lantern", new Cost(CurrencyType.GOLD, 10), 2);
    public static final Gear LANTERN_HOODED = new Gear("Hooded Lantern", new Cost(CurrencyType.GOLD, 5), 2);
    public static final Gear LITTLE_BAG_OF_SAND = new Gear("Little Bag of Sand", new Cost(CurrencyType.GOLD, 0), 0);
    public static final Gear LOCK = new Gear("Lock", new Cost(CurrencyType.GOLD, 10), 1);
    public static final Gear MAGNIFYING_GLASS = new Gear("Magnifying Glass", new Cost(CurrencyType.GOLD, 100), 1);
    public static final Gear MANACLES = new Gear("Manacles", new Cost(CurrencyType.GOLD, 2), 6);
    public static final Gear MESS_KIT = new Gear("Mess Kit", new Cost(CurrencyType.GOLD, 2), 1);
    public static final Gear MIRROR_STEEL = new Gear("Steel Mirror", new Cost(CurrencyType.GOLD, 5), 0.5);
    public static final Gear OIL_FLASK = new Gear("Oil Flask", new Cost(CurrencyType.SILVER, 1), 1);
    public static final Gear PAPER = new Gear("Paper", new Cost(CurrencyType.SILVER, 2), 0);
    public static final Gear PARCHMENT = new Gear("Parchment", new Cost(CurrencyType.SILVER, 1), 0);
    public static final Gear PERFUME = new Gear("Perfume (vial)", new Cost(CurrencyType.GOLD, 5), 0);
    public static final Gear MINERS_PICK = new Gear("Miner's Pick", new Cost(CurrencyType.GOLD, 2), 10);
    public static final Gear PITON = new Gear("Piton", new Cost(CurrencyType.COPPER, 5), 0.25);
    public static final Gear POISON_BASIC = new Gear("Basic Poison (vial)", new Cost(CurrencyType.GOLD, 100), 0);
    public static final Gear POLE = new BundledGear("Pole", 10, new Cost(CurrencyType.COPPER, 5), 7);
    public static final Gear POT_IRON = new Gear("Iron Pot", new Cost(CurrencyType.GOLD, 2), 10);
    public static final Gear POTION_HEALING = new Gear("Potion of Healing", new Cost(CurrencyType.GOLD, 50), 0.5);
    public static final Gear POUCH = new Gear("Pouch", new Cost(CurrencyType.SILVER, 5), 1);
    public static final Gear QUIVER = new Gear("Quiver", new Cost(CurrencyType.GOLD, 1), 1);
    public static final Gear RAM_PORTABLE = new Gear("Portable Ram", new Cost(CurrencyType.GOLD, 4), 35);
    public static final Gear RATIONS = new Gear("Rations", new Cost(CurrencyType.SILVER, 5), 2);
    public static final Gear ROBES = new Gear("Robes", new Cost(CurrencyType.GOLD, 1), 4);
    public static final Gear ROPE_HEMPEN = new BundledGear("Hempen Rope", 50, new Cost(CurrencyType.GOLD, 1), 10);
    public static final Gear ROPE_SILK = new BundledGear("Silk Rope", 50, new Cost(CurrencyType.GOLD, 10), 5);
    public static final Gear SACK = new Gear("Sack", new Cost(CurrencyType.COPPER, 1), 0.5);
    public static final Gear SCALE_MERCHANTS = new Gear("Merchant's Scale", new Cost(CurrencyType.GOLD, 5), 3);
    public static final Gear SEALING_WAX = new Gear("Sealing Wax", new Cost(CurrencyType.SILVER, 5), 0);
    public static final Gear SHOVEL = new Gear("Shovel", new Cost(CurrencyType.GOLD, 2), 5);
    public static final Gear SIGNAL_WHISTLE = new Gear("Signal Whistle", new Cost(CurrencyType.COPPER, 5), 0);
    public static final Gear SIGNET_RING = new Gear("Signet Ring", new Cost(CurrencyType.GOLD, 5), 0);
    public static final Gear SMALL_KNIFE = new Gear("Small Knife", new Cost(CurrencyType.GOLD, 0), 0);
    public static final Gear SOAP = new Gear("Soap", new Cost(CurrencyType.COPPER, 2), 0);
    public static final Gear SPELLBOOK = new Gear("Spellbook", new Cost(CurrencyType.GOLD, 50), 3);
    public static final Gear SPIKES_IRON = new BundledGear("Iron Spikes", 10, new Cost(CurrencyType.GOLD, 1), 5);
    public static final Gear SPYGLASS = new Gear("Spyglass", new Cost(CurrencyType.GOLD, 1000), 1);
    public static final Gear STRING = new BundledGear("String", 10, new Cost(CurrencyType.GOLD, 0), 0);
    public static final Gear TENT_TWO_PERSON = new Gear("Two-Person Tent", new Cost(CurrencyType.GOLD, 2), 20);
    public static final Gear TINDERBOX = new Gear("Tinderbox", new Cost(CurrencyType.SILVER, 5), 1);
    public static final Gear TORCH = new Gear("Torch", new Cost(CurrencyType.COPPER, 1), 1);
    public static final Gear VESTMENTS = new Gear("Vestments", new Cost(CurrencyType.GOLD, 0), 0);
    public static final Gear VIAL = new Gear("Vial", new Cost(CurrencyType.GOLD, 1), 0);
    public static final Gear WATERSKIN = new Gear("Waterskin", new Cost(CurrencyType.SILVER, 2), 5);
    public static final Gear WHETSTONE = new Gear("Whetstone", new Cost(CurrencyType.COPPER, 1), 1);
}
