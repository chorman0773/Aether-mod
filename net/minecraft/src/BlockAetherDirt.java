// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, StatList, 
//            EntityPlayer, mod_Aether, ItemStack, AetherItems, 
//            Item

public class BlockAetherDirt extends Block
    implements ITextureProvider
{

    protected BlockAetherDirt(int i)
    {
        super(i, 6, Material.ground);
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        world.setBlockWithNotify(i, j, k, blockID);
        world.setBlockMetadataWithNotify(i, j, k, 1);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(l == 0 && mod_Aether.equippedSkyrootShovel())
        {
            dropBlockAsItem(world, i, j, k, l, 0);
        }
        dropBlockAsItem(world, i, j, k, l, 0);
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
        if(itemstack.itemID == AetherItems.SwetBall.shiftedIndex)
        {
            itemstack.stackSize--;
            int l = 0;
label0:
            for(int i1 = 0; i1 < 64; i1++)
            {
                int j1 = i;
                int k1 = j;
                int l1 = k;
                for(int i2 = 0; i2 < i1 / 16; i2++)
                {
                    j1 += world.rand.nextInt(3) - 1;
                    k1 += ((world.rand.nextInt(3) - 1) * world.rand.nextInt(3)) / 2;
                    l1 += world.rand.nextInt(3) - 1;
                    if(world.getBlockId(j1, k1, l1) != blockID || world.isBlockNormalCube(j1, k1, l1))
                    {
                        continue label0;
                    }
                }

                if(world.getBlockId(j1, k1, l1) == blockID && world.rand.nextInt(10 + 2 * l) <= 2)
                {
                    world.setBlockWithNotify(j1, k1, l1, mod_Aether.idBlockAetherGrass);
                    l++;
                }
            }

        }
        return false;
    }

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }
}
