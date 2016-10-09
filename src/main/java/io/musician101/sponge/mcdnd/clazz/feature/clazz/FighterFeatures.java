package io.musician101.sponge.mcdnd.clazz.feature.clazz;

import com.google.common.collect.ImmutableMap;
import io.musician101.sponge.mcdnd.clazz.feature.Feature;
import io.musician101.sponge.mcdnd.clazz.feature.subclass.fightingstyle.FightingStyles;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.skill.SkillTypes;
import io.musician101.sponge.mcdnd.dice.HitDice;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.MCDNDArmorTypes;
import io.musician101.sponge.mcdnd.equipment.armor.Armors;
import io.musician101.sponge.mcdnd.equipment.gear.AdventuringGear;
import io.musician101.sponge.mcdnd.equipment.pack.Packs;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapons;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import java.util.Arrays;
import java.util.Collections;

import static io.musician101.sponge.mcdnd.clazz.feature.Feature.builder;

public class FighterFeatures
{
    public static final Feature HP = builder().name("Hit Points").addProperty(MCDNDKeys.HIT_DICE, new HitDice(10)).build();
    public static final Feature PROFICIENCIES = builder().name("Proficiencies")
            .addProperty(MCDNDKeys.ARMOR_TYPES, Arrays.asList(MCDNDArmorTypes.values()))
            .addProperty(MCDNDKeys.ARMOR_STRING, "All armor, shields")
            .addProperty(MCDNDKeys.WEAPONS, Weapons.getAll())
            .addProperty(MCDNDKeys.WEAPON_STRING, "Simple weapons, martial weapons")
            .addProperty(MCDNDKeys.TOOLS, Collections.emptyList()).addProperty(MCDNDKeys.TOOL_STRING, "None")
            .addProperty(MCDNDKeys.ABILITY_SCORE_TYPES, Arrays.asList(AbilityScoreTypes.STRENGTH, AbilityScoreTypes.CONSTITUTION))
            .addProperty(MCDNDKeys.SAVING_THROW_STRING, "Strength, Constitution")
            .addProperty(MCDNDKeys.SKILL_TYPES, Arrays.asList(SkillTypes.ACROBATICS, SkillTypes.ANIMAL_HANDLING, SkillTypes.ATHLETICS, SkillTypes.HISTORY, SkillTypes.INSIGHT, SkillTypes.INTIMIDATION, SkillTypes.PERCEPTION, SkillTypes.SURVIVAL))
            .addProperty(MCDNDKeys.SKILL_AMOUNT, 2)
            .addProperty(MCDNDKeys.SKILL_STRING, "Choose two skills from Acrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, and Survival")
            .build();
    public static final Feature EQUIPMENT = builder().name("Equipment")
            .addProperty(MCDNDKeys.EQUIPMENT_CHOICES, ImmutableMap.<String, DataContainer>builder()
                    .put("(a) chain mail or (b) leather, longbow, and 20 arrows", new MemoryDataContainer()
                            .set(MCDNDKeys.CHOICE_A, new MemoryDataContainer().set(MCDNDKeys.ARMOR, Armors.CHAIN_MAIL))
                            .set(MCDNDKeys.CHOICE_B, new MemoryDataContainer().set(MCDNDKeys.ARMOR, Armors.LEATHER)
                                .set(MCDNDKeys.WEAPON, Weapons.LONGBOW).set(MCDNDKeys.GEAR, AdventuringGear.ARROWS)))
                    .put("(a) a martial weapon and a shield or (b) two martial weapons", new MemoryDataContainer()
                            .set(MCDNDKeys.CHOICE_A, new MemoryDataContainer()
                                    .set(MCDNDKeys.WEAPON_LIST_INTEGER_MAP, Collections.singletonMap(Weapons.getMartialWeapons(), 1))
                                    .set(MCDNDKeys.ARMOR, Armors.SHIELD)))
                    .put("(a) light crossbow and 20 bolts or (b) two handaxes", new MemoryDataContainer()
                            .set(MCDNDKeys.CHOICE_A, new MemoryDataContainer()
                                    .set(MCDNDKeys.WEAPON, Weapons.LIGHT_CROSSBOW)
                                    .set(MCDNDKeys.GEAR, AdventuringGear.CASE_CROSSBOW_BOLT)
                            .set(MCDNDKeys.CHOICE_B, new MemoryDataContainer()
                                    .set(MCDNDKeys.WEAPON_INTEGER_MAP, Collections.singletonMap(Weapons.HANDAXE, 2)))))
                    .put("(a) a dungeoneer's pack or (b) an explorer's pack", new MemoryDataContainer()
                            .set(MCDNDKeys.CHOICE_A, new MemoryDataContainer())
                                    .set(MCDNDKeys.PACK, Packs.DUNGEONEERS_PACK)).build()).build();
    public static final Feature FIGHTING_STYLE = builder().name("Fighting Style")
            .addProperty(MCDNDKeys.FIGHTING_STYLES, Arrays.asList(FightingStyles.ARCHERY, FightingStyles.DEFENSE,
                    FightingStyles.DUELING, FightingStyles.GREAT_WEAPON_FIGHTING, FightingStyles.PROTECTION, FightingStyles.TWO_WEAPON_FIGHTING))
            .build();
    //TODO left off here page 66

    private FighterFeatures()
    {

    }
}
