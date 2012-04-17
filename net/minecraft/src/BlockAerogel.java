// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess

public class BlockAerogel extends Block
    implements ITextureProvider
{

    public BlockAerogel(int i)
    {
        super(i, 1, Material.rock);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }
}
