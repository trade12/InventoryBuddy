package com.trade12.inventorybuddy.Mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import com.trade12.inventorybuddy.Mob.ModelBuddy;
import com.trade12.inventorybuddy.Mob.EntityBuddy;


public class RendererBuddy extends RenderLiving {

    public RendererBuddy() {
        super(new ModelBuddy(0.0F), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return ((EntityBuddy)entity).getLocationSkin();
    }

    @Override
    protected void renderLivingLabel(EntityLivingBase par1EntityLivingBase, String par2Str, double par3, double par5, double par7, int par9) {
        super.renderLivingLabel(par1EntityLivingBase, par2Str, par3, par5, par7, par9);
        }
        }
