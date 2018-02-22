package io.musician101.mcdnd.sponge.race.trait.gnome;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.data.type.skill.SkillTypes;
import io.musician101.mcdnd.sponge.equipment.tool.ArtisanTools;
import io.musician101.mcdnd.sponge.race.trait.Trait;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.mcdnd.sponge.race.trait.Trait.builder;

public class RockGnomeTraits {

    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase").addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.CONSTITUTION, 1)).description("Your Constitution score increases by 1.").build();
    public static final Trait ARTIFICERS_LORE = builder().name("Artificer's Lore").addProperty(MCDNDKeys.SKILL_TYPE, SkillTypes.HISTORY).description("Whenever you make an Intelligence (History) check related to magic items, alchemical objects, or technological devices, you can add twice your proficiency bonus, instead of any proficiency bonus you normally apply.").build();
    public static final Trait TINKER = builder().name("Tinker").addProperty(MCDNDKeys.TOOL, ArtisanTools.TINKERS_TOOLS).addLineToDescription("You have proficiency with artisan's tools (tinker's tools). Using those tools, you can spend 1 hour and 10 gp worth of materials to construct a Tiny clockwork device (AC5, 1 hp). The device ceases to function after 24 hours (unless you spend 1 hour repairing it to keep the device functioning), or when you use your action to dismantle it; at that time, you can reclaim the materials used to create it. You can have up to three such devices active at a time.").addLineToDescription("When you create a device, choose one of the following options:").addLineToDescription("Clockwork Toy: This toy is a clockwork animal, monster, or person, such as a frog, mouse, bird, dragon, or soldier. When placed on the ground, the toy moves 5 feet across the ground on each of your turns in a random direction. It makes noises as appropriate to the creature it represents.").addLineToDescription("Fire Starter: The device produces a miniature flame, which you can use to light a candle, torch, or campfire. Using the device requires your action.").addLineToDescription("Music Box: When opened, this music box plays a single song at a moderate volume. The box stops playing when it reaches the song's end or when it is closed.").build();
    public static final List<Trait> ALL = Collections.unmodifiableList(Arrays.asList(ABILITY_SCORE_INCREASE, ARTIFICERS_LORE, TINKER));
}
