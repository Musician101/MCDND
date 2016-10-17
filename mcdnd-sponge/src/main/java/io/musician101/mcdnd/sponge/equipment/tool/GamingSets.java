package io.musician101.mcdnd.sponge.equipment.tool;

import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.type.CurrencyTypes;
import io.musician101.mcdnd.sponge.equipment.tool.Tool.GamingSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamingSets
{
    public static final GamingSet DICE_SET = new GamingSet("Dice Set", new Cost(CurrencyTypes.SILVER, 1), 0);
    public static final GamingSet DRAGONCHESS_SET = new GamingSet("Dragonchess Set", new Cost(CurrencyTypes.GOLD, 1), 0.5);
    public static final GamingSet PLAYING_CARD_SET = new GamingSet("Playing Card Set", new Cost(CurrencyTypes.SILVER, 5), 0);
    public static final GamingSet THREE_DRAGON_ANTE_SET = new GamingSet("Three Dragon Ante Set", new Cost(CurrencyTypes.GOLD, 1), 0);
    public static final List<GamingSet> ALL = Collections.unmodifiableList(Arrays.asList(DICE_SET, DRAGONCHESS_SET, PLAYING_CARD_SET, THREE_DRAGON_ANTE_SET));

    private GamingSets()
    {

    }
}
