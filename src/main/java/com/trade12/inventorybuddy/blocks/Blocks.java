package com.trade12.inventorybuddy.blocks;

import com.trade12.inventorybuddy.References.Ref;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.StatCollector;

/**
 * Created by kieran on 27/06/2014.
 */
public enum Blocks {
    //MACHINE_ENERGETICINCINERATOR("machine.energeticincinerator", new BlockEnergeticIncinerator(), ModCreativeTabs.Machines) **Example**
    ;

    private final String internalName;
    public final Block block;
    private final Class<? extends ItemBlock> itemBlockClass;
    private final CreativeTabs creativeTabs;

    Blocks(String internalName, Block block)
    {
        this(internalName, block, ItemBlock.class, null);
    }

    Blocks(String internalName, Block block, CreativeTabs creativeTabs)
    {
        this(internalName, block, ItemBlock.class, creativeTabs);
    }

    Blocks(String internalName, Block block, Class<? extends ItemBlock> itemBlockClass)
    {
        this(internalName, block, itemBlockClass, null);
    }

    Blocks(String internalName, Block block, Class<? extends ItemBlock> itemBlockClass, CreativeTabs creativeTabs)
    {
        this.internalName = internalName;
        this.block = block;
        this.itemBlockClass = itemBlockClass;
        this.creativeTabs = creativeTabs;
        block.setBlockName(Ref.MOD_ID + "." + internalName);
    }

    public String getInternalName()
    {
        return internalName;
    }

    public String getStatName()
    {
        return StatCollector.translateToLocal(block.getUnlocalizedName().replace("tile.", "block."));
    }

    private static boolean registered = false;

    private void register()
    {
        GameRegistry.registerBlock(block.setCreativeTab(creativeTabs).setBlockTextureName(Ref.MOD_ID + ":" + internalName), itemBlockClass, "tile." + internalName);
    }

    public static void registerAll()
    {
        if(registered)
            return;
        for(Blocks b : Blocks.values())
            b.register();
        registered = true;
    }
}