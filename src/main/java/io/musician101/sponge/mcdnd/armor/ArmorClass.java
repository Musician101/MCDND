package io.musician101.sponge.mcdnd.armor;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.equipment.armor.Armor;
import io.musician101.sponge.mcdnd.equipment.armor.Armor.ArmorTypes;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.Queries;

import javax.annotation.Nonnull;
import java.util.Map;

public class ArmorClass implements DataSerializable
{
    private final Armor armor;
    private final Armor shield;
    private final int bonus;

    public ArmorClass(Armor armor)
    {
        this(armor, null);
    }

    public ArmorClass(Armor armor, Armor shield)
    {
        this(armor, shield, 0);
    }

    public ArmorClass(Armor armor, Armor shield, int bonus)
    {
        this.armor = armor;
        this.shield = shield;
        this.bonus = bonus;
    }

    public int getArmorClass(Map<AbilityScoreType, Integer> scores)
    {
        AbilityScoreType dex = AbilityScoreTypes.DEXTERITY;
        if (scores.containsKey(dex))
            throw new IllegalArgumentException("Dexterity not found in ArmorClass.getArmorClass()");

        int ac = armor.getArmorClass();
        int dexMod = dex.getMod(scores.get(dex));
        if (armor.getType() == ArmorTypes.LIGHT)
            ac =+ dexMod;
        else if (armor.getType() == ArmorTypes.MEDIUM)
        {
            if (dexMod > 2)
                ac =+ 2;
            else
                ac =+ dexMod;
        }

        if (shield != null)
            ac =+ shield.getArmorClass();

        return ac + bonus;
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
                .set(Queries.CONTENT_VERSION, getContentVersion())
                .set(MCDNDKeys.ARMOR, armor)
                .set(MCDNDKeys.SHIELD, shield)
                .set(MCDNDKeys.ARMOR_CLASS_BONUS, bonus);
    }
}
