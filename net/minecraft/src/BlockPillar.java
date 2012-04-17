// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockPillar extends Block
    implements ITextureProvider
{

    public static int sprTop = 33;
    public static int sprSide = 32;
    public static int sprTopSide = 31;

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    protected BlockPillar(int i)
    {
        super(i, Material.rock);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 0 || i == 1)
        {
            return sprTop;
        }
        if(j == 0)
        {
            return sprSide;
        } else
        {
            return sprTopSide;
        }
    }

    protected int damageDropped(int i)
    {
        return i;
    }

}
