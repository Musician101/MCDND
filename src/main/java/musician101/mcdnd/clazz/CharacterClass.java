package musician101.mcdnd.clazz;

import musician101.mcdnd.equipment.armor.Armor;
import musician101.mcdnd.skill.SkillType;

import java.util.List;

public class CharacterClass
{
    private List<Armor> armorProficiencies;
    private List<SkillType> skillProficiencies;
    private HitDice hitDice;
    private int level;
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

    public String getName()
    {
        return name;
    }
}
