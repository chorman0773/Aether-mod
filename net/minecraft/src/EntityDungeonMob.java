// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityCreature, IMob, World, EntityPlayer, 
//            DamageSource, Entity, AxisAlignedBB, MathHelper, 
//            EnumSkyBlock, NBTTagCompound

public class EntityDungeonMob extends EntityCreature
    implements IMob
{

    protected int attackStrength;

    public EntityDungeonMob(World world)
    {
        super(world);
        attackStrength = 2;
    }

    public int getMaxHealth()
    {
        return 20;
    }

    public void onLivingUpdate()
    {
        float f = getEntityBrightness(1.0F);
        if(f > 0.5F)
        {
            entityAge += 2;
        }
        super.onLivingUpdate();
    }

    protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 16D);
        if(entityplayer != null && canEntityBeSeen(entityplayer))
        {
            return entityplayer;
        } else
        {
            return null;
        }
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        if(!super.attackEntityFrom(damagesource, i))
        {
            return false;
        }
        Entity entity = damagesource.getEntity();
        if(entity != null)
        {
            if(riddenByEntity == entity || ridingEntity == entity)
            {
                return true;
            }
            if(entity != this)
            {
                entityToAttack = entity;
            }
        }
        return true;
    }

    protected void attackEntity(Entity entity, float f)
    {
        if(attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
            entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackStrength);
        }
    }

    protected float getBlockPathWeight(int i, int j, int k)
    {
        return 0.5F - worldObj.getLightBrightness(i, j, k);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        if(worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > rand.nextInt(32))
        {
            return false;
        }
        int l = worldObj.getBlockLightValue(i, j, k);
        if(worldObj.getIsThundering())
        {
            int i1 = worldObj.skylightSubtracted;
            worldObj.skylightSubtracted = 10;
            l = worldObj.getBlockLightValue(i, j, k);
            worldObj.skylightSubtracted = i1;
        }
        return l <= rand.nextInt(8) && super.getCanSpawnHere();
    }
}