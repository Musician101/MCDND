package io.musician101.mcdnd.sponge.data.type;

import java.util.Arrays;
import java.util.List;

public class CurrencyTypes {

    public static final CurrencyType COPPER = new CurrencyType("Copper");
    public static final CurrencyType ELECTRUM = new CurrencyType("Electrum");
    public static final CurrencyType GOLD = new CurrencyType("Gold");
    public static final CurrencyType PLATINUM = new CurrencyType("Platinum");
    public static final CurrencyType SILVER = new CurrencyType("Silver");
    public static final List<CurrencyType> ALL = Arrays.asList(COPPER, SILVER, ELECTRUM, GOLD, PLATINUM);
}
