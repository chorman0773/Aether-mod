// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            AetherItem, EntityMiniCloud, World, ItemStack, 
//            EntityPlayer, AxisAlignedBB, Entity

public class ItemCloudStaff extends AetherItem
{

    public ItemCloudStaff(int i)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(60);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(!cloudsExist(world, entityplayer))
        {
            EntityMiniCloud entityminicloud = new EntityMiniCloud(world, entityplayer, false);
            EntityMiniCloud entityminicloud1 = new EntityMiniCloud(world, entityplayer, true);
            world.spawnEntityInWorld(entityminicloud);
            world.spawnEntityInWorld(entityminicloud1);
            itemstack.damageItem(1, entityplayer);
        }
        return itemstack;
    }

    private boolean cloudsExist(World world, EntityPlayer entityplayer)
    {
        List list = world.getEntitiesWithinAABBExcludingEntity(entityplayer, entityplayer.boundingBox.expand(128D, 128D, 128D));
        for(int i = 0; i < list.size(); i++)
        {
            Entity entity = (Entity)list.get(i);
            if(entity instanceof EntityMiniCloud)
            {
                return true;
            }
        }

        return false;
    }
}
