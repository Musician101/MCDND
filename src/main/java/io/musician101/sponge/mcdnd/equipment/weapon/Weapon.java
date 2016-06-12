package io.musician101.sponge.mcdnd.equipment.weapon;

import io.musician101.sponge.mcdnd.combat.Damage;
import io.musician101.sponge.mcdnd.currency.CurrencyHolder.Cost;
import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.AbilityScoreData;
import io.musician101.sponge.mcdnd.data.manipulator.mutable.WeaponProficiencyData;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.WeaponType;
import io.musician101.sponge.mcdnd.equipment.Equipment;
import io.musician101.sponge.mcdnd.equipment.weapon.property.WeaponProperties;
import io.musician101.sponge.mcdnd.equipment.weapon.property.WeaponProperty;
import io.musician101.sponge.mcdnd.util.Interfaces.DamageDealer;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.util.annotation.CatalogedBy;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CatalogedBy(Weapons.class)
public class Weapon extends Equipment implements DamageDealer
{
    private final Damage damage;
    private final List<WeaponProperty> properties;
    private final WeaponType type;

    protected Weapon(String name, Cost cost, Damage damage, double weight, WeaponType type)
    {
        this(name, cost, damage, weight, new ArrayList<>(), type);
    }

    protected Weapon(String name, Cost cost, Damage damage, double weight, List<WeaponProperty> properties, WeaponType type)
    {
        super(name, cost, weight);
        this.damage = damage;
        this.properties = properties;
        this.type = type;
    }

    public Optional<Integer> rollDamage(AbilityScoreData score, WeaponProficiencyData weapons, boolean isRanged)
    {
        int mod = 0;
        if (weapons.contains(this))
            mod =+ 2;

        AbilityScoreType dex = AbilityScoreTypes.DEXTERITY;
        AbilityScoreType str = AbilityScoreTypes.STRENGTH;
        Optional<Integer> dexScore = score.get(dex);
        Optional<Integer> strScore = score.get(str);
        if (!dexScore.isPresent())
            return Optional.empty();

        if (!strScore.isPresent())
            return Optional.empty();

        int strMod = str.getMod(strScore.get());
        int dexMod = dex.getMod(dexScore.get());
        if (properties.contains(WeaponProperties.FINESSE))
            mod =+ Math.max(strMod, dexMod);
        else
        {
            if (isRanged)
                mod =+ dexMod;
            else
                mod =+ strMod;
        }

        return Optional.of(damage.rollDamage() + mod);
    }

    public WeaponType getType()
    {
        return type;
    }

    @Override
    public Damage getDamage()
    {
        return damage;
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
        return super.toContainer()
                .set(MCDNDKeys.DAMAGE, damage)
                .set(MCDNDKeys.WEAPON_PROPERTIES, properties)
                .set(MCDNDKeys.WEAPON_TYPE, type);
    }
}
