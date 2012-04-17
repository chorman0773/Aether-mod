// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockAetherFlower, AxisAlignedBB, AetherBlocks, Block, 
//            World, mod_Aether, StatList, EntityPlayer, 
//            ItemStack, AetherItems, Item, EntityItem

public class BlockBerryBush extends BlockAetherFlower
{

    protected BlockBerryBush(int i)
    {
        super(i, 50);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return AxisAlignedBB.getBoundingBoxFromPool((double)i + minX, (double)j + minY, (double)k + minZ, (double)i + maxX, (double)j + maxY, (double)k + maxZ);
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        world.setBlockWithNotify(i, j, k, AetherBlocks.BushStem.blockID);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        Random random = new Random();
        int i1;
        int j1;
        if(world.getBlockId(i, j - 1, k) == mod_Aether.idBlockAetherGrass && world.getBlockMetadata(i, j - 1, k) == 1)
        {
            i1 = 1;
            j1 = 3;
        } else
        {
            i1 = 0;
            j1 = 2;
        }
        long l1 = ((long)j1 - (long)i1) + 1L;
        long l2 = (long)((double)l1 * random.nextDouble());
        int k1 = (int)(l2 + (long)i1);
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        ItemStack itemstack = new ItemStack(AetherItems.BlueBerry.shiftedIndex, k1, 0);
        EntityItem entityitem = new EntityItem(world, i, j, k, itemstack);
        entityitem.delayBeforeCanPickup = 10;
        world.spawnEntityInWorld(entityitem);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return mod_Aether.renderID;
    }
}
