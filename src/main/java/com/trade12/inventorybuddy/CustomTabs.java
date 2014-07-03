package com.trade12.inventorybuddy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by kieran on 03/07/2014.
 */
public class CustomTabs {
    public static CreativeTabs tabInventoryBuddy;

    public static void init() {
        tabInventoryBuddy = new CreativeTabs("tabHydraulicraft") {
            public ItemStack getIconItemStack() {
                return new ItemStack(Items.blaze_rod, 1, 0);
            }

            @Override
            public Item getTabIconItem() {
                return Items.dye;
            }
        };
    }
}
