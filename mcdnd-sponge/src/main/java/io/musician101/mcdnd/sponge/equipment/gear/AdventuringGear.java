package io.musician101.mcdnd.sponge.equipment.gear;

import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.type.CurrencyTypes;
import io.musician101.mcdnd.sponge.equipment.gear.Gear.AmmunitionGear;
import io.musician101.mcdnd.sponge.equipment.gear.Gear.ArcaneFocusGear;
import io.musician101.mcdnd.sponge.equipment.gear.Gear.BundledGear;
import io.musician101.mcdnd.sponge.equipment.gear.Gear.DruidicFocusGear;

public class AdventuringGear {

    public static final Gear ABACUS = new Gear("Abacus", new Cost(CurrencyTypes.GOLD, 2), 2);
    public static final Gear ACID_VIAL = new Gear("Acid (Vial)", new Cost(CurrencyTypes.GOLD, 25), 1);
    public static final Gear ALCHEMIST_S_FIRE_FLASK = new Gear("Alchemist's Fire (Flask)", new Cost(CurrencyTypes.GOLD, 50), 1);
    public static final Gear ALMS_BOX = new Gear("Alms Box", new Cost(CurrencyTypes.GOLD, 0), 0);
    public static final Gear ANTITOXIN_VIAL = new Gear("Antitoxin (Vial)", new Cost(CurrencyTypes.GOLD, 50), 0);
    public static final Gear ARCANE_FOCUS_CRYSTAL = new ArcaneFocusGear("Arcane Focus (Crystal)", new Cost(CurrencyTypes.GOLD, 10), 1);
    public static final Gear ARCANE_FOCUS_ORB = new ArcaneFocusGear("Arcane Focus (Orb)", new Cost(CurrencyTypes.GOLD, 20), 3);
    public static final Gear ARCANE_FOCUS_ROD = new ArcaneFocusGear("Arcane Focus (Rod)", new Cost(CurrencyTypes.GOLD, 10), 2);
    public static final Gear ARCANE_FOCUS_STAFF = new ArcaneFocusGear("Arcane Focus (Staff)", new Cost(CurrencyTypes.GOLD, 5), 4);
    public static final Gear ARCANE_FOCUS_WAND = new ArcaneFocusGear("Arcane Focus (Wand)", new Cost(CurrencyTypes.GOLD, 10), 1);
    public static final BundledGear ARROWS = new AmmunitionGear("Arrows", 20, new Cost(CurrencyTypes.GOLD, 1), 1);
    public static final Gear BACKPACK = new Gear("Backpack", new Cost(CurrencyTypes.GOLD, 2), 5);
    public static final BundledGear BALL_BEARINGS = new BundledGear("Ball Bearings (bag of 1,000)", 1000, new Cost(CurrencyTypes.GOLD, 1), 2);
    public static final Gear BARREL = new Gear("Barrel", new Cost(CurrencyTypes.GOLD, 2), 70);
    public static final Gear BASKET = new Gear("Basket", new Cost(CurrencyTypes.SILVER, 4), 2);
    public static final Gear BEDROLL = new Gear("Bedroll", new Cost(CurrencyTypes.GOLD, 1), 7);
    public static final Gear BELL = new Gear("Bell", new Cost(CurrencyTypes.GOLD, 1), 0);
    public static final Gear BLANKET = new Gear("Blanket", new Cost(CurrencyTypes.SILVER, 5), 3);
    public static final Gear BLOCK_AND_TACKLE = new Gear("Block and Tackle", new Cost(CurrencyTypes.GOLD, 1), 5);
    public static final BundledGear BLOWGUN_NEEDLES = new AmmunitionGear("Blowgun Needles", 50, new Cost(CurrencyTypes.GOLD, 1), 1);
    public static final Gear BOOK = new Gear("Book", new Cost(CurrencyTypes.GOLD, 25), 5);
    public static final Gear BUCKET = new Gear("Bucket", new Cost(CurrencyTypes.COPPER, 5), 2);
    public static final BundledGear CALTROPS = new BundledGear("Caltrops (bag of 20)", 20, new Cost(CurrencyTypes.GOLD, 1), 2);
    public static final Gear CANDLE = new Gear("Candle", new Cost(CurrencyTypes.COPPER, 1), 0);
    public static final Gear CASE_CROSSBOW_BOLT = new Gear("Crossbow Bolt Case", new Cost(CurrencyTypes.GOLD, 1), 1);
    public static final Gear CASE_MAP_SCROLL = new Gear("Map/Scroll Case", new Cost(CurrencyTypes.GOLD, 1), 1);
    public static final Gear CENSER = new Gear("Censer", new Cost(CurrencyTypes.GOLD, 0), 0);
    public static final BundledGear CHAIN = new BundledGear("Chain (10 feet)", 10, new Cost(CurrencyTypes.GOLD, 5), 10);
    public static final BundledGear CHALK = new BundledGear("Chalk (1 piece)", 1, new Cost(CurrencyTypes.COPPER, 1), 0);
    public static final Gear CHEST = new Gear("Chest", new Cost(CurrencyTypes.GOLD, 5), 25);
    public static final Gear CLIMBERS_KIT = new Gear("Climber's Kit", new Cost(CurrencyTypes.GOLD, 25), 12);
    public static final Gear CLOTHES_COMMON = new Gear("Common Clothes", new Cost(CurrencyTypes.SILVER, 5), 3);
    public static final Gear CLOTHES_COSTUME = new Gear("Costume Clothes", new Cost(CurrencyTypes.GOLD, 5), 4);
    public static final Gear CLOTHES_FINE = new Gear("Fine Clothes", new Cost(CurrencyTypes.GOLD, 15), 6);
    public static final Gear CLOTHES_TRAVELERS = new Gear("Traveler's Clothes", new Cost(CurrencyTypes.GOLD, 2), 4);
    public static final Gear COMPONENT_POUCH = new Gear("Component Pouch", new Cost(CurrencyTypes.GOLD, 25), 2);
    public static final BundledGear CROSSBOW_BOLTS = new AmmunitionGear("Crossbow Bolts", 20, new Cost(CurrencyTypes.GOLD, 1), 1.5);
    public static final Gear CROWBAR = new Gear("Crowbar", new Cost(CurrencyTypes.GOLD, 2), 5);
    public static final Gear DRUIDIC_FOCUS_SPRIG_MISTLETOE = new DruidicFocusGear("Sprig of Mistletoe", new Cost(CurrencyTypes.GOLD, 1), 0);
    public static final Gear DRUIDIC_FOCUS_TOTEM = new DruidicFocusGear("Totem", new Cost(CurrencyTypes.GOLD, 1), 0);
    public static final Gear DRUIDIC_FOCUS_WOODEN_STAFF = new DruidicFocusGear("Wooden Staff", new Cost(CurrencyTypes.GOLD, 5), 4);
    public static final Gear DRUIDIC_FOCUS_YEW_WAND = new DruidicFocusGear("Yew Wand", new Cost(CurrencyTypes.GOLD, 10), 1);
    public static final Gear FISHING_TACKLE = new Gear("Fishing Tackle", new Cost(CurrencyTypes.GOLD, 1), 4);
    public static final Gear FLASK_TANKARD = new Gear("Flask/Tankard", new Cost(CurrencyTypes.COPPER, 2), 1);
    public static final Gear GLASS_BOTTLE = new Gear("Glass Bottle", new Cost(CurrencyTypes.GOLD, 2), 2);
    public static final Gear GRAPPLING_HOOK = new Gear("Grappling Hook", new Cost(CurrencyTypes.GOLD, 2), 4);
    public static final Gear HAMMER = new Gear("Hammer", new Cost(CurrencyTypes.GOLD, 1), 3);
    public static final Gear HAMMER_SLEDGE = new Gear("Sledge Hammer", new Cost(CurrencyTypes.GOLD, 2), 10);
    public static final Gear HEALERS_KIT = new Gear("Healer's Kit", new Cost(CurrencyTypes.GOLD, 5), 3);
    public static final Gear HOLY_SYMBOL_AMULET = new Gear("Holy Symbol (Amulet)", new Cost(CurrencyTypes.GOLD, 5), 1);
    public static final Gear HOLY_SYMBOL_EMBLEM = new Gear("Holy Symbol (Emblem)", new Cost(CurrencyTypes.GOLD, 5), 0);
    public static final Gear HOLY_SYMBOL_RELIQUARY = new Gear("Holy Symbol (Reliquary)", new Cost(CurrencyTypes.GOLD, 5), 2);
    public static final Gear HOLY_WATER = new Gear("Flask of Holy Water", new Cost(CurrencyTypes.GOLD, 25), 1);
    public static final Gear HOURGLASS = new Gear("Hourglass", new Cost(CurrencyTypes.GOLD, 25), 1);
    public static final Gear HUNTING_TRAP = new Gear("Hunting Trap", new Cost(CurrencyTypes.GOLD, 5), 25);
    public static final Gear INK = new Gear("Ink (1 ounce bottle)", new Cost(CurrencyTypes.GOLD, 10), 0);
    public static final Gear INK_PEN = new Gear("Ink Pen", new Cost(CurrencyTypes.COPPER, 2), 0);
    public static final Gear JUG_PITCHER = new Gear("Jug/Pitcher", new Cost(CurrencyTypes.COPPER, 2), 4);
    public static final BundledGear LADDER = new BundledGear("Ladder", 10, new Cost(CurrencyTypes.SILVER, 1), 25);
    public static final Gear LAMP = new Gear("Lamp", new Cost(CurrencyTypes.SILVER, 5), 1);
    public static final Gear LANTERN_BULLSEYE = new Gear("Bullseye Lantern", new Cost(CurrencyTypes.GOLD, 10), 2);
    public static final Gear LANTERN_HOODED = new Gear("Hooded Lantern", new Cost(CurrencyTypes.GOLD, 5), 2);
    public static final Gear LITTLE_BAG_OF_SAND = new Gear("Little Bag of Sand", new Cost(CurrencyTypes.GOLD, 0), 0);
    public static final Gear LOCK = new Gear("Lock", new Cost(CurrencyTypes.GOLD, 10), 1);
    public static final Gear MAGNIFYING_GLASS = new Gear("Magnifying Glass", new Cost(CurrencyTypes.GOLD, 100), 1);
    public static final Gear MANACLES = new Gear("Manacles", new Cost(CurrencyTypes.GOLD, 2), 6);
    public static final Gear MESS_KIT = new Gear("Mess Kit", new Cost(CurrencyTypes.GOLD, 2), 1);
    public static final Gear MINERS_PICK = new Gear("Miner's Pick", new Cost(CurrencyTypes.GOLD, 2), 10);
    public static final Gear MIRROR_STEEL = new Gear("Steel Mirror", new Cost(CurrencyTypes.GOLD, 5), 0.5);
    public static final Gear OIL_FLASK = new Gear("Oil Flask", new Cost(CurrencyTypes.SILVER, 1), 1);
    public static final Gear PAPER = new Gear("Paper", new Cost(CurrencyTypes.SILVER, 2), 0);
    public static final Gear PARCHMENT = new Gear("Parchment", new Cost(CurrencyTypes.SILVER, 1), 0);
    public static final Gear PERFUME = new Gear("Perfume (vial)", new Cost(CurrencyTypes.GOLD, 5), 0);
    public static final Gear PITON = new Gear("Piton", new Cost(CurrencyTypes.COPPER, 5), 0.25);
    public static final Gear POISON_BASIC = new Gear("Basic Poison (vial)", new Cost(CurrencyTypes.GOLD, 100), 0);
    public static final BundledGear POLE = new BundledGear("Pole", 10, new Cost(CurrencyTypes.COPPER, 5), 7);
    public static final Gear POTION_HEALING = new Gear("Potion of Healing", new Cost(CurrencyTypes.GOLD, 50), 0.5);
    public static final Gear POT_IRON = new Gear("Iron Pot", new Cost(CurrencyTypes.GOLD, 2), 10);
    public static final Gear POUCH = new Gear("Pouch", new Cost(CurrencyTypes.SILVER, 5), 1);
    public static final Gear QUIVER = new Gear("Quiver", new Cost(CurrencyTypes.GOLD, 1), 1);
    public static final Gear RAM_PORTABLE = new Gear("Portable Ram", new Cost(CurrencyTypes.GOLD, 4), 35);
    public static final Gear RATIONS = new Gear("Rations", new Cost(CurrencyTypes.SILVER, 5), 2);
    public static final Gear ROBES = new Gear("Robes", new Cost(CurrencyTypes.GOLD, 1), 4);
    public static final BundledGear ROPE_HEMPEN = new BundledGear("Hempen Rope", 50, new Cost(CurrencyTypes.GOLD, 1), 10);
    public static final BundledGear ROPE_SILK = new BundledGear("Silk Rope", 50, new Cost(CurrencyTypes.GOLD, 10), 5);
    public static final Gear SACK = new Gear("Sack", new Cost(CurrencyTypes.COPPER, 1), 0.5);
    public static final Gear SCALE_MERCHANTS = new Gear("Merchant's Scale", new Cost(CurrencyTypes.GOLD, 5), 3);
    public static final Gear SEALING_WAX = new Gear("Sealing Wax", new Cost(CurrencyTypes.SILVER, 5), 0);
    public static final Gear SHOVEL = new Gear("Shovel", new Cost(CurrencyTypes.GOLD, 2), 5);
    public static final Gear SIGNAL_WHISTLE = new Gear("Signal Whistle", new Cost(CurrencyTypes.COPPER, 5), 0);
    public static final Gear SIGNET_RING = new Gear("Signet Ring", new Cost(CurrencyTypes.GOLD, 5), 0);
    public static final BundledGear SLING_BULLETS = new AmmunitionGear("Sling Bullets", 20, new Cost(CurrencyTypes.COPPER, 4), 1.5);
    public static final Gear SMALL_KNIFE = new Gear("Small Knife", new Cost(CurrencyTypes.GOLD, 0), 0);
    public static final Gear SOAP = new Gear("Soap", new Cost(CurrencyTypes.COPPER, 2), 0);
    public static final Gear SPELLBOOK = new Gear("Spellbook", new Cost(CurrencyTypes.GOLD, 50), 3);
    public static final BundledGear SPIKES_IRON = new BundledGear("Iron Spikes", 10, new Cost(CurrencyTypes.GOLD, 1), 5);
    public static final Gear SPYGLASS = new Gear("Spyglass", new Cost(CurrencyTypes.GOLD, 1000), 1);
    public static final BundledGear STRING = new BundledGear("String", 10, new Cost(CurrencyTypes.GOLD, 0), 0);
    public static final Gear TENT_TWO_PERSON = new Gear("Two-Person Tent", new Cost(CurrencyTypes.GOLD, 2), 20);
    public static final Gear TINDERBOX = new Gear("Tinderbox", new Cost(CurrencyTypes.SILVER, 5), 1);
    public static final Gear TORCH = new Gear("Torch", new Cost(CurrencyTypes.COPPER, 1), 1);
    public static final Gear VESTMENTS = new Gear("Vestments", new Cost(CurrencyTypes.GOLD, 0), 0);
    public static final Gear VIAL = new Gear("Vial", new Cost(CurrencyTypes.GOLD, 1), 0);
    public static final Gear WATERSKIN = new Gear("Waterskin", new Cost(CurrencyTypes.SILVER, 2), 5);
    public static final Gear WHETSTONE = new Gear("Whetstone", new Cost(CurrencyTypes.COPPER, 1), 1);

    private AdventuringGear() {

    }
}
