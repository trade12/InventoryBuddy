package com.trade12.inventorybuddy;

import com.trade12.inventorybuddy.Mob.EntityBuddy;
import com.trade12.inventorybuddy.Mob.Mob;
import com.trade12.inventorybuddy.Proxy.IProxy;
import com.trade12.inventorybuddy.References.Ref;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.world.biome.BiomeGenBase;

import java.rmi.registry.Registry;

@Mod(modid= Ref.MOD_ID, name=Ref.MOD_NAME, version=Ref.VERSION_NUMBER)
public class InventoryBuddy
{
    @Mod.Instance(Ref.MOD_ID)
    public static InventoryBuddy instance;

    @SidedProxy(clientSide = Ref.CLIENT_PROXY_CLASS, serverSide = Ref.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    //Config stuff here

    public static boolean LogDebug = true;



    @Mod.EventHandler
    public void preInt(FMLPreInitializationEvent event)
    {
        proxy.registerBlocks();
        //proxy.registerTileEntities();
        proxy.registerItems();
        EntityRegistry.addSpawn(EntityBuddy.class, 10, 2, 4, EnumCreatureType.monster);
        EntityList.addMapping(EntityBuddy.class, "Ref.Buddy", 5, 113213, 3523523);
            /* Network, Blocks and items initialization */
    }



@Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

            /* Wrap things up */
    }
}
