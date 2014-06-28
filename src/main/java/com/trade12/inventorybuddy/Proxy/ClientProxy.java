package com.trade12.inventorybuddy.Proxy;

import com.trade12.inventorybuddy.Mob.EntityBuddy;
import com.trade12.inventorybuddy.Mob.RendererBuddy;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Created by kieran on 27/06/2014.
 */
public class ClientProxy extends CommonProxy {

    public static void init(){
        RenderingRegistry.registerEntityRenderingHandler(EntityBuddy.class, new RendererBuddy());
    }


}