package com.trade12.inventorybuddy.Proxy;

import com.trade12.inventorybuddy.blocks.Blocks;
//import com.trade12.inventorybuddy.tileentity.Tiles;

/**
 * Created by kieran on 27/06/2014.
 */
public abstract class CommonProxy implements IProxy {
    // Register Blocks
    public void registerBlocks() {
        Blocks.registerAll();
    }

    // Register Tile Entities
    //public void registerTileEntities() {
        //Tiles.registerAll();
    //}

    // Register Items
    public void registerItems() {
        //Items.registerAll();
    }

    // Register Recipes
    public void registerRecipes() {

    }
}