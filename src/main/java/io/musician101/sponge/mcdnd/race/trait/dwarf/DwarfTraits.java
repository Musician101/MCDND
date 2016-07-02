package io.musician101.sponge.mcdnd.race.trait.dwarf;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.combat.MCDNDDamageTypes;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.equipment.tool.ArtisanTools;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import io.musician101.sponge.mcdnd.language.Languages;
import io.musician101.sponge.mcdnd.race.trait.Trait;
import io.musician101.sponge.mcdnd.util.list.TraitList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.musician101.sponge.mcdnd.race.trait.Trait.builder;

public class DwarfTraits
{
    public static final Trait ABILITY_SCORE_INCREASE = builder().name("Ability Score Increase")
            .description("Your Constitution score increases by 2")
            .addProperty(MCDNDKeys.ABILITY_SCORE_INCREASE, Collections.singletonMap(AbilityScoreTypes.CONSTITUTION, 2))
            .build();
    public static final Trait AGE = builder().name("Age")
            .description("Dwarves mature at the same rate as humans, but they're considered young until they reach the age of 50. On average, they live about 350 years.")
            .build();
    public static final Trait ALIGNMENT = builder().name("Alignment")
            .description("Most dwarves are lawful, believing firmly in the benefits of a well-ordered society. They tend toward good as well, with a strong sense of fair play and a belief that everyone deserves to share in the benefits of a just order.")
            .build();
    public static final Trait DARKVISION = builder().name("Darkvision")
            .description("Accustomed to life underground, you have superior vision in dark and dim conditions.")
            .build();
    public static final Trait LANGUAGES = builder().name("Languages")
            .description("You can speak, read and write Common and Dwarvish. Dwarvish is full of hard consonants and guttural sounds and those characteristics spill over into whatever other language a dwarf might speak.")
            .addProperty(MCDNDKeys.LANGUAGES, Arrays.asList(Languages.COMMON, Languages.DWARVISH))
            .build();
    public static final Trait TOOL_PROFICIENCY = builder().name("Tool Proficiency")
            .description("You gain proficiency with the artisan's tools of your choice: smith's tools, brewer's supplies, or mason's tools.")
            .addProperty(MCDNDKeys.TOOLS, Arrays.asList(ArtisanTools.BREWERS_SUPPLIES, ArtisanTools.MASONS_TOOLS, ArtisanTools.SMITHS_TOOLS))
            .build();
    public static final Trait DWARVEN_COMBAT_TRAINING = builder().name("Dwarven Combat Training")
            .description("You have proficiency with the battleaxe, handaxe, throwing hammer, and warhammer.")
            .addProperty(MCDNDKeys.WEAPONS, Arrays.asList(Weapons.BATTLEAXE, Weapons.HANDAXE, Weapons.LIGHT_HAMMER, Weapons.WARHAMMER))
            .build();
    public static final Trait SPEED = builder().name("Speed")
            .description("Your movement speed is 25 feet.")
            .addProperty(MCDNDKeys.INTEGER, 25)
            .build();
    public static final Trait DWARVEN_RESILIENCE = builder().name("Dwarven Resilience")
            .description("You have advantage on saving throws against poison, and you have resistance against poison damage.")
            .addProperty(MCDNDKeys.DAMAGE_TYPE, MCDNDDamageTypes.POISON)
            .build();
    public static final Trait STONECUNNING = builder().name("Stonecunning")
            .description("Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient int the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.")
            .addProperty(MCDNDKeys.SKILL_TYPE, SkillTypes.HISTORY)
            .build();
    public static final Trait SUBRACES = builder().name("Subraces")
            .description("Two main subraces of dwarves populate the worlds of D&D: hill dwarves and mountain dwarves. Choose one of these subraces.")
            .addProperty(MCDNDKeys.SUBRACES, ImmutableMap.<String, TraitList>builder().put("Hill", TraitList.of(HillDwarfTraits.ALL)).put("Mountain", TraitList.of(MountainDwarfTraits.DWARF_MOUNTAIN_TRAITS)).build())
            .build();
    public static final List<Trait> ALL = Arrays.asList(ABILITY_SCORE_INCREASE, AGE, ALIGNMENT, DARKVISION, LANGUAGES,
            TOOL_PROFICIENCY, DWARVEN_COMBAT_TRAINING, SPEED, DWARVEN_RESILIENCE, STONECUNNING, SUBRACES);
}
