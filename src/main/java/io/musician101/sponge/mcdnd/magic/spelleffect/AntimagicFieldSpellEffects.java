package io.musician101.sponge.mcdnd.magic.spelleffect;

import java.util.Arrays;
import java.util.List;

import static io.musician101.sponge.mcdnd.magic.spelleffect.SpellEffect.builder;

public class AntimagicFieldSpellEffects
{
    public static final SpellEffect AREAS_OF_MAGIC = builder().name("Areas of Magic")
            .description("The area of another spell or magical effect, such as Fireball, can't extend into the sphere. If the sphere overlaps an area of magic, the part of the area that is covered by the sphere is suppressed. For example, the flames created by a Wall of Fire are suppressed within the sphere, creating a gap in the wall if the overlap is large enough.")
            .build();
    public static final SpellEffect CREATURES_AND_OBJECTS = builder().name("Creatures and Objects")
            .description("A creature or object summoned or created by magic temporarily winks out of existence in the sphere. Such a creature instantly reappears once the space the creature occupied is no longer within the sphere.")
            .build();
    public static final SpellEffect DISPEL_MAGIC = builder().name("Dispel Magic")
            .description("Spells and magical effects such as Dispel Magic have no effect on the sphere. Likewise, the spheres created by different Antimagic Field spells don't nullify each other.")
            .build();
    public static final SpellEffect SPELLS = builder().name("Spells")
            .description("Any active spell or other magical effect on a creature or an object in the sphere is suppressed while the creature or object is in it.")
            .build();
    public static final SpellEffect MAGIC_ITEMS = builder().name("Magic Items")
            .addLineToDescription("The properties and power of magic items are suppressed in the sphere. For example, a +1 Longsword in the sphere functions as a nonmagical longsword.")
            .addLineToDescription("A magic weapon's properties and powers are suppressed if it is used against a target in the sphere or wielded by an attacker in the sphere. If a magic weapon or a piece of magic ammunition fully leaves the sphere (for example, if you fire a magic arrow or throw a magic spear at a target outside the sphere), the magic of the item ceases to be suppressed as soon as it exits.")
            .build();
    public static final SpellEffect MAGICAL_TRAVEL = builder().name("Magical Travel")
            .description("Teleportation and planar travel fail to work in the sphere, whether the sphere is in the destination or the departure point for such magical travel. A portal to another location, world, or plane of existence, as well as an opening to an extradimensional space such as that created by the Rope Trick spell, temporarily closes while in the sphere.")
            .build();
    //TODO check the name for this effect
    public static final SpellEffect TARGETED_EFFECTS = builder().name("Targeted Effects")
            .description("Spells and other magical effects, such as Magic Missile and Charm Person, that target a creature or an object in the sphere have no effect on that target.")
            .build();
    public static final List<SpellEffect> ALL = Arrays.asList(TARGETED_EFFECTS, AREAS_OF_MAGIC, SPELLS, MAGIC_ITEMS, MAGICAL_TRAVEL, CREATURES_AND_OBJECTS, DISPEL_MAGIC);
}
