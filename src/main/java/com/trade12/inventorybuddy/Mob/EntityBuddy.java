package com.trade12.inventorybuddy.Mob;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class EntityBuddy extends EntityCreature {

    @SideOnly(Side.CLIENT)
    private ThreadDownloadImageData downloadImageSkin;

    @SideOnly(Side.CLIENT)
    private ResourceLocation locationSkin;

    private String owner = "[nobody]";
    private String previousSkin;

    private int pickupCooldown = 0;

    private boolean wasRidden = false;

    public EntityBuddy(World world, String owner) {
        this(world);
        this.owner = owner;
    }

    public EntityBuddy(World world) {
        super(world);
        setSize(0.6F, 0.95F);
        func_110163_bv();
        getNavigator().setAvoidsWater(true);
        getNavigator().setCanSwim(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(5, new AIPickupPlayer(this));
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if (pickupCooldown > 0) pickupCooldown--;
        if (wasRidden && riddenByEntity == null) {
            wasRidden = false;
            setPickupCooldown(1200);
        } else if (riddenByEntity != null) {
            wasRidden = true;
        }
    }

    @Override
    public double getMountedYOffset() {
        return height + 0.15;
    }

    public int getPickupCooldown() {
        return pickupCooldown;
    }

    public void setPickupCooldown(int cooldown) {
        pickupCooldown = cooldown;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getLocationSkin() {
        String newSkin = getPlayerSkin();
        if (newSkin != previousSkin) {
            locationSkin = null;
            downloadImageSkin = null;
        }
        if (locationSkin == null) {
            locationSkin = AbstractClientPlayer.getLocationSkin(newSkin);
            downloadImageSkin = AbstractClientPlayer.getDownloadImageSkin(locationSkin, newSkin);
        }
        previousSkin = newSkin;
        return locationSkin;
    }

    public String getPlayerSkin() {
        return hasCustomNameTag()? getCustomNameTag() : owner;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public boolean isChild() {
        return true;
    }

    public String getUsername() {
        return owner;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setString("owner", owner);
        tag.setInteger("pickupCooldown", pickupCooldown);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        if (tag.hasKey("owner")) owner = tag.getString("owner");
        if (tag.hasKey("pickupCooldown")) pickupCooldown = tag.getInteger("pickupCooldown");
    }

}
