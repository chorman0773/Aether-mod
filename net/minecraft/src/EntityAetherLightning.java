// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityLightningBolt, World, MathHelper, Block, 
//            BlockFire, AxisAlignedBB, Entity, EntityPlayer

public class EntityAetherLightning extends EntityLightningBolt
{

    private int lightningState;
    public long boltVertex;
    private int boltLivingTime;

    public EntityAetherLightning(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
        boltVertex = 0L;
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(lightningState == 2)
        {
            worldObj.playSoundEffect(posX, posY, posZ, "ambient.weather.thunder", 10000F, 0.8F + rand.nextFloat() * 0.2F);
            worldObj.playSoundEffect(posX, posY, posZ, "random.explode", 2.0F, 0.5F + rand.nextFloat() * 0.2F);
        }
        lightningState--;
        if(lightningState < 0)
        {
            if(boltLivingTime == 0)
            {
                setEntityDead();
            } else
            if(lightningState < -rand.nextInt(10))
            {
                boltLivingTime--;
                lightningState = 1;
                boltVertex = rand.nextLong();
                if(worldObj.doChunksNearChunkExist(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ), 10))
                {
                    int i = MathHelper.floor_double(posX);
                    int j = MathHelper.floor_double(posY);
                    int k = MathHelper.floor_double(posZ);
                    if(worldObj.getBlockId(i, j, k) == 0 && Block.fire.canPlaceBlockAt(worldObj, i, j, k))
                    {
                        worldObj.setBlockWithNotify(i, j, k, Block.fire.blockID);
                    }
                }
            }
        }
        if(lightningState >= 0)
        {
            double d = 3D;
            List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getBoundingBoxFromPool(posX - d, posY - d, posZ - d, posX + d, posY + 6D + d, posZ + d));
            for(int l = 0; l < list.size(); l++)
            {
                Entity entity = (Entity)list.get(l);
                if(!(entity instanceof EntityPlayer))
                {
                    entity.onStruckByLightning(this);
                }
            }

            worldObj.lightningFlash = 2;
        }
    }
}
