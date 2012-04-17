// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            AetherBlock, Material, StatList, EntityPlayer, 
//            ItemStack, AetherItems, Item, EntityItem, 
//            World, EntityBlueFX, ModLoader, EffectRenderer, 
//            Loc, AetherBlocks, Block, IBlockAccess

public class BlockBlueLeaves extends AetherBlock
{

    public BlockBlueLeaves(int i)
    {
        super(i, 45, Material.leaves);
        setTickOnLoad(true);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return j != 0 ? 56 : 54;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(l >= 1)
        {
            ItemStack itemstack = new ItemStack(AetherItems.WhiteBerry.shiftedIndex, 1, 0);
            EntityItem entityitem = new EntityItem(world, i, j, k, itemstack);
            entityitem.delayBeforeCanPickup = 10;
            world.spawnEntityInWorld(entityitem);
        }
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        super.randomDisplayTick(world, i, j, k, random);
        if(random.nextInt(10) == 0)
        {
            for(int l = 0; l < 8; l++)
            {
                EntityBlueFX entitybluefx = new EntityBlueFX(world, (float)i + random.nextFloat(), (float)j + 1.1F, (float)k + random.nextFloat(), 0.0D, 0.0D, 0.0D);
                ModLoader.getMinecraftInstance().effectRenderer.addEffect(entitybluefx);
            }

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
