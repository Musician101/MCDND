package musician101.mcdnd.equipment.armor;

import musician101.mcdnd.currency.CurrencyHolder.Cost;
import musician101.mcdnd.currency.CurrencyType;
import musician101.mcdnd.equipment.armor.Armor.ArmorTypes;

import java.util.Arrays;
import java.util.List;

public class Armors
{
    public static final Armor LEATHER = new Armor("Leather", ArmorTypes.LIGHT, new Cost(CurrencyType.GOLD, 10), 11,
            0, false, 10);
    public static final Armor SCALE_MAIL = new Armor("Scale Mail", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD, 50)
            , 14, 0, false, 20);
    public static final Armor CHAIN_MAIL = new Armor("Chain Mail", ArmorTypes.HEAVY, new Cost(CurrencyType.GOLD, 75),
            16, 0, false, 20);
    public static final Armor NO_ARMOR = new Armor("No Armor", ArmorTypes.UNARMORED, new Cost(), 11, 0, false, 0);
    public static final Armor SHIELD = new Armor("Shield", ArmorTypes.SHIELD, new Cost(CurrencyType.GOLD, 10), 2, 0,
            false, 20);
    public static final Armor NO_SHIELD = new Armor("No Shield", ArmorTypes.UNARMORED, new Cost(), 0, 0, false, 0);
    private static final Armor PADDED = new Armor("Padded", ArmorTypes.LIGHT, new Cost(CurrencyType.GOLD, 5), 11, 0,
            true, 8);
    private static final Armor STUDDED_LEATHER = new Armor("Studded Leather", ArmorTypes.LIGHT, new Cost(CurrencyType
            .GOLD, 45), 12, 0, false, 13);
    private static final Armor HIDE = new Armor("Hide", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD, 10), 12, 0,
            false, 12);
    private static final Armor CHAIN_SHIRT = new Armor("Chain Shirt", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD,
            50), 13, 0, false, 20);
    private static final Armor BREASTPLATE = new Armor("Breastplate", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD,
            400), 14, 0, false, 20);
    private static final Armor HALF_PLATE = new Armor("Half Plate", ArmorTypes.MEDIUM, new Cost(CurrencyType.GOLD,
            750), 15, 0, false, 20);
    private static final Armor RING_MAIL = new Armor("Ring Mail", ArmorTypes.HEAVY, new Cost(CurrencyType.GOLD, 30),
            14, 0, false, 20);
    private static final Armor SPLINT = new Armor("Splint", ArmorTypes.HEAVY, new Cost(CurrencyType.GOLD, 200), 17,
            0, false, 20);
    private static final Armor PLATE = new Armor("Plate", ArmorTypes.HEAVY, new Cost(CurrencyType.GOLD, 1500), 18, 0,
            false, 20);

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
