package musician101.mcdnd.character;

import musician101.mcdnd.abilityscore.AbilityScoreTypes;
import musician101.mcdnd.abilityscore.CharacterAbilityScores;
import musician101.mcdnd.equipment.armor.Armor;
import musician101.mcdnd.equipment.armor.Armor.ArmorTypes;

public class ArmorClass
{
    Armor armor;
    Armor shield;

    public ArmorClass(Armor armor)
    {
        this(armor, null);
    }

    public ArmorClass(Armor armor, Armor shield)
    {
        this.armor = armor;
        this.shield = shield;
    }

    public int getArmorClass(CharacterAbilityScores scores, int armorClassBonus)
    {
        int ac = armor.getArmorClass();
        if (armor.getType() != ArmorTypes.HEAVY)
            ac =+ scores.getAbilityMod(AbilityScoreTypes.DEX);

        if (shield != null)
            ac =+ shield.getArmorClass();

        return ac + armorClassBonus;
    }

    public void update(Armor armor)
    {
        if (armor.getType() == ArmorTypes.SHIELD)
        {
            this.shield = armor;
            return;
        }

        this.armor = armor;
    }
}
