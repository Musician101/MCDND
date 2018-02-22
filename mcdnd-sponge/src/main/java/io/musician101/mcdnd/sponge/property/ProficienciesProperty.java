package io.musician101.mcdnd.sponge.property;

import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorType;
import io.musician101.mcdnd.sponge.data.type.skill.SkillType;
import io.musician101.mcdnd.sponge.equipment.tool.Tool;
import io.musician101.mcdnd.sponge.equipment.weapon.Weapon;
import java.util.List;

@Deprecated
public class ProficienciesProperty {

    private final List<MCDNDArmorType> armor;
    private final String armorString;
    private final String savingThrowString;
    private final List<AbilityScoreType> savingThrows;
    private final int skillAmount;
    private final String skillString;
    private final List<SkillType> skills;
    private final String toolString;
    private final List<Tool> tools;
    private final String weaponString;
    private final List<Weapon> weapons;

    public ProficienciesProperty(List<MCDNDArmorType> armor, String armorString, List<Weapon> weapons, String weaponString, List<Tool> tools, String toolString, List<AbilityScoreType> savingThrows, String savingThrowString, List<SkillType> skills, int skillAmount, String skillString) {
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

    public List<MCDNDArmorType> getArmorProficiency() {
        return armor;
    }

    public String getArmorString() {
        return armorString;
    }

    public List<AbilityScoreType> getSavingThrowProficiency() {
        return savingThrows;
    }

    public String getSavingThrowString() {
        return savingThrowString;
    }

    public int getSkillAmount() {
        return skillAmount;
    }

    public List<SkillType> getSkillProficiency() {
        return skills;
    }

    public String getSkillString() {
        return skillString;
    }

    public List<Tool> getToolProficiency() {
        return tools;
    }

    public String getToolString() {
        return toolString;
    }

    public List<Weapon> getWeaponProficiency() {
        return weapons;
    }

    public String getWeaponString() {
        return weaponString;
    }
}
