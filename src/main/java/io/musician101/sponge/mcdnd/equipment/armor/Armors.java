package io.musician101.sponge.mcdnd.equipment.armor;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.type.CurrencyTypes;
import io.musician101.sponge.mcdnd.data.type.MCDNDArmorTypes;

import java.util.Arrays;
import java.util.List;

public class Armors
{
    public static final Armor LEATHER = new Armor("Leather", MCDNDArmorTypes.LIGHT, new Cost(CurrencyTypes.GOLD, 10), 11, 0, false, 10);
    public static final Armor SCALE_MAIL = new Armor("Scale Mail", MCDNDArmorTypes.MEDIUM, new Cost(CurrencyTypes.GOLD, 50), 14, 0, false, 20);
    public static final Armor CHAIN_MAIL = new Armor("Chain Mail", MCDNDArmorTypes.HEAVY, new Cost(CurrencyTypes.GOLD, 75), 16, 0, false, 20);
    public static final Armor NO_ARMOR = new Armor("No Armor", MCDNDArmorTypes.UNARMORED, new Cost(), 0, 0, false, 0);
    public static final Armor SHIELD = new Armor("Shield", MCDNDArmorTypes.SHIELD, new Cost(CurrencyTypes.GOLD, 10), 2, 0, false, 20);
    public static final Armor NO_SHIELD = new Armor("No Shield", MCDNDArmorTypes.UNARMORED, new Cost(), 0, 0, false, 0);
    private static final Armor PADDED = new Armor("Padded", MCDNDArmorTypes.LIGHT, new Cost(CurrencyTypes.GOLD, 5), 11, 0, true, 8);
    private static final Armor STUDDED_LEATHER = new Armor("Studded Leather", MCDNDArmorTypes.LIGHT, new Cost(CurrencyTypes.GOLD, 45), 12, 0, false, 13);
    private static final Armor HIDE = new Armor("Hide", MCDNDArmorTypes.MEDIUM, new Cost(CurrencyTypes.GOLD, 10), 12, 0, false, 12);
    private static final Armor CHAIN_SHIRT = new Armor("Chain Shirt", MCDNDArmorTypes.MEDIUM, new Cost(CurrencyTypes.GOLD, 50), 13, 0, false, 20);
    private static final Armor BREASTPLATE = new Armor("Breastplate", MCDNDArmorTypes.MEDIUM, new Cost(CurrencyTypes.GOLD, 400), 14, 0, false, 20);
    private static final Armor HALF_PLATE = new Armor("Half Plate", MCDNDArmorTypes.MEDIUM, new Cost(CurrencyTypes.GOLD, 750), 15, 0, false, 20);
    private static final Armor RING_MAIL = new Armor("Ring Mail", MCDNDArmorTypes.HEAVY, new Cost(CurrencyTypes.GOLD, 30), 14, 0, false, 20);
    private static final Armor SPLINT = new Armor("Splint", MCDNDArmorTypes.HEAVY, new Cost(CurrencyTypes.GOLD, 200), 17, 0, false, 20);
    private static final Armor PLATE = new Armor("Plate", MCDNDArmorTypes.HEAVY, new Cost(CurrencyTypes.GOLD, 1500), 18, 0, false, 20);

    private Armors()
    {

    }

    public static List<Armor> getLightArmor()
    {
        return Arrays.asList(PADDED, LEATHER, STUDDED_LEATHER);
    }

    public static List<Armor> getMediumArmor()
    {
        return Arrays.asList(HIDE, CHAIN_SHIRT, SCALE_MAIL, BREASTPLATE, HALF_PLATE);
    }

    public static List<Armor> getHeavyArmor()
    {
        return Arrays.asList(RING_MAIL, CHAIN_MAIL, SPLINT, PLATE);
    }
}
