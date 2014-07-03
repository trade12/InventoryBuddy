package com.trade12.inventorybuddy.tileentity;

import com.trade12.inventorybuddy.References.Ref;
import com.trade12.inventorybuddy.helpers.Vector3n;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
/**
public enum Tiles  {

   // MACHINE_ENERGETICINCINERATOR(TileEntityEnergeticIncinerator.class, "energeticincinerator"); **Example**
    // AUTOFEEDERAREA(AutoFeederAreaTile.class, "autofeederarea");

    public final Class<? extends TileEntity> tileClass;
    private final String ID;
    Tiles(Class<? extends TileEntity> clazz, String identifier)
    {
        tileClass = clazz;
        ID = identifier;
    }

    private void register()
    {
        GameRegistry.registerTileEntity(tileClass, "tile." + Ref.MOD_ID + "." + ID.toLowerCase());
    }

    public static void registerAll()
    {
        for(Tiles t : Tiles.values())
            t.register();
    }

    public static <T extends TileEntity> T getTileEntity(IBlockAccess access, Vector3n loc)
    {
        return Tiles.<T>getTileEntity(access, loc.x, loc.y, loc.z);
    }

    @SuppressWarnings("unchecked")
    public static <T extends TileEntity> T getTileEntity(IBlockAccess access, int x, int y, int z)
    {
        TileEntity te = access.getTileEntity(x, y, z);
        try
        {
            return (T)te;
        }
        catch(ClassCastException e)
        {
            return null;
        }
    }
}

/*