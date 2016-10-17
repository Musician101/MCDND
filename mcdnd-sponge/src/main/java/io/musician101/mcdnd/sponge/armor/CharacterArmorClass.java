package io.musician101.mcdnd.sponge.armor;

import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.data.type.MCDNDArmorTypes;
import io.musician101.mcdnd.sponge.equipment.armor.Armor;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.Queries;

import javax.annotation.Nonnull;
import java.util.Map;

public class CharacterArmorClass implements DataSerializable
{
    private final Armor armor;
    private final Armor shield;
    private final int bonus;

    public CharacterArmorClass(Armor armor)
    {
        this(armor, null);
    }

    public CharacterArmorClass(Armor armor, Armor shield)
    {
        this(armor, shield, 0);
    }

    public CharacterArmorClass(Armor armor, Armor shield, int bonus)
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
        if (armor.getType() == MCDNDArmorTypes.LIGHT)
            ac =+ dexMod;
        else if (armor.getType() == MCDNDArmorTypes.MEDIUM)
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
