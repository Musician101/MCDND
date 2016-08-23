package io.musician101.sponge.mcdnd.equipment.tool;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.type.CurrencyTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tools
{
    public static final Tool DISGUISE_KIT = new Tool("Disguise Kit", new Cost(CurrencyTypes.GOLD, 25), 3);
    public static final Tool FORGERY_KIT = new Tool("Forgery Kit", new Cost(CurrencyTypes.GOLD, 15), 5);
    public static final Tool HERBALISM_KIT = new Tool("Herbalism Kit", new Cost(CurrencyTypes.GOLD, 5), 3);
    public static final Tool NAVIGATORS_TOOLS = new Tool("Navigator's Tools", new Cost(CurrencyTypes.GOLD, 25), 2);
    public static final Tool POISONERS_KIT = new Tool("Poisoner's Kit", new Cost(CurrencyTypes.GOLD, 50), 2);
    public static final Tool THIEVES_TOOLS = new Tool("Thieve's Tools", new Cost(CurrencyTypes.GOLD, 25), 1);
    public static final List<Tool> ALL = Collections.unmodifiableList(Arrays.asList(DISGUISE_KIT, FORGERY_KIT, HERBALISM_KIT, NAVIGATORS_TOOLS, POISONERS_KIT, THIEVES_TOOLS));

    private Tools()
    {

    }
}
