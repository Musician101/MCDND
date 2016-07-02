package io.musician101.sponge.mcdnd.equipment.tool;

import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.type.CurrencyTypes;
import io.musician101.sponge.mcdnd.equipment.tool.Tool.MusicalInstrument;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MusicalInstruments
{
    public static final MusicalInstrument BAGPIPES = new MusicalInstrument("Bagpipes", new Cost(CurrencyTypes.GOLD, 30), 6);
    public static final MusicalInstrument DRUM = new MusicalInstrument("Drum", new Cost(CurrencyTypes.GOLD, 6), 3);
    public static final MusicalInstrument DULCIMER = new MusicalInstrument("Dulcimer", new Cost(CurrencyTypes.GOLD, 25), 10);
    public static final MusicalInstrument FLUTE = new MusicalInstrument("Flute", new Cost(CurrencyTypes.GOLD, 2), 1);
    public static final MusicalInstrument LUTE = new MusicalInstrument("Lute", new Cost(CurrencyTypes.GOLD, 35), 2);
    public static final MusicalInstrument LYRE = new MusicalInstrument("Lyre", new Cost(CurrencyTypes.GOLD, 30), 2);
    public static final MusicalInstrument HORN = new MusicalInstrument("Horn", new Cost(CurrencyTypes.GOLD, 3), 2);
    public static final MusicalInstrument PAN_FLUTE = new MusicalInstrument("Pan Flute", new Cost(CurrencyTypes.GOLD, 12), 2);
    public static final MusicalInstrument SHAWM = new MusicalInstrument("Shawm", new Cost(CurrencyTypes.GOLD, 2), 1);
    public static final MusicalInstrument VIOL = new MusicalInstrument("Viol", new Cost(CurrencyTypes.GOLD, 30), 1);
    public static final List<MusicalInstrument> ALL = Collections.unmodifiableList(Arrays.asList(BAGPIPES, DRUM, DULCIMER, FLUTE, LUTE, LYRE, HORN, PAN_FLUTE, SHAWM, VIOL));
}
