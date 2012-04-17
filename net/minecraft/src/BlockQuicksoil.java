// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            Block, Material, StatList, EntityPlayer, 
//            mod_Aether, World

public class BlockQuicksoil extends Block
    implements ITextureProvider
{

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    public BlockQuicksoil(int i)
    {
        super(i, 37, Material.sand);
        slipperiness = 1.1F;
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
}
