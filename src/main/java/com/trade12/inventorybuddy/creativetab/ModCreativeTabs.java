package com.trade12.inventorybuddy.creativetab;

import com.trade12.inventorybuddy.References.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ModCreativeTabs {
    public static final CreativeTabs Machines = new CreativeTabs(Ref.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return Items.fire_charge;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public String getTranslatedTabLabel() {
            return "Inventory Buddy";
        }
    };
}
