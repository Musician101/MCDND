package io.musician101.mcdnd.sponge.race;

import io.musician101.mcdnd.sponge.race.trait.DragonbornTraits;
import io.musician101.mcdnd.sponge.race.trait.HalfElfTraits;
import io.musician101.mcdnd.sponge.race.trait.HalfOrcTraits;
import io.musician101.mcdnd.sponge.race.trait.HumanTraits;
import io.musician101.mcdnd.sponge.race.trait.TieflingTraits;
import io.musician101.mcdnd.sponge.race.trait.dwarf.DwarfTraits;
import io.musician101.mcdnd.sponge.race.trait.elf.ElfTraits;
import io.musician101.mcdnd.sponge.race.trait.gnome.GnomeTraits;
import io.musician101.mcdnd.sponge.race.trait.halfling.HalflingTraits;

public class CharacterRaces
{
    public static final CharacterRace DRAGONBORN = new CharacterRace("Dragonborn", DragonbornTraits.ALL);
    public static final CharacterRace DWARF = new CharacterRace("Dwarf", DwarfTraits.ALL);
    public static final CharacterRace ELF = new CharacterRace("Elf", ElfTraits.ALL);
    public static final CharacterRace GNOME = new CharacterRace("Gnome", GnomeTraits.ALL);
    public static final CharacterRace HALF_ELF = new CharacterRace("Half-Elf", HalfElfTraits.ALL);
    public static final CharacterRace HALF_ORC = new CharacterRace("Half-Orc", HalfOrcTraits.ALL);
    public static final CharacterRace HALFLING = new CharacterRace("Halfling", HalflingTraits.ALL);
    public static final CharacterRace HUMAN = new CharacterRace("Human", HumanTraits.ALL);
    public static final CharacterRace TIEFLING = new CharacterRace("Tiefling", TieflingTraits.ALL);

    private CharacterRaces()
    {

    }
}
