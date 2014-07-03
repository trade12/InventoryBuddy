package com.trade12.inventorybuddy.Util;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import sun.rmi.runtime.Log;

/**
 * Created by kieran on 03/07/2014.
 */
public class GuiHandler implements IGuiHandler {
    public static enum GuiId {
        devNull;

        public static final GuiId[] VALUES = GuiId.values();
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        final GuiId guiId = getGuiId(id);
        if (guiId == null) return null;

        switch (guiId) {
            case devNull:
                if (player.inventory.getCurrentItem() == null) return null;
                return new ContainerDevNull(player.inventory, new ItemInventory(player, 1));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        final GuiId guiId = getGuiId(id);
        if (guiId == null) return null;

        switch (guiId) {
            case devNull:
                return new GuiDevNull((ContainerDevNull)getServerGuiElement(id, player, world, x, y, z));
            default:
                return null;
        }
    }

    private static GuiId getGuiId(int id) {
        try {
            return GuiId.VALUES[id];
        } catch (ArrayIndexOutOfBoundsException e) {
            FMLLog.warning("Invalid GUI id: %d", id);
            return null;
        }
    }
}
