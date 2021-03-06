package com.trade12.inventorybuddy.items;

import com.trade12.inventorybuddy.CustomTabs;
import com.trade12.inventorybuddy.InventoryBuddy;
import com.trade12.inventorybuddy.Util.GuiHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import javax.swing.*;

/**
 * Created by kieran on 03/07/2014.
 */
public class ItemDevNull extends Item {
    public static class Icons {
        public static Icon iconFull;
        public static Icon iconTransparent;
    }

    public ItemDevNull() {
        super();
        setCreativeTab(CustomTabs.tabInventoryBuddy);
        setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) player.openGui(InventoryBuddy.instance, GuiHandler.GuiId.devNull.ordinal(), world, player.inventory.currentItem, 0, 0);
        return stack;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        ItemInventory inventory = new ItemInventory(player, 1);
        ItemStack containedStack = inventory.getStackInSlot(0);
        if (containedStack != null) {
            Item item = containedStack.getItem();
            if (item instanceof ItemBlock) {
                boolean response = ((ItemBlock)item).onItemUse(containedStack, player, world, x, y, z, par7, par8, par9, par10);
                if (containedStack.stackSize == 0) {
                    inventory.setInventorySlotContents(0, null);
                }
                inventory.onInventoryChanged();
                return response;
            }
        }
        return true;
    }

    @SubscribeEvent
    public void onItemPickUp(EntityItemPickupEvent evt) {

        EntityPlayer player = evt.entityPlayer;
        ItemStack pickedStack = evt.item.getEntityItem();

        final ItemStack compareStack = new ItemStack(this);

        boolean foundMatchingContainer = false;

        if (pickedStack != null && player != null) {

            for (int i = 0; i < player.inventory.getSizeInventory(); i++) {

                ItemStack stack = player.inventory.getStackInSlot(i);

                if (stack != null && stack.isItemEqual(compareStack)) {

                    ItemInventory inventory = new ItemInventory(player, 1, i);
                    ItemStack containedStack = inventory.getStackInSlot(0);
                    if (containedStack != null) {
                        boolean isMatching = pickedStack.isItemEqual(containedStack)
                                && ItemStack.areItemStackTagsEqual(pickedStack, containedStack);
                        foundMatchingContainer |= isMatching;
                        if (isMatching) {
                            InventoryUtils.tryInsertStack(inventory, 0, pickedStack, true);
                        }
                    }
                }
            }
        }

        if (foundMatchingContainer) {
            pickedStack.stackSize = 0;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        IIcon.iconTransparent = itemIcon = register.registerIcon("inventorybuddy:devnull");
        IIcon.iconFull = register.registerIcon("inventorybuddy:devfull");
    }
}
