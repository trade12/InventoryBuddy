package com.trade12.inventorybuddy.tileentity;

import net.minecraft.inventory.ISidedInventory;

import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;


public class AutoFeederAreaTile extends TileBasicInventory implements ISidedInventory {

    public static final int BASE_RANGE = 8;
    public static final int EXTENDERS_PER_BLOCK = 4;
    public static final int SCAN_INTERVAL = 40;
    public static final int RESCAN_INTERVAL = 5;
    private int timer;

    public AutoFeederTile()
    {
        super(2, "autofeederarea");
    }

    public void func_145829_t()
    {
        super.func_145829_t();

        this.timer = this.field_145850_b.field_73012_v.nextInt(40);
    }

    public int getRange()
    {
        ItemStack extenders = this.inv.contents[1];
                return 8 + ((extenders != null) && (extenders.getItem() == Items.field_151153_ao) && (extenders.getItemDamage() == 0) ? extenders.stackSize / 4 : 0);
    }

    public void func_145845_h()
    {
        super.func_145845_h();
        if (this.field_145850_b.field_72995_K) {
            return;
        }
        if (--this.timer <= 0)
        {
            ItemStack foodStack = this.inv.contents[0];
            if ((foodStack == null) || (!(foodStack.getItem() instanceof ItemFood)))
            {
                this.timer = 5;
                return;
            }
            ItemFood item = (ItemFood)foodStack.getItem();

            this.timer = 40;

            double range = getRange() + 0.5D;
            double x = this.field_145851_c + 0.5D;
            double y = this.field_145848_d + 0.5D;
            double z = this.field_145849_e + 0.5D;

            List<EntityPlayer> players = this.field_145850_b.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(x - range, y - range, z - range, x + range, y + range, z + range));
            for (EntityPlayer p : players) {
                if (p.getFoodStats().needFood())
                {
                    p.getFoodStats().func_151686_a(item, foodStack);
                    this.timer = 5;
                    if (--foodStack.stackSize <= 0) {
                        break;
                    }
                }
            }
            if (foodStack.field_77994_a <= 0) {
                this.inv.contents[0] = null;
            }
        }
    }

    public boolean canExtractItem(int i, ItemStack itemstack, int j)
    {
        return true;
    }

    public boolean canInsertItem(int i, ItemStack itemstack, int j)
    {
        return true;
    }

    private static int[] accSlots = new int[1];

    public int[] canInsertItem(int var1)
    {
        return accSlots;
    }

    public boolean onBlockActivated(EntityPlayer player)
    {
        if (!this.field_145850_b.isRemote) {
            player.openGui(AutoFood.INSTANCE, AutoFood.GUI_AUTOFEEDER, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
        }
        return true;
    }
}
