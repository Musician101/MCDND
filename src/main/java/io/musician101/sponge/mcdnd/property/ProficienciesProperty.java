package io.musician101.sponge.mcdnd.property;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.skill.SkillType;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.ArmorTypes;
import io.musician101.sponge.mcdnd.equipment.tool.Tool;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapon;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nonnull;
import java.util.List;

public class ProficienciesProperty extends MCDNDProperty
{
    private final int skillAmount;
    private final List<ArmorTypes> armor;
    private final List<AbilityScoreType> savingThrows;
    private final List<SkillType> skills;
    private final List<Tool> tools;
    private final List<Weapon> weapons;
    private final String armorString;
    private final String toolString;
    private final String savingThrowString;
    private final String skillString;
    private final String weaponString;

    public ProficienciesProperty(List<ArmorTypes> armor, String armorString, List<Weapon> weapons, String weaponString, List<Tool> tools, String toolString, List<AbilityScoreType> savingThrows, String savingThrowString, List<SkillType> skills, int skillAmount, String skillString)
    {
        this.armor = armor;
        this.armorString = armorString;
        this.weapons = weapons;
        this.weaponString = weaponString;
        this.tools = tools;
        this.toolString = toolString;
        this.savingThrows = savingThrows;
        this.savingThrowString = savingThrowString;
        this.skills = skills;
        this.skillAmount = skillAmount;
        this.skillString = skillString;
    }

    public int getSkillAmount()
    {
        return skillAmount;
    }

    public List<ArmorTypes> getArmorProficiency()
    {
        return armor;
    }

    public List<AbilityScoreType> getSavingThrowProficiency()
    {
        return savingThrows;
    }

    public List<SkillType> getSkillProficiency()
    {
        return skills;
    }

    public List<Tool> getToolProficiency()
    {
        return tools;
    }

    public List<Weapon> getWeaponProficiency()
    {
        return weapons;
    }

    public String getArmorString()
    {
        return armorString;
    }

    public String getToolString()
    {
        return toolString;
    }

    public String getSavingThrowString()
    {
        return savingThrowString;
    }

    public String getSkillString()
    {
        return skillString;
    }

    public String getWeaponString()
    {
        return weaponString;
    }

    @Override
    public int getContentVersion()
    {
        return 1;
    }

    @Nonnull
    @Override
    public DataContainer toContainer()
    {
        return new MemoryDataContainer()
                .set(MCDNDKeys.ARMOR_TYPES, armor)
                .set(MCDNDKeys.ARMOR_STRING, armorString)
                .set(MCDNDKeys.ABILITY_SCORE_TYPES, savingThrows)
                .set(MCDNDKeys.SAVING_THROW_STRING, savingThrowString)
                .set(MCDNDKeys.SKILL_TYPES, skills)
                .set(MCDNDKeys.SKILL_AMOUNT, skillAmount)
                .set(MCDNDKeys.SKILL_STRING, skillString)
                .set(MCDNDKeys.TOOLS, tools)
                .set(MCDNDKeys.TOOL_STRING, toolString)
                .set(MCDNDKeys.WEAPONS, weapons)
                .set(MCDNDKeys.WEAPON_STRING, weaponString);
    }

}
