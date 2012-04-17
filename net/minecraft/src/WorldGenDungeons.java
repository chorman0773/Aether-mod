// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.MinecraftForge;
import java.io.PrintStream;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, SAPI, World, Material, 
//            Block, TileEntityChest, TileEntityMobSpawner, DungeonLoot, 
//            ItemStack

public class WorldGenDungeons extends WorldGenerator
{

    public WorldGenDungeons()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        byte byte0 = 3;
        int l = random.nextInt(2) + 2;
        int i1 = random.nextInt(2) + 2;
        int j1 = 0;
        for(int k1 = i - l - 1; k1 <= i + l + 1; k1++)
        {
            for(int j2 = j - 1; j2 <= j + byte0 + 1; j2++)
            {
                for(int i3 = k - i1 - 1; i3 <= k + i1 + 1; i3++)
                {
                    Material material = world.getBlockMaterial(k1, j2, i3);
                    if(j2 == j - 1 && !material.isSolid())
                    {
                        return false;
                    }
                    if(j2 == j + byte0 + 1 && !material.isSolid())
                    {
                        return false;
                    }
                    if((k1 == i - l - 1 || k1 == i + l + 1 || i3 == k - i1 - 1 || i3 == k + i1 + 1) && j2 == j && world.isAirBlock(k1, j2, i3) && world.isAirBlock(k1, j2 + 1, i3))
                    {
                        j1++;
                    }
                }

            }

        }

        if(j1 < 1 || j1 > 5)
        {
            return false;
        }
        for(int l1 = i - l - 1; l1 <= i + l + 1; l1++)
        {
            for(int k2 = j + byte0; k2 >= j - 1; k2--)
            {
                for(int j3 = k - i1 - 1; j3 <= k + i1 + 1; j3++)
                {
                    if(l1 == i - l - 1 || k2 == j - 1 || j3 == k - i1 - 1 || l1 == i + l + 1 || k2 == j + byte0 + 1 || j3 == k + i1 + 1)
                    {
                        if(k2 >= 0 && !world.getBlockMaterial(l1, k2 - 1, j3).isSolid())
                        {
                            world.setBlockWithNotify(l1, k2, j3, 0);
                            continue;
                        }
                        if(!world.getBlockMaterial(l1, k2, j3).isSolid())
                        {
                            continue;
                        }
                        if(k2 == j - 1 && random.nextInt(4) != 0)
                        {
                            world.setBlockWithNotify(l1, k2, j3, Block.cobblestoneMossy.blockID);
                        } else
                        {
                            world.setBlockWithNotify(l1, k2, j3, Block.cobblestone.blockID);
                        }
                    } else
                    {
                        world.setBlockWithNotify(l1, k2, j3, 0);
                    }
                }

            }

        }

        for(int i2 = 0; i2 < 2; i2++)
        {
label0:
            for(int l2 = 0; l2 < 3; l2++)
            {
                int k3 = (i + random.nextInt(l * 2 + 1)) - l;
                int l3 = j;
                int i4 = (k + random.nextInt(i1 * 2 + 1)) - i1;
                if(!world.isAirBlock(k3, l3, i4))
                {
                    continue;
                }
                int j4 = 0;
                if(world.getBlockMaterial(k3 - 1, l3, i4).isSolid())
                {
                    j4++;
                }
                if(world.getBlockMaterial(k3 + 1, l3, i4).isSolid())
                {
                    j4++;
                }
                if(world.getBlockMaterial(k3, l3, i4 - 1).isSolid())
                {
                    j4++;
                }
                if(world.getBlockMaterial(k3, l3, i4 + 1).isSolid())
                {
                    j4++;
                }
                if(j4 != 1)
                {
                    continue;
                }
                world.setBlockWithNotify(k3, l3, i4, Block.chest.blockID);
                TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(k3, l3, i4);
                if(tileentitychest == null)
                {
                    break;
                }
                int k4 = 0;
                do
                {
                    if(k4 >= 8)
                    {
                        break label0;
                    }
                    ItemStack itemstack = pickCheckLootItem(random);
                    if(itemstack != null)
                    {
                        tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), itemstack);
                    }
                    k4++;
                } while(true);
            }

        }

        world.setBlockWithNotify(i, j, k, Block.mobSpawner.blockID);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getBlockTileEntity(i, j, k);
        if(tileentitymobspawner != null)
        {
            tileentitymobspawner.setMobID(MinecraftForge.getRandomDungeonMob(random));
        } else
        {
            System.err.println((new StringBuilder("Failed to fetch mob spawner entity at (")).append(i).append(", ").append(j).append(", ").append(k).append(")").toString());
        }
        return true;
    }

    private ItemStack pickCheckLootItem(Random random)
    {
        return SAPI.Dungeon.lootGet(random).getStack();
    }

    private String pickMobSpawner(Random random)
    {
        return SAPI.Dungeon.mobGet(random);
    }
}
