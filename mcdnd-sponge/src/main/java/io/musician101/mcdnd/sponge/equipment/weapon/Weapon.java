package io.musician101.mcdnd.sponge.equipment.weapon;

import io.musician101.mcdnd.sponge.clazz.ProficiencyBonus;
import io.musician101.mcdnd.sponge.combat.Damage;
import io.musician101.mcdnd.sponge.currency.CurrencyHolder.Cost;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreType;
import io.musician101.mcdnd.sponge.data.type.AbilityScoreTypes;
import io.musician101.mcdnd.sponge.data.type.CharacterClassType;
import io.musician101.mcdnd.sponge.data.type.WeaponType;
import io.musician101.mcdnd.sponge.equipment.Equipment;
import io.musician101.mcdnd.sponge.equipment.weapon.property.WeaponProperties;
import io.musician101.mcdnd.sponge.equipment.weapon.property.WeaponProperty;
import io.musician101.mcdnd.sponge.util.Interfaces.DamageDealer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(Weapons.class)
public class Weapon extends Equipment implements DamageDealer {

    private final Damage damage;
    private final List<WeaponProperty> properties;
    private final WeaponType type;

    protected Weapon(String name, Cost cost, Damage damage, double weight, WeaponType type) {
        this(name, cost, damage, weight, new ArrayList<>(), type);
    }

    protected Weapon(String name, Cost cost, Damage damage, double weight, List<WeaponProperty> properties, WeaponType type) {
        super(name, cost, weight);
        this.damage = damage;
        this.properties = properties;
        this.type = type;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public Damage getDamage() {
        return damage;
    }

    public List<WeaponProperty> getProperties() {
        return properties;
    }

    public WeaponType getType() {
        return type;
    }

    public Optional<Integer> rollDamage(Player player, boolean isRanged) {
        int mod;
        Optional<Map<AbilityScoreType, Integer>> asdOptional = player.get(MCDNDKeys.ABILITY_SCORES);
        Optional<Map<CharacterClassType, Integer>> ccdOptional = player.get(MCDNDKeys.CHARACTER_CLASSES);
        Optional<List<Weapon>> wpOptional = player.get(MCDNDKeys.WEAPON_PROFICIENCIES);
        if (asdOptional.isPresent() && ccdOptional.isPresent() && wpOptional.isPresent()) {
            List<Weapon> weapons = wpOptional.get();
            Map<CharacterClassType, Integer> classes = ccdOptional.get();
            Map<AbilityScoreType, Integer> scores = asdOptional.get();
            AbilityScoreType dex = AbilityScoreTypes.DEXTERITY;
            AbilityScoreType str = AbilityScoreTypes.STRENGTH;
            Integer dexScore = scores.get(dex);
            Integer strScore = scores.get(str);
            if (dexScore != null && strScore != null) {
                int strMod = str.getMod(strScore);
                int dexMod = dex.getMod(dexScore);
                if (properties.contains(WeaponProperties.FINESSE)) {
                    mod = +Math.max(strMod, dexMod);
                }
                else {
                    if (isRanged) {
                        mod = +dexMod;
                    }
                    else {
                        mod = +strMod;
                    }
                }

                if (weapons.contains(this)) {
                    mod = +ProficiencyBonus.getBonus(classes);
                }

                return Optional.of(damage.rollDamage() + mod);
            }
        }

        return Optional.empty();
    }

    @Nonnull
    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(MCDNDKeys.DAMAGE, damage).set(MCDNDKeys.WEAPON_PROPERTIES, properties).set(MCDNDKeys.WEAPON_TYPE, type);
    }
}
