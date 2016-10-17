package io.musician101.mcdnd.sponge.menu;

import io.musician101.common.java.minecraft.sponge.menu.AbstractSpongeMenu;
import io.musician101.mcdnd.sponge.SpongeMCDND;
import io.musician101.mcdnd.sponge.data.key.MCDNDKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.custom.CustomInventory;
import org.spongepowered.api.text.translation.FixedTranslation;

import java.util.List;

public class EquipmentChoiceMenu extends AbstractSpongeMenu
{
    public EquipmentChoiceMenu(List<DataContainer> list)
    {
        super(SpongeMCDND.getPluginContainer(),
                CustomInventory.builder().name(new FixedTranslation("Equipment Choices")).size(list.size()).build(),
                event ->
                {

                });

        for (int i = 0; i < list.size() - 1; i++)
        {
            //TODO left off here
            DataContainer dc = list.get(i);
            //noinspection OptionalGetWithoutIsPresent
            setOption(i, ItemStack.of(dc.getObject(MCDNDKeys.ITEM_TYPE.getQuery(), ItemType.class).get(), 1), dc.getString(MCDNDKeys.STRING.getQuery()).get());
        }
    }
}
