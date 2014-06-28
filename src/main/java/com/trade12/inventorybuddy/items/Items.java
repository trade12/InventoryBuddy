package com.trade12.inventorybuddy.items;

import com.trade12.inventorybuddy.References.Ref;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public enum Items {
    // CARD_EXPORTBUSUPGRADE("card.exportbusupgrade", new ItemExportBusCard(), ModCreativeTabs.Machines), **Example**


    ;
    private final String internalName;
    public final Item item;

    Items(String internalName, Item item, CreativeTabs creativeTabs) {
        this.internalName = internalName;
        this.item = item.setTextureName(Ref.MOD_ID + ":" + internalName);
        item.setUnlocalizedName(Ref.MOD_ID + "." + internalName);
        item.setCreativeTab(creativeTabs);
    }

    private void register() {
        GameRegistry.registerItem(item, internalName);
    }

    public String getInternalName() {
        return internalName;
    }

    public String getStatName() {
        return StatCollector.translateToLocal(item.getUnlocalizedName());
    }

    public ItemStack getStack(int damage, int size) {
        return new ItemStack(item, size, damage);
    }

    public static void registerAll() {
        for (Items i : Items.values())
            i.register();
    }
}