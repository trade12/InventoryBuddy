package com.trade12.inventorybuddy.Mob;

import com.trade12.inventorybuddy.References.Ref;
import cpw.mods.fml.common.registry.EntityRegistry;

public final class Mob {

    public static void init(){
        int id = 0;
        EntityRegistry.registerModEntity(EntityBuddy.class, Ref.BUDDY, id++, Ref.MOD_ID, 64, 10, true);
    }
}