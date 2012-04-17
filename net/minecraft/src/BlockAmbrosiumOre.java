// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, AetherItems, Item, 
//            World, StatList, EntityPlayer, mod_Aether

public class BlockAmbrosiumOre extends Block
    implements ITextureProvider
{

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    public BlockAmbrosiumOre(int i)
    {
        super(i, 2, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return AetherItems.AmbrosiumShard.shiftedIndex;
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        world.setBlockWithNotify(i, j, k, blockID);
        world.setBlockMetadataWithNotify(i, j, k, 1);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(l == 0 && mod_Aether.equippedSkyrootPick())
        {
            dropBlockAsItem(world, i, j, k, l, 0);
        }
        dropBlockAsItem(world, i, j, k, l, 0);
    }
}
