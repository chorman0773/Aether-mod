// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityProjectileBase, EntityLiving, AetherPoison, EntityPlayerSP, 
//            AxisAlignedBB, World, Entity, DamageSource, 
//            EntityBreakingFX, Item, EntityFX, EffectRenderer

public class EntityPoisonNeedle extends EntityProjectileBase
{

    public EntityLiving victim;
    public int poisonTime;

    public EntityPoisonNeedle(World world)
    {
        super(world);
    }

    public EntityPoisonNeedle(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    public EntityPoisonNeedle(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public void entityInit()
    {
        super.entityInit();
        dmg = 0;
        speed = 1.5F;
    }

    public boolean handleWaterMovement()
    {
        return victim == null && super.handleWaterMovement();
    }

    public boolean onHitTarget(Entity entity)
    {
        if(!(entity instanceof EntityLiving) || !AetherPoison.canPoison(entity))
        {
            return super.onHitTarget(entity);
        }
        EntityLiving entityliving = (EntityLiving)entity;
        if(entityliving instanceof EntityPlayerSP)
        {
            AetherPoison.afflictPoison();
            return super.onHitTarget(entity);
        }
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, entityliving.boundingBox.expand(2D, 2D, 2D));
        for(int i = 0; i < list.size(); i++)
        {
            Entity entity1 = (Entity)list.get(i);
            if(!(entity1 instanceof EntityPoisonNeedle))
            {
                continue;
            }
            EntityPoisonNeedle entitypoisonneedle = (EntityPoisonNeedle)entity1;
            if(entitypoisonneedle.victim == entityliving)
            {
                entitypoisonneedle.poisonTime = 500;
                entitypoisonneedle.isDead = false;
                setEntityDead();
                return false;
            }
        }

        victim = entityliving;
        entityliving.attackEntityFrom(DamageSource.causeMobDamage(shooter), dmg);
        poisonTime = 500;
        return false;
    }

    public void setEntityDead()
    {
        victim = null;
        super.setEntityDead();
    }

    public boolean onHitBlock()
    {
        return victim == null;
    }

    public boolean canBeShot(Entity entity)
    {
        return super.canBeShot(entity) && victim == null;
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(isDead)
        {
            return;
        }
        if(victim != null)
        {
            if(victim.isDead || poisonTime == 0)
            {
                setEntityDead();
                return;
            }
            EntityBreakingFX entitybreakingfx = new EntityBreakingFX(worldObj, posX, posY, posZ, Item.slimeBall);
            entitybreakingfx.renderDistanceWeight = 10D;
            entitybreakingfx.func_40099_c(94);
            AetherPoison.mc.effectRenderer.addEffect(entitybreakingfx);
            isDead = false;
            inGround = false;
            posX = victim.posX;
            posY = victim.boundingBox.minY + (double)victim.height * 0.80000000000000004D;
            posZ = victim.posZ;
            AetherPoison.distractEntity(victim);
            poisonTime--;
        }
    }
}
