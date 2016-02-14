package musician101.mcdnd.clazz;

import musician101.mcdnd.equipment.armor.Armor;
import musician101.mcdnd.skill.SkillType;
import musician101.mcdnd.util.Interfaces.Named;

import java.util.List;

public class CharacterClass implements Named
{
    private HitDice hitDice;
    private int level;
    private List<Armor> armorProficiencies;
    private List<SkillType> skillProficiencies;
    private String name;

    public CharacterClass()
    {

    }

    public List<Armor> getArmorProficiencies()
    {
        return armorProficiencies;
    }

    public List<SkillType> getSkillProficiencies()
    {
        return skillProficiencies;
    }

    public HitDice getHitDice()
    {
        return hitDice;
    }

    public int getLevel()
    {
        return level;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
