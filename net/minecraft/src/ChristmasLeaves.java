// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            AetherBlock, Material, EntityChristmasSnowFX, ModLoader, 
//            EffectRenderer, World, Loc, AetherBlocks, 
//            Block, IBlockAccess

public class ChristmasLeaves extends AetherBlock
{

    public ChristmasLeaves(int i)
    {
        super(i, 45, Material.leaves);
        setTickOnLoad(true);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return j != 0 ? 46 : 45;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int idDropped(int i, Random random, int j)
    {
        return 0;
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        for(int l = 0; l < 4; l++)
        {
            double d = (double)(float)i + ((double)random.nextFloat() - 0.5D) * 10D;
            double d1 = (double)(float)j + ((double)random.nextFloat() - 0.5D) * 10D;
            double d2 = (double)(float)k + ((double)random.nextFloat() - 0.5D) * 10D;
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            d3 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            EntityChristmasSnowFX entitychristmassnowfx = new EntityChristmasSnowFX(world, d, d1, d2, d3, d4, d5);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(entitychristmassnowfx);
        }

    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(!nearTrunk(world, i, j, k))
        {
            removeLeaves(world, i, j, k);
        }
    }

    private void removeLeaves(World world, int i, int j, int k)
    {
        world.setBlockWithNotify(i, j, k, 0);
    }

    private boolean nearTrunk(World world, int i, int j, int k)
    {
        Loc loc = new Loc(i, j, k);
        LinkedList linkedlist = new LinkedList();
        ArrayList arraylist = new ArrayList();
        linkedlist.offer(new Loc(i, j, k));
        int l = blockID;
        do
        {
            if(linkedlist.isEmpty())
            {
                break;
            }
            Loc loc1 = (Loc)linkedlist.poll();
            if(!arraylist.contains(loc1))
            {
                if(loc1.distSimple(loc) <= 4)
                {
                    int i1 = loc1.getBlock(world);
                    int j1 = loc1.getMeta(world);
                    if(i1 == AetherBlocks.Log.blockID)
                    {
                        return true;
                    }
                    if(i1 == l)
                    {
                        linkedlist.addAll(Arrays.asList(loc1.adjacent()));
                    }
                }
                arraylist.add(loc1);
            }
        } while(true);
        return false;
    }

    private boolean isMyTrunkMeta(int i)
    {
        if(blockID == AetherBlocks.ChristmasLeaves.blockID)
        {
            return i <= 1;
        } else
        {
            return i >= 2;
        }
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        return true;
    }
}
