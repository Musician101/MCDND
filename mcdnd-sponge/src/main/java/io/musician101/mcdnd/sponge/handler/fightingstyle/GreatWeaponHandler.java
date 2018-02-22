package io.musician101.mcdnd.sponge.handler.fightingstyle;

import io.musician101.mcdnd.sponge.dice.Dice;
import io.musician101.mcdnd.sponge.equipment.weapon.property.WeaponProperties;
import io.musician101.mcdnd.sponge.equipment.weapon.property.WeaponProperty;
import io.musician101.mcdnd.sponge.event.PlayerAttackEntityEvent;
import io.musician101.mcdnd.sponge.reference.MenuText;
import io.musician101.musicianlibrary.java.minecraft.gui.chest.GUIButton;
import io.musician101.musicianlibrary.java.minecraft.sponge.gui.SpongeIconBuilder;
import io.musician101.musicianlibrary.java.minecraft.sponge.gui.chest.SpongeChestGUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemTypes;

import static org.spongepowered.api.text.Text.of;

public class GreatWeaponHandler {

    private final Player player;
    private final Entity targetEntity;
    private List<Entry<Dice, Integer>> rolls;

    public GreatWeaponHandler(Player player, List<Entry<Dice, Integer>> rolls, List<WeaponProperty> weaponProperties, Entity targetEntity) {
        this.rolls = rolls;
        this.player = player;
        this.targetEntity = targetEntity;
        boolean offerReroll = false;
        for (Entry<Dice, Integer> roll : rolls) {
            if (roll.getValue() <= 2) {
                offerReroll = true;
            }
        }

        if (offerReroll && (weaponProperties.contains(WeaponProperties.TWO_HANDED) || weaponProperties.contains(WeaponProperties.VERSATILE_D8) || weaponProperties.contains(WeaponProperties.VERSATILE_D10))) {
            SpongeChestGUI.builder().setSize(9).setName(of(MenuText.REROLL)).setPlayer(player).setBackButton(8, ClickInventoryEvent.Primary.class).setButtons(GUIButton.of(0, ClickInventoryEvent.Primary.class, SpongeIconBuilder.builder(ItemTypes.WOOL).type(Keys.DYE_COLOR, DyeColors.GREEN).name(of(MenuText.YES)).build(), (g, p) -> handle(true)), GUIButton.of(1, ClickInventoryEvent.Primary.class, SpongeIconBuilder.builder(ItemTypes.WOOL).type(Keys.DYE_COLOR, DyeColors.RED).name(of(MenuText.NO)).build(), (g, p) -> handle(true))).build();
        }
        else {
            handle(false);
        }
    }

    public void handle(boolean reroll) {
        if (player.isViewingInventory()) {
            return;
        }

        if (reroll) {
            List<Entry<Dice, Integer>> rolls = new ArrayList<>(this.rolls);
            this.rolls.clear();
            rolls.forEach(roll -> this.rolls.addAll(roll.getKey().roll()));
        }

        Sponge.getEventManager().post(new PlayerAttackEntityEvent(player, targetEntity, reroll, Cause.of(EventContext.builder().add(EventContextKeys.PLAYER, player).build(), player)));
    }
}
