package io.musician101.sponge.mcdnd.race;

import com.google.common.collect.ImmutableList;
import io.musician101.sponge.mcdnd.race.trait.Trait;

public class CharacterRaces
{
    public static final CharacterRace DRAGONBORN = new CharacterRace("Dragonborn", ImmutableList.<Trait>builder()
            .build());
    public static final CharacterRace DWARF = new CharacterRace("Dwarf", ImmutableList.<Trait>builder()
            .build());
    public static final CharacterRace ELF = new CharacterRace("Elf", ImmutableList.<Trait>builder()
            .build());
    public static final CharacterRace HUMAN = new CharacterRace("Human", ImmutableList.<Trait>builder()
            .build());
    public static final CharacterRace HALF_ELF = new CharacterRace("Half-Elf", ImmutableList.<Trait>builder()
            .build());
    public static final CharacterRace HALF_ORC = new CharacterRace("Half-Orc", ImmutableList.<Trait>builder()
            .build());
    public static final CharacterRace HALFLING = new CharacterRace("Halfling", ImmutableList.<Trait>builder()
            .build());
    public static final CharacterRace GNOME = new CharacterRace("Gnome", ImmutableList.<Trait>builder()
            .build());
    public static final CharacterRace TIEFLING = new CharacterRace("Tiefling", ImmutableList.<Trait>builder()
            .build());

    private CharacterRaces()
    {

    }
}
