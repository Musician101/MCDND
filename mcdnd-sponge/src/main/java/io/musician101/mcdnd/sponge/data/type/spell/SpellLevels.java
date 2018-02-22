package io.musician101.mcdnd.sponge.data.type.spell;

import java.util.Arrays;
import java.util.List;

public class SpellLevels {

    public static final SpellLevel CANTRIP = new SpellLevel("Cantrip", 0);
    public static final SpellLevel L1 = new SpellLevel("1st Level", 1);
    public static final SpellLevel L2 = new SpellLevel("2nd Level", 2);
    public static final SpellLevel L3 = new SpellLevel("3rd Level", 3);
    public static final SpellLevel L4 = new SpellLevel("4th Level", 4);
    public static final SpellLevel L5 = new SpellLevel("5th Level", 5);
    public static final SpellLevel L6 = new SpellLevel("6th Level", 6);
    public static final SpellLevel L7 = new SpellLevel("7th Level", 7);
    public static final SpellLevel L8 = new SpellLevel("8th Level", 8);
    public static final SpellLevel L9 = new SpellLevel("9th Level", 9);
    public static final List<SpellLevel> ALL = Arrays.asList(CANTRIP, L1, L2, L3, L4, L5, L6, L7, L8, L9);
}
