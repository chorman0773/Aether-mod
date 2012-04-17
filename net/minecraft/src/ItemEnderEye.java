// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, World, EntityPlayer, Block, 
//            BlockEndPortalFrame, ItemStack, Direction, MovingObjectPosition, 
//            EnumMovingObjectType, EntityEnderEye, ChunkPosition, PlayerCapabilities

public class ItemEnderEye extends Item
{

    public ItemEnderEye(int i)
    {
        super(i);
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockId(i, j, k);
        int j1 = world.getBlockMetadata(i, j, k);
        if(entityplayer.canPlayerEdit(i, j, k) && i1 == Block.endPortalFrame.blockID && !BlockEndPortalFrame.func_40212_d(j1))
        {
            if(world.multiplayerWorld)
            {
                return true;
            }
            world.setBlockMetadataWithNotify(i, j, k, j1 + 4);
            itemstack.stackSize--;
            for(int k1 = 0; k1 < 16; k1++)
            {
                double d = (float)i + (5F + itemRand.nextFloat() * 6F) / 16F;
                double d1 = (float)j + 0.8125F;
                double d2 = (float)k + (5F + itemRand.nextFloat() * 6F) / 16F;
                double d3 = 0.0D;
                double d4 = 0.0D;
                double d5 = 0.0D;
                world.spawnParticle("smoke", d, d1, d2, d3, d4, d5);
            }

            int l1 = j1 & 3;
            int i2 = 0;
            int j2 = 0;
            boolean flag = false;
            boolean flag1 = true;
            int k2 = Direction.field_35867_f[l1];
            for(int l2 = -2; l2 <= 2; l2++)
            {
                int j3 = i + Direction.field_35871_a[k2] * l2;
                int j4 = k + Direction.field_35870_b[k2] * l2;
                int j5 = world.getBlockId(j3, j, j4);
                if(j5 != Block.endPortalFrame.blockID)
                {
                    continue;
                }
                int j6 = world.getBlockMetadata(j3, j, j4);
                if(!BlockEndPortalFrame.func_40212_d(j6))
                {
                    flag1 = false;
                    break;
                }
                if(!flag)
                {
                    i2 = l2;
                    j2 = l2;
                    flag = true;
                } else
                {
                    j2 = l2;
                }
            }

            if(flag1 && j2 == i2 + 2)
            {
                int i3 = i2;
                do
                {
                    if(i3 > j2)
                    {
                        break;
                    }
                    int k3 = i + Direction.field_35871_a[k2] * i3;
                    int k4 = k + Direction.field_35870_b[k2] * i3;
                    k3 += Direction.field_35871_a[l1] * 4;
                    k4 += Direction.field_35870_b[l1] * 4;
                    int k5 = world.getBlockId(k3, j, k4);
                    int k6 = world.getBlockMetadata(k3, j, k4);
                    if(k5 != Block.endPortalFrame.blockID || !BlockEndPortalFrame.func_40212_d(k6))
                    {
                        flag1 = false;
                        break;
                    }
                    i3++;
                } while(true);
label0:
                for(int l3 = i2 - 1; l3 <= j2 + 1; l3 += 4)
                {
                    int l4 = 1;
                    do
                    {
                        if(l4 > 3)
                        {
                            continue label0;
                        }
                        int l5 = i + Direction.field_35871_a[k2] * l3;
                        int l6 = k + Direction.field_35870_b[k2] * l3;
                        l5 += Direction.field_35871_a[l1] * l4;
                        l6 += Direction.field_35870_b[l1] * l4;
                        int j7 = world.getBlockId(l5, j, l6);
                        int k7 = world.getBlockMetadata(l5, j, l6);
                        if(j7 != Block.endPortalFrame.blockID || !BlockEndPortalFrame.func_40212_d(k7))
                        {
                            flag1 = false;
                            continue label0;
                        }
                        l4++;
                    } while(true);
                }

                if(flag1)
                {
                    for(int i4 = i2; i4 <= j2; i4++)
                    {
                        for(int i5 = 1; i5 <= 3; i5++)
                        {
                            int i6 = i + Direction.field_35871_a[k2] * i4;
                            int i7 = k + Direction.field_35870_b[k2] * i4;
                            i6 += Direction.field_35871_a[l1] * i5;
                            i7 += Direction.field_35870_b[l1] * i5;
                            world.setBlockWithNotify(i6, j, i7, Block.endPortal.blockID);
                        }

                    }

                }
            }
            return true;
        } else
        {
            return false;
        }
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        MovingObjectPosition movingobjectposition = func_40402_a(world, entityplayer, false);
        if(movingobjectposition != null && movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
        {
            int i = world.getBlockId(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ);
            if(i == Block.endPortalFrame.blockID)
            {
                return itemstack;
            }
        }
        if(!world.multiplayerWorld)
        {
            ChunkPosition chunkposition = world.func_40477_b("Stronghold", (int)entityplayer.posX, (int)entityplayer.posY, (int)entityplayer.posZ);
            if(chunkposition != null)
            {
                EntityEnderEye entityendereye = new EntityEnderEye(world, entityplayer.posX, (entityplayer.posY + 1.6200000000000001D) - (double)entityplayer.yOffset, entityplayer.posZ);
                entityendereye.func_40090_a(chunkposition.x, chunkposition.y, chunkposition.z);
                world.spawnEntityInWorld(entityendereye);
                world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                world.playAuxSFXAtEntity(null, 1002, (int)entityplayer.posX, (int)entityplayer.posY, (int)entityplayer.posZ, 0);
                if(!entityplayer.capabilities.depleteBuckets)
                {
                    itemstack.stackSize--;
                }
            }
        }
        return itemstack;
    }
}
