package io.musician101.sponge.mcdnd.handler.fightingstyle;

import io.musician101.common.java.minecraft.sponge.menu.AbstractSpongeMenu;
import io.musician101.sponge.mcdnd.event.PlayerAttackEntityEvent;
import io.musician101.sponge.mcdnd.SpongeMCDND;
import io.musician101.sponge.mcdnd.dice.Dice;
import io.musician101.sponge.mcdnd.equipment.weapon.property.WeaponProperties;
import io.musician101.sponge.mcdnd.equipment.weapon.property.WeaponProperty;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.custom.CustomInventory;
import org.spongepowered.api.text.LiteralText;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.translation.FixedTranslation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

public class GreatWeaponHandler
{
    private final Entity targetEntity;
    private List<Entry<Dice, Integer>> rolls;
    private final Player player;

    public GreatWeaponHandler(Player player, List<Entry<Dice, Integer>> rolls, List<WeaponProperty> weaponProperties, Entity targetEntity)
    {
        this.rolls = rolls;
        this.player = player;
        this.targetEntity = targetEntity;
        boolean offerReroll = false;
        for (Entry<Dice, Integer> roll : rolls)
            if (roll.getValue() <= 2)
                offerReroll = true;

        if (offerReroll && (weaponProperties.contains(WeaponProperties.TWO_HANDED) || weaponProperties.contains(WeaponProperties.VERSATILE_D8) || weaponProperties.contains(WeaponProperties.VERSATILE_D10)))
            new Menu(this).open(player.getUniqueId());
        else
            handle(false);
    }

    public void handle(boolean reroll)
    {
        if (player.isViewingInventory())
            return;

        if (reroll)
        {
            List<Entry<Dice, Integer>> rolls = new ArrayList<>();//NOSONAR
            rolls.addAll(this.rolls);
            this.rolls.clear();
            rolls.forEach(roll -> this.rolls.addAll(roll.getKey().roll()));
        }

        Sponge.getEventManager().post(new PlayerAttackEntityEvent(player, targetEntity, reroll, Cause.of(NamedCause.source(SpongeMCDND.instance()), NamedCause.simulated(player))));
    }

    private static class Menu extends AbstractSpongeMenu
    {
        private Menu(GreatWeaponHandler gwh)
        {
            super(SpongeMCDND.getPluginContainer(), CustomInventory.builder().name(new FixedTranslation("Reroll?")).size(2).build(), event ->
            {
                event.setWillClose(true);
                event.setWillDestroy(true);
                Optional<Text> nameOptional = event.getItem().get(Keys.DISPLAY_NAME);
                if (nameOptional.isPresent())
                {
                    LiteralText name = (LiteralText) nameOptional.get();
                    if ("Yes".equalsIgnoreCase(name.getContent()))
                        gwh.handle(true);
                    else
                        gwh.handle(false);
                }
            });

            setOption(0, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.GREEN).quantity(1).build(), "Yes");
            setOption(1, ItemStack.builder().itemType(ItemTypes.WOOL).add(Keys.DYE_COLOR, DyeColors.RED).quantity(1).build(), "No");
        }
    }
}
