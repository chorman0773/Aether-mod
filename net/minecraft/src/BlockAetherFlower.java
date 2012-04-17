// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, AetherBlocks, Block

public class BlockAetherFlower extends BlockFlower
    implements ITextureProvider
{

    protected BlockAetherFlower(int i, int j)
    {
        super(i, j);
        blockIndexInTexture = j;
        setTickOnLoad(true);
        float f = 0.2F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3F, 0.5F + f);
    }

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == AetherBlocks.Grass.blockID || i == AetherBlocks.Dirt.blockID;
    }
}
