package com.trade12.inventorybuddy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="InventoryBuddy", name="Inventory Buddy", version="1.7.2-1.0")
public class InventoryBuddy
{
    @Mod.Instance("InventoryBuddy")
    public static InventoryBuddy instance;


    @Mod.EventHandler
    public void preInt(FMLPreInitializationEvent event)
    {
            /* Network, Blocks and items initialization */
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
            /* Register GUI, recipes, TE's */
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
            /* Wrap things up */
    }
}
    