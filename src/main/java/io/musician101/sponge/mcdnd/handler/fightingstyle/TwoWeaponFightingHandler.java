package io.musician101.sponge.mcdnd.handler.fightingstyle;

import io.musician101.sponge.mcdnd.data.key.MCDNDKeys;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreType;
import io.musician101.sponge.mcdnd.data.type.AbilityScoreTypes;
import io.musician101.sponge.mcdnd.data.type.WeaponTypes;
import io.musician101.sponge.mcdnd.equipment.EquippedItems;
import io.musician101.sponge.mcdnd.equipment.weapon.Weapon;
import io.musician101.sponge.mcdnd.equipment.weapon.property.WeaponProperties;
import io.musician101.sponge.mcdnd.handler.Handler;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Map;
import java.util.Optional;

public class TwoWeaponFightingHandler implements Handler<Optional<Integer>>
{
    private final Player player;
    private final Weapon weapon;

    public TwoWeaponFightingHandler(Player player, Weapon weapon)
    {
        this.player = player;
        this.weapon = weapon;
    }

    @Override
    public Optional<Integer> handle()//NOSONAR
    {
        Optional<Integer> attackRoll = weapon.rollDamage(player, true);
        Optional<Map<AbilityScoreType, Integer>> asdOptional = player.get(MCDNDKeys.ABILITY_SCORES);
        Optional<EquippedItems> eiOptional = player.get(MCDNDKeys.EQUIPPED_ITEMS);
        if (attackRoll.isPresent() && asdOptional.isPresent() && eiOptional.isPresent())
        {
            EquippedItems ei = eiOptional.get();
            if (ei.getMainHand() != ei.getOffHand())
            {
                AbilityScoreType abilityScoreType = null;
                Map<AbilityScoreType, Integer> asd = asdOptional.get();
                if (weapon.getProperties().contains(WeaponProperties.FINESSE))
                    abilityScoreType = asd.get(AbilityScoreTypes.DEXTERITY) >= asd.get(AbilityScoreTypes.STRENGTH) ? AbilityScoreTypes.DEXTERITY : AbilityScoreTypes.STRENGTH;
                else if (weapon.getType() == WeaponTypes.MARTIAL_MELEE || weapon.getType() == WeaponTypes.SIMPLE_MELEE)
                    abilityScoreType = AbilityScoreTypes.STRENGTH;
                else if (weapon.getType() == WeaponTypes.MARTIAL_RANGED || weapon.getType() == WeaponTypes.SIMPLE_RANGED)
                    abilityScoreType = AbilityScoreTypes.DEXTERITY;

                return Optional.of(attackRoll.get() + ((asd.get(abilityScoreType) - 10) / 2));
            }

            return Optional.of(attackRoll.get());
        }

        return Optional.empty();
    }
}
