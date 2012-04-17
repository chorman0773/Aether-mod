// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class AetherBlock extends Block
    implements ITextureProvider
{

    protected AetherBlock(int i, int j, Material material)
    {
        super(i, j, material);
    }

    protected AetherBlock(int i, Material material)
    {
        super(i, material);
    }

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }
}
