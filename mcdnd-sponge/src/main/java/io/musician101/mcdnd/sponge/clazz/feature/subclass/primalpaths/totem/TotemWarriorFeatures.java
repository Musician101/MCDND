package io.musician101.mcdnd.sponge.clazz.feature.subclass.primalpaths.totem;

import io.musician101.mcdnd.sponge.clazz.feature.Feature;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.magic.Spells;
import java.util.Arrays;

import static io.musician101.mcdnd.sponge.clazz.feature.Feature.builder;

public class TotemWarriorFeatures {

    public static final Feature ASPECT_OF_THE_BEAST = builder().name("Aspect of the Beast").levelRequirement(6).description("At 6th level, you gain a magical benefit based on the totem animal of your choice. You can choose the same animal you selected at 3rd level or a different one.").addProperty(MCDNDKeys.TOTEMS, Totems.ALL_TOTEMS.get(6)).build();
    public static final Feature SPIRIT_SEEKER = builder().name("Spirit Seeker").levelRequirement(3).description("Yours is a path that seeks attunement with the natural world, giving you a kinship with beasts. At 3rd level when you adopt this path, you gain the ability to cast the Beast Sense and Speak with Animals spells, but only as rituals.").addProperty(MCDNDKeys.SPELLS, Arrays.asList(Spells.BEAST_SENSE, Spells.SPEAK_WITH_ANIMALS)).build();
    public static final Feature SPIRIT_WALKER = builder().name("Spirit Walker").levelRequirement(10).description("At 10th level, you can cast the Commune with Nature spell, but only as a ritual. When you do so, a spiritual version of one of the animals you chose for Totem Spirit or Aspect of the Beast appears to you to convey the information you seek.").addProperty(MCDNDKeys.SPELL, Spells.COMMUNE_WITH_NATURE).build();
    public static final Feature TOTEMIC_ATTUNEMENT = builder().name("Totemic Attunement").levelRequirement(14).description("At 14th level, you gain a magical benefit based on a totem animal of your choice. You can choose the same animal you selected previously or a different one.").addProperty(MCDNDKeys.TOTEMS, Totems.ALL_TOTEMS.get(14)).build();
    public static final Feature TOTEM_SPIRIT = builder().name("Totem Spirit").levelRequirement(3).description("At 3rd level, when you adopt this path, you choose a totem spirit and gain its feature. You must make or acquire a physical totem object-an amulet or similar adornment-that incorporates fur or feathers, claws, teeth, or bones of the totem animal. At your option, you also gain minor physical attributes that are reminiscent of your totem spirit. For example, if you have a bear totem spirit, you might be unusually hairy and thick-skinned, or if your totem is the eagle, your eyes turn bright yellow.", "Your totem animal might be an animal related to those listed here but more appropriate to you homeland. For example, you could choose a hawk or vulture in place of an eagle.").addProperty(MCDNDKeys.TOTEMS, Totems.ALL_TOTEMS.get(3)).build();

    private TotemWarriorFeatures() {

    }
}
