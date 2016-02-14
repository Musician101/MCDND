package musician101.mcdnd.character;

import musician101.mcdnd.alignment.Alignments;
import musician101.mcdnd.clazz.ProficiencyBonus;
import musician101.mcdnd.equipment.armor.Armor;
import musician101.mcdnd.race.Race;
import musician101.mcdnd.skill.SkillCarrier;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;

public class PlayerCharacter extends Character<Player>
{
    ProficiencyBonus proficiencyBonus;
    private Alignments alignment;
    private ArmorClass armorClass;
    private int armorClassBonus;
    private Race race;
    private SkillCarrier skills;

    public PlayerCharacter(Player player)
    {
        super(player);
    }

    @Override
    public Player getEntity()
    {
        for (Player player : Sponge.getServer().getOnlinePlayers())
            if (player.getUniqueId() == uuid)
                return player;

        return null;
    }

    public Alignments getAlignment()
    {
        return alignment;
    }

    public void updateArmorClass(Armor armor)
    {
        armorClass.update(armor);
    }

    @Override
    public int getArmorClass()
    {
        return armorClass.getArmorClass(scores, armorClassBonus);
    }

    public Race getRace()
    {
        return race;
    }

    public void setRace(Race race)
    {
        this.race = race;
    }

    public SkillCarrier getSkillCarrier()
    {
        return skills;
    }
}
