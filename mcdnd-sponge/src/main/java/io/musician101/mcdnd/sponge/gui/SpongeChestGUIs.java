package io.musician101.mcdnd.sponge.gui;

import io.musician101.mcdnd.sponge.handler.fightingstyle.GreatWeaponHandler;
import io.musician101.mcdnd.sponge.reference.MenuText;
import io.musician101.musicianlibrary.java.minecraft.gui.chest.GUIButton;
import io.musician101.musicianlibrary.java.minecraft.sponge.gui.SpongeIconBuilder;
import io.musician101.musicianlibrary.java.minecraft.sponge.gui.chest.SpongeChestGUI;
import io.musician101.musicianlibrary.java.minecraft.sponge.gui.chest.SpongeChestGUIBuilder;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemTypes;

import static org.spongepowered.api.text.Text.of;

public final class SpongeChestGUIs {

    @Nonnull
    protected SpongeChestGUIBuilder builder(int size, int backButtonSlot, @Nonnull String name, @Nonnull Player player, @Nullable SpongeChestGUI prevGUI) {
        return SpongeChestGUI.builder().setSize(size).setName(of(name)).setPlayer(player).setPreviousGUI(prevGUI).setBackButton(backButtonSlot, ClickInventoryEvent.Primary.class);
    }

    public void greatWeaponHandler(@Nonnull Player player, @Nonnull GreatWeaponHandler greatWeaponHandler) {
        builder(9, 8, MenuText.REROLL, player, null).setButtons(GUIButton.of(0, ClickInventoryEvent.Primary.class, SpongeIconBuilder.builder(ItemTypes.WOOL).type(Keys.DYE_COLOR, DyeColors.GREEN).build(), (g, p) -> {

        })).build();
    }
}
