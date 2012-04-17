// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.io.PrintStream;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockAetherFlower, World, AetherBlocks, Block, 
//            AxisAlignedBB, EntityPlayer, ItemStack, Item

public class BlockBushStem extends BlockAetherFlower
    implements ITextureProvider
{

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    protected BlockBushStem(int i)
    {
        super(i, 49);
        setRequiresSelfNotify();
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        checkFlowerChange(world, i, j, k);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        System.out.println("tick");
        if(world.multiplayerWorld)
        {
            return;
        }
        super.updateTick(world, i, j, k, random);
        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(30) == 0)
        {
            world.setBlock(i, j, k, AetherBlocks.BerryBush.blockID);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return AxisAlignedBB.getBoundingBoxFromPool((double)i + minX, (double)j + minY, (double)k + minZ, (double)i + maxX, (double)j + maxY, (double)k + maxZ);
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return false;
        }
        if(entityplayer == null)
        {
            return false;
        }
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
        if(itemstack == null)
        {
            return false;
        }
        if(itemstack.itemID != Item.dyePowder.shiftedIndex)
        {
            return false;
        }
        if(itemstack.getItemDamage() != 15)
        {
            return false;
        } else
        {
            itemstack.stackSize--;
            world.setBlockWithNotify(i, j, k, 0);
            world.setBlockWithNotify(i, j, k, AetherBlocks.BerryBush.blockID);
            return true;
        }
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == AetherBlocks.Grass.blockID || i == AetherBlocks.Dirt.blockID;
    }
}
